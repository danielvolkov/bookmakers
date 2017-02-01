package controller.commands.user;

import controller.commands.Command;
import controller.parser.RideParser;
import model.entity.Ride;
import model.entity.User;
import services.RideService;
import services.impl.RideServiceImpl;
import util.constants.Attributes;
import util.constants.Pages;
import util.validators.RideValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author  Daniil Volkov
 */
public class AddRideCommand implements Command {
    RideService rideService = RideServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User bookmaker = (User) request.getSession().getAttribute(Attributes.USER);

        Ride ride;
        try {
            ride =  new RideParser(bookmaker,request).getEntity();
            RideValidator rideValidator = new RideValidator();
            if (rideValidator.isValid(ride)) {
                rideService.create(ride);
                List<Ride> rides = rideService.findRides();
                request.getSession().setAttribute(Attributes.RIDES, rides);
            } else {
                request.getSession().setAttribute(Attributes.ERROR, Attributes.VALIDATION_MSG);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute(Attributes.ERROR, Attributes.DATABASE_ERROR);
        }
        return Pages.RIDES;

    }
}

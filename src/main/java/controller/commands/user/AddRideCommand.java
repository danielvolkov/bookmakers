package controller.commands.user;

import controller.commands.Command;
import controller.parser.RideParser;
import model.entity.Ride;
import model.entity.User;
import services.RideService;
import services.impl.RideServiceImpl;
import util.Attributes;
import util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by daniel on 1/23/17.
 */
public class AddRideCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User bookmaker = (User) request.getSession().getAttribute(Attributes.User);
        if (bookmaker != null){
            Ride ride =  new RideParser(bookmaker,request).getEntity();
            RideService rideService = RideServiceImpl.getInstance();
            try {
                rideService.create(ride);
                List<Ride> rides = rideService.findRides();
                request.getSession().setAttribute(Attributes.RIDES,rides);

            } catch (Exception e) {
                e.printStackTrace();
                request.getSession().setAttribute(Attributes.RIDES_ERROR, Attributes.RIDES_MSG);
            }
            return Pages.RIDES;
        }

        return Pages.LOGIN;
    }
}

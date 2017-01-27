package controller.commands.user;

import controller.commands.Command;
import model.entity.Ride;
import model.entity.User;
import services.RideService;
import services.impl.RideServiceImpl;
import util.constants.Attributes;
import util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by daniel on 1/22/17.
 */
public class OpenRidesCommand implements Command {
    RideService rideService = RideServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        if (user != null){
            //Ride ride =  new RideParser(user).getEntity();

            try {
                List<Ride> rides = rideService.findRides();
                request.getSession().setAttribute(Attributes.RIDES,rides);

            } catch (Exception e) {
                e.printStackTrace();
                request.getSession().setAttribute(Attributes.RIDES_ERROR, Attributes.DATABASE_ERROR);
            }
            return Pages.RIDES;
        }

        return Pages.LOGIN;

    }
}

package controller.commands.user;

import controller.commands.Command;
import controller.parser.Parser;
import controller.parser.RideParser;
import model.entity.Ride;
import model.entity.User;
import services.RideService;
import services.impl.RideServiceImpl;
import util.Attributes;
import util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by daniel on 1/22/17.
 */
public class OpenRidesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Attributes.User);
        if (user != null){
            Ride ride =  new RideParser(user).getEntity();
            RideService rideService = RideServiceImpl.getInstance();
            try {
                rideService.create(ride);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return Pages.RIDES;
        }

        return Pages.LOGIN;

    }
}

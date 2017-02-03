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
import java.io.IOException;
import java.util.List;

/**
 * Created by daniel on 1/26/17.
 */
public class ConfirmRideResultsCommand implements Command {
    RideService rideService = RideServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute(Attributes.USER);

        Integer rideId = Integer.parseInt(request.getParameter(Attributes.RIDE));
        try {
            rideService.updateWithConfirm(rideId);
            List<Ride> rides = rideService.findRides();
            request.getSession().setAttribute(Attributes.RIDES, rides);

        } catch (Exception e) {
            request.getSession().setAttribute(Attributes.ERROR, Attributes.RIDES_ERROR);
        }

        return Pages.RIDES;

    }
}

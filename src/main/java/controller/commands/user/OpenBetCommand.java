package controller.commands.user;

import controller.commands.Command;
import model.entity.Horse;
import model.entity.Ride;
import model.entity.User;
import services.HorseService;
import services.RideService;
import services.impl.HorseServiceImpl;
import services.impl.RideServiceImpl;
import util.constants.Attributes;
import util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by daniel on 1/24/17.
 */
public class OpenBetCommand implements Command{
    HorseService horseService = HorseServiceImpl.getInstance();
    RideService rideService = RideServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User client = (User)request.getSession().getAttribute(Attributes.USER);

        if (client.getRole().equals(Attributes.CLIENT)){
            Integer rideId = Integer.parseInt(request.getParameter(Attributes.RIDE));
            try {
                Ride ride = rideService.findRide(rideId);
                List<Horse> horses = horseService.getHorses();
                request.getSession().setAttribute(Attributes.HORSES,horses);
                request.getSession().setAttribute(Attributes.RIDE,ride);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute(Attributes.ERROR, Attributes.DATABASE_ERROR);
            }
            return Pages.BET;
        }

        return Pages.PAGE_NOT_FOUND;


    }
}

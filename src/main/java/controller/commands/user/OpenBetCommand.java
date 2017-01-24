package controller.commands.user;

import controller.commands.Command;
import model.entity.Horse;
import model.entity.User;
import services.HorseService;
import services.impl.HorseServiceImpl;
import util.Attributes;
import util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by daniel on 1/24/17.
 */
public class OpenBetCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User client = (User)request.getSession().getAttribute(Attributes.USER);

        if (client.getRole().equals(Attributes.CLIENT)){
            request.getSession().setAttribute(Attributes.RIDE, request.getParameter(Attributes.RIDE));
            HorseService horseService = HorseServiceImpl.getInstance();

            try {
                List<Horse> horses = horseService.getHorses();
                request.getSession().setAttribute(Attributes.HORSES,horses);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute(Attributes.ERROR, Attributes.DATABASE_ERROR);
            }
            return Pages.BET;
        }

        return Pages.PAGE_NOT_FOUND;


    }
}

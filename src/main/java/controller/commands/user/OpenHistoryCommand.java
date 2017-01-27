package controller.commands.user;

import controller.commands.Command;
import model.entity.Bet;
import model.entity.User;
import services.BetService;
import services.impl.BetServiceImpl;
import util.constants.Attributes;
import util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by daniel on 1/22/17.
 */
public class OpenHistoryCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        User user = (User) request.getSession().getAttribute(Attributes.USER);
        if (user != null){
            //Ride ride =  new RideParser(user).getEntity();
            BetService betService = BetServiceImpl.getInstance();
            try {
                List<Bet> bets = betService.findBetsByUser(user);
                request.getSession().setAttribute(Attributes.BETS,bets);

            } catch (Exception e) {
                e.printStackTrace();
                request.getSession().setAttribute(Attributes.ERROR, Attributes.DATABASE_ERROR);
            }
            return Pages.HISTORY;
        }

        return Pages.LOGIN;

    }
}

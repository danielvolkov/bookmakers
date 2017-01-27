package controller.commands.user;

import controller.commands.Command;
import controller.parser.BetParser;
import model.entity.Bet;
import model.entity.User;
import services.BetService;
import services.impl.BetServiceImpl;
import util.constants.Attributes;
import util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by daniel on 1/24/17.
 */
public class MakeBetCommand implements Command {
    BetService betService = BetServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User client = (User)request.getSession().getAttribute(Attributes.USER);

        if (client.getRole().equals(Attributes.CLIENT)){

            Bet bet = new BetParser(request).getEntity();

            try {

                betService.makeBet(client,bet);
                request.setAttribute(Attributes.SUCCESS, Attributes.SUCCESS_MSG);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute(Attributes.ERROR, Attributes.DATABASE_ERROR);
            }
            return Pages.BET;
        }

        return Pages.PAGE_NOT_FOUND;

    }
}

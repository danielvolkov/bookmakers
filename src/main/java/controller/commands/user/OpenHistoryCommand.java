package controller.commands.user;

import controller.commands.Command;
import util.Attributes;
import util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by daniel on 1/22/17.
 */
public class OpenHistoryCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute(Attributes.USER) != null){
            return Pages.HISTORY;
        }

        return Pages.LOGIN;

    }
}

package controller.commands.authorization;

import controller.commands.Command;
import util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by daniel on 1/21/17.
 */
public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().invalidate();
        return Pages.LOGIN;
    }
}

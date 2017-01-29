package controller.commands.authorization;

import controller.commands.Command;
import util.constants.Attributes;
import util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  Daniil Volkov
 */
public class OpenSignupCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().setAttribute(Attributes.SIGNUP_ERROR,null);
        return Pages.SIGNUP;
    }
}

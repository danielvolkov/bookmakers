package controller.commands.authorization;

import controller.commands.Command;
import util.constants.Attributes;
import util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by daniel on 1/22/17.
 */
public class OpenLoginCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if(request.getSession().getAttribute(Attributes.USER)!= null){
            return Pages.CABINET;
        }
        request.getSession().setAttribute(Attributes.LOGIN_ERROR,null);
        return Pages.LOGIN;
    }
}

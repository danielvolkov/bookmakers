package controller.commands.user;

import controller.commands.Command;
import model.entity.User;
import util.Attributes;
import util.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by daniel on 1/21/17.
 */
public class OpenCabinetCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getSession().getAttribute(Attributes.User) != null){
            return Pages.CABINET;
        }

        return Pages.LOGIN;
    }
}

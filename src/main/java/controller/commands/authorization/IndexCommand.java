package controller.commands.authorization;

import controller.commands.Command;
import util.constants.Attributes;
import util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by daniel on 1/22/17.
 */
public class IndexCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getSession().getAttribute(Attributes.USER) != null){
            return Pages.CABINET;
        }

        return Pages.LOGIN;
    }
}

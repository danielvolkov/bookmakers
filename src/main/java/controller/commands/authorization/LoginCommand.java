package controller.commands.authorization;

import controller.commands.Command;
import controller.pickers.LoginPicker;

import model.entity.User;
import services.UserService;
import services.impl.UserServiceImpl;
import util.Attributes;
import util.Pages;
import util.UrlHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by daniel on 1/19/17.
 */
public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

            User user = new LoginPicker(request).getEntity();


            UserService userService = UserServiceImpl.getInstance();
            response.sendRedirect(UrlHolder.CABINET);
            return Pages.CABINET;


    }
}

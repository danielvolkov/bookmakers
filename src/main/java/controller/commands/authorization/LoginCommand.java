package controller.commands.authorization;

import controller.commands.Command;


import controller.parser.LoginParser;
import model.entity.User;
import services.UserService;
import services.impl.UserServiceImpl;
import util.Attributes;
import util.Pages;

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

            User loginUser = new LoginParser(request).getEntity();
            UserService userService = UserServiceImpl.getInstance();

            User existingUser;
            try {
                existingUser = userService.findUser(loginUser.getEmail());

                if (existingUser != null) {
                    String logPassword = loginUser.getPassword();
                    String existPassword = existingUser.getPassword();

                    if (logPassword.equals(existPassword)) {
                        HttpSession session = request.getSession();
                        existingUser.setPassword(null);
                        session.setAttribute(Attributes.USER, existingUser);

                        return Pages.CABINET;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        request.getSession().setAttribute(Attributes.LOGIN_ERROR,Attributes.LOGIN_MSG);
        return Pages.LOGIN;
    }
}

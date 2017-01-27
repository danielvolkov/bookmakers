package controller.commands.authorization;

import controller.commands.Command;
import controller.parser.SignUpParser;

import model.entity.User;
import services.UserService;
import services.impl.UserServiceImpl;
import util.constants.Attributes;
import util.constants.Pages;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by daniel on 1/19/17.
 */
public class SignUpCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = new SignUpParser(request).getEntity();

        UserService userService = UserServiceImpl.getInstance();

        try {
            if(userService.findUser(user.getEmail()) == null){
                userService.create(user);
                return Pages.LOGIN;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute(Attributes.SIGNUP_ERROR, Attributes.SIGNUP_MSG);
        return Pages.SIGNUP;
    }
}

package controller.commands.authorization;

import controller.commands.Command;


import controller.parser.LoginParser;
import model.entity.User;
import services.UserService;
import services.impl.UserServiceImpl;
import util.constants.Attributes;
import util.constants.Pages;
import util.validators.LoginValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by daniel on 1/19/17.
 */
public class LoginCommand implements Command {

    UserService userService = UserServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

            User loginUser = new LoginParser(request).getEntity();//TODO
            User existingUser;
            try {
                LoginValidator loginValidator = new LoginValidator();
                if(loginValidator.validate(loginUser)){
                    existingUser = userService.login(loginUser);
                    request.getSession().setAttribute(Attributes.USER, existingUser);
                    return Pages.CABINET;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        request.getSession().setAttribute(Attributes.LOGIN_ERROR,Attributes.LOGIN_MSG);
        return Pages.LOGIN;
    }
}

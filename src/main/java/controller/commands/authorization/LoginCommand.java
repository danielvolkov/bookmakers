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

    private UserService userService = UserServiceImpl.getInstance();
    private LoginParser loginParser;
    private LoginValidator loginValidator;

    public LoginCommand() {

    }
    //for mocking
    public LoginCommand(LoginParser loginParser, LoginValidator loginValidator) {
        this.loginParser = loginParser;
        this.loginValidator = loginValidator;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

            User loginUser;
            User existingUser;
            try {
                loginUser = new LoginParser(request).getEntity();
                LoginValidator loginValidator = new LoginValidator();
                if(loginValidator.isValid(loginUser)){
                    existingUser = userService.login(loginUser);
                    HttpSession sesson = request.getSession();
                    sesson.setAttribute(Attributes.USER, existingUser);
                    return Pages.CABINET;
                }
            } catch (Exception e) {

            }

        request.getSession().setAttribute(Attributes.LOGIN_ERROR,Attributes.LOGIN_MSG);
        return Pages.LOGIN;
    }
}

package controller.commands.authorization;

import controller.commands.Command;
import controller.parser.SignUpParser;

import model.entity.User;
import services.UserService;
import services.impl.UserServiceImpl;
import util.constants.Attributes;
import util.constants.Pages;
import util.validators.SignupValidator;
import util.validators.Validator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author  Daniil Volkov
 */
public class SignUpCommand implements Command {
    UserService userService = UserServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User newUser;
        try {
            newUser = new SignUpParser(request).getEntity();
            SignupValidator signupValidator = new SignupValidator();
            if(signupValidator.validate(newUser)) {
                userService.create(newUser);
                return Pages.LOGIN;
            } else {
                request.getSession().setAttribute(Attributes.SIGNUP_ERROR, Attributes.VALIDATION_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute(Attributes.SIGNUP_ERROR, Attributes.SIGNUP_MSG);
        }

        return Pages.SIGNUP;
    }
}

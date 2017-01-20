package controller.commands.authorization;

import controller.commands.Command;
import model.entity.User;
import services.UserService;
import services.impl.UserServiceImpl;
import util.Attributes;
import util.Pages;
import util.UrlHolder;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by daniel on 1/19/17.
 */
public class SignUpCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if(request.getMethod().equals(UrlHolder.POST_METHOD)){
        String name = request.getParameter(Attributes.NAME);
        String password =request.getParameter(Attributes.PWD);
        String email = request.getParameter(Attributes.EMAIL);
        String role = request.getParameter(Attributes.ROLE);

        User user = new User(email,password,name,role);
        UserService userService = UserServiceImpl.getInstance();
        userService.create(user);

        return Pages.LOGIN;
        }else{
            return Pages.SIGNUP;
        }
    }
}

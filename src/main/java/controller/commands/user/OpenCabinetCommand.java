package controller.commands.user;

import controller.commands.Command;
import model.entity.User;
import services.UserService;
import services.impl.UserServiceImpl;
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
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        if ( user != null){
            UserService userService = UserServiceImpl.getInstance();
            try {
                user = userService.findUser(user.getEmail());
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.getSession().setAttribute(Attributes.USER,user);
            return Pages.CABINET;
        }

        return Pages.LOGIN;
    }
}

package controller.commands.user;

import controller.commands.Command;
import model.entity.User;
import services.UserService;
import services.impl.UserServiceImpl;
import util.MoneyTypeConverter;
import util.constants.Attributes;
import util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by daniel on 1/22/17.
 */
public class DepositeCommand implements Command {
    UserService userService = UserServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = (User) request.getSession().getAttribute(Attributes.USER);
        if (user != null){

            Long deposite = MoneyTypeConverter.doubleToLong(
                    Double.parseDouble(request.getParameter(Attributes.DEPOSITE)));
            try {
                userService.updateBalance(user, deposite);
                user = userService.findUser(user.getEmail());
            } catch (Exception e) {
                request.getSession().setAttribute(Attributes.CABINET_ERROR,Attributes.CABINET_MSG);
                return Pages.CABINET;
            }
            request.getSession().setAttribute(Attributes.USER,user);
            return Pages.CABINET;
        }
        return Pages.LOGIN;
    }
}

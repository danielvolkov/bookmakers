package controller.commands.user;

import controller.commands.Command;
import model.entity.User;
import services.UserService;
import services.impl.UserServiceImpl;
import util.MoneyTypeConverter;
import util.constants.Attributes;
import util.constants.Pages;
import util.validators.MoneyValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by daniel on 1/22/17.
 */
public class WithdrawCommand implements Command {
    UserService userService = UserServiceImpl.getInstance();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        MoneyValidator moneyValidator = new MoneyValidator();
        String money = request.getParameter(Attributes.WITHDRAW);

        try {
            if(moneyValidator.validate(money)) {
                Long withdraw = MoneyTypeConverter.doubleToLong(
                        Double.parseDouble(money));
                userService.withdrawMoney(user, withdraw );
                user = userService.findUser(user.getEmail());
                request.getSession().setAttribute(Attributes.CABINET_ERROR,null);
            }else {
                request.getSession().setAttribute(Attributes.CABINET_ERROR,Attributes.VALIDATION_MSG);
            }
        } catch (Exception e) {
            request.getSession().setAttribute(Attributes.CABINET_ERROR,Attributes.CABINET_MSG);
            return Pages.CABINET;
        }

        request.getSession().setAttribute(Attributes.USER,user);
        return Pages.CABINET;

    }
}

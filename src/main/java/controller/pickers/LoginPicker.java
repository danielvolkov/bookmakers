package controller.pickers;

import controller.security.Encryptor;
import model.entity.Entity;
import model.entity.User;
import util.Attributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/21/17.
 */
public class LoginPicker implements Picker {

    private User user;
    public LoginPicker(HttpServletRequest request) {
        String email = request.getParameter(Attributes.EMAIL);
        String password = request.getParameter(Attributes.PWD);

        user = new User();
        user.setEmail(email);
        user.setPassword(Encryptor.encrypt(password));
    }

    @Override
    public User getEntity() {
        return user;
    }



}

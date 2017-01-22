package controller.pickers;

import controller.security.Encryptor;
import model.entity.Entity;
import model.entity.User;
import util.Attributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/21/17.
 */
public class SignUpPicker implements Picker {
    private User user;

    public SignUpPicker(HttpServletRequest request) {
        String name = request.getParameter(Attributes.NAME);
        String password = request.getParameter(Attributes.PWD);
        String email = request.getParameter(Attributes.EMAIL);
        String role = request.getParameter(Attributes.ROLE);

        user = new User(email, Encryptor.encrypt(password),name,role);
    }

    @Override
    public User getEntity() {

        return user;
    }
}

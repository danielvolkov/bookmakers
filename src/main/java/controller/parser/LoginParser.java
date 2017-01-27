package controller.parser;

import controller.security.Encryptor;
import model.entity.User;
import util.Attributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/21/17.
 */
public class LoginParser  {

    private User user;
    public LoginParser(HttpServletRequest request) {
        String email = request.getParameter(Attributes.EMAIL);
        String password = request.getParameter(Attributes.PWD);

        user = new User();
        user.setEmail(email);
        user.setPassword(Encryptor.encrypt(password));
    }


    public User getEntity() {
        return user;
    }



}

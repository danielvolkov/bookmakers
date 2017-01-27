package controller.parser;

import controller.security.Encryptor;
import model.entity.User;
import util.Attributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/21/17.
 */
public class SignUpParser {
    private User user;

    public SignUpParser(HttpServletRequest request) {
        String name = request.getParameter(Attributes.NAME);
        String password = request.getParameter(Attributes.PWD);
        String email = request.getParameter(Attributes.EMAIL);
        String role = request.getParameter(Attributes.ROLE);

        user = new User(email, Encryptor.encrypt(password),name,role);
    }


    public User getEntity() {

        return user;
    }
}

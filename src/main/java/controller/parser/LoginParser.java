package controller.parser;

import controller.security.Encryptor;
import model.entity.User;
import org.apache.log4j.Logger;
import util.constants.Attributes;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/21/17.
 */
public class LoginParser  {
    private static final Logger logger = Logger.getLogger(LoginParser.class);
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

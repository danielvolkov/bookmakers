package controller.parser;

import controller.security.Encryptor;
import model.entity.User;
import org.apache.log4j.Logger;
import util.constants.Attributes;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by daniel on 1/21/17.
 */
public class LoginParser  {
    private static final Logger logger = Logger.getLogger(LoginParser.class);
    private User user;
    private Encryptor encryptor;
    private HttpServletRequest request;
    public LoginParser(HttpServletRequest request) {
       this.request = request;
    }

    public User getEntity() {
        String email = request.getParameter(Attributes.EMAIL);
        String password = request.getParameter(Attributes.PWD);
        Encryptor encryptor = new Encryptor();
        user = new User();
        user.setEmail(email);
        user.setPassword(encryptor.encrypt(password));
        return user;
    }



}

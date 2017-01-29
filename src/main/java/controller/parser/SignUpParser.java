package controller.parser;

import controller.security.Encryptor;
import model.entity.User;
import org.apache.log4j.Logger;
import util.constants.Attributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/21/17.
 */
public class SignUpParser {
    private static final Logger logger = Logger.getLogger(SignUpParser.class);
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

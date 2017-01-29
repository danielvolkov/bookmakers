package controller.parser;

import controller.security.Encryptor;
import model.entity.Roles;
import model.entity.User;
import org.apache.log4j.Logger;
import util.UserUtil;
import util.constants.Attributes;



import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/21/17.
 */
public class SignUpParser {
    private static final Logger logger = Logger.getLogger(SignUpParser.class);
    private User user;

    public SignUpParser(HttpServletRequest request) {
        user = new User();
        user.setName(request.getParameter(Attributes.NAME));
        user.setPassword(request.getParameter(Attributes.PWD));
        user.setEmail(request.getParameter(Attributes.EMAIL));
        Roles role = UserUtil.stringToEnumRole(request.getParameter(Attributes.ROLE));
        user.setRole(role);
    }


    public User getEntity() {

        return user;
    }
}

package util.validators;

import model.entity.User;

/**
 * Created by daniel on 1/30/17.
 */
public class SignupValidator implements Validator {

    public Boolean validate(User user){
        return validateValue(user.getEmail(),EMAIL) &&
                validateValue(user.getName(),NAME) &&
                validateValue(user.getPassword(),PASSWORD);
    }
}

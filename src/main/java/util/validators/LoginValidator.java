package util.validators;

import model.entity.User;

/**
 * Created by daniel on 1/30/17.
 */
public class LoginValidator implements Validator {
    public Boolean isValid(User user){
        return validateValue(user.getEmail(),EMAIL) &&
                validateValue(user.getPassword(),PASSWORD);

    }
}

package util.validators;

import model.entity.User;

/**
 * Created by daniel on 1/30/17.
 */
public class LoginValidator implements Validator {
    public Boolean validate(User user){
        if(validateValue(user.getEmail(),EMAIL) &&
                validateValue(user.getPassword(),PASSWORD)){
            return true;
        } else {
            return false;
        }
    }
}

package util.validators;

import model.entity.Ride;

/**
 * Created by daniel on 1/30/17.
 */
public class MoneyValidator implements Validator {
    public Boolean isValid(String money){
        return validateValue(money, MONEY) ;

    }
}

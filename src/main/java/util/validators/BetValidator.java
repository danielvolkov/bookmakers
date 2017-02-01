package util.validators;

import model.entity.Bet;
import model.entity.Ride;

/**
 * Created by daniel on 1/30/17.
 */
public class BetValidator implements Validator {
    public Boolean isValid(Bet bet){
        return validateValue(bet.getBetSum().toString(),MONEY);

    }
}

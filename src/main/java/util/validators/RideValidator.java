package util.validators;

import model.entity.Ride;
import model.entity.User;

/**
 * @author  Daniil Volkov
 */
public class RideValidator implements Validator {

    public Boolean isValid(Ride ride){
        return validateValue(ride.getMaxSumm().toString(),MONEY) &&
                validateValue(ride.getCoefficient().toString(),FACTOR);

    }
}

package util.validators;

import model.entity.Bet;
import model.entity.Ride;
import model.entity.User;

import java.util.regex.Pattern;

/**
 * Created by daniel on 1/28/17.
 */
public class Validator {

    public static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final String NAME = "^[\\p{L} \\.'\\-]+$";

    public static final String PASSWORD = "[^\\s]{4,200}";

    public static final String MONEY = "^.{1,500}$";

    public static final String DATE = "^.{0,500}$";

    public static final String  FACTOR = "^.{0,100}$";


    public Validator() {

    }

    public boolean validateSignUp(User user){

        return true;
    }

    public boolean validateLogin(User user){
        return true;
    }

    public boolean validateRide(Ride ride) {
        return true;
    }

    public boolean validateBet(Bet bet) {
        return true;
    }
    public boolean validateMoney(User user) {
        return true;
    }
}

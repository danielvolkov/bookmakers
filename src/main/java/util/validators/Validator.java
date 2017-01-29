package util.validators;

import model.entity.Bet;
import model.entity.Ride;
import model.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by daniel on 1/28/17.
 */
 public interface Validator {

    public static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final String NAME = "^[\\p{L} \\.'\\-]+$";

    public static final String PASSWORD = "[^\\s]{4,200}";

    public static final String MONEY = "^.{1,500}$";

    public static final String FACTOR = "^.{1,10}$";

    default Boolean validateValue(String inputString, String stringPattern){
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(inputString);
        return  matcher.matches();
    }


}

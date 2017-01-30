package util.validators;

import model.entity.Bet;
import model.entity.Ride;
import model.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**Errors errors
 * Created by daniel on 1/28/17.
 */
 public interface Validator {

    String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    String NAME = "[A-Z][a-z]+";

    String PASSWORD = "[^\\s]{4,200}";

    String MONEY = "^[1-9]\\d*$";

    String FACTOR = "^[1-9].{1,3}$";

    default Boolean validateValue(String inputString, String stringPattern){
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(inputString);
        return  matcher.matches();
    }


}

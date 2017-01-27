package util;

import util.constants.Attributes;

/**
 * Created by daniel on 1/20/17.
 */
public class UserUtil {
    public static String intToStringRole(int role){
        String result = null;
        if(role == 1){
            result = Attributes.CLIENT;
        } else if(role == 2){
            result = Attributes.BOOKMAKER;
        } else if(role == 3){
            result = Attributes.ADMIN;
        }
        return result;
    }

    public static int stringToIntRole(String role){
        int result = 0;
        if(role.equals(Attributes.CLIENT)){
            result = 1;
        } else if(role.equals(Attributes.BOOKMAKER)){
            result = 2;
        } else if(role.equals(Attributes.ADMIN)){
            result = 3;
        }
        return result;

        //TODO enum
    }
}

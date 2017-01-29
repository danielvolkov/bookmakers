package util;

import model.entity.Roles;

/**
 * Created by daniel on 1/20/17.
 */
public class UserUtil {

    public static Roles stringToEnumRole(String stringRole){
        for (Roles role: Roles.values()) {
            if(role.name().equals(stringRole.toUpperCase())) {
                return role;
            }
        }
        throw new RuntimeException();
    }



}

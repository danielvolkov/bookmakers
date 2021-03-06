package util.constants;

/**
 * Created by daniel on 1/19/17.
 */
public class UriHolder {
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";

    public static final String INDEX = "/";
    public static final String SIGNUP = "/signup";
    public static final String LOGIN = "/login";
    public static final String LOGOUT = "/logout";
    
    public static final String CABINET = "/cabinet";
    public static final String DEPOSITE =  "/deposite";
    public static final String WITHDRAW =  "/withdraw";

    public static final String RIDES = "/rides";
    public static final String ADD_RIDE = RIDES + "/add"; // for bookmaker
    public static final String END_RIDE = RIDES + "/confirm"; //for admin
    public static final String BET = RIDES+ "/bet"; // for client
    public static final String MAKE_BET = BET+ "/make";

    public static final String HISTORY = "/history";


    public static final String QUESTION_SYMBOL ="?" ;
    public static final String AND_SYMBOL = "&";
    public static final String EQUAL_SYMBOL = "=";
    public static final String LANG_GET = "lang=" ;
}

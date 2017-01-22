package util;

/**
 * Created by daniel on 1/19/17.
 */
public class UrlHolder {
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";

    public static final String INDEX = "/";
    public static final String SIGNUP = "/signup";
    public static final String LOGIN = "/login";
    public static final String LOGOUT = "/logout";
    
    public static final String CABINET = "/cabinet";
    public static final String ADD_FOUNDS = CABINET + "/add/founds";
    public static final String GET_FOUNDS = CABINET + "/get/founds";

    public static final String RIDES = "/rides";
    public static final String ADD_RIDE = RIDES + "/add/ride"; // for bookmaker
    public static final String END_RIDE = RIDES + "/end/ride"; //for admin
    public static final String BET = RIDES+ "/bet"; // for client

    public static final String HISTORY = "/history";



}

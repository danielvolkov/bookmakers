package util;

/**
 * Created by daniel on 1/27/17.
 */
public class MoneyTypeConverter {
    public static final int ONE = 100;

    public static Long doubleToLong(double doubleFromView){
        return (long) doubleFromView*ONE;
    }

    public static Double longToDouble(long longFromDataBase){
        return (double) longFromDataBase/ONE;
    }

}

package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by daniel on 1/24/17.
 */
public class DateUtil {


    public static Date dateParser(String inputStringDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
        try {
            return formatter.parse(inputStringDate);
                    //formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static String dateParser(Date inputDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
        //formatter.parse(inputStringDate);
        return formatter.format(inputDate);
    }
}

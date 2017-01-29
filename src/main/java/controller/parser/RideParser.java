package controller.parser;

import model.entity.Ride;
import model.entity.User;
import org.apache.log4j.Logger;
import util.MoneyTypeConverter;
import util.constants.Attributes;
import util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author  Daniil Volkov
 */
public class RideParser  {
    private static final Logger logger = Logger.getLogger(RideParser.class);
    Ride ride;

    public RideParser(User bookmaker, HttpServletRequest request) {

        String dateString = request.getParameter(Attributes.DATE);
        Long maxSumm = MoneyTypeConverter.doubleToLong( Double.parseDouble(request.getParameter(Attributes.MAX_BET)));
        Double coeff = Double.parseDouble(request.getParameter(Attributes.COEF));
        Date date = DateUtil.dateParser(dateString);
        this.ride = new Ride(bookmaker.getUserId(), date, maxSumm, coeff);
    }

    public Ride getEntity() {
        return ride;
    }
}

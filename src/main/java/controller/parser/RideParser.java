package controller.parser;

import model.entity.Ride;
import model.entity.User;
import org.apache.log4j.Logger;
import util.MoneyTypeConverter;
import util.constants.Attributes;
import util.DateUtil;

import javax.servlet.http.HttpServletRequest;


/**
 * @author  Daniil Volkov
 */
public class RideParser  {
    private static final Logger logger = Logger.getLogger(RideParser.class);
    Ride ride;

    public RideParser(User bookmaker, HttpServletRequest request) {
        ride = new Ride();
        String dateString = request.getParameter(Attributes.DATE);
        ride.setBookmakerId(bookmaker.getUserId());
        ride.setMaxSumm(MoneyTypeConverter
                .doubleToLong(Double.parseDouble(request.getParameter(Attributes.MAX_BET))));
        ride.setCoefficient(Double.parseDouble(request.getParameter(Attributes.COEF)));
        ride.setStartDataTime(DateUtil.dateParser(dateString));
        ride.setFinished(false);
    }

    public Ride getEntity() {
        return ride;
    }
}

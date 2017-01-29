package controller.parser;

import model.entity.Bet;
import model.entity.Ride;
import model.entity.User;
import org.apache.log4j.Logger;
import util.MoneyTypeConverter;
import util.constants.Attributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/24/17.
 */
public class BetParser {
    private static final Logger logger = Logger.getLogger(BetParser.class);
    private Bet bet;

    public BetParser(HttpServletRequest request) {
        Ride ride = (Ride) request.getSession().getAttribute(Attributes.RIDE);
        Integer rideId = ride.getRideId();
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        Long betSumm = MoneyTypeConverter.doubleToLong(Double.parseDouble(request.getParameter(Attributes.SUMM)));
        Integer horseId = Integer.parseInt(request.getParameter(Attributes.HORSE_ID));
        Integer betType = Integer.parseInt(request.getParameter(Attributes.TYPE));
        bet = new Bet(betSumm,betType,horseId,rideId,user.getUserId());
    }


    public Bet getEntity() {
        return bet;
    }
}

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
        bet = new Bet();
        Ride ride = (Ride) request.getSession().getAttribute(Attributes.RIDE);
        bet.setRideId( ride.getRideId());
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        bet.setUserId(user.getUserId());
        bet.setBetSum(MoneyTypeConverter
                .doubleToLong(Double.parseDouble(request.getParameter(Attributes.SUMM))));
        bet.setHorseId(Integer.parseInt(request.getParameter(Attributes.HORSE_ID)));
        bet.setBetType(Integer.parseInt(request.getParameter(Attributes.TYPE)));
        bet.setPassed(false);
    }


    public Bet getEntity() {
        return bet;
    }
}

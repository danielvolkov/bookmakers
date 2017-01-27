package controller.parser;

import model.entity.Bet;
import model.entity.User;
import util.Attributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/24/17.
 */
public class BetParser {
    Bet bet;

    public BetParser(HttpServletRequest request) {
        Integer rideId = Integer.parseInt ((String) request.getSession()
                .getAttribute(Attributes.RIDE));
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        Integer betSumm = Integer.parseInt(request.getParameter(Attributes.SUMM));
        Integer horseId = Integer.parseInt(request.getParameter(Attributes.HORSE_ID));
        Integer betType = Integer.parseInt(request.getParameter(Attributes.TYPE));
        bet = new Bet(betSumm,betType,horseId,rideId,user.getUserId());
    }


    public Bet getEntity() {
        return bet;
    }
}

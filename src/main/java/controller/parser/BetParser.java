package controller.parser;

import model.entity.Bet;
import model.entity.Entity;
import util.Attributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daniel on 1/24/17.
 */
public class BetParser implements Parser {
    Bet bet;

    public BetParser(HttpServletRequest request) {
        Integer rideId = Integer.parseInt ((String) request.getSession()
                .getAttribute(Attributes.RIDE));
        Integer betSumm = Integer.parseInt(request.getParameter(Attributes.SUMM));
        Integer horseId = Integer.parseInt(request.getParameter(Attributes.HORSE_ID));
        Integer betType = Integer.parseInt(request.getParameter(Attributes.TYPE));
        bet = new Bet(betSumm,betType,horseId,rideId);
    }

    @Override
    public Bet getEntity() {
        return bet;
    }
}

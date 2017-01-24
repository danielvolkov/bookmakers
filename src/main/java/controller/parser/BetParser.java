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
        String ride_id = (String) request.getSession().getAttribute(Attributes.RIDE);
        String coeficient = request.getParameter(Attributes.COEF);
        String betSumm = request.getParameter(Attributes.SUMM);

        bet = new Bet();
    }

    @Override
    public Bet getEntity() {
        return bet;
    }
}

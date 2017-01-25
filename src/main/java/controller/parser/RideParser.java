package controller.parser;

import model.entity.Entity;
import model.entity.Ride;
import model.entity.User;
import util.Attributes;
import util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by daniel on 1/23/17.
 */
public class RideParser implements Parser {
    Ride ride;

    public RideParser(User user, HttpServletRequest request) {

        String dateString = request.getParameter(Attributes.DATE);
        Integer maxSumm = Integer.parseInt(request.getParameter(Attributes.MAX_BET));
        Double coeff = Double.parseDouble(request.getParameter(Attributes.COEF));
        Date date = DateUtil.dateParser(dateString);
        this.ride = new Ride(user.getUserId(),date, maxSumm,coeff);

    }

    @Override
    public Ride getEntity() {

        return ride;
    }
}

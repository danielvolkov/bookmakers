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
        Date date = DateUtil.dateParser(dateString);
        this.ride = new Ride(user.getUserId(),date);

    }

    @Override
    public Ride getEntity() {

        return ride;
    }
}

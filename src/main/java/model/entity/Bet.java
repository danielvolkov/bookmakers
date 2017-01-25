package model.entity;

import java.util.Date;

/**
 * Created by daniel on 26/12/16.
 */
public class Bet implements Entity {
    private Integer betId;
    private Double totalSumm;
    private boolean isPassed;
    private Integer betSum;
    private Integer betType;
    private Horse horse;
    private Integer horseId;
    private Ride ride;
    private Integer rideId;
    private String betTypeString;

    public Integer getUserId() {
        return userId;
    }

    private Integer userId;

    public Bet(Integer betSum, Integer betType, Integer horseId, Integer rideId, Integer userId) {
        this.betSum = betSum;
        this.betType = betType;
        this.horseId = horseId;
        this.rideId = rideId;
        this.userId = userId;
    }

    public Bet( Double totalSumm, boolean isPassed, Integer betSum, String betTypeString, Integer horseId, Integer rideId) {
        this.totalSumm = totalSumm;
        this.isPassed = isPassed;
        this.betSum = betSum;
        this.betTypeString = betTypeString;
        this.horseId = horseId;
        this.rideId = rideId;
    }

    public Integer getBetSum() {
        return betSum;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public Integer getBetId() {
        return betId;
    }

    public Integer getBetType() {
        return betType;
    }

    public Integer getHorseId() {
        return horseId;
    }

    public Integer getRideId() {
        return rideId;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }
}

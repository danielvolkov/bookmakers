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
    private Integer horseId;
    private Ride ride;
    private Integer rideId;

    public Bet(Integer betSum, Integer betType, Integer horseId, Integer rideId) {
        this.betSum = betSum;
        this.betType = betType;
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
}

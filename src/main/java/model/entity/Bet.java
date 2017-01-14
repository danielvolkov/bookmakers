package model.entity;

import java.util.Date;

/**
 * Created by daniel on 26/12/16.
 */
public class Bet {
    private double betSum;
    private double coefficient;
    private boolean isPassed;
    private String typeOfBet;
    private Ride ride;

    public double getBetSum() {
        return betSum;
    }

    public void setBetSum(double betSum) {
        this.betSum = betSum;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public String getTypeOfBet() {
        return typeOfBet;
    }

    public void setTypeOfBet(String typeOfBet) {
        this.typeOfBet = typeOfBet;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }
}

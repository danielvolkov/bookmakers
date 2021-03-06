package model.entity;

/**
 * Created by daniel on 26/12/16.
 */
public class Bet {

    private Integer betId;
    private Long totalSumm;
    private Boolean isPassed;

    private Long betSum;
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

    public Bet() {
    }


    public Long getBetSum() {
        return betSum;
    }

    public Boolean getIsPassed() {
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

    public Horse getHorse() {
        return horse;
    }

    public Long getTotalSumm() {
        return totalSumm;
    }

    public Boolean getPassed() {
        return isPassed;
    }

    public String getBetTypeString() {
        return betTypeString;
    }

    public void setTotalSumm(Long totalSumm) {
        this.totalSumm = totalSumm;
    }
    public void setBetId(Integer betId) {
        this.betId = betId;
    }
    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }
    public void setBetSum(Long betSum) {
        this.betSum = betSum;
    }

    public void setBetType(Integer betType) {
        this.betType = betType;
    }

    public void setHorseId(Integer horseId) {
        this.horseId = horseId;
    }

    public void setBetTypeString(String betTypeString) {
        this.betTypeString = betTypeString;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

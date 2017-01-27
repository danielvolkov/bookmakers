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

    public Bet(Long betSum, Integer betType, Integer horseId, Integer rideId, Integer userId) {
        this.betSum = betSum;
        this.betType = betType;
        this.horseId = horseId;
        this.rideId = rideId;
        this.userId = userId;
        this.isPassed = false;
    }

    public Bet( Long totalSumm, Boolean isPassed, Long betSum, String betTypeString, Integer horseId, Integer rideId, Integer userId) {
        this.totalSumm = totalSumm;
        this.isPassed = isPassed;
        this.betSum = betSum;
        this.betTypeString = betTypeString;
        this.horseId = horseId;
        this.rideId = rideId;
        this.userId = userId;
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

    public void setPassed(Boolean passed) {
        isPassed = passed;
    }

    public void setTotalSumm(Long totalSumm) {
        this.totalSumm = totalSumm;
    }

}

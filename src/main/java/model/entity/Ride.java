package model.entity;

import java.util.Date;

/**
 * Created by daniel on 26/12/16.
 */
public class Ride {
    private Integer rideId;
    private Horse winnerHorse;
    private Horse looserHorse;
    private Integer winnerId;
    private Integer looserId;
    private Date startDataTime;
    private boolean finished;
    private String bookmakerEmail;

    private Integer bookmakerId;
    private Long maxSumm;
    private Double coefficient;

    public Ride(){

    }

    public void setBookmakerEmail(String bookmakerEmail) {
        this.bookmakerEmail = bookmakerEmail;
    }

    public Date getStartDataTime() {
        return startDataTime;
    }

    public void setStartDataTime(Date startDataTime) {
        this.startDataTime = startDataTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Integer getRideId() {
        return rideId;
    }

    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

    public String getBookmakerEmail() {
        return bookmakerEmail;
    }

    public Integer getBookmakerId() {
        return bookmakerId;
    }

    public Long getMaxSumm() {
        return maxSumm;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setWinnerHorse(Horse winnerHorse) {
        this.winnerHorse = winnerHorse;
    }

    public void setLooserHorse(Horse looserHorse) {
        this.looserHorse = looserHorse;
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public Integer getLooserId() {
        return looserId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public void setLooserId(Integer looserId) {
        this.looserId = looserId;
    }


    public void setBookmakerId(Integer bookmakerId) {
        this.bookmakerId = bookmakerId;
    }

    public void setMaxSumm(Long maxSumm) {
        this.maxSumm = maxSumm;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }


    public String getResult() {
        if(winnerHorse!=null && looserHorse!=null) {
            return "Winner: " + winnerHorse.toString() + "\n" +
                    "Looser: " + looserHorse.toString();
        }else {
            return "";
        }
    }


}

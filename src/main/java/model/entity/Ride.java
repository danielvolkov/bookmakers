package model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by daniel on 26/12/16.
 */
public class Ride implements Entity {
    private Integer rideId;
    private List<Horse> horses;
    private Integer winner;
    private Integer looser;
    private Date startDataTime;
    private boolean finished;
    private String bookmakerEmail;
    private Integer bookmakerId;

    public Ride(Integer bookmakerId, Date dateTime){
        this.bookmakerId = bookmakerId;
        this.finished = false;
        this.startDataTime = dateTime;
    }

    public Ride(Integer rideId, Integer winner, Integer looser,
                Date startDataTime, boolean finished, String bookmakerEmail) {
        this.rideId = rideId;
        this.winner = winner;
        this.looser = looser;
        this.startDataTime = startDataTime;
        this.finished = finished;
        this.bookmakerEmail = bookmakerEmail;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public Integer getLooser() {
        return looser;
    }

    public void setLooser(Integer looser) {
        this.looser = looser;
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
}

package model.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by daniel on 26/12/16.
 */
public class Ride {
    private ArrayList<Horse> horses;
    private Horse winner;
    private Horse looser;
    private Date startDataTime;
    private boolean finished;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void setHorses(ArrayList<Horse> horses) {
        this.horses = horses;
    }

    public Horse getWinner() {
        return winner;
    }

    public void setWinner(Horse winner) {
        this.winner = winner;
    }

    public Horse getLooser() {
        return looser;
    }

    public void setLooser(Horse looser) {
        this.looser = looser;
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
}

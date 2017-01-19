package model.entity;


import java.util.Set;

/**
 * Created by daniel on 26/12/16.
 */
public class User {
    private String email;
    private String password;
    private String name;
    private double balance;
    private Integer role;
    private Set<Bet> betHistory;

    public User(String email, String password, String name, int role, double balance) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public Set<Bet> getBetHistory() {
        return betHistory;
    }

    public void setBetHistory(Set<Bet> betHistory) {
        this.betHistory = betHistory;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}

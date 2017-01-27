package model.entity;


import util.UserUtil;

import java.util.Set;

/**
 * Created by daniel on 26/12/16.
 */
public class User {
    private Integer userId;
    private String email;
    private String password;
    private String name;
    private Long balance;
    private String role;
    private Set<Bet> betHistory;

    //TODO builder
    //TODO double to long
    public User() {
    }

    public User(Integer userId, String email, String password, String name, String role, Long balance) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.role = role;
        this.balance = balance;
        this.password = password;
    }

    public User(String email, String password, String name, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.balance = 0L;
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

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Set<Bet> getBetHistory() {
        return betHistory;
    }

    public void setBetHistory(Set<Bet> betHistory) {
        this.betHistory = betHistory;
    }

    public int getRoleInt() {
        return UserUtil.stringToIntRole(role);
    }

    public String getRole() {
        return role;
    }

    public void deposite(Long money){
        balance +=money;
    }

    public Integer getUserId() {
        return userId;
    }
    // TODO equals and hashcode toString
}

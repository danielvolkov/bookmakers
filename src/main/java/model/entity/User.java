package model.entity;


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
    private Roles role;
    private Set<Bet> betHistory;


    public static int CLIENT = 1;
    public static int BOOKMAKER = 2;
    public static int ADMIN = 3;


    public User() {
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

    public void setRole(Roles role) {
        this.role = role;
    }


    public Roles getRole() {
        return role;
    }

    public void deposite(Long money){
        balance +=money;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }



    // TODO equals and hashcode toString
}

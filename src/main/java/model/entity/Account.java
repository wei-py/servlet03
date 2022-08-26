package model.entity;

public class Account {
    private String card_id;
    private String password;
    private String username;
    private double balance;
    private String phone;

    public Account() {
    }

    public Account(String card_id, String password, String username, double balance, String phone) {
        this.card_id = card_id;
        this.password = password;
        this.username = username;
        this.balance = balance;
        this.phone = phone;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Account{" +
                "card_id='" + card_id + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", phone='" + phone + '\'' +
                '}';
    }
}
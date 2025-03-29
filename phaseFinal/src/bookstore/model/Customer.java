package bookstore.model;

public class Customer {
    private String username;
    private String password;
    private int points;

    // Constructor
    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0; // Initialize points to 0
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // Calculate customer status (Gold or Silver)
    public String getStatus() {
        return points >= 1000 ? "Gold" : "Silver";
    }

    @Override
    public String toString() {
        return username + "," + password + "," + points;
    }
}
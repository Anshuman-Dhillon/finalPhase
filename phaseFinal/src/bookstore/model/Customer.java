package bookstore.model;

import bookstore.model.states.CustomerState;
import bookstore.model.states.SilverState;

public class Customer {

    private String username;
    private String password;
    private int points;
    private CustomerState state;  // State pattern

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0;
        this.state = new SilverState();  // Default state
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
        state.checkStatus(this);  // Check for state transitions
    }

    // State-related methods
    public String getStatus() {
        return state.getStatus();
    }

    public void setState(CustomerState state) {
        this.state = state;
    }
}

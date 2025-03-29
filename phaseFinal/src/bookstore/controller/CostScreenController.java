package bookstore.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import bookstore.model.Customer;
import bookstore.util.SceneManager;

public class CostScreenController {
    @FXML private Label totalCostLabel;
    @FXML private Label pointsLabel;
    @FXML private Label statusLabel;

    private Customer customer;

    public void setCustomer(Customer customer, double totalCost, boolean redeemed) {
        this.customer = customer;
        totalCostLabel.setText("Total Cost: " + totalCost);
        pointsLabel.setText("Points: " + customer.getPoints());
        statusLabel.setText("Status: " + customer.getStatus());
    }

    @FXML
    private void handleLogout() {
        SceneManager.switchToLoginScreen();
    }
}
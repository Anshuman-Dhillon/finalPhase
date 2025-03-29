package bookstore.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import bookstore.util.SceneManager;
import bookstore.model.Owner;
import bookstore.model.Customer;
import bookstore.controller.CostScreenController;
import bookstore.controller.CustomerScreenController;


public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if the owner is logging in
        if (username.equals("admin") && password.equals("admin")) {
            SceneManager.switchToOwnerScreen();
        } else {
            // Check if the customer exists
            Owner owner = new Owner("admin", "admin"); // Replace with actual owner instance
            owner.loadData(); // Load customer data
            Customer customer = owner.findCustomerByUsername(username);
            if (customer != null && customer.getPassword().equals(password)) {
                SceneManager.switchToCustomerScreen(customer);
            } else {
                // Show error message (e.g., invalid username/password)
                System.out.println("Invalid username or password.");
            }
        }
    }
}
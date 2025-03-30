package bookstore.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import bookstore.util.SceneManager;
import bookstore.model.Owner;
import bookstore.model.Customer;
import bookstore.controller.CostScreenController;
//import bookstore.controller.CustomerScreenController;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    //System.out.println("The customers " +customer ); // Debug print
//Owner owner = new Owner("admin", "admin");
    Owner owner = SceneManager.getOwner();

    @FXML
    public void initialize() {

        // owner.loadData(); // Load everything only once
        //SceneManager.setOwner(owner);
        System.out.println("Customers on login screen:");// this can be deleted I was just checking
        for (Customer customer : owner.getCustomers()) {
            System.out.println("- " + customer.getUsername() + " (" + customer.getPassword() + " pts)");
        }
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if (username.equals("admin") && password.equals("admin")) {
            SceneManager.switchToOwnerScreen();
        } else {
            // Check if the customer exists
            //  Owner owner = new Owner("admin", "admin"); // Replace with actual owner instance
            //  owner.loadData(); // Load customer data

            Customer customer = owner.findCustomerByUsername(username);

            if (customer != null && customer.getPassword().equals(password)) {
                SceneManager.switchToCustomerScreen(customer);
            } else {
                System.out.println("Invalid username or password.");
            }
        }
    }
}

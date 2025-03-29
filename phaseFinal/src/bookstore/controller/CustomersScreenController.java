package bookstore.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import bookstore.model.Customer;
import bookstore.model.Owner;
import bookstore.util.SceneManager;

public class CustomersScreenController {
    @FXML private TableView<Customer> customersTable;
    @FXML private TableColumn<Customer, String> usernameColumn;
    @FXML private TableColumn<Customer, String> passwordColumn;
    @FXML private TableColumn<Customer, Integer> pointsColumn;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;

    private Owner owner;

    @FXML
    public void initialize() {
        // Set up the table columns
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        // Load owner data
        owner = new Owner("admin", "admin"); // Replace with actual owner instance
        owner.loadData();

        // Populate the table with customers
        customersTable.setItems(owner.getCustomers());
    }

    @FXML
    private void handleAddCustomer() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Customer customer = new Customer(username, password);
        owner.addCustomer(customer);
        customersTable.setItems(owner.getCustomers()); // Refresh the table
    }

    @FXML
    private void handleDeleteCustomer() {
        Customer selectedCustomer = customersTable.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            owner.removeCustomer(selectedCustomer);
            customersTable.setItems(owner.getCustomers()); // Refresh the table
        }
    }

    @FXML
    private void handleBack() {
        SceneManager.switchToOwnerScreen();
    }
}
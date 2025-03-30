package bookstore.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.PropertyValueFactory;
import bookstore.model.Book;
import bookstore.model.Customer;
import bookstore.model.Owner;
import bookstore.util.SceneManager;
import javafx.scene.control.Label;

public class CustomerScreenController {

    @FXML
    private TableView<Book> booksTable;
    @FXML
    private TableColumn<Book, String> bookNameColumn;
    @FXML
    private TableColumn<Book, Double> bookPriceColumn;
    @FXML
    private TableColumn<Book, CheckBox> selectColumn;
    @FXML
    private TableColumn<Customer, Integer> pointsColumn;
    @FXML
    private Label welcomeLabel;

    private Customer customer;
    private Owner owner;

    @FXML
    public void initialize() {
        // Set up the table columns
        selectColumn.setCellValueFactory(new PropertyValueFactory<>("select"));

        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        bookPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Load owner data
        //owner = new Owner("admin", "admin"); // Replace with actual owner instance
        // owner.loadData();
        // Populate the table with books
        // booksTable.setItems(owner.getBooks());
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.owner = SceneManager.getOwner();

        String message = "Welcome " + customer.getUsername() + ". You have " + customer.getPoints() + " points. Your status is " + customer.getStatus();//display message

        welcomeLabel.setText(message);

        booksTable.setItems(owner.getBooks());

    }

    @FXML
    private void handleBuy() {
        // Calculate total cost and update points
        double totalCost = 0;
        for (Book book : booksTable.getItems()) {
            if (book.getSelect().isSelected()) {
                totalCost += book.getPrice();
            }
        }
        customer.setPoints(customer.getPoints() + (int) (totalCost * 10));
        SceneManager.switchToCostScreen(customer, totalCost, false);
    }

    @FXML
    private void handleRedeemAndBuy() {
        // Calculate total cost and redeem points
        double totalCost = 0;
        for (Book book : booksTable.getItems()) {
            if (book.getSelect().isSelected()) {
                totalCost += book.getPrice();
            }
        }
        int pointsToRedeem = customer.getPoints();
        double discount = Math.min(pointsToRedeem / 100, totalCost);
        totalCost -= discount;
        customer.setPoints((int) (pointsToRedeem - (discount * 100)));
        SceneManager.switchToCostScreen(customer, totalCost, true);
    }

    @FXML
    private void handleLogout() {
        SceneManager.switchToLoginScreen();
    }
}

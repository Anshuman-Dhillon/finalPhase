package bookstore.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import bookstore.util.FileHandler;
import java.util.List;
import java.util.ArrayList;

public class Owner {

    private String username;
    private String password;
    private ObservableList<Book> books; // Use ObservableList for books
    private ObservableList<Customer> customers; // Use ObservableList for customers

    // Constructor
    public Owner(String username, String password) {
        this.username = username;
        this.password = password;
        this.books = FXCollections.observableArrayList(); // Initialize as ObservableList
        this.customers = FXCollections.observableArrayList(); // Initialize as ObservableList
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

    // Return ObservableList for books
    public ObservableList<Book> getBooks() {
        return books;
    }

    // Return ObservableList for customers
    public ObservableList<Customer> getCustomers() {
        return customers;
    }

    // Add a book to the bookstore
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book from the bookstore
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Add a customer to the bookstore
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Remove a customer from the bookstore
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    // Find a customer by username
    public Customer findCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    // Save all books and customers to files
    public void saveData() {
        FileHandler.saveBooks(books);
        FileHandler.saveCustomers(customers);
    }

    // Load all books and customers from files
    public void loadData() {
        books = FXCollections.observableArrayList(FileHandler.loadBooks()); // Convert to ObservableList
        customers = FXCollections.observableArrayList(FileHandler.loadCustomers()); // Convert to ObservableList
    }

}

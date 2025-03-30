package bookstore.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import bookstore.util.FileHandler;
import java.util.List;
import java.util.ArrayList;

public class Owner {
    private String username;
    private String password;
    private ObservableList<Book> books;
    private ObservableList<Customer> customers;

    public Owner(String username, String password) {
        this.username = username;
        this.password = password;
        this.books = FXCollections.observableArrayList();
        this.customers = FXCollections.observableArrayList();
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

    public ObservableList<Book> getBooks() {
        return books;
    }

    public ObservableList<Customer> getCustomers() {
        return customers;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public Customer findCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        
        return null; //customer not found
    }

    //Save all books and customers to files
    public void saveData() {
        FileHandler.saveBooks(books);
        FileHandler.saveCustomers(customers);
    }

    //Load all books and customers from files
    public void loadData() {
        books = FXCollections.observableArrayList(FileHandler.loadBooks());
        customers = FXCollections.observableArrayList(FileHandler.loadCustomers());
    }
}
package bookstore.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import bookstore.model.Book;
import bookstore.model.Owner;
import bookstore.util.SceneManager;

public class BooksScreenController {
    @FXML private TableView<Book> booksTable;
    @FXML private TableColumn<Book, String> bookNameColumn;
    @FXML private TableColumn<Book, Double> bookPriceColumn;
    @FXML private TextField nameField;
    @FXML private TextField priceField;

    private Owner owner;

    @FXML
    public void initialize() {
        // Set up the table columns
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        bookPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Load owner data
        owner = new Owner("admin", "admin"); // Replace with actual owner instance
        owner.loadData();

        // Populate the table with books
        booksTable.setItems(owner.getBooks()); // Now works because getBooks() returns ObservableList
    }

    @FXML
    private void handleAddBook() {
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        Book book = new Book(name, price);
        owner.addBook(book);
        // No need to call setItems again because ObservableList automatically updates the table
    }

    @FXML
    private void handleDeleteBook() {
        Book selectedBook = booksTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            owner.removeBook(selectedBook);
            // No need to call setItems again because ObservableList
        }
    }
}
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
    @FXML
    private TableView<Book> booksTable;
    @FXML
    private TableColumn<Book, String> bookNameColumn;
    @FXML
    private TableColumn<Book, Double> bookPriceColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;

    //  private Owner owner;
    Owner owner = SceneManager.getOwner();

    @FXML
    public void initialize() {
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        bookPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Load owner data
        //owner.loadData();
        //Populate the table with books
        booksTable.setItems(owner.getBooks());
    }

    @FXML
    private void handleAddBook() {
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        
        // Check if the book already exists in the list
        for (Book existingBook : owner.getBooks()) {
            if (existingBook.getName().equalsIgnoreCase(name) && existingBook.getPrice() == price) {
                return;
            }
        }
        
        Book book = new Book(name, price);
        owner.addBook(book);
        booksTable.setItems(owner.getBooks());
    }

    @FXML
    private void handleDeleteBook() {
        Book selectedBook = booksTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            owner.removeBook(selectedBook);
            booksTable.setItems(owner.getBooks());
        }
    }

    @FXML
    private void handleBack() {
        SceneManager.switchToOwnerScreen();
    }
}
package bookstore.controller;

import bookstore.util.SceneManager;
import javafx.fxml.FXML;

public class OwnerScreenController {
    @FXML
    private void handleBooks() {
        SceneManager.switchToBooksScreen();
    }

    @FXML
    private void handleCustomers() {
        SceneManager.switchToCustomersScreen();
    }

    @FXML
    private void handleLogout() {
        SceneManager.switchToLoginScreen();
    }
}
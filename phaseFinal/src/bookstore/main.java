package bookstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import bookstore.util.SceneManager;
import bookstore.model.Owner;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set the primary stage in SceneManager
        SceneManager.setPrimaryStage(primaryStage);

        // Load the login screen
        SceneManager.switchToLoginScreen();

        // Set the title of the application window
        primaryStage.setTitle("Book Store Application");

        // Show the application window
        primaryStage.show();

        // Handle window close event to save data
        primaryStage.setOnCloseRequest(event -> {
            // Save data to files before closing
            Owner owner = new Owner("admin", "admin"); // Replace with actual owner instance
            owner.loadData(); // Load existing data
            owner.saveData(); // Save current data
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
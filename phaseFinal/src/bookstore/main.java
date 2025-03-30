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
        Owner owner = new Owner("admin", "admin");
        owner.loadData();

        SceneManager.setOwner(owner);
        SceneManager.setPrimaryStage(primaryStage);

        //Load the login screen
        SceneManager.switchToLoginScreen();

        //Set the title of the application window
        primaryStage.setTitle("Book Store Application");
        primaryStage.show();
        
        //handle window close event to save data
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Saving data before exit...");
            SceneManager.getOwner().saveData(); // Overwrite books.txt and customers.txt

            //save data to files before closing
            //Owner owner = new Owner("admin", "admin"); // Replace with actual owner instance
            //owner.loadData(); // Load existing data
            //owner.saveData(); // Save current data
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

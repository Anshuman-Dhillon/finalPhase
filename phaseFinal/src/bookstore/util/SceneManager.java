package bookstore.util;

import bookstore.model.Owner;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import bookstore.model.Customer;
import bookstore.controller.CostScreenController;
import bookstore.controller.CustomerScreenController;

public class SceneManager {
    private static Stage primaryStage;
    private static Owner currentOwner;

    public static void setOwner(Owner owner) {
        currentOwner = owner;
        System.out.println("Owner set: " + owner); //Just used for checking
    }

    public static Owner getOwner() {
        return currentOwner;
    }

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void switchToLoginScreen() {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource("/bookstore/view/LoginScreen.fxml"));
            Scene scene = new Scene(root, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchToOwnerScreen() {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource("/bookstore/view/OwnerScreen.fxml"));
            Scene scene = new Scene(root, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchToBooksScreen() {
        loadScene("/bookstore/view/BookScreen.fxml");
    }

    public static void switchToCustomersScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/bookstore/view/CustomersScreen.fxml"));
            Parent root = loader.load();
            
            bookstore.controller.CustomersScreenController controller = loader.getController();
            controller.setOwner(currentOwner);

            primaryStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchToCustomerScreen(Customer customer) {
        try {

            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/bookstore/view/CustomerScreen.fxml"));
            Parent root = loader.load();

            CustomerScreenController controller = loader.getController();
            controller.setCustomer(customer);
            primaryStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchToCostScreen(Customer customer, double totalCost, boolean redeemed) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/bookstore/view/CostScreen.fxml"));
            Parent root = loader.load();
            CostScreenController controller = loader.getController();
            controller.setCustomer(customer, totalCost, redeemed);
            
            Scene scene = new Scene(root, 200, 200);
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadScene(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(SceneManager.class.getResource(fxmlPath));
            primaryStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

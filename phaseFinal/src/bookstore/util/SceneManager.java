package bookstore.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import bookstore.model.Customer;
import bookstore.controller.CostScreenController;
import bookstore.controller.CustomerScreenController;

public class SceneManager {
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void switchToLoginScreen() {
        loadScene("/bookstore/view/LoginScreen.fxml");
    }

    public static void switchToOwnerScreen() {
        loadScene("/bookstore/view/OwnerScreen.fxml");
    }

    public static void switchToBooksScreen() {
        loadScene("/bookstore/view/BooksScreen.fxml");
    }

    public static void switchToCustomersScreen() {
        loadScene("/bookstore/view/CustomersScreen.fxml");
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
            primaryStage.setScene(new Scene(root));
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
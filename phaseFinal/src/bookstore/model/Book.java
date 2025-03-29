package bookstore.model;

import javafx.scene.control.CheckBox;

public class Book {
    private String name;
    private double price;
    private CheckBox select; // Add CheckBox field

    // Constructor
    public Book(String name, double price) {
        this.name = name;
        this.price = price;
        this.select = new CheckBox(); // Initialize the CheckBox
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for the CheckBox
    public CheckBox getSelect() {
        return select;
    }

    // Setter for the CheckBox (optional)
    public void setSelect(CheckBox select) {
        this.select = select;
    }
}
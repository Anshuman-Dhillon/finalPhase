package bookstore.util;

import bookstore.model.Book;
import bookstore.model.Customer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    // Save books to books.txt
    public static void saveBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                writer.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load books from books.txt
    public static List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                books.add(new Book(parts[0], Double.parseDouble(parts[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Save customers to customers.txt
    public static void saveCustomers(List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt"))) {
            for (Customer customer : customers) {
                writer.write(customer.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load customers from customers.txt
    public static List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Customer customer = new Customer(parts[0], parts[1]);
                customer.setPoints(Integer.parseInt(parts[2]));
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
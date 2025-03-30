package bookstore.util;

import bookstore.model.Book;
import bookstore.model.Customer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    //Save books to books.txt
    public static void saveBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book b : books) {
                String line = b.getName() + "," + b.getPrice();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Load books from books.txt
    public static List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; //skip blank lines
                }
                String[] split = line.split(",");

                if (split.length < 2) {
                    System.out.println("Skip invalid book line: " + line);
                    continue;
                }

                String name = split[0];
                double price = Double.parseDouble(split[1]);

                books.add(new Book(name, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    //Save customers to customers.txt
    public static void saveCustomers(List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt"))) {
            for (Customer c : customers) {
                String line = c.getUsername() + "," + c.getPassword() + "," + c.getPoints();
                writer.write(line);
                writer.newLine(); //move to next line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Load customers from customers.txt
    public static List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; //skip blank lines
                }
                String[] split = line.split(",");

                if (split.length < 2) {
                    System.out.println("Skip invalid line: " + line);
                    continue;
                }

                String username = split[0];
                String password = split[1];
                int points = (split.length > 2) ? Integer.parseInt(split[2]) : 0;

                Customer c = new Customer(username, password);
                c.setPoints(points);
                customers.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
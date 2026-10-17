
import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println("-------------------------");
        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

public class InventoryManagementSystem {

    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Search product by ID
    static Product searchProduct(int id) {
        for (Product p : inventory) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    // Add product
    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        if (searchProduct(id) != null) {
            System.out.println("Product ID already exists!");
            return;
        }

        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        if (price < 0 || quantity < 0) {
            System.out.println("Price and quantity cannot be negative!");
            return;
        }

        inventory.add(new Product(id, name, price, quantity));
        System.out.println("Product added successfully!");
    }

    // Remove product
    static void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        int id = sc.nextInt();

        Product p = searchProduct(id);

        if (p != null) {
            inventory.remove(p);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Search product
    static void findProduct() {
        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();

        Product p = searchProduct(id);

        if (p != null) {
            p.display();
        } else {
            System.out.println("Product not found!");
        }
    }

    // Update product
    static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();

        Product p = searchProduct(id);

        if (p != null) {
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter New Quantity: ");
            int quantity = sc.nextInt();

            if (price < 0 || quantity < 0) {
                System.out.println("Invalid price or quantity!");
                return;
            }

            p.name = name;
            p.price = price;
            p.quantity = quantity;

            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Display all products
    static void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.println("\n===== PRODUCT LIST =====");

        for (Product p : inventory) {
            p.display();
        }
    }

    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Display All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    removeProduct();
                    break;

                case 3:
                    findProduct();
                    break;

                case 4:
                    updateProduct();
                    break;

                case 5:
                    displayProducts();
                    break;

                case 6:
                    System.out.println("Thank you! Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}

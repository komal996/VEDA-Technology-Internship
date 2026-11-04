
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Base class
class Service {
    private int id;
    private String name;
    private String category;
    private String description;
    private String status;

    public Service(int id, String name, String category,
                   String description, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void display() {
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
    }
}

// Training program class
class TrainingProgram extends Service {
    private int duration;
    private double fee;

    public TrainingProgram(int id, String name, String category,
                           String description, String status,
                           int duration, double fee) {
        super(id, name, category, description, status);
        this.duration = duration;
        this.fee = fee;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: Rs. " + fee);
    }
}

// Inheritance
class InternshipProgram extends TrainingProgram {
    private String technology;

    public InternshipProgram(int id, String name, String category,
                              String description, String status,
                              int duration, double fee,
                              String technology) {
        super(id, name, category, description, status, duration, fee);
        this.technology = technology;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Technology: " + technology);
    }
}

// Customer class
class Customer {
    private int customerId;
    private String name;
    private String email;

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + name);
        System.out.println("Email: " + email);
    }
}

// Inquiry class
class Inquiry {
    private int inquiryId;
    private Customer customer;
    private String message;
    private String status;

    public Inquiry(int inquiryId, Customer customer,
                   String message, String status) {
        this.inquiryId = inquiryId;
        this.customer = customer;
        this.message = message;
        this.status = status;
    }

    public int getInquiryId() {
        return inquiryId;
    }

    public String getStatus() {
        return status;
    }

    public void display() {
        System.out.println("\nInquiry ID: " + inquiryId);
        customer.display();
        System.out.println("Message: " + message);
        System.out.println("Status: " + status);
    }
}

// Main application
public class ServiceManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Service> services = new ArrayList<>();
    static ArrayList<Inquiry> inquiries = new ArrayList<>();

    static HashMap<Integer, Customer> customers = new HashMap<>();

    static int nextInquiryId = 104;

    // Synthetic sample data
    static void loadSampleData() {

        services.add(new Service(
                101, "Web Development",
                "IT Service",
                "Website development services",
                "Active"));

        services.add(new Service(
                102, "Software Development",
                "IT Service",
                "Custom software solutions",
                "Active"));

        services.add(new TrainingProgram(
                103, "Java Programming",
                "Training",
                "Core and advanced Java training",
                "Active", 3, 5000));

        services.add(new InternshipProgram(
                104, "Java Internship",
                "Internship",
                "Practical Java development training",
                "Active", 2, 3000, "Java"));

        Customer c1 = new Customer(
                201, "Rahul Sharma", "rahul@example.com");

        Customer c2 = new Customer(
                202, "Priya Patil", "priya@example.com");

        customers.put(201, c1);
        customers.put(202, c2);

        inquiries.add(new Inquiry(
                101, c1, "Interested in Java training", "Pending"));

        inquiries.add(new Inquiry(
                102, c2, "Need website development", "Resolved"));
    }

    // Display all services
    static void displayServices() {
        System.out.println("\n===== SERVICES AND PROGRAMS =====");

        for (Service service : services) {
            service.display();
            System.out.println("-----------------------------");
        }
    }

    // Add new service
    static void addService() {
        try {
            System.out.print("Enter Service ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            for (Service s : services) {
                if (s.getId() == id) {
                    System.out.println("Error: ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Category: ");
            String category = sc.nextLine().trim();

            System.out.print("Enter Description: ");
            String description = sc.nextLine().trim();

            if (name.isEmpty() || category.isEmpty()
                    || description.isEmpty()) {
                throw new IllegalArgumentException(
                        "Fields cannot be empty!");
            }

            services.add(new Service(
                    id, name, category, description, "Active"));

            System.out.println("Service added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID! Enter a number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Search service or program
    static void searchService() {
        System.out.print("Enter service name to search: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        boolean found = false;

        for (Service s : services) {
            if (s.getName().toLowerCase().contains(keyword)) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching service found!");
        }
    }

    // Filter by category
    static void filterServices() {
        System.out.print("Enter category (IT Service/Training/Internship): ");
        String category = sc.nextLine().trim();

        boolean found = false;

        for (Service s : services) {
            if (s.getCategory().equalsIgnoreCase(category)) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No records found in this category.");
        }
    }

    // Add customer inquiry
    static void addInquiry() {
        try {
            System.out.print("Enter Customer ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            Customer customer = customers.get(id);

            if (customer == null) {
                throw new IllegalArgumentException(
                        "Customer record not found!");
            }

            System.out.print("Enter Inquiry Message: ");
            String message = sc.nextLine().trim();

            if (message.isEmpty()) {
                throw new IllegalArgumentException(
                        "Inquiry message cannot be empty!");
            }

            Inquiry inquiry = new Inquiry(
                    nextInquiryId++, customer, message, "Pending");

            inquiries.add(inquiry);

            System.out.println("Inquiry added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid Customer ID!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Display inquiries
    static void displayInquiries() {
        System.out.println("\n===== CUSTOMER INQUIRIES =====");

        if (inquiries.isEmpty()) {
            System.out.println("No inquiries available.");
            return;
        }

        for (Inquiry inquiry : inquiries) {
            inquiry.display();
            System.out.println("-----------------------------");
        }
    }

    // Filter inquiries by status
    static void filterInquiries() {
        System.out.print("Enter status (Pending/Resolved): ");
        String status = sc.nextLine().trim();

        boolean found = false;

        for (Inquiry inquiry : inquiries) {
            if (inquiry.getStatus().equalsIgnoreCase(status)) {
                inquiry.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No inquiries found for this status.");
        }
    }

    // Basic reporting
    static void generateReport() {
        HashMap<String, Integer> categoryCount = new HashMap<>();

        int pending = 0;
        int resolved = 0;

        for (Service service : services) {
            String category = service.getCategory();

            categoryCount.put(
                    category,
                    categoryCount.getOrDefault(category, 0) + 1);
        }

        for (Inquiry inquiry : inquiries) {
            if (inquiry.getStatus().equalsIgnoreCase("Pending")) {
                pending++;
            } else if (inquiry.getStatus().equalsIgnoreCase("Resolved")) {
                resolved++;
            }
        }

        System.out.println("\n===== SYSTEM REPORT =====");
        System.out.println("Total Services/Programs: " + services.size());
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Inquiries: " + inquiries.size());
        System.out.println("Pending Inquiries: " + pending);
        System.out.println("Resolved Inquiries: " + resolved);

        System.out.println("\nCategory-wise Records:");

        for (Map.Entry<String, Integer> entry
                : categoryCount.entrySet()) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue());
        }
    }

    // Main menu
    public static void main(String[] args) {

        loadSampleData();

        int choice = 0;

        do {
            System.out.println("\n======================================");
            System.out.println("   SERVICE AND PROGRAM MANAGEMENT");
            System.out.println("======================================");
            System.out.println("1. View Services and Programs");
            System.out.println("2. Add New Service");
            System.out.println("3. Search Service");
            System.out.println("4. Filter Services by Category");
            System.out.println("5. Add Customer Inquiry");
            System.out.println("6. View Customer Inquiries");
            System.out.println("7. Filter Inquiries by Status");
            System.out.println("8. Generate System Report");
            System.out.println("9. Exit");
            System.out.println("======================================");

            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        displayServices();
                        break;

                    case 2:
                        addService();
                        break;

                    case 3:
                        searchService();
                        break;

                    case 4:
                        filterServices();
                        break;

                    case 5:
                        addInquiry();
                        break;

                    case 6:
                        displayInquiries();
                        break;

                    case 7:
                        filterInquiries();
                        break;

                    case 8:
                        generateReport();
                        break;

                    case 9:
                        System.out.println("Thank you for using the system!");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice! Select 1 to 9.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }

        } while (choice != 9);

        sc.close();
    }
}

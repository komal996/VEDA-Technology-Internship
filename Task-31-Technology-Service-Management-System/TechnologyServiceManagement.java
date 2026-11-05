
import java.util.*;

public class TechnologyServiceManagement {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Service> services = new ArrayList<>();
    static ArrayList<Program> programs = new ArrayList<>();
    static HashMap<Integer, Customer> customers = new HashMap<>();
    static ArrayList<Inquiry> inquiries = new ArrayList<>();
    static ArrayList<ServiceRequest> requests = new ArrayList<>();

    // Service class
    static class Service {
        int id;
        String name, category, description;
        double price;

        Service(int id, String name, String category,
                String description, double price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.description = description;
            this.price = price;
        }

        void display() {
            System.out.println(id + " | " + name + " | " +
                    category + " | " + description + " | Rs." + price);
        }
    }

    // Parent class for programs
    static abstract class Program {
        int id;
        String name;
        String duration;

        Program(int id, String name, String duration) {
            this.id = id;
            this.name = name;
            this.duration = duration;
        }

        abstract void display();
    }

    // Training program
    static class TrainingProgram extends Program {
        String technology;

        TrainingProgram(int id, String name, String duration,
                        String technology) {
            super(id, name, duration);
            this.technology = technology;
        }

        void display() {
            System.out.println(id + " | Training | " + name +
                    " | " + duration + " | " + technology);
        }
    }

    // Internship program
    static class InternshipProgram extends Program {
        String domain;

        InternshipProgram(int id, String name, String duration,
                          String domain) {
            super(id, name, duration);
            this.domain = domain;
        }

        void display() {
            System.out.println(id + " | Internship | " + name +
                    " | " + duration + " | " + domain);
        }
    }

    // Customer class
    static class Customer {
        int id;
        String name, email, phone;

        Customer(int id, String name, String email, String phone) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        void display() {
            System.out.println(id + " | " + name +
                    " | " + email + " | " + phone);
        }
    }

    // Inquiry class
    static class Inquiry {
        int id, customerId;
        String message, status;

        Inquiry(int id, int customerId, String message) {
            this.id = id;
            this.customerId = customerId;
            this.message = message;
            this.status = "Pending";
        }

        void display() {
            System.out.println(id + " | Customer ID: " +
                    customerId + " | " + message + " | " + status);
        }
    }

    // Service request class
    static class ServiceRequest {
        int id, customerId;
        String serviceName, status;

        ServiceRequest(int id, int customerId, String serviceName) {
            this.id = id;
            this.customerId = customerId;
            this.serviceName = serviceName;
            this.status = "Open";
        }

        void display() {
            System.out.println(id + " | Customer ID: " +
                    customerId + " | " + serviceName + " | " + status);
        }
    }

    // Sample synthetic data
    static void loadSampleData() {
        services.add(new Service(101, "Web Development",
                "Software", "Website development", 15000));

        services.add(new Service(102, "Cloud Computing",
                "Technology", "Cloud solutions", 20000));

        services.add(new Service(103, "Cyber Security",
                "Security", "Security consulting", 12000));

        programs.add(new TrainingProgram(201, "Java Training",
                "3 Months", "Java"));

        programs.add(new TrainingProgram(202, "Python Training",
                "2 Months", "Python"));

        programs.add(new InternshipProgram(301, "Web Development Internship",
                "3 Months", "Web Development"));

        programs.add(new InternshipProgram(302, "Java Internship",
                "2 Months", "Java"));

        customers.put(1, new Customer(1, "Rahul",
                "rahul@gmail.com", "9876543210"));

        customers.put(2, new Customer(2, "Priya",
                "priya@gmail.com", "9876543211"));

        inquiries.add(new Inquiry(401, 1,
                "Need information about Java training"));

        requests.add(new ServiceRequest(501, 2,
                "Web Development"));
    }

    // Add service
    static void addService() {
        try {
            System.out.print("Enter Service ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Service s : services) {
                if (s.id == id) {
                    System.out.println("Service ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Service Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Description: ");
            String description = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = Double.parseDouble(sc.nextLine());

            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative.");
            }

            services.add(new Service(id, name, category,
                    description, price));

            System.out.println("Service added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Display services
    static void displayServices() {
        System.out.println("\n--- AVAILABLE SERVICES ---");

        for (Service s : services) {
            s.display();
        }
    }

    // Add customer
    static void addCustomer() {
        try {
            System.out.print("Enter Customer ID: ");
            int id = Integer.parseInt(sc.nextLine());

            if (customers.containsKey(id)) {
                System.out.println("Customer ID already exists!");
                return;
            }

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            customers.put(id, new Customer(id, name, email, phone));

            System.out.println("Customer registered successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid customer ID!");
        }
    }

    // Display customers
    static void displayCustomers() {
        System.out.println("\n--- CUSTOMER DETAILS ---");

        for (Customer c : customers.values()) {
            c.display();
        }
    }

    // Add program
    static void addProgram() {
        try {
            System.out.println("1. Training Program");
            System.out.println("2. Internship Program");
            System.out.print("Select Program Type: ");

            int type = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Program ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Program p : programs) {
                if (p.id == id) {
                    System.out.println("Program ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Program Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Duration: ");
            String duration = sc.nextLine();

            if (type == 1) {
                System.out.print("Enter Technology: ");
                String technology = sc.nextLine();

                programs.add(new TrainingProgram(
                        id, name, duration, technology));

            } else if (type == 2) {
                System.out.print("Enter Domain: ");
                String domain = sc.nextLine();

                programs.add(new InternshipProgram(
                        id, name, duration, domain));

            } else {
                System.out.println("Invalid program type!");
                return;
            }

            System.out.println("Program added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers.");
        }
    }

    // Display programs
    static void displayPrograms() {
        System.out.println("\n--- TRAINING AND INTERNSHIP PROGRAMS ---");

        for (Program p : programs) {
            p.display();
        }
    }

    // Add inquiry
    static void addInquiry() {
        try {
            System.out.print("Enter Inquiry ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Inquiry i : inquiries) {
                if (i.id == id) {
                    System.out.println("Inquiry ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Customer ID: ");
            int customerId = Integer.parseInt(sc.nextLine());

            if (!customers.containsKey(customerId)) {
                System.out.println("Customer not found!");
                return;
            }

            System.out.print("Enter Inquiry Message: ");
            String message = sc.nextLine();

            inquiries.add(new Inquiry(id, customerId, message));

            System.out.println("Inquiry submitted successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }

    // Display inquiries
    static void displayInquiries() {
        System.out.println("\n--- CUSTOMER INQUIRIES ---");

        for (Inquiry i : inquiries) {
            i.display();
        }
    }

    // Add service request
    static void addRequest() {
        try {
            System.out.print("Enter Request ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (ServiceRequest r : requests) {
                if (r.id == id) {
                    System.out.println("Request ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Customer ID: ");
            int customerId = Integer.parseInt(sc.nextLine());

            if (!customers.containsKey(customerId)) {
                System.out.println("Customer not found!");
                return;
            }

            System.out.print("Enter Service Name: ");
            String serviceName = sc.nextLine();

            requests.add(new ServiceRequest(id, customerId, serviceName));

            System.out.println("Service request created successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }

    // Display service requests
    static void displayRequests() {
        System.out.println("\n--- SERVICE REQUESTS ---");

        for (ServiceRequest r : requests) {
            r.display();
        }
    }

    // Search and filter
    static void searchServices() {
        System.out.print("Enter service name or category: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Service s : services) {
            if (s.name.toLowerCase().contains(keyword) ||
                    s.category.toLowerCase().contains(keyword)) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching services found.");
        }
    }

    // Update inquiry status
    static void updateInquiry() {
        try {
            System.out.print("Enter Inquiry ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Inquiry i : inquiries) {
                if (i.id == id) {
                    System.out.print("Enter new status: ");
                    i.status = sc.nextLine();
                    System.out.println("Inquiry status updated!");
                    return;
                }
            }

            System.out.println("Inquiry not found!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid inquiry ID!");
        }
    }

    // Basic reports
    static void generateReport() {
        System.out.println("\n========== ORGANIZATION REPORT ==========");
        System.out.println("Total Services: " + services.size());
        System.out.println("Total Programs: " + programs.size());
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Inquiries: " + inquiries.size());
        System.out.println("Total Service Requests: " + requests.size());

        int pending = 0;

        for (Inquiry i : inquiries) {
            if (i.status.equalsIgnoreCase("Pending")) {
                pending++;
            }
        }

        int open = 0;

        for (ServiceRequest r : requests) {
            if (r.status.equalsIgnoreCase("Open")) {
                open++;
            }
        }

        System.out.println("Pending Inquiries: " + pending);
        System.out.println("Open Service Requests: " + open);
        System.out.println("=========================================");
    }

    // Main menu
    public static void main(String[] args) {

        loadSampleData();

        int choice = 0;

        do {
            System.out.println("\n======================================");
            System.out.println(" TECHNOLOGY SERVICE MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Service");
            System.out.println("2. Display Services");
            System.out.println("3. Add Customer");
            System.out.println("4. Display Customers");
            System.out.println("5. Add Training/Internship Program");
            System.out.println("6. Display Programs");
            System.out.println("7. Add Customer Inquiry");
            System.out.println("8. Display Inquiries");
            System.out.println("9. Add Service Request");
            System.out.println("10. Display Service Requests");
            System.out.println("11. Search Services");
            System.out.println("12. Update Inquiry Status");
            System.out.println("13. Generate Report");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: addService(); break;
                    case 2: displayServices(); break;
                    case 3: addCustomer(); break;
                    case 4: displayCustomers(); break;
                    case 5: addProgram(); break;
                    case 6: displayPrograms(); break;
                    case 7: addInquiry(); break;
                    case 8: displayInquiries(); break;
                    case 9: addRequest(); break;
                    case 10: displayRequests(); break;
                    case 11: searchServices(); break;
                    case 12: updateInquiry(); break;
                    case 13: generateReport(); break;
                    case 14:
                        System.out.println("Thank you for using the system!");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
            }

        } while (choice != 14);

        sc.close();
    }
}

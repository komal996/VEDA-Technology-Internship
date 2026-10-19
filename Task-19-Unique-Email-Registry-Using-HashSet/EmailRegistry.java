
import java.util.HashSet;
import java.util.Scanner;

public class EmailRegistry {

    static HashSet<String> emails = new HashSet<>();
    static Scanner sc = new Scanner(System.in);

    // Normalize email addresses
    public static String normalizeEmail(String email) {
        return email.trim().toLowerCase();
    }

    // Register a new email
    public static void registerEmail() {
        System.out.print("Enter email address: ");
        String email = normalizeEmail(sc.nextLine());

        if (email.isEmpty() || !email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            System.out.println("Invalid email address!");
            return;
        }

        if (emails.add(email)) {
            System.out.println("Email registered successfully!");
        } else {
            System.out.println("Duplicate email! Already registered.");
        }
    }

    // Remove an email
    public static void removeEmail() {
        System.out.print("Enter email to remove: ");
        String email = normalizeEmail(sc.nextLine());

        if (emails.remove(email)) {
            System.out.println("Email removed successfully!");
        } else {
            System.out.println("Email not found!");
        }
    }

    // Display all emails
    public static void displayEmails() {
        if (emails.isEmpty()) {
            System.out.println("No registered emails found.");
            return;
        }

        System.out.println("\nRegistered Email Addresses:");
        for (String email : emails) {
            System.out.println("- " + email);
        }

        System.out.println("Total Emails: " + emails.size());
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== UNIQUE EMAIL REGISTRY =====");
            System.out.println("1. Register Email");
            System.out.println("2. Remove Email");
            System.out.println("3. Display All Emails");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    registerEmail();
                    break;
                case 2:
                    removeEmail();
                    break;
                case 3:
                    displayEmails();
                    break;
                case 4:
                    System.out.println("Thank you for using Email Registry!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}

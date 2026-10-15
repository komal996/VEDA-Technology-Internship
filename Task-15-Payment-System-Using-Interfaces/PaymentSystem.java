
import java.util.Scanner;

// Payment Interface
interface Payment {
    void processPayment(double amount);
}

// Card Payment Implementation
class CardPayment implements Payment {
    public void processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount!");
            return;
        }

        System.out.println("Processing Card Payment...");
        System.out.println("Amount: Rs. " + amount);
        System.out.println("Card Payment Successful!");
    }
}

// UPI Payment Implementation
class UPIPayment implements Payment {
    public void processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount!");
            return;
        }

        System.out.println("Processing UPI Payment...");
        System.out.println("Amount: Rs. " + amount);
        System.out.println("UPI Payment Successful!");
    }
}

// Wallet Payment Implementation
class WalletPayment implements Payment {
    public void processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount!");
            return;
        }

        System.out.println("Processing Wallet Payment...");
        System.out.println("Amount: Rs. " + amount);
        System.out.println("Wallet Payment Successful!");
    }
}

// Main Class
public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment payment = null;

        System.out.println("===== PAYMENT SYSTEM =====");
        System.out.println("1. Card Payment");
        System.out.println("2. UPI Payment");
        System.out.println("3. Wallet Payment");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                payment = new CardPayment();
                break;
            case 2:
                payment = new UPIPayment();
                break;
            case 3:
                payment = new WalletPayment();
                break;
            case 4:
                System.out.println("Thank you!");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        System.out.print("Enter payment amount: ");

        if (!sc.hasNextDouble()) {
            System.out.println("Invalid amount!");
            sc.close();
            return;
        }

        double amount = sc.nextDouble();

        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Amount must be greater than zero!");
        } else {
            payment.processPayment(amount);
        }

        sc.close();
    }
}

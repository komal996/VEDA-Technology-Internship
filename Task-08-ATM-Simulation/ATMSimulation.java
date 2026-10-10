import java.util.Scanner;

class BankAccount {
    private double balance;
    private final int pin;

    public BankAccount(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount account = new BankAccount(10000, 1234);

        int attempts = 0;
        boolean authenticated = false;

        // PIN Authentication
        while (attempts < 3) {

            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (account.verifyPin(enteredPin)) {
                authenticated = true;
                System.out.println("PIN verified successfully!");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN.");

                if (attempts < 3) {
                    System.out.println(
                        "Attempts remaining: " + (3 - attempts)
                    );
                }
            }
        }

        if (!authenticated) {
            System.out.println("Too many incorrect attempts.");
            System.out.println("Account locked. Please try again later.");
            scanner.close();
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println(
                        "Current Balance: ₹" + account.getBalance()
                    );
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();

                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful!");
                        System.out.println(
                            "Updated Balance: ₹" + account.getBalance()
                        );
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawalAmount = scanner.nextDouble();

                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful!");
                        System.out.println(
                            "Remaining Balance: ₹" + account.getBalance()
                        );
                    } else if (withdrawalAmount > account.getBalance()) {
                        System.out.println(
                            "Insufficient balance. Withdrawal not allowed."
                        );
                    } else {
                        System.out.println("Invalid withdrawal amount.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }

        } while (choice != 4);

        scanner.close();
    }
}

import java.util.Scanner;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom Exception for Invalid Account
class InvalidAccountException extends Exception {
    public InvalidAccountException(String message) {
        super(message);
    }
}

// Custom Exception for Invalid Amount
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber,
                       String accountHolder,
                       double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void validateAccount(int accNo)
            throws InvalidAccountException {
        if (accNo != accountNumber) {
            throw new InvalidAccountException(
                "Invalid account number!");
        }
    }

    public void deposit(double amount)
            throws InvalidAmountException {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero!");
        }

        balance += amount;
        System.out.println("Deposit successful!");
        System.out.println("Current Balance: Rs. " + balance);
    }

    public void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (!Double.isFinite(amount) || amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero!");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance! Available: Rs. " + balance);
        }

        balance -= amount;
        System.out.println("Withdrawal successful!");
        System.out.println("Remaining Balance: Rs. " + balance);
    }

    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Available Balance: Rs. " + balance);
    }
}

// Main Class
public class BankExceptionHandling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account =
            new BankAccount(101, "Komal", 5000);

        int choice = 0;

        System.out.println("================================");
        System.out.println(" BANK ACCOUNT MANAGEMENT SYSTEM");
        System.out.println("================================");

        do {
            System.out.println("\n1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());

                if (choice >= 1 && choice <= 3) {

                    System.out.print("Enter Account Number: ");
                    int accNo = Integer.parseInt(
                        sc.nextLine().trim());

                    account.validateAccount(accNo);
                }

                switch (choice) {

                    case 1:
                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = Double.parseDouble(
                            sc.nextLine().trim());

                        account.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = Double.parseDouble(
                            sc.nextLine().trim());

                        account.withdraw(withdrawAmount);
                        break;

                    case 3:
                        account.displayBalance();
                        break;

                    case 4:
                        System.out.println(
                            "Thank you for using our Banking System!");
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Please try again.");
                }

            } catch (InvalidAccountException e) {
                System.out.println("Account Error: " + e.getMessage());

            } catch (InvalidAmountException e) {
                System.out.println("Amount Error: " + e.getMessage());

            } catch (InsufficientBalanceException e) {
                System.out.println("Balance Error: " + e.getMessage());

            } catch (NumberFormatException e) {
                System.out.println(
                    "Input Error: Please enter a valid number.");

            } catch (Exception e) {
                System.out.println(
                    "Unexpected Error: " + e.getMessage());
            }

        } while (choice != 4);

        sc.close();
    }
}

class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdrawal method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        }
    }

    // Balance method
    public double getBalance() {
        return balance;
    }

    // Display account details
    public void displayAccount() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount account =
                new BankAccount("1234567890", "Komal", 5000);

        account.displayAccount();

        account.deposit(2000);
        account.withdraw(1500);

        System.out.println("Final Balance: " + account.getBalance());
    }
}


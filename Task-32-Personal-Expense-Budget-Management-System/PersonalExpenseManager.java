import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

class Expense implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String title;
    String category;
    double amount;
    LocalDate date;

    Expense(int id, String title, String category,
            double amount, LocalDate date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String toString() {
        return "ID: " + id +
               " | Title: " + title +
               " | Category: " + category +
               " | Amount: Rs. " + amount +
               " | Date: " + date;
    }
}

public class PersonalExpenseManager {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Expense> expenses = new ArrayList<>();
    static HashMap<String, Double> budgets = new HashMap<>();

    static final String EXPENSE_FILE = "expenses.dat";
    static final String BUDGET_FILE = "budgets.dat";

    static int nextId = 1;

    // Load saved data
    @SuppressWarnings("unchecked")
    static void loadData() {
        try (ObjectInputStream in =
                new ObjectInputStream(new FileInputStream(EXPENSE_FILE))) {
            expenses = (ArrayList<Expense>) in.readObject();

            for (Expense e : expenses) {
                if (e.id >= nextId) {
                    nextId = e.id + 1;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Starting with a new expense record.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load expense data: " + e.getMessage());
        }

        try (ObjectInputStream in =
                new ObjectInputStream(new FileInputStream(BUDGET_FILE))) {
            budgets = (HashMap<String, Double>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous budgets found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load budgets: " + e.getMessage());
        }
    }

    // Save data
    static void saveData() {
        try (ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream(EXPENSE_FILE))) {
            out.writeObject(expenses);
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }

        try (ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream(BUDGET_FILE))) {
            out.writeObject(budgets);
        } catch (IOException e) {
            System.out.println("Error saving budgets: " + e.getMessage());
        }
    }

    static String readText(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }

    static double readAmount(String message) {
        while (true) {
            try {
                System.out.print(message);
                double amount = Double.parseDouble(sc.nextLine());

                if (amount <= 0) {
                    System.out.println("Amount must be greater than zero.");
                    continue;
                }
                return amount;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }

    static LocalDate readDate() {
        while (true) {
            try {
                System.out.print("Enter date (YYYY-MM-DD): ");
                return LocalDate.parse(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid date! Please try again.");
            }
        }
    }

    // Add expense
    static void addExpense() {
        System.out.println("\n--- Add Expense ---");

        String title = readText("Enter expense title: ");
        String category = readText("Enter category: ");
        double amount = readAmount("Enter amount: ");
        LocalDate date = readDate();

        Expense expense = new Expense(
                nextId++, title, category, amount, date);

        expenses.add(expense);
        saveData();

        System.out.println("Expense added successfully!");
    }

    // Display expenses
    static void viewExpenses() {
        System.out.println("\n--- All Expenses ---");

        if (expenses.isEmpty()) {
            System.out.println("No expenses available.");
            return;
        }

        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    // Edit expense
    static void editExpense() {
        System.out.print("Enter expense ID to edit: ");

        try {
            int id = Integer.parseInt(sc.nextLine());

            for (Expense e : expenses) {
                if (e.id == id) {
                    System.out.println("Current: " + e);

                    String title = readText("Enter new title: ");
                    String category = readText("Enter new category: ");
                    double amount = readAmount("Enter new amount: ");
                    LocalDate date = readDate();

                    e.title = title;
                    e.category = category;
                    e.amount = amount;
                    e.date = date;

                    saveData();
                    System.out.println("Expense updated successfully!");
                    return;
                }
            }

            System.out.println("Expense ID not found.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    // Delete expense
    static void deleteExpense() {
        System.out.print("Enter expense ID to delete: ");

        try {
            int id = Integer.parseInt(sc.nextLine());

            boolean removed = expenses.removeIf(e -> e.id == id);

            if (removed) {
                saveData();
                System.out.println("Expense deleted successfully!");
            } else {
                System.out.println("Expense ID not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    // Search expenses
    static void searchExpense() {
        String keyword = readText("Enter title or category to search: ")
                .toLowerCase();

        boolean found = false;

        for (Expense e : expenses) {
            if (e.title.toLowerCase().contains(keyword) ||
                e.category.toLowerCase().contains(keyword)) {

                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching expenses found.");
        }
    }

    // Set monthly budget
    static void setBudget() {
        System.out.print("Enter month (YYYY-MM): ");
        String month = sc.nextLine().trim();

        try {
            YearMonth.parse(month);
            double amount = readAmount("Enter monthly budget: ");

            budgets.put(month, amount);
            saveData();

            System.out.println("Monthly budget set successfully!");

        } catch (Exception e) {
            System.out.println("Invalid month! Use YYYY-MM.");
        }
    }

    // Monthly report
    static void monthlyReport() {
        System.out.print("Enter month (YYYY-MM): ");
        String month = sc.nextLine().trim();

        try {
            YearMonth selectedMonth = YearMonth.parse(month);
            double total = 0;

            HashMap<String, Double> categoryTotals = new HashMap<>();

            System.out.println("\n--- Monthly Expense Report ---");

            for (Expense e : expenses) {
                if (YearMonth.from(e.date).equals(selectedMonth)) {
                    System.out.println(e);

                    total += e.amount;

                    categoryTotals.put(
                        e.category,
                        categoryTotals.getOrDefault(e.category, 0.0)
                                + e.amount
                    );
                }
            }

            System.out.println("\nTotal Expenses: Rs. " + total);

            System.out.println("\n--- Category-wise Summary ---");

            if (categoryTotals.isEmpty()) {
                System.out.println("No expenses recorded for this month.");
            } else {
                for (String category : categoryTotals.keySet()) {
                    System.out.println(category + ": Rs. "
                            + categoryTotals.get(category));
                }
            }

            if (budgets.containsKey(month)) {
                double budget = budgets.get(month);

                System.out.println("\nMonthly Budget: Rs. " + budget);
                System.out.println("Remaining Budget: Rs. "
                        + (budget - total));

                if (total > budget) {
                    System.out.println("Warning: Monthly budget exceeded!");
                } else {
                    System.out.println("You are within your budget.");
                }
            } else {
                System.out.println("\nNo budget set for this month.");
            }

        } catch (Exception e) {
            System.out.println("Invalid month! Use YYYY-MM.");
        }
    }

    // Main menu
    public static void main(String[] args) {

        loadData();

        int choice = 0;

        do {
            System.out.println("\n==================================");
            System.out.println(" PERSONAL EXPENSE & BUDGET SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Edit Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Search Expense");
            System.out.println("6. Set Monthly Budget");
            System.out.println("7. Generate Monthly Report");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addExpense();
                        break;

                    case 2:
                        viewExpenses();
                        break;

                    case 3:
                        editExpense();
                        break;

                    case 4:
                        deleteExpense();
                        break;

                    case 5:
                        searchExpense();
                        break;

                    case 6:
                        setBudget();
                        break;

                    case 7:
                        monthlyReport();
                        break;

                    case 8:
                        saveData();
                        System.out.println("Thank you for using the system!");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
            }

        } while (choice != 8);

        sc.close();
    }
}

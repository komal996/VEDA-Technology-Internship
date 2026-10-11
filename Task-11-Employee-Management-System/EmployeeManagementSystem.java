
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department,
                    double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void updateEmployee(String name, String department,
                               double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("-------------------------");
    }
}

public class EmployeeManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();

    public static Employee searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    public static double readSalary() {
        while (true) {
            System.out.print("Enter Salary: ");
            try {
                double salary =
                    Double.parseDouble(sc.nextLine().trim());
                if (Double.isFinite(salary) && salary >= 0) {
                    return salary;
                }
            } catch (NumberFormatException e) {
                // Ask again
            }
            System.out.println("Enter a valid non-negative salary.");
        }
    }

    public static String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    public static void addEmployee() {
        int id = readInt("Enter Employee ID: ");

        if (searchEmployee(id) != null) {
            System.out.println("Employee ID already exists!");
            return;
        }

        String name = readText("Enter Name: ");
        String department = readText("Enter Department: ");
        double salary = readSalary();

        employees.add(new Employee(id, name, department, salary));
        System.out.println("Employee added successfully!");
    }

    public static void findEmployee() {
        int id = readInt("Enter Employee ID to Search: ");
        Employee emp = searchEmployee(id);

        if (emp != null) {
            emp.displayEmployee();
        } else {
            System.out.println("Employee not found!");
        }
    }

    public static void updateEmployee() {
        int id = readInt("Enter Employee ID to Update: ");
        Employee emp = searchEmployee(id);

        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        String name = readText("Enter New Name: ");
        String department = readText("Enter New Department: ");
        double salary = readSalary();

        emp.updateEmployee(name, department, salary);
        System.out.println("Employee updated successfully!");
    }

    public static void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        System.out.println("\n--- Employee List ---");
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. List All Employees");
            System.out.println("5. Exit");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    findEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    listEmployees();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

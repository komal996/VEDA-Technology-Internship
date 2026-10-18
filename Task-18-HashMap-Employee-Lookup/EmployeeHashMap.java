
import java.util.HashMap;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("------------------------");
    }
}

public class EmployeeHashMap {

    static HashMap<Integer, Employee> employees = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("\n===== EMPLOYEE LOOKUP SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Enter a number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    displayEmployees();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }

    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (employees.containsKey(id)) {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        employees.put(id, new Employee(id, name, department, salary));
        System.out.println("Employee added successfully!");
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee emp = employees.get(id);

        if (emp != null) {
            System.out.println("Employee Found:");
            emp.display();
        } else {
            System.out.println("Employee not found!");
        }
    }

    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee emp = employees.get(id);

        if (emp != null) {
            System.out.print("Enter New Name: ");
            emp.name = sc.nextLine();

            System.out.print("Enter New Department: ");
            emp.department = sc.nextLine();

            System.out.print("Enter New Salary: ");
            emp.salary = sc.nextDouble();
            sc.nextLine();

            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (employees.remove(id) != null) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available!");
        } else {
            System.out.println("\n===== EMPLOYEE DETAILS =====");
            for (Employee emp : employees.values()) {
                emp.display();
            }
        }
    }
}

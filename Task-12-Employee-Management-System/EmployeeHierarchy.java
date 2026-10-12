
class Employee {
    protected int id;
    protected String name;
    protected double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }

    public void work() {
        System.out.println(name + " is working.");
    }
}

// Child Class 1: Developer
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(int id, String name, double salary,
                     String programmingLanguage) {
        super(id, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: "
                           + programmingLanguage);
    }

    @Override
    public void work() {
        System.out.println(name + " is developing software using "
                           + programmingLanguage + ".");
    }
}

// Child Class 2: Manager
class Manager extends Employee {
    private int teamSize;

    public Manager(int id, String name, double salary, int teamSize) {
        super(id, name, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }

    @Override
    public void work() {
        System.out.println(name + " is managing a team of "
                           + teamSize + " employees.");
    }
}

// Child Class 3: Intern
class Intern extends Employee {
    private int internshipDuration;

    public Intern(int id, String name, double salary,
                  int internshipDuration) {
        super(id, name, salary);
        this.internshipDuration = internshipDuration;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: "
                           + internshipDuration + " months");
    }

    @Override
    public void work() {
        System.out.println(name + " is learning and working on "
                           + "internship tasks.");
    }
}

// Main Class
public class EmployeeHierarchy {
    public static void main(String[] args) {

        Employee[] employees = {
            new Developer(101, "Rahul", 50000, "Java"),
            new Manager(102, "Priya", 75000, 8),
            new Intern(103, "Amit", 10000, 6)
        };

        System.out.println("===== EMPLOYEE HIERARCHY SYSTEM =====");

        for (Employee emp : employees) {
            System.out.println("\n---------------------------");
            emp.displayDetails();
            emp.work();
        }

        System.out.println("\nProgram executed successfully!");
    }
}

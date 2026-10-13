
class Employee {
    void displayRole() {
        System.out.println("Employee works in the company.");
    }
}

class Developer extends Employee {
    @Override
    void displayRole() {
        System.out.println("Developer writes and maintains code.");
    }
}

class Manager extends Employee {
    @Override
    void displayRole() {
        System.out.println("Manager manages the team and projects.");
    }
}

class Tester extends Employee {
    @Override
    void displayRole() {
        System.out.println("Tester tests software and finds bugs.");
    }
}

public class RuntimePolymorphism {
    public static void main(String[] args) {

        Employee emp;

        System.out.println("===== RUNTIME POLYMORPHISM =====");

        emp = new Developer();
        emp.displayRole();

        emp = new Manager();
        emp.displayRole();

        emp = new Tester();
        emp.displayRole();

        System.out.println("===============================");
    }
}

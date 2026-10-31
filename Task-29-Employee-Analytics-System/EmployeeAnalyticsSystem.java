
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " +
               department + " | Rs." + salary;
    }
}

public class EmployeeAnalyticsSystem {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(101, "Rahul", "IT", 50000),
            new Employee(102, "Priya", "HR", 45000),
            new Employee(103, "Amit", "IT", 70000),
            new Employee(104, "Sneha", "Finance", 60000),
            new Employee(105, "Komal", "IT", 80000),
            new Employee(106, "Neha", "HR", 55000),
            new Employee(107, "Rohit", "Finance", 65000),
            new Employee(108, "Pooja", "Sales", 40000)
        );

        System.out.println("====================================");
        System.out.println("     EMPLOYEE ANALYTICS SYSTEM");
        System.out.println("====================================");

        // 1. Display all employees
        System.out.println("\n1. ALL EMPLOYEES");

        employees.forEach(System.out::println);

        // 2. Total employee count
        long totalEmployees = employees.stream().count();

        System.out.println("\n2. TOTAL EMPLOYEES");
        System.out.println("Total: " + totalEmployees);

        // 3. Average salary
        double averageSalary = employees.stream()
                .collect(Collectors.averagingDouble(
                        Employee::getSalary));

        System.out.println("\n3. AVERAGE SALARY");
        System.out.printf("Rs. %.2f%n", averageSalary);

        // 4. Highest-paid employee
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(
                        Employee::getSalary));

        System.out.println("\n4. HIGHEST PAID EMPLOYEE");
        highestPaid.ifPresent(System.out::println);

        // 5. Lowest-paid employee
        Optional<Employee> lowestPaid = employees.stream()
                .min(Comparator.comparingDouble(
                        Employee::getSalary));

        System.out.println("\n5. LOWEST PAID EMPLOYEE");
        lowestPaid.ifPresent(System.out::println);

        // 6. Department-wise employee count
        Map<String, Long> departmentCount = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.counting()));

        System.out.println("\n6. DEPARTMENT-WISE EMPLOYEE COUNT");

        departmentCount.forEach((department, count) ->
                System.out.println(department + " : " + count));

        // 7. Department-wise average salary
        Map<String, Double> departmentAverage = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.averagingDouble(
                                Employee::getSalary)));

        System.out.println("\n7. DEPARTMENT-WISE AVERAGE SALARY");

        departmentAverage.forEach((department, avg) ->
                System.out.printf("%s : Rs. %.2f%n",
                        department, avg));

        // 8. Department-wise total salary
        Map<String, Double> departmentSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        TreeMap::new,
                        Collectors.summingDouble(
                                Employee::getSalary)));

        System.out.println("\n8. DEPARTMENT-WISE TOTAL SALARY");

        departmentSalary.forEach((department, total) ->
                System.out.printf("%s : Rs. %.2f%n",
                        department, total));

        // 9. Employee ranking by salary
        System.out.println("\n9. EMPLOYEE SALARY RANKING");

        List<Employee> rankedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(
                        Employee::getSalary).reversed())
                .collect(Collectors.toList());

        int rank = 1;

        for (Employee employee : rankedEmployees) {
            System.out.println(rank + ". " + employee);
            rank++;
        }

        // 10. Total salary expense
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        // 11. Department count
        long totalDepartments = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .count();

        // 12. Summary report
        System.out.println("\n====================================");
        System.out.println("          SUMMARY REPORT");
        System.out.println("====================================");

        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Total Departments: " + totalDepartments);

        System.out.printf("Total Salary: Rs. %.2f%n",
                totalSalary);

        System.out.printf("Average Salary: Rs. %.2f%n",
                averageSalary);

        highestPaid.ifPresent(emp ->
                System.out.println("Highest Paid: " +
                        emp.getName()));

        lowestPaid.ifPresent(emp ->
                System.out.println("Lowest Paid: " +
                        emp.getName()));

        System.out.println("====================================");
        System.out.println("Analytics Completed Successfully!");
    }
}

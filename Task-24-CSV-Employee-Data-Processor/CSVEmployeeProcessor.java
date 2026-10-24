import java.io.*;
import java.util.*;

public class CSVEmployeeProcessor {

    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department,
                 double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        String inputFile = "employees.csv";
        String outputFile = "processed_employees.csv";

        List<Employee> employees = new ArrayList<>();
        Set<Integer> employeeIds = new HashSet<>();

        int validRecords = 0;
        int invalidRecords = 0;
        double totalSalary = 0;
        double highestSalary = Double.NEGATIVE_INFINITY;
        double lowestSalary = Double.POSITIVE_INFINITY;

        System.out.println("================================");
        System.out.println(" CSV EMPLOYEE DATA PROCESSOR");
        System.out.println("================================");

        try (BufferedReader br =
                 new BufferedReader(new FileReader(inputFile))) {

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                if (lineNumber == 1) {
                    continue; // Skip header
                }

                try {
                    String[] data = line.split(",", -1);

                    if (data.length != 4) {
                        throw new IllegalArgumentException(
                            "Incorrect number of fields");
                    }

                    for (String field : data) {
                        if (field.trim().isEmpty()) {
                            throw new IllegalArgumentException(
                                "Missing field");
                        }
                    }

                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String department = data[2].trim();
                    double salary =
                        Double.parseDouble(data[3].trim());

                    if (id <= 0 || salary < 0 ||
                        !Double.isFinite(salary)) {
                        throw new IllegalArgumentException(
                            "Invalid ID or salary");
                    }

                    if (employeeIds.contains(id)) {
                        throw new IllegalArgumentException(
                            "Duplicate employee ID");
                    }

                    Employee emp = new Employee(
                        id, name, department, salary);

                    employees.add(emp);
                    employeeIds.add(id);

                    validRecords++;
                    totalSalary += salary;

                    highestSalary =
                        Math.max(highestSalary, salary);
                    lowestSalary =
                        Math.min(lowestSalary, salary);

                } catch (IllegalArgumentException e) {
                    invalidRecords++;

                    System.out.println(
                        "Invalid record at line " +
                        lineNumber + ": " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println(
                "Error reading CSV: " + e.getMessage());
            return;
        }

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(outputFile))) {

            writer.println(
                "ID,Name,Department,Salary,SalaryCategory");

            for (Employee emp : employees) {

                String category;

                if (emp.salary >= 70000) {
                    category = "High";
                } else if (emp.salary >= 40000) {
                    category = "Medium";
                } else {
                    category = "Low";
                }

                writer.printf(
                    Locale.US,
                    "%d,%s,%s,%.2f,%s%n",
                    emp.id,
                    emp.name,
                    emp.department,
                    emp.salary,
                    category);
            }

        } catch (IOException e) {
            System.out.println(
                "Error writing CSV: " + e.getMessage());
            return;
        }

        System.out.println("\n----- EMPLOYEE STATISTICS -----");
        System.out.println("Valid Records   : " + validRecords);
        System.out.println("Invalid Records : " + invalidRecords);
        System.out.printf(
            "Total Salary    : %.2f%n", totalSalary);

        if (validRecords > 0) {
            System.out.printf(
                "Average Salary  : %.2f%n",
                totalSalary / validRecords);
            System.out.printf(
                "Highest Salary  : %.2f%n",
                highestSalary);
            System.out.printf(
                "Lowest Salary   : %.2f%n",
                lowestSalary);
        } else {
            System.out.println("No valid employee records.");
        }

        System.out.println(
            "\nProcessed CSV created successfully!");
        System.out.println("Output File: " + outputFile);
    }
}

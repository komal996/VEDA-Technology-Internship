Task 29 – Employee Analytics System Using Java Streams

Project Overview
This task focuses on analyzing employee records using Java Streams and Collectors. The system calculates salary statistics, identifies the highest-paid employee, groups employees by department, counts employees, and ranks employees by salary.
Objective
Apply Java Stream API operations to a realistic employee analytics problem and generate a readable summary report.

Technologies Used
- Java (JDK 8 or later)
- Java Stream API
- Collections Framework
- Collectors.groupingBy()
- Collectors.averagingDouble()
- Comparator
Features
- Calculate average salary across employees
- Identify the highest-paid employee
- Display department-wise employee counts
- Calculate department-wise average salary
- Rank employees by salary
- Generate a summary report
Suggested Project Structure
Task-29-Employee-Analytics-System-Using-Streams/
├── EmployeeAnalyticsSystem.java
└── README.md

How to Run
Open PowerShell in the task folder, then run:
javac -d . EmployeeAnalyticsSystem.java
java -cp . EmployeeAnalyticsSystem
Note: The commands assume your Java source file is named EmployeeAnalyticsSystem.java and contains the main class EmployeeAnalyticsSystem. Update the commands if your actual filename or class name differs.

Java Streams Concepts
- stream() to process employee records
- mapToDouble() and average() to calculate average salary
- max() with Comparator.comparingDouble() to find the highest salary
- Collectors.groupingBy() to group records by department
- Collectors.counting() to count employees
- sorted() to rank employees by salary
Expected Report Sections
1. Total number of employees
2. Overall average salary
3. Highest-paid employee
4. Department-wise employee counts and average salaries
5. Employee salary ranking
Interview Questions and Answers
1. What is Collectors.groupingBy()?
It groups stream elements according to a classifier function and returns a map of groups. It can also combine grouping with downstream collectors such as counting() or averagingDouble().

2. How do you find the maximum salary using Streams?
Use employees.stream().mapToDouble(Employee::getSalary).max() or employees.stream().max(Comparator.comparingDouble(Employee::getSalary)) to retrieve the highest-paid employee.

3. When should Streams not be used?
Avoid Streams when a simple loop is clearer, when complex stateful modifications are required, or when debugging and performance constraints favor imperative code.

Learning Outcomes
This task helps develop skills in functional-style Java programming, Stream operations, grouping, aggregation, sorting, and reporting.

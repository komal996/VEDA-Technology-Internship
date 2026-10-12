# Task 12: Implement Inheritance with an Employee Hierarchy

## VEDA Technology – Java Programming Internship

### Project Overview
This project demonstrates the concept of **Inheritance in Java** by implementing an Employee Hierarchy System.

The program contains a base `Employee` class and three specialized child classes: `Developer`, `Manager`, and `Intern`.

Each child class inherits common properties and methods from the parent class and implements its own specialized behavior.

## Objective
- Understand inheritance and code reusability in Java.
- Implement parent and child classes using `extends`.
- Demonstrate method overriding.
- Understand runtime polymorphism.
- Develop a structured employee hierarchy.

## Technologies Used
- Programming Language: Java
- IDE: Visual Studio Code
- JDK: Java Development Kit
- Version Control: Git and GitHub

## Features
- Base Employee class with common attributes.
- Developer class with programming language details.
- Manager class with team size details.
- Intern class with internship duration.
- Method overriding using `@Override`.
- Constructor chaining using `super()`.
- Runtime polymorphism using an Employee array.
- Displays employee details and specialized work activities.

## Class Structure

**1. Employee (Parent Class)**

Common attributes:
- Employee ID
- Employee Name
- Salary

Common methods:
- `displayDetails()`
- `work()`

**2. Developer (Child Class)**

- Inherits Employee properties.
- Stores programming language.
- Displays software development activities.

**3. Manager (Child Class)**

- Inherits Employee properties.
- Stores team size.
- Displays team management activities.

**4. Intern (Child Class)**

- Inherits Employee properties.
- Stores internship duration.
- Displays internship learning activities.

## OOP Concepts Implemented

**Inheritance:** Child classes inherit common properties and methods from the Employee class.

**Method Overriding:** Each child class overrides `displayDetails()` and `work()` to provide specialized behavior.

**Polymorphism:** An array of Employee references stores Developer, Manager, and Intern objects.

**Code Reusability:** Common employee properties and methods are defined in the parent class.

## How to Run the Project

**Step 1:** Open the project folder in VS Code.

**Step 2:** Open the terminal.

**Step 3:** Compile the Java program.

```bash
javac -d . EmployeeHierarchy.java
```

**Step 4:** Run the program.

```bash
java -cp . EmployeeHierarchy
```

## Sample Output

```text
===== EMPLOYEE HIERARCHY SYSTEM =====

---------------------------
Employee ID: 101
Name: Rahul
Salary: 50000.0
Programming Language: Java
Rahul is developing software using Java.

---------------------------
Employee ID: 102
Name: Priya
Salary: 75000.0
Team Size: 8
Priya is managing a team of 8 employees.

---------------------------
Employee ID: 103
Name: Amit
Salary: 10000.0
Internship Duration: 6 months
Amit is learning and working on internship tasks.

Program executed successfully!
```

## Learning Outcomes
Through this task, I learned:

- How inheritance works in Java.
- How to create parent and child classes.
- How to use `extends` and `super`.
- How to override methods.
- How polymorphism improves flexibility.
- How inheritance supports code reusability.

## Conclusion
Successfully implemented and executed an Employee Hierarchy System using Java.

The project demonstrates inheritance, method overriding, runtime polymorphism, and code reusability through the Employee, Developer, Manager, and Intern classes.


# Task 19 - Unique Email Registry Using HashSet

## VEDA Technology Internship

**Internship Track:** Java Programming  
**Task Number:** 19  
**Project Name:** Unique Email Registry Using HashSet  
**Programming Language:** Java  
**Concept Used:** HashSet, Collections Framework

## Project Description

This project is a Java-based Unique Email Registry System developed as part of the VEDA Technology Internship.

The system allows users to register email addresses, detect duplicate registrations, remove existing emails, and display all registered emails.

It uses Java HashSet to ensure that every registered email address is unique.

## Objective

- Understand HashSet in Java.
- Learn how to store unique elements.
- Prevent duplicate email registrations.
- Implement email registration and removal.
- Practice Java Collections Framework.

## Technologies Used

- Java
- HashSet
- Scanner Class
- Java Collections Framework
- VS Code
- JDK

## Features

1. Email Registration
   - Register new email addresses.
   - Store unique email addresses.

2. Duplicate Detection
   - Prevent duplicate email registration.
   - Display a warning for duplicate emails.

3. Email Removal
   - Remove existing email addresses.
   - Display a message if an email is not found.

4. Display Registered Emails
   - Show all registered email addresses.
   - Display the total number of emails.

5. Email Normalization
   - Convert emails to lowercase.
   - Remove extra spaces before and after emails.

## Project Structure

Task-19-Unique-Email-Registry-Using-HashSet/
|
|-- EmailRegistry.java
|-- README.md

## How to Run

### Step 1: Open Project Folder

```powershell
cd "D:\Calculator\Task-19-Unique-Email-Registry-Using-HashSet"
```

### Step 2: Compile Java Program

```powershell
javac -d . EmailRegistry.java
```

### Step 3: Run Java Program

```powershell
java -cp . EmailRegistry
```

## Sample Output

```text
===== UNIQUE EMAIL REGISTRY =====
1. Register Email
2. Remove Email
3. Display All Emails
4. Exit

Enter your choice: 1
Enter email address: komal@gmail.com
Email registered successfully!

Enter your choice: 1
Enter email address: KOMAL@gmail.com
Duplicate email! Already registered.

Enter your choice: 3

Registered Email Addresses:
- komal@gmail.com

Total Emails: 1

Enter your choice: 2
Enter email to remove: komal@gmail.com
Email removed successfully!

Enter your choice: 4
Thank you for using Email Registry!
```

Note: The menu is displayed again before each choice.
HashSet does not guarantee the order of emails.

## Concepts Learned

- HashSet in Java
- Java Collections Framework
- Duplicate prevention
- String normalization
- Conditional statements
- Loops and switch-case
- Scanner class
- Methods and input validation

## Advantages

- Prevents duplicate registrations.
- Provides efficient email lookup.
- Easy to use and maintain.
- Demonstrates practical use of HashSet.
- Supports email registration and removal.






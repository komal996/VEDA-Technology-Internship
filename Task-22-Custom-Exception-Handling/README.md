# Task 22: Implement Custom Exception Handling in Java

## VEDA Technology Internship

**Track:** Java Programming  
**Level:** 1  
**Day:** 22  
**Task:** Implement Custom Exception Handling  
**Language:** Java

## Project Overview

This project implements a Bank Account Management System using Java Custom Exception Handling. The system allows users to deposit money, withdraw money, and check account balances while handling invalid banking operations through user-defined exceptions.

## Objective

- Understand exception handling in Java.
- Create and implement custom exception classes.
- Learn the use of `try`, `catch`, `throw`, and `throws`.
- Handle insufficient balance, invalid account numbers, and invalid transaction amounts.
- Display meaningful error messages.
- Improve program reliability and error handling.

## Features

1. Deposit money into a bank account.
2. Withdraw money from a bank account.
3. Check available account balance.
4. Validate account numbers.
5. Prevent withdrawals exceeding the available balance.
6. Reject negative and zero transaction amounts.
7. Handle invalid numeric inputs.
8. Display user-friendly error messages.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Custom Exceptions
- Exception Handling
- Scanner Class
- VS Code
- Git and GitHub

## Custom Exception Classes

### 1. InsufficientBalanceException

This exception is thrown when the withdrawal amount exceeds the available account balance.

### 2. InvalidAccountException

This exception is thrown when the user enters an incorrect account number.

### 3. InvalidAmountException

This exception is thrown when the user enters a negative, zero, or otherwise invalid transaction amount.

All three custom exception classes extend Java's `Exception` class.

## Project Structure

```text
Task-22-Custom-Exception-Handling/
│
├── BankExceptionHandling.java
└── README.md
```

## How to Run

**Step 1:** Open the project folder.

```powershell
cd "D:\Calculator\Task-22-Custom-Exception-Handling"
```

**Step 2:** Compile the Java program.

```powershell
javac -d . BankExceptionHandling.java
```

**Step 3:** Run the Java program.

```powershell
java -cp . BankExceptionHandling
```

## Sample Output

```text
================================
 BANK ACCOUNT MANAGEMENT SYSTEM
================================

1. Deposit Money
2. Withdraw Money
3. Check Balance
4. Exit

Enter your choice: 1
Enter Account Number: 101
Enter Deposit Amount: 2000

Deposit successful!
Current Balance: Rs. 7000.0
```

### Insufficient Balance Exception

```text
Enter your choice: 2
Enter Account Number: 101
Enter Withdrawal Amount: 10000

Balance Error: Insufficient balance!
Available: Rs. 7000.0
```

### Invalid Account Exception

```text
Enter your choice: 3
Enter Account Number: 999

Account Error: Invalid account number!
```

### Invalid Amount Exception

```text
Enter your choice: 1
Enter Account Number: 101
Enter Deposit Amount: -500

Amount Error: Deposit amount must be greater than zero!
```

## Test Cases

| Test Case | Input | Expected Result |
|---|---|---|
| Valid Deposit | 2000 | Deposit Successful |
| Valid Withdrawal | 1500 | Withdrawal Successful |
| Insufficient Balance | 10000 | InsufficientBalanceException |
| Invalid Account | 999 | InvalidAccountException |
| Negative Amount | -500 | InvalidAmountException |
| Zero Amount | 0 | InvalidAmountException |
| Invalid Input | abc | Input Error |

## Interview Questions and Answers

### Q1. What is the difference between checked and unchecked exceptions?

Checked exceptions are checked by the compiler and must be handled or declared. Unchecked exceptions are subclasses of RuntimeException and do not require mandatory handling.

### Q2. What is a custom exception?

A custom exception is a user-defined exception class created by extending the Exception or RuntimeException class.

### Q3. What is finally in Java?

The `finally` block is generally executed after try-catch, regardless of whether an exception occurs. It is commonly used for resource cleanup.

### Q4. When should RuntimeException be used?

RuntimeException should be used for unchecked errors, such as invalid arguments or programming mistakes, where callers are not required to catch the exception.

## Learning Outcomes

Through this task, I learned:

- How to create custom exception classes.
- How checked exceptions work in Java.
- How to use try-catch blocks.
- How to use throw and throws.
- How to validate banking transactions.
- How to handle invalid user inputs.
- How exception handling improves application reliability.

## Conclusion

Successfully implemented a Bank Account Management System using Java Custom Exception Handling. This project demonstrates how to manage banking operations safely by validating inputs, throwing custom exceptions, and displaying meaningful error messages.




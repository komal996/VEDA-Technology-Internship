Task 15 – Payment System Using Interfaces
Project Overview
This Java console application demonstrates how to build a simple payment system using an interface. Users can choose between Card, UPI, and Wallet payments and enter an amount to simulate a transaction.
Note: This is an educational simulation. It does not process real payments or connect to a bank or payment gateway.

Objective
- Understand and implement Java interfaces.
- Demonstrate runtime polymorphism through a common Payment reference.
- Keep payment methods separate and easy to extend.
- Validate user input before processing a simulated payment.

Features
- Card payment simulation
- UPI payment simulation
- Wallet payment simulation
- Menu-driven console interface
- Validation of payment amount and menu selection
- Clear success and error messages

Technologies Used
- Java
- Object-Oriented Programming (OOP)
- VS Code
- JDK and PowerShell terminal

Java Concepts Used
- Interface: Payment declares the processPayment(double amount) method.
- Implementation: CardPayment, UPIPayment, and WalletPayment implement that interface.
- Runtime polymorphism: A Payment reference calls the implementation selected at runtime.
- Switch statement: Selects the payment method.
- Scanner: Reads input from the console.
Project Structure
Task-15-Payment-System-Using-Interfaces/
├── PaymentSystem.java
└── README.md
How to Run
Open a terminal in the task folder:
cd D:\Calculator\Task-15-Payment-System-Using-Interfaces
Compile the program:
javac -d . PaymentSystem.java
Run it:
java -cp . PaymentSystem
Sample Output
===== PAYMENT SYSTEM =====
1. Card Payment
2. UPI Payment
3. Wallet Payment
4. Exit
Enter your choice: 2
Enter payment amount: 1000
Processing UPI Payment...
Amount: Rs. 1000.0
UPI Payment Successful!

What I Learned
This task helped me understand how interfaces define common behavior, how different classes provide their own implementations, and how runtime polymorphism makes Java programs flexible and maintainable.
Conclusion
The Payment System project successfully demonstrates Java interfaces and runtime polymorphism with three simulated payment methods. It also practices basic input validation and menu-driven programming.

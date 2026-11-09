# Task 32 – Personal Expense & Budget Management System

## Project Overview
The Personal Expense & Budget Management System is a Java console-based application designed to help users manage their daily expenses and monthly budgets.

## Features
- Add new expenses.
- View all expenses.
- Edit existing expenses.
- Delete expenses.
- Search expenses by title or category.
- Set monthly budgets.
- Generate monthly expense reports.
- Calculate category-wise expenses.
- Track remaining budgets.
- Save and load data using file handling.

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- ArrayList
- HashMap
- LocalDate and YearMonth
- File Handling
- Exception Handling

## Project Structure

Task-32-Personal-Expense-Budget-Management-System/
│
├── PersonalExpenseManager.java
└── README.md


## How to Run

**Step 1: Compile the program**
```bash
javac -d . PersonalExpenseManager.java
```

**Step 2: Run the program**
```bash
java -cp . PersonalExpenseManager
```

## Menu Options
1. Add Expense
2. View All Expenses
3. Edit Expense
4. Delete Expense
5. Search Expense
6. Set Monthly Budget
7. Generate Monthly Report
8. Exit

## Data Storage
The application uses file handling and serialization to save expense records and monthly budgets.

- `expenses.dat` – Stores expense records.
- `budgets.dat` – Stores monthly budget information.

These files are generated automatically when data is saved.

## Learning Outcomes
- Improved Java programming skills.
- Practiced OOP concepts.
- Learned Java Collections Framework.
- Implemented file handling and serialization.
- Improved exception handling and input validation.

## Conclusion
This project demonstrates the practical application of Java concepts in developing a Personal Expense & Budget Management System. It helps users track expenses, manage budgets, and generate monthly financial summaries.


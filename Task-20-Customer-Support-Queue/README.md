
# Task 20 - Customer Support Queue

## VEDA Technology - Java Programming Internship

### Project Overview
The Customer Support Queue is a console-based Java application
designed to manage customer support tickets efficiently.

The system uses the Queue interface and ArrayDeque class to
process customer tickets in FIFO (First In, First Out) order.

## Objective
To implement a customer support ticket management system
using Java Collections and understand FIFO queue operations.

## Technologies Used
- Java
- Java Collections Framework
- Queue Interface
- ArrayDeque
- ArrayList
- Scanner Class
- VS Code

## Features
1. Create Support Ticket
   - Enter customer name and issue.
   - Generate a unique ticket ID.
   - Set initial status to Pending.

2. View Pending Tickets
   - Display all pending support requests.

3. Process Next Ticket
   - Process tickets using FIFO.
   - Update ticket status to Resolved.

4. Check Ticket Status
   - Search for a ticket using its ID.
   - Display ticket details and current status.

5. View All Tickets
   - Display both pending and resolved tickets.

6. Exit
   - Safely exit the application.

## Concepts Implemented
- Object-Oriented Programming
- Classes and Objects
- Queue Data Structure
- FIFO Principle
- ArrayDeque
- ArrayList
- Loops and Conditional Statements
- Exception Handling
- Methods

## Project Structure

Task-20-Customer-Support-Queue/
    CustomerSupportQueue.java
    README.md

## How to Run

### Step 1: Open the Project Folder

cd "D:\Calculator\Task-20-Customer-Support-Queue"

### Step 2: Compile the Program

javac -d . CustomerSupportQueue.java

### Step 3: Run the Program

java -cp . CustomerSupportQueue

## Sample Output

================================
   CUSTOMER SUPPORT QUEUE
================================

1. Create Support Ticket
2. View Pending Tickets
3. Process Next Ticket
4. Check Ticket Status
5. View All Tickets
6. Exit

Enter your choice: 1

Enter Customer Name: Rahul
Enter Issue: Login Problem

Ticket created successfully!
Your Ticket ID: 101

Enter your choice: 3

Ticket processed successfully!

Ticket ID: 101
Customer Name: Rahul
Issue: Login Problem
Status: Resolved

## Learning Outcomes
- Understood FIFO queue processing.
- Learned Queue and ArrayDeque operations.
- Implemented customer support ticket management.
- Practiced Java Collections Framework.
- Improved Java programming and problem-solving skills.



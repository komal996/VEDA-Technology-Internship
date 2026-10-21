# Task 21: Stack-Based Undo System

## VEDA Technology – Java Programming Internship

### Project Overview
This project implements a simple text editor simulation using Java. It allows users to add text, delete characters, display current text, and undo previous editing operations using a stack.

The project demonstrates the **LIFO (Last In, First Out)** principle and stack-based state management.

## Objective
- Understand stack data structures.
- Implement undo functionality using Java Deque.
- Store previous text states.
- Support multiple undo operations.
- Practice Java collections and menu-driven programming.

## Technologies Used
- **Language:** Java
- **Collection Framework:** Deque, ArrayDeque
- **IDE:** Visual Studio Code
- **Concepts:** Stack, LIFO, Methods, Loops, Switch-Case

## Features
1. **Add Text:** Append new text to the editor.
2. **Delete Text:** Remove characters from the end of the text.
3. **Undo Operation:** Restore the previous text state.
4. **Multiple Undo:** Undo several editing operations.
5. **Display Text:** Show the current editor content.
6. **Exit:** Close the application.

## Project Structure

```text
Task-21-Stack-Based-Undo-System/
├── StackBasedUndoSystem.java
└── README.md
```

## How to Run

**Step 1: Compile the program**

```bash
javac -d . StackBasedUndoSystem.java
```

**Step 2: Execute the program**

```bash
java -cp . StackBasedUndoSystem
```

## Sample Output

```text
===== STACK-BASED UNDO SYSTEM =====

1. Add Text
2. Delete Text
3. Undo
4. Display Text
5. Exit

Enter your choice: 1
Enter text: Hello
Text added successfully!

Enter your choice: 1
Enter text:  Java
Text added successfully!

Enter your choice: 4
Current Text: Hello Java

Enter your choice: 3
Undo successful!

Enter your choice: 4
Current Text: Hello
```

## Working Principle

The application uses `Deque<String>` implemented by `ArrayDeque` to store previous text states.

- `push()` saves the current text before editing.
- `pop()` retrieves the most recent previous state.
- `isEmpty()` checks whether an undo operation is available.

This follows the **Last In, First Out (LIFO)** principle.

## Learning Outcomes
- Understood stack-based state management.
- Implemented text editing operations.
- Learned Java Deque and ArrayDeque.
- Implemented multiple undo functionality.
- Improved problem-solving and Java programming skills.

## Conclusion

Successfully developed a Stack-Based Undo System using Java. This project demonstrates how stack data structures can manage editing history and restore previous states efficiently.



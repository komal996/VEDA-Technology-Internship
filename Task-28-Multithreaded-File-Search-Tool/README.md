# Task 28 – Multithreaded File Search Tool

## VEDA Technology Internship – Java Development

### Project Overview

This project is a **Multithreaded File Search Tool** developed using Java. It searches multiple text files for a specified keyword using multiple worker threads.

The application uses **ExecutorService**, **Callable**, **Future**, and **Java File I/O** to perform concurrent file searching efficiently.

It also compares sequential and multithreaded execution times.

## Objective

To apply Java multithreading concepts to a practical file-processing problem by implementing an efficient keyword search utility.

## Technologies Used

- Java
- ExecutorService
- Callable and Future
- Multithreading
- Java File I/O
- Exception Handling
- VS Code
- Git and GitHub

## Features

- Searches multiple text files for a keyword.
- Uses a fixed thread pool.
- Supports case-insensitive keyword searching.
- Displays matching file names and line numbers.
- Displays matching lines.
- Compares sequential and multithreaded execution times.
- Handles file-reading errors.
- Collects results safely using Future objects.
- Limits the number of worker threads.

## Project Structure

```text
Task-28-Multithreaded-File-Search-Tool/
│
├── MultithreadedFileSearch.java
├── README.md
│
└── files/
    ├── file1.txt
    ├── file2.txt
    └── file3.txt
```

## How to Run

**Step 1: Open PowerShell**

```powershell
cd D:\Calculator\Task-28-Multithreaded-File-Search-Tool
```

**Step 2: Compile the Java program**

```powershell
javac -d . MultithreadedFileSearch.java
```

**Step 3: Run the program**

```powershell
java -cp . MultithreadedFileSearch
```

**Step 4:** Enter the keyword you want to search.

## Sample Output

```text
====================================
   MULTITHREADED FILE SEARCH TOOL
====================================
Enter keyword to search: Java

Total files: 3

--- SEARCH RESULTS ---
File: file1.txt | Line: 1 | Text: Java is a programming language.
File: file1.txt | Line: 2 | Text: Java supports multithreading.
File: file2.txt | Line: 2 | Text: Java provides ExecutorService.
File: file2.txt | Line: 3 | Text: Java is platform independent.
File: file3.txt | Line: 2 | Text: Java supports file handling.

--- PERFORMANCE ---
Sequential Time: 2.150 ms
Multithreaded Time: 4.320 ms
Total Matches: 5
```

*Note: Execution times are illustrative and depend on system performance and file size.*

## How It Works

1. The user enters a keyword.
2. The application identifies text files in the `files` directory.
3. Sequential searching processes files one by one.
4. ExecutorService creates a fixed pool of worker threads.
5. Each worker searches an assigned file.
6. Future objects collect the results.
7. Matching lines are displayed with file names and line numbers.
8. Execution times are compared.


## Learning Outcomes

Through this task, I learned:

- How to implement multithreading in Java.
- How to use ExecutorService and fixed thread pools.
- How to implement Callable and Future.
- How to read and process multiple files.
- How to compare sequential and parallel execution.
- How to collect concurrent task results safely.
- How to handle file-processing exceptions.

## Conclusion

Task 28 helped me understand practical Java concurrency by developing a multithreaded file search utility. This project strengthened my knowledge of thread pools, file handling, task execution, and performance measurement.




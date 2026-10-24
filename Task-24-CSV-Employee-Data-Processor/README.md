# Task 24: CSV Employee Data Processor

## Project Overview
The CSV Employee Data Processor is a Java application developed as part of the VEDA Technology Internship. It reads employee records from a CSV file, validates the data, calculates salary statistics, and generates a processed output CSV file.

## Objectives
- Read employee records from a CSV file.
- Validate employee data and identify invalid records.
- Handle missing fields and incorrect data types.
- Calculate employee salary statistics.
- Generate a processed CSV output file.

## Technologies Used
- **Programming Language:** Java
- **Data Format:** CSV (Comma-Separated Values)
- **File Handling:** Java File I/O
- **Collections:** ArrayList and HashSet

## Project Structure

```text
Task-24-CSV-Employee-Data-Processor/
├── CSVEmployeeProcessor.java
├── employees.csv
├── processed_employees.csv
└── README.md
```

## Features
1. Reads employee records from a CSV file.
2. Validates employee IDs, names, departments, and salaries.
3. Detects missing fields and duplicate employee IDs.
4. Handles invalid records without stopping the entire program.
5. Calculates total, average, highest, and lowest salaries.
6. Categorizes salaries as High, Medium, or Low.
7. Generates a processed employee CSV file.

## Input CSV Format

The input file, `employees.csv`, uses the following columns:

```csv
ID,Name,Department,Salary
101,Rahul,IT,50000
102,Priya,HR,60000
103,Amit,Finance,45000
```

## How to Run the Project

### Step 1: Open the project folder

Open PowerShell in this directory.

### Step 2: Compile the Java program

```powershell
javac -d . CSVEmployeeProcessor.java
```

### Step 3: Run the program

```powershell
java -cp . CSVEmployeeProcessor
```

### Step 4: View the output

The program generates `processed_employees.csv` containing valid employee records and their salary categories.

## Sample Output

```text
CSV EMPLOYEE DATA PROCESSOR

Valid Records   : 8
Invalid Records : 2
Total Salary    : 440000.00
Average Salary  : 55000.00
Highest Salary  : 80000.00
Lowest Salary   : 35000.00

Processed CSV created successfully!
Output File: processed_employees.csv
```

*Note: Output depends on the contents of the input CSV file.*

## Validation and Error Handling
- Missing fields are rejected.
- Invalid numeric values are rejected.
- Duplicate employee IDs are rejected.
- Non-positive employee IDs and negative or non-finite salaries are rejected.
- Invalid records are reported, and processing continues.

## Learning Outcomes
- Understanding Java file handling.
- Reading and processing CSV files.
- Implementing validation and exception handling.
- Using Java collections to track employee IDs and records.
- Calculating statistics from structured data.

## Conclusion
This project demonstrates how Java can be used to process structured employee data efficiently, validate records, calculate useful statistics, and generate output files. It improved my practical understanding of Java programming and file handling.

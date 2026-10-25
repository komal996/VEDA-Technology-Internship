# Task 25: Log File Analyzer

## VEDA Technology Internship

### Project Overview
The Log File Analyzer is a Java-based application that reads log files, analyzes log messages, counts different log levels, and generates a summary report. It uses File I/O for reading and writing files and HashMap for efficient counting and error analysis.

### Objectives
- Read log data from a text file.
- Count INFO, WARNING, and ERROR messages.
- Identify invalid log entries.
- Summarize repeated error messages.
- Generate an analysis report in a text file.

### Technologies Used
- **Programming Language:** Java
- **Concepts:** File I/O, BufferedReader, FileWriter, HashMap, Exception Handling
- **Tools:** VS Code, PowerShell, JDK

### Project Structure
```text
Task-25-Log-File-Analyzer/
├── LogFileAnalyzer.java
├── application.log
├── log_report.txt
└── README.md
```

### How to Run the Project

**Step 1: Open the project directory**
```powershell
cd D:\Calculator\Task-25-Log-File-Analyzer
```

**Step 2: Compile the Java program**
```powershell
javac -d . LogFileAnalyzer.java
```

**Step 3: Run the program**
```powershell
java -cp . LogFileAnalyzer
```

### Sample Log Format
```text
2026-10-25T09:00:00 INFO Application started
2026-10-25T09:10:00 WARNING Low memory
2026-10-25T09:15:00 ERROR Database connection failed
```

Each valid log entry contains a timestamp, log level, and message.

### Features
1. Reads a log file line by line.
2. Counts INFO, WARNING, and ERROR entries.
3. Detects malformed or unknown log levels.
4. Groups identical error messages using HashMap.
5. Creates `log_report.txt` with the analysis results.
6. Handles missing files and file-reading errors.

### Sample Output
```text
========== LOG ANALYSIS REPORT ==========
Total Lines     : 10
INFO Messages   : 4
WARNING Messages: 2
ERROR Messages  : 3
Invalid Lines   : 1

========== ERROR SUMMARY ==========
Database connection failed : 2 occurrence(s)
File not found : 1 occurrence(s)
=========================================
Report generated: log_report.txt
```

**Note:** The invalid entry in the sample data is reported as an unknown log level. The order of error-summary entries may vary.

### Learning Outcomes
- Practiced Java file handling.
- Learned to use HashMap for counting and grouping data.
- Improved exception-handling skills.
- Learned to process and validate structured log data.
- Generated reports from input files.


### Conclusion
This project demonstrates how Java can be used to analyze application logs, identify errors, count log levels, and generate reports efficiently.

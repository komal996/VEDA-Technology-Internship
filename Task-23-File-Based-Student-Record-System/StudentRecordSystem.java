
import java.io.*;
import java.util.*;

public class StudentRecordSystem {

    private static final String FILE_NAME = "students.txt";
    private static final Scanner sc = new Scanner(System.in);

    // Student class
    static class Student {
        int id;
        String name;
        int age;
        String course;

        Student(int id, String name, int age, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.course = course;
        }

        @Override
        public String toString() {
            return id + "," + name + "," + age + "," + course;
        }
    }

    // Read student records from file
    public static ArrayList<Student> readStudents() {
        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader br =
                 new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", -1);

                if (data.length == 4) {
                    try {
                        int id = Integer.parseInt(data[0]);
                        String name = data[1];
                        int age = Integer.parseInt(data[2]);
                        String course = data[3];

                        students.add(
                            new Student(id, name, age, course)
                        );
                    } catch (NumberFormatException e) {
                        System.out.println(
                            "Skipping invalid student record."
                        );
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: "
                               + e.getMessage());
        }

        return students;
    }

    // Save all records to file
    public static void saveStudents(
            ArrayList<Student> students) {

        try (BufferedWriter bw =
                 new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {
                bw.write(student.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving file: "
                               + e.getMessage());
        }
    }

    // Add student
    public static void addStudent() {
        ArrayList<Student> students = readStudents();

        System.out.print("Enter Student ID: ");
        int id = readInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = readInt();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        if (name.trim().isEmpty() ||
            course.trim().isEmpty() ||
            age <= 0 ||
            name.contains(",") ||
            course.contains(",")) {
            System.out.println("Invalid student details!");
            return;
        }

        students.add(new Student(id, name, age, course));
        saveStudents(students);

        System.out.println("Student added successfully!");
    }

    // View all students
    public static void viewStudents() {
        ArrayList<Student> students = readStudents();

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n----- STUDENT RECORDS -----");

        for (Student s : students) {
            displayStudent(s);
        }
    }

    // Search student
    public static void searchStudent() {
        ArrayList<Student> students = readStudents();

        System.out.print("Enter Student ID to Search: ");
        int id = readInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student Found!");
                displayStudent(s);
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Update student
    public static void updateStudent() {
        ArrayList<Student> students = readStudents();

        System.out.print("Enter Student ID to Update: ");
        int id = readInt();

        for (Student s : students) {
            if (s.id == id) {

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Age: ");
                int age = readInt();

                System.out.print("Enter New Course: ");
                String course = sc.nextLine();

                if (name.trim().isEmpty() ||
                    course.trim().isEmpty() ||
                    age <= 0 ||
                    name.contains(",") ||
                    course.contains(",")) {
                    System.out.println("Invalid details!");
                    return;
                }

                s.name = name;
                s.age = age;
                s.course = course;

                saveStudents(students);

                System.out.println(
                    "Student record updated successfully!"
                );
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Display student details
    public static void displayStudent(Student s) {
        System.out.println("----------------------");
        System.out.println("ID     : " + s.id);
        System.out.println("Name   : " + s.name);
        System.out.println("Age    : " + s.age);
        System.out.println("Course : " + s.course);
    }

    // Safe integer input
    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print(
                    "Invalid number. Enter again: "
                );
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        int choice = 0;

        do {
            System.out.println(
                "\n===== STUDENT RECORD SYSTEM ====="
            );
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    System.out.println(
                        "Thank you! Program exited."
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Try again."
                    );
            }

        } while (choice != 5);

        sc.close();
    }
}

import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    // Maximum number of students
    static final int MAX_STUDENTS = 100;

    // Arrays to store student information
    static int[] studentIds = new int[MAX_STUDENTS];
    static String[] studentNames = new String[MAX_STUDENTS];
    static int[] studentAges = new int[MAX_STUDENTS];

    // Number of students currently stored
    static int studentCount = 0;

    // ================= ADD STUDENT =================
    public static void addStudent() {

        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student limit reached!");
            return;
        }

        System.out.println("\n----- Add Student -----");

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        // Check for duplicate ID
        if (findStudent(id) != -1) {
            System.out.println("Student ID already exists!");
            return;
        }

        sc.nextLine(); // Clear input buffer

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        // Validate age
        if (age <= 0 || age > 100) {
            System.out.println("Invalid age! Please enter an age between 1 and 100.");
            return;
        }

        // Store student information
        studentIds[studentCount] = id;
        studentNames[studentCount] = name;
        studentAges[studentCount] = age;

        studentCount++;

        System.out.println("\nStudent added successfully!");
    }

    // ================= SEARCH STUDENT =================
    public static void searchStudent() {

        System.out.println("\n----- Search Student -----");

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        int index = findStudent(id);

        if (index == -1) {
            System.out.println("Student not found!");
        } else {
            System.out.println("\nStudent Found!");
            System.out.println("--------------------");
            System.out.println("ID   : " + studentIds[index]);
            System.out.println("Name : " + studentNames[index]);
            System.out.println("Age  : " + studentAges[index]);
        }
    }

    // ================= UPDATE STUDENT =================
    public static void updateStudent() {

        System.out.println("\n----- Update Student -----");

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        int index = findStudent(id);

        if (index == -1) {
            System.out.println("Student not found!");
            return;
        }

        sc.nextLine(); // Clear input buffer

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();

        if (age <= 0 || age > 100) {
            System.out.println("Invalid age!");
            return;
        }

        studentNames[index] = name;
        studentAges[index] = age;

        System.out.println("\nStudent updated successfully!");
    }

    // ================= DISPLAY STUDENTS =================
    public static void displayStudents() {

        System.out.println("\n----- All Student Records -----");

        if (studentCount == 0) {
            System.out.println("No student records available.");
            return;
        }

        System.out.printf("%-10s %-20s %-10s%n",
                "ID", "Name", "Age");

        System.out.println("------------------------------------------");

        for (int i = 0; i < studentCount; i++) {

            System.out.printf("%-10d %-20s %-10d%n",
                    studentIds[i],
                    studentNames[i],
                    studentAges[i]);
        }
    }

    // ================= FIND STUDENT =================
    public static int findStudent(int id) {

        for (int i = 0; i < studentCount; i++) {

            if (studentIds[i] == id) {
                return i;
            }
        }

        return -1;
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    searchStudent();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    System.out.println("\nThank you for using Student Management System!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please enter 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
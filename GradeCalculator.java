import java.util.Scanner;

public class GradeCalculator {

    // Method to calculate total marks
    public static int calculateTotal(int[] marks) {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    // Method to calculate percentage
    public static double calculatePercentage(int total, int numberOfSubjects) {
        return (double) total / (numberOfSubjects * 100) * 100;
    }

    // Method to calculate grade
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("=================================");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Validate number of subjects
        while (numberOfSubjects <= 0) {
            System.out.println("Invalid number of subjects.");
            System.out.print("Enter a valid number of subjects: ");
            numberOfSubjects = scanner.nextInt();
        }

        int[] marks = new int[numberOfSubjects];

        // Input marks
        for (int i = 0; i < numberOfSubjects; i++) {

            while (true) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");
                int mark = scanner.nextInt();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                } else {
                    System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                }
            }
        }

        // Calculate results
        int total = calculateTotal(marks);
        double percentage = calculatePercentage(total, numberOfSubjects);
        String grade = calculateGrade(percentage);

        // Display result
        System.out.println();
        System.out.println("=================================");
        System.out.println("          STUDENT RESULT");
        System.out.println("=================================");
        System.out.println("Student Name : " + name);
        System.out.println("Total Marks  : " + total + "/" + (numberOfSubjects * 100));
        System.out.printf("Percentage   : %.2f%%%n", percentage);
        System.out.println("Grade        : " + grade);
        System.out.println("=================================");

        scanner.close();
    }
}
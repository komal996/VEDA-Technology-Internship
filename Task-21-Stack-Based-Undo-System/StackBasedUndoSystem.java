
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackBasedUndoSystem {

    private static String text = "";

    private static final Deque<String> undoStack =
            new ArrayDeque<>();

    // Add text
    public static void addText(String newText) {
        undoStack.push(text);
        text += newText;
        System.out.println("Text added successfully!");
    }

    // Delete characters
    public static void deleteText(int count) {

        if (count <= 0 || count > text.length()) {
            System.out.println("Invalid number of characters!");
            return;
        }

        undoStack.push(text);

        text = text.substring(0, text.length() - count);

        System.out.println("Text deleted successfully!");
    }

    // Undo previous operation
    public static void undo() {

        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
        } else {
            text = undoStack.pop();
            System.out.println("Undo successful!");
        }
    }

    // Display current text
    public static void displayText() {
        System.out.println("Current Text: " + text);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println(
            "===== STACK-BASED UNDO SYSTEM ====="
        );

        do {
            System.out.println("\n1. Add Text");
            System.out.println("2. Delete Text");
            System.out.println("3. Undo");
            System.out.println("4. Display Text");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter text: ");
                    String newText = sc.nextLine();
                    addText(newText);
                    break;

                case 2:
                    System.out.print(
                        "Enter number of characters to delete: "
                    );

                    if (sc.hasNextInt()) {
                        int count = sc.nextInt();
                        sc.nextLine();
                        deleteText(count);
                    } else {
                        System.out.println("Invalid number!");
                        sc.nextLine();
                    }
                    break;

                case 3:
                    undo();
                    break;

                case 4:
                    displayText();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using Undo System!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}

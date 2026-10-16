
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

class Book {
    int id;
    String title;
    String author;
    boolean available = true;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(id + " | " + title + " | " +
                author + " | " +
                (available ? "Available" : "Issued"));
    }
}

class Member {
    int id;
    String name;

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class IssueRecord {
    int bookId;
    int memberId;
    LocalDate issueDate;
    LocalDate dueDate;

    IssueRecord(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(14);
    }
}

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static HashMap<Integer, Book> books = new HashMap<>();
    static HashMap<Integer, Member> members = new HashMap<>();
    static HashMap<Integer, IssueRecord> issued =
            new HashMap<>();

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (books.containsKey(id)) {
            System.out.println("Book ID already exists!");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.put(id, new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n--- Book List ---");
        for (Book b : books.values()) {
            b.display();
        }
    }

    static void addMember() {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (members.containsKey(id)) {
            System.out.println("Member ID already exists!");
            return;
        }

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        members.put(id, new Member(id, name));
        System.out.println("Member registered successfully!");
    }

    static void viewMembers() {
        System.out.println("\n--- Member List ---");

        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        for (Member m : members.values()) {
            System.out.println(m.id + " | " + m.name);
        }
    }

    static void searchBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book b = books.get(id);

        if (b == null) {
            System.out.println("Book not found!");
        } else {
            b.display();
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();

        Book book = books.get(bookId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!members.containsKey(memberId)) {
            System.out.println("Member not found!");
            return;
        }

        if (!book.available) {
            System.out.println("Book already issued!");
            return;
        }

        IssueRecord record =
                new IssueRecord(bookId, memberId);

        issued.put(bookId, record);
        book.available = false;

        System.out.println("Book issued successfully!");
        System.out.println("Issue Date: " + record.issueDate);
        System.out.println("Due Date: " + record.dueDate);
    }

    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        IssueRecord record = issued.get(bookId);

        if (record == null) {
            System.out.println("Book is not issued!");
            return;
        }

        LocalDate returnDate = LocalDate.now();

        long overdueDays = ChronoUnit.DAYS.between(
                record.dueDate, returnDate);

        long fine = 0;

        if (overdueDays > 0) {
            fine = overdueDays * 5;
        }

        books.get(bookId).available = true;
        issued.remove(bookId);

        System.out.println("Book returned successfully!");
        System.out.println("Overdue Days: " +
                Math.max(0, overdueDays));
        System.out.println("Fine: Rs. " + fine);
    }

    static void viewIssuedBooks() {
        if (issued.isEmpty()) {
            System.out.println("No issued books.");
            return;
        }

        for (IssueRecord r : issued.values()) {
            long overdue = ChronoUnit.DAYS.between(
                    r.dueDate, LocalDate.now());

            System.out.println(
                    "Book ID: " + r.bookId +
                    " | Member ID: " + r.memberId +
                    " | Due Date: " + r.dueDate +
                    " | Overdue Days: " +
                    Math.max(0, overdue));
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println(
                    "\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Search Book");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. View Issued Books");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: addMember(); break;
                case 4: viewMembers(); break;
                case 5: searchBook(); break;
                case 6: issueBook(); break;
                case 7: returnBook(); break;
                case 8: viewIssuedBooks(); break;
                case 9:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

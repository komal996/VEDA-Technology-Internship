
import java.util.*;

class Ticket {
    int ticketId;
    String customerName;
    String issue;
    String status;

    Ticket(int ticketId, String customerName, String issue) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issue = issue;
        this.status = "Pending";
    }

    void displayTicket() {
        System.out.println("-----------------------------");
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Issue: " + issue);
        System.out.println("Status: " + status);
    }
}

public class CustomerSupportQueue {

    static Queue<Ticket> ticketQueue = new ArrayDeque<>();
    static ArrayList<Ticket> allTickets = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextTicketId = 101;

    // Create a new support ticket
    static void createTicket() {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Issue: ");
        String issue = sc.nextLine().trim();

        if (name.isEmpty() || issue.isEmpty()) {
            System.out.println("Name and issue cannot be empty!");
            return;
        }

        Ticket ticket = new Ticket(nextTicketId++, name, issue);

        ticketQueue.offer(ticket);
        allTickets.add(ticket);

        System.out.println("\nTicket created successfully!");
        System.out.println("Your Ticket ID: " + ticket.ticketId);
    }

    // Display pending tickets
    static void viewPendingTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
            return;
        }

        System.out.println("\n===== PENDING TICKETS =====");

        for (Ticket ticket : ticketQueue) {
            ticket.displayTicket();
        }
    }

    // Process next ticket using FIFO
    static void processNextTicket() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No tickets to process.");
            return;
        }

        Ticket ticket = ticketQueue.poll();
        ticket.status = "Resolved";

        System.out.println("\nTicket processed successfully!");
        ticket.displayTicket();
    }

    // Search ticket and display status
    static void checkTicketStatus() {
        System.out.print("Enter Ticket ID: ");

        int id = readChoice();

        for (Ticket ticket : allTickets) {
            if (ticket.ticketId == id) {
                ticket.displayTicket();
                return;
            }
        }

        System.out.println("Ticket not found!");
    }

    // Display all tickets
    static void viewAllTickets() {
        if (allTickets.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }

        System.out.println("\n===== ALL TICKETS =====");

        for (Ticket ticket : allTickets) {
            ticket.displayTicket();
        }
    }

    // Safely read integer input
    static int readChoice() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter a number: ");
            }
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   CUSTOMER SUPPORT QUEUE");
            System.out.println("================================");
            System.out.println("1. Create Support Ticket");
            System.out.println("2. View Pending Tickets");
            System.out.println("3. Process Next Ticket");
            System.out.println("4. Check Ticket Status");
            System.out.println("5. View All Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = readChoice();

            switch (choice) {
                case 1:
                    createTicket();
                    break;

                case 2:
                    viewPendingTickets();
                    break;

                case 3:
                    processNextTicket();
                    break;

                case 4:
                    checkTicketStatus();
                    break;

                case 5:
                    viewAllTickets();
                    break;

                case 6:
                    System.out.println(
                        "Thank you for using Customer Support Queue!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}

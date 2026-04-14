import java.util.Scanner;

// Passenger class to store details
class Passenger {
    private String name;
    private int passengerId;

    public Passenger(String name, int passengerId) {
        this.name = name;
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public int getPassengerId() {
        return passengerId;
    }
}

// Flight class to manage seat allocation
class Flight {
    // Fixed number of seats using final keyword
    private final int TOTAL_SEATS = 10;
    private Passenger[] seats;
    private int bookedCount;

    public Flight() {
        // Initializing seat array using constructor
        seats = new Passenger[TOTAL_SEATS];
        bookedCount = 0;
    }

    // Method to check availability and book a seat
    public void bookSeat(String name, int id) {
        if (bookedCount >= TOTAL_SEATS) {
            System.out.println("Error: Flight is full! No seats available.");
            return;
        }

        // Check for duplicate booking
        for (int i = 0; i < bookedCount; i++) {
            if (seats[i].getPassengerId() == id) {
                System.out.println("Booking Failed: Passenger ID " + id + " already has a reservation.");
                return;
            }
        }

        // Assign seat and increment count
        seats[bookedCount] = new Passenger(name, id);
        bookedCount++;
        System.out.println("Success: Seat booked successfully for " + name + " (ID: " + id + ").");
    }

    // Method to display seat status
    public void displaySeatStatus() {
        System.out.println("\n--- Flight Seat Status ---");
        System.out.println("Total Seats: " + TOTAL_SEATS);
        System.out.println("Booked: " + bookedCount);
        System.out.println("Available: " + (TOTAL_SEATS - bookedCount));
        System.out.println("--------------------------");
        
        if (bookedCount == 0) {
            System.out.println("No seats booked yet.");
        } else {
            for (int i = 0; i < bookedCount; i++) {
                System.out.println("Seat " + (i + 1) + ": [Passenger: " + seats[i].getName() + ", ID: " + seats[i].getPassengerId() + "]");
            }
        }
        System.out.println("--------------------------\n");
    }
}

// Main class to run the simulation
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flight myFlight = new Flight();
        boolean running = true;

        System.out.println("Welcome to Flight Reservation System Simulator");

        while (running) {
            // Display Menu
            System.out.println("1. Book a Seat");
            System.out.println("2. Show Seat Status");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            // Check if input is an integer to avoid InputMismatchException
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Enter Choice: Booking
                        System.out.print("Enter Passenger Name: ");
                        scanner.nextLine(); // consume newline
                        String name = scanner.nextLine();
                        System.out.print("Enter Passenger ID: ");
                        if (scanner.hasNextInt()) {
                            int id = scanner.nextInt();
                            myFlight.bookSeat(name, id);
                        } else {
                            System.out.println("Invalid ID format. Please use numbers.");
                            scanner.next(); // clear invalid input
                        }
                        break;

                    case 2:
                        // Display Seat Status
                        myFlight.displaySeatStatus();
                        break;

                    case 3:
                        System.out.println("Exiting System. Thank you!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // clear invalid input
            }
        }
        scanner.close();
    }
}
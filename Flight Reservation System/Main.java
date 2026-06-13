import java.util.*;
class Passenger {
    String name;
    int id;
    Passenger(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
class Flight {
    Passenger[] seats = new Passenger[10];
    int count = 0;
    void bookSeat(String name, int id) {
        if (count == 10) {
            System.out.println("Flight Full!");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (seats[i].id == id) {
                System.out.println("ID already booked!");
                return;
            }
        }
        seats[count++] = new Passenger(name, id);
        System.out.println("Seat Booked");
    }
    void showSeats() {
        System.out.println("Booked Seats: " + count);
        for (int i = 0; i < count; i++) {
            System.out.println(seats[i].name + " - " + seats[i].id);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Flight f = new Flight();
        while (true) {
            System.out.println("\n1.Book Seat\n2.Show Seats\n3.Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("ID: ");
                int id = sc.nextInt();
                f.bookSeat(name, id);
            } else if (choice == 2) {
                f.showSeats();
            } else if (choice == 3) {
                break;
            }
        }
        sc.close();
    }
}

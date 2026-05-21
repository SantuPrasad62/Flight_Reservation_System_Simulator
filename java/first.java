class Flight {
    String seat1;

    void book(String name) {
        if (seat1 == null) {
            seat1 = name;
            System.out.println("Seat booked for " + name);
        } else {
            System.out.println("Seat already booked");
        }
    }
}

public class first{
    public static void main(String[] args) {
        Flight f = new Flight();

        f.book("Santu");
        f.book("Rahul");
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        buses.add(new Bus(1,true,3));
        buses.add(new Bus(2,false,2));
        buses.add(new Bus(3,true,4));

        Scanner s = new Scanner(System.in);
        System.out.print("Enter 1 to continue or 0 to exit:  ");
        int userInput = s.nextInt();
        System.out.println();
        while (userInput == 1)
        {
            displayInfo(buses);
            System.out.println();
            Booking booking = new Booking();
            if(booking.isAvailable(buses,bookings))
            {
                bookings.add(booking);
                System.out.println("Successfully booked! Happy Journey!");
            }
            else{
                System.out.println("Sorry, bus is full!, try another bus or try booking on another date.");
            }
            System.out.println();
            System.out.print("Enter 1 to continue or 0 to exit: ");
            userInput = s.nextInt();
            System.out.println();
        }
    }

    public static void displayInfo(ArrayList<Bus>buses)
    {
        for(Bus b : buses)
        {
            System.out.println("BusNo: " + b.getBusNo() +", " + "Capacity: " + b.getCapacity()+", " +"AC: " + b.isAC() );
        }
    }
}

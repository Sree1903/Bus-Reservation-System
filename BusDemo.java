import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) {
        BusDAO acc = new BusDAO();
        try{
            acc.displayInfo();
            Scanner s = new Scanner(System.in);
            System.out.print("Enter 1 to continue or 0 to exit:  ");
            int userInput = s.nextInt();
            System.out.println();
            while (userInput == 1)
            {
                Booking booking = new Booking();
                if(booking.isAvailable())
                {
                    BookingDAO add = new BookingDAO();
                    add.addBookings(booking);
                    System.out.println("Booking confirmed successfully! Wishing you a delightful journey.");
                }
                else{
                    System.out.println("Sorry, the bus is full. Please try another bus or choose a different date.");
                }
                System.out.println();
                System.out.print("Enter 1 to continue or 0 to exit: ");
                userInput = s.nextInt();
                System.out.println();
            }
        }catch (Exception e)
        {
            System.out.println("Our server is down right now. Please try again later.");
        }
    }
}

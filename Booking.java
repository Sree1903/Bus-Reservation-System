import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    private String passengerName;
    private  int BusNo;
    private Date date;

    Scanner s = new Scanner(System.in);

    Booking()
    {
        System.out.print("Enter ur Name: ");
        passengerName = s.nextLine();
        System.out.print("Enter the Bus Number: ");
        BusNo = s.nextInt();
        s.nextLine();
        System.out.print("Enter Date(dd-mm-yyyy): ");
        String d = s.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = format.parse(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getBusNo() {
        return BusNo;
    }

    public Date getDate() {
        return date;
    }

    public boolean isAvailable(ArrayList<Bus>buses,ArrayList<Booking>bookings) {
        int booked = 0;
        int cap = 0;
        for(Booking v : bookings)
        {
            if(v.getDate().equals(date) && v.getBusNo() == BusNo)
            {
                booked++;
            }
        }
        for(Bus c : buses)
        {
            if(c.getBusNo() == BusNo)
            {
                cap = c.getCapacity();
                break;
            }
        }
        return booked < cap;
    }
}

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TicketCancellation {
    int businessCost;
    int economyCost;
    public TicketCancellation()
    {
        businessCost=2000;
        economyCost=1000;
    }
    FlightBooking flightBooking = new FlightBooking();
    public void CancelTicket(File folder,int[] businessSeat,int[] economySeat,String[] number)
    {
        System.out.println("1.Enter the Cancellation Details");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the flight number");
        String flightNumber = sc.nextLine();
        System.out.println("Enter the number of seats to be cancelled");
        int cancelSeats = sc.nextInt();
        System.out.println("Enter the Class");
        String Tclass = sc.nextLine();
        System.out.println("Cancellation amount of Rs 200 will be charged");
        
        int index=0;
        for(int i=0;i<number.length;i++)
        {
            if(number[i].equals(flightNumber))
            {
                index=i;
                break;

            }
        }
        int btotal=0;
        int etotal=0;
        if(Tclass.toLowerCase().equals("business"))
        {
            btotal=(businessCost*cancelSeats)-200;
            businessSeat[index]=businessSeat[index]+cancelSeats;
        }
        if(Tclass.toLowerCase().equals("economy"))
        {
            etotal=(economyCost*cancelSeats)-200;
            economySeat[index]=economySeat[index]+cancelSeats;
        }
        System.out.println("The Booking Id is: "+flightBooking.BookId);
        System.out.println("The amount to be refunded: "+ (Tclass.toLowerCase().equals("business")?btotal:etotal));
            






    }
    
}

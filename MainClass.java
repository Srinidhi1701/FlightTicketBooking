import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args)
    {
        FlightBooking flightBooking = null;
        while(true)
        {
        Scanner sc = new Scanner(System.in);
        System.out.println("AIRLINE TICKET BOOKING");
        System.out.println("1.Flight Details");
        System.out.println("2.Search Flight By Location");
        System.out.println("3.Search Flight By Class ");
        System.out.println("4.Flight Booking");
        System.out.println("5.Cancel Booking");
        System.out.println("6.Display Passenger Details");
        System.out.println("7.Exit");
        String folderPath = "D:\\FlightFolder";
        File folder = new File(folderPath);
        System.out.println("Enter the Choice of Action...");
        int choice=sc.nextInt();
        SeatCalculation seat = new SeatCalculation();
        int[] businessSeatAvail = seat.CalculateBusinessSeat(folder);
        int[] economicSeatAvail = seat.CalculateEconomySeat(folder);
        String[] num = seat.FlightNumber(folder);
       
        
        switch(choice)
        {
            case 1: 
            {
                DisplayFlight displayFlight = new DisplayFlight();
                displayFlight.FlightDetailsDisplay(folder,businessSeatAvail,economicSeatAvail,num);
                break;
            }
            case 2:
            {
                FlightSearch flightSearch = new FlightSearch();
                flightSearch.SearchFlightByLocation(folder);
                break;
            }
            case 3:
            {
                FlightSearch flightSearch = new FlightSearch();
                flightSearch.FlightSearchByClass(folder);
                break;
            }
            case 4:
            {
                flightBooking = new FlightBooking();
                flightBooking.BookTickets(folder, businessSeatAvail, economicSeatAvail, num);
                break;
            }
            case 5:
            {
                TicketCancellation ticketCancellation = new TicketCancellation();
                ticketCancellation.CancelTicket(folder, businessSeatAvail, economicSeatAvail, num);
                break;


            }
            case 6:
            {
                if (flightBooking != null) {
                
                int seats = flightBooking.getPassCount();
                int meal = flightBooking.getMealCount();
                String Tclass = flightBooking.getClassType();
                String flightNumber = flightBooking.getFlightName();
                PassengerDetail passengerDetail = new PassengerDetail();
                System.out.print(seats);
                passengerDetail.PassengerDetailDispaly(folder,seats,meal,Tclass,flightNumber);
                
                }
                else {
                    System.out.println("Please book a flight first.");
                }
                break;

            }
            case 7:
            {
                System.exit(0);
            }
            default: {
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
            }
        }
    }
    
        
    }
}
    



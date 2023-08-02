import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PassengerDetail {
    public void PassengerDetailDispaly(File folder,int seats, int meal,String Tclass,String flightNum)
    {
        
        FlightBooking flightBooking = new FlightBooking();
        System.out.println("Passenger Details...");
        
        System.out.println("Number of Seats Chosen: "+ seats);
        System.out.println("Opted for Meal: "+ (meal==1?"yes":"No"));
        System.out.println("--------");
        System.out.println("Flight Details");
        if(folder.exists() && folder.isDirectory())
        {
            File[] files = folder.listFiles();
            if(files!=null)
            {
                for(File file : files)
                {
                    String fileName = file.getName();
                    if(fileName.contains(flightNum) && fileName.contains(flightNum))
                    {
                        String flightNumber = fileName.substring(fileName.indexOf("-") + 1, fileName.indexOf("-", fileName.indexOf("-") + 1));
                        String flightName = fileName.substring(fileName.indexOf("-", fileName.indexOf("-") + 1) + 1, fileName.lastIndexOf("."));
                        System.out.println("Flight name: "+flightName);
                        System.out.println("Flight Number: "+flightNumber);
                    }
                }
            }
        }


    }
    
}

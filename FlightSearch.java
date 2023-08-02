import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FlightSearch {

    public void SearchFlightByLocation(File folder)
    {
        System.out.println("Search Flights..");
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the source to find: ");
        String src = sc.nextLine();
        System.out.println("Enter the Destination to find: ");
        String dest = sc.nextLine();

        if(folder.exists() && folder.isDirectory())
        {
            File[] files = folder.listFiles();
            if(files!=null)
            {
                for(File file : files)
                {
                    String fileName = file.getName();
                    if(fileName.toLowerCase().contains(src.toLowerCase()) && fileName.toLowerCase().contains(dest.toLowerCase()))
                    {
                        System.out.println("The Flight Details");
                        String flightNumber = fileName.substring(fileName.indexOf("-") + 1, fileName.indexOf("-", fileName.indexOf("-") + 1));
                        String flightName = fileName.substring(fileName.indexOf("-", fileName.indexOf("-") + 1) + 1, fileName.lastIndexOf("."));
                        System.out.println("Flight name: "+flightName);
                        System.out.println("Flight Number: "+flightNumber);
                        BufferedReader reader =null;
                    try{
                        reader = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = reader.readLine()) != null) 
                        {
                            if (line.contains("Business")) 
                            {
                                String valueStr = line.split(":")[1].trim();
                                String[] values = valueStr.substring(1, valueStr.length() - 1).split(",");
                                System.out.println("Business Class Ticket Price: 2000");
                                System.out.println("The number of available seats in Business Class is: " + values[2].trim().replaceAll("[{}]",""));
                                break;
                            } 
                            else if (line.contains("Economy")) 
                            {
                                String valueStr = line.split(":")[1].trim();
                                String[] values = valueStr.substring(1, valueStr.length() - 1).split(",");
                                System.out.println("Economy Class Ticket Price: 1000");
                                System.out.println("The number of available seats in Economy Class is: " + values[2].trim().replaceAll("[{}]",""));
                                break;
                            }
                        }
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }

                    }
                    else
                    {
                        System.out.println("There are  no available Flights");
                    }
                }
            }
        }



    }
    public void FlightSearchByClass(File folder)
    {
        if(folder.exists() && folder.isDirectory())
        {
            File[] files = folder.listFiles();
            if(files!=null)
            {
                for(File file : files)
                {
                    String fileName = file.getName();
                    System.out.println("The Flight Details");
                    String flightNumber = fileName.substring(fileName.indexOf("-") + 1, fileName.indexOf("-", fileName.indexOf("-") + 1));
                    String flightName = fileName.substring(fileName.indexOf("-", fileName.indexOf("-") + 1) + 1, fileName.lastIndexOf("."));
                    System.out.println("Flight name: "+flightName);
                    System.out.println("Flight Number: "+flightNumber);
                    BufferedReader reader =null;
                    try{
                        reader = new BufferedReader(new FileReader(file));
                        String line;
                        while ((line = reader.readLine()) != null) 
                        {
                            if (line.contains("Business") && !line.contains("Economic")) 
                            {
                                String valueStr = line.split(":")[1].trim();
                                String[] values = valueStr.substring(1, valueStr.length() - 1).split(",");
                                System.out.println("Business Class Ticket Price: 2000");
                                System.out.println("The number of available seats in Business Class is: " + values[2].trim().replaceAll("[{}]",""));
                                break;
                            } 
                        }
                    }
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
    
}

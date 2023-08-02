import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SeatCalculation {
    public int[] CalculateBusinessSeat(File folder)
    {
        int[] totalSeatBusi = new int[5];
        int finalVal1=1;
        if(folder.exists() && folder.isDirectory())
        {
            File[] files = folder.listFiles();
            if(files!=null)
            {
                int index=0;
                for(File file : files)
                {
                    String fileName = file.getName();
                    String flightNumber = fileName.substring(fileName.indexOf("-") + 1, fileName.indexOf("-", fileName.indexOf("-") + 1));
                    BufferedReader reader =null;
                    try{
                        reader = new BufferedReader(new FileReader(file));
                        String line;
                        int Bsum=0;
                        int numFlights=0;
                        while ((line = reader.readLine()) != null) 
                        {
                            if (line.contains("Business")) {
                                Bsum = FindSum(line);
                                int startIndexFlights = line.indexOf("},") + 2;
                                int endIndexFlights = line.length();
                                numFlights = Integer.parseInt(line.substring(startIndexFlights, endIndexFlights).trim());

                            }
                        }
                        finalVal1=Bsum*numFlights;
                        totalSeatBusi[index]=finalVal1;
                        index++;

                        }
                        catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                        
                    }
                    
                    
                }
            }
            return totalSeatBusi;
            
        }

        public int[] CalculateEconomySeat(File folder)
    {
        int[] totalSeatBusi = new int[5];
        int finalVal1=1;
        if(folder.exists() && folder.isDirectory())
        {
            File[] files = folder.listFiles();
            if(files!=null)
            {
                int index=0;
                for(File file : files)
                {
                    String fileName = file.getName();
                    String flightNumber = fileName.substring(fileName.indexOf("-") + 1, fileName.indexOf("-", fileName.indexOf("-") + 1));
                    BufferedReader reader =null;
                    try{
                        reader = new BufferedReader(new FileReader(file));
                        String line;
                        int Bsum=0;
                        int numFlights=0;
                        while ((line = reader.readLine()) != null) 
                        {
                            if (line.contains("Economy")) {
                                Bsum = FindSum(line);
                                int startIndexFlights = line.indexOf("},") + 2;
                                int endIndexFlights = line.length();
                                numFlights = Integer.parseInt(line.substring(startIndexFlights, endIndexFlights).trim());

                            }
                        }
                        finalVal1=Bsum*numFlights;
                        totalSeatBusi[index]=finalVal1;
                        index++;

                        }
                        catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                        
                    }
                    
                    
                }
            }
            return totalSeatBusi;
            
        }
        
    
    public String[] FlightNumber(File folder)
    {
        String[] flightNum = new String[5];
        if(folder.exists() && folder.isDirectory())
        {
            File[] files = folder.listFiles();
            if(files!=null)
            {
                int index=0;
                for(File file : files)
                {
                    String fileName = file.getName();
                    String flightNumber = fileName.substring(fileName.indexOf("-") + 1, fileName.indexOf("-", fileName.indexOf("-") + 1));
                    flightNum[index]=flightNumber;
                    index++;
                    
                }
            }
        }
        return flightNum;

    }
    public static int FindSum(String line)
    {
        int sum=0;
        try{
            int startIndex = line.indexOf("{");
            int endIndex = line.indexOf("}");
            String seatValuesStr = line.substring(startIndex + 1, endIndex);
            String[] seatValues = seatValuesStr.trim().split(",");
            for (String seatValue : seatValues) {
                sum += Integer.parseInt(seatValue.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
    
}

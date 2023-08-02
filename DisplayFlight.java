import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DisplayFlight
    {
        public void FlightDetailsDisplay(File folder,int[] businessSeat,int[] economySeat,String[] number)
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
                        int index1=0;
                        int index2=0;
                        while ((line = reader.readLine()) != null) 
                        {
                            if (line.contains("Business")) 
                            {
                                String valueStr = line.split(":")[1].trim();
                                String[] values = valueStr.substring(1, valueStr.length() - 1).split(",");
                                System.out.println("Business Class Ticket Price: 2000");
                                for(int i=0;i<number.length;i++)
                                {
                                    if(number[i].equals(flightName))
                                    {
                                        index1=i;
                                        break;

                                    }
                                }
                                System.out.println("The number of available seats in Business Class is: " + businessSeat[index1]);
                                
                            } 
                            else if (line.contains("Economy")) 
                            {
                                String valueStr = line.split(":")[1].trim();
                                String[] values = valueStr.substring(1, valueStr.length() - 1).split(",");
                                System.out.println("Economy Class Ticket Price: 1000");
                                for(int i=0;i<number.length;i++)
                                {
                                    if(number[i].equals(flightName))
                                    {
                                        index2=i;
                                        break;

                                    }
                                }
                                System.out.println("The number of available seats in Economy Class is: " +economySeat[index2]);
                                
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

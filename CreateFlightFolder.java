import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class CreateFlightFolder
{
    //Creating and adding files into the folder
    public static void main(String[] args)
    {
    String folderPath="D:\\FlightFolder";
    File f1 = new File(folderPath);
    boolean bool = f1.mkdir();
    
    if(bool)
    {
       try {
                File flight1 = new File("D:\\FlightFolder\\Flight-A112-Chennai-Mumbai.txt");
                flight1.createNewFile();
                writeToFile(flight1, "Business : {2, 3, 2}, 12\nEconomy : {3, 4, 4}, 20");

                File flight2 = new File("D:\\FlightFolder\\Flight-A113-Chennai-Kolkata.txt");
                flight2.createNewFile();
                writeToFile(flight2, "Business : {3, 4, 4}, 20\nEconomy : {2, 3, 2}, 12");

                File flight3 = new File("D:\\FlightFolder\\Flight-A114-Chennai-Delhi.txt");
                flight3.createNewFile();
                writeToFile(flight3, "Business : {2, 3, 2}, 12\nEconomy : {3, 4, 4}, 20");

                File flight4 = new File("D:\\FlightFolder\\Flight-A115-Chennai-Bangalore.txt");
                flight4.createNewFile();
                writeToFile(flight4, "Business : {3, 4, 4}, 20\nEconomy : {2, 3, 2}, 12");

                File flight5 = new File("D:\\FlightFolder\\Flight-A116-Chennai-Madurai.txt");
                flight5.createNewFile();
                writeToFile(flight5, "Business : {2, 3, 2}, 12");

                System.out.println("Files created successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    else
    {
        System.out.println("Failed!!");
    }
}
private static void writeToFile(File file, String content) throws IOException {
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(content);
        bufferedWriter.close();
    }
}
    


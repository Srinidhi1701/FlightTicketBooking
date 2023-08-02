import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FlightBooking {
    static int id=0;
    int BookId;
    int pass;
    String fligNumber;
    int mealC;
    String classT;
    int businessPrice;
    int economyPrice;

   
    
    public FlightBooking()
    {
        id=id+1;
        BookId=id;
        businessPrice=2000;
        economyPrice=1000;
       

    }
    public int getPassCount()
    {
        return pass;
    }
    public int getMealCount()
    {
        return mealC;
    }
    public String getClassType()
    {
        return classT;
    }
    public String getFlightName()
    {
        return fligNumber;
    }
    public void BookTickets(File folder,int[] businessSeat,int[] economySeat,String[] number)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Book Flight");
        System.out.println("Enter the number of Passengers Travelling");
        int passCount = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Flight Number");
        String flightName=sc.nextLine();
        
        System.out.println("Enter the Type of class");
        String Tclass = sc.nextLine();
        System.out.println("Enter the choice for meals...1.Yes 2.No");
        int mealChoice=sc.nextInt();
        
        
        int index=0;
        pass = passCount;
        mealC=mealChoice;
        classT=Tclass;
        fligNumber=flightName;
        int btotal=0;
        int etotal=0;
        for(int i=0;i<number.length;i++)
        {
            if(number[i].equals(flightName))
            {
                index=i;
                break;

            }
        }
        
        if(Tclass.toLowerCase().equals("business"))
        {
            btotal = passCount*businessPrice;
            businessSeat[index]=businessSeat[index]-passCount;
            businessPrice+=100;
            if(mealChoice==1)
            {
                btotal+=200;

            }
            
        }
        if(Tclass.toLowerCase().equals("economy"))
        {
            etotal = passCount*economyPrice;
            economySeat[index]=economySeat[index]-passCount;
            economyPrice+=100;
            if(mealChoice==1)
        {
            etotal+=200;
        }
        }
        System.out.println("Number of Passengers: "+passCount);
        System.out.println("Flight Number: "+number[index]);
        System.out.println("Opted For Meals: "+ (mealChoice==1 ?"Yes":"No"));
        System.out.println("Toatl Amount: "+ (Tclass.equals("business")?btotal:etotal));
        System.out.println("Flight Booked Successfully!!");

        
        

    }
    
}


/*
Design a class named Item that contains: 
 A string data field named name for the item’s name. A string data field 
named unique symbol for the item’s symbol. A double data field named 
TodayPrice that stores the item price for Today. A double data field named 
previousDayPrice that stores the item price for the previous day. A 
constructor that creates an item with the specified symbol, name, previous 
day price and Today’s price.
*/

import java.util.Scanner;

public class NehaCat2 {
    
    String item_name;
    double TodayPrice;
    double previousDayPrice;
    double price_change;

    public NehaCat2(String item_name, double TodayPrice, double previousDayPrice) {
        this.item_name = item_name;
        this.TodayPrice = TodayPrice;
        this.previousDayPrice = previousDayPrice;
        this.price_change =  0;
    }

    double getUpdatePercent() {
        return (TodayPrice - previousDayPrice) / previousDayPrice * 100;
    }

    public static void main(String[] args)
    {
        NehaCat2 obj_collection[] = new NehaCat2[10];

        Scanner sc = new Scanner(System.in);

        // Take input
        for(int i=0;i<10;i++)
        {
            System.out.println("Enter the name of the item: ");
            String item_name = sc.nextLine();
            System.out.println("Enter the TodayPrice of the item: ");
            double TodayPrice = sc.nextDouble();
            System.out.println("Enter the previousDayPrice of the item: ");
            double previousDayPrice = sc.nextDouble();

            obj_collection[i] = new NehaCat2(item_name, TodayPrice, previousDayPrice);
            obj_collection[i].price_change = obj_collection[i].getUpdatePercent();
        }

        // Display the output
        for(int i = 0; i<10; i++)
        {
            System.out.println("The price change percent of the item is: " + obj_collection[i].price_change);
        }
    }
}

import java.util.*;

public class Q14 {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 numbers:");

        int Sum_Int = 0;
        float Sum_Float = 0;

        for (int i = 0; i < 10; i++) 
        {
            String var = sc.next();
            try 
            {
                Sum_Int += Integer.parseInt(var);
            } 
            catch (NumberFormatException e) 
            {
                Sum_Float += Float.parseFloat(var);
            }
        }

        System.out.println("Sum of Integers: " + Sum_Int);
        System.out.println("Sum of Floats: " + Sum_Float);
    }
}
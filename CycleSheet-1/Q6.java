// mydict={‘A’: (1,-2,3), ‘B’: (4,8), ‘C’: (3,6,-4,5), ‘D’: (1,7,8,-2,-6), ‘E’: (9,10)}

//Aditya Mitra
// 20BCE2044
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String str = sc.nextLine();

        str = str.substring(str.indexOf("{")+1, str.indexOf("}"));

        
        String[] parts = str.split(":");
        int n = parts.length - 1;

        String[] keys = new String[n];
        int[] values = new int[n];

        keys[0] = parts[0];

        for (int i = 1; i < n; i++) {

            String temp = parts[i];
            
            keys[i] = temp.substring(parts[i].indexOf(")") + 1, parts[i].length());
            // System.out.println(keys[i]); used for debugging

            temp = temp.substring(temp.indexOf("(") + 1, temp.indexOf(")"));

            // System.out.println(temp); used for debugging
            String[] temp_array = temp.split(",");

            for( String a : temp_array ) {
                values[i-1] += Integer.parseInt(a);
            }
            // System.out.println(values[i]); used for debugging
        }

        String temp = parts[parts.length - 1];
        temp = temp.substring(temp.indexOf("(") + 1, temp.indexOf(")"));
        String[] temp_array = temp.split(",");
        for( String a : temp_array ) {
            values[n-1] += Integer.parseInt(a);
        }


        String Array1 = "";
        String Array2 = "";

        for(int i = 0; i < values.length; i++) {
            Array1 += ( "\"" + keys[i] +  "\"" + ",");
            Array2 += ( "\"" + values[i] +  "\"" + ",");
        }

        Array1 = "[" + Array1.substring(0, Array1.length() - 1) + "]"; 
        Array2 = "[" + Array2.substring(0, Array2.length() - 1) + "]"; 

        System.out.println("\nResult:");
        System.out.println("Array 1: " + Array1);
        System.out.println("Array 2: " + Array2);

        sc.close();
    }
}
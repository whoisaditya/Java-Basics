
/*
Input:
11
6.8
14
25
8.3
7.9
Peter George
9.2
Dwarakesh
17
6
Ram Desai

Output:
The No. of Registration Numbers: 4
The No. of CGPSs: 4
The No. of Names: 3
The Max Registration Number: 25   
The Min Registration Number: 6    
The Avg Cgpa: 8.05
The Names: Peter George, Dwarakesh, Ram Desai
*/

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        int n, i, max, min, c_regno = 0, c_name = 0, c_cgpa = 0;
        float cgpa_sum = 0.0f;
        String names = "";
        String str;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no. of entries: ");
        n = Integer.parseInt(sc.nextLine());

        max = -9999999;
        min = 999999;

        System.out.println("Enter the details: ");

        for (i = 0; i < n; i++) {
            str = sc.nextLine();
            try {
                if (Integer.parseInt(str) > max) {
                    max = Integer.parseInt(str);
                    c_regno++;
                }

                if (Integer.parseInt(str) < min) {
                    min = Integer.parseInt(str);
                    c_regno++;
                }
            } catch (NumberFormatException e) {
                try {
                    cgpa_sum += Float.parseFloat(str);
                    c_cgpa++;
                } catch (NumberFormatException e1) {
                    try {
                        names = names + str + ", ";
                        c_name++;
                    } catch (NumberFormatException e2) {
                        System.out.println("Invalid Data Type");
                    }
                }
            }
        }

        if (names.endsWith(", ")) {
            names = names.substring(0, names.length() - 2);
        }

        System.out.println("\nResult: ");
        System.out.println("The No. of Registration Numbers: " + c_regno);
        System.out.println("The No. of CGPSs: " + c_cgpa);
        System.out.println("The No. of Names: " + c_name);
        System.out.println("The Max Registration Number: " + max);
        System.out.println("The Min Registration Number: " + min);
        System.out.println("The Avg Cgpa: " + cgpa_sum / c_cgpa);
        System.out.println("The Names: " + names);

        sc.close();
    }
}

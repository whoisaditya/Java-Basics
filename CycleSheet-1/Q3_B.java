/*
Given the number of rows, n, as input, write a program to print the following pattern.
            Example:

4 (number of rows for the pattern)

         

 

Sample Input II:

3

 

           1

         1   2
       1       3
         1     2

             1
*/

import java.util.Scanner;

public class Q3_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the No. of Rows");
        n = sc.nextInt();

        // No. of rows 
        // No. of Spaces in the pattern
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            System.out.print("1");

            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }

            if (i > 0) {
                System.out.print(i + 1);
            }

            System.out.print("\n");
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            System.out.print("1");

            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }

            if (i > 0) {
                System.out.print(i + 1);
            }

            System.out.print("\n");
        }

        sc.close();
    }

}

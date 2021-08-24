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

class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the no. of rows");
        n = sc.nextInt();

        int k = 2 * n - 1;
        for (int i = 0; i < n - 1; i++) {
            for (int spaces = 0; spaces < n - i - 1; spaces++) {
                System.out.print("\t");
            }

            System.out.print("1");

            for (int spaces = 0; spaces < 2 * i; spaces++) {
                System.out.print("\t");
            }

            if (i > 0) {
                System.out.print(i + 1);
            }

            System.out.print("\n");
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int spaces = 0; spaces < n - i - 1; spaces++) {
                System.out.print("\t");
            }

            System.out.print("1");

            for (int spaces = 0; spaces < 2 * i; spaces++) {
                System.out.print("\t");
            }

            if (i > 0) {
                System.out.print(i + 1);
            }

            System.out.print("\n");
        }

        sc.close();
    }

}

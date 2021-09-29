// Aditya Mitra
// 20BCE2044
// Sample input
// Array Length = 7
// Array = 2 -1 4 3 -1 0 5
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Value of n: ");
        n = sc.nextInt();
        int[][] arr = new int[n - 2][];

        int input[] = new int[n];

        System.out.print("Enter the array: ");
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        System.out.println();

        for (int i = 0; i < n - 2; i++) {
            arr[i] = new int[n - i - 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;

                int sum = 0;
                for (int x = 0; x < i + 2; x++) {
                    sum += input[x + j];
                }

                arr[i][j] = sum;

            }
        }

        System.out.println();
        for (int i = 0; i < n - 2; i++) {
            loop2: for (int j = 0; j < arr[i].length - 1; j++) {
                for (int k = j + 1; k < arr[i].length; k++) {
                    int or, xor;
                    or = arr[i][j] | arr[i][k];
                    xor = arr[i][j] ^ arr[i][k];

                    System.out.println("(" + arr[i][j] + "," + arr[i][k] + ") OR = " + or + " XOR = " + xor);
                    if (or == xor) {
                        System.out.println("Row " + i + " ended abruptly");
                        break loop2;
                    }
                    if (j == arr[i].length - 2) {
                        System.out.println("Row " + i + " processed completely");
                    }
                }

            }
        }
        sc.close();
    }
}

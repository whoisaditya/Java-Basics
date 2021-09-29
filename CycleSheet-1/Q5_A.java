// Aditya Mitra
// 20BCE2044
import java.util.Scanner;

public class Q5_A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Value of n: ");
        int n = sc.nextInt();

        char[][] arr = new char[n][n];

        System.out.println("Enter the Matrix:");

        for (int i = 0; i < n; i++) {
            {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.next().charAt(0);
                }
            }
        }

        System.out.println();
        for (int i = 1; i < n; i++) {
            {
                for (int k = 0; k < i; k++) {
                    char temp = arr[i][0];
                    for (int j = 0; j < n - 1; j++) {
                        arr[i][j] = arr[i][j + 1];
                    }
                    arr[i][n - 1] = temp;
                }

            }
        }

        for (int j = 1; j < n; j++) {
            {
                for (int k = 0; k < j; k++) {
                    char temp = arr[0][j];
                    for (int i = 0; i < n - 1; i++) {
                        arr[i][j] = arr[i + 1][j];
                    }
                    arr[n -1][j] = temp;
                }
            }
        }

        System.out.println("The Resultant Matrix after the rotation: ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();

    }

}

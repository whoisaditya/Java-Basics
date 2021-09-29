
/*
5  (the value of n)
CLASS
GLUE
COMPATIBILITY
ASSESSMENT
PROGRAM

*/

// Aditya Mitra
// 20BCE2044
import java.util.Scanner;

public class Q5_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value of n: ");
        int n = Integer.parseInt(sc.next());

        String[] arr = new String[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            String temp_str = "";

            for (int j = 0; j < arr[i].length(); j++) {

                char[] temp = new char[arr[i].length()];
                temp[j] = arr[i].charAt(j);

                if (isVowel(temp[j])) {
                    temp[j] = 'V';
                } else {
                    temp[j] = 'C';
                }

                temp_str += temp[j];
            }

            arr[i] = temp_str;

            arr[i] = arr[i].replace("CC", "C");
            arr[i] = arr[i].replace("VV", "V");
        }

        for (int i = 0; i < n; i++) {
            String temp_str = arr[i];

            temp_str = temp_str.replace("VC", "X");

            for (int j = 0; j < temp_str.length(); j++) {
                if (temp_str.charAt(j) == 'X') {
                    res[i]++;
                }
            }
        }

        System.out.println("\nResult: ");
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
            System.out.println(arr[i]);
        }

    }

    public static boolean isVowel(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        } else {
            return false;
        }
    }

}

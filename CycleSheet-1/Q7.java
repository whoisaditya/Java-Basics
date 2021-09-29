import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = Integer.parseInt(sc.nextLine());

        Encoding[] arr = new Encoding[n];
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
            arr[i] = new Encoding(str[i]);
        }

        Encoding.sort();

        System.out.println("\nSorted list of words:");
        for (int i = 0; i < Encoding.SA.length; i++) {
            if (Encoding.SA[i] != null) {
                System.out.print(Encoding.SA[i] + " ");
            }
        }

        System.out.println("\n\nEncoded list from the first encodeText(): ");
        for (int i = 0; i < n; i++) {
            arr[i].encodeText();
        }

        System.out.println("\nEncoded list from the second encodeText(): ");
        for (int i = 0; i < n; i++) {
            arr[i].encodeText(true);
        }

        sc.close();
    }
}

class Encoding {
    String inputtext;
    public static int m_length = 0;
    public static String[] SA;
    public static int[] IA;

    Encoding(String input) {
        inputtext = input;
        String split_input_str[] = inputtext.split(" ");

        if (split_input_str.length > m_length) {
            m_length = split_input_str.length;
        }

        if (SA == null) {
            SA = split_input_str.clone();
        } else {
            int SA_len = SA.length;
            int new_length = SA_len + split_input_str.length;
            String temp[] = new String[new_length];
            for (int i = 0; i < SA_len; i++) {
                temp[i] = SA[i];
            }
            for (int i = 0; i < split_input_str.length; i++) {
                temp[i + SA_len] = split_input_str[i];
            }
            SA = temp.clone();
        }
    }

    static void sort() {
        int SA_len = SA.length;
        // int IA_len = IA_len;
        // int t_len = t_len;

        String temp, temp_arr[] = new String[SA_len];
        int temp_i = 1;

        for (int i = 0; i < SA_len - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (SA[j].compareTo(SA[j - 1]) < 0) {
                    temp = SA[j];
                    SA[j] = SA[j - 1];
                    SA[j - 1] = temp;
                }
            }
        }

        temp_arr[0] = SA[0];
        for (int i = 1; i < SA_len; i++) {
            if (SA[i].equals(SA[i - 1])) {
                continue;
            } else {
                temp_arr[temp_i++] = SA[i];
            }
        }
        SA = temp_arr.clone();
    }

    void encodeText() {

        String[] temp = inputtext.split(" ");
        String str;

        int SA_len = SA.length;

        int t_len = temp.length;

        int index = -1;
        IA = new int[t_len];
        int IA_len = IA.length;

        for (int i = 0; i < t_len; i++) {
            str = temp[i];
            for (int j = 0; j < SA_len; j++) {
                if (str.equals(SA[j])) {
                    index = j;
                    break;
                }
            }
            IA[i] = index;
        }

        String result = "";
        for (int i = 0; i < IA_len; i++) {
            result += ((IA[i]) + ", ");
        }

        result = "[" + result.substring(0, result.length() - 2) + "]";

        System.out.println(result);
    }

    void encodeText(boolean equal) {
        if (!equal) {
            this.encodeText();
            return;
        }

        String temp[] = inputtext.split(" ");
        String str;
        int SA_len = SA.length;
        
        int t_len = temp.length;
        int index = -1, d;
        IA = new int[t_len];

        for (int i = 0; i < t_len; i++) {
            str = temp[i];
            for (int j = 0; j < SA_len; j++) {
                if (str.equals(SA[j])) {
                    index = j;
                    break;
                }
            }
            IA[i] = index;
        }

        int IA_len = IA.length;

        String result = "";
        for (int i = 0; i < IA_len; i++) {
            result += ((IA[i]) + ", ");
        }

        result = result.substring(0, result.length() - 2);
        
        d = m_length - IA_len;
        if (d != 0) {
            result += ", ";
        }

        for (int i = 0; i < d; i++) {
            result += "-1, ";
            result = result.substring(0, result.length() - 2);
        }

        result = "[" + result.substring(0, result.length()) + "]";

        System.out.println(result);
    }
}
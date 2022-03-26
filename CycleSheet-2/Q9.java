import java.util.*;

interface Conversion {
    String[] code8421 = new String[] { "0101", "0100", "0000", "1111", "1000", "1011", "1001", "0111", "1010", "0110" };

    class ConversionClass {
        String[][] createArr() {
            String[][] decimals = new String[10][2];

            int w[] = { 8, 4, -2, -1 };
            for (int i = 0; i < code8421.length; i++) {
                int val = 0;
                for (int j = 0; j < w.length; j++) {
                    val += w[j] * Integer.parseInt(code8421[i].substring(j, j + 1));
                }

                decimals[i][0] = code8421[i];
                decimals[i][1] = String.valueOf(val);
            }
            return decimals;
        }
    }
}

class Class8421 extends Conversion.ConversionClass {
    public String number;

    String GetCode8421(String n) {

        // Create a 2D array of 10 rows and 2 columns to store the decimal values
        String[][] t = createArr();
        String code8421Number = "";

        // Convert the number to 8421
        for (int p = 0; p < n.length(); p++) {
            for (int i = 0; i < 10; i++) {
                if (t[i][1].equals(n.charAt(p) + "")) {
                    code8421Number += t[i][0];
                    if (p < n.length() - 1)
                        code8421Number += " ";
                    break;
                }
            }
        }
        return code8421Number;
    }

    void setcode8421Number(String n) {
        this.number = GetCode8421(n);
    }
}

// Finds the 9's complement of a number
class Complement9 extends Class8421 {
    public String complement9 = "";
    public String dec_comp_9 = "";

    void find() {
        for (int i = 0; i < number.length(); i++) {
            switch (number.charAt(i)) {
                case '1': {
                    complement9 += "0";
                    break;
                }
                case '0': {
                    complement9 += "1";
                    break;
                }
                case ' ': {
                    complement9 += " ";
                    continue;
                }
            }
        }
    }

    // Decimal equivalent of complement of 9
    void findDec_comp_9() {
        String[] split_comp_9 = complement9.split(" ");

        // Create a 2D array of 10 rows and 2 columns to store the decimal values
        String[][] t = createArr();

        for (int p = 0; p < split_comp_9.length; p++) {
            for (int i = 0; i < 10; i++) {
                if (t[i][0].equals(split_comp_9[p])) {
                    dec_comp_9 += t[i][1];
                    if (p < split_comp_9.length - 1) {
                        dec_comp_9 += " ";
                    }
                    break;
                }
            }
        }
    }
}

class Q9 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        num = sc.nextInt();
        System.out.println();

        Complement9 obj1 = new Complement9();

        System.out.println("8421 of " + num + ": ");
        obj1.setcode8421Number(Integer.toString(num));
        System.out.println(obj1.number);
        System.out.println();

        System.out.println("9's complement: ");
        obj1.find();
        System.out.println(obj1.complement9);
        System.out.println();

        System.out.println("Decimal eqivalent of 9's complement: ");
        obj1.findDec_comp_9();
        System.out.println(obj1.dec_comp_9);
    }
}
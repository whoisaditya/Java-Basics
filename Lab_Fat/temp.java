import java.lang.Math;

// the main class
public class qone {
    // the main method
    public static void main(String[] args) {
        // an array to store the captcahs
        Captcha[] captchas = new Captcha[26];

        // an array to store the associated values which are taken
        int[] taken = new int[26];

        // initialize taken with a dummy value
        for (int i = 0; i < 26; i++) {
            taken[i] = -1;
        }

        for (int i = 0; i < 26; i++) {
            // call constructor for all the captchas
            captchas[i] = new Captcha((char) (65 + i), taken);
            // add the new associated value to the taken array
            taken[i] = captchas[i].associated_value;
        }

        // call the generate captcha for three values
        for (int i = 0; i < 3; i++) {
            System.out.println(captchas[i].generateCaptcha(captchas));
        }

    }
}

// the Captcha class
class Captcha {
    // two instance variables
    char alphabet;
    int associated_value = -1;

    // function to check if a associated value is already taken
    boolean has_it(int[] taken, int new_val) {
        for (int i = 0; i < 26; i++) {
            if (taken[i] == new_val) {
                return true;
            }
        }
        return false;
    }

    // function to generate random number
    void generateRandom(int[] taken) {
        int rand_num = (int) (Math.random() * 26);

        // if the random number is taken, then generate again
        while (has_it(taken, rand_num)) {
            rand_num = (int) (Math.random() * 26);
        }

        // use the value generated
        associated_value = rand_num;
    }

    // generate captcha function
    String generateCaptcha(Captcha captchas[]) {
        String captcha_str = ""; // empty string
        captcha_str += alphabet; // add the first alph

        // the next Captcha obj
        Captcha next = captchas[associated_value];

        for (int i = 0; i < 4; i++) {
            // add the next alphabet to str
            captcha_str += next.alphabet;
            // move on to the next Captcha obj
            next = captchas[next.associated_value];
        }

        // return the string
        return captcha_str;
    }

    Captcha(char a, int[] taken) {
        // constructor for Captcha
        this.alphabet = a;
        generateRandom(taken);
    }
}
import java.util.*;

// Captcha class
class Captcha {

    // Instance variables
    char alphabet;
    int associated_value = -1;

    // Function to check if a associated value is already used
    boolean check_used(int[] used, int new_value) {
        for (int i = 0; i < 26; i++) {
            if (used[i] == new_value) {
                return true;
            }
        }
        return false;
    }

    // Function to generate random number
    void generateRandom(int[] used) {
        int random_number = (int) (Math.random() * 26);

        
        while (check_used(used, random_number)) {
            random_number = (int) (Math.random() * 26);
        }

        associated_value = random_number;
    }

    // Generate captcha function
    String generateCaptcha(Captcha arr[]) {
        String captcha_str = ""; 
        captcha_str += alphabet; 

        // Next Captcha obj
        Captcha next = arr[associated_value];

        for (int i = 0; i < 4; i++) {
            
            captcha_str += next.alphabet;

            next = arr[next.associated_value];
        }
        
        return captcha_str;
    }

    Captcha(char a, int[] used) {
        this.alphabet = a;
        generateRandom(used);
    }
}

// Main Class
public class Question1 {

    public static void main(String[] args) {
        // Loop Variable
        int i;

        // An array to store the captchas
        Captcha arr[] = new Captcha[26];

        int[] used = new int[26];

        for (i = 0; i < 26; i++) {
            used[i] = -1;
        }

        for (i = 0; i < 26; i++) {
            
            arr[i] = new Captcha((char) (65 + i), used);
            
            used[i] = arr[i].associated_value;
        }

        System.out.println("Aditya Mitra 20BCE2044");
        System.out.println("Question 1");
        System.out.println();
        System.out.println("The 3 Captchas are as follows: ");
        // Generate captcha for three values
        for (i = 0; i < 3; i++) {
            System.out.println("Captcha " + i + " :" + arr[i].generateCaptcha(arr));
        }

    }
}
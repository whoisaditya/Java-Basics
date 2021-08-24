
/*
1-22+333-4444+ … upto n terms  (without using string functions)

Sample Input I:

4 (number of terms)

Sample Output I:

-4132

 

Sample Input II:

3 (number of terms)

Sample Output II:                                                                                                                                                        

312*/

import java.util.Scanner;
class Series {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the no. of terms");
        n = sc.nextInt();
        int term = 1;
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            if(i%2 == 0)
            {
                sum = sum - term*i;
            }
            else{
                sum= sum + term*i;
            }
            
            term = (term*10+1);
            //System.out.println("The term is " + term);
        }
        System.out.println("The sum is " + sum);
        

        sc.close();

    }
}

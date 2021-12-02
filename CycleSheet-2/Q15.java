import java.util.*;

class NotPrimeNoException extends Exception 
{
    NotPrimeNoException(String err) 
    {
        super(err);
    }
}

class NotTwinPrimeNoException extends Exception 
{
    NotTwinPrimeNoException(String err) 
    {
        super(err);
    }
}

class Prime 
{
    public void isPrime(int num) throws NotPrimeNoException 
    {
        boolean flag = true;

        for (int i = 2; i <= num / 2; ++i) 
        {
            if (num % i == 0) 
            {
                flag = false;
                break;
            }
        }

        if (!flag) 
        {
            throw new NotPrimeNoException("Not a prime number");
        }
    }
}

class TwinPrime extends Prime 
{

    public void checksTwinPrime(int num1, int num2) throws NotTwinPrimeNoException, NotPrimeNoException 
    {
        isPrime(num1);
        isPrime(num2);

        if (Math.abs(num1 - num2) != 2) 
        {
            throw new NotTwinPrimeNoException("Not twin prime numbers");
        }
    }
}

class Q15 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TwinPrime TwinPrimeObj = new TwinPrime();

        System.out.print("Enter the number of pairs: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) 
        {
            try
            {
                System.out.print("\nEnter the pair of numbers: ");

                int num1 = sc.nextInt();
                int num2 = sc.nextInt();

                TwinPrimeObj.checksTwinPrime(num1, num2);

                System.out.println("Twin prime Numbers");
            } 
            catch (NotTwinPrimeNoException e) 
            {
                System.out.println(e);
            } 
            catch (NotPrimeNoException e) 
            {
                System.out.println(e);
            }
        }

        sc.close();
    }
}


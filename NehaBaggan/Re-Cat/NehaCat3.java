import java.util.Scanner;

/*
Design a class Account with an account number and initial balance. For 
every account holder some amount will be either credited or debited at end 
of the month based on the type of account. Write a method computeExtra() 
to calculate the amount of either debited or credited. Design a class 
SavingAccount from Account. Add an instance field used to compute the 
extra amount to be credited, named interest of type double. Provide a 
method toString that displays the details of Saving Account holder. Design 
a class CurrentAccount from Account. Add an instance field used to 
compute the extra amount to be debited, named proceesingFee of type 
double. Now, redefine the computeExtra() method based on the account 
type. 
Write a test program that utilizes runtime polymorphism concept to test 
the classes and methods defined above.
*/ 
class Account{
    int acc_no, initial_balance, extra;

    void computeExtra(){
        extra = 0;
    }
}

class SavingsAccount extends Account{
    double interest;

    void computeExtra(){
        // Input intreset
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the interest: ");
        interest = sc.nextDouble();
    }

    public String toString(){
        // Display details 
        System.out.println("The details of the Savings Account are: ");
        System.out.println("The account number is: " + acc_no);
        System.out.println("The initial balance is: " + initial_balance);
    }
}

class CurrentAccount extends Account{
    double processingFee;

    void computeExtra(){
        // Input processingFee
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the processingFee: ");
        processingFee = sc.nextDouble();
    }

    public String toString(){
        // Display details 
        System.out.println("The details of the Current Account are: ");
        System.out.println("The account number is: " + acc_no);
        System.out.println("The initial balance is: " + initial_balance);
    }
}

public class NehaCat3
{
    public static void main(String[] args)  
    {
        Account obj_collection[] = new Account[10];

        Scanner sc = new Scanner(System.in);

        // Take input
        for(int i=0;i<10;i++)
        {
            System.out.println("Enter the account number: ");
            int acc_no = sc.nextInt();
            System.out.println("Enter the initial balance: ");
            int initial_balance = sc.nextInt();

            obj_collection[i] = new Account();
            obj_collection[i].acc_no = acc_no;
            obj_collection[i].initial_balance = initial_balance;
            obj_collection[i].computeExtra();
        }

        // Display the output
        for(int i = 0; i<10; i++)
        {
            System.out.println("The extra amount is: " + obj_collection[i].extra);
        }

        // Display the output
        for(int i = 0; i<10; i++)
        {
            if(obj_collection[i] instanceof SavingsAccount)
            {
                SavingsAccount obj_savings = (SavingsAccount)obj_collection[i];
                obj_savings.toString();
            }
            else if(obj_collection[i] instanceof CurrentAccount)
            {
                CurrentAccount obj_current = (CurrentAccount)obj_collection[i];
                obj_current.toString();
            }
        }
    }
}
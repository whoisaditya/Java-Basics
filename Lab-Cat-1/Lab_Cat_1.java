

import java.util.Scanner;

class Customer {
    String Name; //  = " ";
    int arr[][]; // new int[3][];

    Customer()
    {
        Name = " ";
        arr = new int[3][];
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        Name = sc.nextLine();

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the number of variables in month " + (i + 1) + ": ");
             int temp_len = sc.nextInt();

            arr[i] = new int[temp_len];

            for (int j = 0; j < temp_len; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public void haveDiscount() {
        int sum_1, sum_3 = 0;

        for (int i = 0; i < 3; i++) {
            sum_1 = 0;

            for (int j = 0; j < arr[i].length; j++) {
                sum_3 += arr[i][j];
                sum_1 += arr[i][j];
            }

            if (sum_1 > 25000) {
                System.out.println(Name + " eligible for discount since purchacse in month" + (i)
                        + " as is greater than 25000");
            }

        }

        if (sum_3 > 50000) {
            System.out.println(Name + " eligible for discount since purchacse in 3 month period greater than 50000");
        }
    }

    public void findMaxMonth() {
        int sum_1 = 0, max = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < arr[i].length; j++)
            {
                sum_1 += arr[i][j];
            }

            if (sum_1 > max) {
                max = sum_1;
            }
        }
    }

}

class MainClass {
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of customers: ");
        int n = sc.nextInt();

        Customer obj[] = new Customer[n];

        for(int i = 0; i < n; i++)
        {
            System.out.println("Customer 1:");
            obj[i].input();
            obj[i].haveDiscount();
            obj[i].findMaxMonth();
        }
	}
}

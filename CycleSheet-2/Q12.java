import java.util.Scanner;

class CalcMean extends Thread{
    static int x_i[] = new int[10];
    static int f_i[] = new int[10];

    int value;
    int start, finish;
    int sum = 0;
    
    static{
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            System.out.print("Enter no. of Students who have " + (i + 1) + " Marks: ");
            x_i[i] = i + 1;
            f_i[i] = sc.nextInt();
            System.out.println();
        }
        sc.close();
    }

    CalcMean(int num, int start, int finish){
        value = num;
        this.start = start;
        this.finish = finish;
        start();
    }

    public void run(){
        if(value == 0){
            for(int i = start; i < finish; i++){
                sum += f_i[i];
            }
        }
        else{
            for(int i = start; i < finish; i++){
                sum += f_i[i] * x_i[i];
            }
        }
    }

    int get_sum(){
        return sum;
    }
}

public class Q12 {
    public static void main(String args[]) throws InterruptedException{
        CalcMean obj1 = new CalcMean(0, 0, 5);
        CalcMean obj2 = new CalcMean(0, 5, 10);
        CalcMean obj3 = new CalcMean(1, 0, 5);
        CalcMean obj4 = new CalcMean(1, 5, 10);

        obj1.join();
        obj2.join();
        obj3.join();
        obj4.join();

        double total_f_i = obj1.get_sum() + obj2.get_sum();

        double total_prod = obj3.get_sum() + obj4.get_sum();

        double mean = (double) total_prod / total_f_i;
        System.out.println( "Sum of fi*xi: "+ total_prod + "\nSum of fi: " + total_f_i + "\nMean: " + mean);
    }
}

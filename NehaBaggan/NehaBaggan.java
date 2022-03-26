import java.util.Scanner;

/*
You are asked to develop a program to calculate the possible grade based on the Total marks obtained in a subject which is for maximum of 100 marks. Assume that you are reading marks for 10 students, stored in an array and displaying the grade as Distinction (If Total marks >= 70), First Class (If Total marks >= 60 and Total marks <70), Second Class (If Total marks >= 50 and Total marks <60), or Fail (Total marks <50). Additionally, calculate the average mark and display the same.
In this context, there may be possibility of the following exceptions and so handle the same.
(a) InputMismatchException - If user entered out of possible range of mark (valid is between 0 and 100 for each). So, throw this user-defined error and handle the same.
(b) ArrayIndexOutOfBoundsException - If programmer tries to access out of valid range of the array (valid range is 0 to 9 due to only 10 students)
(c) NotValidEvaluationException - If average of marks is less than or equal to FIFTY then throw and handle this user-defined exception; otherwise display the average.

*/

import java.util.Scanner;

class InputMismatchException extends Exception {
    public InputMismatchException(String s) {
        super(s);
    }
}

class NotValidEvaluationException extends Exception {
    public NotValidEvaluationException(String s) {
        super(s);
    }
}

public class NehaBaggan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[10];

        try {

            // read marks for 10 students
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.print("Enter marks for student " + (i + 1) + ": ");
                    marks[i] = sc.nextInt();
                    if (marks[i] < 0 || marks[i] > 100) {
                        throw new InputMismatchException("Invalid marks");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid marks");
                    System.exit(0);
                }
            }

            // calculate average
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += marks[i];
            }

            double avg = sum / 10.0;

            try {
                if (avg <= 50) {
                    throw new NotValidEvaluationException("Invalid evaluation");
                }
            } catch (NotValidEvaluationException e) {
                System.out.println("Invalid evaluation");
                System.exit(0);
            }

            // display grade
            if (avg >= 70) {
                System.out.println("Distinction");
            } else if (avg >= 60) {
                System.out.println("First Class");
            } else if (avg >= 50) {
                System.out.println("Second Class");
            } else {
                System.out.println("Fail");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid marks");
            System.exit(0);
        }
    }
}


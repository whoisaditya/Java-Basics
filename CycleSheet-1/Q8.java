
//Aditya Mitra
// 20BCE2044
import java.util.Scanner;

class Faculty {
    Student[] s;

    Faculty(int n) {
        s = new Student[n];

        System.out.println("Enter Marks");
        for (int i = 0; i < s.length; i++) {
            System.out.println("Student " + (i + 1) + ":");
            s[i] = new Student();

            System.out.println();
        }
        System.out.println("Class Average: " + findClassAverage());

        System.out.println("Highest Internal Marks: " + findMaxScore());
    }

    float findClassAverage() {
        int total = 0;

        for (int i = 0; i < s.length; i++) {
            total += s[i].getIndividualTotal();
        }
        return (float)((total*1.0) / s.length);
    }

    private int findMaxScore() {
        int max = -999999;

        for (int i = 0; i < s.length; i++) {
            int t = s[i].getIndividualTotal();
            if (t > max) {
                max = t;
            }
        }

        return max;
    }

    class Student {
        int sum;
        int[] marks;

        Student() {
            Scanner sc = new Scanner(System.in);
            marks = new int[5];

            System.out.print("CAT-1: ");
            marks[0] = sc.nextInt();

            System.out.print("CAT-2: ");
            marks[1] = sc.nextInt();

            System.out.print("DA-1: ");
            marks[2] = sc.nextInt();

            System.out.print("DA-2: ");
            marks[3] = sc.nextInt();

            System.out.print("DA-3: ");
            marks[4] = sc.nextInt();
        }

        int getIndividualTotal() {
            sum = 0;

            for (int i = 0; i < marks.length; i++) {
                sum += marks[i];
            }

            return sum; // Returning total marks
        }
    }
}

class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Faculty F = new Faculty(n);

        sc.close();
    }
}

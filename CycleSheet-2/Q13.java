import java.util.Scanner;

class Bill {
    int n;
    int faculty, m_student, f_students;

    Bill(int faculty, int m_student, int f_students) {
        n = 1;
        this.faculty = faculty;
        this.m_student = m_student;
        this.f_students = f_students;
    }

    int Get_Bill() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items bought of type 1: ");
        int t1 = sc.nextInt();

        System.out.print("Enter number of items bought of type 2: ");
        int t2 = sc.nextInt();

        System.out.print("Enter number of items bought of type 3: ");
        int t3 = sc.nextInt();

        System.out.print("Enter number of items bought of type 4: ");
        int t4 = sc.nextInt();

        System.out.println();

        int total = (50 * t1 + 75 * t2 + 100 * t3 + 150 * t4);
        return total;
    }

    synchronized void Calc_Faculty() {
        while (n != 1) {
            try {
                wait();
            } catch (InterruptedException ie) {
            }
        }

        if (faculty > 0) {
            System.out.println("Faculty Queue");
            for (int i = 0; i < 3; i++) {
                int bill_total = Get_Bill();
                System.out.println("Bill = " + bill_total + "\n");
                
                faculty--;
                if (faculty == 0)
                    {break;}
            }
        }
        System.out.println("Faculty Left = " + faculty);
        System.out.println();

        if (m_student > 0) {
            n = 2;
        } else if (f_students > 0) {
            n = 3;
        }

        notifyAll();
    }

    synchronized void Calc_StudentM() {
        while (n != 2) {
            try {
                wait();
            } catch (InterruptedException ie) {
            }
        }

        if (m_student > 0) {
            System.out.println("Male Student Queue");
            int bill_total = Get_Bill();
            System.out.println("Bill = " + bill_total + "\n");

            m_student--;
        }

        System.out.println("Male Students Left = " + m_student);
        System.out.println();

        if (f_students > 0) {
            n = 3;
        } else if (faculty > 0) {
            n = 1;
        }

        notifyAll();
    }

    synchronized void Calc_StudentF() {
        while (n != 3) {
            try {
                wait();
            } catch (InterruptedException ie) {
            }
        }

        if (f_students > 0) {
            System.out.println("Female Student Queue");
            int bill_total = Get_Bill();

            System.out.println("Bill = " + bill_total + "\n");

            f_students--;
        }

        System.out.println("Female Students Left = " + f_students);
        System.out.println();

        if (faculty > 0) {
            n = 1;
        } else if (m_student > 0) {
            n = 2;
        }

        notifyAll();
    }
}

class Faculty extends Thread {
    Bill b;

    int faculty_count;

    Faculty() {
    }

    Faculty(Bill b) {
        this.b = b;
        faculty_count = b.faculty;
    }

    public void run() {
        for (int i = 0; i < faculty_count; i++) {
            b.Calc_Faculty();
        }
    }
}

class M_Student extends Thread {
    Bill b;
    int m_student_count;

    M_Student(Bill b) {
        this.b = b;
        m_student_count = b.m_student;
    }

    public void run() {
        for (int i = 0; i < m_student_count; i++) {
            b.Calc_StudentM();
        }
    }
}

class F_Student extends Thread {
    Bill b;
    int f_students_count;

    F_Student(Bill b) {
        this.b = b;
        f_students_count = b.f_students;
    }

    public void run() {
        for (int i = 0; i < f_students_count; i++) {
            b.Calc_StudentF();
        }
    }
}

public class Q13 {
    public static void main(String[] args) {
        int faculty, m_student, f_students;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Faculty: ");
        faculty = sc.nextInt();

        System.out.print("Enter number of Male Students: ");
        m_student = sc.nextInt();

        System.out.print("Enter number of Female Students: ");
        f_students = sc.nextInt();

        System.out.println();

        Bill b = new Bill(faculty, m_student, f_students);

        Faculty f = new Faculty(b);

        M_Student sm = new M_Student(b);

        F_Student sf = new F_Student(b);

        f.start();

        sm.start();

        sf.start();

        if (b.f_students == 0 && b.faculty == 0 && b.m_student == 0) {
            System.exit(0);
        }

    }
}

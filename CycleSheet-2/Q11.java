
import java.util.Scanner;

class Line {
    int x1, y1, x2, y2;

    Line() {}

    Line(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            throw new NumberFormatException();
        }

        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    boolean compareTo(Line l) {
        if ((this.x1 == l.x1 && this.y1 == l.y1) || (this.x2 == l.x2 && this.y2 == l.y2)
                || (this.x1 == l.x2 && this.y1 == l.y2) || (this.x2 == l.x1 && this.y2 == l.y1)) {
            return true;
        } else {
            return false;
        }
    }
}

class Triangle extends Line {
    Line line1, line2;

    Triangle(Line line1, Line line2) {
        if (!(line1.compareTo(line2)))
            throw new TriangleNotPossibleException(this);

        this.line1 = line1;
        this.line2 = line2;
    }
}

class TriangleNotPossibleException extends RuntimeException {
    Triangle obj;

    TriangleNotPossibleException() {
    };

    TriangleNotPossibleException(Triangle t_obj) {
        this.obj = t_obj;
    }

    public String toString() {
        return "The given lines cannot form a triangle";
    }
}

public class Q11 {
    public static void main(String args[]) {
        int x1, x2, y1, y2;

        Scanner sc = new Scanner(System.in);
        int line_amt = 0;
        int triangle_amt = 0;

        boolean done = false;

        Line line1 = new Line(), line2 = new Line();
        Triangle t_obj;

        while (!done) {
            System.out.println("Enter points: ");
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            try {
                line1 = new Line(x1, y1, x2, y2);
            } catch (NumberFormatException e) {
                System.out.println("Error: Both points are same! Try again!");
                line_amt++;
                continue;
            }

            System.out.println("Enter points: ");
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            try {
                line2 = new Line(x1, y1, x2, y2);
            } catch (NumberFormatException e_l) {
                System.out.println("Error: Both points are identical!");
                line_amt++;
                continue;
            }

            try {
                t_obj = new Triangle(line1, line2);
            } catch (TriangleNotPossibleException e_t) {
                System.out.println(e_t.toString());
                triangle_amt++;
                continue;
            }

            done = true;
        }

        int total_amt= line_amt + triangle_amt;

        System.out.println("Result:");
        System.out.println("Line attempts = " + line_amt);
        System.out.println("Triangle attempts = " + triangle_amt);
        System.out.println("Total attempts = " + total_amt);

        sc.close();

    }
}


/*
Input:
11
6.8
14
25
8.3
7.9
Peter George
9.2
Dwarakesh
17
6
Ram Desai

Output:
The No. of Registration Numbers: 4
The No. of CGPSs: 4
The No. of Names: 3
The Max Registration Number: 25   
The Min Registration Number: 6    
The Avg Cgpa: 8.05
The Names: Peter George, Dwarakesh, Ram Desai
*/

import java.util.Scanner;

class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter number of students: ");
		n = sc.nextInt();
		int c_regno = 0, c_cgpa = 0, c_names = 0;
		int min = 9999, max = 0;
		float avg_cgpa = 0;
		String names = "";
		
		System.out.println("Enter Student information: ");
		for (int i = 0; i < n; i++) {
			
			if (sc.hasNextInt()) {
				c_regno++;

				int temp = sc.nextInt();

				if (temp < min) {
					min = temp;
				}

				if (temp > max) {
					max = temp;
				}
			}

			else if (sc.hasNextFloat()) {
				c_cgpa++;
				float temp = sc.nextFloat();
				avg_cgpa += temp;
			} else {
				c_names++;
				sc.nextLine();
				String tempstring = sc.nextLine();
				if (c_names == 1) {
					names = names + tempstring;
				} else {
					names = names + ", " + tempstring;
				}
			}
		}

		avg_cgpa /= c_cgpa;
		System.out.println("\nOutput:");
		System.out.println(c_regno + " (count reg)");
		System.out.println(c_cgpa + " (count cgpa)");
		System.out.println(c_names + " (count names)");
		System.out.println(avg_cgpa + " (Avg CGPA)");
		System.out.println(min + " (Min Reg number)");
		System.out.println(max + " (Max Reg number)");
		System.out.println("Names enetered: " + names);

		sc.close();
	}
}
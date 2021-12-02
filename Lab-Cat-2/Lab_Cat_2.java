/*
A text file stores the details of all the students of CSE II year such as the registration number, list of courses studied in the previous semester and the total marks scored in each course. Each line contains the data as follows – regno, course name, total marks, course name, total marks …………..
21BCE9001, Java, 78, C++, 63, Calculus, 89, Chemistry 75

21BCE9002, English, 79, Statistics, 92, C++, 84

21BCE9003, Statistics, 90, Java, 81, Physics, 77, English, 58, TOC, 69

Read this file and create individual map for each student which contains the course name as the key and its score as the value. Create another map which contains the registration number as the key and the individual map of that student as the value. The map structure should be as follows:

{21BCE9001={Java=78, C++=63, Calculus=89, Chemistry=75}, 21BCE9002={English=79,Statistics=92, C++=84}, 21BCE9003= {Statistics=90,Java=81, Physics=77, English=58, TOC=69}……}

Note: Create a file with a minimum of 10 rows and proceed. So, the file should be processed till the end. The number of courses studied by each student is not constant.

Print the map. Given a course name, print the registration number of the students who have studied that course.


*/

import java.util.*;
import java.io.*; 

public class Lab_Cat_2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("Lab-Cat-2/input.txt");
        Scanner reader1 = new Scanner(input);

        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();

        while (reader1.hasNextLine())
        {
            String[] line = reader1.nextLine().split(",");
            Map<String, Integer> temp = new HashMap<>();
            
            for(int i = 1; i < line.length-1; i=i+2)
            {
                temp.put(line[i], Integer.parseInt(line[i+1].trim()));
            }

            map.put(line[0], temp); 
        }

        reader1.close();

        //Printing Map
       System.out.println(map);

       Scanner sc = new Scanner(System.in);
        
       System.out.println();
       System.out.println("Enter Course Name");
       String courseName = sc.nextLine();

       for(String outerKey: map.keySet())
        {
            boolean flag = false;

            for(String nestedKey: map.get(outerKey).keySet())
            {
                String temp_str = nestedKey.trim();
                if(temp_str.equals(courseName))
                {
                    flag=true;
                }
            }

            if(flag)
            {
                System.out.println(outerKey);
            }
        }

        sc.close();
    }
}
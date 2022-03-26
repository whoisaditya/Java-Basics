/*
Create a text file Sample.txt through Java program with 20 lines of text.
Additionally, extend the Java program that removes all the occurrences of a
specified string from a text file and saves the change into a new file. Revise the
program to save the change into the original file. Also, display the number of
occurrence’s removed throughout the text.
NOTE: Read the file name and string to be remove from command-line
arguments. 

txt:
John 1 
John 2
John 3 
John 4 
John 5
John 6
John 7
John 8
John 9
John 10
John 11
John 12
John 13
John 14
John 15
John 16
John 17
John 18
John 19
John 20

*/

import java.io.*;

public class NehaQ2 extends Remove {
    public static void main(String[] args) {
        Remove obj = new Remove();
        String fileName = args[0];
        String stringToRemove = args[1];

        // Creating sample.txt
        try {
            FileWriter fw = new FileWriter("Sample.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (int i = 0; i < 20; i++) {
                pw.println("John " + (i + 1));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        try {
            obj.remove(fileName ,stringToRemove);
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}

class Remove {
    public void remove(String fileName ,String stringToRemove) throws IOException {
        File file = new File(fileName);
        File file1 = new File("newFile.txt");
        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(file1);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
        String line = br.readLine();
        int count = 0;
        while (line != null) {
            if (line.contains(stringToRemove)) {
                line = line.replace(stringToRemove, "");
                count++;
            }
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        }
        bw.close();
        br.close();
        System.out.println("Number of Occurrences removed: " + count);
    }
}


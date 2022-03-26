import java.io.*;
import java.util.*;

public class Q16 {
        public static void main(String[] args) throws FileNotFoundException, IOException {

                File file1 = new File("/Aditya M/VSCode/VIT/Java-Basics/CycleSheet-2/Q16.txt");
                Scanner reader1 = new Scanner(file1);
                Scanner sc = new Scanner(System.in);

                Map<String, ArrayList<String>> map = new TreeMap<>();

                while (reader1.hasNextLine()) {
                        String line = reader1.nextLine();
                        ArrayList<String> list;
                        line = line.replace("?", "");

                        String sent_str = line.substring(0, line.indexOf("("));

                        String key_str = line.substring(line.indexOf("(") + 1, line.indexOf(")"));

                        sent_str = sent_str.trim().toLowerCase();
                        key_str = key_str.trim();

                        String words[] = sent_str.split(" ");
                        String keys[] = key_str.split(" ");

                        for (int i = 0; i < keys.length; i++) {
                                list = map.get(keys[i]);

                                if (list == null) {
                                        list = new ArrayList<>();
                                }
                                if (!list.contains(words[i])) {
                                        list.add(words[i]);
                                }

                                map.put(keys[i], list);
                        }
                }

                System.out.print("Enter words: ");
                String input_sent = sc.nextLine();

                input_sent = input_sent.trim().toLowerCase();

                String words[] = input_sent.split(" ");
                String map_seq[][] = new String[words.length][];

                // Creating a 2d ragged array
                for (int i = 0; i < words.length; i++) {
                        ArrayList<String> p_o_s = new ArrayList<>();
                        Set<String> keySet = map.keySet();

                        for (String key : keySet) {
                                ArrayList<String> l = map.get(key);
                                if (l.contains(words[i])) {
                                        p_o_s.add(key);
                                }
                        }

                        int n = p_o_s.size();
                        map_seq[i] = new String[n];

                        for (int j = 0; j < n; j++) {
                                map_seq[i][j] = p_o_s.get(j);
                        }
                }

                for (String word[] : map_seq) {
                        for (String pos : word) {
                                System.out.print(pos + " ");
                        }
                        System.out.println();
                }

                System.out.print("Enter user parse string: ");
                String par_str = sc.nextLine();

                par_str = par_str.trim();
                String user_str[] = par_str.split(" ");

                // pos: Parts of Speech
                int cnt = 0;
                for (String word[] : map_seq) {
                        boolean flag = false;
                        for (String pos : word) {
                                if (user_str[cnt].equals(pos)) {
                                        flag = true;
                                }
                        }
                        if (flag == false) {
                                // We print this if the word entered by the user has nver been used in the way it was supposed to be used.
                                System.out.println("Unacceptable");
                                break;
                        }
                        cnt++;
                }

                if (cnt == user_str.length) {
                        System.out.println("Acceptable");
                }

                reader1.close();
                sc.close();
        }
}

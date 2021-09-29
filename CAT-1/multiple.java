import java.util.Scanner;

class Multiple
{
    public static void generate (int[] arr, int n)
    {
        for(int i = 0; i < 10; i++)
        {
            arr[i] = (i+1)*n;
        System.out.println(arr[i]);

        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[10];
        //String[] arr_str = new String[10];

        generate(arr, n);

        String str_concat = "";

        for(int i = 0; i < 10; i++)
        {
            str_concat += arr[i];
        }

        String str = "";
        int sum = 0;


        for(int i = 0; i < str_concat.length()-1; i+=2)
        {
            //String sub = (String.valueOf(str_concat.charAt(i)) + String.valueOf(str_concat.charAt(i+1)));
            String sub = (Character.toString(str_concat.charAt(i)) + Character.toString(str_concat.charAt(i+1)));
            
            str += (sub + ", ");
            sum += Integer.parseInt(sub);
            
        }

        if(str_concat.length()%2 !=0)
            {
                str += Character.toString(str_concat.charAt(str_concat.length()-1));
            }

        //str = str.substring(0,str.length()-2);

        //System.out.println(str_concat.charAt(str_concat.length()-1));

        System.out.println(str_concat);

        System.out.println(str);

        System.out.println(sum);

        sc.close();
    }
}
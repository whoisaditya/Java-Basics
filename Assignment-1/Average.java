/*
Program to Read all the command line inputs given by the user and then finding their Average

Input in Terminal: 
javac Average.java
java Average <Array of Numbers>
*/
class Average
{
    public static void main(String[] args) {
        int i, sum = 0; 
        float avg;
        for(i = 0; i < args.length; i++)
        {

            sum += Integer.parseInt(args[i]);
        }
        avg = (float)sum/args.length;
        System.out.println("The average is " + avg);
    }
}
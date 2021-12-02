/*

javac Q2.java
java Q2 Vinay 7000 1500 Andrea 46000 -28000 Venba 18500 -11800  Mithil 78000 3000 Kavin 8600 -10000

Output:
Vinay
8500
Andrea
Failed Transaction
46000
Venba
6688
Mithil
81000
Kavin
Failed Transaction
8600

*/ 

public class Q2 {
    public static void main(String[] args){
        int size = args.length;
        int balance;

        int i = 0;
        while(i < size){
            System.out.println(args[i]);
            i++;
            
            balance = Integer.parseInt(args[i]);
            
            i++;
            int amt = Integer.parseInt(args[i]);

            if(amt < 0)
            {
                amt = -amt;
                if(amt > 25000){
                    System.out.println("Failed Transaction");
                }

                else{
                    int charge;
                    if(amt <=500)
                        charge = 5;
                    else if(amt <= 1000)
                        charge = 8;
                    else if(amt <= 5000)
                        charge = 10;
                    else if(amt <= 15000)
                        charge = 12;
                    else
                        charge = 15;
                    
                    int t_amt = amt + charge;

                    if(t_amt > balance)
                        System.out.println("Failed Transaction");
                    else{
                        balance -= t_amt;
                    }
                }
            }
            else{
                balance += amt;
            }
            
            System.out.println(balance);
            
            i++;
        }
    } 
}

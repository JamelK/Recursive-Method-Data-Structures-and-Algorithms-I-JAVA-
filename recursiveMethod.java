// Program Name: Recursive Method
// Programmer: Jamel Kalawi, 1459778
// Assignment Number: Project #3
// Purpose: Develop a recursive method to determine the number of distinct ways in which a given amount
//of money in cents can be changed into quauarters, dimes, nickels, and pennies. Each line of input
//contains an amount. 

import java.util.Scanner;

public class recursiveMethod
{
    //variables
   static int qua=0;
   static int di=0;
   static int ni=0;
   static int p=0;
   
   public static int coins(int n)
   {
       if(n == 1) return 1;//1 penny-1cent
       else if(n == 2) return 5;//1 nicke-5cents
       else if(n == 3) return 10;//1 dime-10cents
       else if(n == 4) return 25;//1 quarter-25cents
       return 0;
   }
   
   public static int ways(int amount, int d)
   {
       if (amount < 0) return 0;
       else if(amount==0)
       {
           //print out 
           System.out.println("There are "+ qua+" quarter,"+di+" dime,"+ni+" nickel,"+p+" penny");
           return 1;
       }
       else
       {
           //variable for ways
           int noWays = 0;
           //coin count
           int c = coins(d);
                    
           switch(c)
           {
            //case for each coin   
           case 25:
               if(amount-25>=0)
               {
                   qua++;
                   noWays += ways(amount - 25, 4);
                  qua=0;
                 
               }

  
           case 10:
               if(amount-10>=0)
               {
                 
                   di++;
                   noWays += ways(amount - 10, 3);
                   di=0;
               }

               
           case 5:
               if(amount-5>=0)
               {
                   ni++;
                   noWays += ways(amount - 5, 2);
                   ni=0;
               }
               
           case 1:
               if(amount-1>=0)
               {                 
                   p++;
                   noWays += ways(amount - 1, 1);
                   p=0;
               }
               
           }  
           
           return noWays;
       }
   
}
   
   public static void main(String args[])
   {
       Scanner input =new Scanner(System.in);
       System.out.println("Enter cents between 1 and 99:");
       int cents=input.nextInt();
       //only accept greater than 0
       if(cents <=0){
        System.out.print("Invalid input");
        System.exit(0);
    }
           
       System.out.println("The number of ways to make change for "+cents+" cents = "+ ways(cents, 4));
     
   }
}
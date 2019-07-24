

import java.io.*;
import java.util.*;
public class lucky7
{
    Random generator = new Random();
    BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    void main()throws IOException
    {
        String play;
        int game, Number1, Number2, total, bet;
        boolean value=true;
        System.out.println("\f");
        System.out.println("Welcome to the game of Lucky 7!");
        do{
            System.out.println("You have "+Casino.cash+" dollars.");
            System.out.println("Enter 'p' to play, 'r' for rules and 'l' to leave");
            play=b.readLine();
            if(play.equalsIgnoreCase("r"))
            {
                System.out.println("  Lucky 7 rules-");
                System.out.println("1.This is a classic dice game to earn a fast buck!");
                System.out.println("2.Two die are rolled");
                System.out.println("3.You have to bet money on any one of these possiblities- 1)Below 7, 2)Lucky 7 and 3)Above 7");
                System.out.println("4.Below 7- Numbers 2, 3, 4, 5 and 6: Double cash!");
                System.out.println("5.Lucky 7- Number 7: Triple cash!");
                System.out.println("6.Above 7- Numbers 8, 9, 10 ,11 and 12: Double cash!");
                System.out.println();
            }
            else if(play.equalsIgnoreCase("p"))
            {
                do
                {
                    bet=BetAmt.bet(Casino.cash);
                    if(bet>Casino.cash)
                    System.out.println("You can't bet more than you have!");
                }while(bet>Casino.cash);
                if(bet>0)
                {
                    Casino.cash-=bet;
                }
                do
                {
                    System.out.println("Where to place bet?(enter no.)");
                    System.out.println("1. Below 7");
                    System.out.println("2. Lucky 7");
                    System.out.println("3. Above 7");
                    try{
                        game=Integer.parseInt(b.readLine());
                        if((game>3)||(game<1))
                        {
                            System.out.println("Please Enter a proper value");
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("Please Enter a proper value");
                        game=0;
                    }
                    
                        
                }while((game==0)||(game>3)||(game<1));
                System.out.println("\f");
                System.out.print("Press enter to roll.  ");
                b.readLine();
                Number1=generator.nextInt(6)+1;
                Number2=generator.nextInt(6)+1;
                total = Number1 + Number2;
                
                for(int i=0;i<6;i++)
                {
                    try
                    {
                        Thread.sleep(250);
                        System.out.print(".");
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println("\nNumbers are " + Number1 + " and " + Number2);
                System.out.println("Total is " + total);
                 
                if(game==1)
                {
                      
                    if(total<7)
                    {
                        System.out.println("You win!");
                        Casino.cash+=2*bet;
                        
                    }
                    else
                    {
                        System.out.println("You loose!");
                        
                    }
                }
                else if(game==2)
                {
                    if(total==7)
                    {
                        System.out.println("You win!");
                        Casino.cash+=3*bet;
                    }
                    else
                    {
                        System.out.println("You loose!");
                        
                    }
                }
                else if(game==3)
                {
                    if(total>7)
                    {
                        System.out.println("You win!");
                        Casino.cash+=2*bet;
                    }
                    else
                    {
                        System.out.println("You loose!");
                        
                    }
                }
                else
                {
                    System.out.println("Invalid!");
                }
                
                       
             }
             else if(play.equalsIgnoreCase("l"))
             {
                 System.out.println("You leave with "+Casino.cash+" dollars.");
                 return;}
             else{
                 System.out.println("\f");
                 System.out.println("Invalid!");
                }
            if(Casino.cash==0)
            {                
                return;
            }    
        }while((play.equalsIgnoreCase("p")==false)||(play.equalsIgnoreCase("r")==false)||(play.equalsIgnoreCase("l")==false));
        
    }
                
                
}

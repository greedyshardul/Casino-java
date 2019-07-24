import java.io.*;
import java.util.*;
public class Roulette
{
    BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    Random generator = new Random();
    void main()throws Exception
    {
        String choice;
        byte betChoice=0,f=0,nu=-1,multiChoice=0;
        byte number[]=new byte[36];
        int bet=0;
        for(int i=0;i<36;i++)
            number[i]=-1;
        System.out.println("\f");    
        System.out.println("Welcome to the game of Raging Roulette!");
        for(int i=0; ;i++)
        {
            System.out.println("You have "+Casino.cash+" dollars.");
            System.out.println("Enter 'p' to play, 'r' for rules and 'l' to leave.");
            choice=b.readLine();
            if(choice.equalsIgnoreCase("p"))
            {
                System.out.println("This is the betting area!");
                layout.m();                
                do
                {  
                    f=0;
                    System.out.println("Where to place bet?");
                    System.out.println("(1)A single number[Payout: 35 to 1]");
                    System.out.println("(2)Multiple numbers");
                    System.out.println("(*)Any other number to go back.");
                    try
                    {
                        betChoice=Byte.parseByte(b.readLine());                          
                    }
                    catch(Exception e)
                    {    
                        f=1;
                        System.out.println("\nEnter a proper value!");  
                    }
                }while(f==1);

                if(betChoice==1)
                {
                    for(i=0;;i++)
                    {
                        do
                        {
                            f=0;
                            System.out.println("Which number to place bet on?");
                            try
                            {
                                nu=Byte.parseByte(b.readLine());
                            }
                            catch(Exception n)
                            {
                                System.out.println("Enter a proper value!");
                                f=1;
                            }
                        }while(f==1);
                        number[0]=nu;
                        if(number[0]>=0&&number[0]<=36)
                            break;
                        else
                            System.out.println("Enter a proper value!");    
                    }
                    bet=BetAmt.bet(Casino.cash);
                    System.out.println("Press Enter to roll!");
                    b.readLine();
                    Choice.delay(5,200);
                    byte ball=(byte)(generator.nextInt(36));
                    System.out.println("The ball stopped on "+ball);
                    b.readLine();
                    Casino.cash=Choice.WinLoose(number,35,ball,bet,Casino.cash);
                }
                else if(betChoice==2)
                {
                    for(i=0;;i++)
                    {
                        do
                        {
                            f=0;
                            System.out.println("Where to place bet?");
                            System.out.println("1.  2 Numbers [Payout: 17 to 1]");
                            System.out.println("2.  3 Numbers [Payout: 11 to 1]");
                            System.out.println("3.  4 Numbers [Payout:  8 to 1]");
                            System.out.println("4.  6 Numbers [Payout:  5 to 1]");
                            System.out.println("5. 12 Numbers [Payout:  2 to 1]");
                            System.out.println("6. 18 numbers [Payout:  1 to 1]");
                            try
                            {
                                multiChoice=Byte.parseByte(b.readLine());
                            }
                            catch(Exception e)
                            {
                                System.out.println("\f");
                                System.out.println("Enter a proper value!");
                                f=1;
                            }
                        }while(f==1);
                        if(multiChoice>0&&multiChoice<7)
                            break;
                    }
                    if(multiChoice==1)
                    {
                        bet=BetAmt.bet(Casino.cash);
                        do
                        {
                            number[0]=Choice.c("first");
                            number[1]=Choice.c("second");
                            if(number[0]==number[1])
                            {
                                System.out.println("Numbers cannot be same!");
                            }
                        }while(number[0]==number[1]);
                        System.out.println("Press Enter to roll!");
                        b.readLine();
                        Choice.delay(5,200);
                        byte ball=(byte)(generator.nextInt(36));
                        System.out.println("The ball stopped on "+ball);
                        Casino.cash=Choice.WinLoose(number,17,ball,bet,Casino.cash);
                    }
                    if(multiChoice==2)
                    {
                        bet=BetAmt.bet(Casino.cash);
                        do
                        {
                            number[0]=Choice.c("first");
                            number[1]=Choice.c("second");
                            number[2]=Choice.c("third");
                            if(number[0]==number[1])
                                System.out.println("Numbers cannot be same!");                            
                        }while(number[0]==(number[1]|number[2])||number[1]==number[2]);
                        System.out.println("Press Enter to roll!");
                        b.readLine();
                        Choice.delay(5,200);
                        byte ball=(byte)(generator.nextInt(36));
                        System.out.println("The ball stopped on "+ball);
                        Casino.cash=Choice.WinLoose(number,11,ball,bet,Casino.cash);
                    }
                    if(multiChoice==3)
                    {
                        bet=BetAmt.bet(Casino.cash);
                        do
                        {
                            number[0]=Choice.c("first");
                            number[1]=Choice.c("second");
                            number[2]=Choice.c("third");
                            number[3]=Choice.c("fourth");
                            if(number[0]==(number[1]|number[2]|number[3])||number[1]==(number[2]|number[3])||number[2]==number[3])
                                System.out.println("Numbers cannot be same!");
                        }while(number[0]==(number[1]|number[2]|number[3])||number[1]==(number[2]|number[3])||number[2]==number[3]);
                        System.out.println("Press Enter to roll!");
                        b.readLine();
                        Choice.delay(5,200);
                        byte ball=(byte)(generator.nextInt(36));
                        System.out.println("The ball stopped on "+ball);
                        Casino.cash=Choice.WinLoose(number,8,ball,bet,Casino.cash);
                    }
                    if(multiChoice==4)
                    {
                        bet=BetAmt.bet(Casino.cash);
                        do{
                            number[0]=Choice.c("first");
                            number[1]=Choice.c("second");
                            number[2]=Choice.c("third");
                            number[3]=Choice.c("fourth");
                            number[4]=Choice.c("fifth");
                            number[5]=Choice.c("sixth");
                            if(number[0]==(number[1]|number[2]|number[3]|number[4]|number[5])||number[1]==(number[2]|number[3]|number[4]|number[5])||number[2]==(number[3]|number[4]|number[5])||number[3]==(number[4]|number[5])||number[4]==number[5])
                                System.out.println("Numbers cannot be same!");
                        }while(number[0]==(number[1]|number[2]|number[3]|number[4]|number[5])||number[1]==(number[2]|number[3]|number[4]|number[5])||number[2]==(number[3]|number[4]|number[5])||number[3]==(number[4]|number[5])||number[4]==number[5]);
                        System.out.println("Press Enter to roll!");
                        b.readLine();
                        Choice.delay(5,200);
                        byte ball=(byte)(generator.nextInt(36));
                        System.out.println("The ball stopped on "+ball);
                        Casino.cash=Choice.WinLoose(number,5,ball,bet,Casino.cash);
                    }

                    if(multiChoice==5)
                    {
                        bet=BetAmt.bet(Casino.cash);
                        byte d=0, flag=0,dr=0,_flag=0;

                        do
                        {
                            System.out.println("Enter 1 for dozen, 2 for row");
                            try
                            {
                                dr=Byte.parseByte(b.readLine());
                            }
                            catch(Exception e)
                            {
                                System.out.println("Enter proper value!");
                                _flag=1;
                            }

                        }while(_flag==1);

                        if(dr==1)
                        {
                            for(i=0;;i++)
                            {
                                do
                                {
                                    flag=0;
                                    System.out.println("Enter 1 for 1st 12, 2 for 2nd 12 or 3 for 3rd 12.");
                                    try
                                    {
                                        d=Byte.parseByte(b.readLine());                                   
                                    }
                                    catch(NumberFormatException ex)
                                    {
                                        System.out.println("Enter proper value!");
                                        flag=1;
                                    }
                                }while(flag==1);
                                if(d>0&&d<4)
                                    break;
                                else
                                    System.out.println("Enter proper value!");    
                            }
                            if(d==1)
                            {
                                for(byte y=1;y<=12;y++)
                                {
                                    number[y-1]=y;
                                }
                            }
                            else if(d==2)
                            {
                                for(byte y=13;y<=24;y++)
                                {
                                    number[y-1]=y;
                                }
                            }
                            else if(d==3)
                            {
                                for(byte y=25;y<=36;y++)
                                {
                                    number[y-1]=y;
                                }
                            }
                        }

                        if(dr==2)
                        {
                            for(i=0;;i++)
                            {
                                do
                                {
                                    System.out.println("Enter 1 for 1st row, 2 for 2nd row or 3 for 3rd row.");
                                    try
                                    {
                                        d=Byte.parseByte(b.readLine());
                                    }
                                    catch(Exception ex)
                                    {
                                        System.out.println("Enter proper value!");
                                        flag=1;
                                    }
                                }while(flag==1);
                                if(d>0&&d<4)
                                    break;
                                else
                                    System.out.println("Enter proper value!");  
                            }
                            if(d==1)
                            {
                                for(byte y=1;y<=34;y+=3)
                                {
                                    number[y-1]=y;
                                }
                            }
                            else if(d==2)
                            {
                                for(byte y=2;y<=35;y+=3)
                                {
                                    number[y-1]=y;
                                }
                            }
                            else if(d==3)
                            {
                                for(byte y=3;y<=36;y+=3)
                                {
                                    number[y-1]=y;
                                }
                            }
                        }
                        else
                            f=1;    
                        System.out.println("Press Enter to roll!");
                        b.readLine();
                        Choice.delay(5,200);
                        byte ball=(byte)(generator.nextInt(36));
                        System.out.println("\f");
                        System.out.println("The ball stopped on "+ball);
                        Casino.cash=Choice.WinLoose(number,2,ball,bet,Casino.cash);
                    }
                    else if(multiChoice==6)
                    {
                        bet=BetAmt.bet(Casino.cash);
                        byte oe=0;
                        byte oddeven[]=new byte[18];
                        while(oe==0)
                        {
                            do
                            {
                                System.out.println("\nEnter 1 for odd(red) or 2 for even(black) numbers");                                
                                f=0;
                                try
                                {
                                    oe=Byte.parseByte(b.readLine());
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Enter proper value!");
                                    f=1;
                                }
                            }while(f==1); 
                            System.out.println("Press Enter to roll!");
                            b.readLine();
                            byte ball=(byte)(generator.nextInt(36));
                            System.out.println("\f");
                            System.out.println("The ball stopped on "+ball);
                            byte fl=0;
                            if(oe==1)
                            {
                                for(byte y=1;y<36;y+=2)
                                {
                                    if(y==ball)
                                    {
                                        fl=1;
                                        y=36;
                                    }
                                        
                                }
                            }

                            else if(oe==2)
                            {
                                for(byte y=0;y<36;y+=2)
                                {
                                    if(y==ball)
                                    {
                                        fl=1;
                                        y=36;
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Enter proper value!");
                                oe=0;
                            }
                            if(fl==1)
                            {
                                System.out.println("You win!");
                                Casino.cash+=bet;
                            }
                            else
                                Casino.cash-=bet;
                            
                            
                            
                            

                        }
                    }

                }
                if(betChoice<1&&betChoice>2)
                {
                    break;
                }  
            }
            else if(choice.equalsIgnoreCase("r"))
            {
                System.out.println("Roulette rules-");
                System.out.println("1.Game consists of a wheel and betting area.");
                System.out.println("2.You can either bet on single or multiple numbers.");
                System.out.println("3.You win if the ball stops on the betted number(s) otherwise you loose.");
                System.out.println("3.If you win you get the payout ammount plus your bet.");
                System.out.println("4.You loose your money of ball lands somewhere else.");
            }
            else if(choice.equalsIgnoreCase("l"))
            {
                System.out.println("\f");
                System.out.println("You leave with "+Casino.cash+" dollars.");
                return;
            }
            
            if(Casino.cash==0)
            {
                System.out.println("Looks like you are out of money!");
                return;
            }
            bet=0;
        }

    }
}


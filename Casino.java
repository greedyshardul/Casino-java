import java.io.*;
public class Casino
{
    static BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    static int cash=100;
    public static void main(String args[])throws Exception
    {        
        System.out.println("\f");
        System.out.println("Welcome to Casino Coyote Valley!");
        try
        {
            Thread.sleep(300);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        byte flag=0, user=0;
        for(int j=0;;j++)
        {
            for(int i=0;;i++)
            {
                System.out.println("\nYou have "+cash +" dollars.");

                do
                {
                    if(cash==0)
                    {
                        System.out.println("Looks like you are out of money!");
                        return;
                    }
                    flag=0;
                    System.out.println("\nWhich game would you like to play?(enter 0 to leave)");
                    System.out.println("1. Lucky 7");
                    System.out.println("2. Roulette");
                    System.out.println("3. Black Jack");
                    try
                    {
                        user=Byte.parseByte(b.readLine());
                    }
                    catch(Exception e)
                    {
                        System.out.println("Enter proper value!");
                        flag=1;
                    }
                }while(flag==1);
                if(user<0||user>3)
                {
                    System.out.println("Enter proper value!");
                    continue;
                }
                else
                    break;
            }

            if(user==1)
            {
                lucky7 L=new lucky7();
                L.main();

            }
            else if(user==2)
            {
                Roulette R=new Roulette();
                R.main();                
            }
            else if(user==3)
            {
                Blackjack B=new Blackjack();
                B.main();              
            }
            else if(user==0)
            {
                System.out.println("\nYou leave with "+cash+" dollars");
                return;
            }

        }
    }

    
}

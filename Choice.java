import java.io.*;
public class Choice
{
    static BufferedReader b=new BufferedReader(new InputStreamReader(System.in));

    static byte c(String ch)throws Exception
    {
        byte n=0;
        do
        {
            System.out.print("Enter "+ch+" number: ");
            try
            {
                n=Byte.parseByte(b.readLine());
                if((n<0)||(n>36))
                    System.out.println("Enter a proper value!");
            }
            catch(Exception x)
            {
                System.out.println("Enter a proper value!");
            }
        }while((n<0)||(n>36));
        return n;
    }

    static void delay(int x,int s)throws Exception
    {
        for(int i=0;i<x;i++)
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
    }

    static int WinLoose(byte[] i,int rate, byte ball,int bet,double cash)
    {
        byte flag=0;
        int d=0;
        for(byte x=0;x<i.length;x++)
        {
            if(i[x]==ball)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
        {
            System.out.println("You win!");
            cash+=bet*rate;
        }
        else
        {
            System.out.println("You loose!");
            cash-=bet;
        }
        d=(int)cash;
        return d;
    }

            
        
}



import java.io.*;
public class BetAmt
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int bet(int cash)
    {
        int b=0,f=0;
        for(int i=0;;i++)
        {
            do
            {
                f=0;
                System.out.println("How much to bet?");
                try
                {
                    b=Integer.parseInt(br.readLine());                
                }
                catch(Exception n)
                {
                    System.out.println("Enter a proper value!");
                }
            }while(f==1);
            if(b>cash)
                System.out.println("You can't bet more than you have!");
            else if(b<=0)
                System.out.println("Enter a proper value!");
            if(b>cash||b<=0)
                continue;
            else
                break;
        } 
        return b;
    }

}

import java.util.*;

public class program45
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a number:");
        int n=sc.nextInt();

        if(palin(n))
        System.out.printf("\n%d is a Palindrome number.",n);
        else
        System.out.printf("\n%d is NOT a Palindrome number.",n);
    }

    static boolean palin(int x)
    {
        int rev=0,t=x;
        while(t>0)
        {
            rev = rev*10 + (t%10);
            t/=10;
        }
       
        return (rev==x)?true:false;
    }
}
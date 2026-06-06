import java.util.*;

public class program43
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a number:");
        int n=sc.nextInt();

        if(isPrime(n))
            System.out.printf("\n%d is a Prime Number.",n);
        else
            System.out.printf("\n%d is NOT a Prime Number.",n);
    }

    static boolean isPrime(int x)
    {
       for(int i=2;i<(x/2);i++)
       {
            if(x%i==0)
                return false;
       }
       return true;
    }
}
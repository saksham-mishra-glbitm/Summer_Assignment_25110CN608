import java.util.*;

public class program25
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a number: ");
        int n=sc.nextInt();

        System.out.printf("\nFactorial of %d = %d.",n,factorial(n));
    }

    static long factorial(int x)
    {
        if(x<=1)
            return 1;
        return x*factorial(x-1);
    }
}
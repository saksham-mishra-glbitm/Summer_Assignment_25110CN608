import java.util.*;

public class program44
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a number:");
        int n=sc.nextInt();

        System.out.printf("\nFactorial of %d is = %d.",n,factorial(n));
    }

    static long factorial(int x)
    {
       return (x<=1)?1: (x*factorial(x-1));
    }
}
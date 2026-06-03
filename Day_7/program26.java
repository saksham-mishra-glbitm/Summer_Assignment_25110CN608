import java.util.*;

public class program26
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of sequence:");
        int n=sc.nextInt();
        System.out.print("\nFibonacci Series up to " + n + " elements:");

         for (int i=0; i<n; i++)
            System.out.print("   "+fibo(i));
    }

    static int fibo(int x)
    {
        if(x<=1)
            return x;
        return fibo(x-1)+fibo(x-2);
    }
}
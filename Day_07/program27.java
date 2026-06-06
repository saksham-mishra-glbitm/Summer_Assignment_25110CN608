import java.util.*;

public class program27
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the number:");
        int n=sc.nextInt();

        System.out.print("\nSum of digits in " + n + " = "+sumD(n)+".");
    }

    static int sumD(int x)
    {
        return  (x==0)?0:(x%10+sumD(x/10));
    }
}
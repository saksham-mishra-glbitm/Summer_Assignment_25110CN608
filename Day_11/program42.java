import java.util.*;

public class program42
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter two numbers respectively:");
        int a=sc.nextInt();
        int b=sc.nextInt();

        System.out.printf("\nMaximum of %d and %d = %d.",a,b,maxm(a,b));
    }

    static int maxm(int x, int y)
    {
        return (x>y)?x:y;
    }
}
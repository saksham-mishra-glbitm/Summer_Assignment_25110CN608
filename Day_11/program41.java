import java.util.*;

public class program41
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter two numbers respectively:");
        int a=sc.nextInt();
        int b=sc.nextInt();

        System.out.printf("\nSum of %d and %d = %d.",a,b,sum(a,b));
    }

    static int sum(int x, int y)
    {
        return (x+y);
    }
}
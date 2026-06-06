import java.util.*;

public class program28
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the number:");
        int n=sc.nextInt();

        System.out.print("\nReverse of " + n + " = "+rev(n,0)+".");
    }

    static int rev(int x,int r)
    {
        return  (x==0)?r:rev((x/10) , (r*10+x%10));
    }
}
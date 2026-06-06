import java.util.*;

public class program23
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a number: ");
        int n=sc.nextInt();
        int c=0,t=n;

        while(t>0)
        {
            t &= (t-1);
            c++;
        }

        System.out.printf("\nNumber of set bits in %d = %d.",n,c);
    }
}
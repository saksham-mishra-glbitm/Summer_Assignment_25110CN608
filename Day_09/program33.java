import java.util.*;

public class program33
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of pattern:");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=n-i;j>0;j--)
                System.out.print("* ");
            
            System.out.println();
        }
    }
}
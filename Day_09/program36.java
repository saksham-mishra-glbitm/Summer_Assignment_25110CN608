import java.util.*;

public class program36
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of pattern:");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0)||(j==0)||(j==(n-1))||(i==(n-1)))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }            
            System.out.println();
        }
    }
}
import java.util.*;

public class program38
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of pattern:");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)        //left spaces
                System.out.print("  ");

            for(int k=n-i;k>0;k--)      //left stars
                System.out.print("* ");

            for(int k=n-i-1;k>0;k--)    //right stars
                System.out.print("* ");

            System.out.println();
        }
    }
}
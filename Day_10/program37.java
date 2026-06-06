import java.util.*;

public class program37
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of pattern:");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=n-i;j>0;j--)      //left spaces
                System.out.print("  ");

            for(int k=0;k<=i;k++)       //left stars
                System.out.print("* ");

            for(int k=0;k<i;k++)        //right stars
                System.out.print("* ");

            System.out.println();
        }
    }
}
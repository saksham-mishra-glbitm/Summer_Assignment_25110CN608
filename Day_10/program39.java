import java.util.*;

public class program39
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of pattern:");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=n-i-1;j>0;j--)    //left spaces
                System.out.print("  ");

            for(int k=0;k<=i;k++)       //left stars
                System.out.print((k+1)+" ");

            for(int k=i;k>=1;k--)       //right stars
                System.out.print((k)+" ");

            System.out.println();
        }
    }
}
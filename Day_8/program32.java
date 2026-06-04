import java.util.*;

public class program32
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of pattern:");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
                System.out.print((i+1)+" ");
            
            System.out.println();
        }
    }
}
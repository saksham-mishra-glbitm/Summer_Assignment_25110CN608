import java.util.*;

public class program34
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of pattern:");
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=1;j<=(n-i);j++)
                System.out.print(j+" ");
            
            System.out.println();
        }
    }
}
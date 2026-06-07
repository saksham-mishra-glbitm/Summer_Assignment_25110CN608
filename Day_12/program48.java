import java.util.*;

public class program48
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a number:");
        int n=sc.nextInt();

        if(perfect(n))
        System.out.printf("\n%d is a Perfect number.",n);
        else
        System.out.printf("\n%d is NOT a Perfect number.",n);
    }

    static boolean perfect(int x)
    {
        int s=0;
        for(int i=1;i<=(x/2);i++)
        {
            if(x%i==0)
                s += i;
        }
       
        return (s==x)?true:false;
    }
}
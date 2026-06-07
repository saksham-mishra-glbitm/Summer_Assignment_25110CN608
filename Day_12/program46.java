import java.util.*;

public class program46
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a number:");
        int n=sc.nextInt();

        if(arms(n))
        System.out.printf("\n%d is an Armstrong number.",n);
        else
        System.out.printf("\n%d is NOT an Armstrong number.",n);
    }

    static boolean arms(int x)
    {
        int arm=0,t=x;
        int d=(x==0)?1:((int)Math.log10(t)+1);
        while(t>0)
        {
            arm += Math.pow((t%10),d);
            t/=10;
        }
       
        return (arm==x)?true:false;
    }
}
import java.util.*;

public class program24
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter x and y respectively: ");
        int x=sc.nextInt();
        int y=sc.nextInt();
        int pow=1;
        for(int i=1;i<=y;i++)
        {
            pow *= x;
        }        

        System.out.printf("\n%d^%d = %d.",x,y,pow);
    }
}
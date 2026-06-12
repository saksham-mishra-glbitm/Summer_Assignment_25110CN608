import java.util.*;

public class program61
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();       //input size
        int a[] =new int[n];
        System.out.println("Enter "+n+" elements in the array:");
        for(int i=0;i<n;i++)        //input elements
            a[i]=sc.nextInt();

        System.out.print("\nInput array:\t");       //display input array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");

        int xor=0;
        for(int i=0; i<=n; i++)     xor ^= i;       //XOR from 0 to n

        System.out.print("\nMissing element = "+xor+".");
        
        sc.close();        
    }
}
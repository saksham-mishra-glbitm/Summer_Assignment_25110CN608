import java.util.*;

public class program64
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();                           //input size
        int a[] =new int[n];
        System.out.println("Enter "+n+" elements in the array:");
        for(int i=0;i<n;i++)                            //input elements
            a[i]=sc.nextInt();

        System.out.print("\nInput array:\t");       //display input array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");

        int x=0, c=0;

        for(int i=0; i<n; i++)              //remove duplicates
        {
            c=0;
            for(int j=0; j<i; j++)          //check if element already exists before current index
                if(a[j] == a[i])
                    c++;
            
            if(c<1)                         //if not a duplicate, keep it
                a[x++] = a[i];
        }
        
        System.out.print("\nResultant array:\t");       //display array without duplicates
        for(int i=0;i<x;i++)
            System.out.print(a[i]+"   ");

        sc.close();        
    }
}
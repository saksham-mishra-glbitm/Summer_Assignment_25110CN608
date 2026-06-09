import java.util.*;

public class program51
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int a[] = new int [n];
        System.out.printf("Enter %d elements in the array:\n",n);
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();  
        
        int l=a[0]; int sml=a[n-1];
        System.out.printf("\nInput array:\t");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+"   "); 
            if(l<a[i])
                l=a[i];
            if(sml>a[i])
                sml=a[i];
        }

        System.out.printf("\nSmallest element of array = %d.\nLargest element of array = %d.",sml,l);
    }
}
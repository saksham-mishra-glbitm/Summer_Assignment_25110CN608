import java.util.*;

public class program57
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

        int l=0,r=n-1;
        while(l<r)          //reverse the array using two pointers
        {
            int t = a[l];
            a[l]=a[r];
            a[r]=t;
            l++;    r--;
        }

        System.out.print("\nReverse array:\t");       //display reversed array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");
        
        sc.close();        
    }
}
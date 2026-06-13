import java.util.*;

public class program71
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

        System.out.println("\nEnter the element to be searched:");
        int k = sc.nextInt();       //input target element
       
        System.out.print("\nInput array:\t");       //display input array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");
            
        int pos = bins(a,0,n-1,k);        //perform binary search
        
        if(pos>=0)
            System.out.println("\n\nSEARCH SUCCESSFULL!!!\nElement "+k+" found at position = "+(pos+1)+".");
        else
            System.out.println("\n\nSEARCH UNSUCCESSFULL!!!\nElement "+k+" not found .");        
    }

    static int bins(int[] a, int low, int high, int k)        //recursive binary search
    {
        if(low>high)        //base case: element not found
            return -1;

        int mid = (high-low)/2 + low;        //calculate mid to avoid overflow

        if(a[mid]==k)        //element found
            return mid;
        else if(a[mid]>k)        //search in left half
            return bins(a,low,mid-1,k);
        else        //search in right half
            return bins(a,mid+1,high,k);
    }
}
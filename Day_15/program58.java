import java.util.*;

public class program58
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

        System.out.println("Enter the number of left rotations:");
        int d=sc.nextInt();      //input number of rotations
        d = d%n;            //total effective rotations

        System.out.print("\nInput array:\t");           //display input array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");

        if(d>0)                 //perform only if needed
        {
            reverse(a,0,d-1);       // Reverse first d elements            
            reverse(a,d,n-1);           // Reverse remaining n-d elements            
            reverse(a,0,n-1);       // Reverse entire array
        }

        System.out.print("\nResultant array:\t");       //display resultant array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");
        
        sc.close();        
    }
    static void reverse(int arr[], int l, int r)    //method to reverse array from index 'l' to 'r'
    {
        while(l<r)
        {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;    r--;
        }
    }
}
import java.util.*;

public class program69
{
    public static void main(String[] sm) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n =sc.nextInt();       //input size
        System.out.println("Enter "+(n)+" integers in the array: ");
        int[] arr =new int[n];
        for(int i=0;i<n;i++)        //input elements
        {
            arr[i]=sc.nextInt();
        }
        System.out.print("Input Array:\t");
        print(arr);
        sort(arr,n);        //sort the array using bubble sort
        System.out.print("\nSorted Array:\t");
        print(arr);
        sc.close();
    }

    static void sort(int[] arr, int n)        //bubble sort implementation
    {
        for(int i=0;i<n-1;i++)
        {
            boolean flag=false;        //optimization flag
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])        //swap if out of order
                {
                    int x=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=x;
                    flag=true;
                }                
            }
            if(!flag)        //if no swaps, array is sorted
                break;
        }        
    }

    static void print(int[] arr)        //display array elements
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+"  ");
        }
    }
    //time complexity = O(n^2)
}
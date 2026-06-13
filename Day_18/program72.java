import java.util.*;

public class program72
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
        quicksort(arr,0,n-1);        //sort using quick sort
        System.out.print("\nSorted Array:\t");
        print(arr);
        sc.close();
    }

    static void quicksort(int[] arr, int low, int high)        //recursive quick sort
    {
        if(low<high)
        {
            int pi=partition(arr,low,high);        //get partition index
            quicksort(arr,low,pi-1);        //sort left subarray
            quicksort(arr,pi+1,high);        //sort right subarray
        }
    }

    static int partition(int[] arr,int low, int high)        //partition using last element as pivot
    {
        int pivot = arr[high];                             //choose pivot
        int i=low-1;                                        //index of smaller element
        for(int j=low;j<high;j++)
        {
            if(arr[j]>pivot)        //for ascending: arr[j] < pivot
            {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;        //place pivot at correct position
        int temp=arr[i];
        arr[i]=pivot; 
        arr[high]=temp;
        return i;        //return partition index
    } 

    static void print(int[] arr)        //display array elements
    {
        for(int i=0;i<arr.length;i++)        
            System.out.print(arr[i]+" ");
        
    }
    //time complexity = O(n logn)
}
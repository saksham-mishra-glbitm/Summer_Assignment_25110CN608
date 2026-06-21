import java.util.*;

public class program99
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter number of names: ");
        int n = Integer.parseInt(sc.nextLine().trim());        //input number of names

        String[] names = new String[n];

        System.out.println("Enter " +n+ " names:");
        for (int i = 0; i<n; i++)        //input names
            names[i] = sc.nextLine().trim();

        System.out.print("\nOriginal names:");
        for (String name : names)        //display original names
            System.out.printf("   \"%s\"",name);

        quicksort(names,0,n-1);        //sort alphabetically

        System.out.print("\n\nSorted names (alphabetically):");
        for (String name : names)        //display sorted names
            System.out.printf("   \"%s\"",name);
            
        sc.close();
    }

    static void quicksort(String[] arr, int low, int high)        //recursive quicksort
    {
        if(low<high)
        {
            int pi=partition(arr,low,high);
            quicksort(arr,low,pi-1);
            quicksort(arr,pi+1,high);
        }
    }

    static int partition(String[] arr,int low, int high)        //partition using compareTo
    {
        String pivot = arr[high];
        int i=low-1;
        for(int j=low;j<high;j++)
        {
            if(arr[j].compareTo(pivot) < 0)        //alphabetical comparison
            {
                i++;
                String temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        String temp=arr[i];
        arr[i]=pivot; 
        arr[high]=temp;
        return i;
    } 
}
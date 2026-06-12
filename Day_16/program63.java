import java.util.*;

public class program63
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

        System.out.print("\nEnter the target sum: ");
        int target = sc.nextInt();       //input target sum

        System.out.print("\nInput array:\t");       //display input array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");

        Map<Integer,Integer> map = new HashMap<>();
        boolean pairFound = false;        //flag to track if any pair is found
        
        for(int i=0;i<n;i++)                     //find pair with given sum
        {
            int dv = target - a[i];

            if(map.containsKey(dv))            //complement exists in map?
            {
                if(!pairFound)        //print header only once when first pair is found
                {
                    System.out.println("\n\nPairs(if any) are:-");
                    pairFound = true;
                }
                System.out.println("\nIndices: [" + map.get(dv) + ", " + i + "]");
                System.out.println("Values:  [" + dv + ", " + a[i] + "]");
            }
            map.put(a[i], i);               //store current element with its index
        }
        
        if(!pairFound)               //print message if no pairs found
            System.out.println("\n\nNo pairs found whose sum is " +target+".");

        sc.close();        
    }
}
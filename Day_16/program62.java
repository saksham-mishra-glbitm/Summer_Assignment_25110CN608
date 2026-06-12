import java.util.*;

public class program62
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

        Map<Integer,Integer> map = new HashMap<>();
        for(int num : a)                         //count frequency of each element
            map.merge(num,1,Integer::sum);

        int max=a[0], mc=0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
            {       
            if (entry.getValue()>mc)      //find element with max frequency
            {
                mc = entry.getValue();
                max = entry.getKey();
            }
        }        

        System.out.println("\nMaximum frequency element = "+max+" with frequency = "+mc+".");
        
        sc.close();        
    }
}
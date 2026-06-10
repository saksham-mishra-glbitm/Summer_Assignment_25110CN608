import java.util.*;

public class program54
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();                        //input size
        int a[] =new int[n];
        System.out.println("Enter "+n+" elements in the array:");
        for(int i=0;i<n;i++)                          //input elements
            a[i]=sc.nextInt();

        System.out.println("\nEnter the element whose frequency is to be found:");
        int k = sc.nextInt();                        //input target
       
        System.out.print("\nInput array:\t");       //display input array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");
            
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : a)
            map.merge(num,1,Integer::sum);      //count frequency of each element

        System.out.println("\nFrequency of "+k+" in the array = "+map.getOrDefault(k, 0)+".");
        
        sc.close();        
    }
}
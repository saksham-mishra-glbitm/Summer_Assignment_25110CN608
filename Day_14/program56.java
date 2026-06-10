import java.util.*;

public class program56
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

        for(int i: a)
            map.merge(i,1,Integer::sum);        //count frequency of each element

        System.out.print("\nDuplicates in the array are the elements:\t");
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            if(entry.getValue() > 1)                    //print elements with frequency > 1
                System.out.print(entry.getKey() + "   ");
        
        sc.close();        
    }
}
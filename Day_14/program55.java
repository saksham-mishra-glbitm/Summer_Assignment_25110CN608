import java.util.*;

public class program55
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

        int f=a[0],sec=a[1];        //initialize largest and second largest

        for(int i:a)            //find second largest
        {
            if(i>f)
            {
                sec = f;
                f = i;
            }
            else if(i>sec && i!=f)
                sec = i;
        }

        System.out.println("\nSecond largest element in the array = "+sec+".");
        
        sc.close();        
    }
}
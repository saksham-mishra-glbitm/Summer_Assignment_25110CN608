import java.util.*;

public class program60
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

        int x = 0;
        for(int i=0;i<n;i++)        //move all non-zero elements to front
            if(a[i]!=0)
                a[x++]=a[i];
        
        while(x<n)                  //fill remaining positions with zeros
            a[x++]=0;     

        System.out.print("\nResultant array:\t");       //display modified array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");
        
        sc.close();        
    }
}
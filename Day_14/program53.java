import java.util.*;

public class program53
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

        System.out.println("\nEnter the element to be searched:");
        int k = sc.nextInt();       //input target
       
        System.out.print("\nInput array:\t");       //display input array
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"   ");
            
        int pos=-1;
        for(int i=0;i<n;i++)
        {
            if(a[i]==k)
            {
                pos = i+1;          //store the position
                break;
            }
        }
        
        if(pos>0)               //print result
            System.out.println("\n\nSEARCH SUCCESSFULL!!!\nElement "+k+" found at position = "+pos+".");
        else
            System.out.println("\n\nSEARCH UNSUCCESSFULL!!!\nElement "+k+" not found .");
        
        sc.close();        
    }
}
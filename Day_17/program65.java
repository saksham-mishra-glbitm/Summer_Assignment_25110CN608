import java.util.*;

public class program65
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of the first array:");
        int n1 = sc.nextInt();       //input size of first array
        System.out.println("Enter the size of the second array:");
        int n2 = sc.nextInt();       //input size of second array
        int a[] =new int[n1];
        int b[] =new int[n2];
        System.out.println("Enter "+n1+" elements in the first array:");
        for(int i=0;i<n1;i++)        //input elements of first array
            a[i]=sc.nextInt();
        System.out.println("Enter "+n2+" elements in the second array:");
        for(int i=0;i<n2;i++)        //input elements of second array
            b[i]=sc.nextInt();

        System.out.print("\nArray 1:\t");       //display first array
        for(int i=0;i<n1;i++)
            System.out.print(a[i]+"   ");
        System.out.print("\nArray 2:\t");       //display second array
        for(int i=0;i<n2;i++)
            System.out.print(b[i]+"   ");

        int[] c = new int[n1+n2];        //create result array

        for(int i=0;i<n1;i++)        //copy first array
            c[i]=a[i];
        for(int i=0;i<n2;i++)        //copy second array
            c[n1+i]=b[i];
        
        System.out.print("\nResultant array:\t");       //display merged array
        for(int i=0;i<c.length;i++)
            System.out.print(c[i]+"   ");

        sc.close();        
    }
}
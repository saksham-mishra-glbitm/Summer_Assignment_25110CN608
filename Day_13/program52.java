import java.util.*;

public class program52
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int a[] = new int [n];
        System.out.printf("Enter %d elements in the array:\n",n);
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();  
        
        int e=0,o=0;
        System.out.printf("\nInput array:\t");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+"   "); 
            if(a[i]%2==0)
                e++;
            else
                o++;
        }

        System.out.printf("\nOdd elements = %d.\nEven elements = %d.",o,e);
    }
}
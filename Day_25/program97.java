import java.util.*;

public class program97
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of the first array:");
        int n1 = sc.nextInt();        //input size of first array
        System.out.println("Enter the size of the second array:");
        int n2 = sc.nextInt();        //input size of second array
        int a[] = new int[n1];
        int b[] = new int[n2];
        System.out.println("Enter "+n1+" sorted elements in the first array:");
        for(int i=0;i<n1;i++) a[i]=sc.nextInt();        //input first sorted array
        System.out.println("Enter "+n2+" sorted elements in the second array:");
        for(int i=0;i<n2;i++) b[i]=sc.nextInt();        //input second sorted array

        int[] c = new int[n1+n2];        //result array
        int i=0, j=0, k=0;

        while(i<n1 && j<n2) {        //merge while both arrays have elements
            c[k++] = (a[i] < b[j]) ? (a[i++]) : (b[j++]);
        }

        while(i<n1) c[k++] = a[i++];        //copy remaining elements of first array
        while(j<n2) c[k++] = b[j++];        //copy remaining elements of second array
        
        System.out.print("\nResultant array:\t");
        for(int val : c) System.out.print(val+"   ");

        sc.close();        
    }
}
import java.util.*;

public class program67
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of the first array:");
        int n1 = sc.nextInt();       //input size of first array
        System.out.println("Enter the size of the second array:");
        int n2 = sc.nextInt();       //input size of second array
        int a[] = new int[n1];
        int b[] = new int[n2];
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

        Set<Integer> s1 = new HashSet<>();        //set for first array
        Set<Integer> s2 = new HashSet<>();        //set for intersection result

        for(int num: a)                           //add all elements of first array
            s1.add(num);

        for(int num: b)                           //find common elements
            if(s1.contains(num))                  //if element exists in first array
                s2.add(num);        
        
        System.out.print("\nIntersection of the two arrays:\t");       //display intersection
        for(int num: s2)
            System.out.print(num+"   ");

        sc.close();        
    }
}
import java.util.*;

public class program68
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

        Map<Integer,Integer> map = new HashMap<>();     //store frequency of elements in first array
        List<Integer> list = new ArrayList<>();        //store intersection

        for(int num: a)                              //count frequency of each element in first array
            map.merge(num,1,Integer::sum);

        for(int num: b)                                          //find common elements
        {
            if(map.getOrDefault(num, 0)>0)        //if element exists with remaining count
            {
                list.add(num);                      //add to result
                map.put(num,map.get(num)-1);        //decrement count
            }
        }  
    
        System.out.print("\nResultant array:\t");       //display intersection with duplicates
        for(int i=0; i<list.size(); i++)
            System.out.print(list.get(i)+"   ");

        sc.close();        
    }
}
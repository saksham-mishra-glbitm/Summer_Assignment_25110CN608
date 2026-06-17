import java.util.*;

public class program87
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine().trim();        //input string
        System.out.printf("\nInput String: \"%s\".\n",s1);

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++)        //count frequency of each character
            map.merge(s1.charAt(i),1,Integer::sum);

        System.out.println("\nFrequency of:-");

        for(Map.Entry<Character,Integer> entry: map.entrySet())        //display frequencies
            if(entry.getKey()!=' ')        //skip spaces
                System.out.printf("'%c' = %d.\n",entry.getKey(),entry.getValue());
            
        sc.close();
    }
}
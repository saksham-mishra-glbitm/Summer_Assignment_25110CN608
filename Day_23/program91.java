import java.util.*;

public class program91
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter first string: ");
        String s1 = sc.nextLine().trim();
        System.out.println("Enter second string: ");
        String s2 = sc.nextLine().trim();
        System.out.printf("\nInput Strings are: \"%s\" and \"%s\".\n",s1,s2);        
        
        s1 = s1.replaceAll(" ", "");        //remove spaces from first string
        s2 = s2.replaceAll(" ", "");        //remove spaces from second string
        
        if(s1.length()!=s2.length())        //check if lengths are equal
        {
            System.out.println("\nThe entered strings are NOT Anagrams of each other.");
            sc.close();
            return;
        }

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i=0;i<s1.length();i++)        //count frequency in first string
            map1.merge(s1.charAt(i),1,Integer::sum);
        for(int i=0;i<s2.length();i++)        //count frequency in second string
            map2.merge(s2.charAt(i),1,Integer::sum);

        for(Map.Entry<Character,Integer> entry: map1.entrySet())        //compare frequencies
        {
            int see = map2.getOrDefault(entry.getKey(), 0);
            if(see != entry.getValue())        //if frequency mismatch
            {
                System.out.println("\nThe entered strings are NOT Anagrams of each other.");
                sc.close();
                return;
            }
        }
        System.out.println("\nThe entered strings are Anagrams of each other.");
        
        sc.close();
    }
}
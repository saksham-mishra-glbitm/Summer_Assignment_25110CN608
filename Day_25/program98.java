import java.util.*;

public class program98
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter first string: ");
        String s1 = sc.nextLine().trim().replaceAll(" ","");        //input first string
        System.out.println("Enter second string: ");
        String s2 = sc.nextLine().trim().replaceAll(" ","");        //input second string
        System.out.printf("\nInput Strings are: \"%s\" and \"%s\".\n",s1,s2);        
        
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        String n = "";        //build result string

        for(char c: s1.toCharArray())        //add characters of first string
            set1.add(c);      
        for(char c: s2.toCharArray())        //add characters of second string
            set2.add(c);  

        for(char c: set1)        //find common characters
        {
            if(set2.contains(c))
                n += c;        //string concatenation in loop
        }

        if(n.length() > 0)
        {
            System.out.printf("\nCommon characters are:");
            for(int i=0;i<n.length();i++)
                System.out.printf("\t'%c'", n.charAt(i));
        }
        else
            System.out.println("\nNo common characters.");
        
        sc.close();
    }
}
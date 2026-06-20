import java.util.*;

public class program93
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter first string (with no whitespaces): ");
        String s1 = sc.nextLine().trim().replaceAll(" ","");        //input first string
        System.out.println("Enter second string (with no whitespaces): ");
        String s2 = sc.nextLine().trim().replaceAll(" ","");        //input second string
        System.out.printf("\nInput Strings are: \"%s\" and \"%s\".\n",s1,s2);        
        
        if(s1.length()!=s2.length() || s1.length()==0)        //check length equality and non-empty
        {
            System.out.println("\nThe entered strings are NOT rotations of each other.");
            sc.close();
            return;
        }
        
        s1 = s1+s1;        //concatenate string with itself
        if(!s1.contains(s2))        //check if s2 is substring of s1+s1
        {
            System.out.println("\nThe entered strings are NOT rotations of each other.");
            sc.close();
            return;
        }

        System.out.println("\nThe entered strings are valid Rotations of each other.");
        
        sc.close();
    }
}
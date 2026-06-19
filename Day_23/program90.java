import java.util.*;

public class program90
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine().trim();
        System.out.printf("\nInput String: \"%s\".\n",s1);

        boolean found = false;
        
        for(int i=0;i<s1.length();i++)
        {
            char ch = s1.charAt(i);
            if(s1.indexOf(ch) != s1.lastIndexOf(ch))
            {
                System.out.printf("\nFirst repeating character is '%c' at index = %d.\n", ch, i);
                found = true;
                break;
            }
        }
        
        if(!found)
            System.out.println("\nNo repeating character found in the string.");
        
        sc.close();
    }
}
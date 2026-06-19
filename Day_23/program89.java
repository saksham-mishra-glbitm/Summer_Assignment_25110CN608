import java.util.*;

public class program89
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine().trim();        //input string
        System.out.printf("\nInput String: \"%s\".\n",s1);

        for(int i=0;i<s1.length();i++)        //find first non-repeating character
        {
            char ch = s1.charAt(i);
            if(s1.indexOf(ch)==s1.lastIndexOf(ch))        //check if character appears only once
            {
                System.out.printf("\nFirst non-repeating character is '%c' at index = %d.\n",ch,i);
                break;
            }
        }
        
        sc.close();
    }
}
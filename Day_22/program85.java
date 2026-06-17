import java.util.*;

public class program85
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine();        //input string
        String rev="";

        for(int i=0;i<s1.length();i++)        //reverse string using concatenation
            rev += s1.charAt(s1.length()-i-1);
        
        if(rev.equals(s1))        //check if palindrome
            System.out.printf("\n\"%s\" is a Palindome String.",s1);
        else
            System.out.printf("\n\"%s\" is NOT a Palindome String.",s1);

        sc.close();
    }
}
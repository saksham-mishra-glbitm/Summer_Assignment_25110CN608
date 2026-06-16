import java.util.*;

public class program83
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String str = sc.nextLine().trim().toLowerCase();        //input string
        int v=0,c=0;
        System.out.printf("\nInput String: \"%s\".",str);
        String vowels = "aeiou";
        for(int i=0;i<str.length();i++)        //count vowels and consonants
        {
            if(vowels.contains(Character.toString(str.charAt(i))))        //check if vowel
                v++;
            else if(str.charAt(i)!=' '  && Character.isLetter(str.charAt(i)))        //check if consonant
                c++;
        }
        
        System.out.printf("\nNumber of vowels = %d.\nNumber of consonants = %d.",v,c);
        
        sc.close();
    }
}
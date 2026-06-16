import java.util.*;

public class program81
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine();       //input string
        
        int len=0;

        for(char c: s1.toCharArray())        //count characters
            len++;

        System.out.printf("\nLength of \"%s\" = %d.",s1,len);
        
        sc.close();
    }
}
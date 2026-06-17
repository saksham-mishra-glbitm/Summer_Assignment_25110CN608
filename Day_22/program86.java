import java.util.*;

public class program86
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine().trim();        //input string

        StringTokenizer st = new StringTokenizer(s1," ");        //split by space
        int c = st.countTokens();        //count words

        System.out.printf("\nNumber of words in \"%s\" = %d.",s1,c);
        
        sc.close();
    }
}
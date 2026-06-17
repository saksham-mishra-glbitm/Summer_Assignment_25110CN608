import java.util.*;

public class program88
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine().trim();        //input string

        System.out.printf("\nInput String: \"%s\".\n",s1);
        s1 = new String(s1.replaceAll(" ", ""));        //remove all spaces
        System.out.printf("\nResultant String: \"%s\".\n",s1);        
        
        sc.close();
    }
}
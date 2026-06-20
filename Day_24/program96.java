import java.util.*;

public class program96
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine().trim().replaceAll(" ","");        //input string, remove spaces
        System.out.printf("\nInput String: \"%s\".\n",s1);        
        
        Set<Character> set = new HashSet<>();
        
        String n="";        //build result string

        for(char c: s1.toCharArray())        //remove duplicate characters
        {
            if(set.contains(c))
                continue;

            set.add(c);
            n+=c;        //string concatenation in loop
        }        

        System.out.println("\nResultant String: \""+n+"\".\n");
        
        sc.close();
    }
}
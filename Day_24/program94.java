import java.util.*;

public class program94
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine().trim().replaceAll(" ","");        //input string
        System.out.printf("\nInput String: \"%s\".\n",s1);        
        
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        
        for(char c: s1.toCharArray())        //count frequency of each character
            map.merge(c,1,Integer::sum);

        StringBuilder sb = new StringBuilder();

        for(char c: s1.toCharArray())        //build compressed string
        {
            if(set.contains(c))
                continue;

            set.add(c); 
            sb.append(c).append(map.get(c));
        }        

        String n = sb.toString();
        System.out.println("\nCompressed String: \""+n+"\".\n");
        
        sc.close();
    }
}
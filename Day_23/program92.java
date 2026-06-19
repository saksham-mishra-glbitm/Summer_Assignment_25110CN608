import java.util.*;

public class program92
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine().trim();        //input string
        System.out.printf("\nInput String: \"%s\".\n",s1);        
        s1 = new String(s1.replaceAll(" ", ""));        //remove spaces

        Map<Character,Integer> map1 = new HashMap<>();

        for(char c: s1.toCharArray())        //count frequency of each character
            map1.merge(c,1,Integer::sum);

        char chh = '\0'; 
        int occ = 0;
        for(Map.Entry<Character,Integer> entry: map1.entrySet())        //find character with max frequency
        {
            if(occ < entry.getValue() && entry.getKey() != ' ')        //skip spaces
            {
                occ = entry.getValue();
                chh = entry.getKey();
            }
        }

        System.out.printf("\nMaximum occuring character is '%c' which occurs %d time(s).\n", chh, occ);
        
        sc.close();
    }
}
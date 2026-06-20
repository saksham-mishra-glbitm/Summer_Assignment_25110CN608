import java.util.*;

public class program95
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine().trim();        //input string
        System.out.printf("\nInput String: \"%s\".\n",s1);        
        
        String[] reg = s1.split(" ");        //split by space

        int max=0;
        String mx="";

        for(int i=0;i<reg.length;i++)        //find longest word
        {
            if(reg[i].length() > max)
            {
                max = reg[i].length();
                mx = reg[i];
            }
        }

        System.out.printf("\nLongest Word is \"%s\" with length = %d.\n", mx, max);
        
        sc.close();
    }
}
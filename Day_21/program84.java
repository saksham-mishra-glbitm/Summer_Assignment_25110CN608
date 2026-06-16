import java.util.*;

public class program84
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String str = sc.nextLine().trim().toLowerCase();        //input string
        char[] chs = str.toCharArray();

        System.out.printf("\nInput String: \"%s\".",str);
        
        for(int i=0;i<chs.length;i++)        //toggle case using XOR
        {
            if(chs[i]==' ')
                continue;
            chs[i] = (char)(chs[i] ^ 32);        //XOR with 32 toggles case
        }

        str = new String(chs);
        
        System.out.printf("\nResultant String: \"%s\".",str);
        
        sc.close();
    }
}
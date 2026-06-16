import java.util.*;

public class program82
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter a string: ");
        String s1 = sc.nextLine();       //input string
        char[] chs = s1.toCharArray();        //convert string to char array
        System.out.printf("\nInput String: \"%s\".",s1);

        for(int i=0,j=(chs.length-1);i<(chs.length/2);i++,j--)        //reverse using two pointers
        {
            char c = chs[i];
            chs[i]=chs[j];
            chs[j]=c;
        }

        s1 = new String(chs);        //convert back to string
        
        System.out.printf("\nReverse String: \"%s\".",s1);
        
        sc.close();
    }
}
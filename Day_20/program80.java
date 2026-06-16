import java.util.*;

public class program80
{
    static Scanner sc = new Scanner(System.in);

    static void read(int n,int mat[][])        //read matrix elements
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                mat[i][j]=sc.nextInt();
        }
    }
    
    static void print(int n,int mat[][])        //display matrix
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)            
                System.out.printf("%d\t",mat[i][j]);

            System.out.printf("\n");
        }
    }
    
    static void csum(int n, int mat[][])        //calculate and display column-wise sums
    {
        for(int i=0;i<n;i++)
        {
            System.out.printf("\nSum of column %d = ",(i+1));
            int cs=0;
            for(int j=0;j<n;j++)
                cs+=mat[j][i];        //column index i fixed, row index j varies
            System.out.printf("%d.",cs);
        }
    }

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of the matrix: ");
        int n =sc.nextInt();       //input matrix size

        int mat[][] = new int[n][n];

        //INPUT-->
        System.out.printf("\nEnter %d elements in the matrix:\n",(n*n));
        read(n,mat);        //input matrix

        //PRINT-->
        System.out.printf("\nMATRIX:\n");
        print(n,mat);        //display matrix

        //COLUMN-WISE SUM-->
        System.out.printf("\n<---COLUMN-WISE SUM--->\n");
        csum(n,mat);        //display sum of each column

        sc.close();
    }
}
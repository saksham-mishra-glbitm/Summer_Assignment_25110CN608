import java.util.*;

public class program78
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
    
    static void transpose(int n, int mat[][])        //display transpose of matrix
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.printf("%d\t",mat[j][i]);
            }
            System.out.printf("\n");
        }
    }

    static boolean symmetric(int n, int mat[][])        //check if matrix is symmetric
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                if(mat[i][j] != mat[j][i])        //compare element with its transpose
                    return false;
        }
        return true;
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

        //SYMMETRIC CHECK-->
        System.out.printf("\nTranspose Matrix:\n");
        transpose(n,mat);        //display transpose
        
        if(symmetric(n,mat))        //check symmetry
            System.out.println("\nThe Matrix is a Symmetric Matrix.");
        else
            System.out.println("\nThe Matrix is NOT a Symmetric Matrix.");

        sc.close();
    }
}
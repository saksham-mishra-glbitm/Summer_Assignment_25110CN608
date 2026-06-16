import java.util.*;

public class program77
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
    
    static void multiplication(int n, int mat1[][], int mat2[][])        //multiply two matrices
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int x=0;
                for(int k=0;k<n;k++)        //dot product of row i and column j
                    x += mat1[i][k] * mat2[k][j];                
                System.out.printf("%d\t",x);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] sm)
    {
        System.out.println("Enter the size of the two matrices: ");
        int n =sc.nextInt();       //input matrix size

        int mat1[][] = new int[n][n];
        int mat2[][] = new int[n][n];

        //INPUT-->
        System.out.printf("\nEnter %d elements in the matrix 1:\n",(n*n));
        read(n,mat1);        //input first matrix
        System.out.printf("\nEnter %d elements in the matrix 2:\n",(n*n));
        read(n,mat2);        //input second matrix

        //PRINT-->
        System.out.printf("\nMATRIX 1:\n");
        print(n,mat1);        //display first matrix
        System.out.printf("\nMATRIX 2:\n");
        print(n,mat2);        //display second matrix

        //MULTIPLICATION-->
        System.out.printf("\nMatrix after multiplication:\n");
        multiplication(n,mat1,mat2);        //display multiplication result

        sc.close();
    }
}
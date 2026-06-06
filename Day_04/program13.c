#include "stdio.h"
int main()
{
    int n;
    printf("Enter the number of terms: ");
    scanf("%d",&n);
    printf("\nFibonacci series till %d:",n);
    int a=-1;
    int b=1;
    
    while(n>0)
    {
        int s=a+b;
        printf("\t%d",s);
        a=b;
        b=s;
        n--;
    }
    
    
    return 0;
}
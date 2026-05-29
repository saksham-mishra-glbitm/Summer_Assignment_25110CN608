#include "stdio.h"

int main()
{
    int n;
    printf("Enter the number: ");
    scanf("%d",&n);

    int rev=0,t=n; 

    while(t>0)
    {
        rev = rev*10 + (t%10);
        t/=10;
    }

    printf("\nReverse of %d = %d.",n,rev);
    
    return 0;
}
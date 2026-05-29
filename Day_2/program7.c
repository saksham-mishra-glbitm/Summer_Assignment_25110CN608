#include "stdio.h"

int main()
{
    int n;
    printf("Enter the number: ");
    scanf("%d",&n);

    int pd=1,t=n; 

    while(t>0)
    {
        pd*= (t%10);
        t/=10;
    }

    printf("\nProduct of digits of %d = %d.",n,pd);
    
    return 0;
}
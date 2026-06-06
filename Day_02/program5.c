#include "stdio.h"

int main()
{
    int n;
    printf("Enter the number: ");
    scanf("%d",&n);

    int sd=0,t=n; 

    while(t>0)
    {
        sd+=(t%10);
        t/=10;
    }

    printf("\nSum of digits of %d = %d.",n,sd);
    
    return 0;
}
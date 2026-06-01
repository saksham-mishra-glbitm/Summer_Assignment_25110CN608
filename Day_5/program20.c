#include "stdio.h"

int isPrime(int x)
{
    int c=0;
    for(int i=2;i<=(x/2);i++)
    {
        if(x%i==0)
            c++;
    }
    return c;
}

int main()
{
    int n;
    printf("Enter a number: ");
    scanf("%d",&n);
    int lp=0;
    for(int i=1;i<=n;i++)
    {
        if((n%i==0)&&(isPrime(i)==0))
            lp=i;
    }

    printf("\nLargest Prime Factor of %d is = %d.",n,lp);

    return 0;
}
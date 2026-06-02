#include "stdio.h"

int main()
{
    long n;
    printf("Enter a decimal number: ");
    scanf("%ld",&n);
    long t=n,b=0,i=0;
    long revbin=0,bin=0;

    while(t>0)
    {
        revbin = revbin*10 + (t%2);
        t/=2;
        b++;
    }

    while(i<b)
    {
        bin = bin*10 + (revbin%10);
        revbin/=10;
        i++;
    }


    printf("\nBinary equivalent of %ld is = %ld.",n,bin);

    return 0;
}
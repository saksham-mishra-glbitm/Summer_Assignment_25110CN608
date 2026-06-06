#include "stdio.h"
#include <math.h>
int main()
{
    long n;
    printf("Enter a binary number: ");
    scanf("%ld",&n);
    long t=n;
    long dec=0;
    int d=0;
    while(t>0)
    {
        dec += (t%10) * pow(2,d); 
        t/=10;
        d++;
    }

    printf("\nDecimal equivalent of %ld is = %ld.",n,dec);

    return 0;
}
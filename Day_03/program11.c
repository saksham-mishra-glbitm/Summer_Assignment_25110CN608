#include "stdio.h"
#include "math.h"
#define MIN(a,b) ((a<b)?a:b)
int main()
{
    int a,b;
    printf("Enter two numbers:\n");
    scanf("%d",&a);
    scanf("%d",&b);
    int gcd=0;

    for(int i=1;i<(MIN(a,b)/2);i++)
    {
        if(a%i==0 && b%i==0)
            gcd=i;
    }
    
    printf("\nGCD of %d and %d = %d.",a,b,gcd);
    return 0;
}
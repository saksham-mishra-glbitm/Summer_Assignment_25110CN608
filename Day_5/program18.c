#include "stdio.h"

int factorial(int x);
int main()
{
    int n;
    printf("Enter a number: ");
    scanf("%d",&n);

    int s=0,t=n;
    while(t>0)
    {
        s+=factorial(t%10);
        t/=10;
    }

    if(s==n)
        printf("\n%d is a Strong number.",n);
    else
        printf("\n%d is NOT a Strong number.",n);

    return 0;
}
int factorial(int x)
{
    int f=1;
    for(int i=1;i<=x;i++)
        f*=i;
    return f;
}
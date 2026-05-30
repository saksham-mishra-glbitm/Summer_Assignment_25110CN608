#include "stdio.h"

int main()
{
    int n;
    printf("Enter the number: ");
    scanf("%d",&n);

    int c=0;
    for(int i=2;i<(n/2);i++)
    {
        if(n%i==0)
            c++;
    }

    if(c>0)
        printf("\n%d is NOT a Prime number.",n);
    else
        printf("\n%d is a Prime number.",n);
    return 0;
}
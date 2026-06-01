#include "stdio.h"

int main()
{
    int n;
    printf("Enter a number: ");
    scanf("%d",&n);

    int s=0;
    for(int i=1;i<=(n/2);i++)
    {
        if(n%i==0)
            s+=i;
    }

    if(s==n)
        printf("\n%d is a Perfect number.",n);
    else
        printf("\n%d is NOT a Perfect number.",n);
}
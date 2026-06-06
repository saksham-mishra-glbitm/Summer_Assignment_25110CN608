#include "stdio.h"

int isPrime(int n);
int main()
{
    int a,b;
    printf("Enter starting number: ");
    scanf("%d",&a);
    printf("Enter ending number: ");
    scanf("%d",&b);
    printf("\nPrime numbers between %d and %d are:",a,b);
    for(int i=a;i<=b;i++)
    {
        if(isPrime(i)==0)
            printf("\t%d",i);
    }
    
    return 0;
}

int isPrime(int n)
{
    int c=0;
    for(int i=2;i<(n/2);i++)
    {
        if(n%i==0)
            c++;
    }

    return c;
}
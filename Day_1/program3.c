#include <stdio.h>

int main()
{
    int n;
    printf("Enter the number: ");
    scanf("%d",&n);
    long long fact=1;    

    for(int i=1;i<=n;i++)
        fact*=i;

    printf("\nFactorial of %d = %ld.",n,fact);
    
    return 0;
}
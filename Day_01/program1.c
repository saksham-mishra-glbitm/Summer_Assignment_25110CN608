#include <stdio.h>

int main()
{
    int n;
    printf("Enter the number: ");
    scanf("%d",&n);

    printf("\nSum of first %d natural numbers = %d.",n,n*(n+1)/2);
    
    return 0;
}
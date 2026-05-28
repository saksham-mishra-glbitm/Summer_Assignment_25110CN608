#include "stdio.h"
#include "math.h"
int main()
{
    int n;
    printf("Enter the number: ");
    scanf("%d",&n);  

    printf("\nNumber of digits in %d = %d.",n,((int)log10(n)+1));
    
    return 0;
}
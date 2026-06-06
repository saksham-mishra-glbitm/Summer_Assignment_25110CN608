#include "stdio.h"

int main()
{
    int n;
    printf("Enter the number: ");
    scanf("%d",&n);

    int rev=0,t=n; 

    while(t>0)
    {
        rev = rev*10 + (t%10);
        t/=10;
    }

    if(rev==n)
        printf("\n%d is a Palindrome number.",n);
    else
        printf("\n%d is NOT a Palindrome number.",n);
    
    return 0;
}
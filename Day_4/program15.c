#include "stdio.h"
#include "math.h"
int ppow(int x,int y);
int main()
{
    int n;
    printf("Enter n: ");
    scanf("%d", &n);
    int t=n;
    int sd=(n==0)?1:((int)(log10(n)+1));
    int s=0;
    while(t>0)
    {
        s+= ppow((t%10),sd);
        t/=10;
    }

    if(s==n)
        printf("\n%d is an Angstrom number.",n);
    else
        printf("\n%d is NOT an Angstrom number.",n);

    return 0;
}

int ppow(int x,int y)
{
    int pow=1;
    for(int i=1;i<=y;i++)
        pow*=x;
    
    return pow;
}
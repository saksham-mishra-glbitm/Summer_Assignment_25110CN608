#include "stdio.h"
#include "math.h"
int ppow(int x,int y);
int isAngs(int n);
int main()
{
    int a,b;
    printf("Enter the range: ");
    scanf("%d", &a);
    scanf("%d", &b);
    printf("\nAngstrom numbers in the range [%d,%d] are:",a,b);

    for(int i=a;i<=b;i++)
    {
        if(isAngs(i)==0)
            printf("\t%d",i);
    }

    return 0;
}

int isAngs(int n)
{
    int t=n;
    int sd=(n==0)?1:((int)(log10(n)+1));
    int s=0;
    while(t>0)
    {
        s+= ppow((t%10),sd);
        t/=10;
    }

    if(s==n)
        return 0;
    else
        return 1;
}

int ppow(int x,int y)
{
    int pow=1;
    for(int i=1;i<=y;i++)
        pow*=x;
    
    return pow;
}
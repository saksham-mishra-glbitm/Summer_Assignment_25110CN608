#include "stdio.h"
#include "math.h"
#define MAX(a,b) ((a>b)?a:b)
#define MIN(a,b) ((a<b)?a:b)
int main()
{
    int a,b;
    printf("Enter two numbers:\n");
    scanf("%d",&a);
    scanf("%d",&b);
    int lcm=0;
    int max=MAX(a,b);
    int min=MIN(a,b);
    for(int i=1;i<max;i++)
    {
        int x = max*i;
        if(x%min==0)
        {
            lcm=x;
            break;
        } 
    }
    
    printf("\nLCM of %d and %d = %d.",a,b,lcm);
    return 0;
}
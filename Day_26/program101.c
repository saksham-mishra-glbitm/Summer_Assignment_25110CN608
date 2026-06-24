#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>

int randGet(int min,int max)        //generate random number between min and max
{
    return (rand()%(max-min+1)+min);
}

void play(int min,int max,int randnum)        //main game logic
{
    int guess=0;
    int c=0;        //counter for attempts
    bool status = false;
    while(status == false)        //loop until correct guess
    {
        printf("\nGUESS A NUMBER BETWEEN %d AND %d: ",min,max);
        scanf("%d",&guess);
        c++;
            if(guess==randnum)
            {
                status = true;
                printf("\nCORRECT!!!\n");
                printf("It took you %d tries.",c);
                break;
            }
            if(guess<randnum)
            {
                status = false;
                printf("TOO LOW!\n");                
            }
            if(guess>randnum)
            {
                status = false;
                printf("TOO HIGH!\n");                
            }
    }
}

int main()
{
    int choice = 0;
    bool flag=true;
    printf("***NUMBER GUESSING GAME***\n");
    while(flag == true)        //loop for valid difficulty input
    {
        printf("\nChoose your difficulty: \n1.1 to 10.\n2.1 to 100.\n3.1 to 1000.\n");
        scanf("%d",&choice);

        if(choice<1 || choice>3)
        {
            flag=true;
            printf("\nINVALID CHOICE!!!!\n");            
        }
        else
        {
            flag=false;
            break;
        }        
    }
    
    int min=1;
    int r1=0,r2=0,r3=0;        //separate variables for each case
    srand(time(NULL));        //seed random number generator

    switch(choice)
    {
        case 1:
        r1=randGet(min,10);
        play(min,10,r1);
        break;

        case 2:
        r2=randGet(min,100);
        play(min,100,r2);
        break;

        case 3:
        r3=randGet(min,1000);
        play(min,1000,r3);
        break;
    }
    
    return 0;
}
/*
    A simple program to take a decimal number and convert it to binary.
    In the future, we will add support for binary to decimal as well.
*/

#include <stdio.h>

int main(void){
    int choice;
    printf("What do want to convert?\n");
    printf("1) Decimal to Binary\n");
    scanf("%d",&choice);
    if(choice==1){
        int dec = 0;
        printf("Enter your number in decimal: \n");
        scanf("%d",&dec);
        long bin = 0;
        long factor = 0;
        while(dec!=0){
            bin+=factor*(dec%2);
            factor*=10;
            dec/=2;
        }
        printf("The number in binary is: %d\n",bin);

    }else if(choice==2){
        //TODO: Add binary to decimal 
    }else{
        printf("Invalid choice\n");
    }
}
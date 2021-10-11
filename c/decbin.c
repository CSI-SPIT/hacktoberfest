/*
    A simple program to take a decimal number and convert it to binary.
    In the future, we will add support for binary to decimal as well.
*/

#include <stdio.h>
#include <math.h>
int main(void)
{
    int choice;
    printf("What do want to convert?\n");
    printf("1) Decimal to Binary\n");
    printf("2) Binary to Decimal\n");
    scanf("%d", &choice);
    if (choice == 1)
    {
        int dec = 0;
        printf("Enter your number in decimal: \n");
        scanf("%d", &dec);
        long bin = 0;
        long factor = 1;
        while (dec != 0)
        {
            bin += factor * (dec % 2);
            factor *= 10;
            dec /= 2;
        }
        printf("The number in binary is: %ld\n", bin);
    }
    else if (choice == 2)
    {
        long int bin_input, dec, b, d, pos;
        printf("Enter binary number to convert to decimal:\n");
        scanf("%ld", &bin_input);
        dec = 0;
        pos = 0;
        while (bin_input != 0)
        {
            b = bin_input % 10;
            while (b != 0 && b != 1)
            {
                printf("Invalid binary number\n");
                printf("Enter binary number containing only 0's and 1's:");
                scanf("%ld", &bin_input);
                dec = 0;
                pos = 0;
                b = bin_input % 10;
            }
            dec = dec + b * pow(2, pos);
            pos++;
            bin_input = bin_input / 10;
        }
        printf("The number in decimal is:%ld\n", dec);
    }
    else
    {
        printf("Invalid choice\n");
    }
}
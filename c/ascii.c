/*
    A program to accept a string and convert it to the corresponding ASCII art.
    It should support spaces and alphabets
*/

#include <stdio.h>

char* characters[] = {
    "\n\n\n\n",
    "    _   \n   /_\\  \n  / _ \\ \n /_/ \\_\\\n",                 
    "  ___ \r\n | _ )\r\n | _ \\\r\n |___/\r\n      ",
    "   ___ \r\n  / __|\r\n | (__ \r\n  \\___|\r\n       ",
    "  ___  \r\n |   \\ \r\n | |) |\r\n |___/ \r\n       ",
    "  ___ \r\n | __|\r\n | _| \r\n |___|\r\n      ",
    "  ___ \r\n | __|\r\n | _| \r\n |_|  \r\n      ",
    "   ___ \r\n  / __|\r\n | (_ |\r\n  \\___|\r\n       ",
    "  _  _     \r\n | || |    \r\n | __ |    \r\n |_||_|    \r\n           ",
    "  ___      \r\n |_ _|     \r\n  | |      \r\n |___|     \r\n           ",
    "     _     \r\n  _ | |    \r\n | || |    \r\n  \\__/     \r\n           ",
    "  _  __    \r\n | |/ /    \r\n | ' <     \r\n |_|\\_\\    \r\n           ",
    "  _        \r\n | |       \r\n | |__     \r\n |____|    \r\n           ",
    "  __  __   \r\n |  \\/  |  \r\n | |\\/| |  \r\n |_|  |_|  \r\n           ",
    "  _  _     \r\n | \\| |    \r\n | .` |    \r\n |_|\\_|    \r\n           ",
    "   ___     \r\n  / _ \\    \r\n | (_) |   \r\n  \\___/    \r\n           ",
    "  ___      \r\n | _ \\     \r\n |  _/     \r\n |_|       \r\n           ",
    "   ___     \r\n  / _ \\    \r\n | (_) |   \r\n  \\__\\_\\   \r\n           ",
    "  ___      \r\n | _ \\     \r\n |   /     \r\n |_|_\\     \r\n           ",
    "  ___      \r\n / __|     \r\n \\__ \\     \r\n |___/     \r\n           ",
    "  _____    \r\n |_   _|   \r\n   | |     \r\n   |_|     \r\n           ",
    "  _   _    \r\n | | | |   \r\n | |_| |   \r\n  \\___/    \r\n           ",
    " __   __   \r\n \\ \\ / /   \r\n  \\ V /    \r\n   \\_/     \r\n           ",
    " __      __\r\n \\ \\    / /\r\n  \\ \\/\\/ / \r\n   \\_/\\_/  \r\n           ",
    " __  __    \r\n \\ \\/ /    \r\n  >  <     \r\n /_/\\_\\    \r\n           ",
    " __   __   \r\n \\ \\ / /   \r\n  \\ V /    \r\n   |_|     \r\n           ",
    "  ____     \r\n |_  /     \r\n  / /      \r\n /___|     \r\n           "
};

int main(){
    printf("Enter a some text: (Only alphabets)\n");
    char str[20];
    scanf("%s",&str);
    for(int i=0;i<20;i++){
        if(str[i]=='\0') break;
        if(str[i]==' '){
            printf("%s\n",characters[0]);
        }
        else if(str[i]>='a' && str[i]<='z'){
            printf("%s\n",characters[str[i]-'a'+1]);
        }
        else if(str[i]>='A' && str[i]<='Z'){
            printf("%s\n",characters[str[i]-'A'+1]);
        }else{
            printf("Invalid character %c in string.",str[i]);
            break;
        }
    }
    return 0;
}
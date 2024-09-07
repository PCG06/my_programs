/* C program to accept a string from keyboard 
- Reverse it
- Find its length
- Find if its a palindrome or not
- Merge the original string and reverse string. 
Using built-in functions. */

#include <stdio.h>
#include <string.h>

static inline char *strrev(char *str);

void main()
{
    char str[20], rev[20], merge[20];
    int len, palindrome = 1;
    printf("Enter the string: ");
    scanf("%[^\n]s", str);
    printf("\nThe entered string is: '%s'", str);
    strcpy(rev, str);
    strrev(rev);
    printf("\nThre reverse of the string is: '%s'", rev);
    len = strlen(str);
    printf("\nThe length of the string is: %d", len);
    palindrome = strcmp(str, rev);
    if (palindrome == 0)
    {
        printf("\nThe string '%s' is a palindrome.", str);
    }
    else
    {
        printf("\nThe string '%s' is not a palindrome.", str);
    }
    strcpy(merge, str);
    strcat(merge, rev);
    printf("\nThe merge of strings '%s' and '%s' is '%s'\n", str, rev, merge);
}

// strrrev() doesn't exist anymore, so I resurrected it :)
static inline char *strrev(char *str)
{
    char *start = str;
    char *end = str + strlen(str) - 1;
    char temp;

    // Swap characters from start and end towards the middle
    while (start < end)
    {
        temp = *start;
        *start = *end;
        *end = temp;
        start++;
        end--;
    }

    return str;
}
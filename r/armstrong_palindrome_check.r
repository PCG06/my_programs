# R script to check Palindrome and Armstrong

cat("1: Palindrome\n2: Armstrong\n")
ch = readline(prompt="Enter your choice: ")
num = as.integer(readline(prompt="Enter a number: "))

temp = num
digit = 0

if (ch == 1) {
    while (temp > 0) {
        rem = temp %% 10
        digit = digit * 10 + rem
        temp = temp %/% 10
    }
    if (num == digit) {
        cat(num, "is a palindrome number\n")
    } else {
        cat(num, "is not a palindrome number\n")
    }
} else if (ch == 2) {
    while (temp > 0) {
        rem = temp %% 10
        digit = digit + (rem ^ 3)
        temp = temp %/% 10
    }
    if (num == digit)  {
        cat(num, "is an armstrong number\n")
    } else {
        cat(num, "is not an armstrong number\n")
    }
}

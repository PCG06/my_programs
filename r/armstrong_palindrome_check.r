# R script to create a choice menu with Armstrong and Palindrome number options

repeat {
    cat("1: Armstrong\n2: Palindrome\n3: Exit\n")
    ch = readline(prompt="Enter your choice: ")

    if (ch == 1) { # Armstrong
        num = as.integer(readline(prompt="Enter a 3 digit number: "))
        temp = num
        sum = 0
        while (temp > 0) {
            rem = temp %% 10
            sum = sum + (rem ^ 3)
            temp = temp %/% 10
        }
        if (num == sum)  {
            cat(num, "is an Armstrong number\n")
        } else {
            cat(num, "is not an Armstrong number\n")
        }
    } else if (ch == 2) { # Palindrome
        num = as.integer(readline(prompt="Enter a number: "))
        temp = num
        rev = 0
        while (temp > 0) {
            rem = temp %% 10
            rev = rev * 10 + rem
            temp = temp %/% 10
        }
        if (num == rev) {
            cat(num, "is a palindrome number\n")
        } else {
            cat(num, "is not a palindrome number\n")
        }
    } else if (ch == 3) { # Exit
        cat("Exiting...\n")
        break
    } else {
        cat("Invalid choice!\n")
    }
}

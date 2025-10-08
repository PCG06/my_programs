# R script to calculate t.test to see if student performance has increased before and after training

before <- c(22, 20, 19, 24, 25, 25, 28, 22, 30, 27, 24, 18, 16, 19, 19, 28, 24, 25, 25, 23)
after <- c(24, 22, 19, 22, 28, 26, 28, 24, 30, 29, 25, 20, 17, 18, 18, 28, 26, 27, 27, 24)

result <- t.test(before, after, paired=TRUE, alternative="two.sided", conf.level=0.99)
print(result)

if (result$p.value < 0.01) {
    cat("Result: Alternative hypothesis is accepted\n")
    cat("The means are significantly different\n")
    cat("The training program has improved students' performance\n")
} else {
    cat("Result: Null hypothesis is accepted\n")
    cat("Theere is no significant difference between the means\n")
    cat("The training program has not improved students' performance\n")
}
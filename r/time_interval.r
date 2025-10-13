# R script to show time taken (in minutes) by 100 students to travel to school on a particular day

# timeinterval_input <- readline(prompt="Enter the expediture intervals: ")
timeinterval_input <- c("0-5, 5-10, 10-15, 15-20, 20-25")
timeinterval <- unlist(strsplit(timeinterval_input, ", "))

# students_input <- readline(prompt="Enter the no. of students: ")
students_input <- c("5, 25, 40, 17, 13")
students <- as.numeric(unlist(strsplit(students_input, ", ")))

data <- data.frame(
    "Time Interval" = timeinterval,
    "Students" = students
)

cat("\nThe data\n")
print(data, right=FALSE, row.names=FALSE)

# Barplot
barplot(students, names.arg=timeinterval, col="skyblue", xlab="Time (in minutes)", ylab="No. of students", main="Barplot of time taken by students")

# Frequency polygon
midpoints <- sapply(timeinterval, function(interval) {
    parts <- as.numeric(unlist(strsplit(interval, "-")))
    mean(parts)
})

plot(midpoints, students, type='o', col="red", xlab="Time (minutes)", ylab="No. of students", main="Frequency polygon of time taken by students")

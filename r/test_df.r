# Testing data frame

test_df <- data.frame(
    ID = c(1, 2, 3, 4, 5),
    Name = c("Adithya", "Delson", "Gilston", "Jaison", "Likith"),
    Location = c("Bihar", "Tamil Nadu", "Rajasthan", "Haryana", "Assam"),
    Occupation = c("Secratary", "Jobless", "Tech Support", "Watchman", "Cook")
)

cat("1. The test data frame:\n")
print(test_df)

cat("\n2. Structure:\n")
print(str(test_df))

cat("\n3. Print column by name:\n")
print(head(test_df$Name))

cat("\n4. Print first two rows:\n")
print(head(test_df, 2))

cat("\n5. Print third and fifth rows:\n")
print(test_df[c(3, 5), ])

cat("\n6. Print first and third columns:\n")
print(test_df[, c(1, 3)])

cat("\n7. Add a new column:\n")
test_df$Join <- c(2017, 2018, 2019, 2020, 2021)
print(test_df)

cat("\n8. Add a new row:\n")
new_row <- data.frame(ID=6, Name="Prajith", Location="Karnataka", Occupation="Developer", Join=2022)
test_df <- rbind(test_df, new_row)
print(test_df)

cat("\n9. Drop a column by name:\n")
test_df$Join <- NULL
print(test_df)

cat("\n10. Drop a row by index:\n")
test_df <- test_df[-6, ]
print(test_df)
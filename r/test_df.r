# Testing data frame

test_df = data.frame(
    ID = c(1, 2, 3, 4),
    Name = c("Adithya", "Delson", "Gilston", "Jaison"),
    Location = c("Bihar", "Tamil Nadu", "Rajasthan", "Haryana"),
    Occupation = c("Secratary", "Jobless", "Tech Support", "Watchman")
)

cat("The test data frame:\n")
print(test_df)

cat("\n1. Structure:\n")
print(str(test_df))

cat("\n2. Print column by name:\n")
print(head(test_df$Name))

cat("\n3. Print first two columns:\n")
print(head(test_df, 2))

cat("\n4. Print third and fifth rows:\n")
print(test_df[c(3, 5), ])

cat("\n4. Print first and third columns:\n")
print(test_df[, c(1, 3)])

cat("\n5. Add a new column:\n")
test_df$Join = c(2017, 2018, 2019, 2020)
print(test_df)

cat("\n6. Add a new row:\n")
new_row = data.frame(ID=5, Name="Prajith", Location="Karnataka", Occupation="Developer", Join=2021)
test_df = rbind(test_df, new_row)
print(test_df)

cat("\n7. Drop a column by name:\n")
test_df$Join = NULL
print(test_df)

cat("\n8. Drop a row by index:\n")
test_df = test_df[-5, ]
print(test_df)
# R script to check if the vector elements are in ascending, descending, equal or random order

cat("Enter vector elements:\n")
vec = scan()

cat("Vector elements are:\n")
print(vec)

asc = desc = 0
i = 1

while (i < length(vec)) {
    if (vec[i] < vec[i + 1]) {
        asc = 1
    } else if (vec[i] > vec[i + 1]) {
        desc = 1
    }
    i = i + 1
}

if (asc == 1 && desc == 0) {
    cat("Ascending order\n")
} else if (desc == 1 && asc == 0) {
    cat("Descending order\n")
} else if (asc == 0 && desc == 0) {
    cat("Equal order\n")
} else {
    cat("Random order\n")
}
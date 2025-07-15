# R script to create an item info data frame and do perform operations

item_info = data.frame(
    Item_Code = c(1001, 1002, 1003, 1004, 1005),
    Item_Category = c("Electronics", "Desktop supplies", "Office supplies", "USB", "CD drive"),
    Item_Price = c(700, 300, 350, 400, 800)
)

cat("The item info data frame:\n")
print(item_info)

# Subset the item data frame where price is greater than or equal to 350
a = subset(item_info, Item_Price >= 350)
cat("\nItems whose price >= 350 are:\n")
print(a)

# Subset the item data frame where the category is either office supplies or desktop supplies
b = subset(item_info, Item_Category %in% c("Office supplies", "Desktop supplies"))
cat("\nItems where category is either office supplies or desktop supplies are:\n")
print(b)

# Subset the item data frame where item price is between 300 and 700
c = subset(item_info, Item_Price > 300 & Item_Price < 700)
cat("\nItems whose price is between 300 and 700 are:\n")
print(c)

# Compute the sum of all item prices
total = sum(item_info$Item_Price)
cat("\nThe sum of all items is ", total, "\n")

# Create another data frame "item_details" and merge the two data frames with the common column "Item_Code"
item_details = data.frame(
    Item_Code = c(1001, 1002, 1003, 1004, 1005),
    Item_Qty_On_Hand = c(50, 20, 35, 100, 75),
    Item_Record_Level = c(700, 300, 350, 400, 800)
)

cat("\nThe item details data frame:\n")
print(item_details)

d = merge(item_info, item_details, by="Item_Code")
cat("\nThe merged table:\n")
print(d)
"""
    Program 6:
    Python script to perform some array operations
"""

import array as arr

n = int(input("Enter the number of elements: "))
a = arr.array('i', map(int, input("Enter the elements: ").split()[:n]))

while True:
    print("\n---Menu---")
    print("1. Add new element\n"
        "2. Insert element at given postion\n"
        "3. Remove an element\n"
        "4. Sort in reverse order\n"
        "5. Count and display elements\n"
        "6. Exit\n")
    ch = int(input("Enter your choice: "))

    # 1. Add new element (append to end)
    if ch == 1:
        ele = int(input("Enter the element to be appended: "))
        a.append(ele)
        print(f"Appended {ele} to the array")

    # 2. Insert element at given position
    elif ch == 2:
        pos = int(input("Enter the position: "))
        
        if pos < 0 or pos > len(a):
            print("Invalid position")
        else:
            ele = int(input("Enter the element to be inserted: "))
            a.insert(pos, ele)
            print(f"Inserted {ele} at position {pos} in the array")

    # 3. Remove an element
    elif ch == 3:
        ele = int(input("Enter the element to be removed: "))
        
        if ele not in a:
            print("Element does not exist in the array")
        else:
            a.remove(ele)
            print(f"Removed {ele} from the array")

    # 4. Sort in reverse order
    elif ch == 4:
        b = sorted(a)
        print("Sorted array: ", end="")
        print(b)
        b.reverse()
        print("Sorted in reverse order array: ", end="")
        print(b)

    # 5. Count and display elements
    elif ch == 5:
        print("Length of the array:", len(a))
        print("Array elements: ", end="")
        print(a)

    # 6. Exit
    elif ch == 6:
        print("Exiting...")
        break

    # Default
    else:
        print("Invalid choice! Enter again!")

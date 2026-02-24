"""
    Program 19:
    Python script to create a shopping database using MySQL to perform some operations
"""

import mysql.connector

"""
# Log in as pcg06
> mysql -u pcg06 -p
> 0000
mysql> ...

# Log in as root
> sudo mysql
mysql> ...
"""

con = mysql.connector.connect(host="localhost", user="pcg06", passwd="0000")
cur = con.cursor()

# cur.execute("DROP DATABASE IF EXISTS Shopping_DB")
cur.execute("CREATE DATABASE IF NOT EXISTS Shopping_DB")
cur.execute("USE Shopping_DB")
cur.execute("""
            CREATE TABLE IF NOT EXISTS Products (
                PID     INT          PRIMARY KEY,
                PName   VARCHAR(20),
                Price   INT,
                Qty     INT
            )
""")
cur.execute("""
            CREATE TABLE IF NOT EXISTS Cart (
                PID INT,
                Qty INT
            )
""")
cur.close()
con.close

class OutOfStockException(Exception):
    pass

def db_connect():
    return mysql.connector.connect(host="localhost", user="pcg06", passwd="0000", db="Shopping_DB")

def insert_product():
    con = db_connect()
    cur = con.cursor()
    pid = int(input("Enter product ID: "))
    pname = input("Enter product name: ")
    price = int(input("Enter price: "))
    qty = int(input("Enter quantity: "))
    cur.execute("INSERT INTO Products VALUES (%s,%s,%s,%s)", (pid, pname, price, qty))
    con.commit()
    cur.close()
    con.close()

def view_products():
    con = db_connect()
    cur = con.cursor()
    cur.execute("SELECT * FROM Products")
    print("PID\tPName\tPrice\tQty")
    for row in cur.fetchall():
        for data in row:
            print(data, end="\t")
        print()
    cur.close()
    con.close()

def add_cart():
    con = db_connect()
    cur = con.cursor()
    try:
        pid = int(input("Enter product ID: "))
        qty = int(input("Enter quantity: "))
        cur.execute("SELECT * FROM Products where PID=%s", (pid, ))
        item = cur.fetchone()

        if not item:
            print("Invalid product ID")
            return
        
        pid, pname, pqty = item[0], item[1], item[3]

        if qty > pqty:
            raise OutOfStockException
        
    except OutOfStockException:
        print("Product is out of stock!")
        return
    
    pqty -= qty
    print("ID:", pid, "\nQTY:", qty)
    cur.execute("INSERT INTO Cart VALUES (%s, %s)", (pid, qty))
    cur.execute("UPDATE Products SET Qty=%s where PID=%s", (pqty, pid))
    print(f"{qty} {pname} (s) have been added to your cart!")
    con.commit()
    cur.close()
    con.close()
    
def view_cart():
    con = db_connect()
    cur = con.cursor()
    cur.execute("SELECT * FROM Cart")
    items = cur.fetchall()

    if not items:
        print("There are no items in your cart!")
        return

    print("PID\tQty")
    for row in items:
        for data in row:
            print(data, end="\t")
        print()
    cur.close()
    con.close()

def remove_cart():
    con = db_connect()
    cur = con.cursor()
    pid = int(input("Enter product ID: "))
    cur.execute("SELECT * FROM Cart WHERE PID=%s", (pid, ))
    items = cur.fetchall()

    if not item:
        print("Item not found in cart")
        return

    cur.execute("DELETE FROM Cart where PID=%s", (pid, ))
    cur.execute("SELECT PName FROM Product WHERE PID=%s", (pid, ))
    pname = cur.fetchone()[1]
    print(f"{pname} has been removed from your cart!")
    con.commit()
    cur.close()
    con.close()

while True:
    print("---Menu---")
    print("1. Add product\n"
          "2. View products\n"
          "3. Add item to cart\n"
          "4. Remove item from cart\n"
          "5. View cart\n"
          "6. Exit\n")
    
    ch = int(input("Enter your choice: "))
    print()

    # Add a product
    if ch == 1:
        insert_product()

    # View all products
    elif ch == 2:
        view_products()

    # Add product to cart
    elif ch == 3:
        add_cart()

    # Remove product from cart
    elif ch == 4:
        remove_cart()

    # View products in cart
    elif ch == 5:
        view_cart()

    # Exit
    elif ch == 6:
        print("Exiting...")
        break

    # Default
    else:
        print("Invalid choice! Enter again!")
    print()

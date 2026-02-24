"""
    Program 17:
    Python script to create a library class using MySQL to perform some operations
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

# cur.execute("DROP DATABASE IF EXISTS Library")
cur.execute("CREATE DATABASE IF NOT EXISTS Library_DB")
cur.execute("USE Library_DB")
cur.execute("""
            CREATE TABLE IF NOT EXISTS Library (
                ANo       INT          NOT NULL UNIQUE,
                Title     VARCHAR(20),
                Author    VARCHAR(20),
                Publisher VARCHAR(20),
                Price     INT,
                Copies    INT
            )
""")

class Library:

    def print_data(self, data):
        print("Ascension No\t\tTitle\t\tAuthor\t\tPublisher\t\tPrice\t\tCopies")
        for row in data:
            for i in row:
                print(i, end="\t\t")
            print()

    def ins_data(self, ANo, Title, Author, Publisher, Price, Copies):
        cur.execute("INSERT INTO Library VALUES(%s, %s, %s, %s, %s, %s)", (ANo, Title, Author, Publisher, Price, Copies))
        con.commit()
        print(f"Inserted {ANo}: \"{Title}\", by {Author}")

    def search_book(self, ANo):
        cur.execute("SELECT * FROM Library where ANO=%s", (ANo,))
        res = cur.fetchall()
        if not res:
            print("Book not found")
        else:
            self.print_data(res)

    def view_books(self):
        cur.execute("SELECT * FROM Library")
        self.print_data(cur.fetchall())

    def highest_cost(self):
        cur.execute("SELECT * FROM Library WHERE Price=(SELECT MAX(Price) FROM Library)")
        print("Costliest book:")
        self.print_data(cur.fetchall())

    def total_cost(self):
        cur.execute("SELECT SUM(Price * Copies) FROM Library")
        print("Total cost:", cur.fetchone()[0])

library = Library()

while True:
    print("---Menu---")
    print("1. Add book\n"
        "2. Search book\n"
        "3. View book\n"
        "4. Costliest book\n"
        "5. Total cost\n"
        "6. Exit\n")
    ch = int(input("Enter your choice: "))

    # 1. Insert record
    if ch == 1:
        print("\nEnter book details")
        ano = int(input("Enter Ascenion No: "))
        title = input("Enter Title: ")
        author = input("Enter Author: ")
        publisher = input("Enter Publisher: ")
        price = int(input("Enter Price: "))
        copies = int(input("Enter Copies: "))
        library.ins_data(ano, title, author, publisher, price, copies)

    # 2. Search book
    elif ch == 2:
        ano = int(input("Enter Ascenion No: "))
        library.search_book(ano)

    # 3. Display all books
    elif ch == 3:
        library.view_books()

    # 4. Display costliest book
    elif ch == 4:
        library.highest_cost()

    # 5. Display total cost of books
    elif ch == 5:
        library.total_cost()

    # 6. Exit
    elif ch == 6:
        print("Exiting...")
        cur.close()
        con.close()
        break

    # Default
    else:
        print("Invalid choice! Enter again!")
    print()

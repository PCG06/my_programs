connect 'jdbc:derby://localhost:1527/src/LibraryManagement/database/library;user=root;password=1234';

CREATE TABLE book (
    bookid INT PRIMARY KEY,
    bookname VARCHAR(25),
    author VARCHAR(25),
    publication VARCHAR(25),
    price DOUBLE,
    copies INT
);

exit;

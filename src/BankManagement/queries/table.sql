connect 'jdbc:derby://localhost:1527/src/BankManagement/database/bank;user=root;password=1234';

CREATE TABLE customer (
    accno INT PRIMARY KEY,
    name VARCHAR(25),
    acctype VARCHAR(5),
    balance DOUBLE
);

CREATE TABLE transactions (
    accno INT,
    trans_date DATE,
    trans_type VARCHAR(10),
    particulars VARCHAR(25),
    trans_amt DOUBLE
);

INSERT INTO customer VALUES
    (101, 'Adithya', 'SB', 25000.00),
    (102, 'Jaison', 'FD', 30000.00),
    (103, 'Likith', 'RD', 50000.00);

exit;

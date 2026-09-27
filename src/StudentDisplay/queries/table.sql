connect 'jdbc:derby://localhost:1527/src/StudentDisplay/database/student;user=root;password=1234';

CREATE TABLE student (
    regno INT PRIMARY KEY,
    name VARCHAR(25),
    address VARCHAR(10),
    course VARCHAR(10)
);

INSERT INTO student VALUES
    (101, 'Adithya', '123 Fake St', 'BCA'),
    (102, 'Arshad', '456 Real St', 'BCom'),
    (103, 'Jaison', '789 Bald St', 'BBA');

exit;

connect 'jdbc:derby://localhost:1527/src/ExamManagement/database/exam;user=root;password=1234';

CREATE TABLE student (
    regno INT PRIMARY KEY,
    name VARCHAR(25),
    class VARCHAR(10),
    course VARCHAR(10)
);

CREATE TABLE exam (
    regno INT,
    sub1 INT,
    sub2 INT,
    sub3 INT,
    total INT,
    perc DOUBLE,
    result VARCHAR(12)
);

exit;

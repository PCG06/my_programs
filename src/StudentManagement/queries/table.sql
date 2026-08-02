connect 'jdbc:derby://localhost:1527/src/StudentManagement/database/student;user=root;password=1234';

CREATE TABLE student (
    regno INT PRIMARY KEY,
    name VARCHAR(25),
    address VARCHAR(50),
    class VARCHAR(10),
    course VARCHAR(10)
);

exit;

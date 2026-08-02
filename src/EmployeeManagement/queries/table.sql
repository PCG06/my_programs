connect 'jdbc:derby://localhost:1527/src/EmployeeManagement/database/employee;user=root;password=1234';

CREATE TABLE employee (
    empid INT PRIMARY KEY,
    name VARCHAR(25),
    dept VARCHAR(15),
    salary DOUBLE
);

exit;

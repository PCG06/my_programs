connect 'jdbc:derby://localhost:1527/src/Login/database/login;user=root;password=1234';

CREATE TABLE login (
    user VARCHAR(25),
    password VARCHAR(25)
);

INSERT INTO login VALUES
    ('pcg', '1234'),
    ('png', 'vk18');

exit;

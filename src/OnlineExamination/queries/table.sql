connect 'jdbc:derby://localhost:1527/src/OnlineExamination/database/exam;user=root;password=1234';

CREATE TABLE questions (
    qid INT PRIMARY KEY,
    question VARCHAR(50),
    option1 VARCHAR(30),
    option2 VARCHAR(30),
    option3 VARCHAR(30),
    option4 VARCHAR(30),
    correct int
);

INSERT INTO questions VALUES
    (1, 'Who is the father of computers?', 'Issac Newton', 'Charles Babbage', 'Compstein Uterberg', 'Marie Curie', 2),
    (2, 'What is the fullform of RAM?', 'Read All Memory', 'Read And Manage', 'Random Access Memory', 'Rent A Machine', 3),
    (3, 'When was the first PC launched?', '1975', '2000', '1995', '1960', 1),
    (4, 'Full form of LLM', 'Long Lasting Memory', 'Lie Lingering Machine', 'Lead Leaf Metal', 'Large Language Model', 4);

exit;

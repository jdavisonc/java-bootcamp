
/*
1. Create a database named 'high-school' and modelate:

Student: first name, last name, registration number, date of birth)
Teacher: first name, last name, date of birth)
Course: name, assigned teacher, hours by week, schedule time (they can be dictated several times during the week)
Notes:

An student can assist several courses during the same year.
A teacher can be assigned to several courses.
For each course, each student has 3 partial notes and a final note.
Create all relationship that you think they are required.

*/
CREATE TABLE Students (
    LastName VARCHAR(30) NOT NULL,
    FirstName VARCHAR(30) NOT NULL,
    RegistrationNumber INT NOT NULL,
    DateOfBirth DATE,
    PRIMARY KEY (RegistrationNumber)
);
CREATE TABLE Teachers (
    LastName VARCHAR(30) NOT NULL,
    FirstName VARCHAR(30) NOT NULL,
    ID INT AUTO_INCREMENT,
    DateOfBirth DATE,
    PRIMARY KEY (ID)
);
CREATE TABLE Courses (
    ID INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(30) NOT NULL,
    TeacherID INT NOT NULL,
    HoursByWeek INT NOT NULL,
    ScheduleTime VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT TeacherID FOREIGN KEY (TeacherID)
        REFERENCES Teachers (ID)
);

CREATE TABLE Courses_Students (
    ID INT NOT NULL AUTO_INCREMENT,
    StudentRN INT NOT NULL,
    CourseID INT NOT NULL,
    Partial1 VARCHAR(45) NULL,
    Partial2 VARCHAR(45) NULL,
    Partial3 VARCHAR(45) NULL,
    FinalNote VARCHAR(45) NULL,
    PRIMARY KEY (`ID`),
    CONSTRAINT StudentRN FOREIGN KEY (StudentRN)
        REFERENCES Students (RegistrationNumber),
    CONSTRAINT CourseID FOREIGN KEY (CourseID)
        REFERENCES Courses (ID)
);

/* 2. Insert information for 3 teachers, 3 courses and 10 students per course.*/
INSERT INTO Students VALUES
        ('Smith','John',1, '1985-05-01'),
        ('Johnson','Mack',2, '1985-05-01'),
        ('Williams','Lily',3, '1985-05-01'),
        ('Johnson','Matt',4, '1985-05-01'),
        ('Smith','Bob',5, '1985-05-01'),
        ('Johnson','Bill',6, '1985-05-01'),
        ('Smith','Joe',7, '1985-05-01'),
        ('Johnson','Billy',8, '1985-05-01'),
        ('Williams','Jamal',9, '1985-05-01'),
        ('Smith','John',10, '1985-05-01');
        
INSERT INTO Teachers VALUES
			('Smith','Billy',1, '1985-05-01'),
			('Johnson','Bob',2, '1985-05-01'),
			('Williams','Mack',3, '1985-05-01');
            
INSERT INTO Courses VALUES
			(1,'Math 1', 1, 30, 'Monday: 07:00 : 12:00'),
			(2,'Math 2', 2, 30, 'Friday: 09:00 - 12:00'),
			(3,'Math 3', 2, 30, 'Tuesday: 09:00 - 17:00');

INSERT INTO Courses_Students VALUES
            (1,1,1, NULL, NULL, NULL, NULL),
            (2,2,1, NULL, NULL, NULL, NULL),
            (3,3,1, NULL, NULL, NULL, NULL),
            (4,4,1, NULL, NULL, NULL, NULL),
            (5,5,1, NULL, NULL, NULL, NULL),
            (6,6,1, NULL, NULL, NULL, NULL),
            (7,7,1, NULL, NULL, NULL, NULL),
            (8,8,1, NULL, NULL, NULL, NULL),
            (9,9,1, NULL, NULL, NULL, NULL),
            (10,10,1, NULL, NULL, NULL, NULL),
            (11,1,2, NULL, NULL, NULL, NULL),
            (12,2,2, NULL, NULL, NULL, NULL),
            (13,3,2, NULL, NULL, NULL, NULL),
            (14,4,2, NULL, NULL, NULL, NULL),
            (15,5,2, NULL, NULL, NULL, NULL),
            (16,6,2, NULL, NULL, NULL, NULL),
            (17,7,2, NULL, NULL, NULL, NULL),
            (18,8,2, NULL, NULL, NULL, NULL),
            (19,9,2, NULL, NULL, NULL, NULL),
            (20,10,2, NULL, NULL, NULL, NULL),
            (21,1,3, NULL, NULL, NULL, NULL),
            (22,2,3, NULL, NULL, NULL, NULL),
            (23,3,3, NULL, NULL, NULL, NULL),
            (24,4,3, NULL, NULL, NULL, NULL),
            (25,5,3, NULL, NULL, NULL, NULL),
            (26,6,3, NULL, NULL, NULL, NULL),
            (27,7,3, NULL, NULL, NULL, NULL),
            (28,8,3, NULL, NULL, NULL, NULL),
            (29,9,3, NULL, NULL, NULL, NULL),
            (30,10,3, NULL, NULL, NULL, NULL);

/* 3. List students and teachers for a given course. */
SELECT c.name as Course, CONCAT(t.lastName, ", ", t.firstName ) as Teacher, CONCAT(s.lastName, ", ", s.firstName) as Students
FROM Courses as c, teachers as t, students as s
WHERE c.ID = 2
GROUP BY students
ORDER BY Students ASC;

/*5. For a given teacher, list the timeline for each course that he is assigned to (ordered by date), and the course name. */

SELECT CONCAT(t.lastName, ", ", t.firstName ) as Teacher, CONCAT(c.ScheduleTime, ": ", c.name) as Schedule
FROM teachers as t, Courses as c
WHERE t.ID = 2;

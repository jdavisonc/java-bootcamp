-- Point 3 - List of students and teacher from a given course.

SELECT 	course.name as Course,
		CONCAT(teacher.lname, ', ' , teacher.fname) as Teacher,
		CONCAT(student.lname, ', ' , student.fname) as Student
FROM 	`teacher` , `attend` , `student` , `course` 
WHERE 	course.idcourse = 2 and
		course.idcourse = attend.idcourse and
		course.idteacher = teacher.idteacher and
		attend.rnumber = student.rnumber	
ORDER BY student ASC;



-- Point 4 - Percentage of students that passed a given course. 
-- For this test the student needs a minimum of 70 in the final note to be approved.

SELECT 	course.name as Course,		
		CONCAT(ROUND(((SELECT count(*) FROM attend WHERE notef > 69 and attend.idcourse = course.idcourse) / count(*) * 100), 1), '%') as Aproved
FROM 	 `attend` , `course` 
WHERE 	course.idcourse = 2 and 
		attend.idcourse = course.idcourse;
		
-- Point 5 

SELECT 	CONCAT(teacher.lname, ', ' , teacher.fname) as Teacher,
		CONCAT(courseschedule.day, ' ' , courseschedule.hourini , ' - ' , courseschedule.hourend , ': ' , course.name) as Schedule		
FROM 	`teacher` , `course`, `courseschedule`
WHERE 	course.idteacher = teacher.idteacher and		
		courseschedule.idcourse = course.idcourse and
		teacher.idteacher = 1
ORDER BY courseschedule.day ASC;

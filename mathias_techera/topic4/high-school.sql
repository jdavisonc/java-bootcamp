SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `attend` (
  `rnumber` int(11) NOT NULL,
  `idcourse` int(11) NOT NULL,
  `note1` tinyint(4) DEFAULT NULL,
  `note2` tinyint(4) DEFAULT NULL,
  `note3` tinyint(4) DEFAULT NULL,
  `notef` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `course` (
  `idcourse` int(11) NOT NULL,
  `name` char(50) NOT NULL,
  `hoursbyweek` tinyint(4) NOT NULL,
  `idteacher` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `courseschedule` (
  `idcourse` int(11) NOT NULL,
  `day` enum('Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday') NOT NULL,
  `hourini` time NOT NULL,
  `hourend` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `student` (
  `rnumber` int(11) NOT NULL,
  `fname` char(30) NOT NULL,
  `lname` char(30) NOT NULL,
  `birthdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `teacher` (
  `idteacher` int(11) NOT NULL,
  `fname` char(30) NOT NULL,
  `lname` char(30) NOT NULL,
  `birthdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `attend`
  ADD PRIMARY KEY (`rnumber`,`idcourse`),
  ADD KEY `idcourse` (`idcourse`);

ALTER TABLE `course`
  ADD PRIMARY KEY (`idcourse`),
  ADD KEY `idteacher` (`idteacher`);

ALTER TABLE `courseschedule`
  ADD KEY `idcourse` (`idcourse`);

ALTER TABLE `student`
  ADD PRIMARY KEY (`rnumber`);

ALTER TABLE `teacher`
  ADD PRIMARY KEY (`idteacher`);


ALTER TABLE `course`
  MODIFY `idcourse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `student`
  MODIFY `rnumber` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

ALTER TABLE `teacher`
  MODIFY `idteacher` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;


ALTER TABLE `attend`
  ADD CONSTRAINT `attend_ibfk_1` FOREIGN KEY (`idcourse`) REFERENCES `course` (`idcourse`),
  ADD CONSTRAINT `attend_ibfk_2` FOREIGN KEY (`rnumber`) REFERENCES `student` (`rnumber`);

ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`idteacher`) REFERENCES `teacher` (`idteacher`);

ALTER TABLE `courseschedule`
  ADD CONSTRAINT `courseschedule_ibfk_1` FOREIGN KEY (`idcourse`) REFERENCES `course` (`idcourse`);


-- Practice 2 Information for 3 teachers, 3 course and 10 students per course.
-- There is a teacher without course and a teacher so the queries can be tested.

INSERT INTO `student` (`rnumber`, `fname`, `lname`, `birthdate`) VALUES
(1, 'Matt', 'Jones', '1985-10-03'),
(2, 'Lily', 'Blake', '1998-12-13'),
(3, 'Keith', 'Grand', '1988-06-19'),
(4, 'William', 'Glover', '1990-09-06'),
(5, 'Keith', 'Hughes', '1993-10-24'),
(6, 'Sean', 'James', '1990-02-14'),
(7, 'Peter', 'Churcihll', '1993-01-04'),
(8, 'Stewart', 'Butler', '1988-07-01'),
(9, 'Joan', 'Bond', '1999-11-01'),
(10, 'Connor', 'Clarkson', '1990-10-31'),
(11, 'Rebecca', 'MacDonald', '1985-10-11'),
(12, 'Adam', 'Piper', '1985-10-20'),
(13, 'Lauren', 'Graham', '1986-03-23'),
(14, 'Colin', 'Allan', '1987-07-19'),
(15, 'Cameron', 'Bell', '1987-08-29'),
(16, 'Sophie', 'Mills', '1987-08-31'),
(17, 'Maria', 'Wallace', '1988-09-10'),
(18, 'Heather', 'Davidson', '1988-10-16'),
(19, 'Alexander', 'MacLeod', '1989-09-29'),
(20, 'Cameron', 'Russell', '1991-05-02'),
(21, 'Una', 'Clark', '1992-02-17'),
(22, 'Madeleine', 'Anderson', '1992-12-09'),
(23, 'John', 'Jones', '1993-11-14'),
(24, 'Anne', 'Ball', '1993-12-21');

INSERT INTO `teacher` (`idteacher`, `fname`, `lname`, `birthdate`) VALUES
(1, 'Felicity', 'Manning', '1978-09-21'),
(2, 'Brandon', 'Dickens', '1970-03-16'),
(3, 'Andrea', 'Marshall', '1985-06-14');

INSERT INTO `course` (`idcourse`, `name`, `hoursbyweek`, `idteacher`) VALUES
(1, 'Programming 1', 6, 1),
(2, 'Data Base 1', 3, 2),
(3, 'Programming 2', 6, 1);

INSERT INTO `courseschedule` (`idcourse`, `day`, `hourini`, `hourend`) VALUES
(3, 'Monday', '19:30:00', '22:30:00'),
(1, 'Wednesday', '19:30:00', '22:30:00'),
(1, 'Tuesday', '17:00:00', '20:00:00'),
(3, 'Thursday', '18:00:00', '21:00:00'),
(2, 'Wednesday', '19:00:00', '22:00:00');

INSERT INTO `attend` (`rnumber`, `idcourse`, `note1`, `note2`, `note3`, `notef`) VALUES
(1, 1, 12, 28, 37, 77),
(2, 1, 12, 28, 44, 84),
(3, 1, 16, 20, 36, 72),
(4, 1, 20, 24, 34, 78),
(5, 1, 17, 24, 30, 71),
(6, 1, 16, 23, 26, 65),
(7, 1, 7, 10, 44, 61),
(8, 1, 17, 20, 35, 72),
(9, 1, 5, 14, 49, 68),
(10, 1, 2, 19, 34, 55),
(11, 2, 15, 19, 36, 70),
(12, 2, 18, 22, 48, 88),
(13, 2, 2, 9, 23, 52),
(14, 2, 19, 19, 38, 76),
(15, 2, 15, 21, 34, 70),
(15, 3, 19, 22, 12, 53),
(16, 2, 20, 23, 40, 83),
(16, 3, 15, 28, 32, 75),
(17, 2, 14, 19, 22, 55),
(17, 3, 15, 22, 26, 63),
(18, 2, 1, 5, 19, 40),
(18, 3, 19, 21, 11, 51),
(19, 2, 15, 27, 44, 86),
(19, 3, 11, 23, 36, 70),
(20, 2, 14, 28, 40, 82),
(20, 3, 15, 15, 33, 63),
(21, 3, 14, 29, 43, 86),
(22, 3, 20, 30, 41, 91),
(23, 3, 17, 22, 10, 49),
(24, 3, 20, 28, 12, 60);


COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

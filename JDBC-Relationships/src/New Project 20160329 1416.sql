-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.11-beta-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema databaserelationships
--

CREATE DATABASE IF NOT EXISTS databaserelationships;
USE databaserelationships;

--
-- Definition of table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `add_id` int(10) unsigned NOT NULL auto_increment,
  `street` varchar(45) NOT NULL,
  `person_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`add_id`),
  KEY `FK_address_1` (`person_id`),
  CONSTRAINT `FK_address_1` FOREIGN KEY (`person_id`) REFERENCES `person` (`Person_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`add_id`,`street`,`person_id`) VALUES 
 (101,'pune',1),
 (102,'mumbai',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


--
-- Definition of table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c_id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY  (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`c_id`,`name`) VALUES 
 (1,'Java'),
 (2,'cpp');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `course_student`
--

DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `stud_id` int(10) unsigned NOT NULL,
  `c_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_course_student_1` (`c_id`),
  KEY `FK_course_student_2` (`stud_id`),
  CONSTRAINT `FK_course_student_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_course_student_2` FOREIGN KEY (`stud_id`) REFERENCES `student` (`stud_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_student`
--

/*!40000 ALTER TABLE `course_student` DISABLE KEYS */;
INSERT INTO `course_student` (`id`,`stud_id`,`c_id`) VALUES 
 (1,101,1);
/*!40000 ALTER TABLE `course_student` ENABLE KEYS */;


--
-- Definition of table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `Person_id` int(10) unsigned NOT NULL auto_increment,
  `person_name` varchar(45) NOT NULL,
  `person_add` varchar(45) NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`Person_id`),
  KEY `FK_person_1` (`user_id`),
  CONSTRAINT `FK_person_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`Person_id`,`person_name`,`person_add`,`user_id`) VALUES 
 (1,'Rahul Moundekar','wadgaonsheri',101);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;


--
-- Definition of table `person1`
--

DROP TABLE IF EXISTS `person1`;
CREATE TABLE `person1` (
  `pid` int(10) unsigned NOT NULL auto_increment,
  `pname` varchar(45) NOT NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person1`
--

/*!40000 ALTER TABLE `person1` DISABLE KEYS */;
INSERT INTO `person1` (`pid`,`pname`) VALUES 
 (1,'Rahul Moundekar');
/*!40000 ALTER TABLE `person1` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stud_id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY  (`stud_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`stud_id`,`name`) VALUES 
 (101,'Rahul'),
 (102,'Mahesh');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL auto_increment,
  `user_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`,`user_name`) VALUES 
 (101,'RahulMoundear');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

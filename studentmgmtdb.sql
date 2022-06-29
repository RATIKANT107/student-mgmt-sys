-- MySQL dump 10.13  Distrib 5.1.35, for Win32 (ia32)
--
-- Host: 127.0.0.1    Database: studentmgmtsys
-- ------------------------------------------------------
-- Server version	5.1.35-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signup` (
  `Name` varchar(30) DEFAULT NULL,
  `User_ID` varchar(30) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Question` varchar(100) DEFAULT NULL,
  `Answer` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES ('Chandan Kumar','ckp1606@GMAIL.COM','12345678','Enter your favourite color ?','Blue'),('Krishna Jadon','jadon@gmail.com','12345678','What is your favourite color ?','Black'),('karan','karan@gmail.com','12345678','What is your favourite color ?','Black'),('Karan Chandra','kc@gmail.com','karan123','What is your favourite color ?','Pink');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` varchar(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  `father` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `address` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('MRIU','Chandan kumar','9241212150','BCA','FCA','Anonymous','ckp1606@gmail.com','New Delhi'),('MRIU1235','Sarita Sachdeva','9854555646','FAS','FAS','Anonymous','sarita@gmail.com','B-25, New Delhi'),('MRIU1257','Abhishek','989104155','BTech','FET','Anonymous','abhi@gmail.com','Badkal Mod, Faridabad 110054'),('MRIU174156','Deepanshu','9896656654','MCA','FCA','Abhishek','deep@gmail.com','Lahore, Pakistan'),('MRIU175154','Karan Chandra','100','BCA','FCA','Unknown','musicalking2000@gmail.com','Faridabad'),('MRIU5454','Jay Arya','989896856','MCA','FAS','Sohan Arya','jay@gmail.com','New Delhi,  Chhattarpur'),('MRU1235','Om Prakash Sharma','2132123156','B.Tech','CSE','Ravi Sharama','om@fake.com','New Delhi');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-02  4:11:42

-- MySQL dump 10.13  Distrib 5.1.37, for pc-linux-gnu (i686)
--
-- Host: localhost    Database: cluborganiser
-- ------------------------------------------------------
-- Server version	5.1.37

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


drop database if exists cluborganiser;
create database cluborganiser;
use cluborganiser;

--
-- Table structure for table `Invoice`
--

DROP TABLE IF EXISTS `Invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Invoice` (
  `Invoice_Number` int(11) NOT NULL AUTO_INCREMENT,
  `Invoice_Date` date DEFAULT NULL,
  `Membership_Id` int(11) DEFAULT NULL,
  `Total_Fees` double DEFAULT NULL,
  PRIMARY KEY (`Invoice_Number`),
  KEY `fk_Invoice_memberships1` (`Membership_Id`),
  CONSTRAINT `fk_Invoice_memberships1` FOREIGN KEY (`Membership_Id`) REFERENCES `memberships` (`Membership_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Invoice`
--

LOCK TABLES `Invoice` WRITE;
/*!40000 ALTER TABLE `Invoice` DISABLE KEYS */;
INSERT INTO `Invoice` VALUES (1,'2012-05-10',1,12000),(2,'2012-05-10',2,2000),(3,'2012-05-10',2,2000),(4,'2012-05-10',5,1000),(5,'2012-05-10',1,2000);
/*!40000 ALTER TABLE `Invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberdetails`
--

DROP TABLE IF EXISTS `memberdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberdetails` (
  `Member_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Date_Of_Birth` date DEFAULT NULL,
  `Occupation` varchar(45) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `Mobile` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Member_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberdetails`
--

LOCK TABLES `memberdetails` WRITE;
/*!40000 ALTER TABLE `memberdetails` DISABLE KEYS */;
INSERT INTO `memberdetails` VALUES (1,'Sarang','1989-11-11','Engineer','Male','#221 Mandi H.P','01985223365','8956234171','sarang@gmail.com','Active'),(2,'Prerna Kaushal','1990-09-26','Manager','Female','#123\nMandi\nH.P','1987562341','9636963254','prerna@gmail.com','InActive');
/*!40000 ALTER TABLE `memberdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberships`
--

DROP TABLE IF EXISTS `memberships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberships` (
  `Membership_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Member_Id` int(11) DEFAULT NULL,
  `Membership_Type_Id` int(11) DEFAULT NULL,
  `Membership_Status` varchar(45) DEFAULT NULL,
  `Sport_Type_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Membership_Id`),
  KEY `fk_memberships_memberdetails1` (`Member_Id`),
  KEY `fk_memberships_membershiptypes1` (`Membership_Type_Id`),
  KEY `fk_memberships_sporttype1` (`Sport_Type_Id`),
  CONSTRAINT `fk_memberships_memberdetails1` FOREIGN KEY (`Member_Id`) REFERENCES `memberdetails` (`Member_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_memberships_membershiptypes1` FOREIGN KEY (`Membership_Type_Id`) REFERENCES `membershiptypes` (`Membership_Type_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_memberships_sporttype1` FOREIGN KEY (`Sport_Type_Id`) REFERENCES `sporttype` (`Sport_Type_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberships`
--

LOCK TABLES `memberships` WRITE;
/*!40000 ALTER TABLE `memberships` DISABLE KEYS */;
INSERT INTO `memberships` VALUES (1,1,3,'Not Available',3),(2,2,3,'Available',5),(3,1,3,'Available',3),(4,2,1,'Available',2),(5,1,3,'Available',2);
/*!40000 ALTER TABLE `memberships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membershiptypes`
--

DROP TABLE IF EXISTS `membershiptypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membershiptypes` (
  `Membership_Type_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Type_Name` varchar(45) DEFAULT NULL,
  `Factor` int(11) DEFAULT NULL,
  `Type_Description` varchar(100) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Membership_Type_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membershiptypes`
--

LOCK TABLES `membershiptypes` WRITE;
/*!40000 ALTER TABLE `membershiptypes` DISABLE KEYS */;
INSERT INTO `membershiptypes` VALUES (1,'Monthly',2,'Valid for one month','Available'),(2,'Annually',12,'valid for one year','Available'),(3,'Golden Monthly',1,'Golden package valid for one month','Available');
/*!40000 ALTER TABLE `membershiptypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sporttype`
--

DROP TABLE IF EXISTS `sporttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sporttype` (
  `Sport_Type_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Sport_Name` varchar(45) DEFAULT NULL,
  `Fees` double DEFAULT NULL,
  `Duration` int(2) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Sport_Type_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sporttype`
--

LOCK TABLES `sporttype` WRITE;
/*!40000 ALTER TABLE `sporttype` DISABLE KEYS */;
INSERT INTO `sporttype` VALUES (1,'Cricket',2000,3,'Available'),(2,'Hockey',1000,3,'Available'),(3,'Football',2000,3,'Available'),(4,'Table Tennis',500,1,'Available'),(5,'Billiards',2500,12,'Available');
/*!40000 ALTER TABLE `sporttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermaster`
--

DROP TABLE IF EXISTS `usermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermaster` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `User_Type` varchar(20) DEFAULT NULL,
  `User_Status` varchar(20) DEFAULT NULL,
  `Name` varchar(50) NOT NULL,
  `Contact_Number` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (1,'admin','admin','Administrator','Active','Rohan','01724565654','admin@gmail.com'),(2,'employee','employee','Employee','Active','Aakash','98888989898','employee@gmail.com'),(3,'User','user','Employee','Active','Rajpreet','9899988888','user@gmail.com');
/*!40000 ALTER TABLE `usermaster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-07-21  9:40:45

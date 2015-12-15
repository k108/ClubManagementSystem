drop database if exists test07;
create database test07;
use test07;

--
-- Table structure for table `Invoice`
--

DROP TABLE IF EXISTS `Persons`;
CREATE TABLE Persons
(
PersonID int,
LastName varchar(255),
FirstName varchar(255),
Address varchar(255),
City varchar(255)
); 

INSERT INTO Persons 
VALUES (1 ,'kaushik','Sudhanshu','null', 'null'); 

INSERT INTO Persons( LastName, FirstName, Address, City )
VALUES ('seth','tanya','null', 'null'); 

select * from Persons;
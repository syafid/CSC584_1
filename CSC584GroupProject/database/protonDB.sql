-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: csc584
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `appID` int NOT NULL AUTO_INCREMENT,
  `appDateTime` datetime DEFAULT NULL,
  `appStatus` varchar(45) DEFAULT NULL,
  `empID` int DEFAULT NULL,
  `serviceID` int DEFAULT NULL,
  `carID` int DEFAULT NULL,
  `cusID` int DEFAULT NULL,
  PRIMARY KEY (`appID`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (3,'2022-11-30 15:08:10','Approve',7,1,13,6),(5,'2022-11-30 08:00:58','Approve',7,1,13,36),(7,'2022-12-01 15:14:04','Approve',7,1,13,4),(10,'2022-11-25 15:21:02','Reject',7,1,13,9),(13,'2022-12-01 15:37:51','Approve',6,1,13,8),(16,'2022-12-10 08:30:52','Approve',7,6,13,33),(66,'2022-12-24 20:33:26','Approve',7,1,13,44),(70,'2022-12-26 20:42:00','Approve',6,1,13,44),(71,'2022-12-26 20:42:00','Approve',6,1,13,44),(72,'2022-12-26 20:42:00','Approve',7,1,13,44),(73,'2022-12-26 20:42:00','NEW',0,1,13,44),(74,'2022-12-26 20:42:00','NEW',0,1,13,44),(76,'2022-12-26 20:42:00','NEW',0,1,13,44),(77,'2022-12-26 20:42:00','Approve',6,1,13,44),(78,'2022-12-26 20:42:00','Approve',6,1,13,44),(79,'2022-12-26 20:42:00','Approve',7,1,13,44);
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `carID` int NOT NULL AUTO_INCREMENT,
  `carModel` varchar(10) DEFAULT NULL,
  `carVariant` varchar(40) DEFAULT NULL,
  `carTransmission` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`carID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'IRIZ','1.3L STANDARD CVT','AUTO'),(2,'IRIZ','1.6L EXECUTIVE CVT','AUTO'),(3,'IRIZ','1.6L ACTIVE CVT','AUTO'),(4,'PERSONA','1.6L STANDARD CVT','AUTO'),(5,'PERSONA','1.6L EXECUTIVE CVT','AUTO'),(6,'PERSONA','1.6L PREMIUM CVT','AUTO'),(7,'SAGA','1.3L STANDARD ','MANU'),(8,'SAGA','1.3L STANDARD','AUTO'),(9,'SAGA','1.3L PREMIUM','AUTO'),(10,'SAGA','1.3L PREMIUM S','AUTO'),(11,'X50','1.5T STANDARD','AUTO'),(12,'X50','1.5T PREMIUM','AUTO'),(13,'X50','1.5T EXECUTIVE','AUTO'),(19,'X70','1.5 TGDI STANDARD 2WD','AUTO'),(20,'X70','1.5 TGDI EXECUTIVE 2WD','AUTO'),(21,'X70','1.5 TGDI EXECUTIVE AWD','AUTO'),(22,'X70','1.5 TGDI PREMIUM 2WD','AUTO'),(23,'X70','1.8 TGDI PREMIUM 2WD','AUTO');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cusID` int NOT NULL AUTO_INCREMENT,
  `cusName` varchar(50) NOT NULL,
  `cusMyKad` varchar(12) NOT NULL,
  `cusPhoneNo` varchar(10) DEFAULT NULL,
  `cusEmail` varchar(20) NOT NULL,
  `cusPasswd` varchar(256) NOT NULL,
  `cusCarType` int NOT NULL,
  `cusCarPlate` varchar(12) NOT NULL,
  `cusCurrMileage` int DEFAULT NULL,
  PRIMARY KEY (`cusID`),
  UNIQUE KEY `cusMyKad_UNIQUE` (`cusMyKad`),
  KEY `carID_idx` (`cusCarType`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (4,'Johan','780914085902','0173867441','emirates@gmail.com','78091408590225d55ad283aa400af464c76d713c07ad',15,'VB6258',8000),(6,'saiful','801203165741','0112545632','sai.full@gmail.com','',21,'CAS 5214',55000),(8,'imran','110922160147','0172595499','imran@gmail.com','',13,'WWQ 5214',4000),(9,'sufian','850505014217','0134632561','padubeb@yahoo.com','',4,'BAS 526',55000),(33,'sasda','353245234542','0172595499','a@gmail.com','',10,'wwe 1234',150000),(36,'fhfdgh','894321321568','0172595499','b@gmail.com','',23,'juj 5521',5000),(44,'mohd syafid abdullah','780814015771','0126760976','syafid@gmail.com','78081401577125d55ad283aa400af464c76d713c07ad',13,'wb5971n',15000);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `empID` int NOT NULL AUTO_INCREMENT,
  `empName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`empID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `invoiceID` int NOT NULL AUTO_INCREMENT,
  `custID` int DEFAULT NULL,
  `partID` int DEFAULT NULL,
  `partQuant` int DEFAULT NULL,
  `partPrice` decimal(5,2) DEFAULT NULL,
  `InvoiceDateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`invoiceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logindetail`
--

DROP TABLE IF EXISTS `logindetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logindetail` (
  `sessionID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sessionID`),
  CONSTRAINT `userID` FOREIGN KEY (`sessionID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logindetail`
--

LOCK TABLES `logindetail` WRITE;
/*!40000 ALTER TABLE `logindetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `logindetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `part` (
  `partID` int NOT NULL AUTO_INCREMENT,
  `partDesc` varchar(45) DEFAULT NULL,
  `partQuant` int DEFAULT NULL,
  `partPrice` decimal(10,2) DEFAULT NULL,
  `partRateTime` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`partID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (1,'Engine Oil 4 litres',1,150.00,0.40),(2,'Engine Oil Filter',1,38.23,0.40),(3,'Drain Plug Gasket',1,2.37,0.40),(4,'Drain Plug',1,1.38,0.40),(5,'Spark Plug',4,28.04,0.30),(6,'Engine Air Filter',1,55.18,0.50),(7,'Dust and Pollen Filter',1,64.17,0.30),(8,'Engine Coolant',5,23.94,1.00),(9,'Brake Fluid DOT 4',1,32.47,0.50),(10,'Fuel Filter',1,17.93,0.40),(11,'AT Transmission Oil / ATF',8,62.62,0.70),(12,'4WD Gear Oil',1,47.00,1.30);
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `serviceID` int NOT NULL AUTO_INCREMENT,
  `serviceName` varchar(100) DEFAULT NULL,
  `serviceType` varchar(50) DEFAULT NULL,
  `serviceFees` float DEFAULT NULL,
  PRIMARY KEY (`serviceID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'1,000KM/1 MONTH',NULL,NULL),(2,'10,000KM/6 MONTH',NULL,NULL),(3,'20,000KM/12 MONTH',NULL,NULL),(4,'30,000KM/18 MONTH',NULL,NULL),(5,'40,000KM/24 MONTH',NULL,NULL),(6,'50,000KM/30 MONTH',NULL,NULL),(7,'60,000KM/36 MONTH',NULL,NULL),(8,'70,000KM/42 MONTH',NULL,NULL),(9,'80,000KM/48 MONTH',NULL,NULL),(10,'90,000KM/54 MONTH',NULL,NULL),(11,'100,000KM/60 MONTH',NULL,NULL),(12,'110,000KM/66 MONTH',NULL,NULL),(13,'120,000KM/72 MONTH',NULL,NULL),(14,'130,000KM/78 MONTH',NULL,NULL),(15,'140,000KM/84 MONTH',NULL,NULL),(16,'150,000KM/90 MONTH',NULL,NULL),(17,'160,000KM AND ABOVE',NULL,NULL),(18,'GENERAL REPAIR',NULL,NULL);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) DEFAULT NULL,
  `userIdentificationNo` varchar(12) DEFAULT NULL,
  `userContactNo` varchar(10) DEFAULT NULL,
  `userDateOfBirth` date DEFAULT NULL,
  `userEmail` varchar(50) DEFAULT NULL,
  `userPassword` varchar(256) DEFAULT NULL,
  `userAccessLevel` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'mohd syafid abdullah','780814015771','0126760976','1978-08-14','2021492334@student.uitm.edu.my','78081401577125d55ad283aa400af464c76d713c07ad','supervisor'),(6,'AKMAL FAIZ BIN ADIDAN','202027981411','0172541214','1980-12-01','2020279814@student.uitm.edu.my','20202798141125d55ad283aa400af464c76d713c07ad','technician'),(7,'MAZLAN BIN MOHAMAD','820506142353','0135622321','1982-05-06','2021435106@student.uitm.edu.my','82050614235325d55ad283aa400af464c76d713c07ad','technician');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'csc584'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-26  9:58:01

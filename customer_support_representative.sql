-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: customer_support_representative
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `csr_customer`
--

DROP TABLE IF EXISTS `csr_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `csr_customer` (
  `csr_id` int NOT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`csr_id`,`customer_id`),
  KEY `FKrun3wxpo77cfimtko3j5lv0x4` (`customer_id`),
  CONSTRAINT `FK9d8rnx2gjvt4vs5qa36bbehna` FOREIGN KEY (`csr_id`) REFERENCES `customer_support_representatives` (`id`),
  CONSTRAINT `FKrun3wxpo77cfimtko3j5lv0x4` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `csr_customer`
--

LOCK TABLES `csr_customer` WRITE;
/*!40000 ALTER TABLE `csr_customer` DISABLE KEYS */;
INSERT INTO `csr_customer` VALUES (4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(8,4),(9,4),(10,4),(9,5),(10,5),(10,6);
/*!40000 ALTER TABLE `csr_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Customer_Address` varchar(255) DEFAULT NULL,
  `Customer_eMail` varchar(255) DEFAULT NULL,
  `Customer_Name` varchar(255) DEFAULT NULL,
  `Customer_User_Pass` varchar(255) NOT NULL,
  `Customer_User_Name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'WWDC','hobbs@gmail.com','HOBBS','CUS1','CUS1'),(2,'BLWK','shaw@gmail.com','SHAW','CUS2','CUS2'),(3,'HNKG','quinee@gmail.com','QUINNEE','CUS3','CUS3'),(4,'u','yi','u','tuvjh','tygh'),(5,'rome','dante@gmail.com','DANTE','CUS6','CSU6'),(6,'gjhgfds','aisle@gmail.com','AISLE','CUS7','CUS7'),(7,'ygh','haan@gmail.com','HAAN','CUS*','CUS*');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_support_representatives`
--

DROP TABLE IF EXISTS `customer_support_representatives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_support_representatives` (
  `id` int NOT NULL AUTO_INCREMENT,
  `CSR_Address` varchar(255) DEFAULT NULL,
  `CSR_eMail` varchar(255) DEFAULT NULL,
  `CSR_Name` varchar(255) DEFAULT NULL,
  `CSR_User_Pass` varchar(255) NOT NULL,
  `CSR_User_Name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_support_representatives`
--

LOCK TABLES `customer_support_representatives` WRITE;
/*!40000 ALTER TABLE `customer_support_representatives` DISABLE KEYS */;
INSERT INTO `customer_support_representatives` VALUES (1,'BALI','dim@gmail.com','DOM','CSR1','CSR1'),(2,'NYCT','letty@gmail.com','LETTY','CSR2','CSR2'),(3,'berline','tez@gmail.com','TEZ','CSR3','CSR3'),(4,'BHGK','brian@gmail.com','BRIAN','CSR4','CSR4'),(5,'ROM','roman@gmail.com','ROMAN','CSR5','CSR5'),(6,'asd','asd','asd','asd','asd'),(7,'asd','asd','asd','asdf','asdf'),(8,'gjh','tess@gmail.com','TESS','CSR6','CSR6'),(9,'jhjd','gab@gmai.com','GABRi','CSR7','CSR7'),(10,'fuygjh','gal@gmail.com','GAL','CSR8','CSR8');
/*!40000 ALTER TABLE `customer_support_representatives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issue` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` enum('LEAVE','PRODUCT','REFERRAL','SERVICE','SUBMISSION','SUPPORT') DEFAULT NULL,
  `createdAt` date DEFAULT NULL,
  `feedback` enum('BAD_EXP','DO_NOT_RAISE_ISSUE_EVER_AGAIN_PLEASE','GOOD_EXP','GREAT_EXP','HAPPY_ADDRESSING_YOUR_ISSUE','HORRIBLE_EXP','ISSUE_IS_ADDRESSED_NOW','ISSUE_NOT_MEANT_TO_BE_ADDRESSED','WAS_HORRIBLE_ADDRESSING_ISSUE','WRONG_CATEGORY_CHOOSEN','YET_TO_BE_CLOSED') DEFAULT NULL,
  `status` enum('CLOSED','OPEN','PENDING','REJECTED') DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk2k0j9v8s0n7ljggog7cdod52` (`customer_id`),
  CONSTRAINT `FKk2k0j9v8s0n7ljggog7cdod52` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` VALUES (1,'PRODUCT','2023-06-15','ISSUE_IS_ADDRESSED_NOW','CLOSED',3),(2,'LEAVE','2023-06-15','HAPPY_ADDRESSING_YOUR_ISSUE','CLOSED',3),(3,'SUPPORT','2023-06-15','GREAT_EXP','CLOSED',3),(4,'SUBMISSION','2023-06-15','HAPPY_ADDRESSING_YOUR_ISSUE','CLOSED',3),(5,'SUBMISSION','2023-06-18','GREAT_EXP','CLOSED',1),(6,'SUBMISSION','2023-06-18','HAPPY_ADDRESSING_YOUR_ISSUE','CLOSED',1),(7,'SUBMISSION','2023-06-18','YET_TO_BE_CLOSED','OPEN',7);
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-19  1:32:05

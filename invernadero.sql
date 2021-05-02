-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: invernadero
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `alarma`
--

DROP TABLE IF EXISTS `alarma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alarma` (
  `idalamara` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `minimo` float NOT NULL,
  `maximo` float NOT NULL,
  PRIMARY KEY (`idalamara`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alarma`
--

LOCK TABLES `alarma` WRITE;
/*!40000 ALTER TABLE `alarma` DISABLE KEYS */;
/*!40000 ALTER TABLE `alarma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sensor` (
  `idsensor` int NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `invernadero` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  PRIMARY KEY (`idsensor`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
INSERT INTO `sensor` VALUES (2,'sen1','tachomi','san marino','687','sanimal@sjssj.com'),(3,'sen2','tachomi','san marino','687','sanimal@sjssj.com'),(4,'sen3','tachomi','san marino','687','sanimal@sjssj.com'),(5,'sen4','camaco','san marino','687','sanimal@sjssj.com'),(6,'sen5','toshiba','san marino','687','sanimal@sjssj.com'),(7,'sen6','tachomi','san marino','687','sanimal@sjssj.com'),(8,'sen7','burmer','san marino','687','sanimal@sjssj.com'),(9,'sen8','tachomi','san marino','687','sanimal@sjssj.com');
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensoresdatos`
--

DROP TABLE IF EXISTS `sensoresdatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sensoresdatos` (
  `idsensoresdatos` int NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) NOT NULL,
  `sensor` int NOT NULL,
  `temperatura` float NOT NULL,
  `humedad` float NOT NULL,
  PRIMARY KEY (`idsensoresdatos`),
  KEY `sensor_idx` (`sensor`),
  CONSTRAINT `sensor` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`idsensor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensoresdatos`
--

LOCK TABLES `sensoresdatos` WRITE;
/*!40000 ALTER TABLE `sensoresdatos` DISABLE KEYS */;
INSERT INTO `sensoresdatos` VALUES (1,'2021-04-23',2,14.5,1.25),(2,'2021-04-24',7,52.5243,5.82661),(3,'2021-04-24',6,59.5362,10.0751),(4,'2021-04-24',2,33.7875,95.27),(5,'2021-04-24',3,54.8032,16.6589);
/*!40000 ALTER TABLE `sensoresdatos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-25 23:52:07

-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: mina
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
-- Table structure for table `notificacionesvehiculo`
--

DROP TABLE IF EXISTS `notificacionesvehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificacionesvehiculo` (
  `idnotificacionesvehiculo` int NOT NULL AUTO_INCREMENT,
  `vehiculo` int NOT NULL,
  `mensaje` varchar(45) NOT NULL,
  `destinatario` int NOT NULL,
  `clave` varchar(45) NOT NULL,
  `semaforo` int DEFAULT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idnotificacionesvehiculo`),
  KEY `vehiculo_idx` (`vehiculo`),
  KEY `destino_idx` (`destinatario`),
  KEY `semaforo_idx` (`semaforo`),
  CONSTRAINT `destino` FOREIGN KEY (`destinatario`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `semaforo` FOREIGN KEY (`semaforo`) REFERENCES `semaforo` (`idsemaforo`),
  CONSTRAINT `vehiculo` FOREIGN KEY (`vehiculo`) REFERENCES `vehiculo` (`idvehiculo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacionesvehiculo`
--

LOCK TABLES `notificacionesvehiculo` WRITE;
/*!40000 ALTER TABLE `notificacionesvehiculo` DISABLE KEYS */;
INSERT INTO `notificacionesvehiculo` VALUES (1,1,'buen estado',1,'men1',1,'2021-04-13');
/*!40000 ALTER TABLE `notificacionesvehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semaforo`
--

DROP TABLE IF EXISTS `semaforo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semaforo` (
  `idsemaforo` int NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idsemaforo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semaforo`
--

LOCK TABLES `semaforo` WRITE;
/*!40000 ALTER TABLE `semaforo` DISABLE KEYS */;
INSERT INTO `semaforo` VALUES (1,'sem1','la condesa','rojo');
/*!40000 ALTER TABLE `semaforo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `puesto` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Jose casal','tecnico','12345');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `idvehiculo` int NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `material` varchar(45) NOT NULL,
  `cantidadmaterial` varchar(45) NOT NULL,
  PRIMARY KEY (`idvehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'carro1','la condesa','detenido','perros','3');
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-25 12:13:10

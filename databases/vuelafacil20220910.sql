-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: vuelafacil
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `taeropuertos`
--

DROP TABLE IF EXISTS `taeropuertos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taeropuertos` (
  `idaeropuertos` int NOT NULL AUTO_INCREMENT,
  `nombreaeropuerto` varchar(45) NOT NULL,
  `descripcionaeropuerto` varchar(45) NOT NULL,
  `habilitado` tinyint NOT NULL,
  `idciudades` int NOT NULL,
  PRIMARY KEY (`idaeropuertos`),
  UNIQUE KEY `nombreaeropuerto_UNIQUE` (`nombreaeropuerto`),
  KEY `fkaeropuertosciudades_idx` (`idciudades`),
  CONSTRAINT `fkaeropuertosciudades` FOREIGN KEY (`idciudades`) REFERENCES `tciudades` (`idciudades`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taeropuertos`
--

LOCK TABLES `taeropuertos` WRITE;
/*!40000 ALTER TABLE `taeropuertos` DISABLE KEYS */;
/*!40000 ALTER TABLE `taeropuertos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tciudades`
--

DROP TABLE IF EXISTS `tciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tciudades` (
  `idciudades` int NOT NULL AUTO_INCREMENT,
  `nombreciudad` varchar(45) NOT NULL,
  `descripcionciudad` varchar(45) NOT NULL,
  `habilitado` tinyint NOT NULL,
  PRIMARY KEY (`idciudades`),
  UNIQUE KEY `nombreciudad_UNIQUE` (`nombreciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tciudades`
--

LOCK TABLES `tciudades` WRITE;
/*!40000 ALTER TABLE `tciudades` DISABLE KEYS */;
INSERT INTO `tciudades` VALUES (1,'Bogotá','Capital de Colombia',1),(2,'Medellín','Ciudad de la eterna primavera',1);
/*!40000 ALTER TABLE `tciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tclases`
--

DROP TABLE IF EXISTS `tclases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tclases` (
  `idclases` int NOT NULL AUTO_INCREMENT,
  `claseejecutiva` tinyint NOT NULL,
  `claseeconomica` tinyint NOT NULL,
  `asientopasillo` tinyint NOT NULL,
  `asientoventana` tinyint NOT NULL,
  `idtrutas` int NOT NULL,
  PRIMARY KEY (`idclases`),
  KEY `fktclasestrutas_idx` (`idtrutas`),
  CONSTRAINT `fktclasestrutas` FOREIGN KEY (`idtrutas`) REFERENCES `trutas` (`idrutas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tclases`
--

LOCK TABLES `tclases` WRITE;
/*!40000 ALTER TABLE `tclases` DISABLE KEYS */;
/*!40000 ALTER TABLE `tclases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmaletas`
--

DROP TABLE IF EXISTS `tmaletas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmaletas` (
  `idmaletas` int NOT NULL AUTO_INCREMENT,
  `maletamano` tinyint NOT NULL,
  `maletabodega` tinyint NOT NULL,
  `pesomaleta` float NOT NULL,
  `idclases` int NOT NULL,
  PRIMARY KEY (`idmaletas`),
  KEY `fkmaletasclases_idx` (`idclases`) /*!80000 INVISIBLE */,
  CONSTRAINT `fkmaletasclases` FOREIGN KEY (`idclases`) REFERENCES `tclases` (`idclases`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmaletas`
--

LOCK TABLES `tmaletas` WRITE;
/*!40000 ALTER TABLE `tmaletas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tmaletas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tprecios`
--

DROP TABLE IF EXISTS `tprecios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tprecios` (
  `idprecios` int NOT NULL AUTO_INCREMENT,
  `descuento` int DEFAULT NULL,
  `valorañadido` float NOT NULL,
  `valorruta` float NOT NULL,
  `valorclase` float NOT NULL,
  `valormaleta` float NOT NULL,
  `valortotal` float NOT NULL,
  `idroles` int NOT NULL,
  PRIMARY KEY (`idprecios`),
  KEY `fkpreciosroles_idx` (`idroles`),
  CONSTRAINT `fkpreciosroles` FOREIGN KEY (`idroles`) REFERENCES `troles` (`idroles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tprecios`
--

LOCK TABLES `tprecios` WRITE;
/*!40000 ALTER TABLE `tprecios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tprecios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `troles`
--

DROP TABLE IF EXISTS `troles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `troles` (
  `idroles` int NOT NULL AUTO_INCREMENT,
  `rolcliente` tinyint NOT NULL,
  `rolasesor` tinyint NOT NULL,
  `roladministrador` tinyint NOT NULL,
  `nombrecliente` varchar(45) NOT NULL,
  `nombreasesor` varchar(45) NOT NULL,
  `nombreadministrador` varchar(45) NOT NULL,
  `documentocliente` int NOT NULL,
  `documentoasesor` int NOT NULL,
  `documentoadministrador` int NOT NULL,
  `idclases` int NOT NULL,
  PRIMARY KEY (`idroles`),
  UNIQUE KEY `documentocliente_UNIQUE` (`documentocliente`),
  UNIQUE KEY `documentoasesor_UNIQUE` (`documentoasesor`),
  UNIQUE KEY `documentoadministrador_UNIQUE` (`documentoadministrador`),
  KEY `fkrolesclases_idx` (`idclases`),
  CONSTRAINT `fkrolesclases` FOREIGN KEY (`idclases`) REFERENCES `tclases` (`idclases`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `troles`
--

LOCK TABLES `troles` WRITE;
/*!40000 ALTER TABLE `troles` DISABLE KEYS */;
/*!40000 ALTER TABLE `troles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trutas`
--

DROP TABLE IF EXISTS `trutas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trutas` (
  `idrutas` int NOT NULL AUTO_INCREMENT,
  `ciudadorigen` varchar(45) NOT NULL,
  `ciudaddestino` varchar(45) NOT NULL,
  `horasalida` time NOT NULL,
  `horallegada` time NOT NULL,
  `diasalida` date NOT NULL,
  `diallegada` date NOT NULL,
  `idaeropuertos` int NOT NULL,
  `idciudades` int NOT NULL,
  PRIMARY KEY (`idrutas`),
  UNIQUE KEY `ciudadorigen_UNIQUE` (`ciudadorigen`),
  UNIQUE KEY `ciudaddestino_UNIQUE` (`ciudaddestino`),
  KEY `fkrutasaeropuertos_idx` (`idaeropuertos`),
  KEY `fkrutasciudades_idx` (`idciudades`),
  CONSTRAINT `fkrutasaeropuertos` FOREIGN KEY (`idaeropuertos`) REFERENCES `taeropuertos` (`idaeropuertos`),
  CONSTRAINT `fkrutasciudades` FOREIGN KEY (`idciudades`) REFERENCES `tciudades` (`idciudades`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trutas`
--

LOCK TABLES `trutas` WRITE;
/*!40000 ALTER TABLE `trutas` DISABLE KEYS */;
/*!40000 ALTER TABLE `trutas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-10 16:53:01

CREATE DATABASE  IF NOT EXISTS `sistema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sistema`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cantidad_compra` int DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `importe_unidad` double DEFAULT NULL,
  `id_producto` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7htj802ek8gvec2d1fpl66l1` (`id_producto`),
  KEY `FK3qv94it8igifsmrl3fl4s428m` (`id_usuario`),
  CONSTRAINT `FK3qv94it8igifsmrl3fl4s428m` FOREIGN KEY (`id_usuario`) REFERENCES `user` (`id`),
  CONSTRAINT `FK7htj802ek8gvec2d1fpl66l1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_usuario`
--

DROP TABLE IF EXISTS `compra_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra_usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `id_producto` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpx6f2fvxhj12hr4nv3uo69o04` (`id_producto`),
  KEY `FK7tcd5tl3epdca4p97me7vlsvr` (`id_user`),
  CONSTRAINT `FK7tcd5tl3epdca4p97me7vlsvr` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKpx6f2fvxhj12hr4nv3uo69o04` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_usuario`
--

LOCK TABLES `compra_usuario` WRITE;
/*!40000 ALTER TABLE `compra_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lot`
--

DROP TABLE IF EXISTS `lot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `fecha_recepcion` date DEFAULT NULL,
  `precio_compra` double DEFAULT NULL,
  `proveedor` varchar(255) DEFAULT NULL,
  `id_pedido` int NOT NULL,
  `id_producto` int NOT NULL,
  `stock_id` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiagyeot4l4v12pu9qv6sl67gl` (`id_pedido`),
  KEY `FK9moi8m58qjgdkqeqgf1y02o0c` (`id_producto`),
  KEY `FKiff5mh4ntlfuq4rigfpjtx64y` (`stock_id`),
  KEY `FKen9wlevr4qgjn94rys748kn5g` (`id_user`),
  CONSTRAINT `FK9moi8m58qjgdkqeqgf1y02o0c` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`),
  CONSTRAINT `FKen9wlevr4qgjn94rys748kn5g` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKiagyeot4l4v12pu9qv6sl67gl` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`),
  CONSTRAINT `FKiff5mh4ntlfuq4rigfpjtx64y` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lot`
--

LOCK TABLES `lot` WRITE;
/*!40000 ALTER TABLE `lot` DISABLE KEYS */;
/*!40000 ALTER TABLE `lot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `fecha_recepcion` date DEFAULT NULL,
  `id_pedido` int NOT NULL,
  `stock_id` int NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK397kvlqm0m1f02h3tg6dmbc98` (`id_pedido`),
  KEY `FKlc5c4qsyk257d1im7qrv57faw` (`stock_id`),
  KEY `FK4p00ljutpg2odje0g23fwnqpj` (`id_user`),
  CONSTRAINT `FK397kvlqm0m1f02h3tg6dmbc98` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`),
  CONSTRAINT `FK4p00ljutpg2odje0g23fwnqpj` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKlc5c4qsyk257d1im7qrv57faw` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cantidad_pedida` int DEFAULT NULL,
  `costo_pedido` double DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `proveedor` varchar(45) NOT NULL,
  `id_producto` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc1emammk1tjnowrcgjp9ygpjj` (`id_producto`),
  CONSTRAINT `FKc1emammk1tjnowrcgjp9ygpjj` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activo` bit(1) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `cantidadcritica` int DEFAULT NULL,
  `descripcion` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` double DEFAULT NULL,
  `precio_reposicion` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,_binary '',5,3,'Sacapuntas Rojo','Sacapuntas',35,20),(2,_binary '',22,3,'Sacapuntas Verde','Sacapuntas',35,20),(3,_binary '',5,6,'Caruchera Verde','Cartuchera',200,100),(4,_binary '',5,6,'Caruchera Roja','Cartuchera',200,100),(5,_binary '',0,3,'Mochila Grande','Mochila',500,250),(6,_binary '',0,3,'10 Lapies de colores','Lapies de colores',500,250);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','admin@admin','Admin','$2a$10$.fYztIQKdySvOZANW9ppfuzyFG5on1OT87TNzlyTa8Aw2m6nmU1jG',''),(2,'User','user@user','User','$2a$10$Klxs4OBYyKQHCNvmAUylXOdFMyP5QMmpzJ8gzt5Gcb8eYCdjppbdG','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rol`
--

DROP TABLE IF EXISTS `user_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol` varchar(20) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8n11gig6mxiekgqtwvaabu1yw` (`rol`,`user_id`),
  KEY `FKkijwolbkui74em8ip1i6vniu4` (`user_id`),
  CONSTRAINT `FKkijwolbkui74em8ip1i6vniu4` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rol`
--

LOCK TABLES `user_rol` WRITE;
/*!40000 ALTER TABLE `user_rol` DISABLE KEYS */;
INSERT INTO `user_rol` VALUES (1,'ADMIN',1),(2,'USER',2);
/*!40000 ALTER TABLE `user_rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-16 20:57:41

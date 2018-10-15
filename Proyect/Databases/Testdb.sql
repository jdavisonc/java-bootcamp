CREATE DATABASE  IF NOT EXISTS `pridestoretest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `pridestoretest`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: pridestoretest
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart` (
  `IdCart` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `UserCart` int(10) unsigned NOT NULL,
  `ProdCart` int(10) unsigned NOT NULL,
  PRIMARY KEY (`IdCart`),
  UNIQUE KEY `IdCart_UNIQUE` (`IdCart`),
  KEY `user` (`UserCart`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,3,3),(2,3,3),(3,1,1),(4,2,1),(5,2,2),(6,2,3),(7,3,3);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categories` (
  `idCat` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NameCat` varchar(25) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idCat`),
  UNIQUE KEY `idCat_UNIQUE` (`idCat`),
  UNIQUE KEY `NameCat_UNIQUE` (`NameCat`),
  KEY `NameCat_Index` (`NameCat`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (4,'Accessories'),(1,'Bijou'),(2,'Clothing'),(5,'Toys'),(3,'Watches');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `IdProd` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NameProd` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `PriceProd` float NOT NULL,
  `DescriptionProd` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `CategoryProd` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`IdProd`),
  UNIQUE KEY `IdProd_UNIQUE` (`IdProd`),
  KEY `NameProd` (`NameProd`) /*!80000 INVISIBLE */,
  KEY `PriceProd` (`PriceProd`) /*!80000 INVISIBLE */,
  KEY `CatProd` (`CategoryProd`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Kindred Necklace',12.5,'Necklace with Kindred character theme in blue and white colors','1'),(2,'Personalized T-shirt',20.9,'Printed T-shirt with the image that you choose','2'),(3,'Vaporeon Plush',15.7,'Vaporeon mini plush, 7 inch height','5');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchasehistory`
--

DROP TABLE IF EXISTS `purchasehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `purchasehistory` (
  `idPurchase` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ordernum` int(10) unsigned NOT NULL,
  `userPurchase` int(10) unsigned NOT NULL,
  `productname` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `productprice` int(10) unsigned NOT NULL,
  `datepurchase` date NOT NULL,
  `totalprice` float unsigned NOT NULL,
  PRIMARY KEY (`idPurchase`),
  UNIQUE KEY `idPurchase_UNIQUE` (`idPurchase`),
  KEY `ordernum` (`ordernum`),
  KEY `user_idx` (`userPurchase`),
  CONSTRAINT `user` FOREIGN KEY (`userPurchase`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchasehistory`
--

LOCK TABLES `purchasehistory` WRITE;
/*!40000 ALTER TABLE `purchasehistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchasehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `IdUser` int(11) unsigned NOT NULL,
  `NameUser` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Email` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `Address` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `UserName` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Password` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`IdUser`),
  UNIQUE KEY `Id_UNIQUE` (`IdUser`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`),
  KEY `Name` (`NameUser`),
  KEY `Id` (`IdUser`),
  KEY `UserName` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-14 15:11:33

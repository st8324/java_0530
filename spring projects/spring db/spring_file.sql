CREATE DATABASE  IF NOT EXISTS `spring` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `spring`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: spring
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `fi_num` int NOT NULL AUTO_INCREMENT,
  `fi_name` varchar(100) DEFAULT NULL,
  `fi_ori_name` varchar(50) DEFAULT NULL,
  `fi_bo_num` int NOT NULL,
  PRIMARY KEY (`fi_num`),
  KEY `FK_fi_bo_num_idx` (`fi_bo_num`),
  CONSTRAINT `FK_fi_bo_num` FOREIGN KEY (`fi_bo_num`) REFERENCES `board` (`bo_num`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,'/2023/09/01/40c4aec4-56da-45d8-a6f3-8e9fd3040389_01. Spring 기초.pptx','01. Spring 기초.pptx',9),(2,'/2023/09/01/4ba7fdf4-5efc-4c92-9e82-a5e25ff186d2_03. Spring AOP.pptx','03. Spring AOP.pptx',11),(3,'/2023/09/01/c0170b0a-2458-4d48-ad86-bf6316e1d6d4_01. Spring 기초 (1).pptx','01. Spring 기초 (1).pptx',12),(4,'/2023/09/01/4d0bfd69-2238-4312-b205-245e65e6008a_01. Spring 기초 (1).pptx','01. Spring 기초 (1).pptx',14),(10,'/2023/09/05/3893876c-3618-4637-9206-05d605d4d0ed_스프링 처리.png','스프링 처리.png',16),(11,'/2023/09/06/2b8762f6-9f30-4abc-8f7c-7b7dddf361c2_스프링 처리.png','스프링 처리.png',17),(12,'/2023/09/06/5dc2f91a-2f28-4b20-bb8d-18415702b1bf_게시글 복습 정리.txt','게시글 복습 정리.txt',18),(13,'/2023/09/06/b7fac6ab-42c5-41eb-ac0e-b5e491b18545_게시글 복습 정리.txt','게시글 복습 정리.txt',19),(14,'/2023/09/11/ecfc789c-64f8-4d44-ae34-31dd810d355e_recording.conf','recording.conf',20);
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-11 10:53:19

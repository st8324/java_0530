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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `bo_num` int NOT NULL AUTO_INCREMENT,
  `bo_title` varchar(50) NOT NULL,
  `bo_contents` longtext NOT NULL,
  `bo_views` int NOT NULL DEFAULT '0',
  `bo_reg_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bo_up_date` datetime DEFAULT NULL,
  `bo_ori_num` int NOT NULL,
  `bo_me_id` varchar(15) NOT NULL,
  `bo_up` int NOT NULL DEFAULT '0',
  `bo_down` int NOT NULL DEFAULT '0',
  `bo_comment` int NOT NULL DEFAULT '0',
  `bo_bt_num` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`bo_num`),
  KEY `FK_member_TO_board_1` (`bo_me_id`),
  KEY `FK_bo_bt_num_idx` (`bo_bt_num`),
  CONSTRAINT `FK_bo_bt_num` FOREIGN KEY (`bo_bt_num`) REFERENCES `board_type` (`bt_num`),
  CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (`bo_me_id`) REFERENCES `member` (`me_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'첫 게시글','<p><font color=\"#000000\" style=\"background-color: rgb(255, 255, 0);\">첫게시글</font></p>',20,'2023-08-31 12:06:49',NULL,1,'qwe123',0,0,0,1),(2,'두번째 게시글','<p><b>두번째 게시글</b><br></p>',0,'2023-08-31 12:08:21',NULL,2,'qwe123',0,0,0,1),(3,'세번째','<p>세번째<br></p>',3,'2023-08-31 12:11:42',NULL,3,'qwe123',0,0,0,1),(4,'네번째?','<p>네번째?</p>',1,'2023-08-31 12:14:01',NULL,4,'qwe123',0,0,0,1),(5,'자바','<p>자바<br></p>',2,'2023-08-31 15:19:03',NULL,5,'qwe123',0,0,0,1),(6,'HTML','<p>HTML</p>',0,'2023-08-31 15:19:33',NULL,6,'qwe123',0,0,0,1),(7,'123','<p>123</p>',0,'2023-08-31 15:19:38',NULL,7,'qwe123',0,0,0,1),(8,'첨부파일 테스트','<p>테스트</p>',0,'2023-09-01 09:36:54',NULL,8,'qwe123',0,0,0,1),(9,'첨부파일 테스트 중 ','<p>첨부파일 테스트 중&nbsp;<br></p>',18,'2023-09-01 10:47:41',NULL,9,'qwe123',0,0,0,1),(10,'123','<p>123</p>',0,'2023-09-01 12:41:11',NULL,10,'qwe123',0,0,0,1),(11,'123','<p>123</p>',0,'2023-09-01 13:10:19',NULL,11,'qwe123',0,0,0,1),(12,'첨부','<p>123</p>',1,'2023-09-01 13:13:33',NULL,12,'qwe123',0,0,0,1),(13,'456','<p>456</p>',1,'2023-09-01 14:04:44',NULL,13,'qwe123',0,0,0,1),(14,'789','<p>789</p>',7,'2023-09-01 14:04:59',NULL,14,'qwe123',0,0,0,1),(15,'스프링 복습(수정)','스프링 복습(수정)',6,'2023-09-04 15:19:46','2023-09-04 16:43:54',15,'qwe123',0,0,0,1),(16,'첨부','123',43,'2023-09-05 14:09:57','2023-09-05 15:17:36',16,'qwe123',0,1,0,1),(17,'글쓰기','<p>글쓰기<br></p>',15,'2023-09-06 15:32:12',NULL,17,'qwe123',0,0,2,1),(18,'답글입니다~','<p>글쓰기<br></p>',2,'2023-09-06 15:33:45',NULL,17,'qwe123',0,0,0,1),(19,'첨부 글쓰기','<p>첨부 글쓰기<br></p>',108,'2023-09-06 16:06:11',NULL,19,'qwe123',0,0,9,1),(20,'공지사항','<p>공지1</p>',0,'2023-09-11 09:49:53',NULL,20,'admin123',0,0,0,6);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
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

-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: taxi
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drivers` (
  `driver_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `license_number` varchar(255) NOT NULL,
  `deleted` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivers`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` VALUES (1,'Иван Иванов','89001234567','ivanov@example.com','A1234564',0),(2,'Петр Петров','89007654321','petrov@example.com','B2345678',0),(3,'Сергей Сергеев','89003456789','sergeev@example.com','C3456789',0),(4,'Алексей Алексеев','89005678901','alekseev@example.com','D4567890',0),(5,'Николай Николаев','89007890123','nikolaev@example.com','E5678901',0),(6,'admin12','89080012314','228@mail.ru','A1234564',0),(7,'Nikitos','87712646020','fвы','228',0),(8,'Димуля','8800','da@mail.ru','000333',1),(9,'Анатолий Пупкин','89222292929292','MineRelmaster@yandex.ru','000333415151',0),(10,'Мой водитель','8922294141','1515@mail.ru','15161515',0);
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengers` (
  `passenger_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`passenger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
INSERT INTO `passengers` VALUES (1,'Анна Аннова','89101234567','annova@example.com',0),(2,'Мария Маркова','89107654321','markova@example.com',0),(3,'Елена Еленова','89103456789','elenova@example.com',0),(4,'Ольга Ольгова','89105678901','olgova@example.com',0),(5,'Татьяна Татьянова','89107890123','tatyanova@example.com',0),(6,'Nikita','89080012314','user@mail.ru',0),(7,'Nikita','89080012314','user@mail.ru',0),(8,'Nikitos','89080012314','user@mail.ru',0),(9,'gdf','87712646020','gdfdfg',0),(10,'Димуля','8800','jobik35830@bustayes.com',0);
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trips`
--

DROP TABLE IF EXISTS `trips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trips` (
  `trip_id` int NOT NULL AUTO_INCREMENT,
  `driver_id` int NOT NULL,
  `passenger_id` int NOT NULL,
  `start_address` varchar(255) NOT NULL,
  `end_address` varchar(255) NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `fare` decimal(10,2) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`trip_id`),
  KEY `driver_id` (`driver_id`),
  KEY `passenger_id` (`passenger_id`),
  CONSTRAINT `trips_ibfk_1` FOREIGN KEY (`driver_id`) REFERENCES `drivers` (`driver_id`),
  CONSTRAINT `trips_ibfk_2` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`passenger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trips`
--

LOCK TABLES `trips` WRITE;
/*!40000 ALTER TABLE `trips` DISABLE KEYS */;
INSERT INTO `trips` VALUES (1,1,1,'ул. Ленина, д. 1','ул. Пушкина, д. 10','2024-06-19 08:00:00','2024-06-19 08:30:00',500.00,1),(2,2,2,'ул. Лермонтова, д. 2','ул. Толстого, д. 20','2024-06-19 09:00:00','2024-06-19 09:45:00',600.00,1),(3,3,3,'ул. Чехова, д. 3','ул. Достоевского, д. 30','2024-06-19 10:00:00','2024-06-19 10:50:00',700.00,1),(4,4,4,'ул. Гоголя, д. 4','ул. Тургенева, д. 40','2024-06-19 11:00:00','2024-06-19 11:40:00',800.00,1),(5,5,5,'ул. Маяковского, д. 5','ул. Ахматовой, д. 50','2024-06-19 12:00:00','2024-06-19 12:30:00',900.00,1),(9,8,10,'Аа','аа','2024-06-13 15:33:00','2024-06-29 15:33:00',300.00,0);
/*!40000 ALTER TABLE `trips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','Admin','Admin'),(2,'User','User','User'),(3,'Mama','Mama','User'),(4,'Papa','Papa','User'),(5,'Mapa','Dupa','User'),(6,'Mama1','Mama','User');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-28 20:44:45

-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: dingfeng
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `address` varchar(256) DEFAULT NULL,
  `banner` varchar(64) DEFAULT NULL,
  `brand` varchar(64) DEFAULT NULL,
  `context` varchar(256) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `shop_logo_img` varchar(64) DEFAULT NULL,
  `shop_simplepy` varchar(64) DEFAULT NULL,
  `shop_title` varchar(64) DEFAULT NULL,
  `telephone` varchar(64) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `type` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `context` varchar(256) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `shop_logo_img` varchar(64) DEFAULT NULL,
  `shop_simplepy` varchar(64) DEFAULT NULL,
  `shop_title` varchar(64) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `type` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `context` varchar(256) DEFAULT NULL,
  `invalid_date` date NOT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `shop_logo_img` varchar(64) DEFAULT NULL,
  `shop_simplepy` varchar(64) DEFAULT NULL,
  `shop_title` varchar(64) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `good` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `banners` varchar(256) DEFAULT NULL,
  `context` varchar(256) DEFAULT NULL,
  `current_price` decimal(19,2) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `shop_logo_img` varchar(64) DEFAULT NULL,
  `shop_simplepy` varchar(64) DEFAULT NULL,
  `shop_title` varchar(64) DEFAULT NULL,
  `type` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `integral`
--

DROP TABLE IF EXISTS `integral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `integral` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `num` int(11) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `type` varchar(64) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integral`
--

LOCK TABLES `integral` WRITE;
/*!40000 ALTER TABLE `integral` DISABLE KEYS */;
/*!40000 ALTER TABLE `integral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pocket_money`
--

DROP TABLE IF EXISTS `pocket_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pocket_money` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `type` varchar(64) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pocket_money`
--

LOCK TABLES `pocket_money` WRITE;
/*!40000 ALTER TABLE `pocket_money` DISABLE KEYS */;
/*!40000 ALTER TABLE `pocket_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prize`
--

DROP TABLE IF EXISTS `prize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `coupon_id` bigint(20) DEFAULT NULL,
  `integral_num` int(11) DEFAULT NULL,
  `pocket_amount` decimal(19,2) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `shop_logo_img` varchar(64) DEFAULT NULL,
  `shop_simplepy` varchar(64) DEFAULT NULL,
  `shop_title` varchar(64) DEFAULT NULL,
  `type` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prize`
--

LOCK TABLES `prize` WRITE;
/*!40000 ALTER TABLE `prize` DISABLE KEYS */;
/*!40000 ALTER TABLE `prize` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `punch_in`
--

DROP TABLE IF EXISTS `punch_in`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `punch_in` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `invalid_date` date NOT NULL,
  `luck_drawn` bit(1) NOT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `punch_in`
--

LOCK TABLES `punch_in` WRITE;
/*!40000 ALTER TABLE `punch_in` DISABLE KEYS */;
/*!40000 ALTER TABLE `punch_in` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `address` varchar(256) DEFAULT NULL,
  `banners` varchar(256) DEFAULT NULL,
  `bg_img` varchar(64) DEFAULT NULL,
  `context` varchar(256) DEFAULT NULL,
  `latitude` decimal(19,2) DEFAULT NULL,
  `logo_img` varchar(64) DEFAULT NULL,
  `longitude` decimal(19,2) DEFAULT NULL,
  `shop_id` bigint(20) DEFAULT NULL,
  `simplepy` varchar(64) DEFAULT NULL,
  `telephone` varchar(64) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_card_rel`
--

DROP TABLE IF EXISTS `user_card_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_card_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `card_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_card_rel`
--

LOCK TABLES `user_card_rel` WRITE;
/*!40000 ALTER TABLE `user_card_rel` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_card_rel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_coupon_rel`
--

DROP TABLE IF EXISTS `user_coupon_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_coupon_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `coupon_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_coupon_rel`
--

LOCK TABLES `user_coupon_rel` WRITE;
/*!40000 ALTER TABLE `user_coupon_rel` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_coupon_rel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wx_user`
--

DROP TABLE IF EXISTS `wx_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wx_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creation` datetime NOT NULL,
  `last_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  `birthday` date DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `open_id` varchar(64) DEFAULT NULL,
  `telephone` varchar(64) DEFAULT NULL,
  `type` varchar(64) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `constellation` int(11) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `mp_gender` int(11) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `union_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wx_user`
--

LOCK TABLES `wx_user` WRITE;
/*!40000 ALTER TABLE `wx_user` DISABLE KEYS */;
INSERT INTO `wx_user` VALUES (1,'2018-06-02 16:20:35','2018-06-04 23:08:22',0,'1992-04-08','小强','wx123456789','18910739693','VVIP',25,NULL,NULL,1,NULL,NULL,NULL,1,NULL,NULL,NULL),(2,'2018-06-02 16:33:32','2018-06-04 23:08:22',0,'1992-04-09','大强','wx987654321','18996931073','VVIP',25,NULL,NULL,1,NULL,NULL,NULL,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `wx_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-05 21:37:38

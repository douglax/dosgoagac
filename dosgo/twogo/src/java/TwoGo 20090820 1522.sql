-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema twogo
--

CREATE DATABASE IF NOT EXISTS twogo;
USE twogo;

--
-- Definition of table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `ID_CATEGORIA` int(11) NOT NULL,
  `DESC_CATEGORIA` varchar(500) NOT NULL,
  PRIMARY KEY  (`ID_CATEGORIA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categoria`
--

/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`ID_CATEGORIA`,`DESC_CATEGORIA`) VALUES 
 (1,'Asiatica'),
 (2,'Rápida'),
 (3,'Mexicana'),
 (4,'Hamburguesas'),
 (5,'Naturista'),
 (6,'Saludable'),
 (7,'Francesa'),
 (8,'Japonesa'),
 (9,'Tostadas'),
 (10,'Vegetariana'),
 (11,'Pizzas'),
 (12,'Oriental'),
 (13,'Sushi'),
 (14,'Pastas'),
 (15,'Pannini'),
 (16,'Italiana'),
 (17,'Casera'),
 (18,'Postres'),
 (19,'Mediterraneo'),
 (20,'Pollo'),
 (21,'Cortes Finos');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

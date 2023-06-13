-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: hierarquia
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `func_dpto_funcao`
--

DROP TABLE IF EXISTS `func_dpto_funcao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `func_dpto_funcao` (
  `cpf_colaborador` char(11) DEFAULT NULL,
  `id_funcao` int NOT NULL,
  `cod_departamento` int NOT NULL,
  `situacao_cadastral` enum('Ativo','Desligado') DEFAULT NULL,
  KEY `fk_idfuncionario` (`cpf_colaborador`),
  KEY `fk_idfuncao` (`id_funcao`),
  KEY `fk_iddpto` (`cod_departamento`),
  CONSTRAINT `fk_iddpto` FOREIGN KEY (`cod_departamento`) REFERENCES `departamento` (`codigo`),
  CONSTRAINT `fk_idfuncao` FOREIGN KEY (`id_funcao`) REFERENCES `funcao` (`id`),
  CONSTRAINT `fk_idfuncionario` FOREIGN KEY (`cpf_colaborador`) REFERENCES `funcionario` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `func_dpto_funcao`
--

LOCK TABLES `func_dpto_funcao` WRITE;
/*!40000 ALTER TABLE `func_dpto_funcao` DISABLE KEYS */;
/*!40000 ALTER TABLE `func_dpto_funcao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-12 23:58:06

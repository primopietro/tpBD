-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 07, 2017 at 03:17 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tpbdjava`
--
CREATE DATABASE IF NOT EXISTS `tpbdjava` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tpbdjava`;

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id_location` int(11) NOT NULL,
  `id_maison` int(11) NOT NULL,
  `id_locateur` int(11) NOT NULL,
  `dateLocation` date DEFAULT NULL,
  `dateRetour` date DEFAULT NULL,
  `prixLocation` decimal(12,2) NOT NULL,
  `quantiteMois` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id_location`, `id_maison`, `id_locateur`, `dateLocation`, `dateRetour`, `prixLocation`, `quantiteMois`) VALUES
(2, 4, 3, NULL, NULL, '0.00', 0),
(3, 5, 2, NULL, NULL, '0.00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `maison`
--

DROP TABLE IF EXISTS `maison`;
CREATE TABLE `maison` (
  `id_maison` int(11) NOT NULL,
  `nbImmeuble` int(11) NOT NULL,
  `rue` varchar(50) NOT NULL,
  `annee` smallint(6) DEFAULT NULL,
  `nombreReparations` smallint(6) DEFAULT NULL,
  `codePostal` char(6) NOT NULL,
  `id_ville` int(11) NOT NULL,
  `echauffement` decimal(8,2) NOT NULL,
  `eau` decimal(8,2) NOT NULL,
  `electricite` decimal(8,2) NOT NULL,
  `assurance` decimal(8,2) NOT NULL,
  `impots` decimal(8,2) NOT NULL,
  `denegeur` decimal(8,2) NOT NULL,
  `entretienMenager` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maison`
--

INSERT INTO `maison` (`id_maison`, `nbImmeuble`, `rue`, `annee`, `nombreReparations`, `codePostal`, `id_ville`, `echauffement`, `eau`, `electricite`, `assurance`, `impots`, `denegeur`, `entretienMenager`) VALUES
(1, 666, 'diable', 19666, 666, '666666', 1, '6660.00', '666.00', '66600.00', '666000.00', '60606.00', '606060.00', '66.60'),
(3, 123, 'rue location', 123, 2, '123123', 2, '123.00', '123.00', '123.00', '123.00', '123.00', '123.00', '123.00'),
(4, 456, 'rue vente', 456, 456, '456456', 3, '456.00', '456.00', '456.00', '456.00', '456.00', '456.00', '456.00'),
(5, 0, 'kekekekeLOL', 456, 456, 'testTT', 1, '456.00', '456.00', '456.00', '456.00', '456.00', '456.00', '456.00');

-- --------------------------------------------------------

--
-- Table structure for table `offreachat`
--

DROP TABLE IF EXISTS `offreachat`;
CREATE TABLE `offreachat` (
  `id_offreAchat` int(11) NOT NULL,
  `id_acheteur` int(11) NOT NULL,
  `id_maison` int(11) NOT NULL,
  `dateOffre` date DEFAULT NULL,
  `valeurOffre` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `offreachat`
--

INSERT INTO `offreachat` (`id_offreAchat`, `id_acheteur`, `id_maison`, `dateOffre`, `valeurOffre`) VALUES
(1, 2, 4, '2017-03-14', '456456.00');

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE `personne` (
  `id_personne` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `telephone` int(11) DEFAULT NULL,
  `acheteur` tinyint(1) NOT NULL,
  `proprietaire` tinyint(1) NOT NULL,
  `courtier` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personne`
--

INSERT INTO `personne` (`id_personne`, `nom`, `prenom`, `telephone`, `acheteur`, `proprietaire`, `courtier`) VALUES
(2, 'acheteur1', 'acheteur1', 11, 1, 0, 0),
(3, 'courtier1', 'courtier1', 111, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `proprietaire`
--

DROP TABLE IF EXISTS `proprietaire`;
CREATE TABLE `proprietaire` (
  `id_proprietaire` int(11) NOT NULL,
  `id_maison` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL,
  `montantPropriete` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proprietaire`
--

INSERT INTO `proprietaire` (`id_proprietaire`, `id_maison`, `id_personne`, `montantPropriete`) VALUES
(1, 1, 1, '100.00');

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id_province` char(2) NOT NULL,
  `nomProvince` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`id_province`, `nomProvince`) VALUES
('AB', 'Alberta'),
('BC', 'British Columbia'),
('MB', 'Manitoba'),
('NB', 'New Brunswick'),
('NL', 'Newfoundland and Labrador'),
('NT', 'Northwest Territories'),
('NS', 'Nova Scotia'),
('NU', 'Nunavut'),
('ON', 'Ontario'),
('PE', 'Prince Edward Island'),
('QC', 'Quebec'),
('SK', 'Saskatchewan	'),
('YT', 'Yukon');

-- --------------------------------------------------------

--
-- Table structure for table `vente`
--

DROP TABLE IF EXISTS `vente`;
CREATE TABLE `vente` (
  `id_vente` int(11) NOT NULL,
  `id_maison` int(11) NOT NULL,
  `id_courtier` int(11) NOT NULL,
  `dateVente` date DEFAULT NULL,
  `prixAchat` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vente`
--

INSERT INTO `vente` (`id_vente`, `id_maison`, `id_courtier`, `dateVente`, `prixAchat`) VALUES
(1, 4, 3, '2017-03-14', '1.00');

-- --------------------------------------------------------

--
-- Table structure for table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE `ville` (
  `id_ville` int(11) NOT NULL,
  `nomVille` varchar(50) NOT NULL,
  `id_province` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ville`
--

INSERT INTO `ville` (`id_ville`, `nomVille`, `id_province`) VALUES
(1, 'Sherbrooke', 'QC'),
(2, 'Montreal', 'QC'),
(3, 'Quebec', 'QC');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id_location`),
  ADD KEY `deleteCascadeMaison` (`id_maison`),
  ADD KEY `deleteCascadePersonne` (`id_locateur`);

--
-- Indexes for table `maison`
--
ALTER TABLE `maison`
  ADD PRIMARY KEY (`id_maison`),
  ADD UNIQUE KEY `codePostal` (`codePostal`),
  ADD UNIQUE KEY `id_maison` (`id_maison`),
  ADD KEY `villeFK` (`id_ville`);

--
-- Indexes for table `offreachat`
--
ALTER TABLE `offreachat`
  ADD PRIMARY KEY (`id_offreAchat`),
  ADD KEY `maisonFK` (`id_maison`),
  ADD KEY `acheteurFK` (`id_acheteur`);

--
-- Indexes for table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id_personne`);

--
-- Indexes for table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id_proprietaire`),
  ADD KEY `maisonFK` (`id_maison`),
  ADD KEY `personneFK` (`id_personne`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`id_province`),
  ADD UNIQUE KEY `nomProvince` (`nomProvince`);

--
-- Indexes for table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`id_vente`),
  ADD KEY `maisonFK` (`id_maison`),
  ADD KEY `courtierFK` (`id_courtier`);

--
-- Indexes for table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`id_ville`),
  ADD UNIQUE KEY `nomVille` (`nomVille`),
  ADD KEY `provinceFK` (`id_province`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id_location` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `maison`
--
ALTER TABLE `maison`
  MODIFY `id_maison` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `offreachat`
--
ALTER TABLE `offreachat`
  MODIFY `id_offreAchat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `personne`
--
ALTER TABLE `personne`
  MODIFY `id_personne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id_proprietaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `vente`
--
ALTER TABLE `vente`
  MODIFY `id_vente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ville`
--
ALTER TABLE `ville`
  MODIFY `id_ville` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `deleteCascadeMaison` FOREIGN KEY (`id_maison`) REFERENCES `maison` (`id_maison`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `deleteCascadePersonne` FOREIGN KEY (`id_locateur`) REFERENCES `personne` (`id_personne`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 17, 2021 at 05:05 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.3.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gfacture`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `nom`, `email`) VALUES
(1, 'lst', 'lst@uae.ac.ma'),
(2, 'lst2', 'lst2@uae.ac.ma'),
(3, 'lst3', 'lst3@uae.ac.ma'),
(4, 'lsi', 'lsi@uae.ac.am'),
(5, 'lsi2', 'lsi2@uae.ac.am'),
(6, 'lsi2', 'lsi2@uae.ac.am'),
(7, 'dddd', 'dddd');

-- --------------------------------------------------------

--
-- Table structure for table `cmd`
--

CREATE TABLE `cmd` (
  `id_cmd` int(11) NOT NULL,
  `numero` varchar(255) NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `lign_cmd`
--

CREATE TABLE `lign_cmd` (
  `id_lign_cmd` int(11) NOT NULL,
  `qte` int(11) DEFAULT NULL,
  `id_cmd` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `pu` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexes for table `cmd`
--
ALTER TABLE `cmd`
  ADD PRIMARY KEY (`id_cmd`),
  ADD KEY `id_client` (`id_client`);

--
-- Indexes for table `lign_cmd`
--
ALTER TABLE `lign_cmd`
  ADD PRIMARY KEY (`id_lign_cmd`),
  ADD KEY `id_cmd` (`id_cmd`,`id_produit`),
  ADD KEY `id_produit` (`id_produit`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `cmd`
--
ALTER TABLE `cmd`
  MODIFY `id_cmd` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lign_cmd`
--
ALTER TABLE `lign_cmd`
  MODIFY `id_lign_cmd` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cmd`
--
ALTER TABLE `cmd`
  ADD CONSTRAINT `cmd_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lign_cmd`
--
ALTER TABLE `lign_cmd`
  ADD CONSTRAINT `lign_cmd_ibfk_1` FOREIGN KEY (`id_cmd`) REFERENCES `cmd` (`id_cmd`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `lign_cmd_ibfk_2` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

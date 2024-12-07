-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Stř 28. úno 2024, 11:09
-- Verze serveru: 10.4.19-MariaDB
-- Verze PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `sigma`
--
CREATE DATABASE IF NOT EXISTS `sigma` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `sigma`;

-- --------------------------------------------------------

--
-- Struktura tabulky `plysak`
--

CREATE TABLE `plysak` (
  `ID` int(11) NOT NULL,
  `jmeno` varchar(25) NOT NULL,
  `odkolilkalet` int(11) DEFAULT NULL,
  `cotoje` varchar(25) NOT NULL,
  `mamho` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Vyprázdnit tabulku před vkládáním `plysak`
--

TRUNCATE TABLE `plysak`;
--
-- Vypisuji data pro tabulku `plysak`
--

INSERT INTO `plysak` (`ID`, `jmeno`, `odkolilkalet`, `cotoje`, `mamho`) VALUES
(1, 'pejsek', 5, 'pes', 0),
(2, 'jarmilka', 3, 'kocka', 0),
(3, 'cyril', 15, 'prase', 1);

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `plysak`
--
ALTER TABLE `plysak`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `jmeno` (`jmeno`),
  ADD KEY `typ` (`cotoje`),
  ADD KEY `mamho` (`mamho`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `plysak`
--
ALTER TABLE `plysak`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

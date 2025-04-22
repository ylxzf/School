-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Počítač: localhost
-- Vygenerováno: Sob 23. bře 2013, 14:28
-- Verze MySQL: 5.5.29
-- Verze PHP: 5.3.10-1ubuntu3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databáze: `eshop`
--
CREATE DATABASE `eshop` DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci;
USE `eshop`;

-- --------------------------------------------------------

--
-- Struktura tabulky `eshop_kosik`
--

CREATE TABLE IF NOT EXISTS `eshop_kosik` (
  `eshop_kosik_id` int(11) NOT NULL AUTO_INCREMENT,
  `eshop_kosik_idUzivatel` int(11) NOT NULL,
  `eshop_kosik_idZbozi` int(11) NOT NULL,
  `eshop_kosik_pocet` int(11) NOT NULL,
  PRIMARY KEY (`eshop_kosik_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=13 ;

--
-- Vypisuji data pro tabulku `eshop_kosik`
--

INSERT INTO `eshop_kosik` (`eshop_kosik_id`, `eshop_kosik_idUzivatel`, `eshop_kosik_idZbozi`, `eshop_kosik_pocet`) VALUES
(8, 1, 1, 2),
(9, 1, 4, 1),
(10, 1, 10, 3),
(12, 2, 6, 4);

-- --------------------------------------------------------

--
-- Struktura tabulky `uziv`
--

CREATE TABLE IF NOT EXISTS `uziv` (
  `uziv_id` int(11) NOT NULL AUTO_INCREMENT,
  `uziv_login` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `uziv_heslo` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`uziv_id`),
  UNIQUE KEY `uziv_login` (`uziv_login`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=4 ;

--
-- Vypisuji data pro tabulku `uziv`
--

INSERT INTO `uziv` (`uziv_id`, `uziv_login`, `uziv_heslo`) VALUES
(1, 'uziv1', 'be747d173d5d70c84372229465bb9d3d'),
(2, 'uziv2', 'c7ec97e3638a633dcd9d973715a4f4d4'),
(3, 'uziv3', '2b9e2249ce9e0dd53eff1b6322a057dc');

-- --------------------------------------------------------

--
-- Struktura tabulky `eshop_zbozi`
--

CREATE TABLE IF NOT EXISTS `eshop_zbozi` (
  `eshop_zbozi_id` int(11) NOT NULL AUTO_INCREMENT,
  `eshop_zbozi_nazev` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `eshop_zbozi_kategorie` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `eshop_zbozi_cena` int(11) NOT NULL,
  PRIMARY KEY (`eshop_zbozi_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=11 ;

--
-- Vypisuji data pro tabulku `eshop_zbozi`
--

INSERT INTO `eshop_zbozi` (`eshop_zbozi_id`, `eshop_zbozi_nazev`, `eshop_zbozi_kategorie`, `eshop_zbozi_cena`) VALUES
(1, 'Fujitsu 3.5" HDD 3000GB, SATA 6G, 7200ot, hot plug', 'HDD', 14000),
(2, 'HP 3.5" HDD 2000GB SATA 7200 ot.', 'HDD', 13200),
(3, 'Intel 710 200GB SSD', 'HDD SSD', 20000),
(4, 'OCZ RevoDrive 3 X2 480GB', 'HDD SSD', 18000),
(5, 'Crucial 96GB KIT DDR3L LRDIMM 1333MHz', 'RAM', 78500),
(6, 'Corsair 64GB KIT DDR3 2400MHz CL10', 'RAM', 25500),
(7, 'EVGA GeForce GTX TITAN SC', 'GK', 26500),
(8, 'ASUS ARES2-6GD5 ', 'GK', 34500),
(9, 'Intel Six-Core XEON X5680', 'CPU', 42500),
(10, 'AMD Dual-Core Opteron 880', 'CPU', 7500);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

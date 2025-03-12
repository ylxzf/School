-- phpMyAdmin SQL Dump
-- version 3.3.7deb5build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Počítač: localhost
-- Vygenerováno: Neděle 20. ledna 2013, 20:35
-- Verze MySQL: 5.1.61
-- Verze PHP: 5.3.3-1ubuntu9.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databáze: `Filmy`
--
CREATE DATABASE `Filmy` DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci;
USE `Filmy`;

-- --------------------------------------------------------

--
-- Struktura tabulky `film`
--

CREATE TABLE IF NOT EXISTS `film` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT,
  `film_nazev` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `film_zanr` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `film_rezie` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (`film_id`),
  UNIQUE KEY `film_nazev` (`film_nazev`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci AUTO_INCREMENT=6 ;

--
-- Vypisuji data pro tabulku `film`
--

INSERT INTO `film` (`film_id`, `film_nazev`, `film_zanr`, `film_rezie`) VALUES
(1, 'Pan prstenu', 'fantasy', 'Peter Jackson'),
(2, 'Expendables', 'akcni', 'Simon West'),
(3, 'Mrazik', 'pohadka', 'Alexandr Rou'),
(4, 'Pelisky', 'komedie, drama', 'Jan Hřebejk'),
(5, 'Jursky park', 'sci-fi', 'Steven Spielberg');

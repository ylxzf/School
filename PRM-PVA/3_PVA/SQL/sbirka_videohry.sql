-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Stř 13. bře 2024, 10:54
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
-- Databáze: `sigma_db_pisemka1`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `sbirka_videohry`
--

CREATE TABLE `sbirka_videohry` (
  `ID_Videohra` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `ReleaseDate` date NOT NULL,
  `Genre` varchar(30) NOT NULL,
  `DoIRecommend` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Vyprázdnit tabulku před vkládáním `sbirka_videohry`
--

TRUNCATE TABLE `sbirka_videohry`;
--
-- Vypisuji data pro tabulku `sbirka_videohry`
--

INSERT INTO `sbirka_videohry` (`ID_Videohra`, `Name`, `ReleaseDate`, `Genre`, `DoIRecommend`) VALUES
(1, 'Destiny 2', '2017-09-06', 'Shooter', 1),
(2, 'Terraria', '2011-05-16', 'Sandbox', 1),
(3, 'Counter Strike 2', '2012-08-21', 'Shooter', 0),
(4, 'League of Legends', '2009-10-27', 'MOBA', 1),
(5, 'Valorant', '2020-06-02', 'Shooter', 1);

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `sbirka_videohry`
--
ALTER TABLE `sbirka_videohry`
  ADD PRIMARY KEY (`ID_Videohra`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `sbirka_videohry`
--
ALTER TABLE `sbirka_videohry`
  MODIFY `ID_Videohra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

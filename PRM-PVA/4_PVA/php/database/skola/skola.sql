-- phpMyAdmin SQL Dump
-- version 3.3.3
-- http://www.phpmyadmin.net
--
-- Počítač: localhost
-- Vygenerováno: Středa 06. listopadu 2013, 20:28
-- Verze MySQL: 5.1.46
-- Verze PHP: 5.3.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databáze: `skola`
--
CREATE DATABASE `skola` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `skola`;

-- --------------------------------------------------------

--
-- Struktura tabulky `studenti`
--

CREATE TABLE IF NOT EXISTS `studenti` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id studenta (PK)',
  `jmeno` varchar(100) COLLATE utf8_czech_ci NOT NULL COMMENT 'jmeno studenta',
  `prijmeni` varchar(100) COLLATE utf8_czech_ci NOT NULL COMMENT 'prijmeni studenta',
  `login` varchar(100) COLLATE utf8_czech_ci NOT NULL COMMENT 'login studenta v systemu (UK)',
  `heslo` varchar(100) COLLATE utf8_czech_ci NOT NULL COMMENT 'heslo studenta',
  `email` varchar(100) COLLATE utf8_czech_ci DEFAULT NULL COMMENT 'email studenta (nepovinny)',
  `rocnik` int(11) NOT NULL COMMENT 'rocnik, ve kterem student studuje',
  `zamereni` enum('IT','ST','EL') COLLATE utf8_czech_ci NOT NULL COMMENT 'zamereni, ktere student studuje',
  `narozeni` date NOT NULL COMMENT 'datum narozeni',
  `pohlavi` enum('muž','žena') COLLATE utf8_czech_ci NOT NULL COMMENT 'pohlavi studenta',
  `ulice` varchar(100) COLLATE utf8_czech_ci NOT NULL COMMENT 'bydliste studenta - ulice',
  `mesto` varchar(100) COLLATE utf8_czech_ci NOT NULL COMMENT 'bydliste studenta - mesto',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci COMMENT='tabulka studentu stredni skoly' AUTO_INCREMENT=101 ;

--
-- Vypisuji data pro tabulku `studenti`
--

INSERT INTO `studenti` (`id`, `jmeno`, `prijmeni`, `login`, `heslo`, `email`, `rocnik`, `zamereni`, `narozeni`, `pohlavi`, `ulice`, `mesto`) VALUES
(1, 'Kamil', 'Demeter', 'Demeter7', ',]0;X@Nw).@q*t8;qFJ', 'DemeterK@worldonline.cz', 2, 'ST', '1995-06-23', 'muž', 'Stříbrná 559', 'Žacléř'),
(2, 'Kevin', 'Severa', 'Severa91', 'E@cNumA@[2&2Ir(q<p', 'SeveraK@infoweb.cz', 4, 'EL', '1993-02-14', 'muž', 'Na Stoupách 3626', 'Napajedla'),
(3, 'Džamila', 'Krejčová', 'Krejcova88', ' ^q,:#iq%UiBE', 'KrejcovaD@vspj.cz', 4, 'EL', '1994-07-04', 'žena', 'Úvoz 9156', 'Hradec Králové'),
(4, 'Julie', 'Navrátilová', 'Navratilova54', 'w_-!,wmAE48', 'NavratilovaJ@atlas.cz', 3, 'ST', '1994-11-11', 'žena', 'Školní 6960', 'Soběslav'),
(5, 'Roland', 'Mikula', 'Mikula82', 'pt26@i|G)L9b', 'MikulaR@vspj.cz', 4, 'IT', '1994-03-25', 'muž', 'U Mincovny 1710', 'Havlíčkův Brod'),
(6, 'Tereza', 'Strnadová', 'Strnadova83', '>Y#2FWf$qRfox(_tsJ', 'StrnadovaT@worldonline.cz', 1, 'IT', '1996-07-14', 'žena', '17. listopadu 9419', 'Chrastava'),
(7, 'Ignác', 'Petr', 'Petr25', 'td2r3tadz ', 'PetrI@vspj.cz', 3, 'ST', '1995-06-30', 'muž', 'U Slunce 4481', 'Nová Včelnice'),
(8, 'Františka', 'Macháčková', 'Machackova28', 'zW*qfhp#QQ L', 'MachackovaF@gmail.cz', 2, 'IT', '1996-09-19', 'žena', '17. listopadu 6425', 'Jaroměřice nad Rokytnou'),
(9, 'Jasmin', 'Doležalová', 'Dolezalova17', 'Wa5~1ME88 Aajw(_', 'DolezalovaJ@sps-jia.cz', 2, 'IT', '1996-09-22', 'žena', 'Stamicova 9165', 'Beroun'),
(10, 'Jiřina', 'Havlová', 'Havlova81', 'zB1RfwOHyMs', 'HavlovaJ@spoluzaci.cz', 2, 'ST', '1995-10-29', 'žena', 'Lesní 1740', 'Příbor'),
(11, 'Klára', 'Fialová', 'Fialova13', '#!,T8Xhe4#r(8&q%7F', 'FialovaK@seznam.cz', 1, 'IT', '1997-03-22', 'žena', 'Dr. Jiřího Procházky 2594', 'Bílina'),
(12, 'Timoteus', 'Kubát', 'Kubat13', 'NUcAy]El22*', 'KubatT@seznam.cz', 1, 'IT', '1996-01-06', 'muž', 'Průmyslová 9269', 'Kryry'),
(13, 'Agrippa', 'Dubský', 'Dubsky81', 't8!X6+I/Yb-&)Dl', 'DubskyA@spoluzaci.cz', 3, 'EL', '1994-11-15', 'muž', 'Arbesova 2999', 'Mohelnice'),
(14, 'Ondřej', 'Jansa', 'Jansa70', 'FWhMa~gT.8o3vB', 'JansaO@post.cz', 1, 'ST', '1996-05-04', 'muž', 'Nové sady 51', 'Chlumec nad Cidlinou'),
(15, 'Ron', 'Vilímek', 'Vilimek66', 'V@ox2]89,K)>mY', 'VilimekR@infoweb.cz', 4, 'EL', '1994-03-10', 'muž', 'Leoše Janáčka 2121', 'Svoboda nad Úpou'),
(16, 'Armand', 'Ševčík', 'Sevcik33', '9|)ZD(0H>+&:emV+{', 'SevcikA@tiscali.cz', 4, 'ST', '1994-12-29', 'muž', 'Nad Jihlávkou 3606', 'Kostelec nad Labem'),
(17, 'Aleš', 'Škrabal', 'Skrabal29', 'yKj4P3IR6834,4h', 'SkrabalA@eposta.cz', 2, 'EL', '1995-07-25', 'muž', 'Květnová 5620', 'Nový Bor'),
(18, 'Aldo', 'Hromádka', 'Hromadka27', '#ka>3JIsWEm!O3,_{?*h', 'HromadkaA@seznam.cz', 1, 'ST', '1996-02-23', 'muž', 'Vlasty Javořické 3118', 'Šumperk'),
(19, 'Jolanta', 'Nováková', 'Novakova49', 'Rby]bf@3@?@[', 'NovakovaJ@seznam.cz', 4, 'EL', '1994-08-14', 'žena', 'Havlíčkova 729', 'Horní Slavkov'),
(20, 'Antonie', 'Slavíková', 'Slavikova65', '4I65;d1f*3L0J7*t', 'SlavikovaA@worldonline.cz', 4, 'IT', '1993-11-16', 'žena', 'Březinova 6712', 'Choceň'),
(21, 'Noah', 'Tvrdík', 'Tvrdik53', 'AhX:]}8nBU:Iy]vIvj', 'TvrdikN@email.cz', 1, 'ST', '1996-03-10', 'muž', 'Karoliny Světlé 9606', 'Mimoň'),
(22, 'Anabela', 'Ježková', 'Jezkova85', 'Ylhesiot&n9t[;v', 'JezkovaA@infoweb.cz', 3, 'IT', '1995-07-27', 'žena', 'Mlýnská 1588', 'Beroun'),
(23, 'Růžena', 'Čechová', 'Cechova74', '4/$j(bn}9%|uL~$5', 'CechovaR@eposta.cz', 1, 'IT', '1997-04-04', 'žena', 'Srázná 8165', 'Suchdol nad Lužnicí'),
(24, 'Vavřinec', 'Doleček', 'Dolecek25', 'cO%j}8-aQW.Gn|*', 'DolecekV@firmy.cz', 4, 'ST', '1993-04-18', 'muž', 'Masarykovo náměstí 494', 'Strážnice'),
(25, 'Darina', 'Urbanová', 'Urbanova99', '+&z ZMVRPa@h&', 'UrbanovaD@spoluzaci.cz', 1, 'IT', '1996-01-10', 'žena', 'Kpt. Nálepky 587', 'Police nad Metují'),
(26, 'Bolemír', 'Smutný', 'Smutny41', 'TC;iMc+&c#>+rtl)/', 'SmutnyB@inmail.cz', 4, 'ST', '1993-12-05', 'muž', 'U Skály 9566', 'Letovice'),
(27, 'Sandra', 'Staňková', 'Stankova61', 'xoCl}4%xFsp}]LqWj_#C', 'StankovaS@eposta.cz', 2, 'EL', '1995-10-12', 'žena', 'Erbenova 4922', 'Podivín	Pohořelice'),
(28, 'Izmael', 'Ondra', 'Ondra99', '<( z;[i@O-?3Wq', 'OndraI@tiscali.cz', 1, 'IT', '1996-04-25', 'muž', 'Mahenova 9724', 'Veltrusy'),
(29, 'Vincenc', 'Večeřa', 'Vecera15', '~2[GllS$=V;.lp~XDMzj', 'VeceraV@sps-jia.cz', 3, 'EL', '1995-10-13', 'muž', 'Nad Jihlávkou 3910', 'Pyšely'),
(30, 'Radúz', 'Bříza', 'Briza29', 'ma~zG!VaL#7a>#Qf', 'BrizaR@sps-jia.cz', 1, 'IT', '1997-02-21', 'muž', 'U Hřbitova 229', 'Velešín'),
(31, 'Ilja', 'Dolejší', 'Dolejsi42', '3@ewLcs=QM##JXI]<', 'DolejsiI@ladymail.cz', 3, 'ST', '1994-06-14', 'muž', 'třída Legionářů 2164', 'Nový Bor'),
(32, 'Lucian', 'Holas', 'Holas34', 'kYz||%A}<Jud!b_.,3', 'HolasL@quick.cz', 1, 'EL', '1996-04-08', 'muž', 'Luční 7734', 'Rychnov nad Kněžnou'),
(33, 'Vítězslav', 'Hanus', 'Hanus46', 'Iwk8b<a{S>', 'HanusV@spoluzaci.cz', 4, 'IT', '1994-04-07', 'muž', 'Horní 648', 'Hostivice'),
(34, 'Celestina', 'Čermáková', 'Cermakova87', '5+DD!jEN_Vq', 'CermakovaC@fel.cvut.cz', 4, 'ST', '1993-06-15', 'žena', 'Smrčenská 7511', 'Tanvald'),
(35, 'Kevin', 'Liška', 'Liska70', 'P9^D@yr.i4nNi', 'LiskaK@spoluzaci.cz', 1, 'EL', '1996-12-29', 'muž', 'Máchova 92', 'Chvaletice'),
(36, 'Julius', 'Nguyen Van', 'Nguyen Van98', 'I#W^7G-6K<(D].', 'Nguyen VanJ@inmail.cz', 4, 'IT', '1993-09-26', 'muž', 'Hany Kvapilové 3756', 'Vyškov'),
(37, 'Božetěch', 'Král', 'Kral57', 'QWz*qmr##V', 'KralB@vspj.cz', 3, 'IT', '1994-05-01', 'muž', 'Pod Příkopem 1098', 'Přebuz'),
(38, 'Zita', 'Vítková', 'Vitkova22', 'nIrzO;^fa9:S', 'VitkovaZ@inmail.cz', 1, 'IT', '1997-06-11', 'žena', 'Tyršova 9946', 'Štětí'),
(39, 'Mariana', 'Šmídová', 'Smidova96', ':wI!ck;%bp_-o;Tbs&=5', 'SmidovaM@atlas.cz', 4, 'IT', '1994-05-09', 'žena', 'Křižíkova 9613', 'Valašské Meziříčí'),
(40, 'Artur', 'Rudolf', 'Rudolf19', 'qk/Xh06iJ-sGu0#OMI(', 'RudolfA@eposta.cz', 1, 'EL', '1997-12-03', 'muž', 'Hálkova 9105', 'Husinec'),
(41, 'Aya', 'Vávrová', 'Vavrova27', '?;v9UQG[Ea', 'VavrovaA@gmail.cz', 1, 'ST', '1997-01-11', 'žena', 'Okrajová 9484', 'Železnice'),
(42, 'Amadeus', 'Dvořák', 'Dvorak86', 'jhs(WO x6ra', 'DvorakA@tiscali.cz', 3, 'ST', '1995-11-07', 'muž', 'Wolkerova 7971', 'Mladá Vožice'),
(43, 'Durancie', 'Bártová', 'Bartova79', 'xXP9:=4_m,~:rOz9qN]i', 'BartovaD@ladymail.cz', 1, 'EL', '1997-09-28', 'žena', 'U Rybníčků 7794', 'Rajhrad'),
(44, 'Anna', 'Stejskalová', 'Stejskalova64', '~:!&EpC=7Y1f', 'StejskalovaA@email.cz', 4, 'IT', '1994-12-27', 'žena', 'U Rybníčků 3149', 'Zbiroh'),
(45, 'Celestina', 'Lišková', 'Liskova80', '+IBvkV.wmWJ=;9UPL', 'LiskovaC@seznam.cz', 2, 'EL', '1996-02-02', 'žena', 'Kpt. Jaroše 5240', 'Osek'),
(46, 'Alina', 'Kratochvílová', 'Kratochvilova6', 'Kkp6j$5B$60]u~L@9W;q', 'KratochvilovaA@tiscali.cz', 2, 'IT', '1996-02-07', 'žena', 'U Cihelny 9890', 'Železnice'),
(47, 'Iva', 'Kratochvílová', 'Kratochvilova67', 'WP ,}mz9_[~7D(}*v', 'KratochvilovaI@infoweb.cz', 4, 'EL', '1994-01-19', 'žena', 'třída Legionářů 1076', 'Újezd u Brna'),
(48, 'Věroslav', 'Kozel', 'Kozel88', 'y*]aFxsGvZ8g[{f8', 'KozelV@sps-jia.cz', 1, 'IT', '1996-04-19', 'muž', 'Komenského 2422', 'Úštěk'),
(49, 'Vladimír', 'Tóth', 'Toth32', 'l>ha2#s3(;|sA#', 'TothV@email.cz', 4, 'EL', '1994-04-05', 'muž', 'Havlíčkova 7486', 'Velké Bílovice'),
(50, 'Nora', 'Švecová', 'Svecova80', 'Pc8y/0;rsv9p', 'SvecovaN@post.cz', 4, 'ST', '1993-02-20', 'žena', 'Jakubské náměstí 1169', 'Horní Jiřetín'),
(51, 'Scholastika', 'Doležalová', 'Dolezalova34', 'p5Oa2:$%fLhsAP0+V#', 'DolezalovaS@centrum.cz', 1, 'ST', '1996-10-18', 'žena', 'Vrchlického 7765', 'Úsov'),
(52, 'Roman', 'Urbanec', 'Urbanec22', 'L$+2Hr0 9q:D9', 'UrbanecR@spoluzaci.cz', 1, 'EL', '1997-07-03', 'muž', 'Havlíčkova 5985', 'Lysá nad Labem'),
(53, 'Albert', 'Šafář', 'Safar41', 'eG{uhg,3,G4|', 'SafarA@fel.cvut.cz', 4, 'EL', '1994-06-24', 'muž', 'Rejchova 3769', 'Roudnice nad Labem'),
(54, 'Branimír', 'Vymazal', 'Vymazal75', 'ag(|3$MX)b{M', 'VymazalB@centrum.cz', 3, 'EL', '1995-09-26', 'muž', 'U Cvičiště 9791', 'Neratovice'),
(55, 'Marcel', 'Šesták', 'Sestak40', '#$}mH{-oCn4]', 'SestakM@ladymail.cz', 3, 'EL', '1994-07-19', 'muž', 'Slepá 3637', 'Volyně'),
(56, 'Atanas', 'Kuneš', 'Kunes4', ']VQ{y0GJ~? *^J', 'KunesA@seznam.cz', 1, 'IT', '1997-05-06', 'muž', 'U Viaduktu 7055', 'Bavorov'),
(57, 'Bertolda', 'Bláhová', 'Blahova71', '8MjZ(Pq< Gb,}s', 'BlahovaB@fel.cvut.cz', 3, 'IT', '1995-06-05', 'žena', 'U Rybníčků 792', 'Hluboká nad Vltavou'),
(58, 'Ester', 'Tomanová', 'Tomanova96', 'Q7*lv,axa*{PLB7H', 'TomanovaE@firmy.cz', 1, 'EL', '1996-02-21', 'žena', 'Palackého 8259', 'Kašperské Hory'),
(59, 'Dětřich', 'Rambousek', 'Rambousek96', '~-Jwhpq)DrTFv{ ', 'RambousekD@tiscali.cz', 1, 'IT', '1996-02-01', 'muž', 'Okrajová 5898', 'Počátky'),
(60, 'Olga', 'Černá', 'Cerna8', '8;(S,sc-;P3=', 'CernaO@fel.cvut.cz', 4, 'EL', '1994-09-26', 'žena', 'Slavíčkova 2555', 'Rumburk'),
(61, 'Silvestr', 'Kuča', 'Kuca27', 's8S/<(=>^gu', 'KucaS@vspj.cz', 4, 'IT', '1994-05-31', 'muž', 'Kpt. Nálepky 2864', 'Benátky nad Jizerou'),
(62, 'Iveta', 'Hájková', 'Hajkova20', 'Dtw#-Zm?*W ~I6PY,d', 'HajkovaI@gmail.cz', 2, 'IT', '1995-02-18', 'žena', 'U Pískovny 7', 'Černovice'),
(63, 'Josefina', 'Šimková', 'Simkova86', '{)W7tI2H#y', 'SimkovaJ@worldonline.cz', 4, 'IT', '1994-10-31', 'žena', 'Riegrova 1795', 'Klobouky u Brna'),
(64, 'Zikmund', 'Mrkvička', 'Mrkvicka15', 'Er_4UU)MnT', 'MrkvickaZ@ladymail.cz', 3, 'IT', '1995-02-03', 'muž', 'S. K. Neumanna 1880', 'Netolice'),
(65, 'Isaiah', 'Mirga', 'Mirga93', ']RdWPy~Z&cat', 'MirgaI@quick.cz', 4, 'ST', '1994-08-17', 'muž', 'V Zahrádkách 7596', 'Jirkov'),
(66, 'Džamila', 'Kolářová', 'Kolarova78', '3v=wtcM5Nhe!4+(sX', 'KolarovaD@atlas.cz', 2, 'ST', '1995-06-25', 'žena', 'Za Lesem 8292', 'Kolín'),
(67, 'Zdeňka', 'Malá', 'Mala6', '^2IaSwRlth{Rzg[x3/ ', 'MalaZ@quick.cz', 1, 'ST', '1997-01-18', 'žena', 'Bezručova 8290', 'Sezemice'),
(68, 'Blažej', 'Vojta', 'Vojta43', '(60Dzbo#0qS', 'VojtaB@infoweb.cz', 2, 'EL', '1996-04-03', 'muž', '5. května 38', 'Hrušovany nad Jevišovkou'),
(69, 'Věroslav', 'Havlíček', 'Havlicek68', 'sUCbliw9Z?!c#YPO', 'HavlicekV@quick.cz', 2, 'ST', '1995-12-12', 'muž', 'Kollárova 263', 'Nový Bydžov'),
(70, 'Dobroslav', 'Janda', 'Janda39', '*VpxwT]%_ ', 'JandaD@fel.cvut.cz', 2, 'IT', '1995-05-15', 'muž', 'Třebízského 377', 'Nová Paka'),
(71, 'Liana', 'Dostálová', 'Dostalova94', 'H#=!q:pXCwa:&C}kfiV', 'DostalovaL@quick.cz', 2, 'ST', '1995-08-20', 'žena', 'U Rybníčků 6445', 'Mnichovo Hradiště'),
(72, 'Přemysl', 'Voráček', 'Voracek30', '.}0lkz/F;hqa', 'VoracekP@ladymail.cz', 1, 'EL', '1997-09-29', 'muž', 'Holíkova 4535', 'Přebuz'),
(73, 'Sebastian', 'Kabát', 'Kabat62', 'f4cj;#1hhT', 'KabatS@ladymail.cz', 4, 'EL', '1994-02-05', 'muž', 'Úzká 7014', 'Brušperk'),
(74, 'Egon', 'Votruba', 'Votruba31', '!&9SE@Bf.7290y}cw', 'VotrubaE@gmail.cz', 3, 'EL', '1995-07-27', 'muž', 'Široká 359', 'Sedlec-Prčice'),
(75, 'Bohuchval', 'Kotek', 'Kotek19', 'XXy}qER@$0(ex!nVpza', 'KotekB@email.cz', 2, 'EL', '1995-09-29', 'muž', 'Hybrálecká 3725', 'Litoměřice'),
(76, 'Světluše', 'Němečková', 'Nemeckova87', '9GUxooySF=Np~($&Rl~N', 'NemeckovaS@email.cz', 4, 'EL', '1993-04-13', 'žena', 'Lípová 6124', 'Bělá nad Radbuzou'),
(77, 'Nerys', 'Burešová', 'Buresova100', '4pa(y9Pi{D8laQM6:', 'BuresovaN@post.cz', 4, 'EL', '1993-11-27', 'žena', 'Halounova 8299', 'Sokolov'),
(78, 'Kevin', 'Coufal', 'Coufal98', '0^8rKBK>7W]', 'CoufalK@email.cz', 4, 'ST', '1994-02-11', 'muž', 'U Koželuhů 7850', 'Dobřichovice'),
(79, 'Ireneus', 'Holub', 'Holub80', '/|e^9|xg{2Ou%[bD#', 'HolubI@spoluzaci.cz', 1, 'EL', '1996-12-21', 'muž', 'Nad Přejezdem 1610', 'Ledeč nad Sázavou'),
(80, 'Lea', 'Tůmová', 'Tumova97', 't*s2ZM8OZcsZ%i*u_[c', 'TumovaL@fel.cvut.cz', 4, 'EL', '1993-05-17', 'žena', 'Kpt. Nálepky 452', 'Slavonice'),
(81, 'Soňa', 'Němečková', 'Nemeckova98', 'rzpi(GGC#$5wF', 'NemeckovaS@email.cz', 2, 'EL', '1996-11-13', 'žena', 'Stamicova 7971', 'Planá'),
(82, 'Justina', 'Staňková', 'Stankova10', '#MZLaGk)61,pC&N>=PQ', 'StankovaJ@spoluzaci.cz', 2, 'IT', '1996-04-01', 'žena', 'Boženy Němcové 7509', 'Karlovy Vary'),
(83, 'Apolena', 'Marková', 'Markova64', 'J/;h@y)48uW9#y?WVA', 'MarkovaA@sps-jia.cz', 3, 'ST', '1994-10-11', 'žena', 'Křivá 7442', 'Milevsko'),
(84, 'Gertruda', 'Žáková', 'Zakova5', '(hhRa1Z}a3$R', 'ZakovaG@quick.cz', 3, 'IT', '1995-09-06', 'žena', 'Březinovy sady 7651', 'Švihov'),
(85, 'Alvar', 'Válek', 'Valek2', '0w&J>]}x%p', 'ValekA@ladymail.cz', 4, 'ST', '1993-09-10', 'muž', 'třída Legionářů 6179', 'Karlovy Vary'),
(86, 'Bohuslava', 'Dostálová', 'Dostalova35', 'gH]j+!5b7hP%$_q', 'DostalovaB@inmail.cz', 1, 'EL', '1997-07-04', 'žena', 'Nad Plovárnou 8113', 'Teplá'),
(87, 'Tabita', 'Kašparová', 'Kasparova18', 'r|]z-XH#9^!Uj{#D', 'KasparovaT@eposta.cz', 4, 'EL', '1993-06-22', 'žena', 'S. K. Neumanna 3058', 'Nýřany'),
(88, 'Richard', 'Dostál', 'Dostal13', '/-tLBI#5s,xmaT', 'DostalR@centrum.cz', 1, 'IT', '1997-02-07', 'muž', 'Na Vrchovině 4088', 'Dobruška'),
(89, 'Metoděj', 'Tomek', 'Tomek37', '}~->F?dHse20$', 'TomekM@ladymail.cz', 1, 'ST', '1996-04-20', 'muž', 'Na Sádkách 4993', 'Holešov'),
(90, 'Marina', 'Kratochvílová', 'Kratochvilova10', 'jheeNn]-&7m', 'KratochvilovaM@email.cz', 3, 'ST', '1994-07-03', 'žena', 'Štefánikovo náměstí 4133', 'Bzenec'),
(91, 'Barabáš', 'Hanzal', 'Hanzal76', 'RpL,/]S0y+5Hj#V{Y', 'HanzalB@worldonline.cz', 2, 'IT', '1996-09-03', 'muž', 'Majakovského 4532', 'Kolín'),
(92, 'Cyril', 'Votava', 'Votava92', 'O( uE(^8(ad', 'VotavaC@inmail.cz', 1, 'IT', '1996-05-11', 'muž', 'Horní 1633', 'Šluknov'),
(93, 'Vanda', 'Valentová', 'Valentova67', 'CS?[^UWTAdgCj6&<', 'ValentovaV@eposta.cz', 3, 'IT', '1995-05-21', 'žena', 'U Mincovny 3524', 'Kladruby'),
(94, 'Dominika', 'Ježková', 'Jezkova3', 'X85#SygUsp]WM31HlC', 'JezkovaD@vspj.cz', 4, 'ST', '1993-01-03', 'žena', 'Ke Skalce 9478', 'Olomouc'),
(95, 'Budimír', 'Anděl', 'Andel42', 'b5$5m?Ew~a94DN@ji;', 'AndelB@tiscali.cz', 3, 'ST', '1995-12-29', 'muž', 'U Dlouhé stěny 7357', 'Česká Skalice'),
(96, 'Juraj', 'Křeček', 'Krecek5', 'kZihB?),t>wH?4GM+eF', 'KrecekJ@post.cz', 1, 'ST', '1997-04-09', 'muž', 'Gorkého 3561', 'Chrast'),
(97, 'Renáta', 'Dušková', 'Duskova83', '.ru{fUjnDXjOoC+Rhyw', 'DuskovaR@sps-jia.cz', 1, 'IT', '1996-04-09', 'žena', 'U Dlouhé stěny 462', 'Vodňany'),
(98, 'Amálie', 'Urbanová', 'Urbanova83', 'QaO9o&6daUADt&c ](', 'UrbanovaA@atlas.cz', 2, 'EL', '1996-02-25', 'žena', 'Gorkého 4552', 'Město Touškov'),
(99, 'Romana', 'Štěpánková', 'Stepankova52', 'TcXNh[x^du', 'StepankovaR@spoluzaci.cz', 3, 'IT', '1994-03-27', 'žena', 'Úzká 162', 'Březová nad Svitavou'),
(100, 'Dobromila', 'Jarošová', 'Jarosova11', '*s&[x$OMQ_ip/h*', 'JarosovaD@ladymail.cz', 1, 'ST', '1997-12-23', 'žena', 'Na Růžku 8879', 'Radnice');

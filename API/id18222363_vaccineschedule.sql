-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 01, 2022 at 10:51 AM
-- Server version: 10.5.12-MariaDB
-- PHP Version: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id18222363_vaccineschedule`
--

-- --------------------------------------------------------

--
-- Table structure for table `addlogs`
--

CREATE TABLE `addlogs` (
  `id` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `activity` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addlogs`
--

INSERT INTO `addlogs` (`id`, `username`, `activity`, `date`, `time`) VALUES
(1, 'supp', 'ADDED NEW VACCINE supp', '2022-01-24', '11:45:29'),
(2, 'supp', 'ADDED new VACCINE fipi', '2022-01-24', '11:57:37'),
(3, 'supp', 'ADDED new VACCINE samplelang', '2022-01-25', '12:48:22'),
(4, 'supp', 'ADDED new VACCINE supp1', '2022-01-25', '01:13:02'),
(5, 'supp', 'ADDED new VACCINE christianjames', '2022-01-25', '01:14:54'),
(6, 'supp', 'ADDED new VACCINE samplenew', '2022-01-25', '10:38:21'),
(7, 'supp', 'ADDED new VACCINE new vaccine', '2022-01-25', '02:08:35'),
(8, 'supp', 'ADDED new VACCINE sampleforsupp', '2022-01-25', '18:18:47'),
(9, 'supp', 'ADDED new VACCINE ', '2022-01-25', '18:19:12'),
(10, 'supp', 'ADDED new VACCINE sample', '2022-01-25', '22:18:47'),
(11, 'supp', 'ADDED new VACCINE sample1', '2022-01-25', '23:03:20');

-- --------------------------------------------------------

--
-- Table structure for table `adminaccount`
--

CREATE TABLE `adminaccount` (
  `id` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `level` int(100) NOT NULL,
  `position` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminaccount`
--

INSERT INTO `adminaccount` (`id`, `username`, `password`, `level`, `position`) VALUES
(1, 'admin', 'admin', 1, 'Nurse'),
(5, 'admin1', 'admin1', 0, 'NurseDin');

-- --------------------------------------------------------

--
-- Table structure for table `adminlogs`
--

CREATE TABLE `adminlogs` (
  `id` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `activity` varchar(100) NOT NULL,
  `admin_id` int(100) NOT NULL,
  `dateandtime` datetime NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminlogs`
--

INSERT INTO `adminlogs` (`id`, `username`, `activity`, `admin_id`, `dateandtime`, `date`, `time`) VALUES
(1, 'admin', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(2, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(3, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(4, 'admin1', 'LOG OUT', 0, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(5, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(6, 'admin1', 'LOG OUT', 0, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(7, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(8, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(9, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(10, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(11, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(12, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(13, 'admin', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(14, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(15, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(16, 'admin', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(17, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(18, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(19, 'admin', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(20, 'admin', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(21, 'admin', 'LOG OUT', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(22, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(23, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(24, 'admin', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(25, 'admin', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(26, 'admin', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(27, 'admin', 'LOG OUT', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(28, 'admin', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(29, 'admin', 'LOG OUT', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(30, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(31, 'admin1', 'LOG OUT', 0, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(32, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(33, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(34, 'Aztech@1', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(35, 'Aztech@1', 'LOG OUT', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(36, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(37, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(38, 'Aztech@1', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(39, 'Aztech@1', 'LOG OUT', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(40, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(41, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(42, 'Aztech@1', 'LOG IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(43, 'admin1', 'LOG IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(44, 'admin1', 'ADDED NEW VACCINE', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(45, 'admin1', 'ADDED NEW VACCINE 1', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(46, 'admin1', 'DELETED VACCINE ', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(47, 'admin1', 'DELETED VACCINE ', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(48, 'admin1', 'DELETED VACCINE ', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(49, 'admin1', 'ADDED NEW VACCINE sample', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(50, 'admin1', 'DELETED VACCINE ', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(51, 'admin1', 'ADDED NEW VACCINE admin', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(52, 'admin1', 'DELETED VACCINE ', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(53, 'admin1', 'ADDED NEW VACCINE admin', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(54, 'admin1', 'DELETED VACCINE 0', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(55, 'admin1', 'ADDED NEW VACCINE gumana', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(56, 'admin1', 'DELETED VACCINE ', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(57, 'admin1', 'ADDED NEW VACCINE 123', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(58, 'admin1', 'DELETED VACCINE ', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(59, 'admin1', 'ADDED NEW VACCINE maligaya', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(60, 'admin1', 'DELETED VACCINE ', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(61, 'admin1', 'ADDED NEW VACCINE 1', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(62, 'admin1', 'DELETED VACCINE 1', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(63, 'admin1', 'UPDATE VACCINE HUMAN-PAPILLOMAVIRUS-VACCINE, SETS', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(64, 'admin1', 'LOG OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(65, 'Aztech@1', 'LOGGED OUT', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(66, 'admin1', 'LOGGED IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(67, 'admin1', 'LOGGED OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(68, 'Aztech@1', 'LOGGED IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(69, 'Aztech@1', 'LOGGED OUT', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(70, 'admin1', 'LOGGED IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(71, 'admin1', 'LOGGED OUT', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(72, 'Aztech@1', 'LOGGED IN', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(73, 'Aztech@1', 'LOGGED OUT', 1, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(74, 'admin1', 'LOGGED IN', 5, '2022-01-23 00:00:00', '0000-00-00', '00:00:00'),
(75, 'Aztech@1', 'LOGGED IN', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(76, 'Aztech@1', 'LOGGED OUT', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(77, 'admin1', 'LOGGED IN', 5, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(78, 'admin1', 'EXPORTED History', 5, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(79, 'Aztech@1', 'LOGGED IN', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(80, 'admin1', 'ACCEPT Appointment No. 99', 5, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(81, 'admin1', 'REFUSED Appointment No. 84', 5, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(82, 'admin1', 'GAVE another Schedule for Appointment No. 37', 5, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(83, 'admin1', 'EXPORTED History of User No. 24', 5, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(84, 'admin1', 'DOWNLOADED PDF Appoinment sets for User No. 24', 5, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(85, 'admin1', 'LOGGED OUT', 5, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(86, 'Aztech@1', 'LOGGED IN', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(87, 'Aztech@1', 'LOGGED OUT', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(88, 'Aztech@1', 'LOGGED IN', 1, '2022-01-24 04:58:00', '0000-00-00', '00:00:00'),
(89, 'Aztech@1', 'ADDED NEW Admin User', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(90, 'Aztech@1', 'LOGGED OUT', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(91, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '0000-00-00', '00:00:00'),
(92, 'Aztech@1', 'LOGGED OUT', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(93, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '0000-00-00', '00:00:00'),
(94, 'christianjames', 'ACCEPTED Appointment No. 100', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(95, 'christianjames', 'REFUSED Appointment No. 83', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(96, 'christianjames', 'EXPORTED History of TETANUS-DIPHTHERIA', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(97, 'christianjames', 'DOWNLOADED PDF Appoinment sets for User No. 24', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(98, 'christianjames', 'UPDATED Appointment No. 37', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(99, 'christianjames', 'SET next Schedule for Appointment No. 37', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(100, 'christianjames', 'ACCEPTED Appointment No. 102', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(101, 'christianjames', 'GAVE another Schedule for Appointment No. 100', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(102, 'christianjames', 'DOWNLOADED PDF Appoinment sets for User No. 48', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(103, 'christianjames', 'LOGGED OUT', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(104, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '0000-00-00', '00:00:00'),
(105, 'Aztech@1', 'LOGGED OUT', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(106, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '0000-00-00', '00:00:00'),
(107, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '0000-00-00', '00:00:00'),
(108, 'christianjames', 'LOGGED OUT', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(109, 'supp', 'LOGGED IN', 14, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(110, 'supp', 'ADDED NEW VACCINE supp', 14, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(111, 'supp', 'ADDED NEW VACCINE supp1', 14, '2022-01-25 00:00:00', '0000-00-00', '00:00:00'),
(112, 'christianjames', 'LOGGED IN', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(113, 'supp', 'ADDED NEW VACCINE christianjames', 14, '2022-01-25 00:00:00', '0000-00-00', '00:00:00'),
(114, 'christianjames', 'REQUEST Stack for christianjames', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(115, 'supp', 'GAVE stacks of  christianjames', 14, '2022-01-25 00:00:00', '0000-00-00', '00:00:00'),
(116, 'christianjames', 'LOGGED OUT', 12, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(117, 'Aztech@1', 'LOGGED IN', 1, '2022-01-24 00:00:00', '0000-00-00', '00:00:00'),
(118, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-25', '09:10:43'),
(119, 'supp', 'UPDATED VACCINE christianjames SETS', 14, '0000-00-00 00:00:00', '2022-01-25', '09:38:22'),
(120, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '09:39:10'),
(121, 'supp', 'UPDATED VACCINE christianjames SETS', 14, '0000-00-00 00:00:00', '2022-01-25', '09:39:35'),
(122, 'supp', 'UPDATED VACCINE christianjames SETS', 14, '0000-00-00 00:00:00', '2022-01-25', '09:41:34'),
(123, 'christianjames', 'DELETED VACCINE christianjames', 12, '0000-00-00 00:00:00', '2022-01-25', '10:34:31'),
(124, 'christianjames', 'DELETED VACCINE supp1', 12, '0000-00-00 00:00:00', '2022-01-25', '10:34:38'),
(125, 'christianjames', 'DELETED VACCINE supp', 12, '0000-00-00 00:00:00', '2022-01-25', '10:34:45'),
(126, 'christianjames', 'REQUEST Stack for BCG', 12, '0000-00-00 00:00:00', '2022-01-25', '02:36:52'),
(127, 'supp', 'GAVE stacks for  BCG', 14, '0000-00-00 00:00:00', '2022-01-25', '00:00:00'),
(128, 'supp', 'ADDED NEW VACCINE samplenew', 14, '0000-00-00 00:00:00', '2022-01-25', '10:38:21'),
(129, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-25', '11:14:48'),
(130, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-25', '11:15:01'),
(131, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-25', '11:16:04'),
(132, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '11:16:32'),
(133, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-25', '12:17:02'),
(134, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '12:17:10'),
(135, 'christianjames', 'REQUEST Stack for samplenew', 12, '0000-00-00 00:00:00', '2022-01-25', '04:20:16'),
(136, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-25', '01:16:10'),
(137, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-25', '01:23:19'),
(138, 'christianjames', 'REQUEST Stack for samplenew', 12, '0000-00-00 00:00:00', '2022-01-25', '05:23:41'),
(139, 'supp', 'GAVE stacks for  samplenew', 14, '0000-00-00 00:00:00', '2022-01-25', '00:00:00'),
(140, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-25', '01:28:47'),
(141, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '01:28:56'),
(142, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-25', '01:29:05'),
(143, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-25', '02:03:20'),
(144, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '02:04:34'),
(145, 'christianjames', 'REQUEST Stack for PCV', 12, '0000-00-00 00:00:00', '2022-01-25', '06:06:32'),
(146, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-25', '02:06:48'),
(147, 'supp', 'GAVE stacks for  PCV', 14, '0000-00-00 00:00:00', '2022-01-25', '00:00:00'),
(148, 'supp', 'ADDED NEW VACCINE new vaccine', 14, '0000-00-00 00:00:00', '2022-01-25', '02:08:35'),
(149, 'christianjames', 'REQUEST Stack for new%20vaccine', 12, '0000-00-00 00:00:00', '2022-01-25', '06:09:53'),
(150, 'supp', 'GAVE stacks for  new%20vaccine', 14, '0000-00-00 00:00:00', '2022-01-25', '00:00:00'),
(151, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-25', '02:14:15'),
(152, 'supp', 'GAVE stacks for  samplenew', 14, '0000-00-00 00:00:00', '2022-01-25', '00:00:00'),
(153, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-25', '03:38:19'),
(154, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '03:38:35'),
(155, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-25', '03:39:26'),
(156, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '03:40:17'),
(157, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-25', '03:42:59'),
(158, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '03:43:15'),
(159, 'Aztech@1', 'DELETED Admin ID No. 13', 1, '0000-00-00 00:00:00', '2022-01-25', '01:14:56'),
(160, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '04:17:11'),
(161, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-25', '17:00:09'),
(162, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '17:00:23'),
(163, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-25', '18:16:21'),
(164, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-25', '18:16:32'),
(165, 'supp', 'GAVE stacks for  samplelang', 14, '0000-00-00 00:00:00', '2022-01-25', '00:00:00'),
(166, 'supp', 'ADDED NEW VACCINE sampleforsupp', 14, '0000-00-00 00:00:00', '2022-01-25', '18:18:47'),
(167, 'supp', 'ADDED NEW VACCINE ', 14, '0000-00-00 00:00:00', '2022-01-25', '18:19:12'),
(168, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-25', '18:31:27'),
(169, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '18:31:41'),
(170, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-25', '18:32:38'),
(171, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '18:32:48'),
(172, 'christianjames', 'ACCEPTED Appointment No. 104', 12, '0000-00-00 00:00:00', '2022-01-25', '18:33:41'),
(173, 'christianjames', 'DELETED Appointment No. 93', 12, '0000-00-00 00:00:00', '2022-01-25', '18:36:22'),
(174, 'christianjames', 'UPDATED Appointment No. 100', 12, '0000-00-00 00:00:00', '2022-01-25', '18:36:50'),
(175, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-25', '19:22:50'),
(176, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '19:24:08'),
(177, 'Aztech@1', 'ADDED NEW Admin User', 1, '0000-00-00 00:00:00', '2022-01-25', '19:35:17'),
(178, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-25', '19:35:23'),
(179, 'supp1', 'LOGGED IN', 15, '0000-00-00 00:00:00', '2022-01-25', '19:35:28'),
(180, 'supp1', 'LOGGED OUT', 15, '0000-00-00 00:00:00', '2022-01-25', '19:35:43'),
(181, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '19:35:55'),
(182, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-25', '19:41:44'),
(183, 'supp1', 'LOGGED IN', 15, '0000-00-00 00:00:00', '2022-01-25', '19:42:56'),
(184, 'supp1', 'LOGGED OUT', 15, '0000-00-00 00:00:00', '2022-01-25', '19:43:09'),
(185, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '19:43:17'),
(186, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-25', '20:40:27'),
(187, 'supp1', 'LOGGED IN', 15, '0000-00-00 00:00:00', '2022-01-25', '20:40:37'),
(188, 'supp1', 'LOGGED OUT', 15, '0000-00-00 00:00:00', '2022-01-25', '20:44:28'),
(189, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-25', '20:51:22'),
(190, 'supp1', 'LOGGED IN', 15, '0000-00-00 00:00:00', '2022-01-25', '21:55:45'),
(191, 'supp1', 'LOGGED OUT', 15, '0000-00-00 00:00:00', '2022-01-25', '22:06:05'),
(192, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '22:06:13'),
(193, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-25', '22:08:06'),
(194, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-25', '22:08:15'),
(195, 'supp', 'UPDATED VACCINE BCG SETS', 14, '0000-00-00 00:00:00', '2022-01-25', '22:08:27'),
(196, 'supp', 'ADDED NEW VACCINE sample', 14, '0000-00-00 00:00:00', '2022-01-25', '22:18:47'),
(197, 'supp', 'UPDATED VACCINE PENTAVALENT-VACCINE SETS', 14, '0000-00-00 00:00:00', '2022-01-25', '22:21:39'),
(198, 'supp', 'UPDATED VACCINE HUMAN-PAPILLOMAVIRUS-VACCINE SETS', 14, '0000-00-00 00:00:00', '2022-01-25', '22:21:50'),
(199, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-25', '22:39:12'),
(200, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-25', '23:02:53'),
(201, 'supp', 'ADDED NEW VACCINE sample1', 14, '0000-00-00 00:00:00', '2022-01-25', '23:03:20'),
(202, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-25', '23:04:52'),
(203, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '23:47:27'),
(204, 'christianjames', 'REQUEST Stack for TETANUS-DIPHTHERIA', 12, '0000-00-00 00:00:00', '2022-01-25', '23:53:05'),
(205, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-25', '23:53:20'),
(206, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-25', '23:53:57'),
(207, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '23:54:27'),
(208, 'christianjames', 'REQUEST Stack for sample', 12, '0000-00-00 00:00:00', '2022-01-25', '23:54:37'),
(209, 'christianjames', 'REQUEST Stack for HUMAN-PAPILLOMAVIRUS-VACCINE', 12, '0000-00-00 00:00:00', '2022-01-25', '23:54:54'),
(210, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-25', '23:55:20'),
(211, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-25', '23:55:42'),
(212, 'christianjames', 'ACCEPTED Appointment No. 101', 12, '0000-00-00 00:00:00', '2022-01-25', '23:56:17'),
(213, 'christianjames', 'DOWNLOADED PDF Appoinment sets for User No. 48', 12, '0000-00-00 00:00:00', '2022-01-25', '23:57:24'),
(214, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-25', '23:58:38'),
(215, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-25', '23:58:53'),
(216, 'Aztech@1', 'DELETED Admin ID No. 15', 1, '0000-00-00 00:00:00', '2022-01-25', '23:59:52'),
(217, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-26', '00:00:23'),
(218, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '00:00:43'),
(219, 'christianjames', 'EXPORTED History', 12, '0000-00-00 00:00:00', '2022-01-26', '00:55:08'),
(220, 'christianjames', 'REQUEST Stack for sample', 12, '0000-00-00 00:00:00', '2022-01-26', '00:55:55'),
(221, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-26', '00:56:00'),
(222, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-26', '00:56:14'),
(223, 'supp', 'GAVE stacks for sample', 14, '0000-00-00 00:00:00', '2022-01-26', '00:00:00'),
(224, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-26', '00:57:07'),
(225, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '00:57:19'),
(226, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-26', '01:50:18'),
(227, 'christianjames', 'REQUEST New Stacks for HUMAN-PAPILLOMAVIRUS-VACCINE', 12, '0000-00-00 00:00:00', '2022-01-26', '01:50:23'),
(228, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-26', '01:50:30'),
(229, 'supp', 'GAVE New stacks for HUMAN-PAPILLOMAVIRUS-VACCINE', 14, '0000-00-00 00:00:00', '2022-01-26', '00:00:00'),
(230, 'christianjames', 'REQUEST New Stacks for TETANUS-DIPHTHERIA', 12, '0000-00-00 00:00:00', '2022-01-26', '01:53:14'),
(231, 'supp', 'GAVE New stacks for TETANUS-DIPHTHERIA', 14, '0000-00-00 00:00:00', '2022-01-26', '00:00:00'),
(232, 'christianjames', 'REQUEST New Stacks for MMR-GRADE-7', 12, '0000-00-00 00:00:00', '2022-01-26', '02:51:42'),
(233, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-26', '02:51:44'),
(234, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-26', '02:51:57'),
(235, 'supp', 'GAVE New stacks for MMR-GRADE-7', 14, '0000-00-00 00:00:00', '2022-01-26', '00:00:00'),
(236, 'supp', 'UPDATED VACCINE HUMAN-PAPILLOMAVIRUS-VACCINE SETS', 14, '0000-00-00 00:00:00', '2022-01-26', '02:58:19'),
(237, 'supp', 'ADD New Stacks of HUMAN-PAPILLOMAVIRUS-VACCINE', 14, '0000-00-00 00:00:00', '2022-01-26', '03:01:28'),
(238, 'supp', 'UPDATED VACCINE HUMAN-PAPILLOMAVIRUS-VACCINE SETS', 14, '0000-00-00 00:00:00', '2022-01-26', '03:02:35'),
(239, 'supp', 'UPDATED VACCINE sample SETS', 14, '0000-00-00 00:00:00', '2022-01-26', '03:04:15'),
(240, 'supp', 'ADD New Stacks of HUMAN-PAPILLOMAVIRUS-VACCINE', 14, '0000-00-00 00:00:00', '2022-01-26', '03:04:23'),
(241, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-26', '03:07:15'),
(242, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '03:07:30'),
(243, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '08:06:33'),
(244, 'christianjames', 'REQUEST New Stacks for IPV', 12, '0000-00-00 00:00:00', '2022-01-26', '08:08:25'),
(245, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-26', '08:08:31'),
(246, 'supp', 'GAVE New stacks for IPV', 14, '0000-00-00 00:00:00', '2022-01-26', '00:00:00'),
(247, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-26', '08:11:22'),
(248, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-26', '08:11:27'),
(249, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '09:47:11'),
(250, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '09:59:02'),
(251, 'christianjames', 'UPDATED Appointment No. 87', 12, '0000-00-00 00:00:00', '2022-01-26', '10:00:30'),
(252, 'christianjames', 'REQUEST Stack for sample', 12, '0000-00-00 00:00:00', '2022-01-26', '10:02:24'),
(253, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-26', '10:02:32'),
(254, 'supp', 'LOGGED IN', 14, '0000-00-00 00:00:00', '2022-01-26', '10:02:42'),
(255, 'supp', 'GAVE stacks for sample', 14, '0000-00-00 00:00:00', '2022-01-26', '00:00:00'),
(256, 'supp', 'LOGGED OUT', 14, '0000-00-00 00:00:00', '2022-01-26', '10:03:32'),
(257, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '10:03:43'),
(258, 'christianjames', 'SET next Schedule for Appointment No. 87', 12, '0000-00-00 00:00:00', '2022-01-26', '10:05:22'),
(259, 'christianjames', 'DOWNLOADED PDF Appoinment sets for User No. 48', 12, '0000-00-00 00:00:00', '2022-01-26', '10:06:32'),
(260, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-26', '10:07:00'),
(261, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-26', '10:07:09'),
(262, 'Aztech@1', 'ADDED NEW Admin User', 1, '0000-00-00 00:00:00', '2022-01-26', '10:07:55'),
(263, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-26', '10:08:31'),
(264, 'supp1', 'LOGGED IN', 16, '0000-00-00 00:00:00', '2022-01-26', '10:08:44'),
(265, 'supp1', 'ADD New Stacks of TETANUS-DIPHTHERIA', 16, '0000-00-00 00:00:00', '2022-01-26', '10:09:35'),
(266, 'supp1', 'LOGGED OUT', 16, '0000-00-00 00:00:00', '2022-01-26', '10:10:53'),
(267, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '10:12:31'),
(268, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '19:42:12'),
(269, 'christianjames', 'ARCHIVED Appointment No. 54', 12, '0000-00-00 00:00:00', '2022-01-26', '19:42:49'),
(270, 'christianjames', 'ARCHIVED Appointment No. 55', 12, '0000-00-00 00:00:00', '2022-01-26', '19:42:57'),
(271, 'christianjames', 'REFUSED Appointment No. 82', 12, '0000-00-00 00:00:00', '2022-01-26', '19:47:21'),
(272, 'christianjames', 'LOGGED OUT', 12, '0000-00-00 00:00:00', '2022-01-26', '19:47:56'),
(273, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-26', '19:48:02'),
(274, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-26', '20:08:55'),
(275, 'Aztech@1', 'LOGGED IN', 1, '0000-00-00 00:00:00', '2022-01-26', '20:09:12'),
(276, 'Aztech@1', 'LOGGED OUT', 1, '0000-00-00 00:00:00', '2022-01-26', '20:09:23'),
(277, 'christianjames', 'LOGGED IN', 12, '0000-00-00 00:00:00', '2022-01-26', '20:09:33'),
(278, 'christianjames', 'ACCEPTED Appointment No. 81', 12, '0000-00-00 00:00:00', '2022-01-26', '20:12:46'),
(279, 'christianjames', 'REFUSED Appointment No. 80', 12, '0000-00-00 00:00:00', '2022-01-26', '20:13:10'),
(280, 'christianjames', 'EXPORTED Archive', 12, '0000-00-00 00:00:00', '2022-01-26', '20:16:09');

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `answer_checklist` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `answer_screening` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`answer_checklist`, `answer_screening`, `user_id`) VALUES
('{\"1\":\"0\",\"2\":\"0\",\"3\":\"0\",\"4\":\"0\",\"5\":\"0\"}', '{\"6\":\"0\",\"7\":\"0\",\"8\":\"0\",\"9\":\"0\",\"10\":\"0\",\"11\":\"0\",\"12\":\"0\"}', 24);

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `appo_id` int(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `appo_date` date NOT NULL,
  `appo_time` time NOT NULL,
  `vaccine` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `user_id` int(100) NOT NULL,
  `nurse` varchar(100) NOT NULL,
  `place` text NOT NULL,
  `email` varchar(30) NOT NULL,
  `dose` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`appo_id`, `lastname`, `firstname`, `phonenumber`, `appo_date`, `appo_time`, `vaccine`, `status`, `user_id`, `nurse`, `place`, `email`, `dose`) VALUES
(27, 'Sabado', 'Dana', '1', '2022-01-05', '22:14:00', 'Vaccine2', 'Choose Status...', 9, 'Dr.Z', '', '', 1),
(28, 'Sabado', 'Dana', '1', '2021-11-25', '16:08:00', 'Vaccine2', 'WAITING', 9, 'Dr.Z', '', '', 1),
(29, 'Sabado', 'Dana', '1', '2021-11-16', '08:52:00', 'Vaccine2', 'WAITING', 9, 'ako', '', '', 1),
(30, 'Sabado', 'Dana', '1', '2022-01-18', '20:17:00', 'Vaccine2', 'Choose Status...', 9, 'sample1', '', '', 1),
(33, 'Sabado', 'Dana', '1', '2021-10-19', '10:18:00', 'Vaccine2', 'WAITING', 9, 'ako', '', '', 1),
(34, 'Sabado', 'Dana', '1', '0000-00-00', '00:00:00', 'Vaccine2', 'WAITING', 9, 'ako', '', '', 1),
(44, 'testlastname', 'testfirstname', '09912345678', '2021-12-25', '03:00:00', 'HUMAN PAPILLOMAVIRUS VACCINE', 'WAITING', 24, 'Dr.Zawd', 'kadiwa', 'test@email.com', 1),
(45, 'testlastname', 'testfirstname', '09912345678', '2022-01-15', '03:00:00', 'HUMAN PAPILLOMAVIRUS VACCINE', 'COMPLETED', 24, 'Dr.Zawd', 'kadiwa', 'test@email.com', 1),
(46, 'testlastname', 'testfirstname', '09912345678', '2022-01-18', '00:03:00', 'HEPATITIS B', 'WAITING', 24, 'Dr.Zwd', 'Saint Dominic', 'test@email.com', 1),
(47, 'testlastname', 'testfirstname', '09912345678', '2022-02-14', '20:14:00', 'BCG', 'WAITING', 24, 'sample', 'NCST', 'test@email.com', 1),
(48, 'testlastname', 'testfirstname', '09912345678', '2022-01-15', '03:00:00', 'MMR', 'WAITING', 24, 'Dr.Zawd', 'kadiwa', 'test@email.com', 1),
(49, 'testlastname', 'testfirstname', '09912345678', '2022-01-18', '00:03:00', 'BCG', 'WAITING', 24, 'Dr.Zwd', 'Saint Dominic', 'test@email.com', 1),
(50, 'testlastname', 'testfirstname', '09912345678', '2022-01-15', '03:00:00', 'BCG', 'WAITING', 24, 'Dr.Zawd', 'kadiwa', 'test@email.com', 1),
(51, 'testlastname', 'testfirstname', '09912345678', '2022-01-15', '03:00:00', 'PCV', 'WAITING', 24, 'Dr.Zawd', 'kadiwa', 'test@email.com', 1),
(52, 'testlastname', 'testfirstname', '09912345678', '2022-01-18', '00:03:00', 'PCV', 'WAITING', 24, 'Dr.Zwd', 'Saint Dominic', 'test@email.com', 1),
(53, 'testlastname', 'testfirstname', '09912345678', '2022-02-14', '20:14:00', 'HEPATITIS B', 'WAITING', 24, 'sample', 'NCST', 'test@email.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `archive`
--

CREATE TABLE `archive` (
  `arc_id` int(100) NOT NULL,
  `appo_id` int(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `phonenumber` varchar(12) NOT NULL,
  `appo_date` date NOT NULL,
  `appo_time` time NOT NULL,
  `vaccine` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `user_id` int(100) NOT NULL,
  `nurse` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `for_id` int(255) NOT NULL DEFAULT 0,
  `place` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `archive`
--

INSERT INTO `archive` (`arc_id`, `appo_id`, `lastname`, `firstname`, `phonenumber`, `appo_date`, `appo_time`, `vaccine`, `status`, `user_id`, `nurse`, `email`, `for_id`, `place`) VALUES
(1, 54, 'Diegas', 'Johnrich', '09123456780', '2022-01-15', '03:00:00', 'TETANUS-DIPHTHERIA', 'MISSED', 38, 'Dr.Zawd', 'diegasjohnrich014@gmail.com', 0, 'kadiwa'),
(2, 55, 'Diegas', 'Johnrich', '09123456780', '2022-01-11', '19:03:00', 'PENTAVALENT-VACCINE', 'MISSED', 38, 'sample for 2nd dose', 'diegasjohnrich014@gmail.com', 0, 'Saint Dominic'),
(3, 82, 'Acuba', 'Roy', '09092553058', '2022-02-09', '08:00:00', 'MMR-GRADE-7', 'MISSED', 57, 'Dra.Rapael', 'Roy@gmail.com', 0, 'Brgy Health Center'),
(4, 80, 'Bayeta', 'Annabelle', '09092553058', '2022-02-02', '08:00:00', 'OPV', 'PENDING', 55, 'Dra.Rapael', 'annabayeta@gmail.com', 0, 'Brgy Health Center');

-- --------------------------------------------------------

--
-- Table structure for table `counting`
--

CREATE TABLE `counting` (
  `id` int(11) NOT NULL,
  `number` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `counting`
--

INSERT INTO `counting` (`id`, `number`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feed_id` int(11) NOT NULL,
  `frstname` text COLLATE utf8_unicode_ci NOT NULL,
  `lastname` text COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `feedback` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

CREATE TABLE `feedbacks` (
  `id` int(11) NOT NULL,
  `appo_id` int(11) NOT NULL,
  `feedback` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `feedbacks`
--

INSERT INTO `feedbacks` (`id`, `appo_id`, `feedback`) VALUES
(1, 45, 'illness');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `his_id` int(11) NOT NULL,
  `appo_id` int(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `phonenumber` int(100) NOT NULL,
  `appo_date` date NOT NULL,
  `appo_time` time NOT NULL,
  `vaccine` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `user_id` int(100) NOT NULL,
  `nurse` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `for_id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`his_id`, `appo_id`, `lastname`, `firstname`, `phonenumber`, `appo_date`, `appo_time`, `vaccine`, `status`, `user_id`, `nurse`, `email`, `for_id`) VALUES
(19, 0, 'Sabado', 'Dana', 1, '2022-01-09', '10:59:00', 'Vaccine2', '1ST DOSE DONE', 24, 'pepten', '', 0),
(20, 0, 'Sabado', 'Dana', 1, '2022-01-09', '23:25:00', 'Vaccine2', '2ND DOSE DONE', 24, 'sanagumananatal', '', 0),
(21, 0, 'Sabado', 'Dana', 1, '2022-01-09', '23:29:00', 'Vaccine2', 'VACCINATED', 24, 'ito naaaaaaaaa', '', 0),
(22, 46, 'Sabado', 'Dana', 1, '2022-01-10', '11:45:00', 'Vaccine2', '2ND DOSE DONE', 24, 'itonatalgatu', 'yahoo.deguzman@gmail.com', 0),
(23, 46, 'Sabado', 'Dana', 1, '2022-01-10', '11:45:00', 'Vaccine2', '1ST DOSE DONE', 24, 'itonatalgatu', 'yahoo.deguzman@gmail.com', 0),
(24, 46, 'Sabado', 'Dana', 1, '2022-01-10', '00:00:00', 'Vaccine2', 'VACCINATED', 24, 'itonatalagatuuu', 'yahoo.deguzman@gmail.com', 0),
(25, 38, 'Gueco', 'Jove', 1, '2022-01-11', '14:07:00', 'Vaccine2', '1ST DOSE DONE', 27, 'Drz', 'yahoo.deguzman@gmail.com', 0),
(26, 38, 'Gueco', 'Jove', 1, '2022-01-11', '16:26:00', 'Vaccine2', '2ND DOSE DONE', 27, '4255', 'yahoo.deguzman@gmail.com', 0),
(27, 38, 'Gueco', 'Jove', 1, '2022-01-11', '16:28:00', 'Vaccine2', 'VACCINATED', 27, 'aaa', 'yahoo.deguzman@gmail.com', 0),
(28, 55, 'Diegas', 'Johnrich', 2147483647, '2022-01-11', '18:56:00', 'PENTAVALENT-VACCINE', '1ST DOSE DONE', 38, 'test email', 'diegasjohnrich014@gmail.com', 0);

-- --------------------------------------------------------

--
-- Table structure for table `manufacturer`
--

CREATE TABLE `manufacturer` (
  `id` int(100) NOT NULL,
  `manuname` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `manufacturer`
--

INSERT INTO `manufacturer` (`id`, `manuname`) VALUES
(1, 'Merck, USA'),
(2, 'Merck, PH');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(100) NOT NULL,
  `question` varchar(200) NOT NULL,
  `category` varchar(30) NOT NULL DEFAULT 'checklist'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `question`, `category`) VALUES
(1, 'Are you experiencing sore throat, Body pains, Headache, or Fever for the past few days?', 'checklist'),
(2, 'Have you worked together or stayed together in the same close environment of a confirmed COVID-19 case? ', 'checklist'),
(3, 'Have you had any contact with anyone with fever, cough, colds, and sore, throat in the past 2 weeks?', 'checklist'),
(4, 'Have you had travelled outside of the Philippines in the last 14 days?', 'checklist'),
(5, 'Have you travelled to any area in NCR aside from your home?', 'checklist'),
(6, 'Does the person have allergies to medication, food or any vaccine?', 'screening'),
(7, 'Has the person had a serious reaction to the vaccine in the past?', 'screening'),
(8, 'Does the person have long-term health problem with heart disease, lung disease, asthma, kidney disease, metabolic disease (e.g,diabetes), anemia. Or other blood disorder?', 'screening'),
(9, 'Does the person have cancer, leukemia, AIDS, or any other immune system problem?', 'screening'),
(10, 'Has the had a seizure, brain, or nerve problem?', 'screening'),
(11, 'During the past year, has the person received a transfusion of blood or blood products, or been given a medicine called immune(gamma) globulin?', 'screening'),
(12, 'Has the person Received any vaccinations in the past 4 weeks?', 'screening');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `vaccine` varchar(100) NOT NULL,
  `quantityy` int(100) NOT NULL,
  `date` date NOT NULL,
  `activity` varchar(100) NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`id`, `username`, `vaccine`, `quantityy`, `date`, `activity`, `time`) VALUES
(26, 'admin1', 'samplelang', 0, '2022-01-25', 'RECEIVED stacks for  samplelang ', '18:16:45'),
(27, 'christianjames', 'christianjames', 0, '2022-01-25', 'RECEIVED stacks for  christianjames ', '01:15:59'),
(28, 'christianjames', 'BCG', 0, '2022-01-25', 'RECEIVED stacks for  BCG ', '10:37:17'),
(29, 'christianjames', 'samplenew', 0, '2022-01-25', 'RECEIVED stacks for  samplenew ', '03:27:22'),
(30, 'christianjames', 'samplenew', 0, '2022-01-25', 'RECEIVED stacks for  samplenew ', '01:23:58'),
(31, 'christianjames', 'PCV', 0, '2022-01-25', 'RECEIVED stacks for  PCV ', '02:07:16'),
(32, 'christianjames', 'new%20vaccine', 0, '2022-01-25', 'RECEIVED stacks for  ', '02:10:04'),
(33, 'christianjames', 'TETANUS-DIPHTHERIA', 0, '2022-01-25', 'REQUEST STACK FOR TETANUS-DIPHTHERIA', '23:53:05'),
(34, 'christianjames', 'sample', 0, '2022-01-25', 'REQUEST STACK FOR sample', '23:54:37'),
(35, 'christianjames', 'HUMAN-PAPILLOMAVIRUS-VACCINE', 0, '2022-01-25', 'REQUEST STACK FOR HUMAN-PAPILLOMAVIRUS-VACCINE', '23:54:54'),
(36, 'christianjames', 'sample', 0, '2022-01-26', 'RECEIVED stacks for  sample ', '00:56:58'),
(37, 'christianjames', 'HUMAN-PAPILLOMAVIRUS-VACCINE', 0, '2022-01-26', 'RECEIVED stacks for  HUMAN-PAPILLOMAVIRUS-VACCINE ', '01:52:17'),
(38, 'christianjames', 'TETANUS-DIPHTHERIA', 0, '2022-01-26', 'RECEIVED stacks for  TETANUS-DIPHTHERIA ', '01:53:29'),
(39, 'christianjames', 'MMR-GRADE-7', 0, '2022-01-26', 'RECEIVED stacks for  MMR-GRADE-7 ', '02:52:14'),
(40, 'christianjames', 'IPV', 0, '2022-01-26', 'RECEIVED stacks for  IPV ', '08:08:52'),
(41, 'christianjames', 'sample', 0, '2022-01-26', 'RECEIVED stacks for  sample ', '10:03:10');

-- --------------------------------------------------------

--
-- Table structure for table `resident_list`
--

CREATE TABLE `resident_list` (
  `resident_id` int(11) NOT NULL,
  `firstname` text COLLATE utf8_unicode_ci NOT NULL,
  `lastname` text COLLATE utf8_unicode_ci NOT NULL,
  `brg_id_number` text COLLATE utf8_unicode_ci NOT NULL,
  `suffix` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `resident_list`
--

INSERT INTO `resident_list` (`resident_id`, `firstname`, `lastname`, `brg_id_number`, `suffix`) VALUES
(1, 'John', 'Dy', 'SALAWAG-42031', ''),
(2, 'Ralf', 'Tig', 'SALAWAG-00531', ''),
(3, 'Remmy', 'Jade', 'SALAWAG-01572', ''),
(4, 'Lilias', 'Ellum', 'SALAWAG-02351', ''),
(5, 'Larine', 'Brobeck', 'SALAWAG-07526', '');

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `id` int(100) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `capacity` int(100) NOT NULL,
  `nurse` varchar(100) NOT NULL,
  `place` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `schedules`
--

INSERT INTO `schedules` (`id`, `date`, `time`, `capacity`, `nurse`, `place`) VALUES
(54, '2022-01-15', '03:00:00', 77, 'Dr.Zawd', 'kadiwa'),
(56, '2022-01-18', '00:03:00', 24, 'Dr.Zwd', 'Saint Dominic'),
(60, '2022-02-14', '20:14:00', 9, 'sample', 'NCST'),
(66, '2022-01-19', '08:00:00', 10, 'Dra.Rapael', 'Brgy Health Center'),
(67, '2022-01-26', '08:00:00', 0, 'Dra.Rapael', 'Brgy Health Center'),
(68, '2022-02-02', '08:00:00', 0, 'Dra.Rapael', 'Brgy Health Center'),
(69, '2022-02-09', '08:00:00', 3, 'Dra.Rapael', 'Brgy Health Center'),
(70, '2022-02-16', '08:00:00', 5, 'Dra.Rapael', 'Brgy Health Center'),
(71, '2022-02-23', '08:00:00', 5, 'Dra.Rapael', 'Brgy Health Center'),
(72, '2022-03-21', '08:07:00', 0, 'Dra.Rapael', 'Brgy Health Center'),
(74, '2022-01-25', '08:25:00', 8, 'Dra.Rapael', 'Brgy Health Center'),
(75, '2022-02-25', '23:52:00', 10, 'Dra.Rapael', 'Brgy Health Center'),
(76, '2022-02-26', '10:01:00', 10, 'Dra.Rapael', 'Brgy Health Center');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `lastname` text COLLATE utf8_unicode_ci NOT NULL,
  `firstname` text COLLATE utf8_unicode_ci NOT NULL,
  `city` text COLLATE utf8_unicode_ci NOT NULL,
  `baranggay` text COLLATE utf8_unicode_ci NOT NULL,
  `email` text COLLATE utf8_unicode_ci NOT NULL,
  `password` text COLLATE utf8_unicode_ci NOT NULL,
  `phonenumber` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usersinfo`
--

CREATE TABLE `usersinfo` (
  `user_id` int(50) NOT NULL,
  `dateofbirth` date DEFAULT NULL,
  `placeofbirth` text NOT NULL,
  `mothersname` text NOT NULL,
  `fathersname` text NOT NULL,
  `birthheight` float NOT NULL DEFAULT 0,
  `birthweight` float NOT NULL DEFAULT 0,
  `sex` text NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `city` text NOT NULL,
  `baranggay` text NOT NULL,
  `email` text NOT NULL,
  `password` char(60) NOT NULL,
  `phone` text NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usersinfo`
--

INSERT INTO `usersinfo` (`user_id`, `dateofbirth`, `placeofbirth`, `mothersname`, `fathersname`, `birthheight`, `birthweight`, `sex`, `firstname`, `lastname`, `city`, `baranggay`, `email`, `password`, `phone`) VALUES
(24, '2005-01-11', 'pasay', 'mother', 'father', 169, 45, 'male', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test@email.com', '$2y$10$3SErMYNeJQnqzh5wI0JVwux.gUzuJm1yCwNQSfNXCM5Mq6MQKF0mi', '09912345678'),
(25, NULL, '', '', '', 0, 0, '', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test2@email.com', '$2y$10$3SErMYNeJQnqzh5wI0JVwux.gUzuJm1yCwNQSfNXCM5Mq6MQKF0mi', '09912345678'),
(26, NULL, '', '', '', 0, 0, '', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test3@email.com', '$2y$10$3SErMYNeJQnqzh5wI0JVwux.gUzuJm1yCwNQSfNXCM5Mq6MQKF0mi', '30991234563'),
(27, NULL, '', '', '', 0, 0, '', 'testfirstnamee', 'testlastnamee', 'Dasmariñas', 'Salawag', 'test123@email.com', '$2y$10$3SErMYNeJQnqzh5wI0JVwux.gUzuJm1yCwNQSfNXCM5Mq6MQKF0mi', '09912345678'),
(38, '2000-01-11', 'SM', 'MOM', 'DAD', 20, 10, 'MALE', 'Johnrich', 'Diegas', 'Dasmariñas', 'Salawag', 'diegasjohnrich014@gmail.com', '$2y$10$3SErMYNeJQnqzh5wI0JVwux.gUzuJm1yCwNQSfNXCM5Mq6MQKF0mi', '09123456780'),
(40, NULL, '', '', '', 0, 0, '', 'Test', 'TestF', 'Dasmariñas', 'Salawag', 'Testemail@gmail.com', '$2y$10$y1fHX4fPuD8rqQ1i5pf15ucVecv7TKXZ7n5G9qOXn1QhBvxJncvXu', '09122121211'),
(42, '2000-05-30', 'Eastern Samar', 'Jane Acuba', 'Philip Acuba', 20, 5, 'Female ', 'Jessa', 'Acuba', 'Dasmariñas City', 'Salawag', 'jessa3.acuba@gmail.com', '$2y$10$FM.lyYKhdUWl8E2GVFFYrOTvZ31Flc9RgrkBXuqrNQ2C5EvHrAbO2', '09648372261'),
(48, '2005-09-23', 'Cavite', 'M', 'F', 0, 0, 'Male', 'Christian', 'De Guzmab', 'Dasmariñas', 'Salawag', 'yahoo.deguzman@gmail.com', '$2y$10$ooOBYKHKLhLwfmj40hwNdOEm/VL6/SIQ3i5mO15Q9MFlWvwhIeuOW', '09319976496'),
(49, NULL, '', '', '', 0, 0, '', 'renz pogi', 'gwapo', 'dasma', 'salawag', 'fiedacan.renzcharles@ncst.edu.ph', '$2y$10$K4yMeBagRdvmbzon2RP7E.HPlJ1luwTp6ZYJT3w/qO/.goI1QBxS.', '09959417109'),
(50, '1999-12-15', 'UMC', 'Analisa', 'Mario', 0, 0, 'F', 'Angelica', 'Ambrad', 'dasma', 'salawag', 'ambrad432angelica@gmail.com', '$2y$10$ZSl2Cy11YCHxi/091yCwq.zWigY7I4/u5oQK19qv6j.o2FAVF2VUS', '09289745116'),
(51, '2000-04-04', 'Los Angeles ', 'HAJ', 'Ajajsj', 0, 0, 'Female ', 'Chyn', 'Angeles', 'Dasmariñas', 'Salawag', 'dallalala71@gmail.com', '$2y$10$2aTZfUqW1MU5aN1pNYlAbuUPJQjXj53Ryr0/Q2nnGELB.1r1RVMui', '09092553058'),
(52, NULL, '', '', '', 0, 0, '', 'Jene', 'Ac', 'Dasmariñas', 'Salawag', 'Jene@gmail.com', '$2y$10$wwXKxX2DtWLfI7qJdRF3ROubf9aqndME9eXqTS7ViihfoiLIYIcra', '09477423392'),
(53, '2000-01-20', 'pampanga', 'Jene', 'Franz', 0, 0, 'Male', 'Rhenz', 'Fiedacan', 'Dasmariñas', 'Salawag', 'renz@gmail.com', '$2y$10$WhyApKXdm4KBTtV2ndWu4.UgEjZGhpRYmyWszozzFR1PNv.vFAuXK', '09092553025'),
(54, '1966-01-17', 'Dasmariñas ', 'Annabelle', 'Rey', 0, 0, 'Female ', 'Kc', 'Casida', 'Dasmariñas', 'Salawag', 'kccassi@gmail.com', '$2y$10$YIAY6CSAjPfF/PyKxIU40eE6bDdufJQ5dehLDiGtEaexBBo7RnLZm', '09092553058'),
(55, '1953-01-20', 'Dasmariñas ', 'Lilian', 'Manuel', 0, 0, 'Female', 'Annabelle', 'Bayeta', 'Dasmariñas', 'Salawag', 'annabayeta@gmail.com', '$2y$10$cSx1pm/u2s7JhjxivWezSuQ.JbtnlTW9SJvKW5SZNxFuTPouUfOiG', '09092553058'),
(56, '1981-10-11', 'Dasmariñas ', 'Lilian', 'Manuel', 0, 0, 'Male', 'Edsel', 'Acuba', 'Dasmariñas', 'Salawag', 'Edsel@gmail.com', '$2y$10$cwC7n1TDx258PRZy.OoEQeiIgDOVBtVZYU.1EN1dGylvUkAY.7w.y', '09092553058'),
(57, '1962-01-13', 'Dasmariñas ', 'Lilian ', 'Manuel', 0, 0, 'Male', 'Roy', 'Acuba', 'Dasmariñas', 'Salawag', 'Roy@gmail.com', '$2y$10$6YDsgjpmxPYGJoPE/UH/YuMI0S2GRD2oMm5HtXXnaMVU062xyYs4q', '09092553058'),
(58, '1990-06-15', 'Dasmariñas ', 'Annabelle', 'Ariel', 0, 0, 'Female ', 'Arianne', 'Conche', 'Dasmariñas', 'Salawag', 'Arianne@gmail.com', '$2y$10$fbyKujqBQKBYCcOyRtfBjeGy0IOtR3CKyl/iOS72uhAr966Cip8rC', '09092553058'),
(59, '2000-01-20', 'Kahit saan', 'mmm', 'ffff', 0, 0, 'Male', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'email123@gmail.com', '$2y$10$puwZY9NaLsESjj80PZGL2uAzy1XXvh6CTRIT83xezc6NBnVtw90xO', '09912345678'),
(60, '1999-10-25', 'Kawit', 'M', 'J', 0, 0, 'Female', 'Jajanine', 'Jocson', 'Dasma', 'Salawag', 'janine.jocson@ncst.edu.ph', '$2y$10$/bn6iFwtopGxsB6TAvmetOLrFboBXcbEX/h.56qNvnaRBAVb1r2iW', '09351612340'),
(61, '1999-10-25', 'Kawit', 'M', 'J', 0, 0, 'Female', 'Jajanine', 'Jocson', 'Dasma', 'Salawag', 'jajajocsondelrosario@gmail.com', '$2y$10$/bn6iFwtopGxsB6TAvmetOLrFboBXcbEX/h.56qNvnaRBAVb1r2iW', '09351612340'),
(62, NULL, '', '', '', 0, 0, '', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test111@email.com', '$2y$10$GHetrwOarXc91TWbh9rW6uREIzFOtNejcSLHMgbQP5v9xv.D7M4.K', '09912345678'),
(63, NULL, '', '', '', 0, 0, '', 'HAHA', 'RERE', 'Dasmariñas', 'Salawag', 'test222@email.com', '$2y$10$GHetrwOarXc91TWbh9rW6uREIzFOtNejcSLHMgbQP5v9xv.D7M4.K', '09912345678'),
(64, NULL, '', '', '', 0, 0, '', 'HEHE', 'HIHI', 'Dasmariñas', 'Salawag', 'test333@email.com', '$2y$10$GHetrwOarXc91TWbh9rW6uREIzFOtNejcSLHMgbQP5v9xv.D7M4.K', '09912345678'),
(65, NULL, '', '', '', 0, 0, '', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test000@email.com', '$2y$10$GHetrwOarXc91TWbh9rW6uREIzFOtNejcSLHMgbQP5v9xv.D7M4.K', '09912345678'),
(66, NULL, '', '', '', 0, 0, '', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test121@email.com', 'Pass123@', '09912345678'),
(67, NULL, '', '', '', 0, 0, '', 'TEST', 'HAHA', 'Dasmariñas', 'Salawag', 'test0101@email.com', 'Pass123@', '09912345678'),
(68, '2000-01-21', 'SAMPLE', 'TESTM', 'TESTF', 30, 20, 'MALE', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test333@gmail.com', 'Pass123@', '09912345678'),
(69, '2022-03-21', 'Tae ng kalabaw', 'MOMOM', 'FAFAFA', 47.1, 13.1, 'Male', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test223@email.com', 'Pass123@', '09912345671'),
(70, '2003-01-21', 'parañaque', 'MOM', 'FAF', 20, 10, 'Male', 'Latrell', 'Conejo', 'Dasmariñas', 'Salawag', 'yuqis4467@gmail.com', 'Pass123@', '09912345678'),
(71, '2000-02-09', 'Manila', 'Manilyn Lapaz', 'Chandler Lapaz', 11, 8, 'Female ', 'Airish', 'Lapaz', 'Dasmariñas', 'Salawag', 'airishlapaz@gmail.com', 'Airish_2000@30', '09563358721'),
(74, '1999-06-10', 'Dasmariñas ', 'nelly ', 'efren', 10, 9, 'Male', 'Jaymark', 'Catacutan', 'Dasmariñas', 'Salawag', 'jay06.catacutan@gmail.com', 'Jaymark_2000@30', '09422635782'),
(76, '2000-01-15', 'Bacoor', 'Melle ', 'Joseph ', 8, 10, 'Male', 'Latrell', 'Conejp', 'Dasmariñas', 'Salawag', 'latrellconejo@gmail.com', 'Latrellcon_2000@30', '09365294255'),
(77, NULL, '', '', '', 0, 0, '', 'benton', 'Sor', 'Dasmariñas', 'Salawag', 'test@email.com', 'Pass123@', '09912345678'),
(78, NULL, '', '', '', 0, 0, '', 'Geri', 'Janjic', 'Dasmariñas', 'Salawag', 'test0909@email.com', 'Pass123@', '09912345678'),
(79, '2000-01-26', 'Cebu', 'Testm', 'Testf', 0, 0, 'Male', 'Benton', 'Sor', 'Dasmariñas', 'Salawag', 'accdummy0123@gmail.com', 'Pass123@', '09123546811'),
(80, NULL, '', '', '', 0, 0, '', 'Larine', 'Brobeck', 'Dasmariñas', 'Salawag', 'test333@email.com', '$2y$10$0rnYFhHeDL8miYvT6CAQxe29QkK7zGEIoHkFKQhyMDWz0ZGmzPoOa', '09912345678'),
(81, NULL, '', '', '', 0, 0, '', 'Lilias', 'Ellum', 'Dasmariñas', 'Salawag', 'test@email.com', '$2y$10$6Cw1SisGjuU8IxCSa2vNouSdHzYQCDntfzonkJHXtE/TrrwvFRMRC', '09912345678');

-- --------------------------------------------------------

--
-- Table structure for table `vaccines`
--

CREATE TABLE `vaccines` (
  `id` int(25) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `quantity` int(25) NOT NULL,
  `dose` int(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vaccines`
--

INSERT INTO `vaccines` (`id`, `name`, `description`, `quantity`, `dose`, `date`) VALUES
(48, 'BCG', 'Bacillus Calmette–Guérin vaccine is a vaccine primarily used against tuberculosis. It is named after its inventors Albert Calmette and Camille Guérin. In countries where tuberculosis or leprosy is common, one dose is recommended in healthy babies as soon after birth as possible.', 22, 1, NULL),
(51, 'HEPATITIS B', 'Hepatitis B is a vaccine-preventable liver infection caused by the hepatitis B virus (HBV). Hepatitis B is spread when blood, semen, or other body fluids from a person infected with the virus enters the body of someone who is not infected.', 30, 1, NULL),
(52, 'PENTAVALENT VACCINE', 'Pentavalent Vaccine is a vaccine that contains five antigens (diphtheria, pertussis, tetanus, and hepatitis B and Haemophilus influenzae type b).', 30, 3, NULL),
(53, 'OPV', 'Oral poliovirus vaccines (OPV) are the predominant vaccine used in the fight to eradicate polio. ', 10, 3, NULL),
(55, 'IPV', 'Polio vaccines are vaccines used to prevent poliomyelitis. Two types are used: an inactivated poliovirus given by injection and a weakened poliovirus given by mouth. ', 10, 1, NULL),
(56, 'PCV', 'Pneumococcal conjugate vaccine is a pneumococcal vaccine and a conjugate vaccine used to protect infants, young children, and adults against disease caused by the bacterium Streptococcus pneumoniae.', 10, 3, NULL),
(58, 'TETANUS DIPHTHERIA', 'Tetanus vaccine, also known as tetanus toxoid, is a toxoid vaccine used to prevent tetanus. ', 30, 2, NULL),
(70, 'MMR', 'The MMR vaccine is a vaccine against measles, mumps, and rubella. ', 20, 1, '2021-12-21'),
(71, 'HUMAN PAPILLOMAVIRUS VACCINE', 'Human papillomavirus vaccines are vaccines that prevent infection by certain types of human papillomavirus. ', 41, 2, '2021-12-21');

-- --------------------------------------------------------

--
-- Table structure for table `vaccinessupp`
--

CREATE TABLE `vaccinessupp` (
  `id` int(25) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `quantity` int(25) NOT NULL,
  `dose` int(100) NOT NULL,
  `atccode` varchar(100) NOT NULL,
  `target` varchar(1000) NOT NULL,
  `storage` varchar(1000) NOT NULL,
  `mimsclass` varchar(1000) NOT NULL,
  `atcclassification` varchar(1000) NOT NULL,
  `precautions` varchar(1000) NOT NULL,
  `adversereaction` varchar(1000) NOT NULL,
  `druginteractions` varchar(1000) NOT NULL,
  `contraindications` varchar(1000) NOT NULL,
  `date` date DEFAULT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `expdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vaccinessupp`
--

INSERT INTO `vaccinessupp` (`id`, `name`, `description`, `quantity`, `dose`, `atccode`, `target`, `storage`, `mimsclass`, `atcclassification`, `precautions`, `adversereaction`, `druginteractions`, `contraindications`, `date`, `manufacturer`, `expdate`) VALUES
(73, 'BCG', 'Bacillus Calmette–Guérin vaccine is a vaccine primarily used against tuberculosis. It is named after its inventors Albert Calmette and Camille Guérin. In countries where tuberculosis or leprosy is common, one dose is recommended in healthy babies as soon after birth as possible.', 970, 10, 'J07AN01 (WHO) L03AX03 (WHO)', 'Mycobacterium tuberculosis', 'Store at 2-8°C.', 'Vaccines, Antisera & Immunologicals', 'L03AX03 - BCG vaccine ; Belongs to the class of other immunostimulants.', 'Patient with small bladder capacity (intravesical). Pregnancy and lactation.', 'Significant: Risk of bladder contracture (intravesical), malaise, fever and chills, flu-like symptoms.', 'Diminished therapeutic effect with immune globulins.\r\nPotentially Fatal: Diminished therapeutic effect with immunosuppressants, bone marrow depressants, antibiotics, radiation therapy.\r\n', 'Hypersensitivity. Impaired immune response, congenital or acquired immune deficiencies (e.g. HIV-infection, leukaemia, lymphoma, cancer therapy, Hodgkin’s disease), active tuberculosis, acute severe febrile illness, generalised infected skin conditions, current or previous evidence of BCG infection, urinary tract infection, gross haematuria, <14 days of biopsy, TUR, or traumatic catheterisation. Concomitant therapy with immunosuppressive agents, bone marrow depressants, antibiotics, radiation therapy.', '2022-01-16', 'Merck, PH', '0000-00-00'),
(74, 'HAPATITIS-B', 'Hepatitis B vaccine is a vaccine that prevents hepatitis B. The first dose is recommended within 24 hours of birth with either two or three more doses given after that. This includes those with poor immune function such as from HIV/AIDS and those born premature.', 1000, 3, 'J07BC01 (WHO)', 'Hepatitis B virus', 'Store between 2-8°C. Do not freeze. Protect from light.', 'Vaccines, Antisera & Immunologicals', 'J07BC01 - hepatitis B, purified antigen ; Belongs to the class of hepatitis viral vaccines.', '', 'Significant: Anaphylactoid reactions, syncope, bleeding/haematoma.\r\nCardiac disorders: Tachycardia.\r\n', 'Diminished therapeutic effect with immunosuppressants. Risk of bleeding with anticoagulants.', '', '2022-01-16', 'Merck, USA', '0000-00-00'),
(75, 'PENTAVALENT-VACCINE', 'A pentavalent vaccine, also known as a 5-in-1 vaccine, is a combination vaccine with five individual vaccines conjugated into one.', 1000, 3, 'Quintavax: J07CA11 (WHO)', 'diphtheria, tetanus, whooping cough, hepatitis B and Haemophilus influenzae type B', 'Store between 2-8°C. Do not freeze. Protect from light.', '', '', '', '', '', '', '2022-01-16', 'Merck, PH', '0000-00-00'),
(76, 'OPV', 'ORAL POLIO VACCINE are vaccines used to prevent poliomyelitis. Two types are used: an inactivated poliovirus given by injection and a weakened poliovirus given by mouth. The World Health Organization recommends all children be fully vaccinated against polio.', 1000, 3, 'J07BF04', 'Polio virus', 'Store at -20°C. It can be stored up to 6 months at temperature between +2°C and +8°C. Protect from light.', '', '', '', '', '', '', '2022-01-16', 'Merck, USA', '0000-00-00'),
(77, 'IPV', 'INACTIVATED POLIO VACCINE is Injectable Polio Vaccine that targets the three types of polio virus: 1,2 & 3 and it is administered by an injection on the right upper thigh of the child.', 970, 1, 'J07BF03', 'Polio virus', 'Store between 2-8°C. Protect from light. Do not freeze.\r\nAny unused portions should be disposed of in accordance with local requirements.\r\n', '', '', '', '', '', '', '2022-01-16', 'Merck, USA', '0000-00-00'),
(78, 'PCV', 'PNEUMOCOCCAL CONJUGATE VACCINE is a pneumococcal vaccine and a conjugate vaccine used to protect infants, young children, and adults against disease caused by the bacterium Streptococcus pneumoniae.', 970, 3, 'J07AL02 (WHO)', 'Streptococcus pneumoniae', 'Store between 2-8°C. Do not freeze. Protect from light. Any unused portions should be disposed of in accordance with local requirements.', '', '', '', '', '', '', '2022-01-16', 'Merck, USA', '0000-00-00'),
(79, 'MMR-GRADE-1', 'MEASLES MUMPS RUBELLA vaccine is a vaccine against measles, mumps, and rubella. This is for Grade 1', 1000, 1, 'J07BD52', 'measles, mumps, and rubella viruses.', 'Store between 2-8°C. Protect from light. Do not freeze.', '', '', '', '', '', '', '2022-01-16', 'Merck, USA', '0000-00-00'),
(80, 'MMR-GRADE-7', 'MEASLES MUMPS RUBELLA vaccine is a vaccine against measles, mumps, and rubella. This is for Grade 7', 970, 2, 'J07BD52 ', 'measles, mumps, and rubella viruses.', 'between -50°C and +8°C (-58°F to +46°F). Use of dry ice may subject MEASLES, MUMPS, AND RUBELLA VIRUS VACCINE LIVE (M-M-R II) to temperatures colder than -50°C (-58°F). Protect the vaccine from light at all times, since such exposure may inactivate the viruses.', '', '', '', '', '', '', '2022-01-16', 'Merck, USA', '0000-00-00'),
(81, 'TETANUS-DIPHTHERIA', 'The DPT vaccine or DTP vaccine is a class of combination vaccines against three infectious diseases in humans: diphtheria, pertussis, and tetanus. The vaccine components include diphtheria and tetanus toxoids and either killed whole cells of the bacterium that causes pertussis or pertussis antigens.', 1000, 2, 'J07AM51', 'protect against the diseases caused by exposure to C. diphtheriae and C. tetani.', 'Store between 2-8°C. Do not freeze. Protect from light.', '', '', '', '', '', '', '2022-01-16', 'Merck, USA', '2022-02-25'),
(82, 'HUMAN-PAPILLOMAVIRUS-VACCINE', 'Human papillomavirus vaccines are vaccines that prevent infection by certain types of human papillomavirus. Available HPV vaccines protect against either two, four, or nine types of HPV.', 1000, 2, 'J07BM01 (WHO) J07BM02 (WHO) J07BM03 (WHO)', 'Human papillomavirus (HPV)', 'Store between 2-8°C. Protect from light. Do not freeze.', '', '', '', '', '', '', '2022-01-16', 'Merck, PH', '2022-01-29'),
(89, 'sample1', 'sample', 970, 1, '1', 'sample', 'sample', '', '', '', '', '', '', '2022-01-25', 'Merck, PH', '2022-03-26');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addlogs`
--
ALTER TABLE `addlogs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `adminaccount`
--
ALTER TABLE `adminaccount`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `adminlogs`
--
ALTER TABLE `adminlogs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`appo_id`);

--
-- Indexes for table `archive`
--
ALTER TABLE `archive`
  ADD PRIMARY KEY (`arc_id`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `counting`
--
ALTER TABLE `counting`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feed_id`);

--
-- Indexes for table `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`his_id`);

--
-- Indexes for table `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `resident_list`
--
ALTER TABLE `resident_list`
  ADD PRIMARY KEY (`resident_id`),
  ADD UNIQUE KEY `brg_id_number` (`brg_id_number`) USING HASH;

--
-- Indexes for table `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`) USING HASH;

--
-- Indexes for table `usersinfo`
--
ALTER TABLE `usersinfo`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `vaccines`
--
ALTER TABLE `vaccines`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminaccount`
--
ALTER TABLE `adminaccount`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `appo_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `counting`
--
ALTER TABLE `counting`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `feedbacks`
--
ALTER TABLE `feedbacks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `his_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `schedules`
--
ALTER TABLE `schedules`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usersinfo`
--
ALTER TABLE `usersinfo`
  MODIFY `user_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT for table `vaccines`
--
ALTER TABLE `vaccines`
  MODIFY `id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

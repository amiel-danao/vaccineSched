-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 09, 2022 at 09:12 AM
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
(44, 'testlastname', 'testfirstname', '09912345678', '2021-12-25', '03:00:00', 'HUMAN PAPILLOMAVIRUS VACCINE', 'WAITING', 24, 'Dr.Zawd', 'kadiwa', 'test@email.com', 1);

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
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id` int(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `phonenumber` int(100) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `vaccine` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(100) NOT NULL,
  `question` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(54, '2022-01-15', '03:00:00', 80, 'Dr.Zawd', 'kadiwa'),
(56, '2022-01-18', '00:03:00', 25, 'Dr.Zwd', 'Saint Dominic'),
(60, '2022-02-14', '20:14:00', 10, 'sample', 'NCST');

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
  `password` text NOT NULL,
  `phone` text NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usersinfo`
--

INSERT INTO `usersinfo` (`user_id`, `dateofbirth`, `placeofbirth`, `mothersname`, `fathersname`, `birthheight`, `birthweight`, `sex`, `firstname`, `lastname`, `city`, `baranggay`, `email`, `password`, `phone`) VALUES
(24, '2004-01-09', 'pasay', 'mother', 'father', 169, 45, 'male', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test@email.com', 'Password123$', '09912345678'),
(25, NULL, '', '', '', 0, 0, '', 'testfirstname', 'testlastname', 'Dasmariñas', 'Salawag', 'test2@email.com', 'Password123$', '09912345678');

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminaccount`
--
ALTER TABLE `adminaccount`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`appo_id`);

--
-- Indexes for table `counting`
--
ALTER TABLE `counting`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

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
  MODIFY `appo_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `counting`
--
ALTER TABLE `counting`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `schedules`
--
ALTER TABLE `schedules`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usersinfo`
--
ALTER TABLE `usersinfo`
  MODIFY `user_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `vaccines`
--
ALTER TABLE `vaccines`
  MODIFY `id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

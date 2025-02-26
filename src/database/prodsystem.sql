-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 26, 2025 at 03:14 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prodsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `u_id` int(10) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_contact` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_password` varchar(50) NOT NULL,
  `u_stat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_username`, `u_fname`, `u_lname`, `u_email`, `u_contact`, `u_type`, `u_password`, `u_stat`) VALUES
(1, 'joseph', 'Joseph Anthony', 'Arambala', 'joseph@gmail.com', '09878654678', 'Customer', 'josephjoseph', 'Active'),
(2, 'heart', 'Heart Immaculate', 'Imalay', 'imalay@gmail.com', '09786556743', 'Customer', 'markjoseph', 'Pending'),
(3, 'Lloyddyy', 'Lloyd', 'Arambala', 'aram@gmail.com', '09786578654', 'Customer', 'loyydddd', 'Pending'),
(4, 'josephhh', 'Joseph', 'Arambala', 'anthony@gmail.com', '097864567445', 'Customer', 'josephjoseph', 'Pending'),
(5, 'adminjoseph', 'Anhony Joseph', 'Arambala', 'jose@gmail.com', '09336672311', 'Admin', 'josephggg', 'Active'),
(6, 'nile0998', 'Nile Christopher', 'Bradi', 'brad@gmail.com', '09889765432', 'Admin', 'bad098777', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

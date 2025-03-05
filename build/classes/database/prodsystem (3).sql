-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2025 at 05:24 AM
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
-- Table structure for table `process`
--

CREATE TABLE `process` (
  `s_id` int(20) NOT NULL,
  `u_id` int(50) NOT NULL,
  `p_id` int(50) NOT NULL,
  `s_quantity` int(50) NOT NULL,
  `s_totalam` decimal(10,0) NOT NULL,
  `s_cash` decimal(10,0) NOT NULL,
  `s_change` decimal(10,0) NOT NULL,
  `s_status` varchar(150) NOT NULL,
  `s_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `p_id` int(10) NOT NULL,
  `p_name` varchar(20) NOT NULL,
  `p_price` decimal(10,0) NOT NULL,
  `p_stock` int(200) NOT NULL,
  `p_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `u_id` int(20) NOT NULL,
  `u_username` varchar(150) NOT NULL,
  `u_fname` varchar(150) NOT NULL,
  `u_lname` varchar(150) NOT NULL,
  `u_email` varchar(150) NOT NULL,
  `u_contact` varchar(150) NOT NULL,
  `u_type` varchar(150) NOT NULL,
  `u_password` varchar(150) NOT NULL,
  `u_stat` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_username`, `u_fname`, `u_lname`, `u_email`, `u_contact`, `u_type`, `u_password`, `u_stat`) VALUES
(1, 'joseph', 'Joseph Anthony', 'Arambala', 'josephanthony@gmail.com', '09786546785', 'Admin', 'josephanthony', 'Active'),
(2, 'lloydt', 'Lloydyyy', 'Anthony', 'll@gmail.com', '09888765433', 'Customer', 'passpass', 'Active'),
(3, 'larrylar', 'Larry Zak', 'Macheldon', 'yaay@yahoo.com', '09876856431', 'Employee', 'larry12345', 'Active'),
(5, 'heartt', 'Immaa', 'Imalay', 'imai@gmail.com', '252643636363', 'Employee', 'heartgiven', 'Pending'),
(6, 'robottt', 'Peter', 'Grifin', 'pet@gmail.com', '77777777777777', 'Employee', 'pppetppet', 'Pending'),
(7, 'riri', 'Rim', 'Adlawan', 'adlaw@gmail.com', '129359328592385', 'Customer', 'ggg123456', 'Pending'),
(8, 'adminadded', 'Mark', 'Grayson', 'grayson@gmail.com', '09564332121', 'Customer', 'graysongray', 'Pending'),
(9, 'noel', 'Nolan', 'Grayson', 'noel@gmail.com', '09887564231', 'Customer', 'invincible', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `process`
--
ALTER TABLE `process`
  ADD PRIMARY KEY (`s_id`),
  ADD KEY `uid` (`u_id`),
  ADD KEY `pid` (`p_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `process`
--
ALTER TABLE `process`
  MODIFY `s_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `process`
--
ALTER TABLE `process`
  ADD CONSTRAINT `pid` FOREIGN KEY (`p_id`) REFERENCES `product` (`p_id`),
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

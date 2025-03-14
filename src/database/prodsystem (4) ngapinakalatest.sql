-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2025 at 01:35 PM
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
  `p_category` varchar(20) NOT NULL,
  `p_brand` varchar(50) NOT NULL,
  `p_price` decimal(10,0) NOT NULL,
  `p_stock` int(200) NOT NULL,
  `p_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`p_id`, `p_name`, `p_category`, `p_brand`, `p_price`, `p_stock`, `p_status`) VALUES
(2, 'Noodles', 'Food and Bevarage', 'Lucky Me', 25, 22, 'Available'),
(3, 'Piattos', 'Food and Bevarage', 'Oishi', 15, 0, 'Not Available'),
(4, 'Kitchen Knife', 'Household Essentials', 'TrustTolly', 100, 50, 'Available'),
(6, 'Noodles', 'Food and Bevarage', 'Lucky me', 20, 50, 'Available'),
(8, 'Shoes', 'Food and Bevarage', 'Nike', 50, 25, 'Available'),
(9, 'Shoes', 'Personal Wellness', 'Nike', 500, 11, 'Available'),
(10, 'Wrench', 'Suppliess Utilities', 'Mr Tool', 40, 20, 'Available');

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
(13, 'zenn', 'Zennia ', 'Requillo', 'zen@gmail.com', '09887865453', 'Customer', 'zennia12345678', 'Active'),
(14, 'sep', 'Seph', 'Anthony', 'anthony@gmail.com', '09668872311', 'Employee', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(15, 'ant', 'Anthony', 'Arambala', 'arambala@gmail.com', '0966886464605', 'Admin', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(16, 'testesss', 'Testing', 'This is Just a test', 'testing@gmail.com', '99999878987', 'Customer', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(17, 'mikey', 'Mike', 'Bustamante', 'mikeee@gmail.com', '09875432121', 'Customer', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(20, 'jeppp', 'Jeepne', 'Josephine', 'jeep@gmail.com', '09887656785', 'Admin', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(21, 'Riri', 'Ridona', 'Adlawan', 'riririi@gmail.com', '09778654232', 'Employee', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(22, 'santino', 'Santino Jamal', 'Murry', 'santt@gmail.com', '09887654531', 'Admin', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(23, 'Antonio', 'Antonio Lezel', 'Arambala', 'anto@gmail.com', '09786567453', 'Admin', 'xC2czW7d4hc8ZKV0fvVWImy3U1ceP1OAauArN2x5CF4=', 'Active'),
(24, 'petpet', 'John Peter', 'delacalzada', 'dela@gmail.com', '09887678654', 'Customer', 'GKR1RAsMs4HFx2/mMPckMwDwZiymS3CFoUbYnBS3Mf4=', 'Active'),
(25, 'caloy', 'Jeven Carl', 'Emnace', 'emnace@gmail.com', '09878654321', 'Admin', 'CUcPSc0Iaz2hqGmH/My+gz+lDz8nmUEF4Iz2ndQyWpo=', 'Pending');

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
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

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

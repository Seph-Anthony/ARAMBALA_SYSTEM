-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 25, 2025 at 02:54 PM
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
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(20) NOT NULL,
  `user_id` int(20) NOT NULL,
  `act` varchar(50) NOT NULL,
  `log_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `user_id`, `act`, `log_date`) VALUES
(1, 27, 'User logged in: loydloydloyd', '2025-03-24'),
(3, 29, 'User Registered: tylerthedestroyer', '2025-03-24'),
(4, 27, 'User logged in: loydloydloyd', '2025-03-24'),
(5, 27, 'User logged in: loydloydloyd', '2025-03-24'),
(7, 27, 'User logged in: loydloydloyd', '2025-03-24'),
(8, 27, 'Product Added: Spring Water Mineral', '2025-03-24'),
(9, 27, 'User logged in: loydloydloyd', '2025-03-24'),
(10, 27, 'User logged in: loydloydloyd', '2025-03-24'),
(11, 27, 'User Added: markyyy', '2025-03-24'),
(12, 27, 'User logged in: loydloydloyd', '2025-03-24'),
(13, 27, 'User logged in: loydloydloyd', '2025-03-24'),
(14, 27, 'User Updated: zenniaaa', '2025-03-24'),
(15, 29, 'User logged in: tylerthedestroyer', '2025-03-24'),
(16, 29, 'User logged in: tylerthedestroyer', '2025-03-24'),
(17, 29, 'User Updated: tylerthedestroyer', '2025-03-24'),
(18, 27, 'User logged in: loydloydloyd', '2025-03-25'),
(19, 27, 'User Updated: loydloydloyd', '2025-03-25'),
(20, 27, 'User logged in: loydloydloyd', '2025-03-25'),
(21, 27, 'User logged in: loydloydloyd', '2025-03-25'),
(22, 27, 'User logged in: loydloydloyd', '2025-03-25'),
(23, 27, 'User Updated: loydloydloyd', '2025-03-25'),
(24, 27, 'User logged in: loydloydloyd', '2025-03-25'),
(25, 27, 'Product Updated: Spicy Noodles', '2025-03-25');

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
(10, 'Wrench', 'Suppliess Utilities', 'Mr Tool', 40, 20, 'Available'),
(11, 'Water Bottle', 'Food Bevarage', 'Minerale', 15, 28, 'Available'),
(12, 'Spring Water Mineral', 'Food Bevarage', 'Lemineralee', 15, 66, 'Available');

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
(13, 'zenniaaa', 'Zennia ', 'Requillo', 'zenn@gmail.com', '09887865453', 'Customer', 'zennia12345678', 'Active'),
(14, 'sep', 'Seph', 'Anthony', 'anthony@gmail.com', '09668872311', 'Employee', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(15, 'ant', 'Anthony', 'Arambala', 'arambala@gmail.com', '0966886464605', 'Admin', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(16, 'testesss', 'Testing', 'This is Just a test', 'testing@gmail.com', '99999878987', 'Customer', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(17, 'mikey', 'Mike', 'Bustamante', 'mikeee@gmail.com', '09875432121', 'Customer', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(20, 'jeppp', 'Jeepne', 'Josephine', 'jeep@gmail.com', '09887656785', 'Admin', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(21, 'Riri', 'Ridona', 'Adlawan', 'riririi@gmail.com', '09778654232', 'Employee', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(22, 'santino', 'Santino Jamal', 'Murry', 'santt@gmail.com', '09887654531', 'Admin', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active'),
(23, 'Antonio', 'Antonio Lezel', 'Arambala', 'anto@gmail.com', '09786567453', 'Admin', 'xC2czW7d4hc8ZKV0fvVWImy3U1ceP1OAauArN2x5CF4=', 'Active'),
(24, 'petpet', 'John Peter', 'delacalzada', 'dela@gmail.com', '09887678654', 'Customer', 'GKR1RAsMs4HFx2/mMPckMwDwZiymS3CFoUbYnBS3Mf4=', 'Active'),
(25, 'caloy', 'Jeven Carl', 'Emnace', 'emnace@gmail.com', '09878654321', 'Admin', 'CUcPSc0Iaz2hqGmH/My+gz+lDz8nmUEF4Iz2ndQyWpo=', 'Pending'),
(26, 'sephsephseph', 'Seri', 'Testingrani', 'chanchan@gmail.com', '09897656768', 'Employee', 'mosjbHV6WdXhLIJklFO3VKGj0meXsUaV5AK2YXFb8TM=', 'Active'),
(27, 'loydloydloyd', 'Loyddyy', 'Arambels', 'belsss@gmail.com', '09879667854', 'Admin', '17FNiCXG3TsYN9RkcJjjc8Tdn4YmFbqKeadxSU4fzfA=', 'Active'),
(28, 'creation12345', 'Cretee', 'Balbon', 'balss@gmail.com', '09897656784', 'Customer', '7k7x34cg3dDL+WVQHvYre6Z+joIrM68YtG7AO+nhnss=', 'Pending'),
(29, 'tylerthedestroyer', 'Tyler', 'Zamora', 'zammm@gmail.com', '09898767543', 'Admin', 'hahahaha', 'Active'),
(30, 'markyyy', 'Mark J', 'Cortes', 'cort@gmail.com', '09786787656', 'Customer', 'bWjlNFKl9XicFi5OH6BhvsvnYbI8ouy/OufE/Rrdyv0=', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `userid` (`user_id`);

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
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `process`
--
ALTER TABLE `process`
  MODIFY `s_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`u_id`);

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

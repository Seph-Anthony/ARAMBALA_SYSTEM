-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2025 at 05:16 PM
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
(25, 27, 'Product Updated: Spicy Noodles', '2025-03-25'),
(26, 30, 'User logged in: markyyy', '2025-03-26'),
(27, 30, 'User logged in: markyyy', '2025-03-26'),
(28, 30, 'User logged in: markyyy', '2025-03-26'),
(29, 30, 'User logged in: markyyy', '2025-03-26'),
(30, 30, 'User logged in: markyyy', '2025-03-26'),
(31, 30, 'User logged in: markyyy', '2025-03-29'),
(32, 30, 'User logged in: markyyy', '2025-03-30'),
(33, 30, 'User logged in: markyyy', '2025-03-30'),
(34, 30, 'User logged in: markyyy', '2025-03-30'),
(35, 30, 'User logged in: markyyy', '2025-03-30'),
(36, 30, 'User logged in: markyyy', '2025-03-30'),
(37, 30, 'User logged in: markyyy', '2025-03-30'),
(38, 30, 'User logged in: markyyy', '2025-03-30'),
(41, 32, 'User logged in: dinaaa', '2025-03-30'),
(42, 32, 'User Added: sensen', '2025-03-30'),
(43, 30, 'User logged in: markyyy', '2025-03-30'),
(45, 30, 'User logged in: markyyy', '2025-03-31'),
(46, 30, 'User logged in: markyyy', '2025-03-31'),
(47, 30, 'User logged in: markyyy', '2025-03-31'),
(48, 33, 'User logged in: sensen', '2025-03-31'),
(49, 30, 'User logged in: markyyy', '2025-03-31'),
(50, 30, 'User Updated: markyyy', '2025-03-31'),
(51, 30, 'User logged in: markyyy', '2025-03-31'),
(52, 30, 'User Updated: markyyy', '2025-03-31'),
(53, 30, 'User logged in: markyyy', '2025-03-31'),
(54, 30, 'User logged in: markyyy', '2025-03-31'),
(55, 30, 'User logged in: markyyy', '2025-03-31'),
(56, 30, 'User Updated: markyyy', '2025-03-31'),
(57, 30, 'User logged in: markyyy', '2025-03-31'),
(58, 30, 'User logged in: markyyy', '2025-03-31'),
(59, 30, 'User Updated: markyyy', '2025-03-31'),
(60, 30, 'User logged in: markyyy', '2025-03-31'),
(61, 30, 'User logged in: markyyy', '2025-03-31'),
(62, 34, 'User logged in: table', '2025-03-31'),
(63, 30, 'User logged in: markyyy', '2025-03-31'),
(64, 30, 'User logged in: markyyy', '2025-03-31'),
(65, 30, 'User Added: larlarlarlar', '2025-03-31'),
(66, 35, 'User logged in: larlarlarlar', '2025-03-31'),
(67, 30, 'User logged in: markyyy', '2025-03-31'),
(68, 30, 'User logged in: markyyy', '2025-03-31'),
(69, 30, 'User Updated: larlarlarlar', '2025-03-31'),
(70, 35, 'User logged in: larlarlarlar', '2025-03-31'),
(71, 30, 'User logged in: markyyy', '2025-03-31'),
(72, 30, 'User Updated: sensen', '2025-03-31'),
(73, 33, 'User logged in: sensen', '2025-03-31'),
(74, 30, 'User logged in: markyyy', '2025-03-31'),
(75, 30, 'User Updated: larlarlarlar', '2025-03-31'),
(76, 30, 'User logged in: markyyy', '2025-03-31'),
(77, 30, 'User logged in: markyyy', '2025-03-31'),
(78, 30, 'User logged in: markyyy', '2025-03-31'),
(79, 30, 'User Updated: sensen', '2025-03-31'),
(80, 30, 'User logged in: markyyy', '2025-03-31'),
(81, 30, 'Product Added: Sip Water Bottle', '2025-03-31'),
(82, 30, 'User logged in: markyyy', '2025-03-31'),
(83, 30, 'User logged in: markyyy', '2025-03-31'),
(84, 30, 'Product Updated: Sip Water Bottle', '2025-03-31'),
(85, 30, 'Product Updated: Sip Water Bottle', '2025-03-31'),
(86, 30, 'User logged in: markyyy', '2025-03-31'),
(87, 30, 'Product Updated: Sip Water Bottle', '2025-03-31'),
(88, 30, 'User logged in: markyyy', '2025-03-31'),
(89, 30, 'Product Updated: Sip Water Bottles', '2025-03-31'),
(90, 30, 'User logged in: markyyy', '2025-03-31'),
(91, 30, 'User logged in: markyyy', '2025-03-31'),
(92, 30, 'User logged in: markyyy', '2025-03-31'),
(93, 30, 'User logged in: markyyy', '2025-03-31'),
(94, 30, 'User Updated: larlarlarlar', '2025-03-31'),
(95, 30, 'User logged in: markyyy', '2025-03-31'),
(96, 30, 'User Updated: larlarlarlar', '2025-03-31'),
(97, 30, 'User logged in: markyyy', '2025-03-31'),
(98, 30, 'User logged in: markyyy', '2025-03-31'),
(99, 30, 'User logged in: markyyy', '2025-03-31'),
(100, 30, 'User Updated: markyyy', '2025-03-31'),
(101, 30, 'User logged in: markyyy', '2025-03-31'),
(102, 30, 'User logged in: markyyy', '2025-03-31'),
(103, 30, 'User logged in: markyyy', '2025-03-31'),
(104, 30, 'User logged in: markyyy', '2025-03-31'),
(105, 30, 'User logged in: markyyy', '2025-03-31'),
(106, 30, 'User logged in: markyyy', '2025-03-31'),
(107, 30, 'User logged in: markyyy', '2025-03-31'),
(108, 30, 'User logged in: markyyy', '2025-03-31'),
(109, 30, 'User logged in: markyyy', '2025-03-31'),
(110, 30, 'User logged in: markyyy', '2025-03-31'),
(111, 30, 'User logged in: markyyy', '2025-03-31'),
(112, 30, 'User logged in: markyyy', '2025-03-31'),
(113, 30, 'User logged in: markyyy', '2025-03-31'),
(114, 30, 'User logged in: markyyy', '2025-03-31'),
(115, 35, 'User logged in: larlarlarlar', '2025-03-31'),
(116, 35, 'User logged in: larlarlarlar', '2025-03-31'),
(117, 35, 'User logged in: larlarlarlar', '2025-03-31'),
(118, 35, 'User logged in: larlarlarlar ', '2025-03-31'),
(119, 30, 'User logged in: markyyy', '2025-03-31'),
(120, 30, 'User logged in: markyyy', '2025-03-31'),
(121, 30, 'User logged in: markyyy', '2025-03-31'),
(122, 30, 'User logged in: markyyy', '2025-03-31'),
(123, 30, 'User logged in: markyyy', '2025-03-31'),
(124, 30, 'User logged in: markyyy', '2025-03-31'),
(125, 30, 'User logged in: markyyy', '2025-03-31'),
(126, 30, 'User logged in: markyyy', '2025-03-31'),
(127, 30, 'User logged in: markyyy', '2025-03-31'),
(128, 30, 'Updated Information: Updated profile', '2025-03-31'),
(129, 30, 'User logged in: markyyy', '2025-03-31'),
(130, 30, 'User logged in: markyyy', '2025-03-31'),
(131, 30, 'User logged in: markyyy', '2025-03-31'),
(132, 30, 'User logged in: markyyy', '2025-03-31'),
(133, 35, 'User logged in: larlarlarlar', '2025-03-31'),
(134, 33, 'User logged in: sensen', '2025-03-31'),
(135, 30, 'User logged in: markyyy', '2025-03-31'),
(136, 34, 'User logged in: table', '2025-03-31'),
(137, 33, 'User logged in: sensen', '2025-03-31'),
(138, 33, 'User logged in: sensen', '2025-03-31'),
(139, 33, 'User logged in: sensen', '2025-03-31'),
(140, 33, 'User Updated: sensen', '2025-03-31'),
(141, 33, 'User logged in: sensen', '2025-03-31'),
(142, 33, 'User logged in: sensen', '2025-03-31'),
(143, 33, 'User logged in: sensen', '2025-03-31'),
(144, 33, 'User logged in: sensen', '2025-03-31'),
(145, 33, 'User logged in: sensen', '2025-03-31'),
(146, 33, 'User logged in: sensen', '2025-03-31'),
(147, 33, 'User logged in: sensen', '2025-03-31'),
(148, 33, 'User logged in: sensen', '2025-03-31'),
(149, 33, 'User logged in: sensen', '2025-03-31'),
(150, 33, 'User logged in: sensen', '2025-03-31'),
(151, 33, 'User logged in: sensen', '2025-03-31'),
(152, 33, 'Changed Pass:sensen', '2025-03-31'),
(153, 33, 'User logged in: sensen', '2025-03-31'),
(154, 30, 'User logged in: markyyy', '2025-03-31'),
(155, 30, 'User Updated: markyyy', '2025-03-31'),
(156, 30, 'User logged in: markyyy', '2025-03-31'),
(157, 33, 'User logged in: sensen', '2025-03-31'),
(158, 30, 'User logged in: markyyy', '2025-03-31'),
(159, 30, 'User logged in: markyyy', '2025-03-31'),
(160, 30, 'User logged in: markyyy', '2025-03-31'),
(161, 30, 'User logged in: markyyy', '2025-03-31'),
(162, 30, 'User logged in: markyyy', '2025-03-31'),
(163, 33, 'User logged in: sensen', '2025-04-01'),
(164, 33, 'User Changed Image:sensen', '2025-04-01'),
(165, 30, 'User logged in: markyyy', '2025-04-01'),
(166, 33, 'User logged in: sensen', '2025-04-01'),
(167, 33, 'User Added Security:sensen', '2025-04-01'),
(168, 33, 'Updated Information: sensen', '2025-04-01'),
(169, 30, 'User logged in: markyyy', '2025-04-01'),
(170, 30, 'User logged in: markyyy', '2025-04-01'),
(171, 30, 'User logged in: markyyy', '2025-04-01'),
(172, 30, 'User logged in: markyyy', '2025-04-01'),
(173, 30, 'User logged in: markyyy', '2025-04-01'),
(174, 30, 'User logged in: markyyy', '2025-04-02'),
(175, 34, 'User logged in: table', '2025-04-02'),
(176, 34, 'User logged in: table', '2025-04-02'),
(177, 34, 'User logged in: table', '2025-04-02'),
(178, 34, 'User logged in: table', '2025-04-02'),
(179, 30, 'User logged in: markyyy', '2025-04-02'),
(180, 30, 'User Updated: table', '2025-04-02'),
(181, 34, 'User logged in: table', '2025-04-02'),
(182, 34, 'User logged in: table', '2025-04-02'),
(183, 34, 'User logged in: table', '2025-04-02'),
(184, 34, 'User logged in: table', '2025-04-02'),
(185, 30, 'User logged in: markyyy', '2025-04-02'),
(186, 30, 'Product Added: Camping Chair', '2025-04-02'),
(187, 30, 'Product Added: Hammer', '2025-04-02'),
(188, 30, 'User logged in: markyyy', '2025-04-02'),
(189, 30, 'User logged in: markyyy', '2025-04-02'),
(190, 30, 'User logged in: markyyy', '2025-04-02'),
(191, 30, 'User logged in: markyyy', '2025-04-02'),
(192, 30, 'User logged in: markyyy', '2025-04-02'),
(193, 30, 'User logged in: markyyy', '2025-04-02'),
(194, 30, 'User logged in: markyyy', '2025-04-02'),
(195, 30, 'User logged in: markyyy', '2025-04-02'),
(196, 30, 'User logged in: markyyy', '2025-04-02'),
(197, 30, 'User logged in: markyyy', '2025-04-02'),
(198, 30, 'User logged in: markyyy', '2025-04-02'),
(199, 30, 'User logged in: markyyy', '2025-04-02'),
(200, 30, 'User logged in: markyyy', '2025-04-02'),
(201, 30, 'User logged in: markyyy', '2025-04-02'),
(202, 30, 'User logged in: markyyy', '2025-04-02'),
(203, 30, 'User logged in: markyyy', '2025-04-02'),
(204, 30, 'User logged in: markyyy', '2025-04-02'),
(205, 30, 'User logged in: markyyy', '2025-04-02'),
(206, 30, 'User logged in: markyyy', '2025-04-02'),
(207, 34, 'User logged in: table', '2025-04-02'),
(208, 30, 'User logged in: markyyy', '2025-04-05'),
(209, 30, 'User added order: markyyynull', '2025-04-05'),
(210, 30, 'User logged in: markyyy', '2025-04-05'),
(211, 30, 'User added order for product: Wrench (markyyy)', '2025-04-05'),
(212, 30, 'User logged in: markyyy', '2025-04-05'),
(213, 30, 'User logged in: markyyy', '2025-04-05'),
(214, 30, 'User Added: markyyy', '2025-04-05'),
(215, 30, 'User logged in: markyyy', '2025-04-06'),
(216, 30, 'User logged in: markyyy', '2025-04-06'),
(217, 30, 'User logged in: markyyy', '2025-04-06'),
(218, 30, 'User logged in: markyyy', '2025-04-06'),
(219, 30, 'User logged in: markyyy', '2025-04-06'),
(220, 30, 'User Logout: markyyy', '2025-04-06'),
(221, 30, 'User logged in: markyyy', '2025-04-07'),
(222, 30, 'User logged in: markyyy', '2025-04-07'),
(223, 30, 'User logged in: markyyy', '2025-04-07'),
(224, 30, 'User Logout: markyyy', '2025-04-07'),
(225, 30, 'User logged in: markyyy', '2025-04-07'),
(226, 30, 'User logged in: markyyy', '2025-04-07'),
(227, 30, 'User logged in: markyyy', '2025-04-07'),
(228, 30, 'User logged in: markyyy', '2025-04-07'),
(229, 30, 'User logged in: markyyy', '2025-04-07'),
(230, 30, 'User logged in: markyyy', '2025-04-07'),
(231, 30, 'User logged in: markyyy', '2025-04-07'),
(232, 30, 'User logged in: markyyy', '2025-04-07'),
(233, 30, 'User logged in: markyyy', '2025-04-10'),
(234, 30, 'User logged in: markyyy', '2025-04-11'),
(235, 30, 'User logged in: markyyy', '2025-04-11'),
(236, 30, 'User logged in: markyyy', '2025-04-11'),
(237, 30, 'User logged in: markyyy', '2025-04-11'),
(238, 30, 'User logged in: markyyy', '2025-04-11'),
(239, 34, 'User logged in: table', '2025-04-11'),
(240, 34, 'User added order for product: Wrench (table)', '2025-04-11'),
(241, 34, 'User logged in: table', '2025-04-11'),
(242, 30, 'User logged in: markyyy', '2025-04-11'),
(243, 30, 'User logged in: markyyy', '2025-04-11'),
(244, 30, 'User logged in: markyyy', '2025-04-11'),
(245, 30, 'User logged in: markyyy', '2025-04-13'),
(246, 30, 'User Logout: markyyy', '2025-04-13'),
(247, 30, 'User logged in: markyyy', '2025-04-13'),
(248, 30, 'User logged in: markyyy', '2025-04-13'),
(249, 30, 'User logged in: markyyy', '2025-04-13'),
(250, 34, 'User logged in: table', '2025-04-13'),
(251, 34, 'User logged in: table', '2025-04-13'),
(252, 34, 'User added order for product: Shoes (table)', '2025-04-13'),
(253, 30, 'User logged in: markyyy', '2025-04-13'),
(254, 30, 'User logged in: markyyy', '2025-04-14'),
(255, 30, 'User logged in: markyyy', '2025-04-14'),
(256, 30, 'User logged in: markyyy', '2025-04-14'),
(257, 30, 'User logged in: markyyy', '2025-04-14'),
(258, 30, 'User logged in: markyyy', '2025-04-14'),
(259, 30, 'User logged in: markyyy', '2025-04-14'),
(260, 30, 'User logged in: markyyy', '2025-04-14'),
(261, 30, 'User logged in: markyyy', '2025-04-14'),
(262, 30, 'Product Added: TestingProduct', '2025-04-14'),
(263, 30, 'User logged in: markyyy', '2025-04-14'),
(264, 30, 'User logged in: markyyy', '2025-04-14'),
(265, 30, 'User logged in: markyyy', '2025-04-14'),
(266, 30, 'User logged in: markyyy', '2025-04-14'),
(267, 30, 'User logged in: markyyy', '2025-04-14'),
(268, 30, 'User logged in: markyyy', '2025-04-14'),
(269, 30, 'User logged in: markyyy', '2025-04-14'),
(270, 30, 'User logged in: markyyy', '2025-04-14'),
(271, 30, 'User logged in: markyyy', '2025-04-14'),
(272, 30, 'User logged in: markyyy', '2025-04-14'),
(273, 30, 'User logged in: markyyy', '2025-04-14'),
(274, 34, 'User logged in: table', '2025-04-14'),
(275, 30, 'User logged in: markyyy', '2025-04-14'),
(276, 30, 'User logged in: markyyy', '2025-04-14');

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

--
-- Dumping data for table `process`
--

INSERT INTO `process` (`s_id`, `u_id`, `p_id`, `s_quantity`, `s_totalam`, `s_cash`, `s_change`, `s_status`, `s_date`) VALUES
(1, 30, 15, 1, 200, 300, 100, 'Complete', '2025-04-02'),
(2, 30, 15, 1, 200, 1120, 920, 'Complete', '2025-04-05'),
(3, 30, 10, 2, 80, 200, 120, 'Pending', '2025-04-05'),
(4, 34, 10, 1, 40, 100, 60, 'Pending', '2025-04-11'),
(5, 34, 8, 1, 50, 60, 10, 'Pending', '2025-04-13');

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
  `p_status` varchar(20) NOT NULL,
  `p_image` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`p_id`, `p_name`, `p_category`, `p_brand`, `p_price`, `p_stock`, `p_status`, `p_image`) VALUES
(3, 'Piattos', 'Food and Beverage', 'Oishi', 15, 0, 'Not Available', ''),
(4, 'Kitchen Knife', 'Household Essentials', 'TrustTolly', 100, 50, 'Available', ''),
(6, 'Noodles', 'Food and Beverage', 'Lucky me', 20, 50, 'Available', ''),
(8, 'Shoes', 'Food and Beverage', 'Nike', 50, 24, 'Available', ''),
(9, 'Shoes', 'Personal Wellness', 'Nike', 500, 11, 'Available', ''),
(10, 'Wrench', 'Supplies Utilities', 'Mr Tool', 40, 18, 'Available', ''),
(11, 'Water Bottle', 'Food and Beverage', 'Minerale', 15, 28, 'Available', ''),
(12, 'Spring Water Mineral', 'Food and Beverage', 'Lemineralee', 15, 66, 'Available', ''),
(13, 'Sip Water Bottles ', 'Food and Beverage', 'SIP ITT', 25, 70, 'Available', 'src/userimages/LOGO SYSTEM small.png'),
(14, 'Camping Chair', 'Household Essentials', 'Let\'s Go Camping', 150, 10, 'Available', 'src/userimages/pexels-summer-stock-325117.jpg'),
(15, 'Hammer', 'Supplies Utilities', 'Saving Tools', 200, 3, 'Available', 'src/userimages/Screenshot 2025-03-07 224221.png'),
(16, 'TestingProduct', 'Personal Wellness', 'HelloWorld', 20, 495, 'Available', 'src/userimages/add-product222.png');

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
  `u_stat` varchar(150) NOT NULL,
  `u_ans1` varchar(50) NOT NULL,
  `u_ans2` varchar(50) NOT NULL,
  `u_ans3` varchar(50) NOT NULL,
  `u_image` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_username`, `u_fname`, `u_lname`, `u_email`, `u_contact`, `u_type`, `u_password`, `u_stat`, `u_ans1`, `u_ans2`, `u_ans3`, `u_image`) VALUES
(13, 'zenniaaa', 'Zennia ', 'Requillo', 'zenn@gmail.com', '09887865453', 'Customer', 'zennia12345678', 'Active', '', '', '', ''),
(15, 'ant', 'Anthony', 'Arambala', 'arambala@gmail.com', '0966886464605', 'Admin', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active', '', '', '', ''),
(16, 'testesss', 'Testing', 'This is Just a test', 'testing@gmail.com', '99999878987', 'Customer', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active', '', '', '', ''),
(17, 'mikey', 'Mike', 'Bustamante', 'mikeee@gmail.com', '09875432121', 'Customer', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active', '', '', '', ''),
(20, 'jeppp', 'Jeepne', 'Josephine', 'jeep@gmail.com', '09887656785', 'Admin', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active', '', '', '', ''),
(21, 'Riri', 'Ridona', 'Adlawan', 'riririi@gmail.com', '09778654232', 'Employee', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active', '', '', '', ''),
(22, 'santino', 'Santino Jamal', 'Murry', 'santt@gmail.com', '09887654531', 'Admin', '8qM5TspK8pdk0gpMqDIWb8uUI5i8CVxIzut45BPIs7w=', 'Active', '', '', '', ''),
(23, 'Antonio', 'Antonio Lezel', 'Arambala', 'anto@gmail.com', '09786567453', 'Admin', 'xC2czW7d4hc8ZKV0fvVWImy3U1ceP1OAauArN2x5CF4=', 'Active', '', '', '', ''),
(24, 'petpet', 'John Peter', 'delacalzada', 'dela@gmail.com', '09887678654', 'Customer', 'GKR1RAsMs4HFx2/mMPckMwDwZiymS3CFoUbYnBS3Mf4=', 'Active', '', '', '', ''),
(25, 'caloy', 'Jeven Carl', 'Emnace', 'emnace@gmail.com', '09878654321', 'Admin', 'CUcPSc0Iaz2hqGmH/My+gz+lDz8nmUEF4Iz2ndQyWpo=', 'Pending', '', '', '', ''),
(26, 'sephsephseph', 'Seri', 'Testingrani', 'chanchan@gmail.com', '09897656768', 'Employee', 'mosjbHV6WdXhLIJklFO3VKGj0meXsUaV5AK2YXFb8TM=', 'Active', '', '', '', ''),
(27, 'loydloydloyd', 'Loyddyy', 'Arambels', 'belsss@gmail.com', '09879667854', 'Admin', '17FNiCXG3TsYN9RkcJjjc8Tdn4YmFbqKeadxSU4fzfA=', 'Active', '', '', '', ''),
(28, 'creation12345', 'Cretee', 'Balbon', 'balss@gmail.com', '09897656784', 'Customer', '7k7x34cg3dDL+WVQHvYre6Z+joIrM68YtG7AO+nhnss=', 'Pending', '', '', '', ''),
(29, 'tylerthedestroyer', 'Tyler', 'Zamora', 'zammm@gmail.com', '09898767543', 'Admin', 'hahahaha', 'Active', '', '', '', ''),
(30, 'markyyy', 'Mark J', 'Cortes', 'cortssss@gmail.com', '09786787656', 'Admin', 'g2SQmc43b221raN17NpOrA+9DyTbO9b5YVZnjKdr7mE=', 'Active', 'Brown', 'English', 'markmark', 'src/userimages/add-product.png'),
(31, 'otep', 'Anthony Joseph', 'Arambala', 'bala@gmail.com', '09897865789', 'Admin', '17FNiCXG3TsYN9RkcJjjc8Tdn4YmFbqKeadxSU4fzfA=', 'Active', 'N/A', 'N/A', 'N/A', 'src/images/testingimage.jpg'),
(32, 'dinaaa', 'Dina Mae', 'Saduguan', 'sad@gmail.com', '09675554321', 'Admin', 'XeF/2zJhykzKccq73oq5/jz3WC28lcnNJxRBwVgSxQw=', 'Active', 'N/A', 'N/A', 'N/A', 'src/userimages/0a38176b-98b5-400e-8665-83c06b69f8db.jpg'),
(33, 'sensen', 'Zennia', 'Arambala', 'zenzenn@gmail.com', '09876545678', 'Customer', '48TEKXn42oKsAF7xLqhm77+xDGpjIbX6lYiQ8lZAT5w=', 'Active', 'Green', 'Math', 'nniaa', 'src/userimages/composercheck download.png'),
(34, 'table', 'Table tennis', 'Ping Pong', 'pongpong@gmail.com', '09897866543', 'Admin', 'c8ppu2gSTqlup+HZn/I43uq6TVRhhcU/fOEjaLM3+uo=', 'Active', 'N/A', 'N/A', 'N/A', 'src/userimages/laravel link.png'),
(35, 'larlarlarlar', 'larry John', 'John John', 'johnnyjohhnyy@gmail.com', '09667543121', 'Customer', 'NaysV9CqcImAuFfEdHqc88iAoVHolOLTqFY4bmXJA4A=', 'Active', 'N/A', 'N/A', 'N/A', 'src/userimages/p.png');

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
  MODIFY `log_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=277;

--
-- AUTO_INCREMENT for table `process`
--
ALTER TABLE `process`
  MODIFY `s_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

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

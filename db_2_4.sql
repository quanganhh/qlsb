-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2019 at 06:14 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlsb`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `status` smallint(6) NOT NULL,
  `time` datetime NOT NULL,
  `total_price` float NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `booking_detail`
--

CREATE TABLE `booking_detail` (
  `id` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `expired_time` date NOT NULL,
  `booking_id` int(11) NOT NULL,
  `sp_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `extra_booking`
--

CREATE TABLE `extra_booking` (
  `id` int(11) NOT NULL,
  `detail_booking_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(13),
(13),
(13),
(13);

-- --------------------------------------------------------

--
-- Table structure for table `sc_pitch`
--

CREATE TABLE `sc_pitch` (
  `id` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `status` smallint(6) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sc_pitch`
--

INSERT INTO `sc_pitch` (`id`, `address`, `description`, `name`, `price`, `status`) VALUES
(1, 'dia chi 1', 'dia chi 1', 'san bong 1', 100000, 1),
(2, 'ha noi', 'san bong cua duy', 'san bong sexy', 1000000, 1),
(3, 'thai binh', 'san bong cua duy', 'san bong vip', 100000000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `t_comment`
--

CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL,
  `content` varchar(300) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_post`
--

CREATE TABLE `t_post` (
  `id` bigint(20) NOT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `title` varchar(300) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_role`
--

CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_role`
--

INSERT INTO `t_role` (`id`, `role_name`) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'GUEST');

-- --------------------------------------------------------

--
-- Table structure for table `t_user`
--

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_user`
--

INSERT INTO `t_user` (`id`, `active`, `avatar_url`, `email`, `first_name`, `last_name`, `password`, `phone_number`, `role_id`) VALUES
(1, b'1', NULL, 'toan@gmail.com', 'Toan', 'Ngo', '$2a$11$IbKOWY28F/XWlpTnmLW9fOWgciVDlPfx/Ef6HSaPpth3TnphYjjxW', '0932321592', 1),
(2, b'1', NULL, 'toan1@gmail.com', 'Toan', 'Ngo', '$2a$11$7.QBrEsbQNHVpLsb8GsTcOMon8iOV6rqYV3HUoWgTfY2BIjTEN03S', '0932321592', 1),
(4, b'0', NULL, 'toan12@gmail.com', 'Toan', 'Ngo', '$2a$11$1kx6MOn1L3c170Y7ptxO1O1jYq7Rxmked/33b0JQh0p2KbrOok2aS', '0932321592', 1),
(5, b'0', NULL, 'toan123@gmail.com', 'Ngo', 'Toan', '$2a$11$V7XagOcFe9.zJG6vfNJLoO3AixSkHxBL/VvUeUEtbm6u/fw3Joqw2', '0917033153', 2),
(10, b'0', NULL, 'toan1234@gmail.com', 'Ngo', 'Toan', '$2a$11$CQAMqK/S6VVBU35JmRjFweZdhrpU1Na7VDHQZmw9cSOeHuYICYY/q', '0917033153', 2),
(8, b'0', NULL, 'toan12345@gmail.com', 'Ngo', 'Toan', '$2a$11$rZi4W7k2bNL0mTmaxh5cluV6Hm0zEbB2lTE4PVf4n7/dEr.qWUuwO', '09121', 2),
(11, b'0', NULL, 'duy@gmail.com', 'Hoàng', 'Duy', '$2a$11$7.QBrEsbQNHVpLsb8GsTcOMon8iOV6rqYV3HUoWgTfY2BIjTEN03S', '0868130798', 2),
(12, b'1', NULL, 'duy1@gmail.com', 'hoang', 'duy', '$2a$11$8B3faLFnidR9OKLbj9aTguWAmtLwFVfocoVkeF9wv4O2.eunaSpU.', '259437', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_userid` (`user_id`);

--
-- Indexes for table `booking_detail`
--
ALTER TABLE `booking_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK59941ondg9nwaifm2umnrduev` (`booking_id`),
  ADD KEY `FKe726d13bqvuynlr4a2gi8pdh7` (`sp_id`);

--
-- Indexes for table `extra_booking`
--
ALTER TABLE `extra_booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKal5lb6qrkp9mvsjjyxcel019r` (`detail_booking_id`);

--
-- Indexes for table `sc_pitch`
--
ALTER TABLE `sc_pitch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_comment`
--
ALTER TABLE `t_comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtamaoacctq4qpko6bvtv0ke1p` (`user_id`),
  ADD KEY `FKsa3hl9a6mu30dct1jnn2bwvem` (`post_id`);

--
-- Indexes for table `t_post`
--
ALTER TABLE `t_post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK18f01t655nkcuptq9oxp04sgn` (`user_id`);

--
-- Indexes for table `t_role`
--
ALTER TABLE `t_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_i6qjjoe560mee5ajdg7v1o6mi` (`email`),
  ADD KEY `FK76cs7cu4h4y8vc1vd4qyw36rt` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `booking_detail`
--
ALTER TABLE `booking_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `extra_booking`
--
ALTER TABLE `extra_booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sc_pitch`
--
ALTER TABLE `sc_pitch`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

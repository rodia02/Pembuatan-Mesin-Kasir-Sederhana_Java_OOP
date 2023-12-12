-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2023 at 02:42 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '202cb962ac59075b964b07152d234b70'),
('', ''),
('saya', 'saya'),
('kamu', '48ec8af8df4bf4347d9b1de4ee7bb092');

-- --------------------------------------------------------

--
-- Table structure for table `makanan`
--

CREATE TABLE `makanan` (
  `kode` varchar(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` float NOT NULL,
  `kadaluarsa` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `makanan`
--

INSERT INTO `makanan` (`kode`, `nama`, `harga`, `kadaluarsa`) VALUES
('MKN1', 'Chitato BBQ Normal', 10000, '2023-06-30'),
('MKN2', 'Oreo Normal', 15000, '2023-07-17'),
('MKN3', 'Potabee Kentang Goreng', 12000, '2023-09-05'),
('MKN4', 'Cheetox BBQ', 16000, '2023-11-02');

-- --------------------------------------------------------

--
-- Table structure for table `pulsa`
--

CREATE TABLE `pulsa` (
  `kode` varchar(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `Operator` varchar(30) NOT NULL,
  `nominal` float NOT NULL,
  `Harga` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pulsa`
--

INSERT INTO `pulsa` (`kode`, `nama`, `Operator`, `nominal`, `Harga`) VALUES
('PL1', 'Telkomsel 5.000', 'Telkomsel', 5000, 7000),
('PL10', 'Indosat 100.000', 'Indosat', 100000, 102000),
('PL11', 'XL 5.000', 'XL', 5000, 7000),
('PL12', 'XL 10.000', 'XL', 10000, 12000),
('PL13', 'XL 20.000', 'XL', 20000, 22000),
('PL14', 'XL 50.000', 'XL', 50000, 52000),
('PL15', 'XL 100.000', 'XL ', 100000, 102000),
('PL16', 'Tri 5.000', 'Tri', 5000, 7000),
('PL17', 'Tri 10.000', 'Tri', 10000, 12000),
('PL18', 'Tri 20.000', 'Tri', 20000, 22000),
('PL19', 'Tri 50.000', 'Tri', 50000, 52000),
('PL2', 'Telkomsel 10.000', 'Telkomsel', 10000, 12000),
('PL20', 'Tri 100.000', 'Tri', 100000, 102000),
('PL3', 'Telkomsel 20.000', 'Telkomsel', 20000, 22000),
('PL4', 'Telkomsel 50.000', 'Telkomsel', 50000, 52000),
('PL5', 'Telkomsel 100.000', 'Telkomsel', 100000, 102000),
('PL6', 'Indosat 5.000', 'Indosat', 5000, 7000),
('PL7', 'Indosat 10.000', 'Indosat', 10000, 12000),
('PL8', 'Indosat 20.000', 'Indosat', 20000, 22000),
('PL9', 'Indosat 50.000', 'Indosat', 50000, 52000);

-- --------------------------------------------------------

--
-- Table structure for table `token`
--

CREATE TABLE `token` (
  `kode` varchar(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nominal` float NOT NULL,
  `harga` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `token`
--

INSERT INTO `token` (`kode`, `nama`, `nominal`, `harga`) VALUES
('TKN1', 'Token 20000', 20000, 22000),
('TKN2', 'Token 50000', 50000, 52000),
('TKN3', 'Token 100000', 100000, 102000),
('TKN4', 'Token 250000', 250000, 252000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_pembayaran` varchar(11) NOT NULL,
  `total_harga` float NOT NULL,
  `waktu_pembayaran` date NOT NULL,
  `jenis_pembayaran` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_pembayaran`, `total_harga`, `waktu_pembayaran`, `jenis_pembayaran`) VALUES
('0', 0, '2023-08-11', 'Tunai'),
('2', 10000, '2023-06-11', 'Kartu Debit'),
('3', 10000, '2023-06-11', 'QRIS'),
('4', 0, '2023-06-11', 'Tunai'),
('5', 0, '2023-06-11', 'Tunai'),
('6', 0, '2023-06-11', 'Tunai'),
('7', 0, '2023-06-11', 'Tunai'),
('8', 91000, '2023-06-11', 'Kartu Debit'),
('9', 10000, '2023-06-11', 'QRIS'),
('10', 22000, '2023-06-11', 'QRIS'),
('11', 22000, '2023-06-11', 'QRIS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `pulsa`
--
ALTER TABLE `pulsa`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`kode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

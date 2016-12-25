-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2016 at 04:48 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `busexpressticketingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `busId` varchar(15) NOT NULL,
  `busTypeId` varchar(15) NOT NULL,
  `plateNo` varchar(15) NOT NULL,
  `model` varchar(15) NOT NULL,
  `totalSeat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`busId`, `busTypeId`, `plateNo`, `model`, `totalSeat`) VALUES
('A000', 'BT002', 'QTX-9090', 'Model-X', 30),
('B000', 'BT001', 'SEQ-9898', 'Model-X', 42),
('C000', 'BT003', 'SEQ-3456', 'Model-Y', 30),
('D000', 'BT003', 'WEZ-4545', 'Model-X', 42),
('E000', 'BT003', 'WEQ-5671', 'Model-Y', 30),
('F000', 'BT004', 'PLE-909', 'Model-Z', 42);

-- --------------------------------------------------------

--
-- Table structure for table `bustype`
--

CREATE TABLE `bustype` (
  `busTypeId` varchar(15) NOT NULL,
  `busTypeName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bustype`
--

INSERT INTO `bustype` (`busTypeId`, `busTypeName`) VALUES
('BT001', 'VIP'),
('BT002', 'Z-Club'),
('BT003', 'Premium'),
('BT004', 'First Class');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cusId` varchar(15) NOT NULL,
  `icNo` varchar(14) NOT NULL,
  `cusName` varchar(80) NOT NULL,
  `gender` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phoneNo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cusId`, `icNo`, `cusName`, `gender`, `address`, `email`, `phoneNo`) VALUES
('CUS0001', '95120135729', 'SS SS', 'Male', 'something else', 'tk.zack1220@gmai.com', '0146822975'),
('CUS0002', '961220135728', 'Mie mie', 'Female', 'something here', 'mei@gmail.com', '0146785898'),
('CUS0003', '951220-135729', 'Mei Mei', 'Male', 'werwrw', 'werwere', '33-909-77'),
('CUS0004', '951220-13-5729', 'Mei mei', 'Female', 'Duck Hourse', 'qweqe', 'qweqwe'),
('CUS0005', '098900-90-0987', 'THt', 'Male', 'jln good', 'jgj@', '129909292'),
('CUS0006', '951220-13-5729', 'D', 'Male', 'jln bad', 'zl@gmail.com', '9876736'),
('CUS0007', '951220-13-5729', 'GG', 'Male', 'jln Max', 'gg.com', '345353534'),
('CUS0008', '951220-13-5729', 'Senial', 'Female', 'Jln buh', 'h.com', '45445445'),
('CUS0009', '951220-15-5577', 'mumu', 'Female', 'jln brid', 'fkf.com', '1234567'),
('CUS0010', '961220-68-5729', 'Daniel', 'Male', 'jln Bird', 'tk.com', '123456789'),
('CUS0011', '951220-13-5729', 'rrr', 'Male', 'jln buru', 'gdfg', '12355'),
('CUS0012', '989898-10-9090', 'rerer', 'Male', 'jln gui', 'erer', '12345'),
('CUS0013', '989898-40-7865', 'thth', 'Female', 'jln good', 'tht.com', '3453535'),
('CUS0014', '961220-13-5728', 'Fernal', 'Female', 'jln kong Bing', 'hk.com', '345678654'),
('CUS0015', '951220-13-5729', 'Dulex', 'Male', 'jln Bagus, 98700', 'famous@.com', '456456456'),
('CUS0016', '880117-14-5678', 'Gen Gen Ming', 'Female', 'jln hantu', '-', '123457865'),
('CUS0017', '200123-08-1234', 'chai', 'Female', 'pj', 'chailk@acd.tarc.edu.my', '0163832363'),
('CUS0018', '222222-22-2222', 'chai', 'Female', 'wea', 'nzjxW@szmxk.com', '232312'),
('CUS0019', '961330-45-6679', 'Mei Mei', 'Female', '-', '-', '123456789');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `scheduleId` varchar(15) NOT NULL,
  `departDate` date NOT NULL,
  `departTime` varchar(15) NOT NULL,
  `fromLocation` varchar(30) NOT NULL,
  `toLocation` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `availability` varchar(15) NOT NULL,
  `busId` varchar(15) NOT NULL,
  `staffId` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`scheduleId`, `departDate`, `departTime`, `fromLocation`, `toLocation`, `price`, `availability`, `busId`, `staffId`) VALUES
('SCH0002', '2016-03-20', '02.00 p.m.', 'Kuala Lumpur', 'Taiping', 50, 'Available', 'C000', 'S0001'),
('SCH0003', '2016-03-20', '11.00 a.m.', 'Gen-Highlands', 'Taiping', 45, 'Available', 'B000', 'S0001'),
('SCH0004', '2016-03-18', '09.45 a.m.', 'Kuala Lumpur', 'Taiping', 30, 'Available', 'B000', 'S0001'),
('SCH0005', '2016-03-23', '09.45 a.m.', 'Gen-Highlands', 'Taiping', 60, 'Available', 'A000', 'S0001'),
('SCH0006', '2016-03-23', '02.00 p.m.', 'Gen-Highlands', 'Taiping', 60, 'Available', 'A000', 'S0001'),
('SCH0007', '2016-03-26', '11.00 a.m.', 'Taiping', 'Kuala Lumpur', 60, 'Available', 'F000', 'S0001'),
('SCH0008', '2016-03-31', '09.45 a.m.', 'Gen-Highlands', 'Taiping', 100, 'Available', 'F000', 'S0001'),
('SCH0009', '2015-04-01', '09.45 a.m.', 'Kuala Lumpur', 'Taiping', 60, 'Available', 'F000', 'S0001'),
('SCH0010', '2016-04-04', '09.45 a.m.', 'Gen-Highlands', 'Taiping', 100, 'Unavailable', 'F000', 'S0001'),
('SCH0011', '2016-04-02', '09.45 a.m.', 'Taiping', 'Gen-Highlands', 45, 'Unavailable', 'B000', 'S0001');

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `seatId` varchar(15) NOT NULL,
  `busId` varchar(15) NOT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`seatId`, `busId`, `status`) VALUES
('A001', 'A000', 'Available'),
('A002', 'A000', 'Available'),
('A003', 'A000', 'Available'),
('A004', 'A000', 'Available'),
('A005', 'A000', 'Available'),
('A006', 'A000', 'Available'),
('A007', 'A000', 'Available'),
('A008', 'A000', 'Available'),
('A009', 'A000', 'Available'),
('A010', 'A000', 'Available'),
('A011', 'A000', 'Available'),
('A012', 'A000', 'Available'),
('A013', 'A000', 'Available'),
('A014', 'A000', 'Available'),
('A015', 'A000', 'Available'),
('A016', 'A000', 'Available'),
('A017', 'A000', 'Available'),
('A018', 'A000', 'Available'),
('A019', 'A000', 'Available'),
('A020', 'A000', 'Available'),
('A021', 'A000', 'Available'),
('A022', 'A000', 'Available'),
('A023', 'A000', 'Available'),
('A024', 'A000', 'Available'),
('A025', 'A000', 'Available'),
('A026', 'A000', 'Available'),
('A027', 'A000', 'Available'),
('A028', 'A000', 'Available'),
('A029', 'A000', 'Available'),
('A030', 'A000', 'Available'),
('B001', 'B000', 'Available'),
('B002', 'B000', 'Available'),
('B003', 'B000', 'Available'),
('B004', 'B000', 'Available'),
('B005', 'B000', 'Available'),
('B006', 'B000', 'Available'),
('B007', 'B000', 'Available'),
('B008', 'B000', 'Available'),
('B009', 'B000', 'Available'),
('B010', 'B000', 'Available'),
('B011', 'B000', 'Available'),
('B012', 'B000', 'Available'),
('B013', 'B000', 'Available'),
('B014', 'B000', 'Available'),
('B015', 'B000', 'Available'),
('B016', 'B000', 'Available'),
('B017', 'B000', 'Available'),
('B018', 'B000', 'Available'),
('B019', 'B000', 'Available'),
('B020', 'B000', 'Available'),
('B021', 'B000', 'Available'),
('B022', 'B000', 'Available'),
('B023', 'B000', 'Available'),
('B024', 'B000', 'Available'),
('B025', 'B000', 'Available'),
('B026', 'B000', 'Available'),
('B027', 'B000', 'Available'),
('B028', 'B000', 'Available'),
('B029', 'B000', 'Available'),
('B030', 'B000', 'Available'),
('B031', 'B000', 'Available'),
('B032', 'B000', 'Available'),
('B033', 'B000', 'Available'),
('B034', 'B000', 'Available'),
('B035', 'B000', 'Available'),
('B036', 'B000', 'Available'),
('B037', 'B000', 'Available'),
('B038', 'B000', 'Available'),
('B039', 'B000', 'Available'),
('B040', 'B000', 'Available'),
('B041', 'B000', 'Available'),
('B042', 'B000', 'Available'),
('C001', 'C000', 'Available'),
('C002', 'C000', 'Available'),
('C003', 'C000', 'Available'),
('C004', 'C000', 'Available'),
('C005', 'C000', 'Available'),
('C006', 'C000', 'Available'),
('C007', 'C000', 'Available'),
('C008', 'C000', 'Available'),
('C009', 'C000', 'Available'),
('C010', 'C000', 'Available'),
('C011', 'C000', 'Available'),
('C012', 'C000', 'Available'),
('C013', 'C000', 'Available'),
('C014', 'C000', 'Available'),
('C015', 'C000', 'Available'),
('C016', 'C000', 'Available'),
('C017', 'C000', 'Available'),
('C018', 'C000', 'Available'),
('C019', 'C000', 'Available'),
('C020', 'C000', 'Available'),
('C021', 'C000', 'Available'),
('C022', 'C000', 'Available'),
('C023', 'C000', 'Available'),
('C024', 'C000', 'Available'),
('C025', 'C000', 'Available'),
('C026', 'C000', 'Available'),
('C027', 'C000', 'Available'),
('C028', 'C000', 'Available'),
('C029', 'C000', 'Available'),
('C030', 'C000', 'Available'),
('D001', 'D000', 'Available'),
('D002', 'D000', 'Available'),
('D003', 'D000', 'Available'),
('D004', 'D000', 'Available'),
('D005', 'D000', 'Available'),
('D006', 'D000', 'Available'),
('D007', 'D000', 'Available'),
('D008', 'D000', 'Available'),
('D009', 'D000', 'Available'),
('D010', 'D000', 'Available'),
('D011', 'D000', 'Available'),
('D012', 'D000', 'Available'),
('D013', 'D000', 'Available'),
('D014', 'D000', 'Available'),
('D015', 'D000', 'Available'),
('D016', 'D000', 'Available'),
('D017', 'D000', 'Available'),
('D018', 'D000', 'Available'),
('D019', 'D000', 'Available'),
('D020', 'D000', 'Available'),
('D021', 'D000', 'Available'),
('D022', 'D000', 'Available'),
('D023', 'D000', 'Available'),
('D024', 'D000', 'Available'),
('D025', 'D000', 'Available'),
('D026', 'D000', 'Available'),
('D027', 'D000', 'Available'),
('D028', 'D000', 'Available'),
('D029', 'D000', 'Available'),
('D030', 'D000', 'Available'),
('D031', 'D000', 'Available'),
('D032', 'D000', 'Available'),
('D033', 'D000', 'Available'),
('D034', 'D000', 'Available'),
('D035', 'D000', 'Available'),
('D036', 'D000', 'Available'),
('D037', 'D000', 'Available'),
('D038', 'D000', 'Available'),
('D039', 'D000', 'Available'),
('D040', 'D000', 'Available'),
('D041', 'D000', 'Available'),
('D042', 'D000', 'Available'),
('E001', 'E000', 'Available'),
('E002', 'E000', 'Available'),
('E003', 'E000', 'Available'),
('E004', 'E000', 'Available'),
('E005', 'E000', 'Available'),
('E006', 'E000', 'Available'),
('E007', 'E000', 'Available'),
('E008', 'E000', 'Available'),
('E009', 'E000', 'Available'),
('E010', 'E000', 'Available'),
('E011', 'E000', 'Available'),
('E012', 'E000', 'Available'),
('E013', 'E000', 'Available'),
('E014', 'E000', 'Available'),
('E015', 'E000', 'Available'),
('E016', 'E000', 'Available'),
('E017', 'E000', 'Available'),
('E018', 'E000', 'Available'),
('E019', 'E000', 'Available'),
('E020', 'E000', 'Available'),
('E021', 'E000', 'Available'),
('E022', 'E000', 'Available'),
('E023', 'E000', 'Available'),
('E024', 'E000', 'Available'),
('E025', 'E000', 'Available'),
('E026', 'E000', 'Available'),
('E027', 'E000', 'Available'),
('E028', 'E000', 'Available'),
('E029', 'E000', 'Available'),
('E030', 'E000', 'Available'),
('F001', 'F000', 'Available'),
('F002', 'F000', 'Available'),
('F003', 'F000', 'Available'),
('F004', 'F000', 'Available'),
('F005', 'F000', 'Available'),
('F006', 'F000', 'Available'),
('F007', 'F000', 'Available'),
('F008', 'F000', 'Available'),
('F009', 'F000', 'Available'),
('F010', 'F000', 'Available'),
('F011', 'F000', 'Available'),
('F012', 'F000', 'Available'),
('F013', 'F000', 'Available'),
('F014', 'F000', 'Available'),
('F015', 'F000', 'Available'),
('F016', 'F000', 'Available'),
('F017', 'F000', 'Available'),
('F018', 'F000', 'Available'),
('F019', 'F000', 'Available'),
('F020', 'F000', 'Available'),
('F021', 'F000', 'Available'),
('F022', 'F000', 'Available'),
('F023', 'F000', 'Available'),
('F024', 'F000', 'Available'),
('F025', 'F000', 'Available'),
('F026', 'F000', 'Available'),
('F027', 'F000', 'Available'),
('F028', 'F000', 'Available'),
('F029', 'F000', 'Available'),
('F030', 'F000', 'Available'),
('F031', 'F000', 'Available'),
('F032', 'F000', 'Available'),
('F033', 'F000', 'Available'),
('F034', 'F000', 'Available'),
('F035', 'F000', 'Available'),
('F036', 'F000', 'Available'),
('F037', 'F000', 'Available'),
('F038', 'F000', 'Available'),
('F039', 'F000', 'Available'),
('F040', 'F000', 'Available'),
('F041', 'F000', 'Available'),
('F042', 'F000', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `seatticket`
--

CREATE TABLE `seatticket` (
  `seatTicketId` int(11) NOT NULL,
  `seatId` varchar(15) NOT NULL,
  `ticketId` varchar(15) NOT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seatticket`
--

INSERT INTO `seatticket` (`seatTicketId`, `seatId`, `ticketId`, `status`) VALUES
(1, 'A020', 'T0001', 'Available'),
(2, 'A021', 'T0001', 'Available'),
(3, 'A003', 'T0002', 'Available'),
(4, 'A001', 'T0003', 'Available'),
(5, 'A002', 'T0003', 'Available'),
(6, 'A004', 'T0004', 'Available'),
(7, 'A005', 'T0005', 'Available'),
(8, 'A007', 'T0006', 'Available'),
(9, 'A006', 'T0007', 'Available'),
(10, 'F001', 'T0014', 'Unavailable'),
(11, 'F002', 'T0014', 'Unavailable'),
(12, 'F003', 'T0014', 'Unavailable'),
(13, 'F007', 'T0015', 'Unavailable'),
(14, 'F002', 'T0016', 'Unavailable'),
(15, 'F001', 'T0017', 'Available'),
(16, 'F002', 'T0017', 'Available'),
(17, 'F021', 'T0017', 'Available'),
(18, 'F020', 'T0017', 'Available'),
(19, 'F003', 'T0017', 'Available'),
(20, 'F007', 'T0017', 'Unavailable'),
(21, 'F014', 'T0018', 'Unavailable'),
(22, 'F015', 'T0018', 'Unavailable'),
(23, 'F014', 'T0019', 'Available'),
(24, 'F015', 'T0019', 'Available'),
(25, 'B001', 'T0020', 'Available'),
(26, 'B002', 'T0020', 'Available'),
(27, 'B003', 'T0020', 'Available'),
(28, 'F040', 'T0021', 'Available'),
(29, 'F041', 'T0021', 'Available'),
(30, 'F042', 'T0021', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffId` varchar(15) NOT NULL,
  `f_name` varchar(50) NOT NULL,
  `l_name` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `marrialStatus` varchar(10) NOT NULL,
  `phoneNo` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `position` varchar(20) NOT NULL,
  `salary` double NOT NULL,
  `password` varchar(45) NOT NULL,
  `recoveryQuestion` varchar(100) NOT NULL,
  `recoveryAnswer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffId`, `f_name`, `l_name`, `gender`, `dob`, `marrialStatus`, `phoneNo`, `address`, `email`, `position`, `salary`, `password`, `recoveryQuestion`, `recoveryAnswer`) VALUES
('S0001', 'hai ting', 'tiong', 'male', '2016-02-19', 'Married', '999-1222-22', 'jln langkawi', 'tk.zack1220@gmail.com', 'Operation Staff', 5000, '1234567', 'abc next is ', 'xyz'),
('S0002', 'Mei Li', 'Wong', 'female', '1995-03-15', 'Single', '133-456-998', 'tkttle.ffkekfe', 'meimei@gmail.com', 'Manager', 3500.55, '12345', 'What color I like', 'pink'),
('S0003', 'Fei Li', 'Yu', 'male', '1998-03-27', 'Single', '556-786-443', 'jln ipoh', 'tk.zack1220@gmail.com', 'Operation Staff', 1200, '1111', 'what is my love color', 'none'),
('S0004', 'chai', 'lk', 'female', '2016-04-02', 'Married', '0163832363', 'pj', 'chailk@acd.tarc.edu.my', 'Manager', 2000, 'chai', 'my son''s name', 'asher');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticketId` varchar(15) NOT NULL,
  `scheduleId` varchar(15) NOT NULL,
  `cusId` varchar(15) NOT NULL,
  `totalAmount` double NOT NULL,
  `PaymentType` varchar(15) NOT NULL,
  `CardNo` varchar(17) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`ticketId`, `scheduleId`, `cusId`, `totalAmount`, `PaymentType`, `CardNo`) VALUES
('T0001', 'SCH0006', 'CUS0003', 127.2, 'Cash', '-'),
('T0002', 'SCH0005', 'CUS0004', 63.6, 'Visa', '4283321045040060'),
('T0003', 'SCH0005', 'CUS0005', 127.2, 'Visa', '4283321045040060'),
('T0004', 'SCH0005', 'CUS0006', 63.6, 'Visa', '4283321045040060'),
('T0005', 'SCH0005', 'CUS0007', 63.6, 'Visa', '4283321045040060'),
('T0006', 'SCH0006', 'CUS0008', 63.6, 'Cash', '-'),
('T0007', 'SCH0005', 'CUS0009', 63.6, 'Cash', '-'),
('T0008', 'SCH0006', 'CUS0010', 63.6, 'Cash', '-'),
('T0009', 'SCH0007', 'CUS0005', 190.8, 'Cash', '-'),
('T0010', 'SCH0007', 'CUS0006', 127.2, 'Cash', '-'),
('T0011', 'SCH0007', 'CUS0007', 318, 'Cash', '-'),
('T0012', 'SCH0007', 'CUS0008', 190.8, 'Cash', '-'),
('T0013', 'SCH0007', 'CUS0009', 127.2, 'Cash', '-'),
('T0014', 'SCH0007', 'CUS0010', 190.8, 'Cash', '-'),
('T0015', 'SCH0007', 'CUS0013', 63.6, 'Cash', '-'),
('T0016', 'SCH0007', 'CUS0014', 63.6, 'Cash', '-'),
('T0017', 'SCH0008', 'CUS0015', 636, 'Visa', '4283321045040060'),
('T0018', 'SCH0008', 'CUS0016', 212, 'Cash', '-'),
('T0019', 'SCH0008', 'CUS0016', 212, 'Cash', '-'),
('T0020', 'SCH0011', 'CUS0018', 143.1, 'Visa', '4848100029440365'),
('T0021', 'SCH0008', 'CUS0019', 318, 'Cash', '-');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`busId`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cusId`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`scheduleId`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`seatId`);

--
-- Indexes for table `seatticket`
--
ALTER TABLE `seatticket`
  ADD PRIMARY KEY (`seatTicketId`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffId`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticketId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

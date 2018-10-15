SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `buyerid` int(11) NOT NULL,
  `finalprice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `cart` (`id`, `buyerid`, `finalprice`) VALUES
(40, 9, 110),
(48, 2, 90);

CREATE TABLE `cartitem` (
  `id` int(11) NOT NULL,
  `buyerid` int(11) NOT NULL,
  `cartid` int(11) NOT NULL,
  `unitvalue` double NOT NULL,
  `amount` int(11) NOT NULL,
  `itemid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `cartitem` (`id`, `buyerid`, `cartid`, `unitvalue`, `amount`, `itemid`) VALUES
(41, 9, 40, 5, 2, 8),
(42, 9, 40, 5, 2, 2),
(43, 9, 40, 5, 2, 2),
(44, 9, 40, 5, 2, 2),
(45, 9, 40, 5, 2, 2),
(46, 9, 40, 15, 2, 4),
(47, 9, 40, 15, 2, 4),
(49, 2, 48, 15, 2, 1),
(50, 2, 48, 15, 2, 1),
(76, 2, 48, 15, 2, 1);

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(77);

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `value` double NOT NULL,
  `amount` int(11) NOT NULL,
  `category` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `item` (`id`, `name`, `value`, `amount`, `category`) VALUES
(3, 'Apple', 5, 1, 'Fruit'),
(4, 'Orange', 4, 5, 'Fruit'),
(5, 'Pork meat 500gr', 20, 2, 'Fresh Meat'),
(8, 'Banana', 5, 15, 'Fruit'),
(75, 'Chocolate cookies', 5, 1, 'Coockies');

CREATE TABLE `purchase` (
  `id` int(11) NOT NULL,
  `buyerid` int(11) NOT NULL,
  `finalprice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `purchase` (`id`, `buyerid`, `finalprice`) VALUES
(54, 9, 0);

CREATE TABLE `purchaseitem` (
  `id` int(11) NOT NULL,
  `buyerid` int(11) NOT NULL,
  `purchaseid` int(11) NOT NULL,
  `unitvalue` double NOT NULL,
  `amount` int(11) NOT NULL,
  `itemid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `user` (`id`, `email`, `fname`, `lname`, `password`, `username`, `token`) VALUES
(1, 'matt@example.com', 'Matt', 'Tech', 'asd', 'newuser', NULL),
(2, 'matt@example.com', 'Matt', 'Tech', 'asd', 'newuser2', NULL),
(9, 'jon@example.com', 'Jon', 'Doe', '111', 'jondoe', NULL);


ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `cartitem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtc9npvycs1rruynyqdhyrybqw` (`cartid`);

ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `purchase`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `purchaseitem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgdh9ghuoc01mj80l1yamlhd5b` (`purchaseid`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

ALTER TABLE `cartitem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

ALTER TABLE `purchase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

ALTER TABLE `purchaseitem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `cartitem`
  ADD CONSTRAINT `FKtc9npvycs1rruynyqdhyrybqw` FOREIGN KEY (`cartid`) REFERENCES `cart` (`id`);

ALTER TABLE `purchaseitem`
  ADD CONSTRAINT `FKgdh9ghuoc01mj80l1yamlhd5b` FOREIGN KEY (`purchaseid`) REFERENCES `purchase` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

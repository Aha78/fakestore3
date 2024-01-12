-- --------------------------------------------------------
-- Verkkotietokone:              127.0.0.1
-- Palvelinversio:               11.4.0-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Versio:              12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for taulu test.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table test.users: ~5 rows (suunnilleen)
INSERT INTO `users` (`user_id`, `username`, `password`, `role`, `enabled`) VALUES
	(14, 'user44', '$2a$10$QXWLac75wGNleWoiqTupUuDuQ.ReDG2xVWCnFOyLjrucBhxXuIutO', 'ROLE_USER', 1),
	(15, 'antto', '$2a$10$QNIkDuFUqpX7pejgMQKWR.2BDny4Lv2RQkTR4LuQFAaxdEvClVK.C', 'ROLE_USER', 1),
	(16, 'antto', '$2a$10$j4Ukcx3Pkm5rCmtCXNUqD.44bppo4cIz5LSnsR96qGs/qQBTNZwpG', 'ROLE_USER', 1),
	(17, 'Antto21', '$2a$10$Yk0P/pYMd.PFPxiyaJQOsef5FuJ8izFuYD0P7HRKLQWvH6wOtHwj.', 'ROLE_USER', 1),
	(18, 'user', '$2a$10$UCPYLXN9OhvShNNG2iC1c.DBj1RpUMH3z10z.SsZiXUvNfk.jf01u', 'ROLE_USER', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

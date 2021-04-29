DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `first` varchar(10) DEFAULT NULL,
                        `second` varchar(10) DEFAULT NULL,
                        `price` double DEFAULT NULL,
                        `card` varchar(10) DEFAULT NULL,
                        `member` varchar(10) DEFAULT NULL,
                        `date` varchar(10) DEFAULT NULL,
                        `year` varchar(10) DEFAULT NULL,
                        `month` varchar(10) DEFAULT NULL,
                        `week` varchar(10) DEFAULT NULL,
                        `type` varchar(10) DEFAULT NULL,
                        `uid` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(10) DEFAULT NULL,
                        `note` varchar(20) DEFAULT NULL,
                        `image` int(11) DEFAULT NULL,
                        `income` double DEFAULT NULL,
                        `expense` double DEFAULT NULL,
                        `balance` double DEFAULT NULL,
                        `uid` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(10) DEFAULT NULL,
                        `password` varchar(20) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
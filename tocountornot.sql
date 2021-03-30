DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `first` varchar(10) DEFAULT NULL,
                        `second` varchar(10) DEFAULT NULL,
                        `price` double DEFAULT NULL,
                        `card` varchar(10) DEFAULT NULL,
                        `member` varchar(10) DEFAULT NULL,
                        `date` varchar(10) DEFAULT NULL,
                        `date_year` varchar(10) DEFAULT NULL,
                        `date_month` varchar(10) DEFAULT NULL,
                        `date_week` varchar(10) DEFAULT NULL,
                        `in_or_out` varchar(10) DEFAULT NULL,
                        `user_id` bigint(20) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `bill` VALUES
(1,'日用','购物',40,'微信','我','2020-09-26','2020','9','39','out',1),
(2,'餐饮','午餐',20,'支付宝','我','2020-09-26','2020','9','39','out',1),
(3,'工资','实习',3000,'微信','我','2020-09-26','2020','9','39','in',1);

DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
                        `name` varchar(10) NOT NULL,
                        `note` varchar(20) DEFAULT NULL,
                        `image` int(11) DEFAULT NULL,
                        `income` double DEFAULT NULL,
                        `expense` double DEFAULT NULL,
                        `balance` double DEFAULT NULL,
                        `user_id` bigint(20) DEFAULT NULL,
                        PRIMARY KEY (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `card` VALUES
('工行','工商银行',1,1000,2000,-1000,3),
('平安','平安银行',1,2000,1000,1000,2),
('建设','建设银行',1,1000,1000,0,1),
('建设','建设银行',1,3000,1500,1500,2);
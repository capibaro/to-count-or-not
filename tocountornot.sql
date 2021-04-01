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
    `uid` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `bill` VALUES
(1,'日用','购物',40,'微信','我','2020-09-26','2020','9','39','out',1),
(2,'餐饮','午餐',20,'支付宝','我','2020-09-26','2020','9','39','out',1),
(3,'工资','实习',3000,'微信','我','2020-09-26','2020','9','39','in',1);

DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(10) DEFAULT NULL,
    `note` varchar(20) DEFAULT NULL,
    `image` int(11) DEFAULT NULL,
    `income` double DEFAULT NULL,
    `expense` double DEFAULT NULL,
    `balance` double DEFAULT NULL,
    `uid` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `card` VALUES
(1,'工行','工商银行',1,1000,2000,-1000,1),
(2,'平安','平安银行',2,2000,1000,1000,2),
(3,'建设','建设银行',3,1000,1000,0,3);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `uid` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(10) DEFAULT NULL,
    `password` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES
(1,'tom','I am tom'),
(2,'jerry','I am jerry'),
(3,'spike','I am spike');
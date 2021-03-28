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
(1,'daily','shopping',40,'WeiXin','me','2020-09-26','2020','9','39','out',1),
(2,'food','lunch',20,'alipay','me','2020-09-26','2020','9','39','out',1),
(3,'salary','internship',3000,'WeiXin','me','2020-09-26','2020','9','39','in',1);
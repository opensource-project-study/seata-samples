-- 在192.168.3.129:3336这个MySQL实例中创建
CREATE DATABASE IF NOT EXISTS seata2 DEFAULT CHARACTER SET = utf8mb4;
USE seata2;

CREATE TABLE IF NOT EXISTS `t_order` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `order_no` varchar(255) DEFAULT NULL,
   `user_id` varchar(255) DEFAULT NULL,
   `commodity_code` varchar(255) DEFAULT NULL,
   `count` int(11) DEFAULT '0',
   `amount` double(14,2) DEFAULT '0.00',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';


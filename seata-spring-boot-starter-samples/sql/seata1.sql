CREATE DATABASE IF NOT EXISTS seata1 DEFAULT CHARACTER SET = utf8mb4;
USE seata1;

CREATE TABLE IF NOT EXISTS `t_account` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(255) DEFAULT NULL,
    `amount` double(14,2) DEFAULT 0.00,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户表';

INSERT INTO `t_account`(user_id,amount) VALUES ('1', 4000.00);
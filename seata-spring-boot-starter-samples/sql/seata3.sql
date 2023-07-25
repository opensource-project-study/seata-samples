-- 在192.168.3.129:3326这个MySQL实例中创建
CREATE DATABASE IF NOT EXISTS seata3 DEFAULT CHARACTER SET = utf8mb4;
USE seata3;

CREATE TABLE IF NOT EXISTS `t_stock` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `commodity_code` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `count` int(11) DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY `commodity_code` (`commodity_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='库存表';

INSERT INTO `t_stock`(commodity_code,name,count) VALUES ('good001', '图书', 1000);
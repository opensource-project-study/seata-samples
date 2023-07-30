-- 在192.168.3.129:3326这个MySQL实例中创建
CREATE DATABASE IF NOT EXISTS seata1 DEFAULT CHARACTER SET = utf8mb4;
USE seata1;

CREATE TABLE IF NOT EXISTS `account` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(255) NOT NULL DEFAULT '',
    `amount` int(11) NOT NULL DEFAULT 0,
    `frozen_amount` int(11) NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户表';

INSERT INTO `account`(user_id,amount) VALUES ('1', 1000);

CREATE TABLE IF NOT EXISTS `undo_log` (
                            `branch_id` bigint(20) NOT NULL COMMENT 'branch transaction id',
                            `xid` varchar(128) NOT NULL COMMENT 'global transaction id',
                            `context` varchar(128) NOT NULL COMMENT 'undo_log context,such as serialization',
                            `rollback_info` longblob NOT NULL COMMENT 'rollback info',
                            `log_status` int(11) NOT NULL COMMENT '0:normal status,1:defense status',
                            `log_created` datetime(6) NOT NULL COMMENT 'create datetime',
                            `log_modified` datetime(6) NOT NULL COMMENT 'modify datetime',
                            UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='AT transaction mode undo table';
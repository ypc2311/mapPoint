CREATE TABLE `MAP_POINT` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `pointLng` varchar(255) NOT NULL COMMENT '经度',
  `pointLat` varchar(255) NOT NULL COMMENT '纬度',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '图像',
  `status` int(11) NOT NULL COMMENT '状态 1在线，2离线',
  `text` varchar(255) DEFAULT NULL COMMENT '说明',
  `str1` varchar(255) DEFAULT NULL COMMENT '备用1',
  `str2` varchar(255) DEFAULT NULL COMMENT '备用2',
  `createTime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(255) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `MAP_POINT` VALUES (1, '116', '37', '测试1', 'http:tttt',1, '说明', '备用1', '备用2', '2016-03-28 09:40:31', '2016-03-28 09:45:31');
SET FOREIGN_KEY_CHECKS=1;
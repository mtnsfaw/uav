/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : uav

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-05-11 22:32:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coordinate_info
-- ----------------------------
DROP TABLE IF EXISTS `coordinate_info`;
CREATE TABLE `coordinate_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plane_name` varchar(255) DEFAULT NULL,
  `signal_index` int(11) DEFAULT NULL COMMENT '消息序号',
  `message` varchar(1000) DEFAULT NULL COMMENT '消息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coordinate_info
-- ----------------------------

-- ----------------------------
-- Table structure for plane_info
-- ----------------------------
DROP TABLE IF EXISTS `plane_info`;
CREATE TABLE `plane_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plane_name` varchar(255) DEFAULT NULL,
  `cur_index` int(11) DEFAULT NULL COMMENT '当前所处序号',
  `status` int(11) DEFAULT '0' COMMENT '0：正常，1：故障',
  `cur_coordinate` varchar(1000) DEFAULT NULL COMMENT '当前坐标',
  `pre_coordinate` varchar(1000) DEFAULT NULL COMMENT '上一坐标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plane_info
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : kg
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : kbproject

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2019-07-03 08:35:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_permission_permission` (`permission`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'user:create', '用户模块新增', '1');
INSERT INTO `sys_permission` VALUES ('2', 'user:delete', '用户模块删除', '1');
INSERT INTO `sys_permission` VALUES ('3', 'menu:create', '菜单模块新增', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_role_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员', '1');
INSERT INTO `sys_role` VALUES ('2', 'user', '用户管理员', '1');
INSERT INTO `sys_role` VALUES ('3', 'demo', '普通用户', '0');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `role_permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3', '3');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '4');
INSERT INTO `sys_role_permission` VALUES ('3', '2', '5');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'fa0dcee1ab20e398bfc3c5d0fcc8e750', '155de6686f73c2062d30e25290d9c55f', '0');
INSERT INTO `sys_user` VALUES ('2', 'li', 'ab7e374b92d9d750dca09c0e81219d9e', '6939d7822daf8055ed9a8d4c5ea56384', '0');
INSERT INTO `sys_user` VALUES ('3', 'wu', '3b0c036b12d2f1c9315edd1820882c81', 'a1fbbfb550f18d620f0fb54d33e8fae4', '0');
INSERT INTO `sys_user` VALUES ('4', 'wang', 'bad6551650660c5838d2fde999205141', '0d942b1179c069c0e9eb3f235335b939', '1');
INSERT INTO `sys_user` VALUES ('6', 'test', null, null, null);
INSERT INTO `sys_user` VALUES ('8', 'test11', '6285950bfff4674e8935f1ac2ef37da8', 'e5ae6cfc202ce5b29e13a9411b04eab3', '0');
INSERT INTO `sys_user` VALUES ('9', 'test112', 'c755a030982c60383e1e934d62a3f2a6', 'dac73f21fb744684544e87c6f1ffa897', '0');
INSERT INTO `sys_user` VALUES ('10', 'test113', 'f3d963cd4469a4ae30ddf18dfe3f5282', 'e20f198c91e675e51a0edbad44e134e2', '0');
INSERT INTO `sys_user` VALUES ('11', 'test114', '2d6f64a03fffb96d16b878bd4dd76634', '0a75d33ef4fc20bad7469851a1af4f82', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `user_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '3', '3');
INSERT INTO `sys_user_role` VALUES ('9', '1', '4');

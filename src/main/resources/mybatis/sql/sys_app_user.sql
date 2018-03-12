/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : yfzero

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-03-09 16:46:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_app_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_user`;
CREATE TABLE `sys_app_user` (
  `user_id` varchar(32) NOT NULL DEFAULT '0' COMMENT '用户账号id',
  `account` varchar(20) NOT NULL COMMENT '账号id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(255) DEFAULT NULL,
  `rights` varchar(255) DEFAULT NULL COMMENT '权限',
  `role_id` varchar(100) DEFAULT NULL COMMENT '角色',
  `last_login` varchar(255) DEFAULT NULL COMMENT '上次登录',
  `ip` varchar(100) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL COMMENT '用户状态',
  `bz` varchar(255) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL COMMENT '手机',
  `sfid` varchar(100) DEFAULT NULL,
  `start_time` varchar(100) DEFAULT NULL,
  `end_time` varchar(100) DEFAULT NULL,
  `years` int(10) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `headImgUrl` varchar(255) DEFAULT NULL COMMENT '头像',
  `weixin_open_id` varchar(100) DEFAULT NULL,
  `reading_protocol` int(11) DEFAULT '0',
  `integral` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '积分',
  `community_id` varchar(32) DEFAULT NULL COMMENT '社区id',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `usernick` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `img_src_z` varchar(250) DEFAULT NULL COMMENT '正面照片地址',
  `img_src_f` varchar(250) DEFAULT NULL COMMENT '背面地址',
  `if_audit` int(2) DEFAULT NULL COMMENT ' 0 未认证  1 已认证成功   2 认证中 3  认证失败',
  `is_lawyer` int(2) unsigned DEFAULT NULL COMMENT '是否 律师  1是   0不是',
  `nim_token` varchar(32) DEFAULT NULL COMMENT 'nim连接时的token',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_app_user
-- ----------------------------
INSERT INTO `sys_app_user` VALUES ('06d72998621447fe9ea0b763732e356b', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('c032071fd7c14c7bb166800c3f37b47b', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('d7d5409fe4904d6a942612559a59cbd4', '16494334', 'jinghan', 'da162afc2db69c74ef32897d8acc95d0261df99f', '小韩', null, null, '2018-02-09 11:21:30', null, '1', null, '18048052209', null, null, null, '0', null, null, null, null, '0', '00000000000', '1', '0', '客官xhg364943345858', null, null, '0', '1', null);

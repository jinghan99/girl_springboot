/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : yfzero

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-04-11 16:48:24
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
INSERT INTO `sys_app_user` VALUES ('01c49b143a3f4f1f99df905617dc5063', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('03969f81ec68458095a6d1e5f3d82800', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('0616ca3b360b429eb320d4262ee3f528', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('06d72998621447fe9ea0b763732e356b', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('0b2f0062f1ff414fa5d50c624ef15c09', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('0dd7d9757144489e99c4bfeaadeb5002', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('15d462c6824f473d9175cc070c6d8cbc', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('198858b7a279422cbd7645c34164d713', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('1acc939de825435aaa0c2774dac3b1a3', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('1bb03f0e184045739cfcc44436662f44', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('1e37cf79eb234c02ba761dcce5d06269', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('22b306ba09494c8b8561ccfef19bb835', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('2348a7fbd8a143aeaed2d31cda3348f1', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('2387b3df307a44d985020ed3c0c9d79e', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('2748222608474da2ba8b5c8455b9b205', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('2c910fa15c2d4ef4b19d45ba685e9bc1', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('33648448cb03428b8dfce601e4af3c70', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('350a140a53b9488e935c149c42820b45', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('37ca489d93704cd5b98f0effc921206d', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('48b5978280da4e12910758168497cfbf', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('672ea6bfd72f487c99ad27749c958ad9', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('6d483475f4fe4fbaa7f442d5c0965324', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('6d607e8a54bb4cfb859fba8f766e054b', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('6f0deee22fb3406da430d319063cee6c', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('72065e621a094aef9ea779792965e1fe', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('72950c856d7f4e928b4a1ef943fb2147', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('823862eb17144dc9997f54e0bc7aa791', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('83b77f6d7283480eba43e15760ac9c09', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('8bddef69c3e04874b425fa4eaef08ab0', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('9bbe8272439e45ca97ff3af193a2e2e6', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('a2b78e4a611243cbb2c6f5477bd14290', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('b157ffc4774f4f57b84bb8ef9b0c5652', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('b931c09f842f41dc97412e96ba8ef034', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('ba5e5755ccc34cf9ba684179867fece6', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('bcab89803e0a4265b17f3842b8fee8f2', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('c032071fd7c14c7bb166800c3f37b47b', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('c366d8a23ecc49c48c9abb2360e6c446', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('c9d657fcdef14b97924033ab62849050', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('cab9e88e6e43433787cae4d8f10206e9', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('cbda2e3db56949bab33f45f148a24927', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('d644292e5eae48e6b978e9bb825a6e10', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('d7d5409fe4904d6a942612559a59cbd4', '16494334', 'jinghan', 'da162afc2db69c74ef32897d8acc95d0261df99f', '小韩', null, null, '2018-02-09 11:21:30', null, '1', null, '18048052209', null, null, null, '0', null, null, null, null, '0', '00000000000', '1', '0', '客官xhg364943345858', null, null, '0', '1', null);
INSERT INTO `sys_app_user` VALUES ('dfd6fada157245b096690f9e96ed8221', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('e5dd93f67c5d45ac9b7d77b9f723b000', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('e67b199a571b47d289ab04bedf6d6da1', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('e75aa0204f124cf2bfb2171e5bc0952d', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('e93540c1f68a4efc9c0164db4406a77d', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('eb01e1c3b94842d4a1fa9f5d2adf1332', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('efe8e4af390e492b8e5450a6fda80ed7', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('f1522f806c8642dc9bc6967d4725a24c', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('f24567099698499a80d5a43b6337dc4b', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('f3e3a54e0c954d169990ac31d0185272', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('f88f551320b14c96af0452ecb8faf80c', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('fa4363d822ab42fa8c3fb7be31925bbb', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('fb511980679244c09e54e436e78c55b6', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('fd5b641d24054262af4b654d7cd80a09', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('fdbfa62b7fb343bbb5364412794f1995', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);
INSERT INTO `sys_app_user` VALUES ('fe252d3eab4744e5b815daced2404abd', '12345', 'jinghan', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '00000000000', null, null, null, null, null, '0', null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(100) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rights` varchar(255) DEFAULT NULL,
  `role_id` varchar(100) DEFAULT NULL,
  `last_login` varchar(255) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  `bz` varchar(255) DEFAULT NULL,
  `skin` varchar(100) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `community_id` varchar(32) DEFAULT NULL COMMENT '社区id',
  `app_user_id` varchar(32) DEFAULT NULL COMMENT '关联appuserid',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'de41b7fb99201d8334c23c014db35ecd92df81bc', '系统管理员', '1133671055321055258374707980945218933803269864762743594642571294', '1', '2018-02-02 18:09:28', '0:0:0:0:0:0:0:1', '0', '最高统治者', 'default', 'admin@main.com', '001', '18788888888', null, '972cb473e3264ab19cde4dc319ebde44');
INSERT INTO `sys_user` VALUES ('838f23be657d4eafa140e7f2fa4c4a7a', 'sqgly', 'f187dcf839a91fbbb19b8d1e76e3d4a7887a9a88', '社区管理员', '', '5bad0b85744c4ffabf2933a025f0c2a9', '2018-02-02 14:33:47', '', '0', '', 'default', 'jinghan94@qq.com', '1001', '18048052202', null, '3406da9c8fe54a50a5f768759d0adf19');

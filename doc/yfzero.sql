/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : yfzero

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-07-12 15:16:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('quartzScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('quartzScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('quartzScheduler', 'jinghan1531379675876', '1531379786231', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for quartz_job
-- ----------------------------
DROP TABLE IF EXISTS `quartz_job`;
CREATE TABLE `quartz_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'Spring Bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态，0：暂停，1：正常',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of quartz_job
-- ----------------------------

-- ----------------------------
-- Table structure for quartz_job_log
-- ----------------------------
DROP TABLE IF EXISTS `quartz_job_log`;
CREATE TABLE `quartz_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态 0：失败 1：成功',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of quartz_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `type` int(11) DEFAULT NULL COMMENT '日志类型 1-登录 2-访问 3-操作 4-异常 5-授权',
  `user_id` bigint(20) DEFAULT NULL COMMENT '操作用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '操作用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '调用方法',
  `params` varchar(5000) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL COMMENT '操作ip地址',
  `result` tinyint(255) DEFAULT NULL COMMENT '操作结果 1-成功 2-失败',
  `remark` varchar(500) DEFAULT NULL COMMENT '操作描述',
  `gmt_create` datetime DEFAULT NULL COMMENT '操作时间',
  `time` bigint(20) DEFAULT NULL COMMENT '耗时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', null, '-1', '获取用户信息为空', '登录', 'com.yf.sys.controller.SysLoginController.login()', '\"admin\"', '0:0:0:0:0:0:0:1', null, null, '2018-07-12 15:14:54', '108');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, '', '0', 'fa fa-coffee', '0', '2017-08-09 22:49:47', '2017-10-26 10:03:40');
INSERT INTO `sys_menu` VALUES ('2', '1', '系统菜单', 'base/menu/list.html', null, '1', 'fa fa-th-list', '1', '2017-08-09 22:55:15', '2017-08-17 10:00:12');
INSERT INTO `sys_menu` VALUES ('3', '0', '组织机构', null, null, '0', 'fa fa-desktop', '1', '2017-08-09 23:06:55', '2017-08-17 09:54:28');
INSERT INTO `sys_menu` VALUES ('4', '1', '通用字典', 'base/macro/list.html', null, '1', 'fa fa-book', '2', '2017-08-09 23:06:58', '2017-08-17 10:00:24');
INSERT INTO `sys_menu` VALUES ('6', '3', '用户管理', 'base/user/list.html', null, '1', 'fa fa-user', '2', '2017-08-10 14:12:11', '2017-08-17 09:57:40');
INSERT INTO `sys_menu` VALUES ('7', '3', '角色管理', 'base/role/list.html', null, '1', 'fa fa-paw', '1', '2017-08-10 14:13:19', '2017-08-17 09:57:32');
INSERT INTO `sys_menu` VALUES ('11', '6', '刷新', null, 'sys:user:list', '2', null, '0', '2017-08-14 10:51:05', null);
INSERT INTO `sys_menu` VALUES ('12', '6', '新增', null, 'sys:user:save', '2', null, '0', '2017-08-14 10:51:35', null);
INSERT INTO `sys_menu` VALUES ('13', '6', '编辑', null, 'sys:user:edit', '2', null, '0', '2017-08-14 10:52:06', null);
INSERT INTO `sys_menu` VALUES ('14', '6', '删除', null, 'sys:user:remove', '2', null, '0', '2017-08-14 10:52:24', null);
INSERT INTO `sys_menu` VALUES ('15', '7', '刷新', null, 'sys:role:list', '2', null, '0', '2017-08-14 10:56:37', null);
INSERT INTO `sys_menu` VALUES ('16', '7', '新增', null, 'sys:role:save', '2', null, '0', '2017-08-14 10:57:02', null);
INSERT INTO `sys_menu` VALUES ('17', '7', '编辑', null, 'sys:role:edit', '2', null, '0', '2017-08-14 10:57:31', '2017-08-17 14:28:27');
INSERT INTO `sys_menu` VALUES ('18', '7', '删除', null, 'sys:role:remove', '2', null, '0', '2017-08-14 10:57:50', null);
INSERT INTO `sys_menu` VALUES ('19', '7', '操作权限', null, 'sys:role:authorizeOpt', '2', null, '0', '2017-08-14 10:58:55', '2017-08-17 13:48:54');
INSERT INTO `sys_menu` VALUES ('20', '2', '刷新', null, 'sys:menu:list', '2', null, '0', '2017-08-14 10:59:32', null);
INSERT INTO `sys_menu` VALUES ('21', '2', '新增', null, 'sys:menu:save', '2', null, '0', '2017-08-14 10:59:56', null);
INSERT INTO `sys_menu` VALUES ('22', '2', '编辑', null, 'sys:menu:edit', '2', null, '0', '2017-08-14 11:00:26', null);
INSERT INTO `sys_menu` VALUES ('23', '2', '删除', null, 'sys:menu:remove', '2', null, '0', '2017-08-14 11:00:58', null);
INSERT INTO `sys_menu` VALUES ('24', '6', '启用', null, 'sys:user:enable', '2', null, '0', '2017-08-14 17:27:18', null);
INSERT INTO `sys_menu` VALUES ('25', '6', '停用', null, 'sys:user:disable', '2', null, '0', '2017-08-14 17:27:43', null);
INSERT INTO `sys_menu` VALUES ('26', '6', '重置密码', null, 'sys:user:resetPassword', '2', null, '0', '2017-08-14 17:28:34', null);
INSERT INTO `sys_menu` VALUES ('27', '1', '系统日志', 'base/log/list.html', null, '1', 'fa fa-warning', '3', '2017-08-14 22:11:53', '2017-08-17 09:55:19');
INSERT INTO `sys_menu` VALUES ('28', '27', '刷新', null, 'sys:log:list', '2', null, '0', '2017-08-14 22:30:22', null);
INSERT INTO `sys_menu` VALUES ('29', '27', '删除', null, 'sys:log:remove', '2', null, '0', '2017-08-14 22:30:43', null);
INSERT INTO `sys_menu` VALUES ('30', '27', '清空', null, 'sys:log:clear', '2', null, '0', '2017-08-14 22:31:02', null);
INSERT INTO `sys_menu` VALUES ('32', '4', '刷新', null, 'sys:macro:list', '2', null, '0', '2017-08-15 16:55:33', null);
INSERT INTO `sys_menu` VALUES ('33', '4', '新增', null, 'sys:macro:save', '2', null, '0', '2017-08-15 16:55:52', null);
INSERT INTO `sys_menu` VALUES ('34', '4', '编辑', null, 'sys:macro:edit', '2', null, '0', '2017-08-15 16:56:09', null);
INSERT INTO `sys_menu` VALUES ('35', '4', '删除', null, 'sys:macro:remove', '2', null, '0', '2017-08-15 16:56:29', null);
INSERT INTO `sys_menu` VALUES ('36', '3', '机构管理', 'base/org/list.html', null, '1', 'fa fa-sitemap', '0', '2017-08-17 09:57:14', null);
INSERT INTO `sys_menu` VALUES ('37', '1', '行政区域', 'base/area/list.html', null, '1', 'fa fa-leaf', '0', '2017-08-17 09:59:57', null);
INSERT INTO `sys_menu` VALUES ('38', '37', '刷新', null, 'sys:area:list', '2', null, '0', '2017-08-17 10:01:33', '2017-08-17 10:01:52');
INSERT INTO `sys_menu` VALUES ('39', '37', '新增', null, 'sys:area:save', '2', null, '0', '2017-08-17 10:02:16', null);
INSERT INTO `sys_menu` VALUES ('40', '37', '编辑', null, 'sys:area:edit', '2', null, '0', '2017-08-17 10:02:33', null);
INSERT INTO `sys_menu` VALUES ('41', '37', '删除', null, 'sys:area:remove', '2', null, '0', '2017-08-17 10:02:50', null);
INSERT INTO `sys_menu` VALUES ('42', '36', '刷新', null, 'sys:org:list', '2', null, '0', '2017-08-17 10:03:36', null);
INSERT INTO `sys_menu` VALUES ('43', '36', '新增', null, 'sys:org:save', '2', null, '0', '2017-08-17 10:03:54', null);
INSERT INTO `sys_menu` VALUES ('44', '36', '编辑', null, 'sys:org:edit', '2', null, '0', '2017-08-17 10:04:11', null);
INSERT INTO `sys_menu` VALUES ('45', '36', '删除', null, 'sys:org:remove', '2', null, '0', '2017-08-17 10:04:30', null);
INSERT INTO `sys_menu` VALUES ('46', '7', '数据权限', null, 'sys:role:authorizeData', '2', null, '0', '2017-08-17 13:48:11', null);
INSERT INTO `sys_menu` VALUES ('47', '1', '定时任务', 'base/quartz/list.html', null, '1', 'fa fa-bell', '4', '2017-08-19 23:00:08', null);
INSERT INTO `sys_menu` VALUES ('48', '47', '刷新', null, 'quartz:job:list', '2', null, '0', '2017-08-19 23:00:54', null);
INSERT INTO `sys_menu` VALUES ('49', '47', '新增', null, 'quartz:job:save', '2', null, '0', '2017-08-19 23:01:29', null);
INSERT INTO `sys_menu` VALUES ('50', '47', '编辑', null, 'quartz:job:edit', '2', null, '0', '2017-08-19 23:01:58', null);
INSERT INTO `sys_menu` VALUES ('51', '47', '删除', null, 'quartz:job:remove', '2', null, '0', '2017-08-19 23:02:30', null);
INSERT INTO `sys_menu` VALUES ('52', '68', '启用', null, 'quartz:job:enable', '2', null, '0', '2017-08-19 23:08:59', '2017-09-14 16:53:00');
INSERT INTO `sys_menu` VALUES ('53', '68', '停用', null, 'quartz:job:disable', '2', null, '0', '2017-08-19 23:09:31', '2017-09-14 16:53:14');
INSERT INTO `sys_menu` VALUES ('54', '68', '立即执行', null, 'quartz:job:run', '2', null, '0', '2017-08-19 23:10:09', '2017-09-14 16:53:30');
INSERT INTO `sys_menu` VALUES ('55', '47', '日志列表', null, 'quartz:job:log', '1', null, '0', '2017-08-19 23:10:40', '2017-09-14 16:53:43');
INSERT INTO `sys_menu` VALUES ('56', '55', '刷新', null, 'quartz:log:list', '2', null, '0', '2017-08-21 13:25:33', '2017-09-14 16:53:57');
INSERT INTO `sys_menu` VALUES ('57', '55', '删除', null, 'quartz:log:remove', '2', null, '0', '2017-08-21 13:25:52', '2017-09-14 16:54:12');
INSERT INTO `sys_menu` VALUES ('58', '55', '清空', null, 'quartz:log:clear', '2', null, '0', '2017-08-21 13:26:11', '2017-09-14 16:54:24');
INSERT INTO `sys_menu` VALUES ('59', '1', '敏捷开发', 'base/generator/list.html', null, '1', 'fa fa-archive', '5', '2017-09-05 09:44:44', null);
INSERT INTO `sys_menu` VALUES ('60', '59', '刷新', null, 'sys:gen:list', '2', null, '0', '2017-09-05 09:45:10', null);
INSERT INTO `sys_menu` VALUES ('61', '59', '生成代码', null, 'sys:gen:code', '2', null, '0', '2017-09-05 09:45:29', null);
INSERT INTO `sys_menu` VALUES ('67', '1', '系统监控', 'druid/index.html', '', '1', 'fa fa-bug', '6', '2017-09-05 14:47:41', '2017-09-05 14:49:45');
INSERT INTO `sys_menu` VALUES ('68', '47', '更多', null, 'quartz:job:more', '1', null, '0', '2017-09-14 16:52:45', null);

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `org_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '机构id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
  `code` varchar(100) DEFAULT NULL COMMENT '机构编码',
  `name` varchar(100) DEFAULT NULL COMMENT '机构名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `status` tinyint(4) DEFAULT '1' COMMENT '可用标识  1：可用  0：不可用',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='机构管理';

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('1', '0', 'js', '江苏省', '0', '1', '2017-08-17 12:03:15', '2017-08-17 17:06:08');
INSERT INTO `sys_org` VALUES ('2', '1', 'nj', '南京市', '0', '1', '2017-08-17 12:03:43', null);
INSERT INTO `sys_org` VALUES ('3', '2', 'gc', '高淳区', '0', '1', '2017-08-17 12:04:47', null);
INSERT INTO `sys_org` VALUES ('4', '3', 'syxx', '高淳区实验小学', '0', '1', '2017-08-17 12:05:31', null);
INSERT INTO `sys_org` VALUES ('5', '4', 'syxx01', '一年级', '0', '1', '2017-08-17 12:06:35', null);
INSERT INTO `sys_org` VALUES ('6', '4', 'syxx02', '二年级', '1', '1', '2017-08-17 12:06:37', null);
INSERT INTO `sys_org` VALUES ('7', '4', 'syxx03', '三年级', '2', '1', '2017-08-17 12:06:41', null);
INSERT INTO `sys_org` VALUES ('9', '5', 'syxx0102', '二班', '1', '1', '2017-08-17 12:07:39', null);
INSERT INTO `sys_org` VALUES ('10', '5', 'syxx0103', '三班', '2', '1', '2017-08-17 12:07:41', null);
INSERT INTO `sys_org` VALUES ('11', '6', 'syxx0201', '一班', '0', '1', '2017-08-17 12:08:56', null);
INSERT INTO `sys_org` VALUES ('12', '6', 'syxx0202', '二班', '1', '1', '2017-08-17 12:08:59', null);
INSERT INTO `sys_org` VALUES ('13', '6', 'syxx0203', '三班', '2', '1', '2017-08-17 12:09:03', null);
INSERT INTO `sys_org` VALUES ('14', '7', 'syxx0301', '一班', '0', '1', '2017-08-17 12:09:05', null);
INSERT INTO `sys_org` VALUES ('15', '7', 'syxx0302', '二班', '1', '1', '2017-08-17 12:09:08', null);
INSERT INTO `sys_org` VALUES ('16', '7', 'syxx0303', '三班', '2', '1', '2017-08-17 12:09:10', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `org_id` bigint(255) DEFAULT NULL COMMENT '所属机构',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_sign` varchar(100) DEFAULT NULL COMMENT '角色标识',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `user_id_create` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '超级管理员', 'admin', '【系统内置】', '2', '2017-08-12 00:43:52', '2017-08-12 19:14:59');
INSERT INTO `sys_role` VALUES ('39', '3', '测试用户', 'test', null, '1', '2017-08-17 19:41:15', '2017-08-17 19:42:39');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1066 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1008', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('1009', '1', '37');
INSERT INTO `sys_role_menu` VALUES ('1010', '1', '38');
INSERT INTO `sys_role_menu` VALUES ('1011', '1', '39');
INSERT INTO `sys_role_menu` VALUES ('1012', '1', '40');
INSERT INTO `sys_role_menu` VALUES ('1013', '1', '41');
INSERT INTO `sys_role_menu` VALUES ('1014', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('1015', '1', '20');
INSERT INTO `sys_role_menu` VALUES ('1016', '1', '21');
INSERT INTO `sys_role_menu` VALUES ('1017', '1', '22');
INSERT INTO `sys_role_menu` VALUES ('1018', '1', '23');
INSERT INTO `sys_role_menu` VALUES ('1019', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('1020', '1', '32');
INSERT INTO `sys_role_menu` VALUES ('1021', '1', '33');
INSERT INTO `sys_role_menu` VALUES ('1022', '1', '34');
INSERT INTO `sys_role_menu` VALUES ('1023', '1', '35');
INSERT INTO `sys_role_menu` VALUES ('1024', '1', '27');
INSERT INTO `sys_role_menu` VALUES ('1025', '1', '28');
INSERT INTO `sys_role_menu` VALUES ('1026', '1', '29');
INSERT INTO `sys_role_menu` VALUES ('1027', '1', '30');
INSERT INTO `sys_role_menu` VALUES ('1028', '1', '47');
INSERT INTO `sys_role_menu` VALUES ('1029', '1', '48');
INSERT INTO `sys_role_menu` VALUES ('1030', '1', '49');
INSERT INTO `sys_role_menu` VALUES ('1031', '1', '50');
INSERT INTO `sys_role_menu` VALUES ('1032', '1', '51');
INSERT INTO `sys_role_menu` VALUES ('1033', '1', '55');
INSERT INTO `sys_role_menu` VALUES ('1034', '1', '56');
INSERT INTO `sys_role_menu` VALUES ('1035', '1', '57');
INSERT INTO `sys_role_menu` VALUES ('1036', '1', '58');
INSERT INTO `sys_role_menu` VALUES ('1037', '1', '68');
INSERT INTO `sys_role_menu` VALUES ('1038', '1', '52');
INSERT INTO `sys_role_menu` VALUES ('1039', '1', '53');
INSERT INTO `sys_role_menu` VALUES ('1040', '1', '54');
INSERT INTO `sys_role_menu` VALUES ('1041', '1', '59');
INSERT INTO `sys_role_menu` VALUES ('1042', '1', '60');
INSERT INTO `sys_role_menu` VALUES ('1043', '1', '61');
INSERT INTO `sys_role_menu` VALUES ('1044', '1', '67');
INSERT INTO `sys_role_menu` VALUES ('1045', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('1046', '1', '36');
INSERT INTO `sys_role_menu` VALUES ('1047', '1', '42');
INSERT INTO `sys_role_menu` VALUES ('1048', '1', '43');
INSERT INTO `sys_role_menu` VALUES ('1049', '1', '44');
INSERT INTO `sys_role_menu` VALUES ('1050', '1', '45');
INSERT INTO `sys_role_menu` VALUES ('1051', '1', '7');
INSERT INTO `sys_role_menu` VALUES ('1052', '1', '15');
INSERT INTO `sys_role_menu` VALUES ('1053', '1', '16');
INSERT INTO `sys_role_menu` VALUES ('1054', '1', '17');
INSERT INTO `sys_role_menu` VALUES ('1055', '1', '18');
INSERT INTO `sys_role_menu` VALUES ('1056', '1', '19');
INSERT INTO `sys_role_menu` VALUES ('1057', '1', '46');
INSERT INTO `sys_role_menu` VALUES ('1058', '1', '6');
INSERT INTO `sys_role_menu` VALUES ('1059', '1', '11');
INSERT INTO `sys_role_menu` VALUES ('1060', '1', '12');
INSERT INTO `sys_role_menu` VALUES ('1061', '1', '13');
INSERT INTO `sys_role_menu` VALUES ('1062', '1', '14');
INSERT INTO `sys_role_menu` VALUES ('1063', '1', '24');
INSERT INTO `sys_role_menu` VALUES ('1064', '1', '25');
INSERT INTO `sys_role_menu` VALUES ('1065', '1', '26');

-- ----------------------------
-- Table structure for sys_role_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_org`;
CREATE TABLE `sys_role_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `org_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色与机构对应关系';

-- ----------------------------
-- Records of sys_role_org
-- ----------------------------
INSERT INTO `sys_role_org` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `org_id` bigint(255) DEFAULT NULL COMMENT '所属机构',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(255) DEFAULT NULL COMMENT '状态 0:禁用，1:正常',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `user_id_create` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', 'admin', '33808479d49ca8a3cdc93d4f976d1e3d', 'admin@example.com', '123456', '1', null, '1', '2017-08-15 21:40:39', '2017-08-15 21:41:00');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `token` varchar(100) NOT NULL COMMENT 'token',
  `gmt_expire` datetime DEFAULT NULL COMMENT '过期时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('1', 'dcb2e9fabe0de0fa0a47a5848b523f9d', '2018-07-13 03:14:54', '2018-07-12 15:14:54');
INSERT INTO `sys_user_token` VALUES ('2', '5004cd9815f7b6e8ac8d831af7eb9324', '2017-09-05 04:04:34', '2017-09-04 16:04:34');

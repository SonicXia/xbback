/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : xiaobao

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2016-11-01 18:30:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `userName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `passwrod` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('admin', '123456');

-- ----------------------------
-- Table structure for tb_money
-- ----------------------------
DROP TABLE IF EXISTS `tb_money`;
CREATE TABLE `tb_money` (
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `mobile` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '手机号',
  `reward` double(20,2) NOT NULL COMMENT '当日应分红',
  `bonus` double(20,2) DEFAULT NULL COMMENT '当日应奖励',
  `releaseDate` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分红（奖励）日期',
  `isRewardRelease` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已分红（奖励）（0：未发；1已发）',
  `isBonusRelease` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已奖励（0：未发；1已发）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_money
-- ----------------------------
INSERT INTO `tb_money` VALUES ('张三', '13666666666', '189.00', '0.00', '2016-11-01', '1', '0');
INSERT INTO `tb_money` VALUES ('李四', '13999999999', '126.00', '0.00', '2016-11-01', '0', '0');
INSERT INTO `tb_money` VALUES ('王五', '13555555555', '630.00', '0.00', '2016-11-01', '0', '0');
INSERT INTO `tb_money` VALUES ('陈六', '15000000000', '63.00', '0.00', '2016-11-01', '0', '0');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `orderId` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '订单编号',
  `mobile` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '报单人身份证号',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `orderCnt` int(10) DEFAULT NULL COMMENT '投单数',
  `price` double(20,2) DEFAULT NULL COMMENT '每单金额',
  `amount` double(20,2) DEFAULT NULL COMMENT '投单总金额',
  `investmentDate` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '投单日期',
  `bonusAlready` double(20,2) DEFAULT NULL COMMENT '本次投单已累计奖励',
  `rewardAlready` double(20,2) DEFAULT NULL COMMENT '本次投单已累计分红',
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '收货地址',
  `remark` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `rewardMonths` int(11) DEFAULT NULL COMMENT '分红月数',
  `extraDays` int(11) DEFAULT NULL COMMENT '额外分红天数',
  `rewardDays` int(10) DEFAULT NULL COMMENT '总分红天数',
  `daysAlready` int(10) DEFAULT '0' COMMENT '已分红天数',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL COMMENT '修改时间',
  `orderStatus` tinyint(4) DEFAULT NULL COMMENT '订单状态（0：订单分红结束，关闭订单；1：正常分红）',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('B161021182434000', '13666666666', '张三', '3', '3300.00', '9900.00', '2016-10-01', '0.00', '189.00', '安徽合肥', '', '4', '10', '97', '1', '2016-10-21 18:24:34', '2016-10-21 18:24:34', '1');
INSERT INTO `tb_order` VALUES ('B161021182523001', '13999999999', '李四', '2', '3200.00', '6400.00', '2016-09-06', '0.00', '0.00', '安徽合肥', '', '4', '0', '87', '0', '2016-10-21 18:25:23', '2016-10-21 18:25:23', '1');
INSERT INTO `tb_order` VALUES ('B161021182641002', '13555555555', '王五', '6', '3200.00', '19200.00', '2016-07-07', '0.00', '0.00', '浙江杭州', '', '4', '0', '86', '0', '2016-10-21 18:26:41', '2016-10-21 18:26:41', '1');
INSERT INTO `tb_order` VALUES ('B161021182746003', '15000000000', '陈六', '1', '3200.00', '3200.00', '2016-08-21', '0.00', '0.00', '宁夏甘肃', '', '4', '3', '90', '0', '2016-10-21 18:27:46', '2016-10-21 18:27:46', '1');
INSERT INTO `tb_order` VALUES ('B161021182857004', '13555555555', '王五', '3', '3200.00', '9600.00', '2016-09-11', '0.00', '0.00', '浙江杭州', '', '4', '0', '87', '0', '2016-10-21 18:28:57', '2016-10-21 18:28:57', '1');
INSERT INTO `tb_order` VALUES ('B161021183034005', '13555555555', '王五', '1', '3200.00', '3200.00', '2016-08-18', '0.00', '0.00', '浙江杭州', '', '4', '3', '89', '0', '2016-10-21 18:30:34', '2016-10-21 18:30:34', '1');
INSERT INTO `tb_order` VALUES ('B161024164001000', '13555555555', '王五', '2', '3000.00', '6000.00', '2016-05-05', '0.00', '0.00', '浙江杭州', '', '4', '0', '86', '0', '2016-10-24 16:40:01', '2016-10-24 16:40:01', '0');

-- ----------------------------
-- Table structure for tb_team
-- ----------------------------
DROP TABLE IF EXISTS `tb_team`;
CREATE TABLE `tb_team` (
  `teamId` int(10) NOT NULL COMMENT '团队id',
  `teamName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '团队名称',
  `teamLeaderId` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '团队领导身份证号',
  `leaderName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '团队领导姓名',
  `number` int(10) DEFAULT NULL COMMENT '团队人数',
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '团队说明',
  PRIMARY KEY (`teamId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_team
-- ----------------------------
INSERT INTO `tb_team` VALUES ('1', '江苏团队', '34011111111111111X', '缤文', '108', null);
INSERT INTO `tb_team` VALUES ('2', '福建团队', '35022222222222222X', '福建总代', '98', null);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `cardId` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '身份证号',
  `mobile` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '手机号',
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录密码',
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电子邮件',
  `totalCnt` int(10) DEFAULT NULL COMMENT '总投单数',
  `isActive` tinyint(1) DEFAULT NULL COMMENT '代理状态（0：未激活；1：已激活）',
  `isBlackList` tinyint(1) DEFAULT NULL COMMENT '黑名单状态（0：未被列入；1：已被列入）',
  `referralCnt` int(10) DEFAULT NULL COMMENT '已推荐人数（下线人数）',
  `referrer` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '推荐人姓名',
  `referrerMobile` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '推荐人手机号',
  `teamId` int(10) DEFAULT NULL COMMENT '所属团队id',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_mobile` (`mobile`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('12', '老王', '311111111111111110', '18888888888', null, null, '0', '1', '0', '5', null, '', '1', '2016-10-01 18:37:37', '2016-10-01 18:39:06');
INSERT INTO `tb_user` VALUES ('13', '张三', '340111111111111111', '13333333333', '', '', '3', '0', '0', '0', '老王', '18888888888', '1', '2016-10-21 18:37:37', '2016-10-27 01:12:49');
INSERT INTO `tb_user` VALUES ('14', '李四', '340111111111111112', '13999999999', '', '', '2', '1', '1', '0', '老王', '18888888888', '0', '2016-10-21 18:38:36', '2016-10-25 17:17:25');
INSERT INTO `tb_user` VALUES ('15', '王五', '340111111111111113', '13555555555', '', '', '12', '1', '0', '0', '老王', '18888888888', '1', '2016-10-21 18:38:51', '2016-10-21 18:38:51');
INSERT INTO `tb_user` VALUES ('16', '陈六', '340111111111111114', '15000000000', '', '', '1', '1', '0', '0', '老王', '18888888888', '1', '2016-10-21 18:39:06', '2016-10-21 18:39:06');
INSERT INTO `tb_user` VALUES ('20', '鬼脚七', '340111111111111117', '17000000000', '', '', '0', '1', '0', '0', '王五', '13555555555', '1', '2016-10-25 12:59:05', '2016-10-25 17:19:24');
INSERT INTO `tb_user` VALUES ('22', '八二哥', '341118888888888888', '13858558585', '', '', '0', '1', '0', '0', '老王', '18888888888', '1', '2016-10-25 13:16:09', '2016-10-25 13:16:09');
INSERT INTO `tb_user` VALUES ('23', '九筒', '340999999999999999', '19999999999', '', '', '0', '1', '0', '0', '张三', '13333333333', '1', '2016-10-25 16:52:59', '2016-10-25 16:52:59');

-- ----------------------------
-- Table structure for t_calendar
-- ----------------------------
DROP TABLE IF EXISTS `t_calendar`;
CREATE TABLE `t_calendar` (
  `date` date NOT NULL COMMENT '日期',
  `week` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_calendar
-- ----------------------------
INSERT INTO `t_calendar` VALUES ('2016-01-01', '0');
INSERT INTO `t_calendar` VALUES ('2016-01-02', '0');
INSERT INTO `t_calendar` VALUES ('2016-01-03', '0');
INSERT INTO `t_calendar` VALUES ('2016-01-04', '1');
INSERT INTO `t_calendar` VALUES ('2016-01-05', '1');
INSERT INTO `t_calendar` VALUES ('2016-01-06', '1');
INSERT INTO `t_calendar` VALUES ('2016-01-07', '1');
INSERT INTO `t_calendar` VALUES ('2016-01-08', '1');
INSERT INTO `t_calendar` VALUES ('2016-01-09', '1');
INSERT INTO `t_calendar` VALUES ('2016-01-10', '1');
INSERT INTO `t_calendar` VALUES ('2016-01-11', '2');
INSERT INTO `t_calendar` VALUES ('2016-01-12', '2');
INSERT INTO `t_calendar` VALUES ('2016-01-13', '2');
INSERT INTO `t_calendar` VALUES ('2016-01-14', '2');
INSERT INTO `t_calendar` VALUES ('2016-01-15', '2');
INSERT INTO `t_calendar` VALUES ('2016-01-16', '2');
INSERT INTO `t_calendar` VALUES ('2016-01-17', '2');
INSERT INTO `t_calendar` VALUES ('2016-01-18', '3');
INSERT INTO `t_calendar` VALUES ('2016-01-19', '3');
INSERT INTO `t_calendar` VALUES ('2016-01-20', '3');
INSERT INTO `t_calendar` VALUES ('2016-01-21', '3');
INSERT INTO `t_calendar` VALUES ('2016-01-22', '3');
INSERT INTO `t_calendar` VALUES ('2016-01-23', '3');
INSERT INTO `t_calendar` VALUES ('2016-01-24', '3');
INSERT INTO `t_calendar` VALUES ('2016-01-25', '4');
INSERT INTO `t_calendar` VALUES ('2016-01-26', '4');
INSERT INTO `t_calendar` VALUES ('2016-01-27', '4');
INSERT INTO `t_calendar` VALUES ('2016-01-28', '4');
INSERT INTO `t_calendar` VALUES ('2016-01-29', '4');
INSERT INTO `t_calendar` VALUES ('2016-01-30', '4');
INSERT INTO `t_calendar` VALUES ('2016-01-31', '4');
INSERT INTO `t_calendar` VALUES ('2016-02-01', '5');
INSERT INTO `t_calendar` VALUES ('2016-02-02', '5');
INSERT INTO `t_calendar` VALUES ('2016-02-03', '5');
INSERT INTO `t_calendar` VALUES ('2016-02-04', '5');
INSERT INTO `t_calendar` VALUES ('2016-02-05', '5');
INSERT INTO `t_calendar` VALUES ('2016-02-06', '5');
INSERT INTO `t_calendar` VALUES ('2016-02-07', '5');
INSERT INTO `t_calendar` VALUES ('2016-02-08', '6');
INSERT INTO `t_calendar` VALUES ('2016-02-09', '6');
INSERT INTO `t_calendar` VALUES ('2016-02-10', '6');
INSERT INTO `t_calendar` VALUES ('2016-02-11', '6');
INSERT INTO `t_calendar` VALUES ('2016-02-12', '6');
INSERT INTO `t_calendar` VALUES ('2016-02-13', '6');
INSERT INTO `t_calendar` VALUES ('2016-02-14', '6');
INSERT INTO `t_calendar` VALUES ('2016-02-15', '7');
INSERT INTO `t_calendar` VALUES ('2016-02-16', '7');
INSERT INTO `t_calendar` VALUES ('2016-02-17', '7');
INSERT INTO `t_calendar` VALUES ('2016-02-18', '7');
INSERT INTO `t_calendar` VALUES ('2016-02-19', '7');
INSERT INTO `t_calendar` VALUES ('2016-02-20', '7');
INSERT INTO `t_calendar` VALUES ('2016-02-21', '7');
INSERT INTO `t_calendar` VALUES ('2016-02-22', '8');
INSERT INTO `t_calendar` VALUES ('2016-02-23', '8');
INSERT INTO `t_calendar` VALUES ('2016-02-24', '8');
INSERT INTO `t_calendar` VALUES ('2016-02-25', '8');
INSERT INTO `t_calendar` VALUES ('2016-02-26', '8');
INSERT INTO `t_calendar` VALUES ('2016-02-27', '8');
INSERT INTO `t_calendar` VALUES ('2016-02-28', '8');
INSERT INTO `t_calendar` VALUES ('2016-02-29', '9');
INSERT INTO `t_calendar` VALUES ('2016-03-01', '9');
INSERT INTO `t_calendar` VALUES ('2016-03-02', '9');
INSERT INTO `t_calendar` VALUES ('2016-03-03', '9');
INSERT INTO `t_calendar` VALUES ('2016-03-04', '9');
INSERT INTO `t_calendar` VALUES ('2016-03-05', '9');
INSERT INTO `t_calendar` VALUES ('2016-03-06', '9');
INSERT INTO `t_calendar` VALUES ('2016-03-07', '10');
INSERT INTO `t_calendar` VALUES ('2016-03-08', '10');
INSERT INTO `t_calendar` VALUES ('2016-03-09', '10');
INSERT INTO `t_calendar` VALUES ('2016-03-10', '10');
INSERT INTO `t_calendar` VALUES ('2016-03-11', '10');
INSERT INTO `t_calendar` VALUES ('2016-03-12', '10');
INSERT INTO `t_calendar` VALUES ('2016-03-13', '10');
INSERT INTO `t_calendar` VALUES ('2016-03-14', '11');
INSERT INTO `t_calendar` VALUES ('2016-03-15', '11');
INSERT INTO `t_calendar` VALUES ('2016-03-16', '11');
INSERT INTO `t_calendar` VALUES ('2016-03-17', '11');
INSERT INTO `t_calendar` VALUES ('2016-03-18', '11');
INSERT INTO `t_calendar` VALUES ('2016-03-19', '11');
INSERT INTO `t_calendar` VALUES ('2016-03-20', '11');
INSERT INTO `t_calendar` VALUES ('2016-03-21', '12');
INSERT INTO `t_calendar` VALUES ('2016-03-22', '12');
INSERT INTO `t_calendar` VALUES ('2016-03-23', '12');
INSERT INTO `t_calendar` VALUES ('2016-03-24', '12');
INSERT INTO `t_calendar` VALUES ('2016-03-25', '12');
INSERT INTO `t_calendar` VALUES ('2016-03-26', '12');
INSERT INTO `t_calendar` VALUES ('2016-03-27', '12');
INSERT INTO `t_calendar` VALUES ('2016-03-28', '13');
INSERT INTO `t_calendar` VALUES ('2016-03-29', '13');
INSERT INTO `t_calendar` VALUES ('2016-03-30', '13');
INSERT INTO `t_calendar` VALUES ('2016-03-31', '13');
INSERT INTO `t_calendar` VALUES ('2016-04-01', '13');
INSERT INTO `t_calendar` VALUES ('2016-04-02', '13');
INSERT INTO `t_calendar` VALUES ('2016-04-03', '13');
INSERT INTO `t_calendar` VALUES ('2016-04-04', '14');
INSERT INTO `t_calendar` VALUES ('2016-04-05', '14');
INSERT INTO `t_calendar` VALUES ('2016-04-06', '14');
INSERT INTO `t_calendar` VALUES ('2016-04-07', '14');
INSERT INTO `t_calendar` VALUES ('2016-04-08', '14');
INSERT INTO `t_calendar` VALUES ('2016-04-09', '14');
INSERT INTO `t_calendar` VALUES ('2016-04-10', '14');
INSERT INTO `t_calendar` VALUES ('2016-04-11', '15');
INSERT INTO `t_calendar` VALUES ('2016-04-12', '15');
INSERT INTO `t_calendar` VALUES ('2016-04-13', '15');
INSERT INTO `t_calendar` VALUES ('2016-04-14', '15');
INSERT INTO `t_calendar` VALUES ('2016-04-15', '15');
INSERT INTO `t_calendar` VALUES ('2016-04-16', '15');
INSERT INTO `t_calendar` VALUES ('2016-04-17', '15');
INSERT INTO `t_calendar` VALUES ('2016-04-18', '16');
INSERT INTO `t_calendar` VALUES ('2016-04-19', '16');
INSERT INTO `t_calendar` VALUES ('2016-04-20', '16');
INSERT INTO `t_calendar` VALUES ('2016-04-21', '16');
INSERT INTO `t_calendar` VALUES ('2016-04-22', '16');
INSERT INTO `t_calendar` VALUES ('2016-04-23', '16');
INSERT INTO `t_calendar` VALUES ('2016-04-24', '16');
INSERT INTO `t_calendar` VALUES ('2016-04-25', '17');
INSERT INTO `t_calendar` VALUES ('2016-04-26', '17');
INSERT INTO `t_calendar` VALUES ('2016-04-27', '17');
INSERT INTO `t_calendar` VALUES ('2016-04-28', '17');
INSERT INTO `t_calendar` VALUES ('2016-04-29', '17');
INSERT INTO `t_calendar` VALUES ('2016-04-30', '17');
INSERT INTO `t_calendar` VALUES ('2016-05-01', '17');
INSERT INTO `t_calendar` VALUES ('2016-05-02', '18');
INSERT INTO `t_calendar` VALUES ('2016-05-03', '18');
INSERT INTO `t_calendar` VALUES ('2016-05-04', '18');
INSERT INTO `t_calendar` VALUES ('2016-05-05', '18');
INSERT INTO `t_calendar` VALUES ('2016-05-06', '18');
INSERT INTO `t_calendar` VALUES ('2016-05-07', '18');
INSERT INTO `t_calendar` VALUES ('2016-05-08', '18');
INSERT INTO `t_calendar` VALUES ('2016-05-09', '19');
INSERT INTO `t_calendar` VALUES ('2016-05-10', '19');
INSERT INTO `t_calendar` VALUES ('2016-05-11', '19');
INSERT INTO `t_calendar` VALUES ('2016-05-12', '19');
INSERT INTO `t_calendar` VALUES ('2016-05-13', '19');
INSERT INTO `t_calendar` VALUES ('2016-05-14', '19');
INSERT INTO `t_calendar` VALUES ('2016-05-15', '19');
INSERT INTO `t_calendar` VALUES ('2016-05-16', '20');
INSERT INTO `t_calendar` VALUES ('2016-05-17', '20');
INSERT INTO `t_calendar` VALUES ('2016-05-18', '20');
INSERT INTO `t_calendar` VALUES ('2016-05-19', '20');
INSERT INTO `t_calendar` VALUES ('2016-05-20', '20');
INSERT INTO `t_calendar` VALUES ('2016-05-21', '20');
INSERT INTO `t_calendar` VALUES ('2016-05-22', '20');
INSERT INTO `t_calendar` VALUES ('2016-05-23', '21');
INSERT INTO `t_calendar` VALUES ('2016-05-24', '21');
INSERT INTO `t_calendar` VALUES ('2016-05-25', '21');
INSERT INTO `t_calendar` VALUES ('2016-05-26', '21');
INSERT INTO `t_calendar` VALUES ('2016-05-27', '21');
INSERT INTO `t_calendar` VALUES ('2016-05-28', '21');
INSERT INTO `t_calendar` VALUES ('2016-05-29', '21');
INSERT INTO `t_calendar` VALUES ('2016-05-30', '22');
INSERT INTO `t_calendar` VALUES ('2016-05-31', '22');
INSERT INTO `t_calendar` VALUES ('2016-06-01', '22');
INSERT INTO `t_calendar` VALUES ('2016-06-02', '22');
INSERT INTO `t_calendar` VALUES ('2016-06-03', '22');
INSERT INTO `t_calendar` VALUES ('2016-06-04', '22');
INSERT INTO `t_calendar` VALUES ('2016-06-05', '22');
INSERT INTO `t_calendar` VALUES ('2016-06-06', '23');
INSERT INTO `t_calendar` VALUES ('2016-06-07', '23');
INSERT INTO `t_calendar` VALUES ('2016-06-08', '23');
INSERT INTO `t_calendar` VALUES ('2016-06-09', '23');
INSERT INTO `t_calendar` VALUES ('2016-06-10', '23');
INSERT INTO `t_calendar` VALUES ('2016-06-11', '23');
INSERT INTO `t_calendar` VALUES ('2016-06-12', '23');
INSERT INTO `t_calendar` VALUES ('2016-06-13', '24');
INSERT INTO `t_calendar` VALUES ('2016-06-14', '24');
INSERT INTO `t_calendar` VALUES ('2016-06-15', '24');
INSERT INTO `t_calendar` VALUES ('2016-06-16', '24');
INSERT INTO `t_calendar` VALUES ('2016-06-17', '24');
INSERT INTO `t_calendar` VALUES ('2016-06-18', '24');
INSERT INTO `t_calendar` VALUES ('2016-06-19', '24');
INSERT INTO `t_calendar` VALUES ('2016-06-20', '25');
INSERT INTO `t_calendar` VALUES ('2016-06-21', '25');
INSERT INTO `t_calendar` VALUES ('2016-06-22', '25');
INSERT INTO `t_calendar` VALUES ('2016-06-23', '25');
INSERT INTO `t_calendar` VALUES ('2016-06-24', '25');
INSERT INTO `t_calendar` VALUES ('2016-06-25', '25');
INSERT INTO `t_calendar` VALUES ('2016-06-26', '25');
INSERT INTO `t_calendar` VALUES ('2016-06-27', '26');
INSERT INTO `t_calendar` VALUES ('2016-06-28', '26');
INSERT INTO `t_calendar` VALUES ('2016-06-29', '26');
INSERT INTO `t_calendar` VALUES ('2016-06-30', '26');
INSERT INTO `t_calendar` VALUES ('2016-07-01', '26');
INSERT INTO `t_calendar` VALUES ('2016-07-02', '26');
INSERT INTO `t_calendar` VALUES ('2016-07-03', '26');
INSERT INTO `t_calendar` VALUES ('2016-07-04', '27');
INSERT INTO `t_calendar` VALUES ('2016-07-05', '27');
INSERT INTO `t_calendar` VALUES ('2016-07-06', '27');
INSERT INTO `t_calendar` VALUES ('2016-07-07', '27');
INSERT INTO `t_calendar` VALUES ('2016-07-08', '27');
INSERT INTO `t_calendar` VALUES ('2016-07-09', '27');
INSERT INTO `t_calendar` VALUES ('2016-07-10', '27');
INSERT INTO `t_calendar` VALUES ('2016-07-11', '28');
INSERT INTO `t_calendar` VALUES ('2016-07-12', '28');
INSERT INTO `t_calendar` VALUES ('2016-07-13', '28');
INSERT INTO `t_calendar` VALUES ('2016-07-14', '28');
INSERT INTO `t_calendar` VALUES ('2016-07-15', '28');
INSERT INTO `t_calendar` VALUES ('2016-07-16', '28');
INSERT INTO `t_calendar` VALUES ('2016-07-17', '28');
INSERT INTO `t_calendar` VALUES ('2016-07-18', '29');
INSERT INTO `t_calendar` VALUES ('2016-07-19', '29');
INSERT INTO `t_calendar` VALUES ('2016-07-20', '29');
INSERT INTO `t_calendar` VALUES ('2016-07-21', '29');
INSERT INTO `t_calendar` VALUES ('2016-07-22', '29');
INSERT INTO `t_calendar` VALUES ('2016-07-23', '29');
INSERT INTO `t_calendar` VALUES ('2016-07-24', '29');
INSERT INTO `t_calendar` VALUES ('2016-07-25', '30');
INSERT INTO `t_calendar` VALUES ('2016-07-26', '30');
INSERT INTO `t_calendar` VALUES ('2016-07-27', '30');
INSERT INTO `t_calendar` VALUES ('2016-07-28', '30');
INSERT INTO `t_calendar` VALUES ('2016-07-29', '30');
INSERT INTO `t_calendar` VALUES ('2016-07-30', '30');
INSERT INTO `t_calendar` VALUES ('2016-07-31', '30');
INSERT INTO `t_calendar` VALUES ('2016-08-01', '31');
INSERT INTO `t_calendar` VALUES ('2016-08-02', '31');
INSERT INTO `t_calendar` VALUES ('2016-08-03', '31');
INSERT INTO `t_calendar` VALUES ('2016-08-04', '31');
INSERT INTO `t_calendar` VALUES ('2016-08-05', '31');
INSERT INTO `t_calendar` VALUES ('2016-08-06', '31');
INSERT INTO `t_calendar` VALUES ('2016-08-07', '31');
INSERT INTO `t_calendar` VALUES ('2016-08-08', '32');
INSERT INTO `t_calendar` VALUES ('2016-08-09', '32');
INSERT INTO `t_calendar` VALUES ('2016-08-10', '32');
INSERT INTO `t_calendar` VALUES ('2016-08-11', '32');
INSERT INTO `t_calendar` VALUES ('2016-08-12', '32');
INSERT INTO `t_calendar` VALUES ('2016-08-13', '32');
INSERT INTO `t_calendar` VALUES ('2016-08-14', '32');
INSERT INTO `t_calendar` VALUES ('2016-08-15', '33');
INSERT INTO `t_calendar` VALUES ('2016-08-16', '33');
INSERT INTO `t_calendar` VALUES ('2016-08-17', '33');
INSERT INTO `t_calendar` VALUES ('2016-08-18', '33');
INSERT INTO `t_calendar` VALUES ('2016-08-19', '33');
INSERT INTO `t_calendar` VALUES ('2016-08-20', '33');
INSERT INTO `t_calendar` VALUES ('2016-08-21', '33');
INSERT INTO `t_calendar` VALUES ('2016-08-22', '34');
INSERT INTO `t_calendar` VALUES ('2016-08-23', '34');
INSERT INTO `t_calendar` VALUES ('2016-08-24', '34');
INSERT INTO `t_calendar` VALUES ('2016-08-25', '34');
INSERT INTO `t_calendar` VALUES ('2016-08-26', '34');
INSERT INTO `t_calendar` VALUES ('2016-08-27', '34');
INSERT INTO `t_calendar` VALUES ('2016-08-28', '34');
INSERT INTO `t_calendar` VALUES ('2016-08-29', '35');
INSERT INTO `t_calendar` VALUES ('2016-08-30', '35');
INSERT INTO `t_calendar` VALUES ('2016-08-31', '35');
INSERT INTO `t_calendar` VALUES ('2016-09-01', '35');
INSERT INTO `t_calendar` VALUES ('2016-09-02', '35');
INSERT INTO `t_calendar` VALUES ('2016-09-03', '35');
INSERT INTO `t_calendar` VALUES ('2016-09-04', '35');
INSERT INTO `t_calendar` VALUES ('2016-09-05', '36');
INSERT INTO `t_calendar` VALUES ('2016-09-06', '36');
INSERT INTO `t_calendar` VALUES ('2016-09-07', '36');
INSERT INTO `t_calendar` VALUES ('2016-09-08', '36');
INSERT INTO `t_calendar` VALUES ('2016-09-09', '36');
INSERT INTO `t_calendar` VALUES ('2016-09-10', '36');
INSERT INTO `t_calendar` VALUES ('2016-09-11', '36');
INSERT INTO `t_calendar` VALUES ('2016-09-12', '37');
INSERT INTO `t_calendar` VALUES ('2016-09-13', '37');
INSERT INTO `t_calendar` VALUES ('2016-09-14', '37');
INSERT INTO `t_calendar` VALUES ('2016-09-15', '37');
INSERT INTO `t_calendar` VALUES ('2016-09-16', '37');
INSERT INTO `t_calendar` VALUES ('2016-09-17', '37');
INSERT INTO `t_calendar` VALUES ('2016-09-18', '37');
INSERT INTO `t_calendar` VALUES ('2016-09-19', '38');
INSERT INTO `t_calendar` VALUES ('2016-09-20', '38');
INSERT INTO `t_calendar` VALUES ('2016-09-21', '38');
INSERT INTO `t_calendar` VALUES ('2016-09-22', '38');
INSERT INTO `t_calendar` VALUES ('2016-09-23', '38');
INSERT INTO `t_calendar` VALUES ('2016-09-24', '38');
INSERT INTO `t_calendar` VALUES ('2016-09-25', '38');
INSERT INTO `t_calendar` VALUES ('2016-09-26', '39');
INSERT INTO `t_calendar` VALUES ('2016-09-27', '39');
INSERT INTO `t_calendar` VALUES ('2016-09-28', '39');
INSERT INTO `t_calendar` VALUES ('2016-09-29', '39');
INSERT INTO `t_calendar` VALUES ('2016-09-30', '39');
INSERT INTO `t_calendar` VALUES ('2016-10-01', '39');
INSERT INTO `t_calendar` VALUES ('2016-10-02', '39');
INSERT INTO `t_calendar` VALUES ('2016-10-03', '40');
INSERT INTO `t_calendar` VALUES ('2016-10-04', '40');
INSERT INTO `t_calendar` VALUES ('2016-10-05', '40');
INSERT INTO `t_calendar` VALUES ('2016-10-06', '40');
INSERT INTO `t_calendar` VALUES ('2016-10-07', '40');
INSERT INTO `t_calendar` VALUES ('2016-10-08', '40');
INSERT INTO `t_calendar` VALUES ('2016-10-09', '40');
INSERT INTO `t_calendar` VALUES ('2016-10-10', '41');
INSERT INTO `t_calendar` VALUES ('2016-10-11', '41');
INSERT INTO `t_calendar` VALUES ('2016-10-12', '41');
INSERT INTO `t_calendar` VALUES ('2016-10-13', '41');
INSERT INTO `t_calendar` VALUES ('2016-10-14', '41');
INSERT INTO `t_calendar` VALUES ('2016-10-15', '41');
INSERT INTO `t_calendar` VALUES ('2016-10-16', '41');
INSERT INTO `t_calendar` VALUES ('2016-10-17', '42');
INSERT INTO `t_calendar` VALUES ('2016-10-18', '42');
INSERT INTO `t_calendar` VALUES ('2016-10-19', '42');
INSERT INTO `t_calendar` VALUES ('2016-10-20', '42');
INSERT INTO `t_calendar` VALUES ('2016-10-21', '42');
INSERT INTO `t_calendar` VALUES ('2016-10-22', '42');
INSERT INTO `t_calendar` VALUES ('2016-10-23', '42');
INSERT INTO `t_calendar` VALUES ('2016-10-24', '43');
INSERT INTO `t_calendar` VALUES ('2016-10-25', '43');
INSERT INTO `t_calendar` VALUES ('2016-10-26', '43');
INSERT INTO `t_calendar` VALUES ('2016-10-27', '43');
INSERT INTO `t_calendar` VALUES ('2016-10-28', '43');
INSERT INTO `t_calendar` VALUES ('2016-10-29', '43');
INSERT INTO `t_calendar` VALUES ('2016-10-30', '43');
INSERT INTO `t_calendar` VALUES ('2016-10-31', '44');
INSERT INTO `t_calendar` VALUES ('2016-11-01', '44');
INSERT INTO `t_calendar` VALUES ('2016-11-02', '44');
INSERT INTO `t_calendar` VALUES ('2016-11-03', '44');
INSERT INTO `t_calendar` VALUES ('2016-11-04', '44');
INSERT INTO `t_calendar` VALUES ('2016-11-05', '44');
INSERT INTO `t_calendar` VALUES ('2016-11-06', '44');
INSERT INTO `t_calendar` VALUES ('2016-11-07', '45');
INSERT INTO `t_calendar` VALUES ('2016-11-08', '45');
INSERT INTO `t_calendar` VALUES ('2016-11-09', '45');
INSERT INTO `t_calendar` VALUES ('2016-11-10', '45');
INSERT INTO `t_calendar` VALUES ('2016-11-11', '45');
INSERT INTO `t_calendar` VALUES ('2016-11-12', '45');
INSERT INTO `t_calendar` VALUES ('2016-11-13', '45');
INSERT INTO `t_calendar` VALUES ('2016-11-14', '46');
INSERT INTO `t_calendar` VALUES ('2016-11-15', '46');
INSERT INTO `t_calendar` VALUES ('2016-11-16', '46');
INSERT INTO `t_calendar` VALUES ('2016-11-17', '46');
INSERT INTO `t_calendar` VALUES ('2016-11-18', '46');
INSERT INTO `t_calendar` VALUES ('2016-11-19', '46');
INSERT INTO `t_calendar` VALUES ('2016-11-20', '46');
INSERT INTO `t_calendar` VALUES ('2016-11-21', '47');
INSERT INTO `t_calendar` VALUES ('2016-11-22', '47');
INSERT INTO `t_calendar` VALUES ('2016-11-23', '47');
INSERT INTO `t_calendar` VALUES ('2016-11-24', '47');
INSERT INTO `t_calendar` VALUES ('2016-11-25', '47');
INSERT INTO `t_calendar` VALUES ('2016-11-26', '47');
INSERT INTO `t_calendar` VALUES ('2016-11-27', '47');
INSERT INTO `t_calendar` VALUES ('2016-11-28', '48');
INSERT INTO `t_calendar` VALUES ('2016-11-29', '48');
INSERT INTO `t_calendar` VALUES ('2016-11-30', '48');
INSERT INTO `t_calendar` VALUES ('2016-12-01', '48');
INSERT INTO `t_calendar` VALUES ('2016-12-02', '48');
INSERT INTO `t_calendar` VALUES ('2016-12-03', '48');
INSERT INTO `t_calendar` VALUES ('2016-12-04', '48');
INSERT INTO `t_calendar` VALUES ('2016-12-05', '49');
INSERT INTO `t_calendar` VALUES ('2016-12-06', '49');
INSERT INTO `t_calendar` VALUES ('2016-12-07', '49');
INSERT INTO `t_calendar` VALUES ('2016-12-08', '49');
INSERT INTO `t_calendar` VALUES ('2016-12-09', '49');
INSERT INTO `t_calendar` VALUES ('2016-12-10', '49');
INSERT INTO `t_calendar` VALUES ('2016-12-11', '49');
INSERT INTO `t_calendar` VALUES ('2016-12-12', '50');
INSERT INTO `t_calendar` VALUES ('2016-12-13', '50');
INSERT INTO `t_calendar` VALUES ('2016-12-14', '50');
INSERT INTO `t_calendar` VALUES ('2016-12-15', '50');
INSERT INTO `t_calendar` VALUES ('2016-12-16', '50');
INSERT INTO `t_calendar` VALUES ('2016-12-17', '50');
INSERT INTO `t_calendar` VALUES ('2016-12-18', '50');
INSERT INTO `t_calendar` VALUES ('2016-12-19', '51');
INSERT INTO `t_calendar` VALUES ('2016-12-20', '51');
INSERT INTO `t_calendar` VALUES ('2016-12-21', '51');
INSERT INTO `t_calendar` VALUES ('2016-12-22', '51');
INSERT INTO `t_calendar` VALUES ('2016-12-23', '51');
INSERT INTO `t_calendar` VALUES ('2016-12-24', '51');
INSERT INTO `t_calendar` VALUES ('2016-12-25', '51');
INSERT INTO `t_calendar` VALUES ('2016-12-26', '52');
INSERT INTO `t_calendar` VALUES ('2016-12-27', '52');
INSERT INTO `t_calendar` VALUES ('2016-12-28', '52');
INSERT INTO `t_calendar` VALUES ('2016-12-29', '52');
INSERT INTO `t_calendar` VALUES ('2016-12-30', '52');
INSERT INTO `t_calendar` VALUES ('2016-12-31', '52');
INSERT INTO `t_calendar` VALUES ('2017-01-01', '0');
INSERT INTO `t_calendar` VALUES ('2017-01-02', '1');
INSERT INTO `t_calendar` VALUES ('2017-01-03', '1');
INSERT INTO `t_calendar` VALUES ('2017-01-04', '1');
INSERT INTO `t_calendar` VALUES ('2017-01-05', '1');
INSERT INTO `t_calendar` VALUES ('2017-01-06', '1');
INSERT INTO `t_calendar` VALUES ('2017-01-07', '1');
INSERT INTO `t_calendar` VALUES ('2017-01-08', '1');
INSERT INTO `t_calendar` VALUES ('2017-01-09', '2');
INSERT INTO `t_calendar` VALUES ('2017-01-10', '2');
INSERT INTO `t_calendar` VALUES ('2017-01-11', '2');
INSERT INTO `t_calendar` VALUES ('2017-01-12', '2');
INSERT INTO `t_calendar` VALUES ('2017-01-13', '2');
INSERT INTO `t_calendar` VALUES ('2017-01-14', '2');
INSERT INTO `t_calendar` VALUES ('2017-01-15', '2');
INSERT INTO `t_calendar` VALUES ('2017-01-16', '3');
INSERT INTO `t_calendar` VALUES ('2017-01-17', '3');
INSERT INTO `t_calendar` VALUES ('2017-01-18', '3');
INSERT INTO `t_calendar` VALUES ('2017-01-19', '3');
INSERT INTO `t_calendar` VALUES ('2017-01-20', '3');
INSERT INTO `t_calendar` VALUES ('2017-01-21', '3');
INSERT INTO `t_calendar` VALUES ('2017-01-22', '3');
INSERT INTO `t_calendar` VALUES ('2017-01-23', '4');
INSERT INTO `t_calendar` VALUES ('2017-01-24', '4');
INSERT INTO `t_calendar` VALUES ('2017-01-25', '4');
INSERT INTO `t_calendar` VALUES ('2017-01-26', '4');
INSERT INTO `t_calendar` VALUES ('2017-01-27', '4');
INSERT INTO `t_calendar` VALUES ('2017-01-28', '4');
INSERT INTO `t_calendar` VALUES ('2017-01-29', '4');
INSERT INTO `t_calendar` VALUES ('2017-01-30', '5');
INSERT INTO `t_calendar` VALUES ('2017-01-31', '5');
INSERT INTO `t_calendar` VALUES ('2017-02-01', '5');
INSERT INTO `t_calendar` VALUES ('2017-02-02', '5');
INSERT INTO `t_calendar` VALUES ('2017-02-03', '5');
INSERT INTO `t_calendar` VALUES ('2017-02-04', '5');
INSERT INTO `t_calendar` VALUES ('2017-02-05', '5');
INSERT INTO `t_calendar` VALUES ('2017-02-06', '6');
INSERT INTO `t_calendar` VALUES ('2017-02-07', '6');
INSERT INTO `t_calendar` VALUES ('2017-02-08', '6');
INSERT INTO `t_calendar` VALUES ('2017-02-09', '6');
INSERT INTO `t_calendar` VALUES ('2017-02-10', '6');
INSERT INTO `t_calendar` VALUES ('2017-02-11', '6');
INSERT INTO `t_calendar` VALUES ('2017-02-12', '6');
INSERT INTO `t_calendar` VALUES ('2017-02-13', '7');
INSERT INTO `t_calendar` VALUES ('2017-02-14', '7');
INSERT INTO `t_calendar` VALUES ('2017-02-15', '7');
INSERT INTO `t_calendar` VALUES ('2017-02-16', '7');
INSERT INTO `t_calendar` VALUES ('2017-02-17', '7');
INSERT INTO `t_calendar` VALUES ('2017-02-18', '7');
INSERT INTO `t_calendar` VALUES ('2017-02-19', '7');
INSERT INTO `t_calendar` VALUES ('2017-02-20', '8');
INSERT INTO `t_calendar` VALUES ('2017-02-21', '8');
INSERT INTO `t_calendar` VALUES ('2017-02-22', '8');
INSERT INTO `t_calendar` VALUES ('2017-02-23', '8');
INSERT INTO `t_calendar` VALUES ('2017-02-24', '8');
INSERT INTO `t_calendar` VALUES ('2017-02-25', '8');
INSERT INTO `t_calendar` VALUES ('2017-02-26', '8');
INSERT INTO `t_calendar` VALUES ('2017-02-27', '9');
INSERT INTO `t_calendar` VALUES ('2017-02-28', '9');
INSERT INTO `t_calendar` VALUES ('2017-03-01', '9');
INSERT INTO `t_calendar` VALUES ('2017-03-02', '9');
INSERT INTO `t_calendar` VALUES ('2017-03-03', '9');
INSERT INTO `t_calendar` VALUES ('2017-03-04', '9');
INSERT INTO `t_calendar` VALUES ('2017-03-05', '9');
INSERT INTO `t_calendar` VALUES ('2017-03-06', '10');
INSERT INTO `t_calendar` VALUES ('2017-03-07', '10');
INSERT INTO `t_calendar` VALUES ('2017-03-08', '10');
INSERT INTO `t_calendar` VALUES ('2017-03-09', '10');
INSERT INTO `t_calendar` VALUES ('2017-03-10', '10');
INSERT INTO `t_calendar` VALUES ('2017-03-11', '10');
INSERT INTO `t_calendar` VALUES ('2017-03-12', '10');
INSERT INTO `t_calendar` VALUES ('2017-03-13', '11');
INSERT INTO `t_calendar` VALUES ('2017-03-14', '11');
INSERT INTO `t_calendar` VALUES ('2017-03-15', '11');
INSERT INTO `t_calendar` VALUES ('2017-03-16', '11');
INSERT INTO `t_calendar` VALUES ('2017-03-17', '11');
INSERT INTO `t_calendar` VALUES ('2017-03-18', '11');
INSERT INTO `t_calendar` VALUES ('2017-03-19', '11');
INSERT INTO `t_calendar` VALUES ('2017-03-20', '12');
INSERT INTO `t_calendar` VALUES ('2017-03-21', '12');
INSERT INTO `t_calendar` VALUES ('2017-03-22', '12');
INSERT INTO `t_calendar` VALUES ('2017-03-23', '12');
INSERT INTO `t_calendar` VALUES ('2017-03-24', '12');
INSERT INTO `t_calendar` VALUES ('2017-03-25', '12');
INSERT INTO `t_calendar` VALUES ('2017-03-26', '12');
INSERT INTO `t_calendar` VALUES ('2017-03-27', '13');
INSERT INTO `t_calendar` VALUES ('2017-03-28', '13');
INSERT INTO `t_calendar` VALUES ('2017-03-29', '13');
INSERT INTO `t_calendar` VALUES ('2017-03-30', '13');
INSERT INTO `t_calendar` VALUES ('2017-03-31', '13');
INSERT INTO `t_calendar` VALUES ('2017-04-01', '13');
INSERT INTO `t_calendar` VALUES ('2017-04-02', '13');
INSERT INTO `t_calendar` VALUES ('2017-04-03', '14');
INSERT INTO `t_calendar` VALUES ('2017-04-04', '14');
INSERT INTO `t_calendar` VALUES ('2017-04-05', '14');
INSERT INTO `t_calendar` VALUES ('2017-04-06', '14');
INSERT INTO `t_calendar` VALUES ('2017-04-07', '14');
INSERT INTO `t_calendar` VALUES ('2017-04-08', '14');
INSERT INTO `t_calendar` VALUES ('2017-04-09', '14');
INSERT INTO `t_calendar` VALUES ('2017-04-10', '15');
INSERT INTO `t_calendar` VALUES ('2017-04-11', '15');
INSERT INTO `t_calendar` VALUES ('2017-04-12', '15');
INSERT INTO `t_calendar` VALUES ('2017-04-13', '15');
INSERT INTO `t_calendar` VALUES ('2017-04-14', '15');
INSERT INTO `t_calendar` VALUES ('2017-04-15', '15');
INSERT INTO `t_calendar` VALUES ('2017-04-16', '15');
INSERT INTO `t_calendar` VALUES ('2017-04-17', '16');
INSERT INTO `t_calendar` VALUES ('2017-04-18', '16');
INSERT INTO `t_calendar` VALUES ('2017-04-19', '16');
INSERT INTO `t_calendar` VALUES ('2017-04-20', '16');
INSERT INTO `t_calendar` VALUES ('2017-04-21', '16');
INSERT INTO `t_calendar` VALUES ('2017-04-22', '16');
INSERT INTO `t_calendar` VALUES ('2017-04-23', '16');
INSERT INTO `t_calendar` VALUES ('2017-04-24', '17');
INSERT INTO `t_calendar` VALUES ('2017-04-25', '17');
INSERT INTO `t_calendar` VALUES ('2017-04-26', '17');
INSERT INTO `t_calendar` VALUES ('2017-04-27', '17');
INSERT INTO `t_calendar` VALUES ('2017-04-28', '17');
INSERT INTO `t_calendar` VALUES ('2017-04-29', '17');
INSERT INTO `t_calendar` VALUES ('2017-04-30', '17');
INSERT INTO `t_calendar` VALUES ('2017-05-01', '18');
INSERT INTO `t_calendar` VALUES ('2017-05-02', '18');
INSERT INTO `t_calendar` VALUES ('2017-05-03', '18');
INSERT INTO `t_calendar` VALUES ('2017-05-04', '18');
INSERT INTO `t_calendar` VALUES ('2017-05-05', '18');
INSERT INTO `t_calendar` VALUES ('2017-05-06', '18');
INSERT INTO `t_calendar` VALUES ('2017-05-07', '18');
INSERT INTO `t_calendar` VALUES ('2017-05-08', '19');
INSERT INTO `t_calendar` VALUES ('2017-05-09', '19');
INSERT INTO `t_calendar` VALUES ('2017-05-10', '19');
INSERT INTO `t_calendar` VALUES ('2017-05-11', '19');
INSERT INTO `t_calendar` VALUES ('2017-05-12', '19');
INSERT INTO `t_calendar` VALUES ('2017-05-13', '19');
INSERT INTO `t_calendar` VALUES ('2017-05-14', '19');
INSERT INTO `t_calendar` VALUES ('2017-05-15', '20');
INSERT INTO `t_calendar` VALUES ('2017-05-16', '20');
INSERT INTO `t_calendar` VALUES ('2017-05-17', '20');
INSERT INTO `t_calendar` VALUES ('2017-05-18', '20');
INSERT INTO `t_calendar` VALUES ('2017-05-19', '20');
INSERT INTO `t_calendar` VALUES ('2017-05-20', '20');
INSERT INTO `t_calendar` VALUES ('2017-05-21', '20');
INSERT INTO `t_calendar` VALUES ('2017-05-22', '21');
INSERT INTO `t_calendar` VALUES ('2017-05-23', '21');
INSERT INTO `t_calendar` VALUES ('2017-05-24', '21');
INSERT INTO `t_calendar` VALUES ('2017-05-25', '21');
INSERT INTO `t_calendar` VALUES ('2017-05-26', '21');
INSERT INTO `t_calendar` VALUES ('2017-05-27', '21');
INSERT INTO `t_calendar` VALUES ('2017-05-28', '21');
INSERT INTO `t_calendar` VALUES ('2017-05-29', '22');
INSERT INTO `t_calendar` VALUES ('2017-05-30', '22');
INSERT INTO `t_calendar` VALUES ('2017-05-31', '22');
INSERT INTO `t_calendar` VALUES ('2017-06-01', '22');
INSERT INTO `t_calendar` VALUES ('2017-06-02', '22');
INSERT INTO `t_calendar` VALUES ('2017-06-03', '22');
INSERT INTO `t_calendar` VALUES ('2017-06-04', '22');
INSERT INTO `t_calendar` VALUES ('2017-06-05', '23');
INSERT INTO `t_calendar` VALUES ('2017-06-06', '23');
INSERT INTO `t_calendar` VALUES ('2017-06-07', '23');
INSERT INTO `t_calendar` VALUES ('2017-06-08', '23');
INSERT INTO `t_calendar` VALUES ('2017-06-09', '23');
INSERT INTO `t_calendar` VALUES ('2017-06-10', '23');
INSERT INTO `t_calendar` VALUES ('2017-06-11', '23');
INSERT INTO `t_calendar` VALUES ('2017-06-12', '24');
INSERT INTO `t_calendar` VALUES ('2017-06-13', '24');
INSERT INTO `t_calendar` VALUES ('2017-06-14', '24');
INSERT INTO `t_calendar` VALUES ('2017-06-15', '24');
INSERT INTO `t_calendar` VALUES ('2017-06-16', '24');
INSERT INTO `t_calendar` VALUES ('2017-06-17', '24');
INSERT INTO `t_calendar` VALUES ('2017-06-18', '24');
INSERT INTO `t_calendar` VALUES ('2017-06-19', '25');
INSERT INTO `t_calendar` VALUES ('2017-06-20', '25');
INSERT INTO `t_calendar` VALUES ('2017-06-21', '25');
INSERT INTO `t_calendar` VALUES ('2017-06-22', '25');
INSERT INTO `t_calendar` VALUES ('2017-06-23', '25');
INSERT INTO `t_calendar` VALUES ('2017-06-24', '25');
INSERT INTO `t_calendar` VALUES ('2017-06-25', '25');
INSERT INTO `t_calendar` VALUES ('2017-06-26', '26');
INSERT INTO `t_calendar` VALUES ('2017-06-27', '26');
INSERT INTO `t_calendar` VALUES ('2017-06-28', '26');
INSERT INTO `t_calendar` VALUES ('2017-06-29', '26');
INSERT INTO `t_calendar` VALUES ('2017-06-30', '26');
INSERT INTO `t_calendar` VALUES ('2017-07-01', '26');
INSERT INTO `t_calendar` VALUES ('2017-07-02', '26');
INSERT INTO `t_calendar` VALUES ('2017-07-03', '27');
INSERT INTO `t_calendar` VALUES ('2017-07-04', '27');
INSERT INTO `t_calendar` VALUES ('2017-07-05', '27');
INSERT INTO `t_calendar` VALUES ('2017-07-06', '27');
INSERT INTO `t_calendar` VALUES ('2017-07-07', '27');
INSERT INTO `t_calendar` VALUES ('2017-07-08', '27');
INSERT INTO `t_calendar` VALUES ('2017-07-09', '27');
INSERT INTO `t_calendar` VALUES ('2017-07-10', '28');
INSERT INTO `t_calendar` VALUES ('2017-07-11', '28');
INSERT INTO `t_calendar` VALUES ('2017-07-12', '28');
INSERT INTO `t_calendar` VALUES ('2017-07-13', '28');
INSERT INTO `t_calendar` VALUES ('2017-07-14', '28');
INSERT INTO `t_calendar` VALUES ('2017-07-15', '28');
INSERT INTO `t_calendar` VALUES ('2017-07-16', '28');
INSERT INTO `t_calendar` VALUES ('2017-07-17', '29');
INSERT INTO `t_calendar` VALUES ('2017-07-18', '29');
INSERT INTO `t_calendar` VALUES ('2017-07-19', '29');
INSERT INTO `t_calendar` VALUES ('2017-07-20', '29');
INSERT INTO `t_calendar` VALUES ('2017-07-21', '29');
INSERT INTO `t_calendar` VALUES ('2017-07-22', '29');
INSERT INTO `t_calendar` VALUES ('2017-07-23', '29');
INSERT INTO `t_calendar` VALUES ('2017-07-24', '30');
INSERT INTO `t_calendar` VALUES ('2017-07-25', '30');
INSERT INTO `t_calendar` VALUES ('2017-07-26', '30');
INSERT INTO `t_calendar` VALUES ('2017-07-27', '30');
INSERT INTO `t_calendar` VALUES ('2017-07-28', '30');
INSERT INTO `t_calendar` VALUES ('2017-07-29', '30');
INSERT INTO `t_calendar` VALUES ('2017-07-30', '30');
INSERT INTO `t_calendar` VALUES ('2017-07-31', '31');
INSERT INTO `t_calendar` VALUES ('2017-08-01', '31');
INSERT INTO `t_calendar` VALUES ('2017-08-02', '31');
INSERT INTO `t_calendar` VALUES ('2017-08-03', '31');
INSERT INTO `t_calendar` VALUES ('2017-08-04', '31');
INSERT INTO `t_calendar` VALUES ('2017-08-05', '31');
INSERT INTO `t_calendar` VALUES ('2017-08-06', '31');
INSERT INTO `t_calendar` VALUES ('2017-08-07', '32');
INSERT INTO `t_calendar` VALUES ('2017-08-08', '32');
INSERT INTO `t_calendar` VALUES ('2017-08-09', '32');
INSERT INTO `t_calendar` VALUES ('2017-08-10', '32');
INSERT INTO `t_calendar` VALUES ('2017-08-11', '32');
INSERT INTO `t_calendar` VALUES ('2017-08-12', '32');
INSERT INTO `t_calendar` VALUES ('2017-08-13', '32');
INSERT INTO `t_calendar` VALUES ('2017-08-14', '33');
INSERT INTO `t_calendar` VALUES ('2017-08-15', '33');
INSERT INTO `t_calendar` VALUES ('2017-08-16', '33');
INSERT INTO `t_calendar` VALUES ('2017-08-17', '33');
INSERT INTO `t_calendar` VALUES ('2017-08-18', '33');
INSERT INTO `t_calendar` VALUES ('2017-08-19', '33');
INSERT INTO `t_calendar` VALUES ('2017-08-20', '33');
INSERT INTO `t_calendar` VALUES ('2017-08-21', '34');
INSERT INTO `t_calendar` VALUES ('2017-08-22', '34');
INSERT INTO `t_calendar` VALUES ('2017-08-23', '34');
INSERT INTO `t_calendar` VALUES ('2017-08-24', '34');
INSERT INTO `t_calendar` VALUES ('2017-08-25', '34');
INSERT INTO `t_calendar` VALUES ('2017-08-26', '34');
INSERT INTO `t_calendar` VALUES ('2017-08-27', '34');
INSERT INTO `t_calendar` VALUES ('2017-08-28', '35');
INSERT INTO `t_calendar` VALUES ('2017-08-29', '35');
INSERT INTO `t_calendar` VALUES ('2017-08-30', '35');
INSERT INTO `t_calendar` VALUES ('2017-08-31', '35');
INSERT INTO `t_calendar` VALUES ('2017-09-01', '35');
INSERT INTO `t_calendar` VALUES ('2017-09-02', '35');
INSERT INTO `t_calendar` VALUES ('2017-09-03', '35');
INSERT INTO `t_calendar` VALUES ('2017-09-04', '36');
INSERT INTO `t_calendar` VALUES ('2017-09-05', '36');
INSERT INTO `t_calendar` VALUES ('2017-09-06', '36');
INSERT INTO `t_calendar` VALUES ('2017-09-07', '36');
INSERT INTO `t_calendar` VALUES ('2017-09-08', '36');
INSERT INTO `t_calendar` VALUES ('2017-09-09', '36');
INSERT INTO `t_calendar` VALUES ('2017-09-10', '36');
INSERT INTO `t_calendar` VALUES ('2017-09-11', '37');
INSERT INTO `t_calendar` VALUES ('2017-09-12', '37');
INSERT INTO `t_calendar` VALUES ('2017-09-13', '37');
INSERT INTO `t_calendar` VALUES ('2017-09-14', '37');
INSERT INTO `t_calendar` VALUES ('2017-09-15', '37');
INSERT INTO `t_calendar` VALUES ('2017-09-16', '37');
INSERT INTO `t_calendar` VALUES ('2017-09-17', '37');
INSERT INTO `t_calendar` VALUES ('2017-09-18', '38');
INSERT INTO `t_calendar` VALUES ('2017-09-19', '38');
INSERT INTO `t_calendar` VALUES ('2017-09-20', '38');
INSERT INTO `t_calendar` VALUES ('2017-09-21', '38');
INSERT INTO `t_calendar` VALUES ('2017-09-22', '38');
INSERT INTO `t_calendar` VALUES ('2017-09-23', '38');
INSERT INTO `t_calendar` VALUES ('2017-09-24', '38');
INSERT INTO `t_calendar` VALUES ('2017-09-25', '39');
INSERT INTO `t_calendar` VALUES ('2017-09-26', '39');
INSERT INTO `t_calendar` VALUES ('2017-09-27', '39');
INSERT INTO `t_calendar` VALUES ('2017-09-28', '39');
INSERT INTO `t_calendar` VALUES ('2017-09-29', '39');
INSERT INTO `t_calendar` VALUES ('2017-09-30', '39');
INSERT INTO `t_calendar` VALUES ('2017-10-01', '39');
INSERT INTO `t_calendar` VALUES ('2017-10-02', '40');
INSERT INTO `t_calendar` VALUES ('2017-10-03', '40');
INSERT INTO `t_calendar` VALUES ('2017-10-04', '40');
INSERT INTO `t_calendar` VALUES ('2017-10-05', '40');
INSERT INTO `t_calendar` VALUES ('2017-10-06', '40');
INSERT INTO `t_calendar` VALUES ('2017-10-07', '40');
INSERT INTO `t_calendar` VALUES ('2017-10-08', '40');
INSERT INTO `t_calendar` VALUES ('2017-10-09', '41');
INSERT INTO `t_calendar` VALUES ('2017-10-10', '41');
INSERT INTO `t_calendar` VALUES ('2017-10-11', '41');
INSERT INTO `t_calendar` VALUES ('2017-10-12', '41');
INSERT INTO `t_calendar` VALUES ('2017-10-13', '41');
INSERT INTO `t_calendar` VALUES ('2017-10-14', '41');
INSERT INTO `t_calendar` VALUES ('2017-10-15', '41');
INSERT INTO `t_calendar` VALUES ('2017-10-16', '42');
INSERT INTO `t_calendar` VALUES ('2017-10-17', '42');
INSERT INTO `t_calendar` VALUES ('2017-10-18', '42');
INSERT INTO `t_calendar` VALUES ('2017-10-19', '42');
INSERT INTO `t_calendar` VALUES ('2017-10-20', '42');
INSERT INTO `t_calendar` VALUES ('2017-10-21', '42');
INSERT INTO `t_calendar` VALUES ('2017-10-22', '42');
INSERT INTO `t_calendar` VALUES ('2017-10-23', '43');
INSERT INTO `t_calendar` VALUES ('2017-10-24', '43');
INSERT INTO `t_calendar` VALUES ('2017-10-25', '43');
INSERT INTO `t_calendar` VALUES ('2017-10-26', '43');
INSERT INTO `t_calendar` VALUES ('2017-10-27', '43');
INSERT INTO `t_calendar` VALUES ('2017-10-28', '43');
INSERT INTO `t_calendar` VALUES ('2017-10-29', '43');
INSERT INTO `t_calendar` VALUES ('2017-10-30', '44');
INSERT INTO `t_calendar` VALUES ('2017-10-31', '44');
INSERT INTO `t_calendar` VALUES ('2017-11-01', '44');
INSERT INTO `t_calendar` VALUES ('2017-11-02', '44');
INSERT INTO `t_calendar` VALUES ('2017-11-03', '44');
INSERT INTO `t_calendar` VALUES ('2017-11-04', '44');
INSERT INTO `t_calendar` VALUES ('2017-11-05', '44');
INSERT INTO `t_calendar` VALUES ('2017-11-06', '45');
INSERT INTO `t_calendar` VALUES ('2017-11-07', '45');
INSERT INTO `t_calendar` VALUES ('2017-11-08', '45');
INSERT INTO `t_calendar` VALUES ('2017-11-09', '45');
INSERT INTO `t_calendar` VALUES ('2017-11-10', '45');
INSERT INTO `t_calendar` VALUES ('2017-11-11', '45');
INSERT INTO `t_calendar` VALUES ('2017-11-12', '45');
INSERT INTO `t_calendar` VALUES ('2017-11-13', '46');
INSERT INTO `t_calendar` VALUES ('2017-11-14', '46');
INSERT INTO `t_calendar` VALUES ('2017-11-15', '46');
INSERT INTO `t_calendar` VALUES ('2017-11-16', '46');
INSERT INTO `t_calendar` VALUES ('2017-11-17', '46');
INSERT INTO `t_calendar` VALUES ('2017-11-18', '46');
INSERT INTO `t_calendar` VALUES ('2017-11-19', '46');
INSERT INTO `t_calendar` VALUES ('2017-11-20', '47');
INSERT INTO `t_calendar` VALUES ('2017-11-21', '47');
INSERT INTO `t_calendar` VALUES ('2017-11-22', '47');
INSERT INTO `t_calendar` VALUES ('2017-11-23', '47');
INSERT INTO `t_calendar` VALUES ('2017-11-24', '47');
INSERT INTO `t_calendar` VALUES ('2017-11-25', '47');
INSERT INTO `t_calendar` VALUES ('2017-11-26', '47');
INSERT INTO `t_calendar` VALUES ('2017-11-27', '48');
INSERT INTO `t_calendar` VALUES ('2017-11-28', '48');
INSERT INTO `t_calendar` VALUES ('2017-11-29', '48');
INSERT INTO `t_calendar` VALUES ('2017-11-30', '48');
INSERT INTO `t_calendar` VALUES ('2017-12-01', '48');
INSERT INTO `t_calendar` VALUES ('2017-12-02', '48');
INSERT INTO `t_calendar` VALUES ('2017-12-03', '48');
INSERT INTO `t_calendar` VALUES ('2017-12-04', '49');
INSERT INTO `t_calendar` VALUES ('2017-12-05', '49');
INSERT INTO `t_calendar` VALUES ('2017-12-06', '49');
INSERT INTO `t_calendar` VALUES ('2017-12-07', '49');
INSERT INTO `t_calendar` VALUES ('2017-12-08', '49');
INSERT INTO `t_calendar` VALUES ('2017-12-09', '49');
INSERT INTO `t_calendar` VALUES ('2017-12-10', '49');
INSERT INTO `t_calendar` VALUES ('2017-12-11', '50');
INSERT INTO `t_calendar` VALUES ('2017-12-12', '50');
INSERT INTO `t_calendar` VALUES ('2017-12-13', '50');
INSERT INTO `t_calendar` VALUES ('2017-12-14', '50');
INSERT INTO `t_calendar` VALUES ('2017-12-15', '50');
INSERT INTO `t_calendar` VALUES ('2017-12-16', '50');
INSERT INTO `t_calendar` VALUES ('2017-12-17', '50');
INSERT INTO `t_calendar` VALUES ('2017-12-18', '51');
INSERT INTO `t_calendar` VALUES ('2017-12-19', '51');
INSERT INTO `t_calendar` VALUES ('2017-12-20', '51');
INSERT INTO `t_calendar` VALUES ('2017-12-21', '51');
INSERT INTO `t_calendar` VALUES ('2017-12-22', '51');
INSERT INTO `t_calendar` VALUES ('2017-12-23', '51');
INSERT INTO `t_calendar` VALUES ('2017-12-24', '51');
INSERT INTO `t_calendar` VALUES ('2017-12-25', '52');
INSERT INTO `t_calendar` VALUES ('2017-12-26', '52');
INSERT INTO `t_calendar` VALUES ('2017-12-27', '52');
INSERT INTO `t_calendar` VALUES ('2017-12-28', '52');
INSERT INTO `t_calendar` VALUES ('2017-12-29', '52');
INSERT INTO `t_calendar` VALUES ('2017-12-30', '52');
INSERT INTO `t_calendar` VALUES ('2017-12-31', '52');

-- ----------------------------
-- Procedure structure for p_report_day
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_report_day`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_report_day`()
BEGIN

#如果表存在，先删除
DROP TABLE IF EXISTS report_day;

#根据查询创建表
CREATE TABLE report_day 
(
#计算当日所有会员账户消费金额和当日所有会员账户结余金额
select t9.date, t9.week, t9.reg_user, t9.ticket_order_cnt, t9.ticket_order_amt, t9.ticket_back_cnt, t9.ticket_back_amt, t9.order_3rd_cnt, 
t9.order_wallet_cnt, t9.order_cnt_total, t9.order_3rd_amt, t9.order_wallet_amt, t9.order_amt_total, t9.back_3rd_cnt, t9.back_wallet_cnt, 
t9.back_3rd_amt, t9.back_wallet_amt, t9.pre_order_cnt, t9.pre_order_amt, t9.pre_back_cnt, t9.pre_back_amt, t9.cnt_50, t9.cnt_100, t9.cnt_200, 
t9.cnt_500, t9.cnt_1000, t9.cnt_2000, t9.cnt_5000, t9.recharg_cnt_total, t9.amt_50, t9.amt_100, t9.amt_200, t9.amt_500, t9.amt_1000, t9.amt_2000, 
t9.amt_5000, t9.recharg_amt_total, 
round(((t9.ticket_order_amt - t9.ticket_back_amt) + 
	(t9.order_amt_total - t9.back_3rd_amt - t9.back_wallet_amt) + 
	(t9.pre_order_amt - t9.pre_back_amt)), 2) consume_amt_total, 
round((t9.recharg_amt_total + t9.order_3rd_amt + ticket_order_3rd_amt + pre_order_3rd_amt - 
	((t9.ticket_order_amt - t9.ticket_back_amt) + 
		(t9.order_amt_total - t9.back_3rd_amt - t9.back_wallet_amt) + 
		(t9.pre_order_amt - t9.pre_back_amt))), 2) balance_amt_total
from 
#计算除当日所有会员账户消费金额和当日所有会员账户结余金额以外的其他字段，并对null值做转0处理
(select t1.*, 
	IFNULL(t2.reg_user,0) reg_user, 
	IFNULL(t3.ticket_order_cnt,0) ticket_order_cnt, 
	IFNULL(t3.ticket_order_amt,0) ticket_order_amt, 
	IFNULL(t4.ticket_back_cnt,0) ticket_back_cnt, 
	IFNULL(t4.ticket_back_amt,0) ticket_back_amt,
	IFNULL(t3a.ticket_order_3rd_amt,0) ticket_order_3rd_amt,	
	IFNULL(t5.order_3rd_cnt,0) order_3rd_cnt, 
	IFNULL(t5.order_wallet_cnt,0) order_wallet_cnt, 
	IFNULL(t5.order_cnt_total,0) order_cnt_total, 
	IFNULL(t5.order_3rd_amt,0) order_3rd_amt, 
	IFNULL(t5.order_wallet_amt,0) order_wallet_amt, 
	IFNULL(t5.order_amt_total,0) order_amt_total, 
	IFNULL(t6.back_3rd_cnt,0) back_3rd_cnt, 
	IFNULL(t6.back_wallet_cnt,0) back_wallet_cnt, 
	IFNULL(t6.back_3rd_amt,0) back_3rd_amt, 
	IFNULL(t6.back_wallet_amt,0) back_wallet_amt, 
	IFNULL(t7.pre_order_cnt,0) pre_order_cnt, 
	IFNULL(t7.pre_order_amt,0) pre_order_amt, 
	IFNULL(t7.pre_back_cnt,0) pre_back_cnt, 
	IFNULL(t7.pre_back_amt,0) pre_back_amt, 
	IFNULL(t7.pre_order_3rd_amt,0) pre_order_3rd_amt, 
	IFNULL(t8.cnt_50,0) cnt_50, 
	IFNULL(t8.cnt_100,0) cnt_100, 
	IFNULL(t8.cnt_200,0) cnt_200, 
	IFNULL(t8.cnt_500,0) cnt_500, 
	IFNULL(t8.cnt_1000,0) cnt_1000, 
	IFNULL(t8.cnt_2000,0) cnt_2000, 
	IFNULL(t8.cnt_5000,0) cnt_5000,
	IFNULL(t8.recharg_cnt_total,0) recharg_cnt_total, 
	IFNULL(t8.amt_50,0) amt_50, 
	IFNULL(t8.amt_100,0) amt_100, 
	IFNULL(t8.amt_200,0) amt_200, 
	IFNULL(t8.amt_500,0) amt_500, 
	IFNULL(t8.amt_1000,0) amt_1000, 
	IFNULL(t8.amt_2000,0) amt_2000, 
	IFNULL(t8.amt_5000,0) amt_5000,
	IFNULL(t8.recharg_amt_total,0) recharg_amt_total 
from (select * from t_calendar where date <= date_sub(curdate(), interval 1 day)) t1 
LEFT JOIN 
#注册用户数
(select date_format(optDate, '%Y-%m-%d') date, count(mobile) reg_user from app_user_info where isActive!=0 group by date_format(optDate, '%Y-%m-%d')) t2 
on t1.date = t2.date left join 
#火车购票（订票）
(SELECT a.date, count(a.order_id) ticket_order_cnt, sum(b.order_amount) ticket_order_amt from 
(SELECT date_format(submit_time, '%Y-%m-%d') date, order_id from ticket_order_info) a,
(SELECT order_id, order_amount from ticket_order_detail where order_status = 4) b 
where a.order_id = b.order_id group by a.date) t3
on t1.date = t3.date left join 
#火车购票（退票）
(select a.date, count(a.order_id) ticket_back_cnt, sum(b.refund_money) ticket_back_amt from 
(SELECT date_format(refund_time, '%Y-%m-%d') date, order_id from ticket_order_info where refund_sign = 1) a, 
(SELECT order_id, refund_money from ticket_order_detail where order_status = 7) b
where a.order_id = b.order_id group by a.date) t4 
on t1.date = t4.date left join 
#新增火车购票（第三方支付）
(SELECT a.date, count(a.order_id) ticket_order_3rd_cnt, sum(b.order_amount) ticket_order_3rd_amt from 
(SELECT date_format(submit_time, '%Y-%m-%d') date, order_id from ticket_order_info where pay_type not in(1)) a,
(SELECT order_id, order_amount from ticket_order_detail where order_status = 4) b 
where a.order_id = b.order_id group by a.date) t3a
on t1.date = t3a.date left join 
#列车点餐（订餐）
(select a.date, b.order_wallet_cnt order_wallet_cnt, c.order_3rd_cnt order_3rd_cnt, (b.order_wallet_cnt + c.order_3rd_cnt) order_cnt_total, 
b.order_wallet_amt order_wallet_amt, c.order_3rd_amt order_3rd_amt, (b.order_wallet_amt + c.order_3rd_amt) order_amt_total from 
t_calendar a LEFT JOIN 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) order_wallet_cnt, sum(actualAmt) order_wallet_amt from order_info 
where orderStatus in(1,2,3,4) and orderType != 9 and payMethod = 0 group by date_format(orderDate, '%Y-%m-%d')) b
on a.date = b.date left join 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) order_3rd_cnt, sum(actualAmt) order_3rd_amt from order_info 
where orderStatus in(1,2,3,4) and orderType != 9 and (payMethod = 1 or payMethod = 2) group by date_format(orderDate, '%Y-%m-%d')) c
on a.date = c.date) t5
on t1.date = t5.date left join 
#列车点餐（退单）
(select a.date, b.back_wallet_cnt, c.back_3rd_cnt, b.back_wallet_amt, c.back_3rd_amt from t_calendar a LEFT JOIN 
(select date_format(orderDate, '%Y-%m-%d') date, count(orderNo) back_wallet_cnt, sum(actualAmt) back_wallet_amt from 
 order_info where orderStatus = 7 and orderType != 9 and payMethod = 0 
GROUP BY date_format(orderDate, '%Y-%m-%d')) b 
on a.date = b.date left join 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) back_3rd_cnt, sum(actualAmt) back_3rd_amt from
 order_info where orderStatus = 7 and orderType != 9 and (payMethod = 1 or payMethod = 2) group by date_format(orderDate, '%Y-%m-%d')) c
ON a.date = c.date) t6 
on t1.date = t6.date left join
#提前订餐（订单/退单）
(select a.date, b.pre_order_cnt, b.pre_order_amt, c.pre_back_cnt, c.pre_back_amt , d.pre_order_3rd_amt from 
t_calendar a left join 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) pre_order_cnt, sum(actualAmt) pre_order_amt from 
order_info where orderStatus in(1,2,3,4) and orderType = 9 group by date_format(orderDate, '%Y-%m-%d')) b 
ON a.date = b.date LEFT JOIN 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) pre_back_cnt, sum(actualAmt) pre_back_amt from 
order_info where orderStatus = 7 and orderType = 9 group by date_format(orderDate, '%Y-%m-%d')) c 
ON a.date = c.date left join
#新增提前订餐（第三方支付）
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) pre_order_3rd_cnt, sum(actualAmt) pre_order_3rd_amt from 
order_info where orderStatus in(1,2,3,4) and orderType = 9 and (payMethod = 1 or payMethod = 2) group by date_format(orderDate, '%Y-%m-%d')) d
on a.date = d.date) t7
on t1.date = t7.date left join 
#会员充值
(SELECT
b.date,
SUM(IF(b.amt_standerd='50', b.cnt_total, 0)) AS cnt_50,
SUM(IF(b.amt_standerd='100', b.cnt_total, 0)) AS cnt_100,
SUM(IF(b.amt_standerd='200', b.cnt_total, 0)) AS cnt_200,
SUM(IF(b.amt_standerd='500', b.cnt_total, 0)) AS cnt_500,
SUM(IF(b.amt_standerd='1000', b.cnt_total, 0)) AS cnt_1000,
SUM(IF(b.amt_standerd='2000', b.cnt_total, 0)) AS cnt_2000,
SUM(IF(b.amt_standerd='5000', b.cnt_total, 0)) AS cnt_5000,
SUM(IF(b.amt_standerd is NULL, b.cnt_total, 0)) AS recharg_cnt_total,
SUM(IF(b.amt_standerd='50', b.amt_total, 0)) AS amt_50,
SUM(IF(b.amt_standerd='100', b.amt_total, 0)) AS amt_100,
SUM(IF(b.amt_standerd='200', b.amt_total, 0)) AS amt_200,
SUM(IF(b.amt_standerd='500', b.amt_total, 0)) AS amt_500,
SUM(IF(b.amt_standerd='1000', b.amt_total, 0)) AS amt_1000,
SUM(IF(b.amt_standerd='2000', b.amt_total, 0)) AS amt_2000,
SUM(IF(b.amt_standerd='5000', b.amt_total, 0)) AS amt_5000,
SUM(IF(b.amt_standerd is null, b.amt_total, 0)) AS recharg_amt_total 
FROM 
(SELECT a.date ,IFNULL(a.amount, null) AS amt_standerd, SUM(cnt_total) AS cnt_total, SUM(amt_total) AS amt_total 
FROM 
(select date_format(date, '%Y-%m-%d') date, amount, count(amount) cnt_total, sum(amount) amt_total from 
recharge_info where success = 1 group by date_format(date, '%Y-%m-%d'), amount having amount in(50,100,200,500,1000,2000,5000)) a 
GROUP BY a.date, IFNULL(a.amount, null)
WITH ROLLUP
HAVING a.date IS NOT NULL) b
GROUP BY b.date) t8 
on t1.date = t8.date) t9
ORDER BY t9.date
);

#添加备注
ALTER table report_day MODIFY `date` date NOT NULL COMMENT '日期';
ALTER table report_day MODIFY `week` int(2) NOT NULL COMMENT '周';
ALTER table report_day MODIFY `reg_user` bigint(21) NOT NULL DEFAULT '0' COMMENT '注册用户数量';
ALTER table report_day MODIFY `ticket_order_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '火车购票订单数量';
ALTER table report_day MODIFY `ticket_order_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '火车购票订单金额';
ALTER table report_day MODIFY `ticket_back_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '火车票退票单数';
ALTER table report_day MODIFY `ticket_back_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '火车票退票金额';
ALTER table report_day MODIFY `order_3rd_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '列车点餐第三方支付单数';
ALTER table report_day MODIFY `order_wallet_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '列车点餐钱包支付单数';
ALTER table report_day MODIFY `order_cnt_total` bigint(22) NOT NULL DEFAULT '0' COMMENT '列车点餐支付总单数';
ALTER table report_day MODIFY `order_3rd_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐第三方支付金额';
ALTER table report_day MODIFY `order_wallet_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐钱包支付金额';
ALTER table report_day MODIFY `order_amt_total` decimal(32,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐支付总金额';
ALTER table report_day MODIFY `back_3rd_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '列车点餐退单次数（第三方支付方式）';
ALTER table report_day MODIFY `back_wallet_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '列车点餐退单次数（钱包支付方式）';
ALTER table report_day MODIFY `back_3rd_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐退单金额（第三方支付方式）';
ALTER table report_day MODIFY `back_wallet_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐退单金额（钱包支付方式）';
ALTER table report_day MODIFY `pre_order_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '预订单数量';
ALTER table report_day MODIFY `pre_order_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '预订单金额';
ALTER table report_day MODIFY `pre_back_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '预订单退单数量';
ALTER table report_day MODIFY `pre_back_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '预订单退单金额';
ALTER table report_day MODIFY `cnt_50` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（50元）';
ALTER table report_day MODIFY `cnt_100` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（100元）';
ALTER table report_day MODIFY `cnt_200` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（200元）';
ALTER table report_day MODIFY `cnt_500` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（500元）';
ALTER table report_day MODIFY `cnt_1000` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（1000元）';
ALTER table report_day MODIFY `cnt_2000` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（2000元）';
ALTER table report_day MODIFY `cnt_5000` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（5000元）';
ALTER table report_day MODIFY `recharg_cnt_total` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数总计';
ALTER table report_day MODIFY `amt_50` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（50元）';
ALTER table report_day MODIFY `amt_100` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（100元）';
ALTER table report_day MODIFY `amt_200` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（200元）';
ALTER table report_day MODIFY `amt_500` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（500元）';
ALTER table report_day MODIFY `amt_1000` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（1000元）';
ALTER table report_day MODIFY `amt_2000` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（2000元）';
ALTER table report_day MODIFY `amt_5000` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（5000元）';
ALTER table report_day MODIFY `recharg_amt_total` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额总计';
ALTER table report_day MODIFY `consume_amt_total` decimal(36,2) NOT NULL DEFAULT '0.00' COMMENT '当日所有会员账户消费金额';
ALTER table report_day MODIFY `balance_amt_total` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '当日所有会员账户结余金额';

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for p_report_day_add
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_report_day_add`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_report_day_add`()
BEGIN

#如果表存在，先删除
DROP TABLE IF EXISTS report_day;

#根据查询创建表
CREATE TABLE report_day 
(
#计算当日所有会员账户消费金额和当日所有会员账户结余金额
select t9.date, t9.week, t9.reg_user, t9.ticket_order_cnt, t9.ticket_order_amt, t9.ticket_back_cnt, t9.ticket_back_amt, t9.order_3rd_cnt, 
t9.order_wallet_cnt, t9.order_cnt_total, t9.order_3rd_amt, t9.order_wallet_amt, t9.order_amt_total, t9.back_3rd_cnt, t9.back_wallet_cnt, 
t9.back_3rd_amt, t9.back_wallet_amt, t9.pre_order_cnt, t9.pre_order_amt, t9.pre_back_cnt, t9.pre_back_amt, t9.cnt_50, t9.cnt_100, t9.cnt_200, 
t9.cnt_500, t9.cnt_1000, t9.cnt_2000, t9.cnt_5000, t9.recharg_cnt_total, t9.amt_50, t9.amt_100, t9.amt_200, t9.amt_500, t9.amt_1000, t9.amt_2000, 
t9.amt_5000, t9.recharg_amt_total, 
round(((t9.ticket_order_amt - t9.ticket_back_amt) + 
	(t9.order_amt_total - t9.back_3rd_amt - t9.back_wallet_amt) + 
	(t9.pre_order_amt - t9.pre_back_amt)), 2) consume_amt_total, 
round((t9.recharg_amt_total + t9.order_3rd_amt + ticket_order_3rd_amt + pre_order_3rd_amt - 
	((t9.ticket_order_amt - t9.ticket_back_amt) + 
		(t9.order_amt_total - t9.back_3rd_amt - t9.back_wallet_amt) + 
		(t9.pre_order_amt - t9.pre_back_amt))), 2) balance_amt_total
from 
#计算除当日所有会员账户消费金额和当日所有会员账户结余金额以外的其他字段，并对null值做转0处理
(select t1.*, 
	IFNULL(t2.reg_user,0) reg_user, 
	IFNULL(t3.ticket_order_cnt,0) ticket_order_cnt, 
	IFNULL(t3.ticket_order_amt,0) ticket_order_amt, 
	IFNULL(t4.ticket_back_cnt,0) ticket_back_cnt, 
	IFNULL(t4.ticket_back_amt,0) ticket_back_amt,
	IFNULL(t3a.ticket_order_3rd_amt,0) ticket_order_3rd_amt,	
	IFNULL(t5.order_3rd_cnt,0) order_3rd_cnt, 
	IFNULL(t5.order_wallet_cnt,0) order_wallet_cnt, 
	IFNULL(t5.order_cnt_total,0) order_cnt_total, 
	IFNULL(t5.order_3rd_amt,0) order_3rd_amt, 
	IFNULL(t5.order_wallet_amt,0) order_wallet_amt, 
	IFNULL(t5.order_amt_total,0) order_amt_total, 
	IFNULL(t6.back_3rd_cnt,0) back_3rd_cnt, 
	IFNULL(t6.back_wallet_cnt,0) back_wallet_cnt, 
	IFNULL(t6.back_3rd_amt,0) back_3rd_amt, 
	IFNULL(t6.back_wallet_amt,0) back_wallet_amt, 
	IFNULL(t7.pre_order_cnt,0) pre_order_cnt, 
	IFNULL(t7.pre_order_amt,0) pre_order_amt, 
	IFNULL(t7.pre_back_cnt,0) pre_back_cnt, 
	IFNULL(t7.pre_back_amt,0) pre_back_amt, 
	IFNULL(t7.pre_order_3rd_amt,0) pre_order_3rd_amt, 
	IFNULL(t8.cnt_50,0) cnt_50, 
	IFNULL(t8.cnt_100,0) cnt_100, 
	IFNULL(t8.cnt_200,0) cnt_200, 
	IFNULL(t8.cnt_500,0) cnt_500, 
	IFNULL(t8.cnt_1000,0) cnt_1000, 
	IFNULL(t8.cnt_2000,0) cnt_2000, 
	IFNULL(t8.cnt_5000,0) cnt_5000,
	IFNULL(t8.recharg_cnt_total,0) recharg_cnt_total, 
	IFNULL(t8.amt_50,0) amt_50, 
	IFNULL(t8.amt_100,0) amt_100, 
	IFNULL(t8.amt_200,0) amt_200, 
	IFNULL(t8.amt_500,0) amt_500, 
	IFNULL(t8.amt_1000,0) amt_1000, 
	IFNULL(t8.amt_2000,0) amt_2000, 
	IFNULL(t8.amt_5000,0) amt_5000,
	IFNULL(t8.recharg_amt_total,0) recharg_amt_total 
from (select * from t_calendar where date <= date_sub(curdate(), interval 1 day)) t1 
LEFT JOIN 
#注册用户数
(select date_format(optDate, '%Y-%m-%d') date, count(mobile) reg_user from app_user_info where isActive!=0 group by date_format(optDate, '%Y-%m-%d')) t2 
on t1.date = t2.date left join 
#火车购票（订票）
(SELECT a.date, count(a.order_id) ticket_order_cnt, sum(b.order_amount) ticket_order_amt from 
(SELECT date_format(submit_time, '%Y-%m-%d') date, order_id from ticket_order_info) a,
(SELECT order_id, order_amount from ticket_order_detail where order_status = 4) b 
where a.order_id = b.order_id group by a.date) t3
on t1.date = t3.date left join 
#火车购票（退票）
(select a.date, count(a.order_id) ticket_back_cnt, sum(b.refund_money) ticket_back_amt from 
(SELECT date_format(refund_time, '%Y-%m-%d') date, order_id from ticket_order_info where refund_sign = 1) a, 
(SELECT order_id, refund_money from ticket_order_detail where order_status = 7) b
where a.order_id = b.order_id group by a.date) t4 
on t1.date = t4.date left join 
#新增火车购票（第三方支付）
(SELECT a.date, count(a.order_id) ticket_order_3rd_cnt, sum(b.order_amount) ticket_order_3rd_amt from 
(SELECT date_format(submit_time, '%Y-%m-%d') date, order_id from ticket_order_info where pay_type not in(1)) a,
(SELECT order_id, order_amount from ticket_order_detail where order_status = 4) b 
where a.order_id = b.order_id group by a.date) t3a
on t1.date = t3a.date left join 
#列车点餐（订餐）
(select a.date, b.order_wallet_cnt order_wallet_cnt, c.order_3rd_cnt order_3rd_cnt, (b.order_wallet_cnt + c.order_3rd_cnt) order_cnt_total, 
b.order_wallet_amt order_wallet_amt, c.order_3rd_amt order_3rd_amt, (b.order_wallet_amt + c.order_3rd_amt) order_amt_total from 
t_calendar a LEFT JOIN 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) order_wallet_cnt, sum(actualAmt) order_wallet_amt from order_info 
where orderStatus in(1,2,3,4) and orderType != 9 and payMethod = 0 group by date_format(orderDate, '%Y-%m-%d')) b
on a.date = b.date left join 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) order_3rd_cnt, sum(actualAmt) order_3rd_amt from order_info 
where orderStatus in(1,2,3,4) and orderType != 9 and (payMethod = 1 or payMethod = 2) group by date_format(orderDate, '%Y-%m-%d')) c
on a.date = c.date) t5
on t1.date = t5.date left join 
#列车点餐（退单）
(select a.date, b.back_wallet_cnt, c.back_3rd_cnt, b.back_wallet_amt, c.back_3rd_amt from t_calendar a LEFT JOIN 
(select date_format(orderDate, '%Y-%m-%d') date, count(orderNo) back_wallet_cnt, sum(actualAmt) back_wallet_amt from 
 order_info where orderStatus = 7 and orderType != 9 and payMethod = 0 
GROUP BY date_format(orderDate, '%Y-%m-%d')) b 
on a.date = b.date left join 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) back_3rd_cnt, sum(actualAmt) back_3rd_amt from
 order_info where orderStatus = 7 and orderType != 9 and (payMethod = 1 or payMethod = 2) group by date_format(orderDate, '%Y-%m-%d')) c
ON a.date = c.date) t6 
on t1.date = t6.date left join
#提前订餐（订单/退单）
(select a.date, b.pre_order_cnt, b.pre_order_amt, c.pre_back_cnt, c.pre_back_amt , d.pre_order_3rd_amt from 
t_calendar a left join 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) pre_order_cnt, sum(actualAmt) pre_order_amt from 
order_info where orderStatus in(1,2,3,4) and orderType = 9 group by date_format(orderDate, '%Y-%m-%d')) b 
ON a.date = b.date LEFT JOIN 
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) pre_back_cnt, sum(actualAmt) pre_back_amt from 
order_info where orderStatus = 7 and orderType = 9 group by date_format(orderDate, '%Y-%m-%d')) c 
ON a.date = c.date left join
#新增提前订餐（第三方支付）
(SELECT date_format(orderDate, '%Y-%m-%d') date, count(orderNo) pre_order_3rd_cnt, sum(actualAmt) pre_order_3rd_amt from 
order_info where orderStatus in(1,2,3,4) and orderType = 9 and (payMethod = 1 or payMethod = 2) group by date_format(orderDate, '%Y-%m-%d')) d
on a.date = d.date) t7
on t1.date = t7.date left join 
#会员充值
(SELECT
b.date,
SUM(IF(b.amt_standerd='50', b.cnt_total, 0)) AS cnt_50,
SUM(IF(b.amt_standerd='100', b.cnt_total, 0)) AS cnt_100,
SUM(IF(b.amt_standerd='200', b.cnt_total, 0)) AS cnt_200,
SUM(IF(b.amt_standerd='500', b.cnt_total, 0)) AS cnt_500,
SUM(IF(b.amt_standerd='1000', b.cnt_total, 0)) AS cnt_1000,
SUM(IF(b.amt_standerd='2000', b.cnt_total, 0)) AS cnt_2000,
SUM(IF(b.amt_standerd='5000', b.cnt_total, 0)) AS cnt_5000,
SUM(IF(b.amt_standerd is NULL, b.cnt_total, 0)) AS recharg_cnt_total,
SUM(IF(b.amt_standerd='50', b.amt_total, 0)) AS amt_50,
SUM(IF(b.amt_standerd='100', b.amt_total, 0)) AS amt_100,
SUM(IF(b.amt_standerd='200', b.amt_total, 0)) AS amt_200,
SUM(IF(b.amt_standerd='500', b.amt_total, 0)) AS amt_500,
SUM(IF(b.amt_standerd='1000', b.amt_total, 0)) AS amt_1000,
SUM(IF(b.amt_standerd='2000', b.amt_total, 0)) AS amt_2000,
SUM(IF(b.amt_standerd='5000', b.amt_total, 0)) AS amt_5000,
SUM(IF(b.amt_standerd is null, b.amt_total, 0)) AS recharg_amt_total 
FROM 
(SELECT a.date ,IFNULL(a.amount, null) AS amt_standerd, SUM(cnt_total) AS cnt_total, SUM(amt_total) AS amt_total 
FROM 
(select date_format(date, '%Y-%m-%d') date, amount, count(amount) cnt_total, sum(amount) amt_total from 
recharge_info where success = 1 group by date_format(date, '%Y-%m-%d'), amount having amount in(50,100,200,500,1000,2000,5000)) a 
GROUP BY a.date, IFNULL(a.amount, null)
WITH ROLLUP
HAVING a.date IS NOT NULL) b
GROUP BY b.date) t8 
on t1.date = t8.date) t9
ORDER BY t9.date
);

#添加备注
ALTER table report_day MODIFY `date` date NOT NULL COMMENT '日期';
ALTER table report_day MODIFY `week` int(2) NOT NULL COMMENT '周';
ALTER table report_day MODIFY `reg_user` bigint(21) NOT NULL DEFAULT '0' COMMENT '注册用户数量';
ALTER table report_day MODIFY `ticket_order_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '火车购票订单数量';
ALTER table report_day MODIFY `ticket_order_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '火车购票订单金额';
ALTER table report_day MODIFY `ticket_back_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '火车票退票单数';
ALTER table report_day MODIFY `ticket_back_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '火车票退票金额';
ALTER table report_day MODIFY `order_3rd_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '列车点餐第三方支付单数';
ALTER table report_day MODIFY `order_wallet_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '列车点餐钱包支付单数';
ALTER table report_day MODIFY `order_cnt_total` bigint(22) NOT NULL DEFAULT '0' COMMENT '列车点餐支付总单数';
ALTER table report_day MODIFY `order_3rd_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐第三方支付金额';
ALTER table report_day MODIFY `order_wallet_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐钱包支付金额';
ALTER table report_day MODIFY `order_amt_total` decimal(32,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐支付总金额';
ALTER table report_day MODIFY `back_3rd_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '列车点餐退单次数（第三方支付方式）';
ALTER table report_day MODIFY `back_wallet_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '列车点餐退单次数（钱包支付方式）';
ALTER table report_day MODIFY `back_3rd_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐退单金额（第三方支付方式）';
ALTER table report_day MODIFY `back_wallet_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '列车点餐退单金额（钱包支付方式）';
ALTER table report_day MODIFY `pre_order_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '预订单数量';
ALTER table report_day MODIFY `pre_order_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '预订单金额';
ALTER table report_day MODIFY `pre_back_cnt` bigint(21) NOT NULL DEFAULT '0' COMMENT '预订单退单数量';
ALTER table report_day MODIFY `pre_back_amt` decimal(31,2) NOT NULL DEFAULT '0.00' COMMENT '预订单退单金额';
ALTER table report_day MODIFY `cnt_50` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（50元）';
ALTER table report_day MODIFY `cnt_100` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（100元）';
ALTER table report_day MODIFY `cnt_200` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（200元）';
ALTER table report_day MODIFY `cnt_500` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（500元）';
ALTER table report_day MODIFY `cnt_1000` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（1000元）';
ALTER table report_day MODIFY `cnt_2000` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（2000元）';
ALTER table report_day MODIFY `cnt_5000` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数（5000元）';
ALTER table report_day MODIFY `recharg_cnt_total` bigint(21) NOT NULL DEFAULT '0' COMMENT '会员充值次数总计';
ALTER table report_day MODIFY `amt_50` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（50元）';
ALTER table report_day MODIFY `amt_100` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（100元）';
ALTER table report_day MODIFY `amt_200` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（200元）';
ALTER table report_day MODIFY `amt_500` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（500元）';
ALTER table report_day MODIFY `amt_1000` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（1000元）';
ALTER table report_day MODIFY `amt_2000` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（2000元）';
ALTER table report_day MODIFY `amt_5000` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额（5000元）';
ALTER table report_day MODIFY `recharg_amt_total` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '会员充值金额总计';
ALTER table report_day MODIFY `consume_amt_total` decimal(36,2) NOT NULL DEFAULT '0.00' COMMENT '当日所有会员账户消费金额';
ALTER table report_day MODIFY `balance_amt_total` decimal(65,2) NOT NULL DEFAULT '0.00' COMMENT '当日所有会员账户结余金额';

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for p_reward
-- ----------------------------
DROP PROCEDURE IF EXISTS `p_reward`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_reward`()
BEGIN
	
	INSERT INTO tb_money(name, mobile, reward, bonus, releaseDate) 

	SELECT name, mobile, sum(orderCnt * 63) reward, 0, DATE_FORMAT(CURDATE(),'%Y-%m-%d') releaseDate FROM tb_order 
		WHERE orderStatus = 1 GROUP BY name, mobile, bonusAlready, releaseDate;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for tb_calendar
-- ----------------------------
DROP PROCEDURE IF EXISTS `tb_calendar`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `tb_calendar`()
BEGIN
#生成临时表，用于构造日历表
	DROP TABLE IF EXISTS tmp_calendar;
	CREATE TABLE tmp_calendar(i int(1));
	INSERT INTO tmp_calendar(i) VALUES (0), (1), (2), (3), (4), (5), (6), (7), (8), (9);
#生成日历表
	DROP TABLE IF EXISTS t_calendar;
	CREATE TABLE t_calendar
	(SELECT a.date, WEEK(a.date, 1) week from 
	(select adddate('2016-01-01', numlist.id) as 'date' from 
	(SELECT n1.i + n10.i*10 + n100.i*100 AS id FROM tmp_calendar n1 cross join tmp_calendar as n10 cross join tmp_calendar as n100) as numlist 
	where adddate('2016-01-01', numlist.id) <= '2017-12-31' ) a ORDER BY a.date);
#转成date格式
	ALTER table t_calendar MODIFY `date` date NOT NULL COMMENT '日期';
#删除临时表
	DROP TABLE IF EXISTS tmp_calendar;
	
END
;;
DELIMITER ;

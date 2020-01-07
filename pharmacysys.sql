/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : pharmacysys
Target Host     : localhost:3306
Target Database : pharmacysys
Date: 2020-01-07 16:46:44
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) DEFAULT NULL COMMENT '商品名称',
  `code` varchar(20) NOT NULL COMMENT '商品编号',
  `type` varchar(10) DEFAULT NULL COMMENT '商品分类',
  `purchaseprice` decimal(10,2) DEFAULT NULL COMMENT '预计进价',
  `sellprice` decimal(10,2) DEFAULT NULL COMMENT '预设售价',
  `summary` varchar(300) DEFAULT NULL COMMENT '商品简介',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifield_time` datetime DEFAULT NULL COMMENT '修改时间',
  `user_id` int(10) DEFAULT NULL COMMENT '创建id',
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`,`code`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('8', '舒筋活血片', '11012758', '风湿骨伤类', '15.00', '20.00', '0.3g*108s', '2019-04-14 18:40:00', '2019-04-14 18:40:00', '1', '2');
INSERT INTO `goods` VALUES ('9', '东方活血膏', '12081444', '风湿骨伤类', '26.00', '32.00', '5g*2贴', '2019-04-14 18:45:42', '2019-04-14 18:45:42', '1', '2');
INSERT INTO `goods` VALUES ('10', '板蓝根颗粒', '12041665', '清热解毒类', '10.00', '20.00', '10g*20袋', '2019-04-14 18:47:15', '2019-04-16 14:03:11', '1', '2');
INSERT INTO `goods` VALUES ('11', '牛黄解毒片', '11016133', '清热解毒类', '5.00', '10.00', '12s*2板', '2019-04-14 18:48:23', '2019-04-14 18:48:23', '1', '2');
INSERT INTO `goods` VALUES ('12', '双黄连口服液', '12051834', '清热解毒类', '8.00', '12.00', '10ml*10支', '2019-04-14 18:49:15', '2019-04-14 18:49:15', '1', '2');
INSERT INTO `goods` VALUES ('13', '感冒解毒颗粒', '332Z06206', '感冒解毒类', '8.00', '12.00', '10g*10s', '2019-04-14 18:50:06', '2019-04-14 18:50:06', '1', '2');
INSERT INTO `goods` VALUES ('14', '999感冒灵颗粒', 'Z44021940', '感冒解毒类', '15.00', '20.00', '10g*9s', '2019-04-14 18:51:39', '2019-04-14 18:51:39', '1', '2');
INSERT INTO `goods` VALUES ('15', '氨苯伪麻片', 'H10950308', '麻黄碱复方制剂类', '8.00', '12.00', '0.35g*20片', '2019-04-14 18:52:36', '2019-04-14 18:52:36', '1', '2');
INSERT INTO `goods` VALUES ('16', '布洛伪麻颗粒', 'H10970153', '麻黄碱复方制剂类', '5.00', '10.00', '30mg*6包', '2019-04-14 18:53:29', '2019-04-14 18:53:29', '1', '2');
INSERT INTO `goods` VALUES ('17', '诺氟沙星', 'A14200011739', '抗菌消炎类', '3.00', '6.00', '0.1g*24s', '2019-04-14 18:56:22', '2019-04-14 18:56:22', '1', '1');
INSERT INTO `goods` VALUES ('18', '罗红霉素', 'A14202031264', '抗菌消炎类', '3.00', '6.00', '0.15g*6s', '2019-04-14 18:57:38', '2019-04-14 18:57:38', '1', '2');
INSERT INTO `goods` VALUES ('19', '阿莫西林胶囊', 'H31020363', '感冒类', '5.00', '10.00', '0.25*24粒', '2019-04-14 18:58:35', '2019-05-10 10:32:07', '1', '1');
INSERT INTO `goods` VALUES ('20', '人工牛黄甲硝唑', 'H22024285', '感冒类', '4.00', '6.00', '24粒', '2019-04-14 18:59:22', '2019-04-14 18:59:22', '1', '1');
INSERT INTO `goods` VALUES ('21', '复方酮康唑发用洗剂', 'H20058545', '外用药类', '20.00', '29.00', '100ml', '2019-04-14 19:02:04', '2019-04-14 19:02:04', '1', '2');
INSERT INTO `goods` VALUES ('22', '复方酮康唑软膏', 'H53022106', '外用药类', '8.00', '12.00', '10个/支', '2019-04-14 19:03:11', '2019-04-14 19:03:11', '1', '2');
INSERT INTO `goods` VALUES ('23', '尼美舒利颗粒', 'D14200005489', '儿科用药', '7.00', '10.00', '500mg*10袋', '2019-04-14 19:04:01', '2019-04-14 19:04:01', '1', '2');
INSERT INTO `goods` VALUES ('24', '布洛芬混悬液(美林）', 'D12200001630', '儿科用药', '15.00', '21.00', '100ml', '2019-04-14 19:04:46', '2019-04-14 19:04:46', '1', '2');
INSERT INTO `goods` VALUES ('25', '利咽解毒颗粒', 'Z13020787', '咽喉类', '16.00', '23.00', '6g*10袋', '2019-04-14 19:05:40', '2019-04-14 19:05:40', '1', '1');
INSERT INTO `goods` VALUES ('26', '清喉咽颗粒', 'Z50020109', '咽喉类', '12.00', '18.00', '18g/袋', '2019-04-14 19:06:32', '2019-04-14 19:06:32', '1', '2');
INSERT INTO `goods` VALUES ('27', '益母草膏', 'Z21020059', '妇科用药类', '15.00', '20.00', '125g/瓶', '2019-04-14 19:07:28', '2019-04-14 19:07:28', '1', '2');
INSERT INTO `goods` VALUES ('28', '当归红枣颗粒', '14000292161', '妇科用药类', '20.00', '25.00', '20g*12袋', '2019-04-14 19:08:24', '2019-04-14 19:08:24', '1', '2');
INSERT INTO `goods` VALUES ('29', '叶酸片', 'H20103724', '维生素及矿物质类', '15.00', '20.00', '0.4mg/片', '2019-04-14 19:09:10', '2019-04-14 19:09:10', '1', '2');
INSERT INTO `goods` VALUES ('30', '甘草锌颗粒', 'H19993277', '维生素及矿物质类', '12.00', '15.00', '1.5g/片', '2019-04-14 19:09:54', '2019-04-14 19:09:54', '1', '2');
INSERT INTO `goods` VALUES ('31', '复方丹参片', 'B14002002475', '其他', '7.00', '11.00', '60s', '2019-04-14 19:10:35', '2019-04-14 19:10:35', '1', '2');
INSERT INTO `goods` VALUES ('32', '胃苏颗粒', 'B12000607474', '其他', '30.00', '36.00', '15g*9袋', '2019-04-14 19:11:18', '2019-04-14 19:11:18', '1', '2');
INSERT INTO `goods` VALUES ('33', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '', '2019-04-16 14:02:28', '2019-04-16 14:02:28', '1', '2');
INSERT INTO `goods` VALUES ('34', '感冒灵', '12345612', '感冒类', '10.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:25', '2019-05-10 10:28:25', '1', '2');
INSERT INTO `goods` VALUES ('35', '感冒灵', '12345612', '感冒类', '10.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:25', '2019-05-10 10:28:25', '1', '2');
INSERT INTO `goods` VALUES ('36', '感冒灵', '12345612', '感冒类', '10.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:27', '2019-05-10 10:28:27', '1', '2');
INSERT INTO `goods` VALUES ('37', '感冒灵', '12345612', '感冒类', '10.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:27', '2019-05-10 10:28:27', '1', '2');
INSERT INTO `goods` VALUES ('38', '感冒灵', '12345612', '感冒类', '10.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:28', '2019-05-10 10:28:28', '1', '2');
INSERT INTO `goods` VALUES ('39', '感冒灵', '12345612', '感冒类', '10.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:28', '2019-05-10 10:28:28', '1', '2');
INSERT INTO `goods` VALUES ('40', '感冒灵', '12345612', '感冒类', '10.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:29', '2019-05-10 10:28:29', '1', '2');
INSERT INTO `goods` VALUES ('41', '感冒灵', '12345612', '感冒类', '10.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:29', '2019-05-10 10:28:29', '1', '2');
INSERT INTO `goods` VALUES ('42', '感冒灵', '12345612', '感冒类', '10.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:29', '2019-05-10 10:28:29', '1', '2');
INSERT INTO `goods` VALUES ('43', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:41', '2019-05-10 10:28:41', '1', '2');
INSERT INTO `goods` VALUES ('44', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:42', '2019-05-10 10:28:42', '1', '2');
INSERT INTO `goods` VALUES ('45', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:42', '2019-05-10 10:28:42', '1', '2');
INSERT INTO `goods` VALUES ('46', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:43', '2019-05-10 10:28:43', '1', '2');
INSERT INTO `goods` VALUES ('47', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:43', '2019-05-10 10:28:43', '1', '2');
INSERT INTO `goods` VALUES ('48', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:28:43', '2019-05-10 10:28:43', '1', '2');
INSERT INTO `goods` VALUES ('49', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:29:08', '2019-05-10 10:29:08', '1', '2');
INSERT INTO `goods` VALUES ('50', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:29:08', '2019-05-10 10:29:08', '1', '2');
INSERT INTO `goods` VALUES ('51', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:29:08', '2019-05-10 10:29:08', '1', '2');
INSERT INTO `goods` VALUES ('52', '感冒灵', '12345612', '感冒类', '12.00', '20.00', '嘻嘻嘻', '2019-05-10 10:29:08', '2019-05-10 10:29:08', '1', '2');

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` int(40) NOT NULL DEFAULT '0' COMMENT '商品编号',
  `incount` int(10) DEFAULT NULL COMMENT '库存量',
  `sellcount` int(10) DEFAULT NULL COMMENT '销售量',
  `lastpurchaseprice` decimal(10,2) DEFAULT NULL COMMENT '上次进价',
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
  `lastsellprice` decimal(10,2) DEFAULT NULL COMMENT '上一次销售价',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifield_time` datetime DEFAULT NULL COMMENT '修改时间',
  `inventorytotal` decimal(20,2) DEFAULT NULL COMMENT '库存总值',
  `selltotal` decimal(20,2) DEFAULT NULL COMMENT '价售总值',
  PRIMARY KEY (`id`,`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES ('5', '8', '180', '20', '20.00', '1', '20.00', '2019-04-14 18:40:00', '2019-04-16 14:07:55', '3600.00', '3600.00');
INSERT INTO `inventory` VALUES ('6', '9', '0', '0', '26.00', '1', null, '2019-04-14 18:45:42', '2019-04-14 18:45:42', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('7', '10', '20', '30', '15.00', '1', '20.00', '2019-04-14 18:47:15', '2019-04-16 13:33:04', '300.00', '400.00');
INSERT INTO `inventory` VALUES ('8', '11', '30', '0', '20.00', '1', null, '2019-04-14 18:48:23', '2019-04-15 13:01:36', '600.00', '0.00');
INSERT INTO `inventory` VALUES ('9', '12', '0', '0', '8.00', '1', null, '2019-04-14 18:49:15', '2019-04-14 18:49:15', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('10', '13', '0', '0', '8.00', '1', null, '2019-04-14 18:50:06', '2019-04-14 18:50:06', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('11', '14', '0', '0', '15.00', '1', null, '2019-04-14 18:51:39', '2019-04-14 18:51:39', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('12', '15', '0', '0', '8.00', '1', null, '2019-04-14 18:52:36', '2019-04-14 18:52:36', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('13', '16', '0', '0', '5.00', '1', null, '2019-04-14 18:53:29', '2019-04-14 18:53:29', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('14', '17', '40', '40', '20.00', '1', '20.00', '2019-04-14 18:56:22', '2019-05-10 11:36:01', '800.00', '800.00');
INSERT INTO `inventory` VALUES ('15', '18', '0', '0', '3.00', '1', null, '2019-04-14 18:57:38', '2019-04-14 18:57:38', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('16', '19', '0', '0', '6.00', '1', null, '2019-04-14 18:58:35', '2019-04-14 18:58:35', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('17', '20', '0', '0', '4.00', '1', null, '2019-04-14 18:59:22', '2019-04-14 18:59:22', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('18', '21', '0', '0', '20.00', '1', null, '2019-04-14 19:02:04', '2019-04-14 19:02:04', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('19', '22', '0', '0', '8.00', '1', null, '2019-04-14 19:03:11', '2019-04-14 19:03:11', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('20', '23', '0', '0', '7.00', '1', null, '2019-04-14 19:04:01', '2019-04-14 19:04:01', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('21', '24', '0', '0', '15.00', '1', null, '2019-04-14 19:04:46', '2019-04-14 19:04:46', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('22', '25', '0', '0', '16.00', '1', null, '2019-04-14 19:05:40', '2019-04-14 19:05:40', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('23', '26', '0', '0', '12.00', '1', null, '2019-04-14 19:06:32', '2019-04-14 19:06:32', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('24', '27', '0', '0', '15.00', '1', null, '2019-04-14 19:07:28', '2019-04-14 19:07:28', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('25', '28', '0', '0', '20.00', '1', null, '2019-04-14 19:08:24', '2019-04-14 19:08:24', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('26', '29', '0', '0', '15.00', '1', null, '2019-04-14 19:09:10', '2019-04-14 19:09:10', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('27', '30', '0', '0', '12.00', '1', null, '2019-04-14 19:09:54', '2019-04-14 19:09:54', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('28', '31', '0', '0', '7.00', '1', null, '2019-04-14 19:10:35', '2019-04-14 19:10:35', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('29', '32', '0', '0', '30.00', '1', null, '2019-04-14 19:11:18', '2019-04-14 19:11:18', '0.00', '0.00');
INSERT INTO `inventory` VALUES ('30', '33', '0', '0', '12.00', '1', null, '2019-04-16 14:02:28', '2019-04-16 14:02:28', '0.00', '0.00');

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) DEFAULT NULL COMMENT '供应商名字',
  `linkman` varchar(10) DEFAULT NULL COMMENT '联系人',
  `mobile` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `addres` varchar(50) DEFAULT NULL COMMENT '联系地址',
  `summary` varchar(50) DEFAULT NULL COMMENT '描述',
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifield_time` datetime DEFAULT NULL COMMENT '修改时间',
  `user_id` int(10) DEFAULT NULL COMMENT '更新人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of provider
-- ----------------------------
INSERT INTO `provider` VALUES ('26', '洛阳顺势药业有限公司', '李毅', '18238642530', '河南洛阳', '0.3g*108s', '1', '2019-04-14 19:14:54', '2019-04-14 19:14:54', '1');
INSERT INTO `provider` VALUES ('27', '山东明仁福瑞达制药股份有限公司', '王文', '18235612500', '山东济南', '', '1', '2019-04-14 19:24:07', '2019-04-14 19:24:07', '1');
INSERT INTO `provider` VALUES ('28', '四川逢春制药有限公司', '李为', '15237333640', '四川成都', '', '1', '2019-04-14 19:24:59', '2019-04-16 14:05:00', '1');
INSERT INTO `provider` VALUES ('29', '温州海鹤药业有限公司', '张琪', '15835353187', '浙江温州', '', '1', '2019-04-14 19:25:47', '2019-04-14 19:25:47', '1');
INSERT INTO `provider` VALUES ('30', '黑龙江喜人药业集团有限公司', '吴丽', '15687545623', '黑龙江哈尔滨', '', '1', '2019-04-14 19:26:23', '2019-04-14 19:26:23', '1');
INSERT INTO `provider` VALUES ('31', '111', '111', '23123', 'dsda', '1111111111', '2', '2019-04-15 10:13:26', '2019-04-15 10:13:32', '1');
INSERT INTO `provider` VALUES ('32', '感冒灵', '张盼', '18238600894', '哈喃', '', '2', '2019-04-16 14:04:38', '2019-04-16 14:04:38', '1');
INSERT INTO `provider` VALUES ('33', '黑龙江', '李为', '18238600894', '哈喃', '嘻嘻嘻', '2', '2019-05-10 09:01:10', '2019-05-10 09:01:10', '1');
INSERT INTO `provider` VALUES ('34', '黑龙江喜人药业集团有限公司', '张盼', '18238600894', '哈喃', '嘻嘻嘻', '2', '2019-05-10 09:02:10', '2019-05-10 10:59:34', '1');
INSERT INTO `provider` VALUES ('35', '感冒灵', '李为', '18238600894', '哈喃', '嘻嘻嘻', '2', '2019-05-10 10:59:14', '2019-05-10 10:59:14', '3');

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_id` int(10) DEFAULT NULL COMMENT '商品id',
  `provider_id` int(10) DEFAULT NULL COMMENT '供应商id',
  `ordercode` varchar(30) DEFAULT NULL COMMENT '订单号',
  `count` int(10) DEFAULT NULL COMMENT '数量',
  `unitprice` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `totalprice` decimal(20,2) DEFAULT NULL COMMENT '总价',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modifield_time` datetime DEFAULT NULL COMMENT '修改时间',
  `user_id` int(10) DEFAULT NULL COMMENT '更新人id',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `state` varchar(10) DEFAULT NULL COMMENT '状态 0审核 1 正常 2 删除 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('19', '8', '30', 'P20190414192804', '100', '15.00', '1500.00', '2019-04-14 19:28:04', '2019-04-14 19:28:04', '1', null, '1');
INSERT INTO `purchase` VALUES ('20', '10', '30', 'P20190414193715', '50', '15.00', '750.00', '2019-04-14 19:37:15', '2019-04-14 19:37:15', '1', null, '1');
INSERT INTO `purchase` VALUES ('21', '17', '30', 'P20190415130104', '20', '20.00', '400.00', '2019-04-15 13:01:04', '2019-04-15 13:01:04', '3', null, '2');
INSERT INTO `purchase` VALUES ('22', '11', '30', 'P20190415130120', '30', '20.00', '600.00', '2019-04-15 13:01:20', '2019-04-15 13:01:20', '3', null, '1');
INSERT INTO `purchase` VALUES ('23', '8', '28', 'P20190416140625', '100', '20.00', '2000.00', '2019-04-16 14:06:25', '2019-04-16 14:06:25', '3', null, '1');
INSERT INTO `purchase` VALUES ('24', '17', '34', 'P20190510090236', '20', '20.00', '400.00', '2019-05-10 09:02:36', '2019-05-10 09:02:36', '1', null, '1');
INSERT INTO `purchase` VALUES ('25', '17', '28', 'P20190510110124', '20', '20.00', '400.00', '2019-05-10 11:01:24', '2019-05-10 11:01:24', '3', null, '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `remark` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '管理员');
INSERT INTO `role` VALUES ('3', 'inventoryperson', '库存管理员');
INSERT INTO `role` VALUES ('4', 'sellperson', '销售员');

-- ----------------------------
-- Table structure for sell
-- ----------------------------
DROP TABLE IF EXISTS `sell`;
CREATE TABLE `sell` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ordercode` varchar(30) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifield_time` datetime DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL COMMENT '状态 0审核 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sell
-- ----------------------------
INSERT INTO `sell` VALUES ('13', 'P20190414193543', '2019-04-14 19:35:43', '2019-04-14 19:35:43', '1', '10盒舒筋活血片', '1');
INSERT INTO `sell` VALUES ('14', 'P20190416133304', '2019-04-16 13:33:04', '2019-04-16 13:33:04', '1', '', '1');
INSERT INTO `sell` VALUES ('15', 'P20190416140755', '2019-04-16 14:07:55', '2019-04-16 14:07:55', '4', '', '1');
INSERT INTO `sell` VALUES ('16', 'P20190510105630', '2019-05-10 10:56:30', '2019-05-10 10:56:30', '4', '', '1');
INSERT INTO `sell` VALUES ('17', 'P20190510111005', '2019-05-10 11:10:05', '2019-05-10 11:10:05', '4', '诺氟沙星', '1');

-- ----------------------------
-- Table structure for selldetail
-- ----------------------------
DROP TABLE IF EXISTS `selldetail`;
CREATE TABLE `selldetail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goods_id` int(10) DEFAULT NULL,
  `provider_id` int(10) DEFAULT NULL,
  `count` int(10) DEFAULT NULL,
  `unitprice` decimal(10,2) DEFAULT NULL,
  `totalprice` decimal(20,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifield_time` datetime DEFAULT NULL,
  `sell_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of selldetail
-- ----------------------------
INSERT INTO `selldetail` VALUES ('15', '8', null, '10', '20.00', '200.00', '2019-04-14 19:35:43', '2019-04-14 19:35:43', '13');
INSERT INTO `selldetail` VALUES ('16', '10', null, '30', '20.00', '600.00', '2019-04-16 13:33:04', '2019-04-16 13:33:04', '14');
INSERT INTO `selldetail` VALUES ('17', '8', null, '10', '20.00', '200.00', '2019-04-16 14:07:55', '2019-04-16 14:07:55', '15');
INSERT INTO `selldetail` VALUES ('18', '17', null, '20', '20.00', '400.00', '2019-05-10 10:56:31', '2019-05-10 10:56:31', '16');
INSERT INTO `selldetail` VALUES ('19', '17', null, '20', '20.00', '400.00', '2019-05-10 11:10:05', '2019-05-10 11:10:05', '17');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `role_id` int(10) NOT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '管理员', '111', '1');
INSERT INTO `user` VALUES ('3', '库存管理员', '111', '3');
INSERT INTO `user` VALUES ('4', '销售员', '111', '4');
INSERT INTO `user` VALUES ('5', '张盼', '111', '4');
INSERT INTO `user` VALUES ('7', '李茜倩', '123', '4');

/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : trainticket

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 15/06/2019 14:19:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPw` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for t_checi
-- ----------------------------
DROP TABLE IF EXISTS `t_checi`;
CREATE TABLE `t_checi`  (
  `id` int(11) NOT NULL DEFAULT 0,
  `riqi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bianhao` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shifadi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `daodadi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `facheshi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shengpiao` int(11) NULL DEFAULT NULL,
  `chengrenpiaojia` int(11) NULL DEFAULT NULL,
  `ertongpiaojia` int(11) NULL DEFAULT NULL,
  `del` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_checi
-- ----------------------------
INSERT INTO `t_checi` VALUES (2, '2018-02-20', 'H001', '北京', '青岛', '08:00:00', 190, 200, 150, 'yes');
INSERT INTO `t_checi` VALUES (3, '2019-06-05', 'G012', '北京', '大连', '12:00:00', 195, 180, 120, 'no');
INSERT INTO `t_checi` VALUES (4, '2019-06-05', 'G003', '北京', '南京', '12:00:00', 196, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (5, '2018-02-07', 'MU1818', '北京', '上海', '16:00:00', 197, 1590, 1288, 'yes');
INSERT INTO `t_checi` VALUES (6, '2019-06-05', 'G1110', '北京', '成都', '12:00:00', 194, 990, 698, 'no');
INSERT INTO `t_checi` VALUES (7, '2019-06-05', 'G1818', '北京', '上海', '12:00:00', 194, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (8, '2019-06-05', 'G1818', '北京', '武汉', '12:00:00', 185, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (9, '2019-06-05', 'G9191', '北京', '上海', '12:00:00', 198, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (10, '2019-06-05', 'G888', '四川', '北京', '12:00:00', 176, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (11, '2019-06-05', 'G9191', '成都', '北京', '12:00:00', 199, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (12, '2018-03-24', '111', '11', '111', '12:00:00', 200, 100, 50, 'yes');
INSERT INTO `t_checi` VALUES (13, '2019-06-06', 'T001', '黑龙江', '丽江', '12:00:00', 199, 1000, 500, 'no');
INSERT INTO `t_checi` VALUES (14, '2019-06-07', 'K001', '北京', '上海', '12:00:00', 200, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (15, '2019-06-07', 'K002', '北京', '拉萨', '12:00:00', 200, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (16, '2019-06-07', 'K003', '北京', '南京', '12:00:00', 200, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (17, '2019-06-07', 'G001', '北京', '四川', '12:00:00', 198, 100, 50, 'no');
INSERT INTO `t_checi` VALUES (18, '2019-06-07', 'G002', '北京', '杭州', '12:00:00', 200, 100, 50, 'no');

-- ----------------------------
-- Table structure for t_gonggao
-- ----------------------------
DROP TABLE IF EXISTS `t_gonggao`;
CREATE TABLE `t_gonggao`  (
  `id` int(11) NOT NULL,
  `gonggao` varchar(4000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `del` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_gonggao
-- ----------------------------
INSERT INTO `t_gonggao` VALUES (1, '明天大雪封天，到成都的旅客请注意', 'no');
INSERT INTO `t_gonggao` VALUES (2, '1111111111111', 'yes');

-- ----------------------------
-- Table structure for t_liuyan
-- ----------------------------
DROP TABLE IF EXISTS `t_liuyan`;
CREATE TABLE `t_liuyan`  (
  `id` int(11) NOT NULL,
  `neirong` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `liuyanshi` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userId` int(11) NULL DEFAULT NULL,
  `huifu` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `huifushi` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_liuyan
-- ----------------------------
INSERT INTO `t_liuyan` VALUES (1, '希望系统可以好好优化', '2019-06-04 10:40', 2, '', '');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `userId` int(11) NULL DEFAULT NULL,
  `xiadanshi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shouhourenming` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shouhourenhua` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shouhourenzhi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zongjiage` int(11) NULL DEFAULT NULL,
  `zhuangtai` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1559611820030', 2, '2019-06-04 09:30:20', '小二', '12300000000', '111', 990, '已受理');
INSERT INTO `t_order` VALUES ('1559616012304', 2, '2019-06-04 10:40:12', '付逗', '12300000000', '北京市故宫', 1100, '未受理');
INSERT INTO `t_order` VALUES ('1559645773886', 2, '2019-06-04 06:56:13', '111', '11111111111', '1111', 180, '未受理');
INSERT INTO `t_order` VALUES ('1559784918171', 3, '2019-06-06 09:35:18', '测试用户', '15963255412', '北京市五棵松体育馆旁', 100, '已受理');

-- ----------------------------
-- Table structure for t_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `t_orderitem`;
CREATE TABLE `t_orderitem`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `orderId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `checiId` int(11) NULL DEFAULT NULL,
  `piaoleixing` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `danjia` int(11) NULL DEFAULT NULL,
  `shuliang` int(11) NULL DEFAULT NULL,
  `zuoweihao` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zwIndex` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------
INSERT INTO `t_orderitem` VALUES ('1559611785586', '1559611820030', 6, '成人票', 990, 1, ',15', ',4_4');
INSERT INTO `t_orderitem` VALUES ('1559615987244', '1559616012304', 13, '成人票', 1000, 1, ',23', ',6_4');
INSERT INTO `t_orderitem` VALUES ('1559615994954', '1559616012304', 4, '成人票', 100, 1, ',34', ',9_2');
INSERT INTO `t_orderitem` VALUES ('1559645744519', '1559645773886', 3, '成人票', 180, 1, ',12', ',3_5');
INSERT INTO `t_orderitem` VALUES ('1559784597746', '1559784918171', 17, '成人票', 100, 1, ',17', ',5_1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pw` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_age` int(50) NULL DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_del` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'liusan', '123123', '刘三', '男', 33, '北京路', '13222222222', 'yes');
INSERT INTO `t_user` VALUES (2, 'ceshi', '123123', '测试', '女', 33, '北京三元桥', '12123123', 'no');
INSERT INTO `t_user` VALUES (3, 'ceshi1', '123123', '测试用户', '男', 25, '北京市五棵松体育馆旁', '15963255412', 'no');

-- ----------------------------
-- Table structure for t_xunwu
-- ----------------------------
DROP TABLE IF EXISTS `t_xunwu`;
CREATE TABLE `t_xunwu`  (
  `id` int(11) NOT NULL,
  `neirong` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `xunwushi` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `huifu` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `huifushi` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_xunwu
-- ----------------------------
INSERT INTO `t_xunwu` VALUES (1, '本人在G001列车上丢失一部手机，座位是15号座', '2019-06-13 13:20', '2', '已找到，请在铁路服务中心领取', '2019-06-13 13:23');

SET FOREIGN_KEY_CHECKS = 1;

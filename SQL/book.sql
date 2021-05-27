/*
 Navicat Premium Data Transfer

 Source Server         : chw
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 27/05/2021 18:38:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `sales` int(255) NOT NULL,
  `stock` int(255) NOT NULL,
  `img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 'java从入门到放弃', '国哥', 80.00, 1020, 999, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (2, '数据结构与算法', '严敏君', 78.50, 22, 99900, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (3, '怎样拐跑别人的媳妇', '龙伍', 68.00, 60, 520, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (4, '木虚肉盖饭', '小胖', 16.00, 47, 506, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (5, 'C++编程思想', '刚哥', 45.50, 14, 959, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (6, '蛋炒饭', '周星星', 9.90, 12, 539, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (7, '赌神', '龙伍', 66.50, 125, 535, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (8, 'Java编程思想', '阳哥', 99.50, 47, 36, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (9, 'JavaScript从入门到精通', '婷姐', 9.90, 85, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (10, 'cocos2d-x游戏编程入门', '国哥', 49.00, 52, 62, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (11, 'C语言程序设计', '谭浩强', 28.00, 52, 74, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (12, 'Lua语言程序设计', '雷丰阳', 51.50, 48, 82, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (13, '西游记', '罗贯中', 12.00, 19, 9999, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (14, '水浒传', '华仔', 33.05, 22, 88, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (15, '操作系统原理', '刘优', 133.05, 122, 188, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (16, '数据结构 java版', '封大神', 173.15, 21, 81, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (17, 'UNIX高级环境编程', '乐天', 99.15, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (18, 'javaScript高级编程', '国哥', 69.15, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (19, '大话设计模式', '国哥', 89.15, 20, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (20, '人月神话', '刚哥', 88.15, 20, 80, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (34, '1', '1', 1.00, 1, 1, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (35, '1', '1', 1.00, 1, 1, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (36, 'java核心技术', '老外', 999.00, 999999, 888888, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (37, '1', '1', 1.00, 1, 90, 'static/img/default.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `orderid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `userid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('00000000005', '2021-03-31 20:34:55', 200.00, 1, 6);

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `totalprice` decimal(11, 2) NULL DEFAULT NULL,
  `orderid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `orderid`(`orderid`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`orderid`) REFERENCES `t_order` (`orderid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES (3, 'mysql从入门到精通', 1, 20.00, 20.00, '00000000005');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', 'admin@qq.com');
INSERT INTO `t_user` VALUES (3, 'admin1', 'admin1', 'admin1@qq.com');
INSERT INTO `t_user` VALUES (4, '张三', '123', '123@qq.com');
INSERT INTO `t_user` VALUES (5, '李四', '456', '456@qq.com');
INSERT INTO `t_user` VALUES (6, 'chw111', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (7, 'chw22222', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (8, 'chw3333', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (9, 'chw666', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (10, 'chw444', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (11, 'chw555', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (12, 'chw777', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (13, 'chw123', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (14, 'chw111111111', '123456', 'chw11111@qq.com');
INSERT INTO `t_user` VALUES (15, 'chw1111111', '123456', 'chw111@qq.com');
INSERT INTO `t_user` VALUES (16, 'chw010101', '123456', 'chw@qqq.com');
INSERT INTO `t_user` VALUES (17, 'chw111222', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (18, 'chw111111', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (19, 'chw1232222', '123456', 'chw@qq.com');
INSERT INTO `t_user` VALUES (20, 'chw147', '123456', 'chw@qq.com');

SET FOREIGN_KEY_CHECKS = 1;

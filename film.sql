/*
Navicat MySQL Data Transfer

Source Server         : mysql57
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : film

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-11-04 10:55:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(6) DEFAULT NULL,
  `film_id` int(5) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL COMMENT '用户评论',
  `score` int(2) DEFAULT NULL COMMENT '影片评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', '1', '3', '不错，好看', '7');
INSERT INTO `comments` VALUES ('2', '1', '3', '1111', '9');
INSERT INTO `comments` VALUES ('5', '1', '1', '超级好看，五星好评', '9');
INSERT INTO `comments` VALUES ('6', '1', '6', '超级11111好看，五星好评', '9');
INSERT INTO `comments` VALUES ('7', '1', '6', '超级11111好看，五星好评', '9');
INSERT INTO `comments` VALUES ('14', '2', '3', null, '6');
INSERT INTO `comments` VALUES ('15', '2', '4', null, '7');
INSERT INTO `comments` VALUES ('16', '4', '7', null, '8');
INSERT INTO `comments` VALUES ('17', '3', '5', null, '6');
INSERT INTO `comments` VALUES ('18', '1', '1', '111', '2');
INSERT INTO `comments` VALUES ('19', '1', '4', '111', '8');
INSERT INTO `comments` VALUES ('20', '1', '3', '111', '4');
INSERT INTO `comments` VALUES ('21', '1', '2', '111', '6');
INSERT INTO `comments` VALUES ('22', '7', '2', '111111', '4');
INSERT INTO `comments` VALUES ('23', '7', '2', '111111', '4');
INSERT INTO `comments` VALUES ('24', '7', '2', '111111', '8');

-- ----------------------------
-- Table structure for film
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `film_id` int(5) NOT NULL AUTO_INCREMENT,
  `film_name` varchar(50) NOT NULL,
  `director` varchar(50) DEFAULT NULL,
  `duration` int(3) DEFAULT '0' COMMENT '电影时长',
  `date` date DEFAULT NULL COMMENT '上映时间',
  `price` double(3,0) NOT NULL DEFAULT '0' COMMENT '影片价格',
  `type_id` int(2) DEFAULT NULL COMMENT '电影类别',
  `image_id` int(5) DEFAULT '1' COMMENT '预览图位置',
  `save_id` int(5) DEFAULT NULL COMMENT '保存位置',
  PRIMARY KEY (`film_id`),
  KEY `film_type` (`type_id`),
  KEY `film_save` (`save_id`),
  KEY `film_image` (`image_id`),
  CONSTRAINT `film_image` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`) ON DELETE CASCADE,
  CONSTRAINT `film_save` FOREIGN KEY (`save_id`) REFERENCES `save` (`save_id`),
  CONSTRAINT `film_type` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES ('1', '金陵十三钗', '张艺谋', '111', '2019-10-18', '4', '2', '9', null);
INSERT INTO `film` VALUES ('2', '影', '张艺谋', '111', '2019-10-22', '11', '3', '10', null);
INSERT INTO `film` VALUES ('3', '山楂树之恋', '张艺谋', '133', '2016-07-20', '99', '4', '11', null);
INSERT INTO `film` VALUES ('4', '人在囧途', '徐峥', '89', '2019-10-28', '33', '5', '1', null);
INSERT INTO `film` VALUES ('5', '疯狂的石头', '宁浩', '144', '2019-10-16', '1', '6', '1', null);
INSERT INTO `film` VALUES ('6', '战狼', '吴京', '123', '2019-10-10', '39', '7', '1', null);
INSERT INTO `film` VALUES ('7', '我也不知道是啥', '我是谁', '343', '2019-09-30', '1', '8', '1', null);
INSERT INTO `film` VALUES ('8', '唐人街探案', '陈思诚', '0', '2019-10-23', '0', '9', '1', null);
INSERT INTO `film` VALUES ('9', 'fsdfsd', '陈凯歌', '0', '2019-10-23', '0', '11', '1', null);
INSERT INTO `film` VALUES ('10', '天下第一', '我是谁', '99', '2019-10-28', '99', '12', '1', null);
INSERT INTO `film` VALUES ('11', '唐人街探案2', '陈思诚', '99', '2019-10-23', '9', '2', '1', null);
INSERT INTO `film` VALUES ('12', '红海行动', '不知道', '121', '2019-10-23', '2', '10', '1', null);

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(6) DEFAULT NULL,
  `film_id` int(5) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('33', '12', '2', '2019-10-24 15:31:33');
INSERT INTO `history` VALUES ('34', '12', '2', '2019-10-24 15:51:36');
INSERT INTO `history` VALUES ('35', '12', '10', '2019-10-24 15:53:34');
INSERT INTO `history` VALUES ('36', '12', '9', '2019-10-24 15:57:39');
INSERT INTO `history` VALUES ('37', '12', '11', '2019-10-24 15:59:14');
INSERT INTO `history` VALUES ('38', '12', '1', '2019-10-24 15:59:32');
INSERT INTO `history` VALUES ('42', '1', '1', '2019-11-01 10:05:20');
INSERT INTO `history` VALUES ('43', '1', '1', '2019-11-01 10:05:48');
INSERT INTO `history` VALUES ('44', '1', '2', '2019-11-01 15:34:15');
INSERT INTO `history` VALUES ('45', '7', '4', '2019-11-04 10:00:17');
INSERT INTO `history` VALUES ('46', '7', '4', '2019-11-04 10:00:23');
INSERT INTO `history` VALUES ('47', '7', '2', '2019-11-04 10:01:02');
INSERT INTO `history` VALUES ('48', '7', '2', '2019-11-04 10:10:53');
INSERT INTO `history` VALUES ('49', '7', '4', '2019-11-04 10:14:36');
INSERT INTO `history` VALUES ('50', '7', '2', '2019-11-04 10:14:52');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `image_id` int(5) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) NOT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', 'http://localhost:8080/resources/111111.png');
INSERT INTO `image` VALUES ('9', 'http://localhost:8080/resources/3beda638cd3144a4a9e6724c230a1585_.jpg');
INSERT INTO `image` VALUES ('10', 'http://localhost:8080/resources/cf302e0fb6b246e0b599fd4594b4350f_.jpg');
INSERT INTO `image` VALUES ('11', 'http://localhost:8080/resources/575ee2fb79dd4a0190bbd3ec7db75c26_.jpg');
INSERT INTO `image` VALUES ('12', 'http://localhost:8080/resources/bd0de49cc1814cb4a3aeb254bd85b2e3_.jpg');
INSERT INTO `image` VALUES ('13', 'http://localhost:8080/resources/d7c2ef5c99d3408e8bdd46f904a1bb87_.jpg');
INSERT INTO `image` VALUES ('14', 'http://localhost:8080/resources/cb4224aa8533455e9ec19c71eda60331_.jpg');
INSERT INTO `image` VALUES ('15', 'http://localhost:8080/resources/29214674d622485b9cc03c3b4407ed7f_.jpg');
INSERT INTO `image` VALUES ('16', 'http://localhost:8080/resources/0f73ec601ad44862bccef0019288f4c9_.jpg');
INSERT INTO `image` VALUES ('17', 'http://localhost:8080/resources/14f1e8044f6f47929049737c276ca28e_.jpg');
INSERT INTO `image` VALUES ('18', 'http://localhost:8080/resources/b7b3f1817d34488ca3e22760f502ee24_.jpg');
INSERT INTO `image` VALUES ('19', 'http://localhost:8080/resources/7c674d7c2b26481db624e0734e45b1bd_.jpg');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `member_id` int(2) NOT NULL AUTO_INCREMENT,
  `grade` varchar(5) NOT NULL DEFAULT '0' COMMENT '会员等级',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '1级');
INSERT INTO `member` VALUES ('2', '2级');
INSERT INTO `member` VALUES ('3', '3级');
INSERT INTO `member` VALUES ('4', '4级');
INSERT INTO `member` VALUES ('5', '5级');
INSERT INTO `member` VALUES ('6', '6级');
INSERT INTO `member` VALUES ('7', '7级');
INSERT INTO `member` VALUES ('8', '8级');
INSERT INTO `member` VALUES ('9', '9级');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(6) DEFAULT NULL,
  `film_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  KEY `film_id` (`film_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '1', '1');
INSERT INTO `orderdetail` VALUES ('2', '1', '2');
INSERT INTO `orderdetail` VALUES ('3', '1', '3');
INSERT INTO `orderdetail` VALUES ('4', '6', '1');
INSERT INTO `orderdetail` VALUES ('5', '6', '5');
INSERT INTO `orderdetail` VALUES ('9', '1', '4');
INSERT INTO `orderdetail` VALUES ('48', '1', '6');
INSERT INTO `orderdetail` VALUES ('49', '7', '4');
INSERT INTO `orderdetail` VALUES ('50', '7', '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(2) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(7) NOT NULL COMMENT '1:普通  2：管理员   3：超管',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户');
INSERT INTO `role` VALUES ('2', '管理员');
INSERT INTO `role` VALUES ('3', '超级管理员');

-- ----------------------------
-- Table structure for save
-- ----------------------------
DROP TABLE IF EXISTS `save`;
CREATE TABLE `save` (
  `save_id` int(5) NOT NULL AUTO_INCREMENT,
  `save_url` varchar(50) NOT NULL,
  PRIMARY KEY (`save_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of save
-- ----------------------------

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` int(2) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(30) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '全部');
INSERT INTO `type` VALUES ('2', '恐怖片');
INSERT INTO `type` VALUES ('3', '惊悚片');
INSERT INTO `type` VALUES ('4', '纪录片');
INSERT INTO `type` VALUES ('5', '战争片');
INSERT INTO `type` VALUES ('6', '科幻片');
INSERT INTO `type` VALUES ('7', '剧情片');
INSERT INTO `type` VALUES ('8', '喜剧片');
INSERT INTO `type` VALUES ('9', '动画片');
INSERT INTO `type` VALUES ('10', '音乐剧');
INSERT INTO `type` VALUES ('11', '爱情片');
INSERT INTO `type` VALUES ('12', '悬疑剧');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(6) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `state` enum('1','0') DEFAULT '0' COMMENT '0:使用   1：停用',
  `member_id` int(2) DEFAULT '1',
  `role_id` int(2) DEFAULT '1',
  `integral` int(4) DEFAULT '0' COMMENT '账户积分',
  PRIMARY KEY (`user_id`),
  KEY `member_id` (`member_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1589619226', '2019-10-10 11:13:29', '0', '9', '3', '9999');
INSERT INTO `user` VALUES ('2', '张三', '123', '110', '2019-10-15 13:49:03', '0', '1', '1', '0');
INSERT INTO `user` VALUES ('3', '李四', '123', '12580', '2019-10-22 21:13:09', '0', '1', '1', '0');
INSERT INTO `user` VALUES ('4', '王五', '111111', '11111100', '2019-10-25 09:33:51', '1', '1', '1', '0');
INSERT INTO `user` VALUES ('5', '六六六', '22222222', '111122222', '2019-10-25 09:33:54', '1', '1', '1', '0');
INSERT INTO `user` VALUES ('6', '1111', '111', '17657865778', '2019-10-29 09:13:03', '0', '4', '1', '3899');
INSERT INTO `user` VALUES ('7', '123', '123', '15896192265', null, '0', '1', '1', '0');

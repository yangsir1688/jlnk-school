/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50618
Source Host           : localhost:3306
Source Database       : bookstore_teach

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2019-06-12 14:05:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `publish` varchar(100) NOT NULL,
  `price` float NOT NULL,
  `path` varchar(100) DEFAULT NULL,
  `photoName` varchar(100) DEFAULT NULL,
  `categoryId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('03176f09-45ad-46e2-95ef-fabfd7934fef', '笑傲江湖', '金庸', '沧海一声笑', '济南大学出版社', '78', '/13/0', 'a009768b-c697-4c71-9123-90948f8818a4.jpg', '1');
INSERT INTO `book` VALUES ('1001', '天龙八部', '金庸', '一代大侠为国为民', '工业出版社', '52', '/11/0', '8.jpg', '1');
INSERT INTO `book` VALUES ('7d8264ad-dcc8-4505-bfda-9beecf36c72f', '寻秦记', '黄易', '古仔真帅', '延边大学出版社', '32', '/12/0', '4d220f34-c04d-4bde-9d38-c3048d0dff5a.jpg', '1');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '武侠', '金庸巨作...');
INSERT INTO `category` VALUES ('8735aeea-938a-47c8-8aaa-59500af73a34', '计算机教程', 'IT开发图书真好 ');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `type` varchar(20) NOT NULL,
  `sex` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3ae1eff9-2d52-4bb5-ae2a-2c7610ee9dca', 'admins', '123', '普通用户', 'man');

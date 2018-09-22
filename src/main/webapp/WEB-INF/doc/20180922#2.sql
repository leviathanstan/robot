/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : robot

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-22 17:44:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `area`
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
`area_id`  int(11) NOT NULL AUTO_INCREMENT ,
`area_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`area_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `association_article`
-- ----------------------------
DROP TABLE IF EXISTS `association_article`;
CREATE TABLE `association_article` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`title`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`release_time`  datetime NOT NULL ,
`link`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`summary`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`content`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`source`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
`brand_id`  int(11) NOT NULL AUTO_INCREMENT ,
`brand_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`brand_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`logo`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`introduction`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `company_area`
-- ----------------------------
DROP TABLE IF EXISTS `company_area`;
CREATE TABLE `company_area` (
`company_id`  int(11) NOT NULL ,
`area_id`  int(11) NOT NULL ,
FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id` (`company_id`) USING BTREE ,
INDEX `area_id` (`area_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `company_industry`
-- ----------------------------
DROP TABLE IF EXISTS `company_industry`;
CREATE TABLE `company_industry` (
`company_id`  int(11) NOT NULL ,
`industry_id`  int(11) NOT NULL ,
FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`industry_id`) REFERENCES `industry` (`industry_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `company_id` (`company_id`) USING BTREE ,
INDEX `industry_id` (`industry_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `company_robot`
-- ----------------------------
DROP TABLE IF EXISTS `company_robot`;
CREATE TABLE `company_robot` (
`robot_id`  int(11) NOT NULL ,
`company_id`  int(11) NOT NULL ,
FOREIGN KEY (`robot_id`) REFERENCES `robot_category` (`robot_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `robot_id` (`robot_id`) USING BTREE ,
INDEX `company_id` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `conference`
-- ----------------------------
DROP TABLE IF EXISTS `conference`;
CREATE TABLE `conference` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`cover_img`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`title`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`hold_time`  datetime NOT NULL ,
`address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`host`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`introduction`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `expert`
-- ----------------------------
DROP TABLE IF EXISTS `expert`;
CREATE TABLE `expert` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`introduction`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`face_img`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `expert_article`
-- ----------------------------
DROP TABLE IF EXISTS `expert_article`;
CREATE TABLE `expert_article` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`title`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`release_time`  datetime NOT NULL ,
`link`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`summary`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`content`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`source`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `industry`
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry` (
`industry_id`  int(11) NOT NULL AUTO_INCREMENT ,
`industry_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`industry_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `information`
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`summary`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`content`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`title`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`release_time`  datetime NOT NULL ,
`source`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`link`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`category_id`  int(11) NOT NULL ,
`cover_img`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`category_id`) REFERENCES `information_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `information_ibfk_1` (`category_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `information_category`
-- ----------------------------
DROP TABLE IF EXISTS `information_category`;
CREATE TABLE `information_category` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `parts`
-- ----------------------------
DROP TABLE IF EXISTS `parts`;
CREATE TABLE `parts` (
`parts_id`  int(11) NOT NULL AUTO_INCREMENT ,
`parts_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`parts_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`price`  int(10) NOT NULL ,
`introduction`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`cover_img`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`company_id`  int(11) NOT NULL ,
`load`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负载' ,
`axis`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '轴' ,
`imgs`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`effect_time`  date NOT NULL ,
`last_update_time`  datetime NOT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `company_id` (`company_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `product_article`
-- ----------------------------
DROP TABLE IF EXISTS `product_article`;
CREATE TABLE `product_article` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`title`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`release_time`  datetime NOT NULL ,
`link`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`summary`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`content`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`source`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `product_category`
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
`product_id`  int(11) NOT NULL ,
`industry_id`  int(11) NULL DEFAULT NULL ,
`brand_id`  int(11) NULL DEFAULT NULL ,
`parts_id`  int(11) NULL DEFAULT NULL ,
FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`industry_id`) REFERENCES `industry` (`industry_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`parts_id`) REFERENCES `parts` (`parts_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `product_category_ibfk_1` (`product_id`) USING BTREE ,
INDEX `product_category_ibfk_3` (`industry_id`) USING BTREE ,
INDEX `product_category_ibfk_4` (`brand_id`) USING BTREE ,
INDEX `product_category_ibfk_5` (`parts_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `product_robot`
-- ----------------------------
DROP TABLE IF EXISTS `product_robot`;
CREATE TABLE `product_robot` (
`product_id`  int(11) NOT NULL ,
`robot_id`  int(11) NULL DEFAULT NULL ,
FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`robot_id`) REFERENCES `robot_category` (`robot_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `product_id` (`product_id`) USING BTREE ,
INDEX `robot_id` (`robot_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `registration_form`
-- ----------------------------
DROP TABLE IF EXISTS `registration_form`;
CREATE TABLE `registration_form` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`conference_id`  int(11) NOT NULL ,
`name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`gender`  char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`phone`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`wechat`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`email`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`company_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`position`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`company_address`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' ,
PRIMARY KEY (`id`),
FOREIGN KEY (`conference_id`) REFERENCES `conference` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `conference_id` (`conference_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `robot_category`
-- ----------------------------
DROP TABLE IF EXISTS `robot_category`;
CREATE TABLE `robot_category` (
`robot_id`  int(11) NOT NULL AUTO_INCREMENT ,
`robot_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`robot_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `technology_article`
-- ----------------------------
DROP TABLE IF EXISTS `technology_article`;
CREATE TABLE `technology_article` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`title`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`release_time`  datetime NOT NULL ,
`link`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`summary`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`content`  varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`source`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `university`
-- ----------------------------
DROP TABLE IF EXISTS `university`;
CREATE TABLE `university` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`introduction`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`name`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`email`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`phone`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`face_img`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Auto increment value for `area`
-- ----------------------------
ALTER TABLE `area` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `association_article`
-- ----------------------------
ALTER TABLE `association_article` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `brand`
-- ----------------------------
ALTER TABLE `brand` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `company`
-- ----------------------------
ALTER TABLE `company` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `conference`
-- ----------------------------
ALTER TABLE `conference` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `expert`
-- ----------------------------
ALTER TABLE `expert` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `expert_article`
-- ----------------------------
ALTER TABLE `expert_article` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `industry`
-- ----------------------------
ALTER TABLE `industry` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `information`
-- ----------------------------
ALTER TABLE `information` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `information_category`
-- ----------------------------
ALTER TABLE `information_category` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `parts`
-- ----------------------------
ALTER TABLE `parts` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `product`
-- ----------------------------
ALTER TABLE `product` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `product_article`
-- ----------------------------
ALTER TABLE `product_article` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `registration_form`
-- ----------------------------
ALTER TABLE `registration_form` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `robot_category`
-- ----------------------------
ALTER TABLE `robot_category` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `technology_article`
-- ----------------------------
ALTER TABLE `technology_article` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `university`
-- ----------------------------
ALTER TABLE `university` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `user`
-- ----------------------------
ALTER TABLE `user` AUTO_INCREMENT=1;

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : outpatient

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-12-22 17:01:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dempartment
-- ----------------------------
DROP TABLE IF EXISTS `dempartment`;
CREATE TABLE `dempartment` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `department_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `avaliable_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `doctor_sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `doctor_level` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `doctor_score` int(11) DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for errorlist
-- ----------------------------
DROP TABLE IF EXISTS `errorlist`;
CREATE TABLE `errorlist` (
  `error_id` int(11) NOT NULL,
  `error_info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `error_type` int(11) DEFAULT NULL,
  `user_action` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`error_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for hcard
-- ----------------------------
DROP TABLE IF EXISTS `hcard`;
CREATE TABLE `hcard` (
  `hcard_id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard_number` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `crash_card` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`hcard_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory` (
  `laboratory_id` int(11) NOT NULL AUTO_INCREMENT,
  `laboratory_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `report` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`laboratory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `medicine_id` int(11) NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `medicine_info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `med_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `patient_sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `patient_age` int(11) DEFAULT NULL,
  `idcard_number` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `hcard_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `prescription_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `medicine_list` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `evaluate_score` int(11) DEFAULT NULL,
  PRIMARY KEY (`prescription_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for registerrecord
-- ----------------------------
DROP TABLE IF EXISTS `registerrecord`;
CREATE TABLE `registerrecord` (
  `register_id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) NOT NULL,
  `patient_id` int(11) DEFAULT NULL,
  `register_time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `register_price` decimal(10,2) DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  `trade_id` int(11) NOT NULL,
  PRIMARY KEY (`register_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_power` int(11) DEFAULT NULL,
  `role_describe` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for traderecord
-- ----------------------------
DROP TABLE IF EXISTS `traderecord`;
CREATE TABLE `traderecord` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `pre_time` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `final_time` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `trade_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `isPrePay` char(1) COLLATE utf8_bin DEFAULT NULL,
  `isFinalPay` char(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `phone_number` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

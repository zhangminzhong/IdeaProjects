/*
Navicat MySQL Data Transfer

Source Server         : DB
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : studentmanage

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-04-20 18:40:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classID` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(12) NOT NULL,
  `specialityID` int(11) NOT NULL,
  `entryDate` date DEFAULT NULL,
  `studentNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`classID`),
  KEY `FK_Reference_3` (`specialityID`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`specialityID`) REFERENCES `specialty` (`specialityID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '计算机1101班', '1', '2016-04-07', '35');
INSERT INTO `class` VALUES ('2', '计算机1102班', '1', '2016-04-07', '35');
INSERT INTO `class` VALUES ('3', '计算机1103班', '1', '2016-04-07', '35');
INSERT INTO `class` VALUES ('4', '计算机1104班', '1', '2016-04-07', '35');
INSERT INTO `class` VALUES ('5', '计算机1105班', '1', '2016-04-07', '35');
INSERT INTO `class` VALUES ('6', '计算机1106班', '1', '2016-04-07', '35');
INSERT INTO `class` VALUES ('7', '计算机1107班', '1', '2016-04-07', '35');
INSERT INTO `class` VALUES ('8', '计算机1108班', '1', '2016-04-07', '35');
INSERT INTO `class` VALUES ('9', '计算机1109班', '1', '2016-04-07', '35');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseID` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(20) NOT NULL,
  `coursetypeID` int(11) DEFAULT NULL,
  `totalPeriod` int(11) DEFAULT NULL,
  `weekPeriod` int(11) DEFAULT NULL,
  `creditHour` float DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`courseID`),
  KEY `FK_Reference_5` (`coursetypeID`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`coursetypeID`) REFERENCES `coursetype` (`coursetypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for coursetype
-- ----------------------------
DROP TABLE IF EXISTS `coursetype`;
CREATE TABLE `coursetype` (
  `coursetypeID` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(20) NOT NULL,
  PRIMARY KEY (`coursetypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursetype
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentID` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(30) NOT NULL,
  `departmentHead` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`departmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '计算机科学与技术学院', '张民忠');

-- ----------------------------
-- Table structure for specialty
-- ----------------------------
DROP TABLE IF EXISTS `specialty`;
CREATE TABLE `specialty` (
  `specialityID` int(11) NOT NULL AUTO_INCREMENT,
  `specialityName` varchar(30) NOT NULL,
  `departmentID` int(11) NOT NULL,
  PRIMARY KEY (`specialityID`),
  KEY `FK_Reference_4` (`departmentID`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`departmentID`) REFERENCES `department` (`departmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specialty
-- ----------------------------
INSERT INTO `specialty` VALUES ('1', '计算机科学与技术', '1');
INSERT INTO `specialty` VALUES ('2', '物联网', '1');
INSERT INTO `specialty` VALUES ('3', '软件工程', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentID` varchar(20) NOT NULL,
  `studentName` varchar(20) NOT NULL,
  `nation` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `classID` int(11) NOT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `creditHour` float NOT NULL,
  `entryDate` date DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`studentID`),
  KEY `FK_Reference_1` (`classID`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`classID`) REFERENCES `class` (`classID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1234567891001', '刘一一', '汉族', '女', '1992-01-01', '1', '13311111111', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891002', '陈二', '汉族', '女', '1992-01-01', '1', '13322222222', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891003', '张三', '汉族', '男', '1992-01-01', '2', '13333333333', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891004', '李四', '汉族', '男', '1992-01-01', '1', '13344444444', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891005', '王五', '汉族', '男', '1992-01-01', '1', '13355555555', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891006', '赵六', '汉族', '男', '1992-01-01', '5', '13366666666', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891007', '孙七', '汉族', '男', '1992-01-01', '1', '13377777777', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891008', '周八', '汉族', '男', '1992-01-01', '1', '13388888888', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891009', '吴九', '汉族', '女', '1992-01-01', '8', '13399999999', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891010', '郑十', '汉族', '女', '1992-01-01', '1', '13300000000', '1.5', '2016-04-07', '湖北省武汉市武昌区和平大道1178号', '新生');
INSERT INTO `student` VALUES ('1234567891012', '张民忠', '汉族', '男', '1992-10-01', '1', '13999999999', '0', '2016-04-13', '湖北省武汉市', '新生');

-- ----------------------------
-- Table structure for studentcourse
-- ----------------------------
DROP TABLE IF EXISTS `studentcourse`;
CREATE TABLE `studentcourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentID` varchar(20) NOT NULL,
  `courseID` int(11) NOT NULL,
  `grade` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_6` (`studentID`),
  KEY `FK_Reference_7` (`courseID`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentcourse
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherID` varchar(20) NOT NULL,
  `teacherName` varchar(20) NOT NULL,
  `departmentID` int(11) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `technicalPost` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`teacherID`),
  KEY `FK_Reference_2` (`departmentID`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`departmentID`) REFERENCES `department` (`departmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin');
INSERT INTO `user` VALUES ('2', 'admin1', 'admin1');

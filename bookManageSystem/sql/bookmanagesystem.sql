/*
Navicat MySQL Data Transfer

Source Server         : rct
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : bookmanagesystem

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2015-01-04 13:08:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app`
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app
-- ----------------------------
INSERT INTO `app` VALUES ('1', '企业1', '1', '启用', '2014-05-28');

-- ----------------------------
-- Table structure for `authority`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', 'ROLE_USER', '用户', '1');
INSERT INTO `authority` VALUES ('2', 'ROLE_ADMIN', '管理员', '1');
INSERT INTO `authority` VALUES ('3', 'ROLE_ANONYMOUS', '游客', '1');

-- ----------------------------
-- Table structure for `authority_power`
-- ----------------------------
DROP TABLE IF EXISTS `authority_power`;
CREATE TABLE `authority_power` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authorityId` bigint(20) DEFAULT NULL,
  `powerId` bigint(20) DEFAULT NULL,
  `powerResource` varchar(255) DEFAULT NULL,
  `authorityName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority_power
-- ----------------------------
INSERT INTO `authority_power` VALUES ('1', '1', '1', '/rs/**', 'ROLE_USER');
INSERT INTO `authority_power` VALUES ('2', '1', '4', '/index.jsp', 'ROLE_USER');
INSERT INTO `authority_power` VALUES ('4', '2', '1', '/rs/**', 'ROLE_ADMIN');
INSERT INTO `authority_power` VALUES ('5', '2', '2', '/user.html', 'ROLE_ADMIN');
INSERT INTO `authority_power` VALUES ('6', '2', '3', '/admin.html', 'ROLE_ADMIN');
INSERT INTO `authority_power` VALUES ('7', '2', '4', '/index.jsp', 'ROLE_ADMIN');
INSERT INTO `authority_power` VALUES ('8', '2', '15', 'cas/**', 'ROLE_ADMIN');
INSERT INTO `authority_power` VALUES ('9', '3', '5', '/rs/anonymous/**', 'ROLE_ANONYMOUS');
INSERT INTO `authority_power` VALUES ('10', '3', '6', '/rs/anonymousUser/**', 'ROLE_ANONYMOUS');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prefixId` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `rentStatus` varchar(20) DEFAULT NULL,
  `bookTypeId` bigint(20) DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  `count` bigint(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `rentNumber` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '1', '社会科学概览', '0001', '自然辩证法是马克思主义的自然观和自然科学观的反映。体现马克思主义哲学的世界观、认识论、方法论的统一，是马克思主义哲学的一个组成部分。F.恩格斯的《自然辩证法》（Dialectics of Nature）所开创的研究领域。自然界本身的辩证法是通过自然科学和技术的发展日益被揭示出来的，两个方面的研究密切相联，不可分割。', null, '7', '1', '11', 'bookImage/sociality.jpg', '2');
INSERT INTO `book` VALUES ('2', '2', '计算机网络', '0002', null, null, '2', '1', '36', null, '10');
INSERT INTO `book` VALUES ('3', '3', '软件工程', '0003', null, null, '2', '1', '48', null, '1');
INSERT INTO `book` VALUES ('4', '4', '历史', '0004', null, null, '6', '1', '14', null, '0');
INSERT INTO `book` VALUES ('5', '5', '水文学', '0005', '研究地球大气层、地表及地壳内水的分布、运动和变化规律，以及水与环境相互作用的学科，属于地球物理科学范畴。通过测验、分析计算和模拟，预报自然界中水量和水质的变化和发展，为开发利用水资源、控制洪水和保护水环境等方面提供科学依据。属于地球物理学和自然地理学的分支学科。', null, '7', '1', '23', 'bookImage/s5910099.jpg', '3');
INSERT INTO `book` VALUES ('6', '6', '巴黎圣母院', '0006', null, null, '4', '1', '78', null, '6');
INSERT INTO `book` VALUES ('7', '7', '生活宝典', '0007', null, null, '5', '1', '43', null, '7');
INSERT INTO `book` VALUES ('8', '8', '心理学', '0008', null, null, '8', '1', '14', null, '2');
INSERT INTO `book` VALUES ('9', '9', '刑法', '0009', null, null, '1', '1', '25', null, '4');
INSERT INTO `book` VALUES ('10', '10', 'IT生活', '0010', null, null, '5', '1', '23', null, '5');
INSERT INTO `book` VALUES ('11', '11', '法律行为', '0011', null, '', '1', '1', '23', '', '2');
INSERT INTO `book` VALUES ('12', '12', '法律的基础', '0012', null, null, '1', '1', '23', 'bookImage/law.jpg', '3');
INSERT INTO `book` VALUES ('13', '13', '法律的生长', '0013', null, null, '1', '1', '55', null, '12');
INSERT INTO `book` VALUES ('14', '14', '法律与社会', '0014', '《法律与社会(第9版)》围绕着法律与社会这一逻辑线索系统，全面地阐释了法律社会学的基本理论知识。对法律与社会之间的关系做了丰富的。均衡的，综合的分析。《法律与社会第9版》梳理了最前沿的跨学科研究、最新的理论进展以及正在持续的论争。它描述了法律竞技场中的主要参与者以及他们对社会和我们的日常生活的影响，有助于我们对法律以及法律系统的结构和功能有新的理解。', null, '1', '1', '25', 'bookImage/s6507709.jpg', '4');
INSERT INTO `book` VALUES ('15', '15', '美国法律史', '0015', null, null, '1', '1', '58', null, '7');
INSERT INTO `book` VALUES ('16', '16', '法律与文学', '0016', null, null, '1', '1', '65', null, '3');
INSERT INTO `book` VALUES ('17', '17', '论法律', '0017', null, null, '1', '1', '96', null, '2');
INSERT INTO `book` VALUES ('18', '18', '法律篇', '0018', null, null, '1', '1', '54', null, '3');
INSERT INTO `book` VALUES ('19', '19', '法律的界限', '0019', null, null, '1', '1', '85', null, '2');
INSERT INTO `book` VALUES ('20', '20', '法律方法', '0020', null, null, '1', '1', '55', null, '1');
INSERT INTO `book` VALUES ('21', '21', '社会的法律', '0021', null, null, '1', '1', '88', null, '2');
INSERT INTO `book` VALUES ('22', '22', '法律与分歧', '0022', null, null, '1', '1', '55', null, '2');
INSERT INTO `book` VALUES ('23', '23', '法律的异邦', '0023', null, null, '1', '1', '88', null, '6');
INSERT INTO `book` VALUES ('24', '24', '法律基础', '0024', null, null, '1', '1', '65', null, '45');
INSERT INTO `book` VALUES ('25', '25', '走过法律', '0025', null, null, '1', '1', '75', null, '65');
INSERT INTO `book` VALUES ('26', '26', '中国法律', '0026', null, null, '1', '1', '65', null, '22');
INSERT INTO `book` VALUES ('27', '27', '法律与社会', '0027', null, null, '1', '1', '99', null, '45');
INSERT INTO `book` VALUES ('28', '28', '法律事务', '0028', null, null, '1', '1', '54', null, '22');
INSERT INTO `book` VALUES ('29', '29', '法律史解释', '0029', null, null, '1', '1', '66', null, '25');
INSERT INTO `book` VALUES ('30', '30', '法律导引', '0030', null, null, '1', '1', '99', null, '22');
INSERT INTO `book` VALUES ('31', '31', '法律小词典', '0031', null, null, '1', '1', '666', null, '225');
INSERT INTO `book` VALUES ('32', '32', '计算机导论', '0032', '本书是根据教育部高等学校计算机科学与技术教学指导委员会颁布的《高等学校计算机科学与技术专业发展战略研究报告暨专业规范（试行）》及《关于进一步加强高等学校计算机基础教学的意见暨计算机基础课程教学基本要求（试行）》中有关计算机导论和大学计算机基础课程教学基本要求编写的。', null, '2', '1', '55', 'bookImage/s5804126.jpg', '2');
INSERT INTO `book` VALUES ('33', '33', '计算机网络', '0033', null, null, '2', '1', '888', null, '22');
INSERT INTO `book` VALUES ('34', '34', '计算机网络', '0034', null, null, '2', '1', '654', null, '222');
INSERT INTO `book` VALUES ('35', '35', '计算机网络', '0035', null, null, '2', '1', '665', null, '22');
INSERT INTO `book` VALUES ('36', '36', '计算机绘图', '0036', null, null, '2', '1', '848', null, '221');
INSERT INTO `book` VALUES ('37', '37', '计算机导论', '0037', null, null, '2', '1', '884', null, '225');
INSERT INTO `book` VALUES ('38', '38', '计算机网络', '0038', null, null, '2', '1', '541', null, '232');
INSERT INTO `book` VALUES ('39', '39', '计算机导论', '0039', null, null, '2', '1', '999', null, '445');
INSERT INTO `book` VALUES ('40', '40', '计算机英语', '0040', null, null, '2', '1', '546', null, '222');
INSERT INTO `book` VALUES ('41', '41', '计算机网络', '0041', null, null, '2', '1', '884', null, '225');
INSERT INTO `book` VALUES ('42', '42', '计算机仿真', '0042', null, null, '2', '1', '545', null, '222');
INSERT INTO `book` VALUES ('43', '43', '计算机联锁', '0043', '计算机网络由一组结点和链络组成。网络中的结点有两类：转接结点和访问结点。通信处理机、集中器和终端控制器等属于转接结点，它们在网络中转接和交换传送信息。主计算机和终端等是访问结点，它们是信息传送的源结点和目标结点。', null, '2', '1', '464', 'bookImage/s6179109.jpg', '222');
INSERT INTO `book` VALUES ('44', '44', '计算机绘图', '0044', null, null, '2', '1', '886', null, '222');
INSERT INTO `book` VALUES ('45', '45', '计算机数学', '0045', null, null, '2', '1', '99', null, '52');
INSERT INTO `book` VALUES ('46', '46', '计算机导论', '0046', null, null, '2', '1', '665', null, '232');
INSERT INTO `book` VALUES ('47', '47', '计算机文化', '0047', null, null, '2', '1', '656', null, '222');
INSERT INTO `book` VALUES ('48', '48', '计算机仿真', '0048', null, null, '2', '1', '666', null, '555');
INSERT INTO `book` VALUES ('49', '49', '计算机网络', '0049', null, null, '2', '1', '999', null, '141');
INSERT INTO `book` VALUES ('50', '50', '计算机原理', '0050', null, null, '2', '1', '656', null, '222');
INSERT INTO `book` VALUES ('51', '51', '计算机工程', '0051', null, null, '2', '1', '999', null, '546');
INSERT INTO `book` VALUES ('52', '52', '计算机网络', '0052', null, null, '2', '1', '686', null, '454');
INSERT INTO `book` VALUES ('53', '53', '医学史', '0053', null, null, '3', '1', '565', 'bookImage/medical.jpg', '222');
INSERT INTO `book` VALUES ('54', '54', '医学遗传学', '0054', null, null, '3', '1', '646', null, '555');
INSERT INTO `book` VALUES ('55', '55', '医学营养学', '0055', null, null, '3', '1', '888', null, '555');
INSERT INTO `book` VALUES ('56', '56', '医学史', '0056', null, null, '3', '1', '656', null, '55');
INSERT INTO `book` VALUES ('57', '57', '中医学', '0057', null, null, '3', '1', '555', null, '325');
INSERT INTO `book` VALUES ('58', '58', '医学伦理学', '0058', null, null, '3', '1', '656', null, '22');
INSERT INTO `book` VALUES ('59', '59', '医学法学', '0059', null, null, '3', '1', '666', null, '22');
INSERT INTO `book` VALUES ('60', '60', '医学伦理学', '0060', null, null, '3', '1', '646', null, '232');
INSERT INTO `book` VALUES ('61', '61', '康复医学', '0061', null, null, '3', '1', '361', null, '22');
INSERT INTO `book` VALUES ('62', '62', '中医学', '0062', null, null, '3', '1', '656', null, '22');
INSERT INTO `book` VALUES ('63', '63', '医学哲学杂谈', '0063', null, null, '3', '1', '656', null, '555');
INSERT INTO `book` VALUES ('64', '64', '医学伦理学', '0064', null, null, '3', '1', '666', null, '22');
INSERT INTO `book` VALUES ('65', '65', '法医学', '0065', null, null, '3', '1', '636', null, '22');
INSERT INTO `book` VALUES ('66', '66', '预防医学', '0066', null, null, '3', '1', '333', null, '22');
INSERT INTO `book` VALUES ('67', '67', '医学生理学', '0067', null, null, '3', '1', '66', null, '22');
INSERT INTO `book` VALUES ('68', '68', '医学生理学', '0068', null, null, '3', '1', '65', null, '2');
INSERT INTO `book` VALUES ('69', '69', '西医学概论', '0069', null, null, '3', '1', '6', null, '1');
INSERT INTO `book` VALUES ('70', '70', '纳米医学', '0070', null, null, '3', '1', '36', null, '2');
INSERT INTO `book` VALUES ('71', '71', '核医学', '0071', null, null, '3', '1', '23', null, '2');
INSERT INTO `book` VALUES ('72', '72', '医学伦理学', '0072', null, null, '3', '1', '23', null, '2');
INSERT INTO `book` VALUES ('73', '73', '法医学', '0073', null, null, '3', '1', '23', null, '2');
INSERT INTO `book` VALUES ('74', '74', '文学', '0074', null, null, '4', '1', '22', 'bookImage/literature.jpg', '2');
INSERT INTO `book` VALUES ('75', '75', '文学', '0075', null, null, '4', '1', '32', null, '2');
INSERT INTO `book` VALUES ('76', '76', '谈文学', '0076', null, null, '4', '1', '655', null, '22');
INSERT INTO `book` VALUES ('77', '77', '文学家', '0077', null, null, '4', '1', '33', null, '22');
INSERT INTO `book` VALUES ('78', '78', '希腊文学罗马文学', '0078', null, null, '4', '1', '35', null, '2');
INSERT INTO `book` VALUES ('79', '79', '中国文学通论', '0079', null, null, '4', '1', '55', null, '2');
INSERT INTO `book` VALUES ('80', '80', '中国新文学大系', '0080', null, null, '4', '1', '54', null, '2');
INSERT INTO `book` VALUES ('81', '81', '两汉文献与两汉文学', '0081', null, null, '4', '1', '55', null, '1');
INSERT INTO `book` VALUES ('82', '82', '谈文学', '0082', null, null, '4', '1', '54', null, '36');
INSERT INTO `book` VALUES ('83', '83', '种源文学', '0083', null, null, '4', '1', '232', null, '3');
INSERT INTO `book` VALUES ('84', '84', '水文学', '0084', null, null, '4', '1', '22', null, '3');
INSERT INTO `book` VALUES ('85', '85', '水文学', '0085', null, null, '4', '1', '1', null, '0');
INSERT INTO `book` VALUES ('86', '86', '水文学', '0086', null, null, '4', '1', '56', null, '2');
INSERT INTO `book` VALUES ('87', '87', '文学：批判与审美', '0087', null, null, '4', '1', '22', null, '3');
INSERT INTO `book` VALUES ('88', '88', '法国文学理论与实践', '0088', null, null, '4', '1', '23', null, '2');
INSERT INTO `book` VALUES ('89', '89', '中国古代文学作品选', '0089', null, null, '4', '1', '22', null, '1');
INSERT INTO `book` VALUES ('90', '90', '水文学', '0090', null, null, '4', '1', '65', null, '0');
INSERT INTO `book` VALUES ('91', '91', '文学史与文学史学', '0091', null, null, '4', '1', '65', null, '2');
INSERT INTO `book` VALUES ('92', '92', '文学', '0092', null, null, '4', '1', '65', null, '2');
INSERT INTO `book` VALUES ('93', '93', '水文学', '0093', null, null, '4', '1', '3', null, '1');
INSERT INTO `book` VALUES ('94', '94', '文学', '0094', null, null, '4', '1', '2', null, '1');
INSERT INTO `book` VALUES ('95', '95', '简单生活', '0095', null, null, '5', '1', '555', 'bookImage/life.jpg', '63');
INSERT INTO `book` VALUES ('96', '96', 'IT生活', '0096', null, null, '5', '1', '656', null, '22');
INSERT INTO `book` VALUES ('97', '97', '都市生活', '0097', null, null, '5', '1', '54', null, '2');
INSERT INTO `book` VALUES ('98', '98', '生活原型录', '0098', null, null, '5', '1', '652', null, '23');
INSERT INTO `book` VALUES ('99', '99', '生活的意义', '0099', null, null, '5', '1', '656', null, '22');
INSERT INTO `book` VALUES ('100', '100', '乐生活', '0100', null, null, '5', '1', '221', null, '21');
INSERT INTO `book` VALUES ('101', '101', '心理与生活', '101', null, null, '5', '1', '323', null, '152');
INSERT INTO `book` VALUES ('102', '102', '论可能生活', '0102', null, null, '5', '1', '220', null, '32');
INSERT INTO `book` VALUES ('103', '103', '科学与生活', '0103', null, null, '5', '1', '322', null, '21');
INSERT INTO `book` VALUES ('104', '104', '低碳生活', '0104', null, null, '5', '1', '320', null, '21');
INSERT INTO `book` VALUES ('105', '105', '慢生活', '0105', null, null, '5', '1', '31', null, '16');
INSERT INTO `book` VALUES ('106', '106', '简生活', '0106', null, null, '5', '1', '325', null, '22');
INSERT INTO `book` VALUES ('107', '107', '心生活', '0107', null, null, '5', '1', '213', null, '62');
INSERT INTO `book` VALUES ('108', '108', '俭生活', '0108', null, null, '5', '1', '321', null, '55');
INSERT INTO `book` VALUES ('109', '109', '悦读生活', '0109', null, null, '5', '1', '221', null, '5');
INSERT INTO `book` VALUES ('110', '110', '道德与生活', '0110', null, null, '5', '1', '225', null, '22');
INSERT INTO `book` VALUES ('111', '111', '化学与生活', '0111', null, null, '5', '1', '212', null, '44');
INSERT INTO `book` VALUES ('112', '112', '古罗马生活', '0112', null, null, '5', '1', '221', null, '22');
INSERT INTO `book` VALUES ('113', '113', '伪生活', '0113', null, null, '5', '1', '211', null, '55');
INSERT INTO `book` VALUES ('114', '114', '慢生活', '0114', null, null, '5', '1', '345', null, '21');
INSERT INTO `book` VALUES ('115', '115', '生活哲学', '0115', null, null, '5', '1', '122', null, '11');
INSERT INTO `book` VALUES ('116', '116', '历史', '0116', null, null, '6', '1', '211', 'bookImage/history.jpg', '22');
INSERT INTO `book` VALUES ('117', '117', '管理的历史', '0117', null, null, '6', '1', '55', null, '6');
INSERT INTO `book` VALUES ('118', '118', '武器的历史', '0118', null, null, '6', '1', '315', null, '11');
INSERT INTO `book` VALUES ('119', '119', '论历史', '0119', null, null, '6', '1', '541', null, '121');
INSERT INTO `book` VALUES ('120', '120', '中国大历史', '0120', null, null, '6', '1', '225', null, '11');
INSERT INTO `book` VALUES ('121', '121', '艺术的历史', '0121', null, null, '6', '1', '225', null, '22');
INSERT INTO `book` VALUES ('122', '122', '历史是什么', '0122', null, null, '6', '1', '11', null, '1');
INSERT INTO `book` VALUES ('123', '123', '论历史', '0123', null, null, '6', '1', '112', null, '22');
INSERT INTO `book` VALUES ('124', '124', '阅读的历史', '0124', null, null, '6', '1', '223', null, '22');
INSERT INTO `book` VALUES ('125', '125', '历史江湖', '0125', null, null, '6', '1', '11', null, '2');
INSERT INTO `book` VALUES ('126', '126', '被忽略的历史', '0126', null, null, '6', '1', '22', null, '3');
INSERT INTO `book` VALUES ('127', '127', '赌博的历史', '0127', null, null, '6', '1', '222', null, '21');
INSERT INTO `book` VALUES ('128', '128', '历史变迁与历史学', '0128', null, null, '6', '1', '235', null, '24');
INSERT INTO `book` VALUES ('129', '129', '建筑的历史', '0129', null, null, '6', '1', '22', null, '2');
INSERT INTO `book` VALUES ('130', '130', '让历史还原历史', '0130', null, null, '6', '1', '54', null, '2');
INSERT INTO `book` VALUES ('131', '131', '国学的历史', '0131', null, null, '6', '1', '22', null, '3');
INSERT INTO `book` VALUES ('132', '132', '没的历史', '0132', null, null, '6', '1', '322', null, '2');
INSERT INTO `book` VALUES ('133', '133', '爱情的历史', '0133', null, null, '6', '1', '54', null, '2');
INSERT INTO `book` VALUES ('134', '134', '历史悬案', '0134', null, null, '6', '1', '31', null, '3');
INSERT INTO `book` VALUES ('135', '135', '历史语言学', '0135', null, null, '6', '1', '22', null, '1');
INSERT INTO `book` VALUES ('136', '136', '20世纪中国学术大典：历史学', '0136', null, null, '6', '1', '22', null, '3');
INSERT INTO `book` VALUES ('137', '137', '社会科学方法', '0137', null, null, '7', '1', '55', null, '1');
INSERT INTO `book` VALUES ('138', '138', '社会科学哲学', '0138', null, null, '7', '1', '225', null, '22');
INSERT INTO `book` VALUES ('139', '139', '社会科学研究方法', '0139', null, null, '7', '1', '552', null, '22');
INSERT INTO `book` VALUES ('140', '140', '社会科学哲学', '0140', null, null, '7', '1', '320', null, '23');
INSERT INTO `book` VALUES ('141', '141', '社会科学', '0141', null, null, '7', '1', '225', null, '1');
INSERT INTO `book` VALUES ('142', '142', '社会科学中的数学', '0142', null, null, '7', '1', '22', null, '5');
INSERT INTO `book` VALUES ('143', '143', '人文社会科学基础', '0143', null, null, '7', '1', '22', null, '5');
INSERT INTO `book` VALUES ('144', '144', '人文社会科学哲学', '0144', null, null, '7', '1', '55', null, '1');
INSERT INTO `book` VALUES ('145', '145', '社会科学研究方法', '0145', null, null, '7', '1', '521', null, '2');
INSERT INTO `book` VALUES ('146', '146', '社会科学概览', '0146', null, null, '7', '1', '44', null, '1');
INSERT INTO `book` VALUES ('147', '147', '行政法与社会科学', '0147', null, null, '7', '1', '45', null, '5');
INSERT INTO `book` VALUES ('148', '148', '社会科学统计方法', '0148', null, null, '7', '1', '255', null, '2');
INSERT INTO `book` VALUES ('149', '149', '社会科学方法论', '0149', null, null, '7', '1', '225', null, '5');
INSERT INTO `book` VALUES ('150', '150', '社会科学方法论', '0150', null, null, '7', '1', '552', null, '2');
INSERT INTO `book` VALUES ('151', '151', '社会科学方法论', '0151', null, null, '7', '1', '551', null, '55');
INSERT INTO `book` VALUES ('152', '152', '社会科学文献检索', '0152', null, null, '7', '1', '552', null, '2');
INSERT INTO `book` VALUES ('153', '153', '社会科学导论', '0153', null, null, '7', '1', '565', null, '2');
INSERT INTO `book` VALUES ('154', '154', '世界社会科学报告2010', '0154', null, null, '7', '1', '551', null, '2');
INSERT INTO `book` VALUES ('155', '155', '社会科学方法论', '0155', null, null, '7', '1', '55', null, '2');
INSERT INTO `book` VALUES ('156', '156', '上海社会科学院图书馆馆藏精粹', '0156', null, null, '7', '1', '55', null, '2');
INSERT INTO `book` VALUES ('157', '157', '社会科学概览', '0157', null, null, '7', '1', '55', 'bookImage/sociality.jpg', '1');

-- ----------------------------
-- Table structure for `bookcluster`
-- ----------------------------
DROP TABLE IF EXISTS `bookcluster`;
CREATE TABLE `bookcluster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clusterName` varchar(255) DEFAULT NULL,
  `bookNumbers` varchar(255) DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookcluster
-- ----------------------------
INSERT INTO `bookcluster` VALUES ('132', '聚类0', '0001;0069;', '1');
INSERT INTO `bookcluster` VALUES ('133', '聚类1', '0002;0070;0075;0077;0078;0105;0134;', '1');
INSERT INTO `bookcluster` VALUES ('134', '聚类2', '0003;0146;', '1');
INSERT INTO `bookcluster` VALUES ('135', '聚类3', '0004;0122;0125;', '1');
INSERT INTO `bookcluster` VALUES ('136', '聚类4', '0084;0087;0126;0131;0136;', '1');
INSERT INTO `bookcluster` VALUES ('137', '聚类5', '0017;0019;0021;0023;0030;0115;0123;', '1');
INSERT INTO `bookcluster` VALUES ('138', '聚类6', '0007;0147;', '1');
INSERT INTO `bookcluster` VALUES ('139', '聚类7', '0008;', '1');
INSERT INTO `bookcluster` VALUES ('140', '聚类8', '0009;0014;', '1');
INSERT INTO `bookcluster` VALUES ('141', '聚类9', '0010;0142;0143;', '1');
INSERT INTO `bookcluster` VALUES ('142', '聚类10', '0011;0071;0072;0073;0074;0088;0089;0129;0135;', '1');
INSERT INTO `bookcluster` VALUES ('143', '聚类11', '0005;0012;', '1');
INSERT INTO `bookcluster` VALUES ('144', '聚类12', '0025;0027;0045;', '1');
INSERT INTO `bookcluster` VALUES ('145', '聚类13', '0085;0093;0094;', '1');
INSERT INTO `bookcluster` VALUES ('146', '聚类14', '0024;0026;0028;0029;0067;0082;', '1');
INSERT INTO `bookcluster` VALUES ('147', '聚类15', '0006;0016;0068;0090;0091;0092;', '1');
INSERT INTO `bookcluster` VALUES ('148', '聚类16', '0031;0033;0034;0035;0036;0037;0038;0039;0040;0041;0042;0043;0044;0046;0047;0048;0049;0050;0051;0052;0053;0054;0055;0056;0057;0058;0059;0060;0062;0063;0064;0065;0076;0095;0096;0098;0099;0119;0139;0145;0150;0151;0152;0153;0154;', '1');
INSERT INTO `bookcluster` VALUES ('149', '聚类17', '0013;0015;0117;', '1');
INSERT INTO `bookcluster` VALUES ('150', '聚类18', '0061;0066;0083;0100;101;0102;0103;0104;0106;0107;0108;0109;0110;0111;0112;0113;0114;0116;0118;0120;0121;0124;0127;0128;0132;0138;0140;0141;0148;0149;', '1');
INSERT INTO `bookcluster` VALUES ('151', '聚类19', '0018;0020;0022;0032;0079;0080;0081;0086;0097;0130;0133;0137;0144;0155;0156;0157;', '1');

-- ----------------------------
-- Table structure for `bookrecord`
-- ----------------------------
DROP TABLE IF EXISTS `bookrecord`;
CREATE TABLE `bookrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `prefixId` bigint(20) DEFAULT NULL,
  `bookId` bigint(20) DEFAULT NULL,
  `bookNumber` varchar(255) DEFAULT NULL,
  `optionTypeId` bigint(20) DEFAULT NULL,
  `recordTime` date DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookrecord
-- ----------------------------
INSERT INTO `bookrecord` VALUES ('1', '1', '1', '1', '0001', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('2', '1', '5', '5', '0005', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('3', '1', '14', '14', '0014', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('4', '1', '32', '32', '0032', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('5', '2', '8', '8', '0008', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('6', '2', '45', '45', '0045', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('7', '3', '54', '54', '0054', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('8', '2', '67', '67', '0067', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('9', '1', '43', '43', '0043', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('10', '2', '67', '67', '0067', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('11', '3', '130', '130', '0130', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('12', '3', '5', '5', '0005', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('13', '2', '121', '121', '0121', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('14', '3', '146', '146', '0146', '1', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('15', '1', '1', '1', '0001', '2', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('16', '1', '5', '5', '0005', '2', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('17', '2', '8', '8', '0008', '2', '2015-01-02', '1');
INSERT INTO `bookrecord` VALUES ('18', '3', '32', '32', '0032', '1', '2015-01-02', '1');

-- ----------------------------
-- Table structure for `booktype`
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('1', '法律', '法律', '1');
INSERT INTO `booktype` VALUES ('2', '计算机', '计算机', '1');
INSERT INTO `booktype` VALUES ('3', '医学', '医学', '1');
INSERT INTO `booktype` VALUES ('4', '文学', '文学', '1');
INSERT INTO `booktype` VALUES ('5', '生活', '生活', '1');
INSERT INTO `booktype` VALUES ('6', '历史', '历史', '1');
INSERT INTO `booktype` VALUES ('7', '社科', '社科', '1');
INSERT INTO `booktype` VALUES ('8', '心理', '心理', '1');

-- ----------------------------
-- Table structure for `optiontype`
-- ----------------------------
DROP TABLE IF EXISTS `optiontype`;
CREATE TABLE `optiontype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of optiontype
-- ----------------------------
INSERT INTO `optiontype` VALUES ('1', '借书', '该操作名称，性质不可更改，由数据库维护人员添加', '1');
INSERT INTO `optiontype` VALUES ('2', '还书', '该操作名称，性质不可更改，由数据库维护人员添加', '1');

-- ----------------------------
-- Table structure for `power`
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `resource` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES ('1', '/rs/**', 'resource', '所有rest服务');
INSERT INTO `power` VALUES ('2', '/user.html', 'url', null);
INSERT INTO `power` VALUES ('3', '/admin.html', 'url', null);
INSERT INTO `power` VALUES ('4', '/index.jsp', 'url', null);
INSERT INTO `power` VALUES ('5', '/rs/anonymous/**', 'resource', '匿名rest服务');
INSERT INTO `power` VALUES ('6', '/rs/anonymousUser/**', 'resource', '匿名rest服务');
INSERT INTO `power` VALUES ('15', 'cas/**', 'service', 'cas client test from android');

-- ----------------------------
-- Table structure for `prefix`
-- ----------------------------
DROP TABLE IF EXISTS `prefix`;
CREATE TABLE `prefix` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cip` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `pressName` varchar(255) DEFAULT NULL,
  `pressLocation` varchar(255) DEFAULT NULL,
  `pressTime` date DEFAULT NULL,
  `appId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prefix
-- ----------------------------
INSERT INTO `prefix` VALUES ('1', '13', '223', '401', '武汉理工大学出版社', '武汉', '2014-12-03', '1');
INSERT INTO `prefix` VALUES ('2', '44', '232', '401', '武汉理工大学出版社', '武汉', '2015-01-06', '1');
INSERT INTO `prefix` VALUES ('5', '146', '151', '401', '武汉理工大学出版社', '武汉', '2015-01-15', '1');
INSERT INTO `prefix` VALUES ('8', '123', '12312', '401', '武汉理工大学出版社', '武汉', '2015-01-22', '1');
INSERT INTO `prefix` VALUES ('14', '1212', '1212', '401', '武汉理工大学出版社', '武汉', '2015-01-13', '1');
INSERT INTO `prefix` VALUES ('32', '232', '222', '401', '武汉理工大学出版社', '武汉', '2015-01-23', '1');
INSERT INTO `prefix` VALUES ('35', '1212', '1212', '401', '武汉理工大学出版社', '武汉', '2015-01-21', '1');
INSERT INTO `prefix` VALUES ('43', '232', '323', '401', '武汉理工大学出版社', '武汉', '2015-01-07', '1');
INSERT INTO `prefix` VALUES ('45', '232', '232', '401', '武汉理工大学出版社', '武汉', '2014-12-18', '1');
INSERT INTO `prefix` VALUES ('54', '123', '123', '401', '武汉理工大学出版社', '武汉', '2015-01-16', '1');
INSERT INTO `prefix` VALUES ('67', '123', '232', '401', '武汉理工大学出版社', '武汉', '2015-01-12', '1');
INSERT INTO `prefix` VALUES ('121', '232', '222', '401', '武汉理工大学出版社', '武汉', '2015-01-14', '1');
INSERT INTO `prefix` VALUES ('130', '1223', '232', '401', '武汉理工大学出版社', '武汉', '2015-01-13', '1');
INSERT INTO `prefix` VALUES ('146', '232', '222', '401', '武汉理工大学出版社', '武汉', '2015-01-07', '1');

-- ----------------------------
-- Table structure for `reader`
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('1', '1', 'xiaozhujun', '00001', '男', '1986-08-15', '1');
INSERT INTO `reader` VALUES ('2', '2', 'zhangsan', '00002', '男', '1987-01-13', '1');
INSERT INTO `reader` VALUES ('3', '3', 'shunhui', '00003', '男', '1988-07-14', '1');

-- ----------------------------
-- Table structure for `readerrecord`
-- ----------------------------
DROP TABLE IF EXISTS `readerrecord`;
CREATE TABLE `readerrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `readerId` bigint(20) DEFAULT NULL,
  `bookSet` varchar(255) DEFAULT NULL,
  `curBookSet` varchar(255) DEFAULT NULL,
  `optionTypeId` bigint(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of readerrecord
-- ----------------------------
INSERT INTO `readerrecord` VALUES ('18', '1', '1;2;3;4;', '1;2;3;4;', '1', '2015-01-04 12:54:10', '1');
INSERT INTO `readerrecord` VALUES ('19', '1', '2;4;', '1;3;', '2', '2015-01-04 12:54:17', '1');
INSERT INTO `readerrecord` VALUES ('20', '1', '1;', '3;', '2', '2015-01-04 12:54:23', '1');
INSERT INTO `readerrecord` VALUES ('21', '1', '1;2;', '3;1;2;', '1', '2015-01-04 12:54:32', '1');
INSERT INTO `readerrecord` VALUES ('22', '1', '1;2;3;', '', '2', '2015-01-04 12:54:45', '1');
INSERT INTO `readerrecord` VALUES ('23', '1', '1;2;3;4;', '1;2;3;4;', '1', '2015-01-04 12:55:32', '1');
INSERT INTO `readerrecord` VALUES ('24', '1', '1;', '1;2;3;4;1;', '1', '2015-01-04 12:55:40', '1');
INSERT INTO `readerrecord` VALUES ('25', '1', '1;', '2;3;4;1;', '2', '2015-01-04 12:55:59', '1');

-- ----------------------------
-- Table structure for `readerrule`
-- ----------------------------
DROP TABLE IF EXISTS `readerrule`;
CREATE TABLE `readerrule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `readerId` bigint(20) DEFAULT NULL,
  `itemX` varchar(255) DEFAULT NULL,
  `itemY` varchar(255) DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=529 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readerrule
-- ----------------------------
INSERT INTO `readerrule` VALUES ('207', '1', '1;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('208', '1', '35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('209', '1', '14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('210', '1', '14;35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('211', '1', '1;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('212', '1', '1;', '14;35;5;', '1');
INSERT INTO `readerrule` VALUES ('213', '1', '1;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('214', '1', '14;', '1;', '1');
INSERT INTO `readerrule` VALUES ('215', '1', '1;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('216', '1', '14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('217', '1', '1;', '14;', '1');
INSERT INTO `readerrule` VALUES ('218', '1', '35;', '1;14;5;', '1');
INSERT INTO `readerrule` VALUES ('219', '1', '14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('220', '1', '1;14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('221', '1', '1;14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('222', '1', '14;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('223', '1', '1;5;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('224', '1', '35;5;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('225', '1', '1;35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('226', '1', '14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('227', '1', '35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('228', '1', '1;14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('229', '1', '1;14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('230', '1', '35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('231', '1', '14;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('232', '1', '1;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('233', '1', '14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('234', '1', '1;', '5;', '1');
INSERT INTO `readerrule` VALUES ('235', '1', '35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('236', '1', '14;35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('237', '1', '1;35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('238', '1', '35;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('239', '1', '35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('240', '1', '14;', '1;35;5;', '1');
INSERT INTO `readerrule` VALUES ('241', '1', '1;14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('242', '1', '35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('243', '1', '14;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('244', '1', '1;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('245', '1', '1;35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('246', '1', '35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('247', '1', '24;', '67;', '1');
INSERT INTO `readerrule` VALUES ('248', '1', '14;35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('249', '1', '1;', '35;', '1');
INSERT INTO `readerrule` VALUES ('250', '1', '14;5;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('251', '2', '35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('252', '2', '14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('253', '2', '14;35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('254', '2', '1;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('255', '2', '1;', '14;35;5;', '1');
INSERT INTO `readerrule` VALUES ('256', '2', '1;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('257', '2', '14;', '1;', '1');
INSERT INTO `readerrule` VALUES ('258', '2', '14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('259', '2', '121;', '1;', '1');
INSERT INTO `readerrule` VALUES ('260', '2', '1;', '14;', '1');
INSERT INTO `readerrule` VALUES ('261', '2', '8;', '45;5;', '1');
INSERT INTO `readerrule` VALUES ('262', '2', '1;14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('263', '2', '1;5;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('264', '2', '14;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('265', '2', '14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('266', '2', '45;5;', '8;', '1');
INSERT INTO `readerrule` VALUES ('267', '2', '1;14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('268', '2', '1;', '5;', '1');
INSERT INTO `readerrule` VALUES ('269', '2', '14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('270', '2', '1;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('271', '2', '14;35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('272', '2', '1;35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('273', '2', '35;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('274', '2', '1;14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('275', '2', '35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('276', '2', '14;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('277', '2', '35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('278', '2', '1;35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('279', '2', '8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('280', '2', '14;35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('281', '2', '1;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('282', '2', '45;', '5;', '1');
INSERT INTO `readerrule` VALUES ('283', '2', '45;8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('284', '2', '1;', '121;', '1');
INSERT INTO `readerrule` VALUES ('285', '2', '1;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('286', '2', '35;', '1;14;5;', '1');
INSERT INTO `readerrule` VALUES ('287', '2', '14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('288', '2', '1;14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('289', '2', '8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('290', '2', '35;5;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('291', '2', '1;35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('292', '2', '35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('293', '2', '1;14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('294', '2', '35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('295', '2', '14;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('296', '2', '5;8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('297', '2', '35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('298', '2', '35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('299', '2', '45;', '8;', '1');
INSERT INTO `readerrule` VALUES ('300', '2', '14;', '1;35;5;', '1');
INSERT INTO `readerrule` VALUES ('301', '2', '45;', '5;8;', '1');
INSERT INTO `readerrule` VALUES ('302', '2', '1;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('303', '2', '24;', '67;', '1');
INSERT INTO `readerrule` VALUES ('304', '2', '1;', '35;', '1');
INSERT INTO `readerrule` VALUES ('305', '2', '14;5;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('306', '3', '35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('307', '3', '14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('308', '3', '14;35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('309', '3', '1;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('310', '3', '1;', '14;35;5;', '1');
INSERT INTO `readerrule` VALUES ('311', '3', '1;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('312', '3', '14;', '1;', '1');
INSERT INTO `readerrule` VALUES ('313', '3', '14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('314', '3', '121;', '1;', '1');
INSERT INTO `readerrule` VALUES ('315', '3', '1;', '14;', '1');
INSERT INTO `readerrule` VALUES ('316', '3', '8;', '45;5;', '1');
INSERT INTO `readerrule` VALUES ('317', '3', '1;14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('318', '3', '1;5;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('319', '3', '14;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('320', '3', '14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('321', '3', '45;5;', '8;', '1');
INSERT INTO `readerrule` VALUES ('322', '3', '1;14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('323', '3', '1;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('324', '3', '1;', '5;', '1');
INSERT INTO `readerrule` VALUES ('325', '3', '14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('326', '3', '14;35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('327', '3', '1;35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('328', '3', '35;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('329', '3', '1;14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('330', '3', '35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('331', '3', '14;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('332', '3', '35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('333', '3', '1;35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('334', '3', '8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('335', '3', '14;35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('336', '3', '1;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('337', '3', '45;', '5;', '1');
INSERT INTO `readerrule` VALUES ('338', '3', '45;8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('339', '3', '1;', '121;', '1');
INSERT INTO `readerrule` VALUES ('340', '3', '1;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('341', '3', '35;', '1;14;5;', '1');
INSERT INTO `readerrule` VALUES ('342', '3', '14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('343', '3', '1;14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('344', '3', '8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('345', '3', '35;5;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('346', '3', '1;35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('347', '3', '35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('348', '3', '1;14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('349', '3', '35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('350', '3', '14;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('351', '3', '5;8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('352', '3', '35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('353', '3', '130;', '5;', '1');
INSERT INTO `readerrule` VALUES ('354', '3', '35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('355', '3', '45;', '8;', '1');
INSERT INTO `readerrule` VALUES ('356', '3', '14;', '1;35;5;', '1');
INSERT INTO `readerrule` VALUES ('357', '3', '45;', '5;8;', '1');
INSERT INTO `readerrule` VALUES ('358', '3', '1;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('359', '3', '24;', '67;', '1');
INSERT INTO `readerrule` VALUES ('360', '3', '1;', '35;', '1');
INSERT INTO `readerrule` VALUES ('361', '3', '14;5;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('362', '1', '35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('363', '1', '14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('364', '1', '14;35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('365', '1', '1;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('366', '1', '1;', '14;35;5;', '1');
INSERT INTO `readerrule` VALUES ('367', '1', '1;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('368', '1', '14;', '1;', '1');
INSERT INTO `readerrule` VALUES ('369', '1', '14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('370', '1', '121;', '1;', '1');
INSERT INTO `readerrule` VALUES ('371', '1', '1;', '14;', '1');
INSERT INTO `readerrule` VALUES ('372', '1', '8;', '45;5;', '1');
INSERT INTO `readerrule` VALUES ('373', '1', '1;14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('374', '1', '1;5;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('375', '1', '14;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('376', '1', '14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('377', '1', '45;5;', '8;', '1');
INSERT INTO `readerrule` VALUES ('378', '1', '1;14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('379', '1', '1;', '5;', '1');
INSERT INTO `readerrule` VALUES ('380', '1', '14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('381', '1', '1;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('382', '1', '14;35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('383', '1', '1;35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('384', '1', '35;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('385', '1', '1;14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('386', '1', '35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('387', '1', '14;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('388', '1', '35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('389', '1', '1;35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('390', '1', '8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('391', '1', '14;35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('392', '1', '1;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('393', '1', '45;', '5;', '1');
INSERT INTO `readerrule` VALUES ('394', '1', '45;8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('395', '1', '1;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('396', '1', '35;', '1;14;5;', '1');
INSERT INTO `readerrule` VALUES ('397', '1', '14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('398', '1', '1;14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('399', '1', '8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('400', '1', '35;5;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('401', '1', '1;35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('402', '1', '35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('403', '1', '1;14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('404', '1', '35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('405', '1', '14;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('406', '1', '5;8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('407', '1', '35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('408', '1', '130;', '5;', '1');
INSERT INTO `readerrule` VALUES ('409', '1', '35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('410', '1', '45;', '8;', '1');
INSERT INTO `readerrule` VALUES ('411', '1', '14;', '1;35;5;', '1');
INSERT INTO `readerrule` VALUES ('412', '1', '45;', '5;8;', '1');
INSERT INTO `readerrule` VALUES ('413', '1', '1;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('414', '1', '24;', '67;', '1');
INSERT INTO `readerrule` VALUES ('415', '1', '1;', '35;', '1');
INSERT INTO `readerrule` VALUES ('416', '1', '14;5;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('417', '2', '35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('418', '2', '14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('419', '2', '14;35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('420', '2', '1;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('421', '2', '1;', '14;35;5;', '1');
INSERT INTO `readerrule` VALUES ('422', '2', '1;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('423', '2', '14;', '1;', '1');
INSERT INTO `readerrule` VALUES ('424', '2', '14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('425', '2', '121;', '1;', '1');
INSERT INTO `readerrule` VALUES ('426', '2', '1;', '14;', '1');
INSERT INTO `readerrule` VALUES ('427', '2', '8;', '45;5;', '1');
INSERT INTO `readerrule` VALUES ('428', '2', '1;14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('429', '2', '1;5;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('430', '2', '14;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('431', '2', '14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('432', '2', '45;5;', '8;', '1');
INSERT INTO `readerrule` VALUES ('433', '2', '1;14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('434', '2', '1;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('435', '2', '1;', '5;', '1');
INSERT INTO `readerrule` VALUES ('436', '2', '14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('437', '2', '14;35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('438', '2', '1;35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('439', '2', '35;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('440', '2', '1;14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('441', '2', '35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('442', '2', '14;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('443', '2', '35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('444', '2', '1;35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('445', '2', '8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('446', '2', '14;35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('447', '2', '1;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('448', '2', '45;', '5;', '1');
INSERT INTO `readerrule` VALUES ('449', '2', '45;8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('450', '2', '1;', '121;', '1');
INSERT INTO `readerrule` VALUES ('451', '2', '1;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('452', '2', '35;', '1;14;5;', '1');
INSERT INTO `readerrule` VALUES ('453', '2', '14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('454', '2', '1;14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('455', '2', '8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('456', '2', '35;5;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('457', '2', '1;35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('458', '2', '35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('459', '2', '1;14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('460', '2', '35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('461', '2', '14;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('462', '2', '5;8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('463', '2', '35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('464', '2', '130;', '5;', '1');
INSERT INTO `readerrule` VALUES ('465', '2', '35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('466', '2', '45;', '8;', '1');
INSERT INTO `readerrule` VALUES ('467', '2', '14;', '1;35;5;', '1');
INSERT INTO `readerrule` VALUES ('468', '2', '45;', '5;8;', '1');
INSERT INTO `readerrule` VALUES ('469', '2', '1;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('470', '2', '24;', '67;', '1');
INSERT INTO `readerrule` VALUES ('471', '2', '1;', '35;', '1');
INSERT INTO `readerrule` VALUES ('472', '2', '14;5;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('473', '3', '35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('474', '3', '14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('475', '3', '14;35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('476', '3', '1;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('477', '3', '1;', '14;35;5;', '1');
INSERT INTO `readerrule` VALUES ('478', '3', '1;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('479', '3', '14;', '1;', '1');
INSERT INTO `readerrule` VALUES ('480', '3', '14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('481', '3', '121;', '1;', '1');
INSERT INTO `readerrule` VALUES ('482', '3', '1;', '14;', '1');
INSERT INTO `readerrule` VALUES ('483', '3', '8;', '45;5;', '1');
INSERT INTO `readerrule` VALUES ('484', '3', '1;14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('485', '3', '1;5;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('486', '3', '14;', '1;35;', '1');
INSERT INTO `readerrule` VALUES ('487', '3', '14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('488', '3', '45;5;', '8;', '1');
INSERT INTO `readerrule` VALUES ('489', '3', '1;14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('490', '3', '1;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('491', '3', '1;', '5;', '1');
INSERT INTO `readerrule` VALUES ('492', '3', '14;', '35;', '1');
INSERT INTO `readerrule` VALUES ('493', '3', '14;35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('494', '3', '1;35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('495', '3', '35;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('496', '3', '1;14;35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('497', '3', '35;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('498', '3', '14;', '1;5;', '1');
INSERT INTO `readerrule` VALUES ('499', '3', '35;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('500', '3', '1;35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('501', '3', '8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('502', '3', '14;35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('503', '3', '1;', '14;35;', '1');
INSERT INTO `readerrule` VALUES ('504', '3', '45;', '5;', '1');
INSERT INTO `readerrule` VALUES ('505', '3', '45;8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('506', '3', '1;', '121;', '1');
INSERT INTO `readerrule` VALUES ('507', '3', '1;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('508', '3', '35;', '1;14;5;', '1');
INSERT INTO `readerrule` VALUES ('509', '3', '14;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('510', '3', '1;14;', '5;', '1');
INSERT INTO `readerrule` VALUES ('511', '3', '8;', '5;', '1');
INSERT INTO `readerrule` VALUES ('512', '3', '35;5;', '1;14;', '1');
INSERT INTO `readerrule` VALUES ('513', '3', '1;35;', '14;5;', '1');
INSERT INTO `readerrule` VALUES ('514', '3', '35;', '5;', '1');
INSERT INTO `readerrule` VALUES ('515', '3', '1;14;', '35;5;', '1');
INSERT INTO `readerrule` VALUES ('516', '3', '35;5;', '14;', '1');
INSERT INTO `readerrule` VALUES ('517', '3', '14;5;', '1;', '1');
INSERT INTO `readerrule` VALUES ('518', '3', '5;8;', '45;', '1');
INSERT INTO `readerrule` VALUES ('519', '3', '35;', '14;', '1');
INSERT INTO `readerrule` VALUES ('520', '3', '130;', '5;', '1');
INSERT INTO `readerrule` VALUES ('521', '3', '35;', '1;', '1');
INSERT INTO `readerrule` VALUES ('522', '3', '45;', '8;', '1');
INSERT INTO `readerrule` VALUES ('523', '3', '14;', '1;35;5;', '1');
INSERT INTO `readerrule` VALUES ('524', '3', '45;', '5;8;', '1');
INSERT INTO `readerrule` VALUES ('525', '3', '1;5;', '35;', '1');
INSERT INTO `readerrule` VALUES ('526', '3', '24;', '67;', '1');
INSERT INTO `readerrule` VALUES ('527', '3', '1;', '35;', '1');
INSERT INTO `readerrule` VALUES ('528', '3', '14;5;', '1;35;', '1');

-- ----------------------------
-- Table structure for `reader_booktype`
-- ----------------------------
DROP TABLE IF EXISTS `reader_booktype`;
CREATE TABLE `reader_booktype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `readerId` bigint(20) DEFAULT NULL,
  `bookTypeId` bigint(20) DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader_booktype
-- ----------------------------

-- ----------------------------
-- Table structure for `storehouse`
-- ----------------------------
DROP TABLE IF EXISTS `storehouse`;
CREATE TABLE `storehouse` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `telNumber` varchar(255) DEFAULT NULL,
  `appId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storehouse
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `appId` bigint(20) DEFAULT '1',
  `status` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiaozhujun', 'e10adc3949ba59abbe56e057f20f883e', '男', 'ROLE_USER;ROLE_ADMIN;ROLE_ANONYMOUS', '1', '启用', null);
INSERT INTO `user` VALUES ('2', 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '男', 'ROLE_USER;ROLE_ANONYMOUS', '1', '启用', null);
INSERT INTO `user` VALUES ('3', 'sunhui', 'e68fa2bc61b75b8a06766e25905052c7', '男', 'ROLE_USER', '1', '启用', null);
INSERT INTO `user` VALUES ('4', 'liujinxia', 'c99c1cbefe13019978d90cb442cb8f78', '女', 'ROLE_ADMIN', '1', '启用', null);

-- ----------------------------
-- Table structure for `user_authority`
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `authorityId` bigint(20) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `authorityName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_authority
-- ----------------------------
INSERT INTO `user_authority` VALUES ('1', '1', '1', 'xiaozhujun', 'ROLE_USER');
INSERT INTO `user_authority` VALUES ('2', '1', '2', 'xiaozhujun', 'ROLE_ADMIN');
INSERT INTO `user_authority` VALUES ('3', '1', '3', 'xiaozhujun', 'ROLE_ANONYMOUS');
INSERT INTO `user_authority` VALUES ('4', '2', '3', 'zhangsan', 'ROLE_ANONYMOUS');
INSERT INTO `user_authority` VALUES ('5', '2', '1', 'zhangsan', 'ROLE_USER');
INSERT INTO `user_authority` VALUES ('6', '3', '1', 'sunhui', 'ROLE_USER');
INSERT INTO `user_authority` VALUES ('7', '4', '2', 'liujinxia', 'ROLE_ADMIN');

/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : bookshopdatabase

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-10-22 20:09:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(8) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(20) NOT NULL,
  `admin_passwd` varchar(20) NOT NULL,
  `admin_realname` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'summer', '1111', '赵达');
INSERT INTO `admin` VALUES ('3', 'sky', '1111', 'jack');
INSERT INTO `admin` VALUES ('4', 'zhangsan', '1111', '张三');
INSERT INTO `admin` VALUES ('5', 'lisi', '1111', '李四');
INSERT INTO `admin` VALUES ('6', 'wangwu', '1111', '王五');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(8) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) NOT NULL,
  `book_author` varchar(20) NOT NULL,
  `book_publisher` varchar(30) NOT NULL,
  `book_price` double(30,2) NOT NULL,
  `book_description` varchar(200) NOT NULL,
  `book_imgurl` varchar(50) DEFAULT NULL,
  `type_id` int(8) NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `book_ibfk_1` (`type_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `book_type` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2', 'javaee', 'ice11', '人民出版社', '98.00', '学习javaee', '/images/book/2.JPG', '10');
INSERT INTO `book` VALUES ('3', '海底两万里', '凡尔纳', '人民出版社', '45.00', '海底的奇艺冒险', '/images/book/3.JPG', '5');
INSERT INTO `book` VALUES ('4', '钢铁是怎样炼成的', '列夫托尔斯泰', '中国出版社', '32.00', '磨炼钢铁的意志', '/images/book/4.JPG', '2');
INSERT INTO `book` VALUES ('106', '成功秘方', '闫佳成', '536出版社', '100.00', '掌握成功', '/images/book/106.JPG', '2');
INSERT INTO `book` VALUES ('112', '书名2', '作者2', '出版社2', '2.00', '描述2', null, '3');
INSERT INTO `book` VALUES ('113', '书名3', '作者3', '出版社3', '3.00', '描述3', null, '4');
INSERT INTO `book` VALUES ('114', '书名4', '作者4', '出版社4', '4.00', '描述4', null, '4');
INSERT INTO `book` VALUES ('115', '书名5', '作者5', '出版社5', '5.00', '描述5', null, '6');
INSERT INTO `book` VALUES ('116', '书名6', '作者6', '出版社6', '6.00', '描述6', null, '6');
INSERT INTO `book` VALUES ('117', '书名7', '作者7', '出版社7', '7.00', '描述7', null, '6');
INSERT INTO `book` VALUES ('118', '书名8', '作者8', '出版社8', '8.00', '描述8', null, '6');
INSERT INTO `book` VALUES ('119', '书名9', '作者9', '出版社9', '9.00', '描述9', null, '7');
INSERT INTO `book` VALUES ('120', '书名10', '作者10', '出版社10', '10.00', '描述10', null, '7');
INSERT INTO `book` VALUES ('121', '书名11', '作者11', '出版社11', '11.00', '描述11', null, '8');
INSERT INTO `book` VALUES ('122', '书名12', '作者12', '出版社12', '12.00', '描述12', null, '9');
INSERT INTO `book` VALUES ('123', '书名13', '作者13', '出版社13', '13.00', '描述13', null, '10');
INSERT INTO `book` VALUES ('124', '书名14', '作者14', '出版社14', '14.00', '描述14', null, '1');
INSERT INTO `book` VALUES ('125', '书名15', '作者15', '出版社15', '15.00', '描述15', null, '1');
INSERT INTO `book` VALUES ('126', '书名16', '作者16', '出版社16', '16.00', '描述16', null, '1');
INSERT INTO `book` VALUES ('127', '书名17', '作者17', '出版社17', '17.00', '描述17', null, '1');
INSERT INTO `book` VALUES ('128', '书名18', '作者18', '出版社18', '18.00', '描述18', null, '1');
INSERT INTO `book` VALUES ('129', '书名19', '作者19', '出版社19', '19.00', '描述19', null, '1');
INSERT INTO `book` VALUES ('130', '书名20', '作者20', '出版社20', '20.00', '描述20', null, '1');
INSERT INTO `book` VALUES ('131', '书名21', '作者21', '出版社21', '21.00', '描述21', null, '1');
INSERT INTO `book` VALUES ('132', '书名22', '作者22', '出版社22', '22.00', '描述22', null, '1');
INSERT INTO `book` VALUES ('133', '书名23', '作者23', '出版社23', '23.00', '描述23', null, '1');
INSERT INTO `book` VALUES ('134', '书名24', '作者24', '出版社24', '24.00', '描述24', null, '1');
INSERT INTO `book` VALUES ('135', '书名25', '作者25', '出版社25', '25.00', '描述25', null, '1');
INSERT INTO `book` VALUES ('136', '书名26', '作者26', '出版社26', '26.00', '描述26', null, '1');
INSERT INTO `book` VALUES ('137', '书名27', '作者27', '出版社27', '27.00', '描述27', null, '1');
INSERT INTO `book` VALUES ('138', '书名28', '作者28', '出版社28', '28.00', '描述28', null, '1');
INSERT INTO `book` VALUES ('139', '书名29', '作者29', '出版社29', '29.00', '描述29', null, '1');
INSERT INTO `book` VALUES ('140', '书名30', '作者30', '出版社30', '30.00', '描述30', null, '1');
INSERT INTO `book` VALUES ('141', '书名31', '作者31', '出版社31', '31.00', '描述31', null, '1');
INSERT INTO `book` VALUES ('142', '书名32', '作者32', '出版社32', '32.00', '描述32', null, '1');
INSERT INTO `book` VALUES ('143', '书名33', '作者33', '出版社33', '33.00', '描述33', null, '1');
INSERT INTO `book` VALUES ('144', '书名34', '作者34', '出版社34', '34.00', '描述34', null, '1');
INSERT INTO `book` VALUES ('145', '书名35', '作者35', '出版社35', '35.00', '描述35', null, '1');
INSERT INTO `book` VALUES ('146', '书名36', '作者36', '出版社36', '36.00', '描述36', null, '1');
INSERT INTO `book` VALUES ('147', '书名37', '作者37', '出版社37', '37.00', '描述37', null, '1');
INSERT INTO `book` VALUES ('148', '书名38', '作者38', '出版社38', '38.00', '描述38', null, '1');
INSERT INTO `book` VALUES ('149', '书名39', '作者39', '出版社39', '39.00', '描述39', null, '1');
INSERT INTO `book` VALUES ('150', '书名40', '作者40', '出版社40', '40.00', '描述40', null, '1');
INSERT INTO `book` VALUES ('151', '书名41', '作者41', '出版社41', '41.00', '描述41', null, '1');
INSERT INTO `book` VALUES ('152', '书名42', '作者42', '出版社42', '42.00', '描述42', null, '1');
INSERT INTO `book` VALUES ('153', '书名43', '作者43', '出版社43', '43.00', '描述43', null, '1');
INSERT INTO `book` VALUES ('154', '书名44', '作者44', '出版社44', '44.00', '描述44', null, '1');
INSERT INTO `book` VALUES ('155', '书名45', '作者45', '出版社45', '45.00', '描述45', null, '1');
INSERT INTO `book` VALUES ('156', '书名46', '作者46', '出版社46', '46.00', '描述46', null, '1');
INSERT INTO `book` VALUES ('157', '书名47', '作者47', '出版社47', '47.00', '描述47', null, '1');
INSERT INTO `book` VALUES ('158', '书名48', '作者48', '出版社48', '48.00', '描述48', null, '1');
INSERT INTO `book` VALUES ('159', '书名49', '作者49', '出版社49', '49.00', '描述49', null, '1');
INSERT INTO `book` VALUES ('160', '书名50', '作者50', '出版社50', '50.00', '描述50', null, '1');
INSERT INTO `book` VALUES ('161', '书名51', '作者51', '出版社51', '51.00', '描述51', null, '1');
INSERT INTO `book` VALUES ('162', '书名52', '作者52', '出版社52', '52.00', '描述52', null, '1');
INSERT INTO `book` VALUES ('163', '书名53', '作者53', '出版社53', '53.00', '描述53', null, '1');
INSERT INTO `book` VALUES ('164', '书名54', '作者54', '出版社54', '54.00', '描述54', null, '1');
INSERT INTO `book` VALUES ('165', '书名55', '作者55', '出版社55', '55.00', '描述55', null, '1');
INSERT INTO `book` VALUES ('166', '书名56', '作者56', '出版社56', '56.00', '描述56', null, '1');
INSERT INTO `book` VALUES ('167', '书名57', '作者57', '出版社57', '57.00', '描述57', null, '1');
INSERT INTO `book` VALUES ('168', '书名58', '作者58', '出版社58', '58.00', '描述58', null, '1');
INSERT INTO `book` VALUES ('169', '书名59', '作者59', '出版社59', '59.00', '描述59', null, '1');
INSERT INTO `book` VALUES ('170', '书名60', '作者60', '出版社60', '60.00', '描述60', null, '1');
INSERT INTO `book` VALUES ('171', '书名61', '作者61', '出版社61', '61.00', '描述61', null, '1');
INSERT INTO `book` VALUES ('172', '书名62', '作者62', '出版社62', '62.00', '描述62', null, '1');
INSERT INTO `book` VALUES ('173', '书名63', '作者63', '出版社63', '63.00', '描述63', null, '1');
INSERT INTO `book` VALUES ('174', '书名64', '作者64', '出版社64', '64.00', '描述64', null, '1');
INSERT INTO `book` VALUES ('175', '书名65', '作者65', '出版社65', '65.00', '描述65', null, '1');
INSERT INTO `book` VALUES ('176', '书名66', '作者66', '出版社66', '66.00', '描述66', null, '1');
INSERT INTO `book` VALUES ('177', '书名67', '作者67', '出版社67', '67.00', '描述67', null, '1');
INSERT INTO `book` VALUES ('178', '书名68', '作者68', '出版社68', '68.00', '描述68', null, '1');
INSERT INTO `book` VALUES ('179', '书名69', '作者69', '出版社69', '69.00', '描述69', null, '1');
INSERT INTO `book` VALUES ('180', '书名70', '作者70', '出版社70', '70.00', '描述70', null, '1');
INSERT INTO `book` VALUES ('181', '书名71', '作者71', '出版社71', '71.00', '描述71', null, '1');
INSERT INTO `book` VALUES ('182', '书名72', '作者72', '出版社72', '72.00', '描述72', null, '1');
INSERT INTO `book` VALUES ('183', '书名73', '作者73', '出版社73', '73.00', '描述73', null, '1');
INSERT INTO `book` VALUES ('184', '书名74', '作者74', '出版社74', '74.00', '描述74', null, '1');
INSERT INTO `book` VALUES ('185', '书名75', '作者75', '出版社75', '75.00', '描述75', null, '1');
INSERT INTO `book` VALUES ('186', '书名76', '作者76', '出版社76', '76.00', '描述76', null, '1');
INSERT INTO `book` VALUES ('187', '书名77', '作者77', '出版社77', '77.00', '描述77', null, '1');
INSERT INTO `book` VALUES ('188', '书名78', '作者78', '出版社78', '78.00', '描述78', null, '1');
INSERT INTO `book` VALUES ('189', '书名79', '作者79', '出版社79', '79.00', '描述79', null, '1');
INSERT INTO `book` VALUES ('190', '书名80', '作者80', '出版社80', '80.00', '描述80', null, '1');
INSERT INTO `book` VALUES ('191', '书名81', '作者81', '出版社81', '81.00', '描述81', null, '1');
INSERT INTO `book` VALUES ('192', '书名82', '作者82', '出版社82', '82.00', '描述82', null, '1');
INSERT INTO `book` VALUES ('193', '书名83', '作者83', '出版社83', '83.00', '描述83', null, '1');
INSERT INTO `book` VALUES ('194', '书名84', '作者84', '出版社84', '84.00', '描述84', null, '1');
INSERT INTO `book` VALUES ('195', '书名85', '作者85', '出版社85', '85.00', '描述85', null, '1');
INSERT INTO `book` VALUES ('196', '书名86', '作者86', '出版社86', '86.00', '描述86', null, '1');
INSERT INTO `book` VALUES ('197', '书名87', '作者87', '出版社87', '87.00', '描述87', null, '1');
INSERT INTO `book` VALUES ('198', '书名88', '作者88', '出版社88', '88.00', '描述88', null, '1');
INSERT INTO `book` VALUES ('199', '书名89', '作者89', '出版社89', '89.00', '描述89', null, '1');
INSERT INTO `book` VALUES ('200', '书名90', '作者90', '出版社90', '90.00', '描述90', null, '1');
INSERT INTO `book` VALUES ('201', '书名91', '作者91', '出版社91', '91.00', '描述91', null, '1');
INSERT INTO `book` VALUES ('202', '书名92', '作者92', '出版社92', '92.00', '描述92', null, '1');
INSERT INTO `book` VALUES ('203', '书名93', '作者93', '出版社93', '93.00', '描述93', null, '1');
INSERT INTO `book` VALUES ('204', '书名94', '作者94', '出版社94', '94.00', '描述94', null, '1');
INSERT INTO `book` VALUES ('205', '书名95', '作者95', '出版社95', '95.00', '描述95', null, '1');
INSERT INTO `book` VALUES ('206', '书名96', '作者96', '出版社96', '96.00', '描述96', null, '1');
INSERT INTO `book` VALUES ('207', '书名97', '作者97', '出版社97', '97.00', '描述97', null, '1');
INSERT INTO `book` VALUES ('208', '书名98', '作者98', '出版社98', '98.00', '描述98', null, '1');
INSERT INTO `book` VALUES ('209', '书名99', '作者99', '出版社99', '99.00', '描述99', null, '1');
INSERT INTO `book` VALUES ('210', '书名100', '作者100', '出版社100', '100.00', '描述100', null, '1');

-- ----------------------------
-- Table structure for `book_type`
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type` (
  `type_id` int(8) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES ('1', '青春');
INSERT INTO `book_type` VALUES ('2', '玄幻');
INSERT INTO `book_type` VALUES ('3', '科幻');
INSERT INTO `book_type` VALUES ('4', '爱情');
INSERT INTO `book_type` VALUES ('5', '科教');
INSERT INTO `book_type` VALUES ('6', '悬疑');
INSERT INTO `book_type` VALUES ('7', '推理');
INSERT INTO `book_type` VALUES ('8', '神话');
INSERT INTO `book_type` VALUES ('9', '科学');
INSERT INTO `book_type` VALUES ('10', '体育');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) NOT NULL,
  `order_time` datetime NOT NULL,
  `order_state` varchar(5) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `orders_ibfk_1` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('44', '2', '2017-10-20 18:45:20', '已完成');
INSERT INTO `orders` VALUES ('45', '2', '2017-10-21 19:45:45', '已完成');
INSERT INTO `orders` VALUES ('47', '2', '2017-10-21 20:17:33', '已完成');
INSERT INTO `orders` VALUES ('49', '2', '2017-10-21 20:17:52', '已完成');
INSERT INTO `orders` VALUES ('50', '2', '2017-10-21 20:47:25', '已完成');
INSERT INTO `orders` VALUES ('51', '2', '2017-10-22 18:33:47', '已完成');
INSERT INTO `orders` VALUES ('53', '2', '2017-10-22 18:38:45', '已完成');
INSERT INTO `orders` VALUES ('54', '2', '2017-10-22 19:39:03', '已完成');
INSERT INTO `orders` VALUES ('55', '2', '2017-10-22 20:02:47', '已完成');

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_detail_id` int(8) NOT NULL AUTO_INCREMENT,
  `order_id` int(8) NOT NULL,
  `book_id` int(8) NOT NULL,
  `count` int(5) NOT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `order_detail_ibfk_1` (`order_id`),
  KEY `order_detail_ibfk_2` (`book_id`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('42', '44', '4', '1');
INSERT INTO `order_detail` VALUES ('47', '49', '4', '1');
INSERT INTO `order_detail` VALUES ('50', '51', '2', '1');
INSERT INTO `order_detail` VALUES ('53', '54', '2', '3');
INSERT INTO `order_detail` VALUES ('54', '54', '3', '1');
INSERT INTO `order_detail` VALUES ('55', '55', '2', '5');
INSERT INTO `order_detail` VALUES ('56', '55', '3', '1');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(20) NOT NULL,
  `user_passwd` varchar(20) NOT NULL,
  `user_email` varchar(20) NOT NULL,
  `user_telephone` varchar(30) DEFAULT NULL,
  `user_address` varchar(50) NOT NULL,
  `posttime` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('2', 'sky', '000000', '1551073921@qq.com', '11111111111', '南二环东路20号河北师范大学新校区', '2017-10-20 18:29:14');

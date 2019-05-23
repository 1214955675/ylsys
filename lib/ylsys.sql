/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : ylsys

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 23/05/2019 20:42:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advice
-- ----------------------------
DROP TABLE IF EXISTS `advice`;
CREATE TABLE `advice`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `createTime` bigint(50) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactWay` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isDeal` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advice
-- ----------------------------
INSERT INTO `advice` VALUES (1, 1555507484488, 'asdasadasd', '1214@qq.com', 1);
INSERT INTO `advice` VALUES (2, 1558614811350, '这是什么', '3221242625@qq.com', 1);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `fromUserId` int(50) NULL DEFAULT NULL,
  `fromUserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fromUserImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toCommentId` int(50) NULL DEFAULT NULL,
  `toPostId` int(50) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `commentTime` bigint(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 'wwj', NULL, 0, 1, '评论', NULL);
INSERT INTO `comment` VALUES (2, NULL, NULL, NULL, 0, 1, '你好', NULL);

-- ----------------------------
-- Table structure for deal
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adviceId` int(50) NULL DEFAULT NULL,
  `dealTime` bigint(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deal
-- ----------------------------
INSERT INTO `deal` VALUES (1, '1111111111', 1, 1385431);
INSERT INTO `deal` VALUES (2, '123', 2, 1558615152064);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `messageId` int(255) NOT NULL AUTO_INCREMENT,
  `fromId` int(50) NULL DEFAULT NULL,
  `fromName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toId` int(50) NULL DEFAULT NULL,
  `messageText` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `messageDate` bigint(50) NULL DEFAULT NULL,
  `formatDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`messageId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 1, NULL, 3, 'nihao', 1557583756108, '2019-05-11 22:09:16');
INSERT INTO `message` VALUES (2, 1, NULL, 2, 'sd', 1557583756103, '2019-05-11 22:09:16');
INSERT INTO `message` VALUES (3, 3, NULL, 1, '123', 1557583756102, NULL);
INSERT INTO `message` VALUES (4, 4, NULL, 1, '12', NULL, NULL);
INSERT INTO `message` VALUES (5, 1, 'wwj', 3, 'nihao', 1557641836286, '2019-05-12 14:17:16');
INSERT INTO `message` VALUES (6, 0, 'wwj', 4, '？\n\n		<div><br></div>', 1557652807908, '2019-05-12 17:20:07');
INSERT INTO `message` VALUES (7, 0, 'wwj', 3, '？？', 1557652838492, '2019-05-12 17:20:38');
INSERT INTO `message` VALUES (8, 0, 'wwj', 4, '暗示的\n\n		', 1557656447856, '2019-05-12 18:20:47');
INSERT INTO `message` VALUES (9, 0, 'wwj', 3, '222', 1557656465736, '2019-05-12 18:21:05');
INSERT INTO `message` VALUES (10, 0, 'wwj', 3, '暗示的', 1557656471055, '2019-05-12 18:21:11');
INSERT INTO `message` VALUES (11, 0, 'wwj', 3, '', 1557656477511, '2019-05-12 18:21:17');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `postName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` bigint(50) NULL DEFAULT NULL,
  `topicId` int(11) NULL DEFAULT NULL,
  `clickNum` int(50) NULL DEFAULT NULL,
  `postImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 'test', '23sdas<p><img src=\"\" style=\"max-width:100%;\"><img src=\"http://localhost:8080/upload/b9b2e998bfe585b9e7b1b3e59388e9b281b344.jpg\" style=\"max-width: 100%;\"><br></p>', 1555506286899, 1, 2, NULL);
INSERT INTO `post` VALUES (2, '123123问问', '<p><img style=\"max-width: 100%;\" src=\"http://localhost:8080/upload/b9b2e998bfe585b9e7b1b3e59388e9b281b344.jpg\">啊实打实大<br></p>', 1557407854219, 1, 15, NULL);
INSERT INTO `post` VALUES (3, '试试撒', '<p>阿萨1是多少</p>', 1557416861770, 1, 1, NULL);
INSERT INTO `post` VALUES (5, '521', '<p>硕大的</p>', 1558442519858, 2, 1, 'http://localhost:8080/upload/b9b2e998bfe585b9e7b1b3e59388e9b281b344.jpg');
INSERT INTO `post` VALUES (6, '请问', '<p>方法方法</p>', 1558442754036, 2, 1, 'http://localhost:8080/upload/b9b2e998bfe585b9e7b1b3e59388e9b281b344.jpg');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `topicName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `postNum` int(50) NULL DEFAULT NULL,
  `imgUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clickNum` int(50) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES (1, 'testtest', 3, '', 47);
INSERT INTO `topic` VALUES (2, 'test', 2, '', 23);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `passWord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wwj', '123', 'j', '18161214978', NULL);
INSERT INTO `user` VALUES (2, '222', '222', 'sda', NULL, NULL);
INSERT INTO `user` VALUES (3, 'lll', '123', 'ggg', NULL, NULL);
INSERT INTO `user` VALUES (4, '去问问', '123', '去', NULL, 'http://localhost:8080/upload/b9b2e998bfe585b9e7b1b3e59388e9b281b344.jpg');

-- ----------------------------
-- Table structure for usertaste
-- ----------------------------
DROP TABLE IF EXISTS `usertaste`;
CREATE TABLE `usertaste`  (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `userId` int(50) NULL DEFAULT NULL,
  `collectTime` bigint(250) NULL DEFAULT NULL,
  `topicId` int(50) NULL DEFAULT -1,
  `postId` int(50) NULL DEFAULT -1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usertaste
-- ----------------------------
INSERT INTO `usertaste` VALUES (1, 1, 1557410865432, 1, -1);
INSERT INTO `usertaste` VALUES (2, 1, 1557410865433, 1, -1);
INSERT INTO `usertaste` VALUES (3, 4, 1557410865434, 2, -1);
INSERT INTO `usertaste` VALUES (4, 4, 1557410865436, 2, -1);
INSERT INTO `usertaste` VALUES (5, 1, 1557410865412, 1, -1);
INSERT INTO `usertaste` VALUES (6, 4, 1557410865433, 2, -1);
INSERT INTO `usertaste` VALUES (7, 4, 1557410865422, 2, -1);
INSERT INTO `usertaste` VALUES (8, 4, 1557410865422, 3, -1);
INSERT INTO `usertaste` VALUES (10, 1, 1557416277037, 2, -1);
INSERT INTO `usertaste` VALUES (11, 3, 1558442213322, 1, -1);
INSERT INTO `usertaste` VALUES (13, 3, 1558444117416, 2, -1);
INSERT INTO `usertaste` VALUES (14, 3, 1558444168430, 2, -1);
INSERT INTO `usertaste` VALUES (15, 1, 1558445411529, 1, -1);
INSERT INTO `usertaste` VALUES (16, 1, 1558445419529, 1, -1);
INSERT INTO `usertaste` VALUES (17, 1, 1558445421354, 1, -1);
INSERT INTO `usertaste` VALUES (18, 1, 1558445423263, 1, -1);
INSERT INTO `usertaste` VALUES (19, 1, 1558445424968, 1, -1);
INSERT INTO `usertaste` VALUES (20, 1, 1558445426921, 1, -1);
INSERT INTO `usertaste` VALUES (21, 1, 1558445673489, 1, -1);
INSERT INTO `usertaste` VALUES (22, 1, 1558445874899, -1, 2);
INSERT INTO `usertaste` VALUES (23, 1, 1558446264424, -1, 2);
INSERT INTO `usertaste` VALUES (24, 1, 1558446270690, -1, 2);
INSERT INTO `usertaste` VALUES (25, 1, 0, 1, -1);
INSERT INTO `usertaste` VALUES (26, 1, 0, 1, -1);
INSERT INTO `usertaste` VALUES (27, 1, 0, 2, -1);
INSERT INTO `usertaste` VALUES (28, 1, 1558614509551, -1, 2);
INSERT INTO `usertaste` VALUES (29, 1, 0, 1, -1);
INSERT INTO `usertaste` VALUES (30, 1, 0, 1, -1);
INSERT INTO `usertaste` VALUES (31, 1, 0, 1, -1);
INSERT INTO `usertaste` VALUES (32, 1, 0, 1, -1);
INSERT INTO `usertaste` VALUES (33, 3, 0, 1, -1);
INSERT INTO `usertaste` VALUES (34, 1, 0, 1, -1);

SET FOREIGN_KEY_CHECKS = 1;

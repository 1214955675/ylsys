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

 Date: 10/05/2019 21:27:30
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 'test', '23sdas<p><img src=\"\" style=\"max-width:100%;\"><img src=\"http://localhost:8080/upload/b9b2e998bfe585b9e7b1b3e59388e9b281b344.jpg\" style=\"max-width: 100%;\"><br></p>', 1555506286899, 1, 1);
INSERT INTO `post` VALUES (2, '123123问问', '<p><img style=\"max-width: 100%;\" src=\"http://localhost:8080/upload/b9b2e998bfe585b9e7b1b3e59388e9b281b344.jpg\">啊实打实大<br></p>', 1557407854219, 1, 1);
INSERT INTO `post` VALUES (3, '试试撒', '<p>阿萨是多少</p>', 1557416861770, 1, 1);

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `topicName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `postNum` int(50) NULL DEFAULT NULL,
  `imgUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES (1, 'testtest', 1, '');
INSERT INTO `topic` VALUES (2, 'test', 1, '');
INSERT INTO `topic` VALUES (3, '哇哇的', 0, 'D:\\opt\\img\\632a3e5a-29fa-4cd0-8c85-ccb85c9e912f.jpg');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wwj', '123', 'j', '18161214978', NULL);
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
  `topicId` int(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usertaste
-- ----------------------------
INSERT INTO `usertaste` VALUES (1, 1, 1557410865432, 1);
INSERT INTO `usertaste` VALUES (2, 1, 1557410865433, 1);
INSERT INTO `usertaste` VALUES (3, 4, 1557410865434, 2);
INSERT INTO `usertaste` VALUES (4, 4, 1557410865436, 2);
INSERT INTO `usertaste` VALUES (5, 1, 1557410865412, 1);
INSERT INTO `usertaste` VALUES (6, 4, 1557410865433, 2);
INSERT INTO `usertaste` VALUES (7, 4, 1557410865422, 2);
INSERT INTO `usertaste` VALUES (8, 4, 1557410865422, 3);
INSERT INTO `usertaste` VALUES (9, 1, 1557416179106, 1);
INSERT INTO `usertaste` VALUES (10, 1, 1557416277037, 1);

SET FOREIGN_KEY_CHECKS = 1;

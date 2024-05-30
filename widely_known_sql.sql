-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.34 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 widely_known 的数据库结构
CREATE DATABASE IF NOT EXISTS `widely_known` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `widely_known`;

-- 导出  表 widely_known.icon_group 结构
CREATE TABLE IF NOT EXISTS `icon_group` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名字',
  `icon_path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片路径',
  `relevance_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `icon_group` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片组',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='图片组';

-- 正在导出表  widely_known.icon_group 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `icon_group` DISABLE KEYS */;
INSERT INTO `icon_group` (`id`, `name`, `icon_path`, `relevance_id`, `create_time`, `update_time`, `icon_group`) VALUES
	('6a2b488c14afc8e611c5ac4e81503919', 'admin', '/static/1.png', '2', '2024-05-22 23:45:59', NULL, NULL);
/*!40000 ALTER TABLE `icon_group` ENABLE KEYS */;

-- 导出  表 widely_known.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '管理员标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 正在导出表  widely_known.user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `username`, `password`, `email`, `create_time`, `update_time`, `isAdmin`) VALUES
	('140895b21f141557b7ac6b80920a8d181', 'admin', 'admin', 'admin', 'xxxxx@q.com', '2024-05-22 21:54:33', NULL, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 导出  表 widely_known.widely_data 结构
CREATE TABLE IF NOT EXISTS `widely_data` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `introduce` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '介绍',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='家乡';

-- 正在导出表  widely_known.widely_data 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `widely_data` DISABLE KEYS */;
INSERT INTO `widely_data` (`id`, `title`, `introduce`, `type`, `user_id`, `create_time`, `update_time`) VALUES
	(1, '粽子', '粽子', '食物', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(2, '粽子', '粽子', '食物', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(3, '粽子', '粽子', '食物', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(4, '粽子', '粽子', '食物', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(6, '英歌舞', '潮汕地区英歌舞集戏剧、舞蹈、武术于一体 [12]，具有独特的步法、身法、槌法、阵法。既似土风，又似武舞。它以刚劲、雄浑、粗犷、奔放的舞姿，构成了磅礴、威武、强壮、豪迈的气势，给人以力与美的震撼', '文化', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(7, '南澳岛', '广东省内最大的也是唯一的海岛县，美丽的海上绿洲，海岸线，海鲜美食，满足你各种休闲体验', '景点', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(9, '礐石风景名胜区', '这里风景绮丽、丘峦簇拥、怪石奇峭，古朴的民居与殖民地洋楼并存，是海湾环抱的亚热带植物为特色的滨海自然风景名胜区', '景点', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(10, '前美古村·陈慈黉故居', '前美村是汕头市澄海区隆都镇的一个行政村，历史悠久，海外华侨众多，是潮汕地区著名的古村落、汕头市著名侨乡、汕头十大著名旅游景点之一', '景点', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(11, '莲华乡村旅游区', '前美村是汕头市澄海区隆都镇的一个行政村，历史悠久，海外华侨众多，是潮汕地区著名的古村落、汕头市著名侨乡、汕头十大著名旅游景点之一。', '景点', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(12, '英歌舞', '潮汕地区英歌舞集戏剧、舞蹈、武术于一体 [12]，具有独特的步法、身法、槌法、阵法。既似土风，又似武舞。它以刚劲、雄浑、粗犷、奔放的舞姿，构成了磅礴、威武、强壮、豪迈的气势，给人以力与美的震撼', '文化', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(13, '英歌舞', '潮汕地区英歌舞集戏剧、舞蹈、武术于一体 [12]，具有独特的步法、身法、槌法、阵法。既似土风，又似武舞。它以刚劲、雄浑、粗犷、奔放的舞姿，构成了磅礴、威武、强壮、豪迈的气势，给人以力与美的震撼', '文化', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL),
	(15, '英歌舞', '潮汕地区英歌舞集戏剧、舞蹈、武术于一体 [12]，具有独特的步法、身法、槌法、阵法。既似土风，又似武舞。它以刚劲、雄浑、粗犷、奔放的舞姿，构成了磅礴、威武、强壮、豪迈的气势，给人以力与美的震撼', '文化', '140895b21f141557b7ac6b80920a8d181', '2024-05-22 22:27:03', NULL);
/*!40000 ALTER TABLE `widely_data` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

CREATE DATABASE IF NOT EXISTS `JWebGW`;
USE `JWebGW`;

CREATE TABLE IF NOT EXISTS `AdminUser` (
  `user_id` char(24) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `bm_id` text DEFAULT NULL,
  `bm_name` text DEFAULT NULL,
  `user_account` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `power_id` text DEFAULT NULL,
  `user_sort` varchar(5) DEFAULT NULL,
  `user_style` char(2) DEFAULT NULL,
  `user_uptimelogin` char(20) DEFAULT NULL,
  `user_time` char(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_account` (`user_account`),
  KEY `index4` (`user_sort`),
  KEY `index5` (`user_style`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `AdminUser` (`user_id`, `user_name`, `bm_id`, `bm_name`, `user_account`, `user_password`, `user_email`, `power_id`, `user_sort`, `user_style`, `user_uptimelogin`, `user_time`) VALUES
	('201802171403338370000001', '超级管理员', NULL, NULL, 'superadmin#', 'superadmin#', NULL, '', '0-01', '启用', NULL, '2018-02-17 14:03:33'),
	('201802171404503510000002', 'G_Admin', '', '', 'admin', 'admin', 'pankeng1988w@163.com', 'Y100,Y100_4,Y100_4_1,Y100_4_2,Y100_0,Y100_1,Y100_1_1,Y100_1_2,Y100_1_3,Y100_2,Y100_3,Y100_3_1,Y100_3_2,Y100_3_3,J,J5,J51,J52,J51_1,J51_2,J51_3,J4,J41,J42,J43,J43_1,J43_2,J43_3,J44,J44_1,J44_2,J44_3,J44_4,J7_2,J7_2_1,J7_2_2,J7_2_2_1,J7_2_2_2,J7_2_2_3,X,X1,X1_1,X1_2,X1_2_1,X1_2_2,X1_2_3,X1_3,X2,X2_1,X2_2,X2_2_1,X2_2_2,X2_2_3,X2_3,X3,X3_2,X3_3,X3_4', '管理员', '启用', NULL, '2018-02-17 14:04:50');

CREATE TABLE IF NOT EXISTS `JSDJ` (
  `jsdj_zj` char(24) NOT NULL,
  `jsdj_dm` int(11) NOT NULL,
  `jsdj_mc` varchar(50) NOT NULL,
  `jsdj_bz` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`jsdj_zj`),
  UNIQUE KEY `jsdj_dm` (`jsdj_dm`),
  UNIQUE KEY `jsdj_mc` (`jsdj_mc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `JSDJ` (`jsdj_zj`, `jsdj_dm`, `jsdj_mc`, `jsdj_bz`) VALUES
	('201707311429218510000002', 1, '股东层', ''),
	('201707311429287670000003', 2, '总监层', ''),
	('201707311429363810000004', 3, '经理层', '');

CREATE TABLE IF NOT EXISTS `Role` (
  `role_id` char(24) NOT NULL,
  `jsdj_zj` char(24) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `role_info` varchar(50) DEFAULT NULL,
  `role_create` datetime NOT NULL,
  `power` varchar(5000) DEFAULT NULL,
  `user_id` char(24) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`),
  KEY `jsdj_zj` (`jsdj_zj`),
  KEY `role_create` (`role_create`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `Role` (`role_id`, `jsdj_zj`, `role_name`, `role_info`, `role_create`, `power`, `user_id`, `user_name`) VALUES
	('201802171406168450000003', '201707311429218510000002', 'ALL', '', '2018-02-17 14:06:16', 'Y100,Y100_4,Y100_4_1,Y100_4_2,Y100_0,Y100_1,Y100_1_1,Y100_1_2,Y100_1_3,Y100_2,Y100_3,Y100_3_1,Y100_3_2,Y100_3_3,J,J5,J51,J52,J51_1,J51_2,J51_3,J4,J41,J42,J43,J43_1,J43_2,J43_3,J44,J44_1,J44_2,J44_3,J44_4,J7_2,J7_2_1,J7_2_2,J7_2_2_1,J7_2_2_2,J7_2_2_3', '201802171404503510000002', 'G_Admin');

CREATE TABLE IF NOT EXISTS `User` (
  `user_id` char(24) NOT NULL,
  `role_id` varchar(5000) DEFAULT NULL,
  `power_id` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `User` (`user_id`, `role_id`, `power_id`) VALUES
	('201711281619003970000001', '201802171406168450000003', '');

CREATE TABLE IF NOT EXISTS `BM` (
  `bm_id` char(24) NOT NULL,
  `bm_pid` char(24) NOT NULL,
  `bm_name` char(50) NOT NULL,
  PRIMARY KEY (`bm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `BM` (`bm_id`, `bm_pid`, `bm_name`) VALUES
	('201708161038567800000003', '0', '小汪科技工作室'),
	('201708161039129690000004', '201708161038567800000003', '总经办');


CREATE TABLE IF NOT EXISTS `RY` (
  `ry_id` char(24) NOT NULL,
  `bm_id` char(24) NOT NULL,
  `bm_name` varchar(50) NOT NULL,
  `gw_id` char(24) DEFAULT NULL,
  `gw_name` varchar(50) DEFAULT NULL,
  `ry_cdate` datetime NOT NULL,
  `ry_style` int(11) NOT NULL,
  `ry_sort` int(11) NOT NULL,
  `ry_name` varchar(50) NOT NULL,
  `ry_sex` char(1) NOT NULL,
  `ry_email` varchar(150) DEFAULT NULL,
  `ry_phone` varchar(150) DEFAULT NULL,
  `ry_info` varchar(150) DEFAULT NULL,
  `ry_account` varchar(50) NOT NULL,
  `ry_password` varchar(50) NOT NULL,
  PRIMARY KEY (`ry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `RY` (`ry_id`, `bm_id`, `bm_name`, `gw_id`, `gw_name`, `ry_cdate`, `ry_style`, `ry_sort`, `ry_name`, `ry_sex`, `ry_email`, `ry_phone`, `ry_info`, `ry_account`, `ry_password`) VALUES
('201711281619003970000001', '201708161039129690000004', '总经办', '', 'ERP工程师', '2017-03-20 00:00:00', 1, 3, '汪春滋', '男', 'wangchunzi@rarone.cc', '8893、17097600192', '22', 'wangchunzi', '123');

CREATE TABLE IF NOT EXISTS `JingyanKuFL` (
  `jingyankufl_id` char(24) NOT NULL,
  `jingyankufl_pid` char(24) NOT NULL,
  `jingyankufl_name` char(50) NOT NULL,
  PRIMARY KEY (`jingyankufl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `JingyanKuFL` (`jingyankufl_id`, `jingyankufl_pid`, `jingyankufl_name`) VALUES
	('201801291207394470000007', '0', '前言'),
	('201801291207430510000008', '0', '文档中心');

CREATE TABLE `Spage_index` (
  `spage_indexpage_zj` char(24) NOT NULL,
  `spage_indexpage_neirong` TEXT NOT NULL,
  PRIMARY KEY (`spage_indexpage_zj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;	
INSERT INTO `Spage_index` (`spage_indexpage_zj`, `spage_indexpage_neirong`) VALUES
	('1', '<div class="container" style=" margin-top: 50px;">\n            <div class="row clearfix">\n                <div class="col-md-12 column">\n                    <div class="page-header" style="color: #008">\n                        <h2>\n                            <p>JWeb框架</p> <p><small>高效、快速、创新</small></p>\n                        </h2>\n                    </div>\n                </div>\n            </div>\n            <div>\n                   您好！ 首页编辑要注意，百度ueditor会自动删除第三方样式（不是ueditor认可的。）所以，一旦您修改首页，一定要使用html视图编辑，把样式加上才行。\n            </div>\n        </div>\n');

CREATE TABLE IF NOT EXISTS `Spage_jingyanku` (
  `spage_jingyanku_zj` char(24) NOT NULL,
  `spage_jingyanku_biaoti` varchar(200) NOT NULL,
  `spage_jingyanku_gjc` varchar(500) NOT NULL,
  `spage_jingyanku_neirong` text NOT NULL,
  `spage_jingyanku_fabushijian` varchar(30) NOT NULL,
  `spage_jingyanku_zhidanren` varchar(50) NOT NULL,
  `spage_jingyanku_zhidanren_zj` char(24) NOT NULL,
  `jingyankufl_id` varchar(50) NOT NULL,
  `jingyankufl_name` char(24) NOT NULL,
  `spage_jingyanku_zhidanshijian` varchar(21) NOT NULL,
  PRIMARY KEY (`spage_jingyanku_zj`),
  KEY `spage_jingyanku_biaoti` (`spage_jingyanku_biaoti`),
  KEY `spage_jingyanku_gjc` (`spage_jingyanku_gjc`),
  KEY `jingyankufl_id` (`jingyankufl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `Spage_notice` (
  `spage_notice_zj` char(24) NOT NULL,
  `spage_notice_biaoti` varchar(200) NOT NULL,
  `spage_notice_neirong` text NOT NULL,
  `spage_notice_fabushijian` varchar(30) NOT NULL,
  `spage_notice_zhidanren` varchar(50) NOT NULL,
  `spage_notice_zhidanren_zj` char(24) NOT NULL,
  `spage_notice_zhidanshijian` varchar(21) NOT NULL,
  PRIMARY KEY (`spage_notice_zj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `Spage_notice` (`spage_notice_zj`, `spage_notice_biaoti`, `spage_notice_neirong`, `spage_notice_fabushijian`, `spage_notice_zhidanren`, `spage_notice_zhidanren_zj`, `spage_notice_zhidanshijian`) VALUES
	('201802171414023480000004', 'JWeb框架发布啦', '发布时间不填，默认使用当前的时间。<img src="http://img.baidu.com/hi/jx2/j_0002.gif"/><p></p>', '2018-02-17 14:14:02', '汪春滋', '201711281619003970000001', '2018-02-17 14:14:02');

	CREATE TABLE `Mybeanfield` (
	`mybeanfield_zj` CHAR(24) NOT NULL,
	`mybean_zj` CHAR(24) NOT NULL,
	`mybean_mc` VARCHAR(50) NOT NULL,
	`mybeanfield_bz` VARCHAR(50) NULL DEFAULT NULL,
	`mybeanfield_dateformat` VARCHAR(50) NULL DEFAULT NULL,
	`c_zyy` VARCHAR(50) NOT NULL,
	`c_lx` VARCHAR(50) NOT NULL,
	`c_mc` VARCHAR(50) NOT NULL,
	`c_bz` VARCHAR(50) NOT NULL,
	`c_setmethod` VARCHAR(50) NOT NULL,
	`c_getmethod` VARCHAR(50) NOT NULL,
	`t_mc` VARCHAR(50) NOT NULL,
	`t_lx` VARCHAR(50) NOT NULL,
	`t_sy` VARCHAR(50) NULL DEFAULT NULL,
	`t_yxkong` VARCHAR(50) NOT NULL,
	`t_cd` VARCHAR(50) NULL DEFAULT NULL,
	`t_bz` VARCHAR(50) NULL DEFAULT NULL,
	`v_zzbds` VARCHAR(200) NULL DEFAULT NULL,
	`v_cuowuxx` VARCHAR(50) NULL DEFAULT NULL,
	`v_bxjiancha` VARCHAR(50) NULL DEFAULT NULL,
	`h_lx` VARCHAR(50) NOT NULL,
	`h_jb` VARCHAR(50) NULL DEFAULT NULL,
	`e_mc` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`mybeanfield_zj`)
)
ENGINE=InnoDB;

CREATE TABLE `MyModel` (
	`mymodel_zj` CHAR(24) NOT NULL,
	`mybean_zj` CHAR(24) NOT NULL,
	`mybean_mc` VARCHAR(50) NOT NULL,
	`mymodel_mc` VARCHAR(500) NULL DEFAULT NULL,
	`mymodel_nr` TEXT NULL DEFAULT NULL,
	PRIMARY KEY (`mymodel_zj`)
)
ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS `CModel`(
`cmodel_zj` CHAR(24) NOT NULL/*主键*/
,`cmodel_mc` VARCHAR(50) DEFAULT NULL/*模型名*/
,`cmodel_nr` TEXT     DEFAULT NULL/*模型内容*/

,PRIMARY KEY (`cmodel_zj`)
,UNIQUE KEY `cmodel_mc` (`cmodel_mc`)
) ENGINE=InnoDB ;

CREATE TABLE `MyPackage` (
  `mypackage_id` char(24) NOT NULL,
  `mypackage_pid` char(24) NOT NULL,
  `mypackage_name` char(50) NOT NULL,
  PRIMARY KEY (`mypackage_id`)
) ENGINE=InnoDB;

DROP TABLE `Mybean`;
CREATE TABLE IF NOT EXISTS `Mybean`(
    `mybean_zj` CHAR(24)  NOT NULL  /*主键*/
    ,`mybean_px` INT  DEFAULT NULL /*排序*/
    ,`mypackage_id` CHAR(24)  NOT NULL /*外键（归属包）*/
    ,`mybean_mc` VARCHAR(50)  NOT NULL /*类名*/
    ,`mybean_bz` VARCHAR(50)  DEFAULT NULL /*备注*/
    ,`package_bean` VARCHAR(100)  DEFAULT NULL /*bean类包*/
    ,`package_soo` VARCHAR(100)  DEFAULT NULL /*soo/dao 类包*/
    ,`name_soo` VARCHAR(100)  DEFAULT NULL /*soo/dao 类*/
    ,`package_service` VARCHAR(100)  DEFAULT NULL /*service类包*/
    ,`name_service` VARCHAR(100)  DEFAULT NULL /*service类*/
    ,`package_hm` VARCHAR(100)  DEFAULT NULL /*hm类包*/
    ,`name_hmA` VARCHAR(100)  DEFAULT NULL /*hmA类*/
    ,`name_hmD` VARCHAR(100)  DEFAULT NULL /*hmD类*/
    ,`name_hmU` VARCHAR(100)  DEFAULT NULL /*hmU类*/
    ,`name_hmS` VARCHAR(100)  DEFAULT NULL /*hmS类*/
    ,`package_validate` VARCHAR(100)  DEFAULT NULL /*validate类包*/
    ,`name_validate` VARCHAR(100)  DEFAULT NULL /*validate类*/
    ,`package_cache` VARCHAR(100)  DEFAULT NULL /*cache类包*/
    ,`name_cache` VARCHAR(100)  DEFAULT NULL /*cache类*/
    ,`package_vo` VARCHAR(100)  DEFAULT NULL /*vo类包*/
    ,`name_vo` VARCHAR(100)  DEFAULT NULL /*vo类*/
    ,`vpackage_admin` VARCHAR(100)  DEFAULT NULL /*jsp/html包*/
    ,`vname_admin` VARCHAR(100)  DEFAULT NULL /*jsp/html包*/
    ,`vname_adminA` VARCHAR(100)  DEFAULT NULL /*jsp/html_A*/
    ,`vname_adminD` VARCHAR(100)  DEFAULT NULL /*jsp/html_D*/
    ,`vname_adminS` VARCHAR(100)  DEFAULT NULL /*jsp/html_S*/
    ,`vname_adminU` VARCHAR(100)  DEFAULT NULL /*jsp/html_U*/
    ,`vpackage_admin_js` VARCHAR(100)  DEFAULT NULL /*js包*/
    ,`vname_admin_js` VARCHAR(100)  DEFAULT NULL /*js*/
    ,`vpackage_admin_css` VARCHAR(100)  DEFAULT NULL /*css包*/
    ,`vname_admin_css` VARCHAR(100)  DEFAULT NULL /*css*/
    ,`power_code` VARCHAR(100)  DEFAULT NULL /*模块权限代码*/
    ,`power_codeA` VARCHAR(100)  DEFAULT NULL /*权限代码A*/
    ,`power_codeD` VARCHAR(100)  DEFAULT NULL /*权限代码D*/
    ,`power_codeS` VARCHAR(100)  DEFAULT NULL /*权限代码S*/
    ,`power_codeU` VARCHAR(100)  DEFAULT NULL /*权限代码U*/

    ,PRIMARY KEY (`mybean_zj`)
    ,KEY `mypackage_id` (`mypackage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
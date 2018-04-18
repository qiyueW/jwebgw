DROP TABLE `YushizhiFL`;
CREATE TABLE `YushizhiFL` (
  `yushizhifl_id` char(24) NOT NULL,
  `yushizhifl_pid` char(24) NOT NULL,
  `yushizhifl_name` char(50) NOT NULL,
  PRIMARY KEY (`yushizhifl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
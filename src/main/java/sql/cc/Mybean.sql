CREATE TABLE `Mybean` (
  `mybean_zj` CHAR(24) NOT NULL,
  `mybean_px` INT NULL,
  `mypackage_id` char(24) NULL,
  `mybean_mc` VARCHAR(50) NOT NULL,
  `mybean_bz` VARCHAR(100) NULL,
  PRIMARY KEY (`mybean_zj`),
  UNIQUE INDEX `mybean_mc_UNIQUE` (`mybean_mc` ASC),
  INDEX `mypackage_id` (`mypackage_id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
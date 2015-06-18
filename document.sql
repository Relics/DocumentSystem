SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `document` DEFAULT CHARACTER SET utf8 ;
USE `document` ;

-- -----------------------------------------------------
-- Table `document`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `document`.`department` (
  `departmentNo` INT(11) NOT NULL,
  `departmentName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`departmentNo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `document`.`file1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `document`.`file1` (
  `fileID` INT(11) NOT NULL AUTO_INCREMENT,
  `fileName` VARCHAR(200) NULL DEFAULT NULL,
  `filePath` VARCHAR(200) NULL DEFAULT NULL,
  `ownPeopleID` INT(11) NULL DEFAULT NULL,
  `modifiedDate` DATETIME NULL DEFAULT NULL,
  `size` VARCHAR(45) NULL DEFAULT NULL,
  `kind` VARCHAR(200) NULL DEFAULT NULL,
  `ownDepartNo` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`fileID`),
  INDEX `ownPeopleID_idx` (`ownPeopleID` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 59
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `document`.`fileauthority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `document`.`fileauthority` (
  `fileID` INT(11) NOT NULL,
  `isFolder` INT(11) NULL DEFAULT NULL,
  `departmentNo` INT(11) NOT NULL,
  `isViewable` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`fileID`, `departmentNo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `document`.`people`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `document`.`people` (
  `peopleID` INT(11) NOT NULL,
  `password` VARCHAR(45) NULL DEFAULT '123',
  `groupNo` INT(11) NOT NULL,
  `peopleName` VARCHAR(45) NULL DEFAULT NULL,
  `photo` VARCHAR(45) NULL DEFAULT NULL,
  `male` VARCHAR(45) NULL DEFAULT NULL,
  `bornPlace` VARCHAR(200) NULL DEFAULT NULL,
  `bornYear` VARCHAR(20) NULL DEFAULT NULL,
  `Nation` VARCHAR(45) NULL DEFAULT NULL,
  `departmentNo` INT(11) NULL DEFAULT NULL,
  `position` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`peopleID`),
  INDEX `departmentNo_idx` (`departmentNo` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `people` (`peopleID`,`password`,`groupNo`,`peopleName`,`photo`,`male`,`bornPlace`,`bornYear`,`Nation`,`departmentNo`,`position`) VALUES (1,'1',1,'王五',NULL,NULL,NULL,NULL,NULL,5,NULL);
INSERT INTO `people` (`peopleID`,`password`,`groupNo`,`peopleName`,`photo`,`male`,`bornPlace`,`bornYear`,`Nation`,`departmentNo`,`position`) VALUES (2,'2',0,'李四',NULL,NULL,NULL,NULL,NULL,2,NULL);
INSERT INTO `people` (`peopleID`,`password`,`groupNo`,`peopleName`,`photo`,`male`,`bornPlace`,`bornYear`,`Nation`,`departmentNo`,`position`) VALUES (123,'123',1,'张三',NULL,NULL,NULL,NULL,NULL,1,NULL);
INSERT INTO `department` (`departmentNo`,`departmentName`) VALUES (0,'后台管理');
INSERT INTO `department` (`departmentNo`,`departmentName`) VALUES (1,'财务');
INSERT INTO `department` (`departmentNo`,`departmentName`) VALUES (2,'教务');
INSERT INTO `department` (`departmentNo`,`departmentName`) VALUES (3,'党务');
INSERT INTO `department` (`departmentNo`,`departmentName`) VALUES (4,'资产');
INSERT INTO `department` (`departmentNo`,`departmentName`) VALUES (5,'工会');
INSERT INTO `department` (`departmentNo`,`departmentName`) VALUES (6,'学生');
INSERT INTO `department` (`departmentNo`,`departmentName`) VALUES (7,'教职工');
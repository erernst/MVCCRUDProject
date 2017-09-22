-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema emaze
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `emaze` ;

-- -----------------------------------------------------
-- Schema emaze
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `emaze` DEFAULT CHARACTER SET utf8 ;
USE `emaze` ;

-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(200) NOT NULL,
  `state` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `emaze`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emaze` ;

CREATE TABLE IF NOT EXISTS `emaze` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `course` VARCHAR(1000) NOT NULL,
  `location_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `emaze_location`
    FOREIGN KEY (`id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO mazeuser@localhost;
 DROP USER mazeuser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'mazeuser'@'localhost' IDENTIFIED BY 'maze';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'mazeuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `location`
-- -----------------------------------------------------
START TRANSACTION;
USE `emaze`;
INSERT INTO `location` (`id`, `city`, `state`) VALUES (1, ' Hollister', ' California');
INSERT INTO `location` (`id`, `city`, `state`) VALUES (2, ' Frederick', ' Maryland');
INSERT INTO `location` (`id`, `city`, `state`) VALUES (3, ' Danville', ' Vermont');
INSERT INTO `location` (`id`, `city`, `state`) VALUES (4, ' Germantown', ' Ohio');
INSERT INTO `location` (`id`, `city`, `state`) VALUES (5, ' Lehi', ' Utah');
INSERT INTO `location` (`id`, `city`, `state`) VALUES (6, ' Harrodsburg', ' Kentucky');
INSERT INTO `location` (`id`, `city`, `state`) VALUES (7, ' Ronks', ' Pennsylvania');
INSERT INTO `location` (`id`, `city`, `state`) VALUES (8, ' Meridian', ' Idaho');
INSERT INTO `location` (`id`, `city`, `state`) VALUES (9, ' Anderson', ' South Carolina');
INSERT INTO `location` (`id`, `city`, `state`) VALUES (10, ' Mercer', ' Pennsylvania');

COMMIT;


-- -----------------------------------------------------
-- Data for table `emaze`
-- -----------------------------------------------------
START TRANSACTION;
USE `emaze`;
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (1, ' Swank Farms', ' http://img1.10bestmedia.com/Images/Photos/333547/472_54_990x660.jpg', 1);
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (2, ' Summers Farm', ' http://img2.10bestmedia.com/Images/Photos/333489/Summers-Farm_54_990x660.jpg', 2);
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (3, ' Great Vermont', ' http://img1.10bestmedia.com/Images/Photos/333492/altered-2016_54_990x660.jpg', 3);
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (4, ' Tom\'s Maze', ' http://img1.10bestmedia.com/Images/Photos/333550/unnamed-Something-To-Crow-About--2016-maze_54_990x660.jpg', 4);
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (5, ' Cornbelly\'s', ' http://img1.10bestmedia.com/Images/Photos/333493/Cornbelly_54_990x660.jpg', 5);
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (6, ' Devine\'s', ' http://img2.10bestmedia.com/Images/Photos/333485/Devine-s_54_990x660.JPG', 6);
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (7, ' Cherry Crest Farm', ' http://img1.10bestmedia.com/Images/Photos/333474/CCAF-2016-Maze-detail-LR_54_990x660.jpg', 7);
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (8, ' Farmstead', ' http://img1.10bestmedia.com/Images/Photos/333955/MazeDesign2016-The-Farmstead_54_990x660.jpeg', 8);
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (9, ' Denver Downs', ' http://img2.10bestmedia.com/Images/Photos/333595/2014-Denver-Downs-AgPro-JD-Maze_54_990x660.JPG', 9);
INSERT INTO `emaze` (`id`, `name`, `course`, `location_id`) VALUES (10, ' Cool Spring', ' http://img1.10bestmedia.com/Images/Photos/333703/Coolspring_54_990x660.jpg', 10);

COMMIT;


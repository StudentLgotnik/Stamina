CREATE TABLE `stamina`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Email` VARCHAR(255) NOT NULL,
  `Name` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `Record` INT NULL,
  `Current` TINYINT NOT NULL,
  PRIMARY KEY (`ID`));

CREATE TABLE `stamina`.`type` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Score` DOUBLE NOT NULL,
  `Language` VARCHAR(45) NOT NULL,
  `Date` VARCHAR(25) NOT NULL,
  `UserId` INT NOT NULL,
  PRIMARY KEY (`ID`));

CREATE TABLE `stamina`.`languages` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Language` VARCHAR(45) NOT NULL,
  `Text` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`ID`));
/** Test data **/
INSERT INTO languages(LANGUAGE, TEXT) VALUE ('English', 'user user user user user user user user user user user user user user user ');
INSERT INTO languages(LANGUAGE, TEXT) VALUE ('Russian', 'пользователь пользователь пользователь пользователь пользователь пользователь ');
INSERT INTO languages(LANGUAGE, TEXT) VALUE ('Ukrainian', 'користувач користувач користувач користувач користувач користувач користувач ');

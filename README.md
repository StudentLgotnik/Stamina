**Description:**
<br>This maven project is analogous to the program 'Stamina' only in the form of a website.
In project used jsp files with css styles in folder 'webapp/WEB-INF/pages'. 
The project isn't ideal and needs further work. 
Especially the storage functionality of the current user and isn't intended for multi-user use. The 
reason for all this is the lack of my experience. 
pom.xml have all required comments. <br>
**Technologies:**
1. Spring MVC;
2. Hibernate;
3. SLF4J
4. DBCP
5. Servlet
---
**Server:**
<br>Tomcat 7.0.85
<br>Default URL: http://localhost:8080/
<br>**Database:**
Used: MySQL;
<br>Script to create tables:
```sql
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
```

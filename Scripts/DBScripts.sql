create schema StudentManagement;
use StudentManagement;

create table if not exists oauth_access_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication LONG VARBINARY,
  refresh_token VARCHAR(255)
);
create table if not exists oauth_refresh_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication LONG VARBINARY
);



CREATE TABLE `student` (
  `student_id INT,
  `RegNo` INT,
  `Name` VARCHAR(45) NOT NULL,
  `course_id` INT NULL,
  PRIMARY KEY (`Name`)
  CONSTRAINT `FK_Category`
    FOREIGN KEY (`student_id`)
    REFERENCES `user` (`User_id`));
  
  CREATE TABLE `teacher` (
  `Teacher_id` INT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Teacher_id`)
    CONSTRAINT `FK_Category`
    FOREIGN KEY (`Teacher_id`)
    REFERENCES `user` (`User_id`)););
  
CREATE TABLE `user` (
	`User_id` INT(11) NOT NULL AUTO_INCREMENT ;
	`password` VARCHAR(150) NOT NULL AFTER `user_name`,
	`User_role` VARCHAR(45) NOT NULL AFTER `password`;
	
	PRIMARY KEY (`User_id`));
  
  CREATE TABLE `AttendanceHistory` (
  `course_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  'course_time' DATE,
  'attended' BOOLEAN);
 
  CREATE TABLE `Courses` (
  `course_id` INT NOT NULL,
  `Course_Name` VARCHAR(45) NOT NULL,
  `courseDate` DATE, 
  
  CREATE TABLE `CourseSchedule` (
  `course_id` INT NOT NULL,
  `teacher_id` INT NOT NULL,
  `courseDate` DATE,

  PRIMARY KEY (`course_id`,'courseDate'),
  INDEX `FK_Category_idx` (`category_id` ASC),
  CONSTRAINT `FK_Category`
    FOREIGN KEY (`course_id`)
    REFERENCES `Courses` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	



CREATE TABLE `role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`));

INSERT INTO `role` (`role_id`, `role_name`) VALUES ('1', 'ADMIN');
INSERT INTO `role` (`role_id`, `role_name`) VALUES ('2', 'USER');


ALTER TABLE `user` 
CHANGE COLUMN `User_role` `role_id` INT NOT NULL ,
ADD INDEX `fk_role_idx` (`role_id` ASC);
ALTER TABLE `member` 
ADD CONSTRAINT `fk_role`
  FOREIGN KEY (`role_id`)
  REFERENCES `role` (`role_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

insert into user values (1, 'Tim', '$2a$10$yS3A95pgXy9AT1pNYfog1..35m5I7/qGGp4K3rIFn5erHPHJtbWRC');
insert into user values (2, 'Cook', '$2a$10$TOy2Isg4bKZ9Rxrhjo8lKeSQ7slQCEpdNeVDQD77vCnO3vpx2W6y2',);
insert into user values (2, 'Pam', '$2a$10$TOy2Isg4bKZ9Rxrhjo8lKeSQ7slQCEpdNeVDQD77vCnO3vpx2W6y2',);


insert into Courses values (1,'Chemistry');
insert into Courses values (2,'Maths');
insert into Courses values (3,'Physics');

insert into CourseSchedule values (1,2,'26 JAN 2105 11:11:11');
insert into CourseSchedule values (2,1,'26 JAN 2105 11:11:11');
insert into CourseSchedule values (3,2,'10 MAY 2006 05:14:11');

insert into AttendanceHistory values (1,1,TRUE);
insert into AttendanceHistory values (2,2,FALSE);
insert into AttendanceHistory values (3,1,TRUE);
insert into AttendanceHistory values (2,3,FALSE);


commit;
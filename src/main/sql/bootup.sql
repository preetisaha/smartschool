CREATE SCHEMA `SmartSchool` ;
use SmartSchool;

CREATE TABLE `SmartSchool`.`Login` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC));

CREATE TABLE `SmartSchool`.`Teacher` (
  `tid` INT NOT NULL,
  `teacherName` VARCHAR(45) NOT NULL,
  `designation` VARCHAR(45) NULL,
  PRIMARY KEY (`tid`),
    CONSTRAINT `tid`
    FOREIGN KEY (`tid`)
    REFERENCES `SmartSchool`.`Login` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION 
);

CREATE TABLE `SmartSchool`.`Student` (
  `sid` INT NOT NULL,
  `studentName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sid`),
  CONSTRAINT `sid`
    FOREIGN KEY (`sid`)
    REFERENCES `SmartSchool`.`Login` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE `SmartSchool`.`course` (
  `courseId` INT NOT NULL AUTO_INCREMENT,
  `courseName` VARCHAR(45) NOT NULL,
  `teacherId` INT NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  PRIMARY KEY (`courseId`),
  INDEX `teacherId_idx` (`teacherId` ASC),
  CONSTRAINT `teacherId`
    FOREIGN KEY (`teacherId`)
    REFERENCES `SmartSchool`.`Teacher` (`tid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `SmartSchool`.`student_course` (
  `studentId` INT NOT NULL AUTO_INCREMENT,
  `student_course_id` INT NOT NULL,
  INDEX `studentId_idx` (`studentId` ASC),
  INDEX `student_course_id_idx` (`student_course_id` ASC),
  CONSTRAINT `studentId`
    FOREIGN KEY (`studentId`)
    REFERENCES `SmartSchool`.`Student` (`sid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_course_id`
    FOREIGN KEY (`student_course_id`)
    REFERENCES `SmartSchool`.`course` (`courseId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `SmartSchool`.`exam` (
  `examId` INT NOT NULL AUTO_INCREMENT,
  `examName` VARCHAR(45) NULL,
  `startDate` DATE NULL,
  `endDate` DATE NULL,
  `duration` VARCHAR(45) NULL,
  `marks` INT NULL,
  `courseId` INT NULL,
  `publish` TINYINT(10) NOT NULL,
  `grade_status` TINYINT(10) NOT NULL;
  PRIMARY KEY (`examId`),
  INDEX `courseId_idx` (`courseId` ASC),
  CONSTRAINT `courseId`
    FOREIGN KEY (`courseId`)
    REFERENCES `SmartSchool`.`course` (`courseId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `SmartSchool`.`question` (
  `questionId` INT NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(45) NULL,
  `marks` INT NULL,
  `type` VARCHAR(45) NULL,
  `examId` INT NOT NULL,
  PRIMARY KEY (`questionId`),
  INDEX `examId_idx` (`examId` ASC),
  CONSTRAINT `examId`
    FOREIGN KEY (`examId`)
    REFERENCES `SmartSchool`.`exam` (`examId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `SmartSchool`.`multiple_choice` (
  `multiple_choice_id` INT NOT NULL AUTO_INCREMENT,
  `choice_type` VARCHAR(45) NULL,
  `answer` VARCHAR(45) NULL,
  `questionId` INT NOT NULL,
  PRIMARY KEY (`multiple_choice_id`),
  INDEX `questionId_idx` (`questionId` ASC),
  CONSTRAINT `questionId`
    FOREIGN KEY (`questionId`)
    REFERENCES `SmartSchool`.`question` (`questionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `SmartSchool`.`answer` (
  `answerId` INT NOT NULL AUTO_INCREMENT,
  `question_id` INT(11) NOT NULL,
  `answer` VARCHAR(45) NULL,
  `student_id` INT(11) NOT NULL,
  `marks` INT NULL,
  PRIMARY KEY (`answerId`),
  INDEX `question_id_idx` (`question_id` ASC),
  INDEX `student_id_idx` (`student_id` ASC),
  CONSTRAINT `question_id`
    FOREIGN KEY (`question_id`)
    REFERENCES `SmartSchool`.`question` (`questionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `SmartSchool`.`Student` (`sid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `SmartSchool`.`grades` (
  `id_student` INT(11) NOT NULL,
  `id_exam` INT(11) NOT NULL,
  `id_course` INT(11) NOT NULL,
  `grade` VARCHAR(45) NULL,
  INDEX `id_student_idx` (`id_student` ASC),
  INDEX `id_exam_idx` (`id_exam` ASC),
  INDEX `id_course_idx` (`id_course` ASC),
  CONSTRAINT `id_student`
    FOREIGN KEY (`id_student`)
    REFERENCES `SmartSchool`.`Student` (`sid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_exam`
    FOREIGN KEY (`id_exam`)
    REFERENCES `SmartSchool`.`exam` (`examId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_course`
    FOREIGN KEY (`id_course`)
    REFERENCES `SmartSchool`.`course` (`courseId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

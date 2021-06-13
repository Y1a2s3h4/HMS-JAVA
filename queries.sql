CREATE DATABASE `hms_db`;
CREATE TABLE `doctorappoint` (
  `A_ID` int NOT NULL AUTO_INCREMENT,
  `Doctor_Name` char(25) DEFAULT NULL,
  `Patient_Name` char(25) DEFAULT NULL,
  `Patient_Disease` char(45) DEFAULT NULL,
  `Date_Time` char(45) DEFAULT NULL,
  PRIMARY KEY (`A_ID`)
);

CREATE TABLE `doctordetails` (
  `doc_id` int NOT NULL AUTO_INCREMENT,
  `doc_name` char(15) DEFAULT NULL,
  `doc_mail` varchar(30) DEFAULT NULL,
  `doc_pass` char(20) DEFAULT NULL,
  PRIMARY KEY (`doc_id`)
);

CREATE TABLE `patientappoint` (
  `PA_ID` int NOT NULL AUTO_INCREMENT,
  `Patient_Name` char(25) DEFAULT NULL,
  `Patient_Disease` char(45) DEFAULT NULL,
  `treatment_by` char(45) DEFAULT NULL,
  `bill` int DEFAULT NULL,
  `payBy` char(45) DEFAULT NULL,
  PRIMARY KEY (`PA_ID`)
);

CREATE TABLE `patientdetails` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `patient_name` char(15) DEFAULT NULL,
  `patient_pass` char(20) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
);





/*  PRETEST 4 */

/*
1. Create a database named dbPretest4 with the following specifications :
   a. Primary file group with the data file dbPretest4.mdf. The size, maximum size,
      and file growth should be 8, unlimited and 20 respectively.
   b. Log file dbPretest4_log.ldf. The size, maximum size, and file growth should be
      8, 50, and 10% respectively.
*/

create database dbPretest4
on primary
( name=dbPretest4, filename='f:\data\dbPretest4.mdf',size=8, maxsize=unlimited, filegrowth=20)
log on
( name=dbPretest4_log, filename='f:\data\dbPretest4_log.ldf',size=8, maxsize=50, filegrowth=10%)
go

-- open database 
use dbPretest4
go

/*
	2. Create the tables:
*/

--table tbProjects
create table tbStudent (
	stID varchar(5) not null,
	stName varchar(50) ,
	stAge tinyint,
	stGender bit not null constraint DF_gender DEFAULT 1,
	constraint PK_stid primary key nonclustered (stID),
	constraint CK_age CHECK (stAge between 14 and 70),
)

-- table tbProjects
create table tbProjects (
	pID varchar(5) ,
	pName varchar(50) Not null unique,
	pType varchar(5) ,
	pStartDate date Not null constraint DF_startdate default GETDATE(),
	constraint PK_project primary key nonclustered (pID),
	constraint UNI_pname unique (pName),
	constraint CK_type check (pType in ('EDU','DEP' , 'GOV') )
)

-- table tbStudentProject
create table tbStudentProject (
	studentID varchar(5) Not null,
	projectID varchar(5) Not null,
	joinedDate date Not null constraint DF_joinedDate default GETDATE(),
	rate tinyint,
	constraint PK_studentProject primary key nonclustered(studentID , projectID),
	constraint FK_prj foreign key (studentID) references tbStudent,
	constraint FK_std foreign key (projectID) references tbStudent,
	constraint CK_rate check (rate between 1 and 5)
)
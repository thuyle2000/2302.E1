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
	constraint FK_std foreign key (studentID) references tbStudent,
	constraint FK_prj foreign key (projectID) references tbProjects,
	constraint CK_rate check (rate between 1 and 5)
)
go

/*
3. Insert some records to each table
*/

--insert data for tbStudent
insert tbStudent values 
('S01', 'Tom Hanks', 18, 1),
('S02', 'Phil Collins' ,18, 1),
('S03', 'Jennifer Aniston', 19, 0),
('S04', 'Jane Fonda', 20, 0),
('S05', 'Cristiano Ronaldo', 24, 1);

select * from tbStudent

-- insert data into tbProjects
set dateformat dmy
insert tbProjects values
('P20', 'Social Network', 'GOV' ,'12/01/2020'),
('P21', 'React Navtive + NodeJS', 'EDU', '22/08/2020'),
('P22', 'Google Map API', 'DEP', '15/10/2019'),
('P23', 'nCovid Vaccine', 'GOV', '16/05/2020')

select * from tbProjects
go

-- insert data into tbStudentProject
set dateformat dmy
insert tbStudentProject values
('S01', 'P20', '12/02/2020', 4),
('S01', 'P21', '12/03/2020', 5),
('S02', 'P20', '16/02/2020', 3),
('S02', 'P22', '01/09/2020', 5),
('S04', 'P21', '12/04/2020', 4),
('S04', 'P22', '01/10/2020', 3),
('S04', 'P20', '16/10/2020', 3),
('S03', 'P23', '04/07/2020', 5)

select * from tbStudentProject
go

/*
4. Create a clustered index ‘IX_stname’ for stname column on tbStudents table.
   Create an index ‘IX_pID’ for projectID column on tbStudentProject table
*/
create clustered index ix_stname on tbstudent(stname)
create index ix_pid on tbStudentProject(projectID)
go

/*
5. Create a view ‘vwStudentProject’ to display the list of students joined to projects had start-date before ‘Jun-01-2020’, including following information :
StudentID, Student name, Student Age, Project name, Start date, Join date and Rate.
Note: this view will need to check for domain integrity and encryption.
*/
create view vwStudentProject WITH ENCRYPTION 
as
select sv.stID,sv.stName, sv.stAge, da.pName, da.pStartDate, sv_da.joinedDate, sv_da.rate
	from tbStudentProject sv_da join tbStudent sv  on sv.stID=sv_da.studentID
								join tbProjects da on da.pID =sv_da.projectID
	where da.pStartDate < '2020-06-01'
	WITH CHECK OPTION
go

-- test encryption
sp_helptext vwStudentProject

-- test view
select * from vwStudentProject
go

/*
6. Create a stored procedure ‘upRating’ with an input parameter ‘student-name’, and output parameter ‘avg-rate’

- If ‘student-name’ is null, displays all the projects that all students have workedfor.
  Otherwise, displays information about that students and the corresponding projects
  they have joined.

- Procedure also returns the average rate mark (avg-mark) that students joined into
projects.

*/
create proc upRating
	@avg_rate numeric(5,2) output , @student_name varchar(50) = null
as
begin
	if @student_name is null
	begin
		select sv.stID,sv.stName, sv.stAge, da.pName, da.pStartDate,
			   sv_da.joinedDate, sv_da.rate
			from tbStudentProject sv_da join tbStudent sv  on sv.stID=sv_da.studentID
							        join tbProjects da on da.pID =sv_da.projectID
									
		select @avg_rate= AVG(rate) from tbStudentProject		 
	end
	else
	begin
		select sv.stID,sv.stName, sv.stAge, da.pName, da.pStartDate,
			   sv_da.joinedDate, sv_da.rate
			from tbStudentProject sv_da join tbStudent sv  on sv.stID=sv_da.studentID
							        join tbProjects da on da.pID =sv_da.projectID
			where stName Like '%'+@student_name+'%'
			
		select @avg_rate= AVG(rate)
			from tbStudentProject sv_da join tbStudent sv on 
											sv.stID=sv_da.studentID
						join tbProjects da on da.pID=sv_da.projectID
		where stName Like '%'+@student_name+'%'		 
	end
end
go

-- test case 1:
declare @avg numeric(5,2)
exec upRating @avg output
select @avg [diem binh quan]
go

-- test case 2:
declare @avg numeric(5,2)
exec upRating @avg output, 'Jane'
select @avg [diem binh quan]
go


/*
7. Create trigger ‘tgDeleteStudent’, it will remove all projects that student have worked for whenever a DEL statement triggered on table 'tbStudents'.
*/

create trigger tgDeleteStudent on tbstudent
instead of delete as
begin
	delete from tbStudentProject where studentID in (select stID from deleted)
	delete from tbStudent where stID in (select stID from deleted)
end




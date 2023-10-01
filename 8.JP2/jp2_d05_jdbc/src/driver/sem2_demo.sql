--0. tao database
create database sem2_demo
go

--1. open database
use sem2_demo
go

--2.tao bang user
create table tbUser
(
	userid varchar(10) primary key,
	pass varchar(20),
	[role] tinyint
)

--3.tao bang lop hoc
create table tbBatch
(
	batchno varchar(4) primary key,
	[description] varchar(20),
	fee int
)

--4. tao bang Sinh Vien
create table tbStudent
(
	st_id varchar(4) not null primary key nonclustered,
	lastname VARCHAR(20), 
	firstname varchar(10) not null,
	gender bit default 0,
	phone int,
	batchno varchar(4) references tbBatch(Batchno)
) 
go

--5. tao bang mon hoc
create table tbCourse
(
	course_id VARCHAR(4) not null PRIMARY KEY,
	course_name VARCHAR(30) 
)


--6. tao bang diem
create table tbExam
(
	exam_id INT IDENTITY PRIMARY KEY,
	st_id varchar(4) foreign key references tbStudent(st_id),
	course_id varchar(4) foreign key references tbCourse(course_id),
	finalmark int check(finalmark BETWEEN 0 and 100) 
)


--7. Nap du lieu vo bang lop hoc
insert tbBatch VALUES 
	('0908','ACCP 2007',900),
	('0903','ACCP 2005',800),
	('0909','ACCP 2010',1100),
	('0910','ACCP 2010',1200)


--8. Nap du lieu vo bang sinh vien
insert tbStudent VALUES
('ST01','Nguyen Phuong','Thao',0,113,'0908'),
('ST02','Nguyen Hoang','Nhat',1,118,'0903'),
('ST03','Ly Ngoc','Minh',1,119,'0908'),
('ST04','Nguyen Ngoc','Mai',0,117,'0908'),
('ST05','Tran Minh','Truong',1,399,'0909'),
('ST06','Bui Minh','Hung',1,911,'0909'),
('ST07','Tran Tuan','Anh',1,113,'0908')

--9. Nap du lieu vo bang mon hoc
INSERT tbCourse
VALUES
('JP1', 'Java Programming 1'),
('JP2', 'Java Programming 2'),	
('AJP1', 'Advance Java Programming 1'),
('AJP2', 'Advance Java Programming 2'),
('PCS', 'Programming CSharp'),
('XML', 'XML Simplify')


--10. Nap du lieu vo bang diem
insert tbExam VALUES
('ST04','PCS',70),
('ST04','XML',80),
('ST01','PCS',77),
('ST01','XML',67),
('ST02','PCS',90),
('ST03','XML',80),
('ST03','JP1',60),
('ST05','JP1',90),
('ST05','PCS',40),
('ST06','JP2',60),
('ST07','XML',90),
('ST07','JP2',100),
('ST07','JP1',100)


--11. Nap du lieu vo bang user
insert tbUser values('admin','admin',1)
insert tbUser values('user','user',2)
insert tbUser values('aptech','123',2)

--12.Xem lai du lieu
select * from tbBatch
select * from tbStudent
SELECT * FROM tbCourse 
SELECT * FROM tbExam 
select * from tbUser
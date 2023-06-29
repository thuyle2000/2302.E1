-- open csdl [db2302_e1]
use db2302_e1
go

/* tao bang khoa hoc [tbCourse], bao gom cac cot:
 - course_id, so thu tu tang tu dong, bat dau tu 1,2,3...  PK
 - course_name varchar(30), duy nhat
 - fee, so nguyen > 0 va < 4000
 - duration, so nguyen >0 va <60
*/
CREATE TABLE [tbCourse] (
	course_id int identity(1,1) PRIMARY KEY,
	course_name varchar(30) NOT NULL UNIQUE,
	fee int CHECK (fee>0 AND fee<4000),
	duration int CHECK(duration>0 AND duration<60),
)
GO

/*
bo sung them cot active (true - default/false) cho bang [tbCourse]
*/
ALTER TABLE [tbCourse]
	ADD active bit NOT NULL DEFAULT 1
GO

-- xem so lieu cua bang khoa hoc
SELECT * FROM tbCourse
go

-- them 1 so khoa hoc vo bang [tbCourse]
INSERT tbCourse(course_name) VALUES ('ACCP 2000')
SELECT * FROM tbCourse
go

INSERT tbCourse VALUES 
('ACCP 2012', 2000, 24, 1),
('ACCP 6723', 3000, 36, 0),
('ACCP 7023', 3200, 40, 1)
SELECT * FROM tbCourse
go


/*
tao bang lop hoc [tbBatch], bao gom cac cot
	batch_no,  varchar(10) PK
	start_date, date
	fee, so nguyen, mac dinh 2000
	khoa_hoc, so nguyen, khoa ngoai -> tbCourse.course_id
*/
CREATE TABLE tbBatch(
	batch_no varchar(10) NOT NULL,
	[start_date] date,
	fee int NOT NULL DEFAULT 2000,
	course int 
	CONSTRAINT FK_course FOREIGN KEY REFERENCES tbCourse(course_id)
	CONSTRAINT PK_batch PRIMARY KEY (batch_no)
)
GO

-- them so lieu cho bang lop hoc
select * from tbCourse
INSERT tbBatch VALUES
('2302.E1','2023-02-25', 2100, 4),
('2302.M0','2023-02-12', 2100, 4),
('2303.M1','2023-03-30', default, 3)

select * from tbBatch
go


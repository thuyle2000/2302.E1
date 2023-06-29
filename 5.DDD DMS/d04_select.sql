--open db [db2302_e1]
use db2302_e1
go

/* select without FROM  */
select LEFT('FPT Aptech HCMC',3 ) [company name]
select RIGHT('FPT Aptech HCMC',4) [city]
select SUBSTRING('FPT Aptech HCMC',5,6) [center name]
GO

DECLARE @school VARCHAR(30) = 'FPT Aptech HCMC';
select LEFT(@school,3 ) [company name]
select RIGHT(@school,4) [city]
select SUBSTRING(@school,5,6) [center name]
GO

SELECT DATEADD(D, 15, GETDATE()) [next 15-days]
SELECT DATEDIFF(YY, '1998-07-10', GETDATE()) [Tuoi cua em]
GO


/* select with expressions */
-- xem ds sinh vien
select * from tbStudent

select student_id, student_name,
		  case 
			when gender=1 then 'Male'
			when gender=0 then 'Female'
			else 'Unknown'
		  end 'gender'
	from tbStudent

 select student_id, student_name, gender, dob, DATEDIFF(YY, dob, GETDATE())[age] 
	from tbStudent
GO

/* rename resultset column name */
-- xem ds sinh vien
 select student_id, student_name, 
	case when gender = 1 then 'Male'
		 when gender=0 then 'Female'
		 else 'unknown' 
	end [gender],
	dob, DATEDIFF(YY, dob, GETDATE())[age] 
	from tbStudent


 select student_id N'mã số', student_name N'Họ tên', 
		case when gender = 1 then 'nam'
			 when gender=0 then N'nữ'
			 else 'ko xac dinh' 
		end	N'Giới tính', 
		dob N'Ngày sinh', DATEDIFF(YY, dob, GETDATE()) N'Tuổi' 
	from tbStudent
Go

/* select with DISTINCT */
-- liet ke ds cac truong nhom
select * from tbStudent
select mentor_id from tbStudent WHERE mentor_id is not NULL
select DISTINCT mentor_id from tbStudent WHERE mentor_id is not NULL

-- liet ke cac mon hoc da to chuc thi
select * from tbExam
select md_id from tbExam
select DISTINCT md_id from tbExam
GO

/* select TOP [WITH TIES]*/
-- tim 3 bai thi co so diem cao nhat
select * from tbExam order by mark DESC

select TOP 3 * 
	from tbExam order by mark DESC

select TOP 3 WITH TIES * 
	from tbExam order by mark DESC


/* select INTO */
-- luu ds top 3 bai thi co diem cao nhat vo bang Top3Exam
select TOP 3 WITH TIES * INTO [Top3Exam]
	from tbExam order by mark DESC
select * from Top3Exam
GO


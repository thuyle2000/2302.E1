use db2302_e1
go

/* 1. Tao 1 stored procedure [up_exam_c], thuc hien cac viec sau :
	- liet ke ket qua thi mon c
	- dem so bai thi pass
	- dem so bai thi fail
*/
create proc up_exam_c as
begin
	-- liet ke ket qua thi mon c
	select * from tbExam where md_id LIKE 'LBEP' order by st_id, mark DESC

	-- dem so bai thi pass
	select count(*) [so bai thi pass] from tbExam where md_id LIKE 'LBEP' and mark >=40

	-- dem so bai thi fail
	select count(*) [so bai thi fail] from tbExam where md_id LIKE 'LBEP' and mark <40
end
go

-- test case
exec up_exam_c
go


/* 2. Tao 1 stored procedure [up_exam], thuc hien cac viec sau :
	- liet ke ket qua thi bat ky (ten mon thi/ ma mon thi la tham so input )
	- dem so bai thi pass
	- dem so bai thi fail
*/
create proc up_exam
	@maMonThi varchar(5) = '%'
as
begin
	-- liet ke ket qua thi cua mon hoc
	select * from tbExam 
		where md_id LIKE @maMonThi 
		order by md_id, st_id, mark DESC

	-- dem so bai thi pass
	select count(*) [so bai thi pass] from tbExam 
					where md_id LIKE @maMonThi and mark >=40

	-- dem so bai thi fail
	select count(*) [so bai thi fail] from tbExam 
					where md_id LIKE @maMonThi and mark <40
end
go

/* test case */
--1. thu cho mon LBEP
exec up_exam 'LBEP'
go

--2. thu cho mon AJS
exec up_exam 'AJS'
go

--3. thu cho tat ca cac mon
exec up_exam 
go
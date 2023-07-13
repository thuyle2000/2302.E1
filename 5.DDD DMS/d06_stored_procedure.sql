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



/* 3. Tao 1 stored procedure [up_student], thuc hien cac viec sau :
	- liet ke ds dv theo nam sinh (dua vao tham so input @yob)
	- dem so sv nu -> tra ve cho ct goi  (tham so output @cnt_boy)
	- dem so sv nam -> tra ve cho ct goi (tham so output @cnt_girl)
*/
create proc up_student
	@yob int = null,
	@cnt_boy int output,
	@cnt_girl int output
as
begin
	
	if @yob is null
		begin
			--1. liet ke ds sv
			select * from tbStudent order by dob
			--2. dem so luong nam sinh
			select @cnt_boy=count(*) from tbStudent where gender=1
			--3. dem so luong nu sinh
			select @cnt_girl=count(*) from tbStudent where gender=0
		end
	else
		begin
			--1. liet ke ds sv
			select * from tbStudent where YEAR(dob) = @yob
			--2. dem so luong nam sinh
			select @cnt_boy=count(*) from tbStudent where YEAR(dob) = @yob and gender=1
			--3. dem so luong nu sinh
			select @cnt_girl=count(*) from tbStudent where YEAR(dob) = @yob and gender=0
		end
end
go

/* test case */
--1. liet ke ds sinh vien sinh nam 2000
declare @c1 int, @c2 int
exec up_student 2000, @c1 output, @c2 output
select @c1 [# nam sinh], @c2 [# nu sinh]
go
 
--2. liet ke ds sinh vien sinh nam 2001
declare @boy int, @girl int
exec up_student 2001, @boy output, @girl output
select @boy [# nam sinh], @girl [# nu sinh]
go

--3a. liet ke ds sinh vien 
declare @boy int, @girl int
exec up_student default, @boy output, @girl output
select @boy [# nam sinh], @girl [# nu sinh]
go

--3b. liet ke ds sinh vien 
declare @boy int, @girl int
exec up_student null, @boy output, @girl output
select @boy [# nam sinh], @girl [# nu sinh]
go




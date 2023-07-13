--open csdl [db2302_e1]
use db2302_e1
go

-- xem ds sv
select * from tbStudent
go

--1. tao 1 view chua ds nam sinh vien
create view vwShoolBoy as
	select * from tbStudent where gender = 1
go

-- test case: xem ds nam sinh tu view vwShoolBoy
select * from vwShoolBoy

select student_id, student_name, dob, phone from vwShoolBoy

select student_id, student_name, dob, phone from vwShoolBoy
	where YEAR(dob)>=2002

select student_id, student_name, dob, phone from vwShoolBoy
	where YEAR(dob)>=2002
	order by YEAR(dob) DESC

select student_id, student_name, dob, DATEDIFF(YY, dob, GETDATE()) [age], phone 
	from vwShoolBoy
	where YEAR(dob)>=2002
	order by YEAR(dob) DESC
go

-- sua ten cua sv co ma so [S15]
update tbStudent set student_name= N'Nguyễn Quốc Hoàng' where student_id Like 'S15'
go


--2. Tao view chua ket qua thi, bao gom cac cot: ma so bai thi, ms + ho ten + phone cua sv, ms va ten mon thi, diem kq 
select diem.id, sv.student_id, sv.student_name, sv.phone, 
	   mh.module_id, mh.module_name, diem.mark
	from tbExam [diem] join tbStudent [sv] on diem.st_id=sv.student_id
				       join tbModule [mh] on diem.md_id= mh.module_id


select diem.id, sv.student_id, sv.student_name, coalesce(sv.phone,' - - - ') [phone], 
	   mh.module_id, mh.module_name, diem.mark
	from tbExam [diem] join tbStudent [sv] on diem.st_id=sv.student_id
				       join tbModule [mh] on diem.md_id= mh.module_id
go

create view vwExam as
select diem.id, sv.student_id, sv.student_name, coalesce(sv.phone,' - - - ') [phone], 
	   mh.module_id, mh.module_name, diem.mark
	from tbExam [diem] join tbStudent [sv] on diem.st_id=sv.student_id
				       join tbModule [mh] on diem.md_id= mh.module_id
go

/*** test case ***/
-- xem bang diem 
select * from vwExam

-- xem bang diem cua mon hoc co ten logic building ...
select * from vwExam where module_name like 'logic building%'

select id [ma bai thi], student_id [ma sv], student_name [ho ten], phone [so dt], mark [diem]
	from vwExam 
	where module_name like 'logic building%'

select id, student_id, student_name, phone, mark 
	from vwExam 
	where module_name like 'logic building%'

select id [ma bai thi], student_id [ma sv], student_name [ho ten], phone [so dt], mark [diem]
	from vwExam 
	where module_name like 'logic building%'
	order by diem DESC
go

-- xem bang diem cua sv co ten la Mai
select * from vwExam where student_name LIKE '% mai'

select * from vwExam 
	where student_name LIKE '% mai'
	order by module_id, mark DESC
go


--3.  them 1 nam sinh vien vo view [vwShoolBoy]
select * from vwShoolBoy
insert vwShoolBoy (student_id, student_name, dob, mentor_id) VALUES
				  ('S30', N'Trần văn A', '2002-09-20', 'S05')
select * from vwShoolBoy
go

--4. thay doi so dt cua sv co ms [S17] trong view [vwShoolBoy]
update vwShoolBoy set phone = '9999' where student_id = 'S17'
select * from vwShoolBoy
go

--5. xoa nam sinh co ma so [S30]
delete from vwShoolBoy where student_id = 'S30'
select * from vwShoolBoy
go

--6. doc dinh nghia view  bang cach chay stored procedure [sp_helptext]
exec sp_helptext vwShoolBoy
go
sp_helptext vwExam
go

--7. them 1 nu sinh vo view nam sinh
select * from vwShoolBoy

-- sai qua sai ve mat logic !!!!
insert vwShoolBoy VALUES ('S31', N'Nguyen Thuy Tien', 0, '2006-12-31', null, 'S20') 

select * from vwShoolBoy
select * from tbStudent
go

--8. modify lai noi dung cua view, bo sung menh de [WITH CHECK OPTION]
ALTER VIEW vwShoolBoy as 
	select * from tbStudent where gender = 1
	WITH CHECK OPTION 
go

/*** test case ***/
-- them 1 nu sinh vo view nam sinh : BAO LOI !!!
insert vwShoolBoy VALUES ('S32', N'Huyen Tran', 0, '2008-12-31', null, 'S20') 

-- them 1 nam sinh vo view nam sinh : OK !
insert vwShoolBoy VALUES ('S32', N'Tran van B', 1, '2008-12-31', null, 'S20') 
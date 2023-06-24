use db2302_e1
go

--xem ds sinh vien
select * from tbStudent

--vi du ve vi tu 'LIKE' : 
-- tim cac sv ho Trần
select * from tbStudent where student_name LIKE N'Trần %'
-- tim cac sv ten Huy
select * from tbStudent where student_name LIKE N'% huy'
go

--vi du ve vi tu 'BETWEEN':
-- tim cac sv sinh tu nam 2000 -> 2004
select * from tbStudent where YEAR(dob)>=2000 AND YEAR(dob)<=2004
select * from tbStudent where YEAR(dob) BETWEEN 2000 AND 2004
go

--vi du ve vi tu 'IN'
--tim cac sv sinh nam 2000, 2002, 2004
select * from tbStudent 
	where YEAR(dob)=2000 OR YEAR(dob)=2002 OR YEAR(dob)=2004

select * from tbStudent 
	where YEAR(dob) IN (2000,2002,2004)
go 

--vi du ve ham CAST()
-- dem so sv sinh nam 2000 va in ket qua ra man hinh
declare @sv2000 INT
select @sv2000=COUNT(*) from tbStudent where YEAR(dob)=2000
print 'Co ' + CAST(@sv2000 AS VARCHAR(5)) + ' sinh vien, sinh nam 2000.'
go

--vi du ve ham CONVERT()
-- dem so sv sinh nam 2000 va in ket qua ra man hinh
declare @sv2000 INT
select @sv2000=COUNT(*) from tbStudent where YEAR(dob)=2000
print 'Co ' + CONVERT(VARCHAR(5), @sv2000) + ' sinh vien, sinh nam 2000.'
go

--vi du ve ham UPPER()
-- in ra ds sv, voi phan ho ten duoc in hoa
select * from tbStudent
select student_id, UPPER(student_name) from tbStudent
select student_id, UPPER(student_name) as 'Full name' from tbStudent
go

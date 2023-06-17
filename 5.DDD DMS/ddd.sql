--open database [db2302_E1]
use db2302_E1
go

-- xem ds sinh vien
select * from tbStudent
go

-- xem ds sinh vien, bao gom cac cot: id, name, dob, phone
select student_id, student_name, dob, phone 
	from tbStudent;
go

-- xem ds sinh vien co nam sinh >=2000
select *					-- danh sach cot trong tap ket qua
	from tbStudent			-- nguon du lieu
	where YEAR(dob)>=2000	-- dieu kien loc du lieu / chon dong
go

-- tim cac ds sinh vien nam, co ho 'Nguyễn'
select *
	from tbStudent
	where gender=1 and student_name LIKE N'nguyễn %'
go

-- dem so sinh vien nam va nu
select gender, COUNT(*)
	from tbStudent
	group by gender			-- chia nhom theo du lieu cua cot gender
go

select gender, COUNT(*) AS [no. students]
	from tbStudent
	group by gender			-- chia nhom theo du lieu cua cot gender
go

select 
	case gender
			when 1 then 'Male'
			when 0 then 'Female'
			else 'Unknown'
	end,
	COUNT(*) AS [no. students]
	from tbStudent
	group by gender	
go

select 
	case gender
			when 1 then 'Male'
			when 0 then 'Female'
			else 'Unknown'
	end as [gender],
	COUNT(*) AS [no. students]
	from tbStudent
	group by gender	
go

-- dem sinh vien theo nam sinh
select YEAR(dob) [yob], COUNT(*) [no. students]
	from tbStudent
	group by YEAR(dob)
go

-- dem sinh vien theo nam sinh, chi chon cac nhom so luong sv >=3
select YEAR(dob) [yob], COUNT(*) [no. students]
	from tbStudent
	group by YEAR(dob)
	having COUNT(*) >=3
go


-- in ds sinh vien
select * from tbStudent

-- in ds sinh vien, sap xep theo thu tu cot ngay sinh
select * from tbStudent order by dob
go

-- in ds sinh vien, sap xep theo thu tu giam dan cot ngay sinh
select * from tbStudent order by dob desc
go

-- dem sv theo gioi tinh va tinh do tuoi lon nhat, nho nhất trong tunng nhom
select gender, MIN(YEAR(dob)) [old], MAX(YEAR(dob))[youth]
	from tbStudent
	group by gender
go


-- tim tat ca cac sinh vien nho tuoi nhat
select * from tbStudent 
	where year(dob)=(select max(year(dob)) from tbStudent)


-- xem ds sinh vien
select * from tbStudent
-- xem ds cac mon hoc
select * from tbModule

-- xem ket qua thi
select * from tbExam
go

-- nhap diem thi (1 dong)
insert tbExam (st_id, md_id, mark) values ('S01', 'LBEP', 80);
select * from tbExam
go

-- nhap diem thi mon LBEP (nhieu dong)
insert tbExam (st_id, md_id, mark) values 
('S01', 'LBEP', 40),
('S02', 'LBEP', 34),
('S02', 'LBEP', 70),
('S02', 'LBEP', 43),
('S20', 'LBEP', 100),
('S20', 'LBEP', 60),
('S21', 'LBEP', 98),
('S21', 'LBEP', 36),
('S21', 'LBEP', 63),
('S11', 'LBEP', 58),
('S11', 'LBEP', 30),
('S11', 'LBEP', 86),
('S11', 'LBEP', 90)
select * from tbExam
go

-- nhap diem thi mon HCJS (nhieu dong)
insert tbExam (st_id, md_id, mark) values 
('S01', 'HCJS', 70),
('S01', 'HCJS', 50),
('S02', 'HCJS', 26),
('S02', 'HCJS', 50),
('S02', 'HCJS', 80),
('S02', 'HCJS', 85),
('S10', 'HCJS', 100),
('S10', 'HCJS', 90),
('S13', 'HCJS', 48),
('S13', 'HCJS', 36),
('S13', 'HCJS', 50),
('S11', 'HCJS', 58),
('S11', 'HCJS', 25),
('S11', 'HCJS', 68),
('S11', 'HCJS', 52),
('S14', 'HCJS', 88),
('S14', 'HCJS', 50)
select * from tbExam
go

-- nhap diem thi mon AJS (nhieu dong)
insert tbExam (st_id, md_id, mark) values 
('S01', 'AJS', 90),
('S01', 'AJS', 80),
('S02', 'AJS', 80),
('S02', 'AJS', 50),
('S02', 'AJS', 100),
('S15', 'AJS', 55),
('S15', 'AJS', 25),
('S15', 'AJS', 65),
('S06', 'AJS', 100),
('S06', 'AJS', 90),
('S03', 'AJS', 48),
('S03', 'AJS', 36),
('S03', 'AJS', 80),
('S11', 'AJS', 58),
('S11', 'AJS', 25),
('S11', 'AJS', 78),
('S11', 'AJS', 52),
('S16', 'AJS', 88),
('S16', 'AJS', 37),
('S16', 'AJS', 57),
('S18', 'AJS', 38),
('S18', 'AJS', 37),
('S18', 'AJS', 78),
('S18', 'AJS', 77);
select * from tbExam
go

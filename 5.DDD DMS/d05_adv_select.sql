--open database
use db2302_e1
go


/* select group by with cube */ 
select id, st_id md_id from tbexam
select st_id, count(*) from tbexam
	group by st_id order by 2

select st_id, md_id ,count(*) [so luot thi] from tbexam
	group by st_id, md_id
	with cube 
	
select st_id, md_id ,count(*) [so luot thi] from tbexam
	group by st_id, md_id
	with rollup


/* select with aggregate functions */
-- dem so bai thi, tinh diem binh quan, diem cao nhat, thap nhat cua tung sinh vien
select st_id, COUNT(*) [so luot thi], AVG(mark) [diem BQ], MAX(mark) [diem cao nhat], 
			  MIN(mark) [diem thap nhat]
 from tbExam 
 group by st_id



 /* subquery */
 -- tim danh sach cac sv chua thi mon hoc nao het
 select * from tbStudent where student_id not in (select DISTINCT st_id from tbExam)

 /* inner join */
 -- xem ds sinh vien thi mon LBEP
 select * from tbStudent
 select * from tbExam WHERE md_id LIKE 'LBEP'

 select id, student_id, student_name, dob, mark
	from tbStudent [sv] JOIN tbExam [thi] ON sv.student_id=thi.st_id
	where thi.md_id LIKE 'LBEP'

 select DISTINCT student_id, student_name, dob
	from tbStudent [sv] JOIN tbExam [thi] ON sv.student_id=thi.st_id
	where thi.md_id LIKE 'LBEP'

/* outer join : left join */
-- tim ds sinh vien chua thi mon LBEP
select sv.student_id, sv.student_name, thi.mark 
	from tbStudent [sv] LEFT JOIN ( select * from tbExam where md_id LIKE 'LBEP') [thi]
						ON sv.student_id=thi.st_id

-- lenh truy van se la :
select sv.student_id, sv.student_name 
	from tbStudent [sv] LEFT JOIN ( select * from tbExam where md_id LIKE 'LBEP') [thi]
						ON sv.student_id=thi.st_id
	where mark is NULL

/* inner join */
-- in ds sinh vien: id, ho ten, ngay sinh, leader id va ho ten
select sv.student_id, sv.student_name, sv.dob, sv.mentor_id, tn.student_name [mentor_name]
	from tbStudent [sv] LEFT JOIN tbStudent [tn] ON sv.mentor_id = tn.student_id

select sv.student_id, sv.student_name, sv.dob, 
	ISNULL(sv.mentor_id,'---') [mentorID], ISNULL(tn.student_name,'---') [mentor_name]
	from tbStudent [sv] LEFT JOIN tbStudent [tn] ON sv.mentor_id = tn.student_id

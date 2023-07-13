--open database
use db2302_e1
go




/*1.  tao after trigger ko cho phep cac sv thi 1 mon hoc qua 4 lan */
create trigger tg_exam on tbexam
for insert, update
as
begin	
	
	--lay ma so sv va ma so mon hoc cua bai thi moi nhap diem
	declare @sv varchar(5), @mh varchar(5)
	select @sv= st_id, @mh=md_id from inserted

	--dem so bai thi cua mon hoc cua sv moi dc nhap diem
	declare @tsbaithi int
	select  @tsbaithi=COUNT(*) from tbExam where st_id = @sv and md_id = @mh

	-- kiem tra
	if @tsbaithi > 4
	begin
		print 'LOI : Tong so bai thi cua mon hoc ' + @mh + ' vuot qua 4 lan !'
		rollback	-- tu choi thao tac INSERT/UPDATE 
	end
end
go

/* test case */
select * from tbExam order by st_id, md_id
go
--1. them ket qua bai thi mon [HCJS] cho sv [S02] : hien tai da co 4 ket qua => tb LOI !
insert tbExam values ('S02','HCJS', 100)
go

--2. them ket qua bai thi mon [AJS] cho sv [S02] : hien tai da co 3 ket qua => OK !
insert tbExam values ('S02','AJS', 90)
go

--3. thay doi ten mon thi cua bai thi co ma so [57] -> [HCJS] => LOI !!!
update tbExam set md_id='HCJS' where id = 57
go


--4. them ket qua cua nhieu bai thi
select * from tbExam order by st_id, md_id
go

insert tbExam values
('S01','AJS',100),
('S01','AJS',90),
('S01','AJS',80),
('S02','AJS',80)
go

/*2. Tao trigger ko cho phep thay doi diem thi */
create trigger up_exam_mark on tbExam
for update
as
	if update(mark)
	begin
		print 'LOI: ko duoc phep thay doi diem ket qua thi !'
		rollback --tu choi thao tac
	end
go

/* test case */
select * from tbExam order by st_id

--1. doi ma so mon hoc cua bai thi so [1] -> 'HCJS' : OK
update tbExam set md_id='HCJS' where id= 1

--2. doi ket qua cua bai thi so [1] -> 100 : LOI !
update tbExam set mark=100 where id= 1
go

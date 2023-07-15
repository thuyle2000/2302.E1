use db2302_e1
go
-- tao non-clustered index tren cot ten cua bang sinh vien
create index ixStudentName on tbStudent(student_name DESC) 
go

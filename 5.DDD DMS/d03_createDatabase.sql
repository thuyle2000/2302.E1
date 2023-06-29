-- tao csdl [dbDemo1] voi cac tham so he thong mac dinh
CREATE  DATABASE [dbDemo1]
go

/* tao csdl [dbDemo2] voi cac tham so:
	- tap tin data: 
	  logical name: dbDemo2, filegroup: primary,size:10M, filegrowth: 10%, maxsize:unlimited, path: F:\data, filename: dbDemo2.mdf
	- tap tin log: 
	  logical name: dbDemo2_log, size:10M, filegrowth: 10M, maxsize:64M, path: F:\data, filename: dbDemo2_log.ldf     
*/
CREATE DATABASE [dbDemo2]
ON PRIMARY
(name='dbDemo2', filename='F:\data\dbDemo2.MDF',size=10, filegrowth=10%, maxsize=unlimited )
LOG ON
(name='dbDemo2_log', filename='F:\data\dbDemo2_LOG.LDF',size=10, filegrowth=10, maxsize=64)
go


/* tao csdl [dbDemo3], co filegroup, voi cac tham so:
	- tap tin data 1: 
	  logical name: dbDemo3, filegroup: primary,size:10M, filegrowth: 10%, maxsize:unlimited, path: F:\data, filename: dbDemo3.mdf
	- tap tin data 2: 
	  logical name: dbDemo3b, filegroup: second, path: F:\data, filename: dbDemo3b.ndf

	- tap tin log: 
	  logical name: dbDemo3_log, size:10M, filegrowth: 10M, maxsize:64M, path: F:\data, filename: dbDemo3_log.ldf     
*/

CREATE DATABASE [dbDemo3]
ON PRIMARY
(name='dbDemo3', filename='F:\data\dbDemo3.MDF',size=10, filegrowth=10%, maxsize=unlimited ),
FILEGROUP SECOND
(name='dbDemo3b', filename='F:\data\dbDemo3b.NDF'),
(name='dbDemo3c', filename='F:\data\dbDemo3c.NDF')
LOG ON
(name='dbDemo3_log', filename='F:\data\dbDemo3_LOG.LDF',size=10, filegrowth=10, maxsize=64)
go

-- xoa CSDL [dbDemo2]
DROP DATABASE [dbDemo2]
GO

-- xoa CSDL [dbDemo3]
DROP DATABASE [dbDemo3]
GO

-- tao csdl anh cua [db2302_e1]
CREATE DATABASE dbSnapshot_2302_e1
ON
(
    NAME = db2302_e1	--logical name of source_database
    , FILENAME = 'F:\data\dbss_2302_e1.ss'
) 
AS SNAPSHOT OF db2302_e1 --source_database_name
GO

-- open csdl  [dbSnapshot_2302_e1]
use dbSnapshot_2302_e1
go

-- xem ds sinh vien
select * from tbStudent

-- doi so phone cua sv co ma so [s03] tu 118->811 : LOI !!!
update tbStudent
	set phone=811 where student_id LIKE 'S03'
go

use master
go

drop database dbSnapshot_2302_e1
go


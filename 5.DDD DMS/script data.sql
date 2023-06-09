USE [master]
GO
/****** Object:  Database [db2302_e1]    Script Date: 7/1/2023 7:25:56 PM ******/
CREATE DATABASE [db2302_e1]
GO

USE [db2302_e1]
GO


CREATE TABLE [dbo].[tbBatch](
	[batch_no] [varchar](10) NOT NULL,
	[start_date] [date] NULL,
	[fee] [int] NOT NULL,
	[course] [int] NULL,
 CONSTRAINT [PK_batch] PRIMARY KEY CLUSTERED ([batch_no] ASC)
 )
GO


CREATE TABLE [dbo].[tbCourse](
	[course_id] [int] IDENTITY(1,1) NOT NULL,
	[course_name] [varchar](30) NOT NULL,
	[fee] [int] NULL,
	[duration] [int] NULL,
	[active] [bit] NOT NULL,
PRIMARY KEY CLUSTERED (	[course_id] ASC )
) 
GO

CREATE TABLE [dbo].[tbExam](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[st_id] [varchar](5) NOT NULL,
	[md_id] [varchar](5) NOT NULL,
	[mark] [tinyint] NOT NULL,
 CONSTRAINT [PK_tbExam] PRIMARY KEY CLUSTERED ([id] ASC)
) 
GO

CREATE TABLE [dbo].[tbModule](
	[module_id] [varchar](5) NOT NULL,
	[module_name] [varchar](40) NOT NULL,
	[hours] [tinyint] NOT NULL,
	[fee] [int] NULL,
 CONSTRAINT [PK_tbModule] PRIMARY KEY CLUSTERED ([module_id] ASC )
) 
GO


CREATE TABLE [dbo].[tbStudent](
	[student_id] [varchar](5) NOT NULL,
	[student_name] [nvarchar](40) NOT NULL,
	[gender] [bit] NOT NULL,
	[dob] [date] NULL,
	[phone] [varchar](20) NULL,
	[mentor_id] [varchar](5) NULL,
 CONSTRAINT [PK_tbStudent] PRIMARY KEY CLUSTERED ([student_id] ASC)
) 
GO


INSERT [dbo].[tbBatch] ([batch_no], [start_date], [fee], [course]) 
	VALUES (N'2302.E1', CAST(N'2023-02-25' AS Date), 2100, 4)
GO
INSERT [dbo].[tbBatch] ([batch_no], [start_date], [fee], [course]) VALUES 
(N'2302.M0', CAST(N'2023-02-12' AS Date), 2100, 4),
(N'2303.M1', CAST(N'2023-03-30' AS Date), 2000, 3)
GO

SET IDENTITY_INSERT [dbo].[tbCourse] ON 
GO
INSERT [dbo].[tbCourse] ([course_id], [course_name], [fee], [duration], [active]) VALUES 
(1, N'ACCP 2000', NULL, NULL, 1),
(2, N'ACCP 2012', 2000, 24, 1),
(3, N'ACCP 6723', 3000, 36, 0),
(4, N'ACCP 7023', 3200, 40, 1)
GO
SET IDENTITY_INSERT [dbo].[tbCourse] OFF
GO

SET IDENTITY_INSERT [dbo].[tbExam] ON 
GO
INSERT [dbo].[tbExam] ([id], [st_id], [md_id], [mark]) VALUES 
(1, N'S01', N'LBEP', 80),
(2, N'S01', N'LBEP', 40),
(3, N'S02', N'LBEP', 34),
(4, N'S02', N'LBEP', 70),
(5, N'S02', N'LBEP', 43),
(6, N'S20', N'LBEP', 100),
(7, N'S20', N'LBEP', 60),
(8, N'S21', N'LBEP', 98),
(9, N'S21', N'LBEP', 36),
(10, N'S21', N'LBEP', 63),
(11, N'S11', N'LBEP', 58),
(12, N'S11', N'LBEP', 30),
(13, N'S11', N'LBEP', 86),
(14, N'S11', N'LBEP', 90),
(15, N'S01', N'HCJS', 70),
(16, N'S01', N'HCJS', 50),
(17, N'S02', N'HCJS', 26),
(18, N'S02', N'HCJS', 50),
(19, N'S02', N'HCJS', 80),
(20, N'S02', N'HCJS', 85),
(21, N'S10', N'HCJS', 100),
(22, N'S10', N'HCJS', 90),
(23, N'S13', N'HCJS', 48),
(24, N'S13', N'HCJS', 36),
(25, N'S13', N'HCJS', 50),
(26, N'S11', N'HCJS', 58),
(27, N'S11', N'HCJS', 25),
(28, N'S11', N'HCJS', 68),
(29, N'S11', N'HCJS', 52),
(30, N'S14', N'HCJS', 88),
(31, N'S14', N'HCJS', 50),
(32, N'S01', N'AJS', 90),
(33, N'S01', N'AJS', 80),
(34, N'S02', N'AJS', 80),
(35, N'S02', N'AJS', 50),
(36, N'S02', N'AJS', 100),
(37, N'S15', N'AJS', 55),
(38, N'S15', N'AJS', 25),
(39, N'S15', N'AJS', 65),
(40, N'S06', N'AJS', 100),
(41, N'S06', N'AJS', 90),
(42, N'S03', N'AJS', 48),
(43, N'S03', N'AJS', 36),
(44, N'S03', N'AJS', 80),
(45, N'S11', N'AJS', 58),
(46, N'S11', N'AJS', 25),
(47, N'S11', N'AJS', 78),
(48, N'S11', N'AJS', 52),
(49, N'S16', N'AJS', 88),
(50, N'S16', N'AJS', 37),
(51, N'S16', N'AJS', 57),
(52, N'S18', N'AJS', 38),
(53, N'S18', N'AJS', 37),
(54, N'S18', N'AJS', 78),
(55, N'S18', N'AJS', 77)
GO

SET IDENTITY_INSERT [dbo].[tbExam] OFF
GO

INSERT [dbo].[tbModule] ([module_id], [module_name], [hours], [fee]) VALUES 
(N'AJS', N'AngularJS & Angular', 20, 100),
(N'DDD', N'Database Development & Design ', 12, NULL),
(N'DMS', N'Database Management System', 64, 210),
(N'HCJS', N'HTML5 / CSS3 / Javascript', 64, 180),
(N'LBEP', N'Logic Building Elementary Programming', 60, 160),
(N'PRJ-1', N'eProjecr Semester 1', 24, 180)
GO

INSERT [dbo].[tbStudent] VALUES
(N'S01', N'Nghiêm Khả Ân', 0, CAST(N'2006-12-25' AS Date), N'911', N'S03')
(N'S02', N'Huỳnh Yến Phụng', 0, CAST(N'2002-09-09' AS Date), N'113', N'S03')
(N'S03', N'Nguyễn Quốc Dương', 1, CAST(N'2000-01-31' AS Date), N'118', NULL)
(N'S04', N'Nguyễn Thành Nhân', 1, CAST(N'1998-07-21' AS Date), N'1080', N'S05')
(N'S05', N'Phan Minh Giu', 1, CAST(N'1996-08-15' AS Date), N'1088', NULL)
(N'S06', N'Võ Hồng Tấn', 1, CAST(N'1994-02-28' AS Date), N'115', NULL)
(N'S07', N'Hà Nhật Minh', 1, CAST(N'1995-03-22' AS Date), N'116611', N'S06')
(N'S08', N'Phạm Đào Phú Quý', 1, CAST(N'2002-04-30' AS Date), N'12345', N'S06')
(N'S10', N'Ngô Đình Tân', 1, CAST(N'2005-10-10' AS Date), N'3456', NULL)
(N'S11', N'Nguyễn thị Ngọc Mai', 0, CAST(N'2006-06-06' AS Date), NULL, N'S10')
(N'S12', N'Nguyễn Bá Nghi', 1, NULL, NULL, N'S10')
(N'S13', N'Phan Hoàng Khang', 1, CAST(N'2008-01-01' AS Date), NULL, N'S10')
(N'S14', N'Đinh Hoàng Khánh Linh', 0, CAST(N'2000-03-03' AS Date), N'1145', NULL)
(N'S15', N'Nguyễn Quỗ Hoàng', 1, CAST(N'2006-02-28' AS Date), N'34568', N'S14')
(N'S16', N'Trần Bảo Huy', 1, CAST(N'2004-03-10' AS Date), N'6789', N'S14')
(N'S17', N'Trần Quốc Việt', 1, CAST(N'1966-10-10' AS Date), N'67895', NULL)
(N'S18', N'Nguyễn Thế Huy', 1, CAST(N'2008-04-04' AS Date), N'3875', N'S17')
(N'S19', N'Lương Sơn Thịnh', 1, CAST(N'2004-08-08' AS Date), N'888', N'S17')
(N'S20', N'Trần Ngọc Bảo Khoa', 1, CAST(N'2000-02-02' AS Date), N'222', NULL)
(N'S21', N'Phạm Văn Phúc lộc', 1, CAST(N'2001-03-03' AS Date), N'333999', N'S20')
(N'S22', N'Đỗ Quang Nhật', 1, CAST(N'2001-06-06' AS Date), N'666778', N'S20')
(N'S23', N'Trần Thị Huệ', 0, CAST(N'2004-09-09' AS Date), N'999333', N'S24')
(N'S24', N'Phan Quốc Huy', 1, CAST(N'2006-06-06' AS Date), N'789654', N'S24')
(N'S25', N'Trần Quang Khải', 1, CAST(N'2004-04-04' AS Date), N'445566', NULL)


ALTER TABLE [dbo].[tbCourse] ADD UNIQUE NONCLUSTERED 
(
	[course_name] ASC
)

ALTER TABLE [dbo].[tbBatch] ADD  DEFAULT ((2000)) FOR [fee]
GO

ALTER TABLE [dbo].[tbCourse] ADD  DEFAULT ((1)) FOR [active]
GO

ALTER TABLE [dbo].[tbExam] ADD  CONSTRAINT [DF_tbExam_mark]  DEFAULT ((0)) FOR [mark]
GO

ALTER TABLE [dbo].[tbStudent] ADD  CONSTRAINT [DF_tbStudent_gender]  DEFAULT ((1)) FOR [gender]
GO

ALTER TABLE [dbo].[tbBatch] WITH CHECK ADD CONSTRAINT [FK_course] FOREIGN KEY([course])
REFERENCES [dbo].[tbCourse] ([course_id])
GO

ALTER TABLE [dbo].[tbBatch] CHECK CONSTRAINT [FK_course]
GO

ALTER TABLE [dbo].[tbExam]  WITH CHECK ADD CONSTRAINT [FK_tbExam_tbModule] FOREIGN KEY([md_id])
REFERENCES [dbo].[tbModule] ([module_id])
GO

ALTER TABLE [dbo].[tbExam] CHECK CONSTRAINT [FK_tbExam_tbModule]
GO

ALTER TABLE [dbo].[tbExam]  WITH CHECK ADD  CONSTRAINT [FK_tbExam_tbStudent] FOREIGN KEY([st_id])
REFERENCES [dbo].[tbStudent] ([student_id])
GO

ALTER TABLE [dbo].[tbExam] CHECK CONSTRAINT [FK_tbExam_tbStudent]
GO

ALTER TABLE [dbo].[tbCourse]  WITH CHECK ADD CHECK (([duration]>(0) AND [duration]<(60)))
GO

ALTER TABLE [dbo].[tbCourse]  WITH CHECK ADD CHECK (([fee]>(0) AND [fee]<(4000)))
GO


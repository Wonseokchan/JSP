--table name : book

create table book(
	id 				varchar2(10) not null,
	title 			varchar2(100) not null,
	price 			number not null,
	author 			varchar2(100) not null,
	description 	varchar2(1000),
	publisher 		varchar2(100),
	category 		varchar2(30),
	quantity 		number,
	release_date 	date,
	condition 		varchar2(20),
	image_filename 	varchar2(20), 
	constraint book_pk primary key(id)
)

select * from book;

create table Student(
	no number not null,
	depart varchar2(20) not null,
	name varchar2(30) not null,
	address varchar2(50),
	phone varchar2(15),
	constraint student_pk primary key(no)
)


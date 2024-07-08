create table Student(
	no number not null,
	depart varchar2(20) not null,
	name varchar2(30) not null,
	address varchar2(50),
	phone varchar2(15),
	constraint student_pk primary key(no)
)
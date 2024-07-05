create table member (
	id number generated as identity not null,
	title varchar2(1000) NOT NULL,
	content varchar2(4000) NOT NULL,
	writer varchar2(100) NOT NULL,
	register_date DATE DEFAULT sysdate NOT NULL,
	modified_date DATE,
	CONSTRAINT memo_pk PRIMARY key(no)
);

commit;

alter table member 




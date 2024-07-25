create table book_member (
memberId varchar2(50),
memberPw varchar2(100) not null,
memberName varchar2(30) not null,
memberMail varchar2(100) not null,
memberAddr1 varchar2(100) not null,
memberAddr2 varchar2(100) not null,
memberAddr3 varchar2(100) not null,
adminCk number not null,
regDate date not null,
money number not null,
point number not null,
primary key(memberId)
);
commit;

select * from book_member;
select * from vam_author;

update book_member set adminck=1 where memberid='admin';

create table vam_nation(
    nationId VARCHAR2(2) PRIMARY KEY,
    nationName VARCHAR2(50)
);


insert into vam_nation values('01','국내');
insert into vam_nation values('02','국외');

create table vam_author(
authorid number generated as identity (start with 1) primary key,
authorname VARCHAR2(50),
nationid VARCHAR2(2),
authorintro long,
foreign key(nationId) REFERENCES vam_nation(nationId)
);


insert into vam_author(authorname,nationid,authorintro) values('유홍준','01','작가 소개입니다.');
insert into vam_author(authorname,nationid,authorintro) values('김난도','01','작가 소개입니다.');
insert into vam_author(authorname,nationid,authorintro) values('폴크루그먼','02','작가 소개입니다.');

alter table vam_author add regDate date default sysdate;
alter table vam_author add updateDate date default sysdate;


delete from vam_author;
 
    ALTER TABLE vam_author MODIFY(authorId GENERATED AS IDENTITY (START WITH 1));
 
    insert into vam_author(authorName, nationId, authorIntro) values('유홍준', '01', '작가 소개입니다' );
    insert into vam_author(authorName, nationId, authorIntro) values('김난도', '01', '작가 소개입니다' );
    insert into vam_author(authorName, nationId, authorIntro) values('폴크루그먼', '02', '작가 소개입니다' );
 
    select * from USER_INDEXES;
    
    insert into vam_author(authorname, nationid)(select authorname, nationid from vam_author);
    
    commit;

/* 
물리적 설계
1. DB(스키마)를 생성 
2. 테이블(릴레이션)을 생성 
3. 데이터를 추가 

SQL : Structured Query Language
DDL(데이터 정의어) : 테이블/DB를 추가,수정,삭제 
DML(데이터 조작어) : 데이터 추가, 수정, 조회 
DCL(데이터 제어어) : 계정에 사용권한을 부여, 회수 
TCL(트랜잭션 제어어): 작업을 묶어서 DML 결과를 작업단위 별로 묶어서 제어
*/
/* 
DDL
 - create   : 테이블/DB를 생성
 - alter    : 테이블/DB를 수정
 - drop     : 테이블/DB를 삭제 
 - truncate : 테이블를 초기화
*/
/* 
DB 생성 : MYSQL에서는 DB와 스키마가 같은 걸로 인식 
create schema DB명;
create database DB명;
drop schema DB명;
drop database DB명;

if not exists DB명 : DB명이 존재하지 않을 때 작업
if exists DB명 : DB명이 존재할 때 작업 
*/
create schema if not exists course;
-- drop schema if exists course;

/* 
use DB명 : DB명을 선택. 워크벤치에서는 해당 DB를 더블클릭하면 글자가 두껍게 변함 
*/
use course;
/* 
테이블 생성
- auto_increment는 기본키에만 설정할 수 있다. 
- 테이블당 최대 1개만 설정 
- default는 not null인 경우 기본값을 설정할 때 사용 
- check는 데이터가 추가될 때 조건이 맞지 않는 경우 추가되게 하지 않을 때 사용 
create table 테이블명(
	속성명1 타입 [default 값] [not null | null] [auto_incerement],
    속성명2 타입 [default 값] [not null | null], 
    primary key(속성명), -- 기본키 설정
    foreign key(속성명) references 테이블명(속성명) [on updete 제약조건옵션 on delete 제약조건옵션],
    check(조건)
);
제약조건 옵션 : 
 - 참조무결성을 지키기 위해서 참조되는 테이블의 기본키값이 변경되면 참조하는 테이블의 값을 
   어떻게 할건지를 결정하는 값 
RESTRICTED : 참조되고 있는 경우 기본키의 값을 바꾸지 못하게 함 
 - 수강에 등록된 과목들은 과목 코드를 변경할 수 없음 
CASECADE : 참조되고 있으면 기본키의 값이 변하면 참조하는 테이블의 값도 같이 바뀜 
 - 수강에 등록된 과목 코드가 변경되면 수강 테이블의 과목 코드도 변경 
SET NULL : 참조되고 있으면 기본키의 값이 변하면 참조하는 테이블의 값이 NULL로 바뀜 
 - 단, 이경우는 외래키가 NULL 허용인 경우만 가능 
NO ACTION : 제약조건 옵션을 선택하지 않은 경우 자동으로 선택. RESTRICTED와 동일 
SET DEFAULT : 참조되고 있으면 기본키의 값이 변하면 참조하는 테이블의 값이 기본값으로 바뀜 

*/
-- 대학생(학번, 이름, 학과)
create table if not exists course.`student`(
	num char(10) not null,
    name varchar(20) not null,
    major varchar(20) not null,
    primary key(num)
);
-- 과목(과목코드, 과목명, 학점, 시수)
-- 과목코드 앞 3자리는 종류, 뒤 3자리는 숫자 MSC001
create table if not exists subject(
	code char(6) not null,
    title varchar(20) not null,
    point int not null default 0,
    time int not null default 0,
    primary key(code)
);
-- 수강(수강번호, 과목코드(FK), 학번(FK), 강의실, 교수, 시간표, 연도, 학기)
create table if not exists course(
	num int not null auto_increment,
    subject_code char(6) not null,
    student_num char(10) not null,
    room varchar(20) not null default '',
    professor_name varchar(20) not null default '',
    schedule varchar(20) not null default '',
    year int not null,
    semester varchar(10) not null default '1',
    primary key(num),
    foreign key(subject_code) references subject(code),
    foreign key(student_num) references student(num)
);
/*
alter : 테이블을 수정
- 속성 추가
alter table 테이블명 add 속성명 타입;
- 속성 수정
alter table 테이블명 modify 속성명 타입;
- 속성명 수정 
alter table 테이블명 change 기존속성명 새속성명 타입; 
- 속성 삭제
alter table 테이블명 drop 속성명; 
- 제약 조건 추가
alter table 테이블명 add constraint 제약조건명 제약조건내용;
- 제약 조건 삭제
alter table 테이블명 drop 제약조건명; 
*/
-- 학생 테이블에 주소 속성을 추가 
alter table student add address varchar(50) not null default '';
-- 학생 테이블에 주소를 최대 40자로 수정 
alter table student modify address varchar(40) not null default '';
-- 학생 테이블 주소를 address_detail로 수정
alter table student change address address_detail varchar(40) not null default '';
-- 학생 테이블 주소를 삭제 
alter table student drop address_detail;
-- 수강 테이블 기본키에 있는 auto_increment 속성을 제거 
alter table course modify num int not null;
-- 수강 테이블 기본키 제약조건 삭제 
alter table course drop primary key;
-- 수강 테이블 기본키 제약조건 추가(제약조건명 : PK_NUM)
alter table course add constraint PK_NUM primary key(num);
-- 수강 테이블에 student_num의 외래키 제약조건 삭제
alter table course drop constraint course_ibfk_2;
-- 수강 테이블에 student_num의 외래키 제약조건 추가
alter table course add constraint FK_STUDENT_NUM 
	foreign key(student_num) references student(num);



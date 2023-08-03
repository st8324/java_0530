/* 
-- 일반 테이블 생성 
create table 테이블명(
	속성명 타입 .. ,
    속성명 타입 ..
);
-- 기존 테이블을 이용하여 새 테이블 생성 
create table 테이블명(select 테이블에추가할속성들 from 기존테이블명);
*/
create table if not exists course_min(
	select num, subject_code, student_num from course
);
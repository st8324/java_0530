/* 
select문 기본
select 속성명1, ..., 속성명n from 테이블명;
=> 테이블에서 속성명1, ..., 속성명n의 값들을 조회 
=> 전체를 조회하려면 *을 이용 

as : 속성 또는 테이블명을 일시적으로 변경해서 사용할 때 쓰는 키워드 
속성명1 as 속성명2 => 속성명1을 일시적으로 속성명2로 사용 
*/
use course;
-- 등록된 모든 학생의 모든 정보를 조회하는 쿼리 
select * from student;
-- 등록된 모든 학생의 학번을 조회하는 쿼리
select num as '학번' from student;

/*
select 속성명1,..., 속성명n from 테이블명 where 조건식;
=> 조건식을 만족하는 행(튜플)들만 검색해서 해당 행의 속성1,...,속성n의 정보를 조회 
where절
속성명1 = 값1 or 속성명2 = 값2 and 속성명3 = 값3
where절의 사용되는 연산자 
= : 같다. null과 비교가 안됨
!=: 같지 않다. null과 비교가 안됨
<>: 같지 않다. null과 비교가 안됨
and : ~하고, 자바의 &&연산자 
or  : ~하거나, 자바의 ||연산자 
is null : null인지 확인
is not null : null이 아닌지 확인 
like : 와일드카드와 함께 사용되며, 값이 주어진 와이드가 포함된 문자열과 같은지를 비교할 때 사용 
_ : 한글자를 의미하는 와일드 카드
% : 0글자이상을 의미하는 와일드 카드 
*/
-- 컴퓨터공학과 학생들을 조회하는 쿼리 
SELECT 
    *
FROM
    student
WHERE
    major = '컴퓨터공학과';
-- 컴퓨터공학과가 아닌 학생들을 조회하는 쿼리 
select * from student where major <> '컴퓨터공학과';
select * from student where major != '컴퓨터공학과';
-- 학번이 2023135001인 학생이 듣는 수강정보를 조회하는 쿼리 
select * from course where student_num = '2023135001';
-- 학점이 3학점인 과목의 과목명을 조회하는 쿼리 
select title from subject where point = 3;
-- 이름이 3자인 학생 정보를 조회하는 쿼리
select * from student where name like '___';


-- 유재석 학생이 수강하는 수강정보를 조회하는 쿼리 
SELECT 
    *
FROM
    course
WHERE
    student_num IN (SELECT 
            num
        FROM
            student
        WHERE
            name = '유재석');

-- 영어를 수강하는 컴퓨터공학과 학생들의 수강정보를 조회하는 쿼리 
SELECT 
    *
FROM
    course
WHERE
    subject_code = (SELECT 
            code
        FROM
            subject
        WHERE
            title = '영어')
	and student_num in (select num from student where major = '컴퓨터공학과');
-- 수강생이 3명 이상인 과목의 과목코드를 조회하는 쿼리 
SELECT 
    subject_code, COUNT(*) as 수강생수
FROM
    course
GROUP BY subject_code
HAVING COUNT(*) >= 3;

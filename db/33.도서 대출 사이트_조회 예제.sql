-- 예약 가능한 도서를 조회하는 쿼리 
SELECT 
    *
FROM
    BOOK
WHERE
    BO_POSSIBLE_RESERVATION = (SELECT 
            BS_NUM
        FROM
            BOOK_STATE
        WHERE
            BS_DESC = '예약 가능');
-- 대출 가능한 도서를 조회하는 쿼리 
SELECT * FROM BOOK
WHERE
    BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출 가능') 
	AND 
    BO_POSSIBLE_RESERVATION IN(SELECT 
            BS_NUM
        FROM
            BOOK_STATE
        WHERE
            BS_DESC != '예약 중') ;
-- QWE123회원이 대출 가능한 도서를 조회하는 쿼리 
SELECT 
    BOOK.*
FROM
    BOOK
        LEFT JOIN
    RESERVATION ON RE_BO_NUM = BO_NUM
WHERE
    BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출 가능')
    AND
    (RE_NUM IS NULL OR RE_ME_ID = 'QWE123');

-- QWE123회원이 현재 대출한 도서를 조회하는 쿼리 
SELECT 
    *
FROM
    BOOK
        JOIN
    LOAN ON LO_BO_NUM = BO_NUM
WHERE
	LO_ME_ID = 'QWE123' AND LO_RETURN_DATE IS NULL;

-- 각 회원들의 대출이 불가능한 기간을 조회하는 쿼리. 
-- 대출이 가능한 회원은 대출 가능으로 표시하고, 
-- 대출이 불가능한 회원은 언제까지인지를 표시 하도록 작성 
SELECT ME_ID AS 아이디, 
	CASE 
		WHEN ME_APPLY_OVERDUE IS NULL THEN '대출가능' 
        ELSE ME_APPLY_OVERDUE 
	END AS 대출불가일
FROM MEMBER;

-- 각 도서별 대출 회수를 조회하는 쿼리 
SELECT 
    BO_TITLE AS 도서명, COUNT(LO_NUM) AS 대출회수
FROM
    BOOK
        LEFT JOIN
    LOAN ON LO_BO_NUM = BO_NUM
GROUP BY BO_NUM;

-- 회원별 연체 회수를 조회하는 쿼리 
SELECT 
    ME_ID AS 아이디, COUNT(LO_EXPECTED_DATE < LO_RETURN_DATE) AS 연체회수
FROM
	MEMBER 
		LEFT JOIN
	LOAN ON LO_ME_ID = ME_ID
GROUP BY ME_ID;

-- 도서를 가장 많이 대출한 회원을 조회하는 쿼리, 대출수가 같은 경우 아이디순으로 정렬 후 첫번째 회원을 선택 
SELECT 
    ME_ID AS 아이디, COUNT(LO_NUM) AS 대출도서수
FROM
    MEMBER
        LEFT JOIN
    LOAN ON LO_ME_ID = ME_ID
GROUP BY ME_ID
ORDER BY 대출도서수 DESC, 아이디 ASC
LIMIT 1;
-- 도서 상태 샘플 데이터를 추가
INSERT INTO BOOK_STATE(BS_DESC) 
VALUES('예약 가능'),('예약 중'),('도서 상태에 의한 예약 불가능'),
('대출 가능'),('대출 중'),('도서 상태에 의한 대출 불가능');

-- 도서 샘플 데이터를 추가
-- 101.1ABC12 자바의 정석 남궁성 도우출판, 일반도서(대출/예약이 가능한 도서) 
-- 103.987DD Do it! 점프 투 파이썬 박응용 이지스퍼블리싱, 예약 불가능한 도서 
-- 500.ABC123 V1 1 해리포터와 마법사의 돌 1 J.K. 롤링저자/강동혁 엮은이 문학수첩, 일반도서 
INSERT INTO BOOK(BO_NUM,BO_TYPE, BO_TITLE, BO_PUBLISHER, BO_AUTHOR, BO_POSSIBLE_LOAN, BO_POSSIBLE_RESERVATION)
VALUES('101.1ABC12', '코딩' ,'자바의 정석', '도우출판', '저자 : 남궁성', 4, 1),
('103.987DD', '코딩' ,'Do it! 점프 투 파이썬', '이지스퍼블리싱', '저자 : 박응용', 4, 3),
('500.ABC123 V1 1', '외국 소설' ,'해리포터와 마법사의 돌 1', '문학수첩', '저자 : J.K. 롤링/엮은이 강동혁', 4, 1);

-- 회원 샘플 데이터를 추가 
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_BIRTHDAY, ME_AUTHORITY)
	VALUES('ADMIN','ADMIN', '011-1234-5678', '2000-01-01', 'ADMIN'),
    ('QWE123', 'QWE123', '010-1111-2222', '2002-02-02', 'USER');

-- QWE123회원이 자바의 정석을 예약했을때 적용해야하는 쿼리 
INSERT INTO RESERVATION(RE_RESERVATION_DATE, RE_ME_ID, RE_BO_NUM)
	SELECT DATE_FORMAT(NOW(),'%Y-%m-%d'), 'QWE123', BO_NUM FROM BOOK WHERE BO_TITLE = '자바의 정석';

UPDATE BOOK 
SET 
    BO_POSSIBLE_RESERVATION = (SELECT 
            BS_NUM
        FROM
            BOOK_STATE
        WHERE
            BS_DESC = '예약 중')
WHERE
    BO_NUM = '101.1ABC12'; -- UPDATE 하는 테이블이 BOOK인데 BOOK에서 조회해서 값을 가져올 수 없다 

-- QWE123회원이 예약한 자바의 정석을 대출했을 때 적용해야하는 쿼리 
-- 대출 테이블에 데이터 추가 
INSERT INTO LOAN(LO_DATE, LO_ME_ID, LO_BO_NUM, LO_EXPECTED_DATE)
	SELECT DATE_FORMAT(NOW(),'%Y-%m-%d'), 'QWE123', BO_NUM, 
		DATE_FORMAT( DATE_ADD( NOW(), INTERVAL 14 DAY),'%Y-%m-%d')
	FROM BOOK
    WHERE BO_TITLE = '자바의 정석';
-- 예약 테이블에 데이터를 삭제 
DELETE FROM RESERVATION 
WHERE
    RE_ME_ID = 'QWE123'
    AND RE_BO_NUM = (SELECT 
        BO_NUM
    FROM
        BOOK
    WHERE
        BO_TITLE = '자바의 정석');

-- 도서 상태를 수정 
UPDATE BOOK
SET
	BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출 중'),
    BO_POSSIBLE_RESERVATION = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '예약 가능')
WHERE
	BO_NUM = '101.1ABC12';

-- 회원이 대출한 도서 수를 증가 
UPDATE MEMBER
SET
	ME_BOOK_COUNT = ME_BOOK_COUNT + 1
WHERE
	ME_ID = 'QWE123';

-- QWE123회원이 자바의 정석을 반납했을 때 필요한 쿼리 
-- 대출 테이블에 반납일을 수정 
UPDATE LOAN 
SET 
    LO_RETURN_DATE = DATE_FORMAT(NOW(), '%Y-%m-%d')
WHERE
    LO_ME_ID = 'QWE123'
        AND LO_BO_NUM = (SELECT 
            BO_NUM
        FROM
            BOOK
        WHERE
            BO_TITLE = '자바의 정석');
-- 도서 테이블에 해당 도서의 도서 상태를 수정 
UPDATE BOOK
SET
	BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출 가능')
WHERE
	BO_NUM = '101.1ABC12';
-- 회원이 대출한 도서 수를 감소 
UPDATE MEMBER
SET
	ME_BOOK_COUNT = ME_BOOK_COUNT - 1
WHERE
	ME_ID = 'QWE123';
-- 연체일을 계산해서 회원 테이블을 수정 
UPDATE MEMBER 
SET 
    ME_TOTAL_OVERDUE = ME_TOTAL_OVERDUE + (SELECT 
            CASE
				WHEN DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE) < 1 THEN 0
				ELSE DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE)
			END AS 연체일
        FROM
            LOAN
        WHERE
            LO_ME_ID = 'QWE123'
                AND LO_BO_NUM = '101.1ABC12')
WHERE
    ME_ID = 'QWE123';
-- 회원이 대출한 모든 도서가 반납됐을 때 연체일이 있으면 다음날부터 연체 적용이 되도록 수정 
UPDATE MEMBER 
SET 
    ME_APPLY_OVERDUE = (SELECT 
            CASE
                    WHEN
                        ME_BOOK_COUNT = 0
                            AND ME_TOTAL_OVERDUE != 0
                    THEN
                        DATE_FORMAT(DATE_ADD(NOW(),
                                    INTERVAL ME_TOTAL_OVERDUE DAY),
                                '%Y-%m-%d')
                    ELSE NULL
                END AS T
        FROM
            (SELECT * FROM MEMBER) AS TMP
        WHERE
            ME_ID = 'QWE123')
WHERE
    ME_ID = 'QWE123';
    







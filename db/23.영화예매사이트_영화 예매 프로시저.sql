/*
프로시저 
- 일렴의 쿼리를 마치 하나의 함수처럼 실행하기 위한 쿼리의 집합 
- 예시
  - 대학생 학번을 생성하기 위한 프로시저 : 입학년도, 학과번호를 이용하여 학번을 생성할 수 있다 

		함수 	 		프로시저 
매개변수	여러개(입력)	여러개(입력|출력|입출력)
리턴값 	1개, 필수		여러개, 선택(매개변수를 통해 전달) 
SELECT문	사용 가능 		사용 불가능 
처리장소	클라이언트		서버 

프로시저 정의 
DELIMITER // -- 문자의 끝을 //로 인식하게 해줌 
CREATE PROCEDURE 프로시저명( 
[	(IN | OUT | INOUT) 매개변수명 타입 

]
)
BEGIN 
	-- 프로시저 코드 구현 
    -- 변수 선언 
    DECLARE 변수명 타입;
    DELCARE 변수명 타입 DEFAULT 초기값;
    -- 변수에 값을 수정 
    SET 변수명 = 값;
    -- 조건문 : CASE WHEN
    CASE
		WHEN 조건식1 THEN
			실행문1;
        WHEN 조건식2 THEN
			실행문2;
		ELSE
			실행문3;
	END;
    -- 조건문 : IF 
    IF 조건식 THEN
		실행문1
	ELSE 
		실행문2
	END IF;
END //
DELIMITER ;

프로시저 호출 
CALL 프로시저명(매개변수들);
*/
-- 모든 영화 예매율을 업데이트하는 프로시저 
DROP PROCEDURE IF EXISTS UPDATE_RESERVATION_RATE;
DELIMITER //
CREATE PROCEDURE UPDATE_RESERVATION_RATE()
BEGIN 
	DECLARE _TOTAL_SEAT INT;
    DECLARE DONE INT DEFAULT 0;
    DECLARE _MO_NUM INT; 
    DECLARE _MOVIE_SEAT INT;
    
    DECLARE CUR CURSOR FOR
		SELECT MO_NUM FROM MOVIE;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET DONE = 1;
	-- 영화 예매를 이용하여 예매 좌석수별로 예매율을 계산 
    -- => A영화 예매율 : A영화 예매좌석수 /예매중인 전체 예매 좌석수 * 100 
    -- 전체 예매 좌석수 
	SET _TOTAL_SEAT = (
		SELECT 
			SUM(RV_ADULT + RV_TEENAGER) 
		FROM 
			RESERVATION
    );
    SELECT _TOTAL_SEAT;
    OPEN CUR;
    MOVIE_LOOP : LOOP
		FETCH CUR INTO _MO_NUM;
        IF DONE THEN 
			LEAVE MOVIE_LOOP;
		END IF;
        -- 하고싶은 작업 
        -- 현재 선택된 영화의 예매 좌석수를 계산 
        SET _MOVIE_SEAT = (
			SELECT 
				IFNULL(SUM(RV_ADULT + RV_TEENAGER),0)
			FROM
				MOVIE_SCHEDULE 
					JOIN
				RESERVATION ON RV_MS_NUM = MS_NUM
			WHERE
				MS_MO_NUM = _MO_NUM
		);
        SELECT _MOVIE_SEAT;
        -- 예매율 업데이트
        UPDATE MOVIE 
		SET
			MO_RESERVATION_RATE = ROUND(_MOVIE_SEAT / _TOTAL_SEAT * 100)
		WHERE
			MO_NUM = _MO_NUM;
		
    END LOOP;
    CLOSE CUR;
    
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS RESERVATION_MOVIE;
-- 영화를 예매하는 프로시저 
DELIMITER //
CREATE PROCEDURE RESERVATION_MOVIE(
	IN _MS_NUM INT,-- 스케줄 번호 
    IN _ID VARCHAR(15),-- 예약 아이디명 
    IN _ADULT_COUNT INT, -- 성인수 
    IN _TEENAGER_COUNT INT,-- 청소년 수 
    IN _SEAT_LIST TEXT -- 좌석번호를 JSON 형태의 문자열로 
)
BEGIN 
	DECLARE _ADULT_TOTAL_PRICE INT DEFAULT 0;
    DECLARE _TEENAGER_TOTAL_PRICE INT DEFAULT 0;
    DECLARE _TOTAL_PRICE INT DEFAULT 0;
    DECLARE _IS_DISCOUNT CHAR(1);
    
    DECLARE DONE INT DEFAULT 0;
    
    DECLARE _SE_NUM INT;
    DECLARE _PR_NUM INT;
    DECLARE _RV_NUM VARCHAR(20);
    DECLARE SEAT_NAME VARCHAR(4);
    DECLARE _POSSIBLE_SEAT INT;
    /* 
    CURSOR
    - SQL 결과 집합을 가르키는 데이터 타입. 프로시저나 함수내에서 사용 
    - 결과를 반복처리할 때 사용
    - 결과를 한번에 가져오는게 아니라 하나씩 가져와서 처리 
    */
    -- 좌석 리스트를 CURSOR로 선언 
    DECLARE CUR CURSOR FOR 
		SELECT *
        FROM JSON_TABLE(_SEAT_LIST, '$[*]'
			COLUMNS(SEAT_NAME VARCHAR(4) PATH '$.SEAT_NAME')
		) AS A;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET DONE = 1;
    
    -- 예약번호 생성 --202308091614MS008001
    SET _RV_NUM = CONCAT(
		-- NOW() : YYYY-MM-DD HH:MM:SS =>YYYYMMDDHHMM
		DATE_FORMAT(NOW(), '%Y%m%d%H%i'),
        'MS',
        LPAD(_MS_NUM, 3, 0),
        LPAD((SELECT COUNT(*)+1 FROM RESERVATION WHERE RV_MS_NUM = _MS_NUM) , 3, 0)
	);

	-- 전체 요금을 계산 : 
    -- 성인수, 청소년수, 조조할인 여부 알면 => 청소년 총 요금, 성인 총 요금을 계산 
    -- 예약 테이블에 정보를 추가 
    -- 조조할인이 적용되는지 여부를 _IS_DISCOUNT에 저장
    SET _IS_DISCOUNT = (SELECT MS_DISCOUNT FROM MOVIE_SCHEDULE WHERE MS_NUM = _MS_NUM);
    -- 조조할인 여부에 따라 성인 전체요금과 청소년 전체 요금을 계산 
    IF _IS_DISCOUNT = 'Y' THEN 
		SET _ADULT_TOTAL_PRICE = 
        (SELECT PR_DISCOUNT_PRICE FROM PRICE WHERE PR_TYPE='성인')*_ADULT_COUNT;
        SET _TEENAGER_TOTAL_PRICE = 
        (SELECT PR_DISCOUNT_PRICE FROM PRICE WHERE PR_TYPE='청소년')*_TEENAGER_COUNT;
	ELSE
		SET _ADULT_TOTAL_PRICE = 
        (SELECT PR_PRICE FROM PRICE WHERE PR_TYPE='성인')*_ADULT_COUNT;
        SET _TEENAGER_TOTAL_PRICE = 
        (SELECT PR_PRICE FROM PRICE WHERE PR_TYPE='청소년')*_TEENAGER_COUNT;
    END IF;
    -- 전체 요금을 계산 
    SET _TOTAL_PRICE = _ADULT_TOTAL_PRICE + _TEENAGER_TOTAL_PRICE;
	-- 예약 정보를 테이블에 추가 
    INSERT INTO RESERVATION(RV_NUM, RV_MS_NUM, RV_ME_ID, RV_ADULT, RV_TEENAGER, RV_PRICE)
    VALUE(_RV_NUM, _MS_NUM, _ID, _ADULT_COUNT, _TEENAGER_COUNT, _TOTAL_PRICE);
    
    -- 예약 리스트에 좌석 정보를 추가 
    -- CURSOR를 열음 
	OPEN CUR;
    READ_LOOP:LOOP
		FETCH CUR INTO SEAT_NAME;
        -- 반복을 멈추는 작업 
        IF DONE THEN
			LEAVE READ_LOOP;
		END IF;
        -- 좌석정보를 이용하여 예약 리스트에 추가하는 작업 
        -- 영화 스케쥴과 좌석이름을 이용하여 좌석번호를 가져옴 
        SET _SE_NUM = (
			SELECT SE_NUM FROM SEAT
				JOIN SCREEN ON SE_SC_NUM = SC_NUM
				JOIN MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
			WHERE MS_NUM = _MS_NUM AND SE_NAME = SEAT_NAME
		);
        -- 예약좌석에 가격 번호를 연결하는데 있어서, 청소년 먼저하고, 성인을 하는거와 
        -- 성인 먼저하고 청소년을 먼저하는 건 중요하지 않음 
        -- 성인먼저 좌석 순으로 배치를 하고, 이후에 청소년을 좌석순으로 배치
        -- 성인수가 0이 아니면 주어진 좌석은 성인 좌석 
		IF _ADULT_COUNT != 0 THEN 
			SET _PR_NUM = (SELECT PR_NUM FROM PRICE WHERE PR_TYPE='성인');
            SET _ADULT_COUNT = _ADULT_COUNT - 1;
		ELSE
			SET _PR_NUM = (SELECT PR_NUM FROM PRICE WHERE PR_TYPE='청소년');
            SET _TEENAGER_COUNT = _TEENAGER_COUNT - 1;
		END IF;
        INSERT INTO RESERVATION_LIST(RL_RV_NUM, RL_SE_NUM, RL_PR_NUM)
        VALUES(_RV_NUM, _SE_NUM, _PR_NUM);
	END LOOP;
    CLOSE CUR;

    -- 영화 스케쥴에 예약 가능좌석수를 업데이트 
    SET _POSSIBLE_SEAT = (
		SELECT 
			SC_TOTAL_SEAT - SUM(RV_ADULT + RV_TEENAGER) 
		FROM 
			RESERVATION
			JOIN 
				MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
			JOIN 
				SCREEN ON MS_SC_NUM = SC_NUM
		WHERE
			RV_MS_NUM = _MS_NUM
	);
    UPDATE 
		MOVIE_SCHEDULE 
	SET 
		MS_POSSIBLE_SEAT = _POSSIBLE_SEAT
	WHERE
		MS_NUM = _MS_NUM;
    
    -- 모든 영화 예매율을 업데이트 
    CALL UPDATE_RESERVATION_RATE();
END //
DELIMITER ;

CALL RESERVATION_MOVIE(4, 'admin', 1, 1,'[{"SEAT_NAME" : "A1"},{"SEAT_NAME" : "A2"}]');
/* 
{ "속성명" : 값,"속성명" : 값}
*/



/*
- 함수
하나의 작업을 하도록 구성. 예매 함수 => 예매에 데이터를 추가만 함 
매개변수 : 값을 사용(매개변수의 값이 변경되지 않음) 
반환값 : 무조건 1개 
SELECT문에서 사용 가능. SUM, COUNT 등 

- 프로시저 
일련의 작업을 하도록 구성. 예매 프로시저 
 => 예매에 데이터를 추가, 예매 리스트에 데이터를 추가, 스케줄의 예매 가능좌석 업데이트, 영화의 예매율 업데이트 
매개변수 : 값을 사용 IN, 값을 반환 OUT, 값을 사용과 반환 INOUT
반환값 : 없음. 대신 매개변수를 이용하여 OUT/INOUT인 매개변수에 반환값을 전달할 수 있음. 
SELECT문에서 사용이 불가능 


DELIMITER //

CREATE PROCEDURE 프로시저명(
[
IN|OUT|INOUT 변수명 변수타입 
]
)
BEGIN
	-- 변수 선언 방법. 상단에 변수 선언을 모아 놓아야 함 
	DECLARE 변수명 변수타입;
	DECLARE 변수명 변수타입 DEFAULT 기본값;
    
    -- 변수값 변경 
    SET 변수명 = 값;
    
    -- IF문
    IF 조건식1 THEN
		실행문1;
	ELSEIF 조건식2 THEN
		실행문2;
	ELSE
		실행문3;
	END IF;
END //
DELIMITER ;

-- 프로시저 호출
CALL 프로시저명(매개변수들);
*/

-- 숫자가 주어지면 숫자앞에 0을 붙여서 최대 5자리로 된 숫자를 만드는 프로시저 
-- 1 => 00001

DROP PROCEDURE IF EXISTS ZERO_NUM;

DELIMITER //

CREATE PROCEDURE ZERO_NUM(
IN _NUM INT
)
BEGIN
	DECLARE _RES CHAR(5);
	SET _RES = (SELECT LPAD(_NUM, 5, '0'));
    SELECT _RES;
END //
DELIMITER ;
CALL ZERO_NUM(123);









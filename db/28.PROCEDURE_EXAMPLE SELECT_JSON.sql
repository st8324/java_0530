-- JSON형태의 문자열을 추출해서 출력하는 프로시저 

DROP PROCEDURE IF EXISTS SELECT_JSON;

DELIMITER //
CREATE PROCEDURE SELECT_JSON(
IN _JSON TEXT
)
BEGIN
	DECLARE DONE INT DEFAULT 0; -- CURSOR를 이용하여 반복문을 할 때 종료할지를 결정해주는 변수 
    DECLARE _ID CHAR(10); -- 검색결과에 있는 한행의 있는 아이디를 저장할 변수
    DECLARE _NAME VARCHAR(20); -- 검색결과에 있는 한행의 있는 이름을 저장할 변수
    
    DECLARE CUR CURSOR FOR
		SELECT * FROM JSON_TABLE(_JSON, "$[*]"
			COLUMNS(
				ID CHAR(10) PATH "$.ID",
                NAME VARCHAR(20) PATH "$.NAME"
            )
        ) AS INFO_TABLE;
        
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET DONE = 1;
    -- CURSOR를 염
    OPEN CUR;
    STUDENT_LOOP : LOOP
		
		FETCH CUR INTO _ID, _NAME;
        IF DONE THEN 
			LEAVE STUDENT_LOOP;
		END IF;
        -- 하고싶은 작업 
        SELECT _ID, _NAME;
    END LOOP;
    -- CURSOR를 닫음 
    CLOSE CUR;
END //
DELIMITER ;

CALL SELECT_JSON('[{"ID" : "ABC123","NAME":"홍길동"},{"ID" : "ADMIN","NAME":"고길동"},{"ID" : "QWE123","NAME":"임꺽정"}]');






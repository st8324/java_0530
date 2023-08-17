/* 
이벤트 스케쥴러 : 일정주기마다 이벤트를 발생시켜서 등록된 이벤트를 실행하는 것 
CREATE EVENT 이벤트명 
ON SCHEDULE EVERY 숫자 단위(DAY, HOUR, MINUTE,..) 
[STARTS 시간]
DO
	작업할코드; -- 작업할 코드는 한줄로 된 INSERT/UPDATE/DELETE나 프로시저 이용 
*/
-- 이벤트 스케쥴러의 ON/OFF 를 조회하는 쿼리 
-- SHOW VARIABLES LIKE 'EVENT%';
USE TEST;
-- 등록된 이벤트 스케쥴러 조회 
-- SHOW EVENTS;
DROP EVENT IF EXISTS TEST_EVENT;
CREATE EVENT TEST_EVENT ON SCHEDULE EVERY 1 MINUTE
DO
	UPDATE DASH_BOARD SET DB_MEMBER = DB_MEMBER + 1;

-- 영화 오펜하이머에 출연한 감독과 배우들을 조회하는 쿼리 
SELECT 
    MO_TITLE AS '영화제목',
    FP_NAME AS '영화인',
    RO_ROLE AS '역할'
FROM
    FILM_PERSON
        JOIN
    ROLE ON FP_NUM = RO_FP_NUM
        JOIN
    MOVIE ON MO_NUM = RO_MO_NUM
WHERE
	MO_TITLE = '오펜하이머';
-- 영화 오펜하이머 기본 정보를 조회하는 쿼리(제목, 제목(영문), 개봉일, 런링타임, 줄거리, 연령제한, 예매율
SELECT 
    MO_TITLE AS 제목,
    MO_TITLE_ENG AS '제목(영문)',
    MO_OPENING_DATE AS 개봉일,
    MO_RUNNING_TIME AS 런닝타임,
    MO_PLOT AS 줄거리,
    MO_AG_NAME AS 연령제한,
    CONCAT(MO_RESERVATION_RATE,'%') AS 예매율
FROM
    MOVIE
WHERE
    MO_TITLE = '오펜하이머';
-- 영화 오펜하이머의 트레일러와 스틸컷 파일의 개수를 조회하는 쿼리
SELECT 
	MO_TITLE AS '영화제목',
	FI_STATE AS '타입',
    COUNT(*) AS '개수'
FROM
    FILE
        JOIN
    MOVIE_FILE ON MF_FI_NUM = FI_NUM
        JOIN
    MOVIE ON MF_MO_NUM = MO_NUM
WHERE
    MO_TITLE = '오펜하이머'
GROUP BY FI_STATE;

-- abc회원의 예매 내역을 조회하는 쿼리(영화명, 시간, 좌석명) 
SELECT 
    MO_TITLE AS 영화제목, MS_START_TIME AS 상영시간, SE_NAME AS 좌석
FROM
    RESERVATION
        JOIN
    RESERVATION_LIST ON RL_RV_NUM = RV_NUM
		JOIN
	SEAT ON RL_SE_NUM = SE_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
		JOIN
	MOVIE ON MO_NUM = MS_MO_NUM
WHERE RV_ME_ID = 'abc123';
-- abc회원의 예매 내역을 조회하는 쿼리(영화명, 시간, 성인 X명, 청소년 X명) 
SELECT 
    MO_TITLE AS 영화제목, MS_START_TIME AS 상영시간, 
    SUM(RV_ADULT) AS 성인수, SUM(RV_TEENAGER) AS 청소년수
FROM
    RESERVATION
		JOIN
	MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
		JOIN
	MOVIE ON MO_NUM = MS_MO_NUM
WHERE RV_ME_ID = 'abc123'
GROUP BY RV_NUM;

-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리
SELECT 
    SE_NAME
FROM
    SEAT
        JOIN
    SCREEN ON SE_SC_NUM = SC_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
WHERE
	MS_NUM = 8 AND SE_NUM NOT IN(
	SELECT RL_SE_NUM FROM RESERVATION
		JOIN RESERVATION_LIST ON RL_RV_NUM = RV_NUM
		WHERE RV_MS_NUM = 8
    );
-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리(OUTER JOIN 이용)
SELECT 
    SE_NAME
FROM
    SEAT
        JOIN
    SCREEN ON SE_SC_NUM = SC_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
		LEFT JOIN -- 예약과 예약 리스트를 JOIN하는게 아니라 예약 리스트와 좌석을 JOIN
	RESERVATION_LIST ON SE_NUM = RL_SE_NUM
WHERE
	MS_NUM = 8 AND RL_SE_NUM IS NULL;
-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 있는 좌석들과 좌석들 예매 여부를 조회하는 쿼리 
SELECT 
    SE_NAME AS '좌석 번호', 
	CASE 
		WHEN RL_SE_NUM IS NULL THEN 'O'
		ELSE 'X' 
	END AS '예약 가능 여부'
FROM
    SEAT
        JOIN
    SCREEN ON SE_SC_NUM = SC_NUM
		JOIN
	MOVIE_SCHEDULE ON MS_SC_NUM = SC_NUM
		LEFT JOIN -- 예약과 예약 리스트를 JOIN하는게 아니라 예약 리스트와 좌석을 JOIN
	RESERVATION_LIST ON SE_NUM = RL_SE_NUM
WHERE
	MS_NUM = 8;

-- 'abc123'회원이 관람했던 영화 목록을 조회하는 쿼리 
SELECT MO_TITLE AS '관람 영화' FROM RESERVATION
	JOIN
		MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
	JOIN
		MOVIE ON MS_MO_NUM = MO_NUM
WHERE 
	RV_ME_ID = 'abc123' AND NOW() >= CONCAT(MS_DATE,' ',MS_START_TIME)
GROUP BY MO_NUM -- 같은 영화를 여러번 봐도 관람 영화 목로에는 1번만 출력 
;
-- 예약 가능한 모든 상영 영화 정보를 조회하는 쿼리 
SELECT DISTINCT
    MO_TITLE AS 영화제목, MS_DATE AS 상영일, MS_START_TIME AS 상영시간, MO_AG_NAME AS 연령제한
FROM
    MOVIE_SCHEDULE
        JOIN
    MOVIE ON MO_NUM = MS_MO_NUM
WHERE
    NOW() < CONCAT(MS_DATE, ' ', MS_START_TIME) AND ms_possible_seat > 0; 

-- CGV에서 이벤트로 한 영화를 여러번 회원 중에 가장 많이 본 회원 3명을 뽑으려고 한다. 
-- 각 영화를 각회원이 몇번봤는지 조회는 쿼리 
SELECT 
    MO_TITLE AS 영화, RV_ME_ID AS 아이디, COUNT(RV_NUM) AS 회수
FROM
    RESERVATION
        JOIN
    MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
        JOIN
    MOVIE ON MS_MO_NUM = MO_NUM
WHERE
    NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME)
GROUP BY RV_ME_ID , MS_MO_NUM;

-- 회원들 중 금액 사용이 가장 많은 3명의 회원을 조회하는 쿼리
-- 사용 금액이 같은 회원이 여러명인 경우 누구는 순위 포함되고 누구는 순위에 포함되지 않을 수 있음 
SELECT 
    ME_ID AS 아이디,
    SUM(CASE
			WHEN NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME) THEN RV_PRICE
			ELSE 0
		END)AS 누적금액
FROM
    RESERVATION
        JOIN
    MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM
        RIGHT JOIN
    MEMBER ON RV_ME_ID = ME_ID
GROUP BY RV_ME_ID
ORDER BY 누적금액 DESC
LIMIT 3;
-- 회원들 중 금액 사용이 가장 많은 3명의 회원을 조회하는 쿼리 
-- 사용 금액이 같은 회원이 여러명인 경우 여러명 모두 등수에 포함되면 모두 받을 수 있다. 
SELECT * FROM (
	SELECT 
		ME_ID AS 아이디,
		누적금액,
		RANK() OVER(ORDER BY 누적금액 DESC) AS 순위
	FROM
		(SELECT *, SUM(
			CASE
				WHEN NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME) THEN RV_PRICE
				ELSE 0
			END) AS 누적금액 FROM
		RESERVATION
			JOIN
		MOVIE_SCHEDULE ON RV_MS_NUM = MS_NUM
			RIGHT JOIN
		MEMBER ON RV_ME_ID = ME_ID
		GROUP BY RV_ME_ID
		) AS A
	) AS B
WHERE 순위 <= 3;

-- 영화인별로 배우로 참여한 영화 개수를 조회하는 쿼리 
SELECT 
    FP_NAME AS 영화인, IFNULL(COUNT(RO_NUM),0) AS '참여영화수(배우)'
FROM
    FILM_PERSON
        LEFT JOIN
    (SELECT 
        *
    FROM
        ROLE
    WHERE
        RO_ROLE = '배우') AS ROLE2 ON RO_FP_NUM = FP_NUM
GROUP BY FP_NUM;
-- 각 스케쥬별 예약한 좌석 수를 조회하는 쿼리 
SELECT 
    MO_TITLE AS 영화,
    MS_DATE AS 상영일,
    MS_START_TIME AS 상영시간,
    SC_TOTAL_SEAT - MS_POSSIBLE_SEAT AS 예약좌석수
FROM
    MOVIE_SCHEDULE
        JOIN
    SCREEN ON MS_SC_NUM = SC_NUM
		JOIN
	MOVIE ON MO_NUM = MS_MO_NUM;
-- 영화관별 상영 영화 목록을 보여주는 쿼리 
SELECT 
    TH_NAME AS 영화관, MO_TITLE AS 영화
FROM
    MOVIE_SCHEDULE
        JOIN
    SCREEN ON MS_SC_NUM = SC_NUM -- 영화관과 연결을 위해 먼저 상영관과 연결 
		JOIN
	THEATER ON TH_NUM = SC_TH_NUM -- 영화관명을 조회하기 위해 영화관 연결 
		JOIN
	MOVIE ON MS_MO_NUM = MO_NUM -- 영화 제목을 조회가 위해 영화관 열결 
WHERE 
	NOW() < CONCAT(MS_DATE, ' ', MS_START_TIME)
GROUP BY TH_NUM, MS_MO_NUM;

-- 오펜하이머를 상영하는 영화관을 조회하는 쿼리 
SELECT 
    TH_NAME AS 영화관
FROM
    MOVIE_SCHEDULE
        JOIN
    SCREEN ON MS_SC_NUM = SC_NUM -- 영화관과 연결을 위해 먼저 상영관과 연결 
		JOIN
	THEATER ON TH_NUM = SC_TH_NUM -- 영화관명을 조회하기 위해 영화관 연결 
		JOIN
	MOVIE ON MS_MO_NUM = MO_NUM -- 영화 제목을 조회가 위해 영화관 열결 
WHERE 
	NOW() < CONCAT(MS_DATE, ' ', MS_START_TIME) AND MO_TITLE = '오펜하이머'
GROUP BY TH_NUM, MS_MO_NUM;

-- 등록된 영화를 조회는 쿼리 
SELECT * FROM MOVIE;

-- 장르가 드라마인 영화를 조회하는 쿼리 
SELECT 
    *
FROM
    MOVIE
        JOIN
    MOVIE_GENRE ON MG_MO_NUM = MO_NUM
WHERE
	MG_GE_NAME = '드라마';

-- 개봉전인 영화를 조회하는 쿼리 
SELECT 
    *
FROM
    MOVIE
WHERE
	MO_OPENING_DATE > NOW();

-- 상영 종료된 영화를 조회하는 쿼리(현재 개봉중인 영화는 오늘을 기준으로 2주까지 스케쥴이 반드시 등록이 됨)
SELECT 
    MO_TITLE AS 상영종료영화
FROM
    MOVIE
		LEFT JOIN -- 상영 종료된 영화는 상영 정보가 없기 때문에 INNER JOIN을 하면 상영 종료된 영화가 조회되지 않음 
	MOVIE_SCHEDULE ON MO_NUM = MS_MO_NUM
WHERE
	MO_OPENING_DATE <= NOW()
HAVING 
	COUNT(MS_NUM) = 0;
    

-- 영화 콘크리트 유토피아 리뷰를 조회하는 쿼리 
SELECT 
    *
FROM
    REVIEW
WHERE
    RE_MO_NUM = (SELECT 
            MO_NUM
        FROM
            MOVIE
        WHERE
            MO_TITLE = '콘크리트 유토피아');
-- 15세관람가 영화를 조회하는 쿼리 
SELECT 
    *
FROM
    MOVIE
WHERE
	MO_AG_NAME = '15세관람가';

-- 이병헌이 출연한 영화를 조회하는 쿼리 
SELECT 
    MO_TITLE AS 영화, FP_NAME AS 영화인
FROM
    MOVIE
        JOIN
    ROLE ON MO_NUM = RO_MO_NUM
        JOIN
    FILM_PERSON ON FP_NUM = RO_FP_NUM
WHERE
    FP_NAME = '이병헌';
-- 2023년에 개봉한 영화를 조회하는 쿼리 
SELECT 
    *
FROM
    MOVIE
WHERE
	MO_OPENING_DATE LIKE '2023%';
    
-- 2023년에 개봉한 한국 영화를 조회하는 쿼리 
SELECT 
    CP_CT_NAME AS 국가, MO_TITLE AS 영화
FROM
    MOVIE
		JOIN 
	COUNTRY_PRODUCTION ON MO_NUM = CP_MO_NUM
WHERE
	MO_OPENING_DATE LIKE '2023%' AND CP_CT_NAME = '한국';

-- 각 영화의 리뷰수를 조회하는 쿼리 
SELECT 
	MO_TITLE AS 영화, COUNT(RE_NUM) AS 리뷰수 
FROM 
	MOVIE
		LEFT JOIN 
	REVIEW ON MO_NUM = RE_MO_NUM
GROUP BY MO_NUM;

-- CGV강남에서 상영하는 모든 영화 스케쥴을 조회하는 쿼리 
-- 영화 제목, 상영시간, 상영관이름 
SELECT 
    MO_TITLE AS 영화, MS_START_TIME AS 상영시간, SC_NAME AS 상영관
FROM
    MOVIE_SCHEDULE
        JOIN
    MOVIE ON MO_NUM = MS_MO_NUM
        JOIN
    SCREEN ON SC_NUM = MS_SC_NUM
WHERE
    SC_TH_NUM = (SELECT 
            TH_NUM
        FROM
            THEATER
        WHERE
            TH_NAME = 'CGV강남');
-- 영화 예매율 순으로 가장 예매율이 높은 영화 1개를 조회하는 쿼리. 
-- 예매율이 같은 경우 개봉일이 늦은 영화를 조회 
SELECT 
    MO_TITLE AS 영화예매율1위
FROM
    MOVIE
ORDER BY MO_RESERVATION_RATE DESC , MO_OPENING_DATE ASC
LIMIT 1;
    
    
    
    
-- 관리자를 등록하는 작업
-- 아이디 : admin, 비번 : admin, 이름 : 관리자, 번호 : 011-1111-2222, 생일 : 2000-01-01
-- 권한 : ADMIN 
INSERT INTO MEMBER(ME_ID, ME_PW, ME_NAME, ME_PHONE, ME_BIRTHDAY, ME_AUTHORITY)
VALUES('admin', 'admin', '관리자', '011-1111-2222', '2000-01-01', 'ADMIN');

-- 관리자가 영화 오펜하이머를 등록하기전에 사전에 해야하는 작업을 쿼리로 작성
-- 영화를 등록하기 위해 필요한 연령제한 데이터를 추가 
-- : 전체관람가, 12세관람가, 15세관람가, 청소년관람불가, 제한상영가
INSERT INTO AGE VALUES('전체관람가'),('12세관람가'),('15세관람가'),('청소년관람불가'),('제한상영가');
-- 감독/배우를 등록하기 위해서 필요한 국가 데이터를 추가 
-- : 한국, 미국, 영국, 일본 등...
INSERT INTO COUNTRY VALUES('한국'),('미국'),('영국'),('일본'),('아일랜드');

-- 다른 데이터베이스 테이블에 있는 데이터를가져와서 추가하는 쿼리 
-- INSERT INTO COUNTRY SELECT COUNTRY FROM SAKILA.COUNTRY;

-- 영화를 등록하기 위해 필요한 장르 데이터를 추가
-- : 멜로, 드라마, 코미디, SF, 어드벤처, 액션, 판타지, 공포, 스릴러, 범죄, 전쟁 
INSERT INTO GENRE VALUES('멜로'),('드라마'),('코미디'),('SF'),('어드벤처'),
('액션'),('판타지'),('공포'),('스릴러'),('범죄'),('전쟁');

-- 관리자가 영화 오펜하이머를 등록하는 작업을 쿼리로 작성
-- 메인포스터를 먼저 등록 : 오펜하이머_메인포스터.JPG
INSERT INTO FILE(FI_NAME, FI_STATE) VALUES('오펜하이머_메인포스터.JPG', '메인포스터');
-- 영화 정보를 등록 : 제목, 제목-영어, 개봉일, 런링타임, 줄거리, 등록된 메인포스터 번호, 연령제한을 선택 
INSERT INTO MOVIE(MO_TITLE, MO_TITLE_ENG, MO_OPENING_DATE, MO_RUNNING_TIME,
	MO_PLOT, MO_FI_NUM, MO_AG_NAME)
    VALUES('오펜하이머','Oppenheimer', '2023-08-15',180, 
    '“나는 이제 죽음이요, 세상의 파괴자가 되었다.”', 1, '15세관람가');
-- 등록된 영화인이 아닌 경우는 영화인을 등록하고, 이미 등록되어 있으면 생략 
-- 영화인을 등록(크리스토퍼 놀란, 킬리언 머피, 에밀리 블런트, 맷 데이먼, 로버트 다우니 주니어, 플로렌스 퓨,
-- 조쉬 하트넷, 케이시애플렉, 라미 말렉, 케네스 브래너)
INSERT INTO FILM_PERSON(FP_NAME, FP_THUMBNAIL, FP_AGENCY, FP_FINAL_EDUCATION, 
	FP_BIRTHDAY, FP_CT_NAME)
    VALUES('크리스토퍼 놀란','크리스토퍼 놀란.JPG','','','1970-07-30','영국'),
    ('킬리언 머피','킬리언 머피.JPG','','','1974-05-25','아일랜드'),
    ('에밀리 블런트','에밀리 블런트.JPG','','','1983-02-23','영국'),
    ('맷 데이먼','맷 데이먼.JPG','','','1970-10-08','미국'),
    ('로버트 다우니 주니어','로버트 다우니 주니어.JPG','','','1965-04-04','미국'),
    ('플로렌스 퓨','플로렌스 퓨.JPG','','','1996-01-03','영국'),
    ('조쉬 하트넷','조쉬 하트넷.JPG','','','1978-07-21','미국'),
    ('케이시애플렉','케이시애플렉.JPG','','','1975-08-12','미국'),
    ('라미 말렉','라미 말렉.JPG','','','1981-05-12','미국'),
    ('케네스 브래너','케네스 브래너.JPG','','','1960-12-10','영국');

-- 역할을 등록 
INSERT INTO ROLE(RO_ROLE, RO_FP_NUM, RO_MO_NUM)
VALUES('감독', 1, 1),
('배우', 2, 1),
('배우', 3, 1),
('배우', 4, 1),
('배우', 5, 1),
('배우', 6, 1),
('배우', 7, 1),
('배우', 8, 1),
('배우', 9, 1),
('배우', 10, 1);
-- 영화 장르에서 오펜하이머 장르를 추가
INSERT INTO MOVIE_GENRE(MG_GE_NAME, MG_MO_NUM) VALUES('드라마', 1),('스릴러',1);
-- 제작 국가에서 오펜하이머 제작국가를 추가 
INSERT INTO COUNTRY_PRODUCTION(CP_CT_NAME, CP_MO_NUM) VALUES('미국',1),('영국',1);
-- 트레일러와 스틸컷을 등록(오펜하이머_트레일러1.MP4, 오펜하이머_스틸컷.JPG, ... )
INSERT INTO FILE(FI_NAME, FI_STATE) 
VALUES('오펜하이머_트레일러1.MP4', '트레일러'),
('오펜하이머_트레일러2.MP4', '트레일러'),
('오펜하이머_트레일러3.MP4', '트레일러'),
('오펜하이머_스틸컷1.JPG', '스틸컷'),
('오펜하이머_스틸컷2.JPG', '스틸컷'),
('오펜하이머_스틸컷3.JPG', '스틸컷'),
('오펜하이머_스틸컷4.JPG', '스틸컷'),
('오펜하이머_스틸컷5.JPG', '스틸컷');

-- 영화 파일에 오펜하이머에 어떤 트레일러와 스틸컷이 있는지 등록 
INSERT INTO MOVIE_FILE(MF_FI_NUM, MF_MO_NUM)
VALUES(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1);

-- 영화 콘크리트 유토피아를 등록(위에서 했던 영화 오펜하이머와 같은 방식으로 진행)
-- 트레일러는 2개, 스틸컷은 3개 
-- 메인포스터를 등록 
INSERT INTO FILE(FI_NAME, FI_STATE) VALUES('콘크리트 유토피아_메인포스터.JPG', '메인포스터');
-- 영화 정보를 등록
INSERT INTO MOVIE(MO_TITLE, MO_TITLE_ENG, MO_OPENING_DATE, MO_RUNNING_TIME,
	MO_PLOT, MO_FI_NUM, MO_AG_NAME)
    VALUES('콘크리트 유토피아', 'Concrete Utopia', '2023-08-09', 130,
    '“아파트는 주민의 것”', 10, '15세관람가');

-- 영화인 등록 
INSERT INTO FILM_PERSON(FP_NAME, FP_THUMBNAIL, FP_BIRTHDAY, FP_CT_NAME)
VALUES('엄태화', '엄태화.JPG', '1981-01-01', '한국'),
('이병헌', '이병헌.JPG', '1970-07-12', '한국'),
('박서준', '박서준.JPG', '1988-12-16', '한국'),
('박보영', '박보영.JPG', '1990-02-12', '한국'),
('김선영', '김선영.JPG', '1976-04-10', '한국'),
('박지후', '박지후.JPG', '2003-11-07', '한국'),
('김도윤', '김도윤.JPG', '1981-08-07', '한국');

-- 역할 등록 
INSERT INTO ROLE(RO_ROLE, RO_FP_NUM, RO_MO_NUM)
VALUES('감독',11,2),('배우',12,2),('배우',13,2),('배우',14,2),('배우',15,2)
	,('배우',16,2),('배우',17,2);

-- 영화 장르 등록
INSERT INTO MOVIE_GENRE(MG_GE_NAME, MG_MO_NUM) VALUES('드라마', 2);
-- 영화 제작 국가 
INSERT INTO COUNTRY_PRODUCTION(CP_CT_NAME, CP_MO_NUM) VALUES('한국',2);
-- 트레일러/스틸컷 등록 
INSERT INTO FILE(FI_NAME, FI_STATE)
VALUES('콘크리트 유토피아_트레일러1.MP4', '트레일러'),
('콘크리트 유토피아_트레일러2.MP4', '트레일러'),
('콘크리트 유토피아_트레일러3.MP4', '트레일러'),
('콘크리트 유토피아_스틸컷1.JPG', '스틸컷'),
('콘크리트 유토피아_스틸컷2.JPG', '스틸컷');

-- 영화 파일을 등록
INSERT INTO MOVIE_FILE(MF_FI_NUM, MF_MO_NUM)
VALUES(11,2),(12,2),(13,2),(14,2),(15,2);

-- 영화관 등록을 위해 사전에 해야하는 작업 
-- 지역 데이터를 추가 : 서울, 경기, 인천, 강원, 대전/충청, 대구, 부산/울산, 경상, 광주/전라/제주 
INSERT INTO REGION VALUES('서울'), ('경기'), ('인천'), ('강원'), ('대전/충청'), ('대구'),
	('부산/울산'),('경상'),('광주/전라/제주');

-- 영화관 등록 : 
-- CGV강남 영화관을 등록, 2관, 24좌석 
INSERT INTO THEATER(TH_NAME, TH_ADDRESS, TH_RE_NAME, TH_TOTAL_SCREEN, TH_TOTAL_SEAT)
VALUES('CGV강남', '서울특별시 강남구 강남대로 438 (역삼동)', '서울', 2, 24);

-- CGV강남 영화관에 있는 상영관 등록
-- 1관 6층, 총 10좌석 
-- 2관(LCK관) 6층(LASER), 총 14좌석 
INSERT INTO SCREEN(SC_NAME, SC_TOTAL_SEAT, SC_TH_NUM)
VALUES('1관 6층', 10, 1), ('2관(LCK관) 6층(LASER)', 14, 1);

-- CGV강남 영화관 좌석을 등록 
-- 1관 : A1, A2, A3, A4, B1, B2, B3, C1, C2, C3 
-- 2관 : A1, A2, A3, A4, B1, B2, B3, B4, C1, C2, C3, C4, D1, D2
INSERT INTO SEAT(SE_NAME, SE_ROW, SE_COL, SE_SC_NUM)
VALUES('A1', 'A', '1', 1),
('A2', 'A', '2', 1),
('A3', 'A', '3', 1),
('A4', 'A', '4', 1),
('B1', 'B', '1', 1),
('B2', 'B', '2', 1),
('B3', 'B', '3', 1),
('C1', 'C', '1', 1),
('C2', 'C', '2', 1),
('C3', 'C', '3', 1),
('A1', 'A', '1', 2),
('A2', 'A', '2', 2),
('A3', 'A', '3', 2),
('A4', 'A', '4', 2),
('B1', 'B', '1', 2),
('B2', 'B', '2', 2),
('B3', 'B', '3', 2),
('B4', 'B', '4', 2),
('C1', 'C', '1', 2),
('C2', 'C', '2', 2),
('C3', 'C', '3', 2),
('C4', 'C', '4', 2),
('D1', 'D', '1', 2),
('D2', 'D', '2', 2);
-- CGV강남 영화관 영화 스케쥴 
-- 오펜하이머 1관 23년 8월 16일 09:00, 12:30, 16:00, 19:30
-- 콘크리트 유토피아 2관 23년 8월 16일 10:10, 12:50, 18:10, 20:50
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	1, 1, '2023-08-16',10,  '09:00:00', 
	RIGHT(ADDDATE('2023-08-16 09:00:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '09:00' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 1;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	1, 1, '2023-08-16',10,  '12:30:00', 
	RIGHT(ADDDATE('2023-08-16 12:30:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '12:30' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 1;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	1, 1, '2023-08-16',10,  '16:00:00', 
	RIGHT(ADDDATE('2023-08-16 16:00:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '16:00' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 1;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	1, 1, '2023-08-16',10,  '19:30:00', 
	RIGHT(ADDDATE('2023-08-16 19:30:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '19:30' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 1;

INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	2, 2, '2023-08-16',14,  '10:10:00', 
	RIGHT(ADDDATE('2023-08-16 10:10:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '10:10' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 2;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	2, 2, '2023-08-16',14,  '12:50:00', 
	RIGHT(ADDDATE('2023-08-16 12:50:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '12:50' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 2;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	2, 2, '2023-08-16',14,  '18:10:00', 
	RIGHT(ADDDATE('2023-08-16 18:10:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '18:10' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 2;
INSERT INTO MOVIE_SCHEDULE(MS_MO_NUM, MS_SC_NUM, MS_DATE,MS_POSSIBLE_SEAT, 
	MS_START_TIME, MS_END_TIME, MS_DISCOUNT)
SELECT 
	2, 2, '2023-08-16',14,  '20:50:00', 
	RIGHT(ADDDATE('2023-08-16 20:50:00', INTERVAL MO_RUNNING_TIME+10 MINUTE), 8), 
	CASE WHEN '20:50' <= '12:00' THEN 'Y' ELSE 'N' END
FROM MOVIE WHERE MO_NUM = 2;

-- 예매를 위해 사전에 해야하는 작업 
-- 요금 데이터를 추가 
-- 성인 : 14000, 조조 : 12000
-- 청소년 : 11000, 조조 : 9000
INSERT INTO PRICE(PR_TYPE, PR_PRICE, PR_DISCOUNT_PRICE)
VALUES('성인', 14000, 12000), ('청소년', 11000, 9000);

-- 아이디 : abc123, 비번 : abc123, 이름 : 홍길동, 번호 : 011-1234-5678,
-- 생일 : 2000-01-05, 권한 : USER 인 회원이 회원가입 
INSERT INTO MEMBER(ME_ID, ME_PW, ME_NAME, ME_PHONE, ME_BIRTHDAY, ME_AUTHORITY)
VALUES('abc123', 'abc123', '홍길동', '011-1234-5678', '2000-01-05', 'USER');
-- abc123회원이 CGV강남에서 20:50에 시작하는 콘크리트 유토피아 영화를 성인 2명으로, 
-- A1, A2 좌석을 예매했을 때 필요한 쿼리들 

-- RESERVATION에 예약 정보를 추가 
INSERT INTO RESERVATION(RV_NUM, RV_ADULT, RV_TEENAGER, RV_ME_ID, RV_MS_NUM, RV_PRICE)
SELECT '202308091614MS008001',2, 0, 'abc123', MS_NUM,
CASE 
	WHEN MS_DISCOUNT = 'Y' THEN
		2 * 12000 + 0 * 9000
    ELSE
		2 * 14000 + 0 * 11000
    END
FROM MOVIE_SCHEDULE WHERE MS_MO_NUM = 2 AND MS_START_TIME = '20:50:00';

-- RESUERVATION_LIST에 예약 좌석 정보를 추가 
INSERT INTO RESERVATION_LIST(RL_RV_NUM, RL_SE_NUM, RL_PR_NUM) 
	VALUES('202308091614MS008001', 11, 1),('202308091614MS008001', 12, 1);

-- MOVIE_SCHEDULE에 예약 가능 좌석 수를 수정 
UPDATE MOVIE_SCHEDULE 
SET 
    MS_POSSIBLE_SEAT = MS_POSSIBLE_SEAT - 2
WHERE
    MS_NUM = 8;
-- MOVIE에 예매율을 수정 
UPDATE MOVIE 
SET 
    MO_RESERVATION_RATE = ROUND(
    (SELECT 
    SUM(RV_ADULT + RV_TEENAGER)
FROM
    RESERVATION
    JOIN
		MOVIE_SCHEDULE
	ON RV_MS_NUM = MS_NUM
WHERE
	MS_MO_NUM = 2) / 
    (SELECT 
    SUM(RV_ADULT + RV_TEENAGER)
FROM
    RESERVATION
    JOIN
		MOVIE_SCHEDULE
	ON RV_MS_NUM = MS_NUM) * 100)
WHERE
    MO_NUM = 2;

-- 'abc123'회원이 콘크리트 유토피아 리뷰를 다음과 같이 작성할 때 쿼리
-- 콘크리트 유토피아 재미 있어요 
INSERT INTO REVIEW(RE_CONTENT, RE_MO_NUM, RE_ME_ID)
	SELECT 
		'콘크리트 유토피아 재미 있어요', MO_NUM, 'abc123'
	FROM
		MOVIE
	WHERE
		MO_TITLE = '콘크리트 유토피아';

-- abc123회원이 작성한 콘크리트 유토피아 리뷰를 admin회원이 추천을 클릭했을 때 필요한 쿼리 
-- 단, 리뷰번호는 1번인걸 알고 있다고 가정 
-- 1. 추천 테이블에 데이터 추가 
INSERT INTO `LIKE`(ME_ID, RE_NUM) VALUES('admin', 1);
-- 2. 리뷰 테이블에 추천 수를 업데이트 
UPDATE 
	REVIEW 
SET 
	RE_TOTAL_LIKE = (SELECT COUNT(*) FROM `LIKE` WHERE RE_NUM = 1)
WHERE
	RE_NUM = 1;
    
-- admin 회원이 1번 리뷰를 추천을 취소 했을 때 필요한 쿼리 
DELETE FROM `LIKE` WHERE ME_ID='admin' AND RE_NUM = 1;
UPDATE 
	REVIEW 
SET 
	RE_TOTAL_LIKE = (SELECT COUNT(*) FROM `LIKE` WHERE RE_NUM = 1)
WHERE
	RE_NUM = 1;







-- qwe123회원이 구매(환불, 반품을 제외한)한 제품명과 옵션명 목록을 확인하는 쿼리 
SELECT 
	OR_ME_ID AS 주문아이디,
    PR_NAME AS 제품명,
    OP_NAME AS 옵션명,
    PR_PRICE AS 제품가격,
    OL_AMOUNT AS 구매수량
FROM `ORDER`
	JOIN ORDER_LIST ON OL_OR_NUM = OR_NUM
    JOIN `OPTION` ON OL_OP_NUM = OP_NUM
    JOIN PRODUCT ON OP_PR_CODE = PR_CODE
WHERE OR_STATE NOT IN('환불', '반품') AND OR_ME_ID = 'qwe123';

-- abc123회원이 장바구니에 담은 제품명과 옵션명, 수량을 확인하는 쿼리 
SELECT 
    BA_ME_ID AS 회원아이디,
    PR_NAME AS 제품명,
    OP_NAME AS 옵션명,
    BA_AMOUNT AS 수량
FROM
    BASKET
    JOIN `OPTION`
	ON BA_OP_NUM = OP_NUM
    JOIN PRODUCT
	ON OP_PR_CODE = PR_CODE
WHERE
    BA_ME_ID = 'abc123';
-- abc123회원이 등록한 배송지 정보를 조회하는 쿼리 
SELECT 
    *
FROM
    ADDRESS
WHERE
    AD_ME_ID = 'abc123';
-- 등록된 모든 제품을 검색하는 쿼리 
SELECT * FROM PRODUCT;

-- KH가 제품명에 포함된 제품들을 검색하는 쿼리 
SELECT 
    *
FROM
    PRODUCT
WHERE
    PR_NAME LIKE CONCAT('%', 'KH', '%');    

-- KH가 제품명에 포함된 제품들 중에서 1페이지에 해당하는 제품들을 검색하는 쿼리(한 페이지에는 제품이 최대 5개)
SELECT 
    *
FROM
    PRODUCT
WHERE
    PR_NAME LIKE CONCAT('%', 'KH', '%')
LIMIT 0, 5;   
-- KH가 제품명에 포함된 제품들 중에서 2페이지에 해당하는 제품들을 검색하는 쿼리(한 페이지에는 제품이 최대 5개)
SELECT 
    *
FROM
    PRODUCT
WHERE
    PR_NAME LIKE CONCAT('%', 'KH', '%')
LIMIT 5, 5;   

-- abc123회원이 작성한 모든 리뷰를 조회하는 쿼리 
SELECT * FROM REVIEW WHERE RE_ME_ID = 'abc123';

-- abc123회원이 작성한 리뷰가 있는 제품명을 조회 
SELECT 
    PR_NAME AS 리뷰제품
FROM
    REVIEW
        JOIN
    `OPTION` ON RE_OP_NUM = OP_NUM
        JOIN
    PRODUCT ON PR_CODE = OP_PR_CODE
WHERE
    RE_ME_ID = 'abc123';
-- 제품 코드가 ABC001이고, 옵션명이 무선인 제품에 달린 리뷰를 조회 
SELECT 
    *
FROM
    REVIEW
        JOIN
    `OPTION` ON OP_NUM = RE_OP_NUM
WHERE
    OP_PR_CODE = 'ABC001' AND OP_NAME = '무선';
-- 제품명이 KH무선마우스인 제품의 리뷰 개수를 조회하는 쿼리
SELECT 
    COUNT(*) AS 'KH무선마우스 리뷰수'
FROM
    REVIEW
        JOIN
    `OPTION` ON RE_OP_NUM = OP_NUM
WHERE
	OP_PR_CODE = (SELECT PR_CODE FROM PRODUCT WHERE PR_NAME = 'KH무선마우스');
-- 제품별 리뷰 개수를 조회하는 쿼리(리뷰가 등록된 제품만 조회)
SELECT 
	OP_PR_CODE AS 제품코드,
    COUNT(*) AS 리뷰수
FROM
    REVIEW
        JOIN
    `OPTION` ON OP_NUM = RE_OP_NUM
GROUP BY OP_PR_CODE;

-- 제품별 옵션의 개수를 조회하는 쿼리(제품명, 옵션수)
SELECT 
	PR_NAME AS 제품명, 
    COUNT(*) AS 옵션수 
FROM 
	PRODUCT 
		JOIN 
	`OPTION` ON PR_CODE = OP_PR_CODE 
GROUP BY PR_CODE;

-- 제품별 판매량(반품, 환불을 제외한)을 조회하는 쿼리(제품명, 판매량)
SELECT
	PR_NAME AS 제품명,
	SUM(OL_AMOUNT) AS 판매량
FROM
    PRODUCT
JOIN
	`OPTION`
ON
	OP_PR_CODE = PR_CODE
LEFT JOIN
	ORDER_LIST
ON
	OL_OP_NUM = OP_NUM
LEFT JOIN
	`ORDER` 
ON 
	OR_NUM = OL_OR_NUM
WHERE
	OR_STATE IS NULL OR OR_STATE NOT IN('반품','환불')
GROUP BY PR_CODE;
-- 제품 옵션별 판매량(반품, 환불을 제외한)을 조회하는 쿼리(제품명, 옵션명, 판매량)
SELECT
	PR_NAME AS 제품명,
    OP_NAME AS 옵션명,
	IFNULL(SUM(OL_AMOUNT),0) AS 판매량
FROM
    PRODUCT
JOIN
	`OPTION`
ON
	OP_PR_CODE = PR_CODE
LEFT JOIN
	ORDER_LIST
ON
	OL_OP_NUM = OP_NUM
LEFT JOIN
	`ORDER` 
ON 
	OR_NUM = OL_OR_NUM
WHERE
	OR_STATE IS NULL OR OR_STATE NOT IN('반품','환불')
GROUP BY OP_NUM;

-- 제품 옵션별 판매량(반품, 환불을 제외한)을 조회하는 쿼리(제품명, 옵션명, 판매량, 총판매금액)
SELECT
	PR_NAME AS 제품명,
    OP_NAME AS 옵션명,
	IFNULL(SUM(OL_AMOUNT),0) AS 판매량,
    PR_PRICE * IFNULL(SUM(OL_AMOUNT),0) AS 총판매금액
FROM
    PRODUCT
		JOIN
	`OPTION` ON	OP_PR_CODE = PR_CODE
		LEFT JOIN 
	ORDER_LIST ON OL_OP_NUM = OP_NUM
		LEFT JOIN 
	`ORDER`ON OR_NUM = OL_OR_NUM
WHERE
	OR_STATE IS NULL OR OR_STATE NOT IN('반품','환불')
GROUP BY OP_NUM;
-- 옵션별 리뷰수를 조회하는 쿼리(제품명, 옵션명, 리뷰수)
SELECT 
   PR_NAME AS 제품명, OP_NAME AS 옵션명, COUNT(RE_NUM) AS 리뷰수
FROM
    REVIEW
        RIGHT JOIN
    `OPTION` ON RE_OP_NUM = OP_NUM
        JOIN
    product ON OP_PR_CODE = PR_CODE
GROUP BY OP_NUM;

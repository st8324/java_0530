/* 
대표적으로 많이 사용되는 타입
숫자
tinyint : 1바이트, 정수, -128~127. 논리형값을 저장할 때 사용(0:false, 그외 : true)
int : 4바이트, 정수 -약21억~약21억
bigint : 8바이트, 정수, -약900경~900경 
float/double : 4/8바이트, 실수 

문자 
char(n) : 고정된 n자리 문자열
varchar(n) : 최대 n자리 문자열 
longtext : 최대 4GB 크기의 문자열 
longblob : 최대 4GB 크기의 2진데이터 

날짜
문자열처럼 사용과 비교가 가능 
date : 년-월-일
datetime : 년-월-일 시:분:초, now()를 통해 초기값 설정 가능. current_timestamp

now()는 현재 시간을 알려주는 함수 
*/
/* 
if(수식, 참, 거짓)

ifnull(속성, 값) : 속성 값이 null이 아니면 속성값을 이용하고, null이면 값을 이용
 
case when 조건1 then 값1 when 조건2 then 값2 else 값3
: 조건1이 참이면 값1을 조건2가 참이면 값2를 아님녀 값3을 이용 

instr(기준문자열, 찾을문자열);
: 기준문자열에서 찾을 문자열이 몇번재에 있는지 알려주는 함수, 없으면 0. 1부터 시작 

format(숫자, 소수점 자리수);
: 숫자를 소수점 자리까지 표현하고, 정수부분은 3개단위로 ,를 추가 해줌 

right(문자열, 숫자)/left(문자열, 숫자);
: 문자열에서 오른쪽/왼쪽에서 숫자개수만큼 문자열을 추출. 오른쪽/왼쪽을 기준으로 고정된 길이의 문자열을 추출할 때 

lpad/rpad(문자열, 숫자, 채울문자열);
: 문자열에 채울문자열을 왼쪽/오른족에 채워서 숫자개수만큼 길이가 되도록 함. 

replace(문자열, 원래문자열, 바꿀문자열);
문자열에서 원래문자열을 찾아 있으면 바꿀 문자열로 수정 

substring(문자열, 시작위치, 길이);
문자열에서 시작위치부터 길이만큼 찾아서 반환. 길이가 생략되면 시작위치부터 끝까지 반환 

now(), current_timestamp(), sysdate();
:현재시간을 년-월-일 시:분:초로 알려주는 함수 

adddate(날짜, 차이)/subdate(날짜, 차이);
: 날짜로부터 차이만큼 더한/뺀 날짜
차이 : interval 숫자 단위(day, month, year, hour, minute, second) 

addtime(날짜, 차이)/subtime(날짜, 차이);
: 날짜로부터 차이만큼 더한/뺀 날짜 
차이 : 'yyyy-MM-dd hh:mm:ss'

datediff(날짜1, 날짜2);
:날짜1과 날짜2 사이의 차이를 일 기준으로 반환 
timediff(날짜1, 날짜2);
:날짜1과 날짜2 사이의 차이를 시,분,초로 반환 
*/
select num as 학번, if(major = '컴퓨터공학과','컴공','컴공아님') as 전공  from student;
select title as 과목명, ifnull(time, 0) as 시수 from subject;
select num as 학번, 
case 
	when major = '방송학과' then '방송'
    when major = '컴퓨터공학과' then '컴공'
    else '기타'
end as 학과 
from student;
select instr(title, '개론') as 대학위치, title from subject;
select format(1000000, 0);
-- 23학번 학생 조회
select * from student where left(num, 4) = 2023;
select lpad(1, 3, '0');
select replace('hello', 'h', 'H');
select substring('Hello. My name is xxx.', 1, 6);
select adddate(now(), interval 1 day); -- 현재시간을 기준으로 하루 다음 날짜 
select adddate(now(), interval 1 month);
select adddate(now(), interval 1 year);
select subdate(now(), interval 1 day);
select addtime(now(), '1 0:0:0'); -- 현재시간을 기준으로 하루 다음 날짜 
select datediff('2023-08-05 14:00:00', '2023-08-02 13:00:00');
select timediff('2023-08-05 14:00:00', '2023-08-02 13:00:00');

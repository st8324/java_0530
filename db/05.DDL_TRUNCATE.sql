/* 
truncate table 테이블명 : 테이블 데이터를 초기화 
- 유의 사항
  - 초기화 하려는 테이블의 기본키가 외래키로 참조 중인 경우 바로 초기화가 안됨
  - 외래키 체크를 하는 값을 0(체크안함)으로 설정 한 뒤 초기화
  - 초기화 완료 후 외래키 체크하는 값을 1(체크)로 설정해야 함. 
*/
set foreign_key_checks = 0;
truncate table student;
truncate table subject;
set foreign_key_checks = 1;
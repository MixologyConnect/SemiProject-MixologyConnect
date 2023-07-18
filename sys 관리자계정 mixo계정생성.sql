ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER mixo IDENTIFIED BY m1234;
--생성한 자용자 계정 권한 부여 
GRANT CONNECT, RESOURCE TO mixo;
-- CONNECT :DB 연결권한 ROLE
-- RESOURCE :DB 기본객체 생성 권한 ROLE

-- 객체(테이블 등)가 생성될 수 있는 공간 할당량 지정
ALTER USER mixo DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

GRANT CREATE TABLE, CREATE VIEW TO mixo;
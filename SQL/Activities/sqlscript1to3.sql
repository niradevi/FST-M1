REM   Script: Activity1_3
REM   create and select statements

CREATE TABLE salesman;

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int 
);

DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES(100, 'abc', 'Delhi', 2) 
    INTO salesman VALUES(101, 'abc2', 'Mumbai', 3) 
    INTO salesman VALUES(102, 'abc3', 'Bangalore', 4) 
    INTO salesman VALUES(103, 'abc4', 'Chennai', 5) 
SELECT 1 FROM DUAL;

select * from salesman;

select salesman_id, salesman_city from salesman;

select * from salesman where salesman_city='Chennai' 
;


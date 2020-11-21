-- №1
SELECT *
FROM departments d;
-- №2
select c.customer_id,
       c.cust_first_name || ' ' || c.cust_last_name as NAME,
       c.CUST_EMAIL
from CUSTOMERS c
ORDER BY c.customer_id;
-- №3
select e.employee_id,
       e.first_name,
       e.last_name,
       e.job_id,
       e.email,
       e.phone_number,
       (CASE
            WHEN 100000 < ((e.salary + 100) * 12) AND ((e.salary + 100) * 12) < 150000
                THEN e.salary * 0.7
            WHEN ((e.salary + 100) * 12) > 150000
                THEN e.salary * 0.65
           END) AS Salary
from employees e
where (e.salary + 100) * 12 between 100000 and 200000
ORDER BY e.job_id, e.last_name, e.salary;
-- №4
SELECT c.country_id, c.country_name
FROM countries c
WHERE c.country_id IN ('DE', 'IT', 'RU')
ORDER BY c.country_name;
-- №5
SELECT e.first_name || ' ' || e.last_name as NAME
FROM employees e
WHERE e.last_name LIKE '_a%'
  AND e.first_name LIKE '%d%';
-- №6
SELECT *
FROM employees e
WHERE LENGTH(e.first_name) < 5
   OR LENGTH(e.last_name) < 5
ORDER BY (LENGTH(e.first_name) + LENGTH(e.last_name)), LENGTH(e.last_name), e.last_name, e.first_name;
-- №7
SELECT j.job_id, j.job_title, ROUND(((j.max_salary + j.min_salary) / 2) * 0.82 / 1000, 1) * 1000 AS AVG_SALARY
FROM JOBS j
ORDER BY AVG_SALARY DESC, j.job_id;

-- №8
SELECT c.CUST_LAST_NAME,
       c.CUST_FIRST_NAME,
       case
           WHEN c.CREDIT_LIMIT >= 3500 THEN 'A'
           WHEN c.CREDIT_LIMIT < 3500 AND c.CREDIT_LIMIT >= 1000 THEN 'B'
           ELSE 'C'
           end                                                           category,
       CASE WHEN c.CREDIT_LIMIT >= 3500 THEN 'Внимание, VIP-клиенты' end COMMENTS
FROM CUSTOMERS c
ORDER BY category;
-- №9
SELECT decode(
               EXTRACT(month from o.order_date),
               1, 'Январь',
               2, 'Февраль',
               3, 'Март',
               4, 'Апрель',
               5, 'Май',
               6, 'Июнь',
               7, 'Июль',
               8, 'Август‚',
               9, 'Сентябрь',
               10, 'Октябрь',
               11, 'Ноябрь',
               12, 'Декабрь'
           ) month
FROM orders o
WHERE date '1998-01-01' <= o.order_date
  and o.order_date < date '1999-01-01'
GROUP BY EXTRACT(month from o.ORDER_DATE);
-- №10

select DISTINCT to_char(o.ORDER_DATE, 'MONTH', 'nls_date_language=russian') as MONTH
from orders o
WHERE date '1998-01-01' <= o.order_date
  and o.order_date < date '1999-01-01';
-- №11

SELECT sysdate, to_char(sysdate, 'dd fmMONTH yyyy, day') AS RESULT
FROM dual;
SELECT sysdate,
       case
           WHEN to_char(trunc(sysdate, 'MONTH') + rownum - 1, 'day') IN ('воскресенье', 'суббота') then 'выходной'
           end comments
FROM dual
connect by rownum <= to_number(to_char(last_day(sysdate), 'DD'));


-- 12
SELECT e.employee_id,
       e.last_name || ' ' || e.first_name as emp_name,
       e.job_id,
       e.salary,
       e.commission_pct
FROM employees e
WHERE e.commission_pct is not null
ORDER BY e.commission_pct desc,
         e.employee_id;

-- 13

SELECT *
FROM employees e
WHERE LENGTH(e.first_name) < 5
   OR LENGTH(e.last_name) < 5
ORDER BY (LENGTH(e.first_name) + LENGTH(e.last_name)), LENGTH(e.last_name), e.last_name, e.first_name;
SELECT *
FROM JOBS;
SELECT j.job_id, j.job_title, ROUND(((j.max_salary + j.min_salary) / 2) * 0.82 / 1000, 1) * 1000 AS AVG_SALARY
FROM JOBS j
ORDER BY AVG_SALARY DESC, j.job_id;

SELECT c.cust_last_name, c.cust_first_name
FROM customers c;
SELECT j.job_id, j.job_title, AVG(((j.max_salary + j.min_salary) / 2) * 0.82) AS AVG_SALARY
FROM JOBS j
GROUP BY j.job_id;

select DISTINCT to_char(o.ORDER_DATE, 'fmMONTH ')                          AS MONTH,
       to_char(o.ORDER_DATE, 'yyyy', 'nls_date_language=russian') AS YEAR,
       COUNT(*) over (ORDER BY o.ORDER_DATE)                      as orders
from ORDERS o group by to_char(o.order_date, 'month'),to_char(o.order_date, 'yyyy') having count(*) > 2 and sum(o.order_total) > 20000
order by extract(month from to_date(Month, 'MM'));
;;
select to_char(o.order_date, 'month') as Month,
       to_char(o.order_date, 'yyyy')  as Year,
       count(*)                       as count_order,
       count(o.order_total) as total
from orders o
group by to_char(o.order_date, 'month'),
         to_char(o.order_date, 'yyyy')
having count(*) > 2
   and sum(o.order_total) > 20000
order by extract(month from to_date(Month, 'MM'));
;
select e.DEPARTMENT_ID from EMPLOYEES e group by e.department_id, e.first_name HAVING COUNT(e.FIRST_NAME) >1 order by e.DEPARTMENT_ID;
select e.department_id
from employees e
group by e.department_id, e.first_name
having count(e.first_name) > 1
order by e.department_id;

SELECT  EXTRACT(YEAR FROM O.ORDER_DATE) AS YEAR,
        SUM(CASE
                WHEN EXTRACT(MONTH FROM O.ORDER_DATE) < 7 THEN
                    O.ORDER_TOTAL
            END) AS SUMPART1,
        COUNT(CASE
                  WHEN EXTRACT(MONTH FROM O.ORDER_DATE) < 7 THEN
                      O.ORDER_TOTAL
            END) AS COUNTPART1,
        SUM(CASE
                WHEN 6 < EXTRACT(MONTH FROM O.ORDER_DATE)THEN
                    O.ORDER_TOTAL
            END) AS SUMPART2,
        COUNT(CASE
                  WHEN 6 < EXTRACT(MONTH FROM O.ORDER_DATE)THEN
                      O.ORDER_TOTAL
            END) AS COUNTPART2
FROM  ORDERS O
GROUP BY EXTRACT(YEAR FROM O.ORDER_DATE)
ORDER BY YEAR
;
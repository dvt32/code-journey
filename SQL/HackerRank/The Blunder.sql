# https://www.hackerrank.com/challenges/the-blunder

SELECT CEILING(AVG(Salary) - AVG(REPLACE(Salary, '0', '')))
FROM EMPLOYEES;

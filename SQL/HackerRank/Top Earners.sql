# https://www.hackerrank.com/challenges/earnings-of-employees

SELECT Salary * Months, COUNT(Name)
FROM Employee
WHERE Salary * Months = (SELECT MAX(Salary * Months) FROM Employee);

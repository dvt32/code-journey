# https://leetcode.com/problems/department-highest-salary/
# MySQL

SELECT d.name AS "Department", e.name AS "Employee", e.salary AS "Salary"
FROM Employee e, Department d
WHERE 
    e.departmentId = d.Id AND
    e.salary = (SELECT MAX(salary) FROM Employee WHERE departmentId = d.Id);

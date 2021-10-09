/* https://leetcode.com/problems/department-top-three-salaries */
/* MS SQL Server */

SELECT d1.Name AS Department, e1.Name AS Employee, e1.Salary
FROM Department d1, Employee e1
WHERE 
    e1.DepartmentId = d1.Id 
    AND
    e1.Salary IN 
        (SELECT DISTINCT TOP 3 e2.Salary 
         FROM Department d2, Employee e2
         WHERE d2.Id = d1.Id AND e2.DepartmentId = d2.Id
         ORDER BY salary DESC)
ORDER BY Department;

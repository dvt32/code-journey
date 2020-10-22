# https://leetcode.com/problems/employees-earning-more-than-their-managers/submissions/

SELECT Name as Employee
FROM Employee e1
WHERE 
    Salary > 
        (SELECT Salary 
         FROM Employee e2 
         WHERE e2.Id = e1.ManagerId);

# https://leetcode.com/problems/classes-more-than-5-students/
# MySQL

SELECT class
FROM courses 
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5

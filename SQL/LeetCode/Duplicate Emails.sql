# https://leetcode.com/problems/duplicate-emails

SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(Email) > 1
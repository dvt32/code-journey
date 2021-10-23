/* https://leetcode.com/problems/consecutive-numbers/ */
/* MS SQL Server */

SELECT DISTINCT log1.num AS ConsecutiveNums
FROM Logs log1, Logs log2, Logs log3
WHERE 
    (log2.id = log1.id+1 AND log3.id = log1.id+2) AND
    (log1.num = log2.num AND log1.num = log3.num AND log2.num = log3.num);

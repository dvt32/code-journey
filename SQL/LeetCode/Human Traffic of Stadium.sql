# https://leetcode.com/problems/human-traffic-of-stadium/
# MySQL / MS SQL Server

SELECT DISTINCT s1.id, s1.visit_date, s1.people
FROM Stadium s1, Stadium s2, Stadium s3
WHERE 
    (
        (s2.id = s1.id+1 AND s3.id = s1.id+2) OR
        (s2.id = s1.id-1 AND s3.id = s1.id+1) OR
        (s2.id = s1.id-1 AND s3.id = s1.id-2)  
    ) AND
    (s1.people >= 100 AND s2.people >= 100 AND s3.people >= 100)
ORDER BY s1.visit_date ASC

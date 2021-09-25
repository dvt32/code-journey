# https://leetcode.com/problems/exchange-seats/
# MySQL

SELECT id-1 As Id, student
FROM seat
WHERE id % 2 = 0
    UNION
SELECT id+1, student
FROM seat
WHERE id % 2 = 1 AND id < (SELECT COUNT(*) FROM seat)
    UNION
SELECT id, student
FROM seat
WHERE id = (SELECT COUNT(*) FROM seat) AND (SELECT COUNT(*) FROM seat) % 2 = 1
ORDER BY id

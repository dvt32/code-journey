# https://leetcode.com/problems/rising-temperature/
# MySQL

SELECT w1.Id
FROM Weather w1, Weather w2
WHERE
    w1.temperature > w2.temperature AND
    DATEDIFF(w1.recordDate, w2.recordDate) = 1;

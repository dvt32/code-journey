# https://www.hackerrank.com/challenges/more-than-75-marks

SELECT Name
FROM STUDENTS
WHERE Marks > 75
ORDER BY SUBSTRING(Name, LENGTH(Name)-2, 3) ASC, ID ASC;

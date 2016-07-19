# https://www.hackerrank.com/challenges/weather-observation-station-8

SELECT DISTINCT CITY
FROM STATION
WHERE CITY REGEXP '^[a, e, i, o, u]' AND CITY REGEXP '[a, e, i, o, u]$';

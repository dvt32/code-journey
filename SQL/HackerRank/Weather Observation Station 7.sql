# https://www.hackerrank.com/challenges/weather-observation-station-7

SELECT DISTINCT CITY
FROM STATION
WHERE CITY REGEXP '[a, e, i, o, u]$';

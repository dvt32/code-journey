# https://www.hackerrank.com/challenges/weather-observation-station-20

SELECT ROUND(A.LAT_N, 4)
FROM STATION A
WHERE 
  (SELECT COUNT(LAT_N) FROM STATION WHERE LAT_N > A.LAT_N) =
  (SELECT COUNT(LAT_N) FROM STATION WHERE LAT_N < A.LAT_N);

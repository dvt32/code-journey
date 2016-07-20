# https://www.hackerrank.com/challenges/weather-observation-station-19
# Indented for better readability

SELECT 
    ROUND(
        SQRT(
             POW(MIN(LAT_N)-MIN(LONG_W), 2) +
             POW(MAX(LAT_N)-MAX(LONG_W), 2)
        ),
    4
    )
FROM STATION;

# https://www.hackerrank.com/challenges/what-type-of-triangle

SELECT 
    IF(A + B <= C OR A + C <= B OR B + C <= B, "Not A Triangle", 
       IF(A = B AND B = C AND A = C, "Equilateral", 
          IF(A = B OR A = C OR B = C, "Isosceles", "Scalene")))
FROM TRIANGLES;

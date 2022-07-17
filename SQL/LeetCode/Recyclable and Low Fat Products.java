# https://leetcode.com/problems/recyclable-and-low-fat-products/
# MySQL

SELECT product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y';

# https://leetcode.com/problems/customers-who-never-order/

SELECT Name AS Customers
FROM Customers c
WHERE 
    NOT EXISTS(
        SELECT * FROM Orders WHERE CustomerId = c.id
    );

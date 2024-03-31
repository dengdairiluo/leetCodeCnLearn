# Write your MySQL query statement below
SELECT s.user_id , SUM(s.quantity * p.price) AS spending
FROM Sales AS s
         JOIN Product AS p
              USING(product_id)
GROUP BY s.user_id
ORDER BY spending DESC , s.user_id

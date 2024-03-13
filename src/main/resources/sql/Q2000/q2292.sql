# Write your MySQL query statement below
with a as (
    SELECT product_id, YEAR(purchase_date) YY
    FROM Orders
    GROUP BY product_id, YEAR(purchase_date)
    HAVING COUNT(DISTINCT order_id) >= 3
)

SELECT DISTINCT b.product_id
FROM a b, a c
WHERE b.product_id = c.product_id AND ABS(b.YY - c.YY) = 1


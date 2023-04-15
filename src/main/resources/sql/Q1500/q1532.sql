# Write your MySQL query statement below
SELECT c.name customer_name,
       c.customer_id,
       t.order_id,
       t.order_date
FROM (SELECT order_id,
             order_date,
             customer_id,
             row_number() over (partition by customer_id order by order_date DESC) as rank_tag
      FROM orders) t
         LEFT JOIN customers c
                   ON t.customer_id = c.customer_id
WHERE rank_tag <= 3
ORDER BY name, customer_id, order_date DESC;

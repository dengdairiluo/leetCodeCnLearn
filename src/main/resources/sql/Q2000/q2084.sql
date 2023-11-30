# Write your MySQL query statement below


select order_id, customer_id, order_type
from (select order_id,
             customer_id,
             order_type,
             count(1) over (partition by customer_id)        as order_num,
             sum(order_type) over (partition by customer_id) as type_sum
      from orders) a
where a.order_num = a.type_sum
   or a.order_type = 0;

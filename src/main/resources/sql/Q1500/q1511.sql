# Write your MySQL query statement below
select o.customer_id,
       c.name
from Orders o
         left join Customers c using (customer_id)
         left join Product p using (product_id)
where order_date like "2020-06%"
   or "2020-07%"
group by customer_id
having sum(case when order_date like "2020-06%" then quantity * price else 0 end) >= 100
   and sum(case when order_date like "2020-07%" then quantity * price else 0 end) >= 100
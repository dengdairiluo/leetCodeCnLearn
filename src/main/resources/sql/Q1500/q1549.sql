# Write your MySQL query statement below
select p.product_name, p.product_id, o.order_id, o.order_date
from Orders o
         left join Products p on o.product_id = p.product_id
         left join Customers c on o.customer_id = c.customer_id
where (product_name, order_date) in (select product_name, max(order_date) order_date
                                     from Orders o
                                              left join Products p on o.product_id = p.product_id
                                     group by product_name)
order by product_name, product_id, order_id;

# Write your MySQL query statement below
select
    product_id,
    price
from (
         select
             product_id,
             new_price as price,
             rank() over(partition by product_id order by change_date desc) as rk
         from Products
         where change_date <= '2019-08-16'
     ) t1 where rk = 1
union
select
    product_id,
    10 as price
from Products
group by product_id
having(min(change_date) > '2019-08-16')


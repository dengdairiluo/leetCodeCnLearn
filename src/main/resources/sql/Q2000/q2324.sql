# Write your MySQL query statement below
with t as (select user_id
                , t1.product_id
                , dense_rank() over (partition by user_id order by sum(quantity * price) desc) rk
           from Sales t1
                    left join Product t2
                              on t1.product_id = t2.product_id
           group by 1, 2)
select user_id
     , product_id
from t
where t.rk = 1

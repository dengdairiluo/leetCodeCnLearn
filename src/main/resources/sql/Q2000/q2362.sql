# Write your MySQL query statement below
with t as (select a.*,a.quantity*b.price as price
           from purchases a
                    left join products b using(product_id))


select product_id,quantity,price
from t
where invoice_id in
      (select invoice_id
       from
           (select *,row_number() over(order by sum_price desc,invoice_id) as rk
            from
                (select *,sum(price) over(partition by invoice_id) as sum_price
                 from t) t2) t3
       where rk = 1)


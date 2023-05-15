# Write your MySQL query statement below
select s.seller_name
from seller s
         left join orders o on s.seller_id = o.seller_id and year(o.sale_date) = '2020'
where o.seller_id is null
order by s.seller_name

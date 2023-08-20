# Write your MySQL query statement below
select order_id
from (
         -- 每个订单的最大数量 > max(每个订单的平均数量)
         select *,
                max(quantity) > max(avg(quantity)) over () as flag
         from OrdersDetails
         group by order_id) as base
where flag = 1


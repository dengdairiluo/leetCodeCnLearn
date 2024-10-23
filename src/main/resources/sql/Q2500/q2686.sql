# Write your MySQL query statement below
select order_date , round(avg(order_date =customer_pref_delivery_date) *100 ,2)as immediate_percentage
from delivery
group by order_date
order by order_date

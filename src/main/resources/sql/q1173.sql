# 嵌套
select 
    round(
        (select count(*) from Delivery where order_date=customer_pref_delivery_date) /
        (select count(*) from Delivery), 4
    ) * 100
as immediate_percentage 

# 条件选择
select round(
    sum(case when order_date=customer_pref_delivery_date then 1 else 0 end) /
    count(*)
   ,4)*100
as immediate_percentage
from Delivery


# 逻辑真值
select round(
    sum(order_date=customer_pref_delivery_date) /
    count(*)
    ,4)*100
as immediate_percentage
from Delivery

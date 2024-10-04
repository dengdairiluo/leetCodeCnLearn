# Write your MySQL query statement below
select
    customer_id,
    min(transaction_date) as consecutive_start,
    max(transaction_date) as consecutive_end
from
    (    select
             customer_id,
             transaction_date,
             sum(case when amount > last_amount then 0 else 1 end) over(partition by customer_id order by transaction_date asc) as flag_amount,
                 date_sub(transaction_date,interval rn day) as flag_day
         from (
                  select
                      transaction_id,
                      customer_id,
                      transaction_date,
                      amount,
                      lag(amount,1,0) over(partition by customer_id order by transaction_date asc) as last_amount,
                          row_number() over(partition by customer_id order by transaction_date asc) as rn
                  from Transactions
              ) t1
    ) t2
group by customer_id,flag_amount,flag_day
having count(1) > 2
order by customer_id asc
;

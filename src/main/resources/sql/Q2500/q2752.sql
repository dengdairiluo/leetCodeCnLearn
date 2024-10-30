# Write your MySQL query statement below
select customer_id
from (select customer_id,
             count_num,
             dense_rank() over (order by count_num desc) dr
      from (select customer_id,
                   count(*) as count_num
            from (select *,
                         date_sub(transaction_date, interval
                                  row_number() over (partition by customer_id order by transaction_date) day) as flag
                  from Transactions) a
            group by customer_id, flag) b) c
where dr = 1
order by customer_id asc



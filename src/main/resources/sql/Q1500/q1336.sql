with recursive
    cte1 as (select v.user_id, visit_date, transaction_date, amount
             from visits v
                      left join transactions t on v.user_id = t.user_id and v.visit_date = t.transaction_date),
    cte2 as (select user_id, visit_date, sum(case when amount is null then 0 else 1 end) as transactions_count
             from cte1
             group by user_id, visit_date),
    cte3 as (select max(transactions_count) as max_transactions_count
             from cte2),
    cte4(n) as (select 0 as n
                union all
                select n + 1 as n
                from cte4
                where n < (select max_transactions_count from cte3))


select n              as transactions_count,
       count(user_id) as visits_count
from cte4 t1
         left join cte2 t2
                   on t1.n = t2.transactions_count
group by 1


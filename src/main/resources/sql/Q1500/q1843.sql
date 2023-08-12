# Write your MySQL query statement below
with t1 as (select account_id,
                   sum(amount)                  as total_income,
                   extract(year_month from day) as month,
                   max_income
            from Transactions
                     left join Accounts using (account_id)
            where type = 'Creditor'
            group by account_id, month),

     t2 as (select *, month - rank() over (partition by account_id order by month) as ref
            from t1
            where total_income > max_income)

select distinct account_id
from t2
group by account_id, ref
having count(*) >= 2


with cte as
         (select *
          from transactions
          union all
          select id, country, 'chargeback' state, amount, c.trans_date
          from chargebacks c
                   left join transactions t
                             on c.trans_id = t.id)

select date_format(trans_date, '%Y-%m')         month,
       country,
       sum(state = 'approved')                  approved_count,
       sum(if(state = 'approved', amount, 0))   approved_amount,
       sum(state = 'chargeback')                chargeback_count,
       sum(if(state = 'chargeback', amount, 0)) chargeback_amount
from cte
group by month, country
having approved_amount
    or chargeback_amount
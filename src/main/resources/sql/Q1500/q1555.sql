# Write your MySQL query statement below


select user_id,
       user_name,
       (credit + recv - paid)                      as credit,
       if((credit + recv - paid) < 0, 'Yes', 'No') as credit_limit_breached
from (select a.*, ifnull(b.paid, 0) as paid, ifnull(c.recv, 0) as recv
      from Users a
               left join
           (select paid_by, sum(amount) as paid
            from Transactions
            group by paid_by) b
           on a.user_id = b.paid_by
               left join
           (select paid_to, sum(amount) as recv
            from Transactions
            group by paid_to) c
           on a.user_id = c.paid_to) as temp


# Write your MySQL query statement below
select distinct a.id, a.name
from (select a.id, a.login_date as ad, b.login_date as bd
      from logins a
               join logins b
                    on a.id = b.id and datediff(a.login_date, b.login_date) between 0 and 4
      group by a.id, a.login_date
      having count(distinct b.login_date) = 5) as t
         left join accounts a on a.id = t.id


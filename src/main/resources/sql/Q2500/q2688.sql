# Write your MySQL query statement below
select distinct user_id
from (
         select user_id,created_at, lead(created_at,1) over (partition by user_id order by created_at asc) as next_date
         from users
     ) tmp
where abs(datediff(created_at,next_date))<=7


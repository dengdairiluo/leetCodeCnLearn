# Write your MySQL query statement below
select contest_id, round(count(user_id) * 100 / (select count(*) from users), 2) percentage
from Register
group by contest_id
order by percentage desc, contest_id

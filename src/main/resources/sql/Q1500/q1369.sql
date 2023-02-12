# Write your MySQL query statement below
select A.username, A.activity, A.startDate, A.endDate
from (select a.*,
             COUNT(1) over (partition by a.username)                               cn,
             row_number() over (partition by a.username order by a.startdate desc) rn
      from UserActivity a) A
WHERe A.cn = '1'
   or A.rn = '2'


# Write your MySQL query statement below
select distinct
    session_id
from Playback P
         left join Ads A
                   on P.customer_id = A.customer_id and timestamp between start_time and end_time
where timestamp is null


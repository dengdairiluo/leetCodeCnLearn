# Write your MySQL query statement below
select distinct id1 user_id
from (select id1,
             id2,
             case
                 when count(1) over (partition by id1,rq) = 1 then 2
                 when row_number() over (partition by id1,rq order by sj) = 1 then 1
                 when row_number() over (partition by id1,rq order by sj desc) = 1 then 1
                 else 0 end lx,
             rq
      from (select caller_id id1, recipient_id id2, call_time sj, date_format(call_time, '%Y-%m-%d') rq
            from calls
            union
            select recipient_id id1, caller_id id2, call_time sj, date_format(call_time, '%Y-%m-%d') rq
            from calls) a) b
group by id1, id2, rq
having sum(lx) = 2;
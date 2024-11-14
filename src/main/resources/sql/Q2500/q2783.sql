# Write your MySQL query statement below

with aa as(
select
    flight_id,count(1) as tol
from passengers
group by flight_id
)
select
    f1.flight_id,
    ifnull(if(capacity<=tol,capacity,tol),0) as booked_cnt,
    if(capacity<tol,tol-capacity,0) as waitlist_cnt
from flights f1  left join aa on f1.flight_id=aa.flight_id
order by flight_id
;


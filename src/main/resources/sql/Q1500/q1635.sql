# Write your MySQL query statement below

with recursive t(n) as (
    select 1 n
    union all
    select n+1 from t where n < 12
)
select t.n as month, ifnull(max(active_drivers), ifnull(max(max(active_drivers)) over(order by t.n),0)) as active_drivers, count(distinct AcceptedRides.ride_id) as accepted_rides
from
    t
left join
    (select *, count(driver_id) over(order by join_date) as active_drivers from Drivers) a
on t.n = month(a.join_date) and year(join_date) = 2020
left join Rides on t.n = month(requested_at) and year(requested_at) = 2020
left join AcceptedRides on Rides.ride_id = AcceptedRides.ride_id
group by t.n

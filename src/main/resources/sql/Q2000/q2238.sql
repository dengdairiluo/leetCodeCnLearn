# Write your MySQL query statement below
select r1.driver_id, count(distinct r2.ride_id) as cnt
from Rides r1
         left join Rides r2
                   on r1.driver_id = r2.passenger_id
group by r1.driver_id

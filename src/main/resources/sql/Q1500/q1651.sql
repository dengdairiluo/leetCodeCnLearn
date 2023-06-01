# Write your MySQL query statement below
with recursive t(n) as(
    select 1 n
    union all
    select n+1 from t where n<10
)

select t.n as month, ifnull(round(sum(AcceptedRides.ride_distance)/3,2),0) as average_ride_distance, ifnull(round(sum(AcceptedRides.ride_duration)/3,2),0) as average_ride_duration
from t
         left join Rides on t.n between month(Rides.requested_at)-2 and month(Rides.requested_at) and year(Rides.requested_at) = 2020
         left join AcceptedRides on Rides.ride_id = AcceptedRides.ride_id
group by t.n

# Write your MySQL query statement below
with recursive
    buses_total_passengers as
        (select b.*,
                count(passenger_id)                       as total_passenger,
                row_number() over (order by arrival_time) as rn
         from buses b
                  left join passengers p on b.arrival_time >= p.arrival_time
         group by bus_id),
    result as (select bus_id,
                      rn,
                      least(capacity, total_passenger) psg,
                      least(capacity, total_passenger) bf
               from buses_total_passengers
               where rn = 1
               union
               select b.bus_id,
                      b.rn,
                      least(capacity, total_passenger - bf) psg,
                      least(total_passenger, bf + capacity) bf
               from buses_total_passengers b
                        inner join result r
               where b.rn = r.rn + 1)
select bus_id, psg as passengers_cnt
from result
order by bus_id

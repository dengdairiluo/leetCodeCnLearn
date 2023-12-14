# Write your MySQL query statement below
select airport_id
from (select departure_airport as airport_id, dense_rank() over (order by sum(de_sum) desc) as ranking
      from (select *
            from (select departure_airport, sum(flights_count) as de_sum
                  from `flights`
                  group by departure_airport) a
            union all
            select arrival_airport, sum(flights_count) as arr_sum
            from `flights`
            group by arrival_airport) r
      group by departure_airport) r1
where ranking = 1;


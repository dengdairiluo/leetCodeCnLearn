# Write your MySQL query statement below
with t as (select city_id
                , day
                , degree
                , row_number() over (partition by city_id order by degree desc,day) num
           from Weather)
select city_id
     , day
     , degree
from t
where num = 1
order by 1

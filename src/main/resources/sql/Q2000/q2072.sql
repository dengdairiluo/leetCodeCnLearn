# Write your MySQL query statement below
with uni as (select ny_number,
                    ca_number
             from (select count(student_id) as ny_number
                   from newyork
                   where score >= 90) as ny,
                  (select count(student_id) as ca_number
                   from california
                   where score >= 90) as ca)

select case
           when ny_number > ca_number then "New York University"
           when ny_number < ca_number then "California University"
           else "No Winner"
           end as Winner
from uni
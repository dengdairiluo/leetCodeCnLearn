select name as country
from (select caller_id as call_id, duration
      from Calls
      union all
      select callee_id as call_id, duration
      from Calls) a
         left join
     (select id, c.name
      from Person
               left join Country c
                         on left(Person.phone_number, 3) = c.country_code) b
     on call_id = id
group by name
having avg(duration) > (select avg(duration) from Calls)

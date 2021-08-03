with recursive a as (
    select 1 as n
    union all
    select n+1 from a where n<100
)
select n as ids
from a
where  n not in (select customer_id from Customers)
  and n<=(select max(customer_id) from Customers)

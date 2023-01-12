with t as(
    -- 用union all聚合时，在第一行对字段重命名，方便后续用using()
    select Wimbledon player_id from Championships
    union all
    select Fr_open  from Championships
    union all
    select US_open  from Championships
    union all
    select Au_open  from Championships
)
select
    player_id, player_name, count(1) grand_slams_count
from
    t join Players p using(player_id)
group by
    1

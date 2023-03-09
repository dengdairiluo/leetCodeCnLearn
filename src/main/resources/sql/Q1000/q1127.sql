# Write your MySQL query statement below

with cte1 as
         (
             select distinct spend_date, 'desktop'  as platform from spending
             union
             select distinct spend_date, 'mobile' from spending
             union
             select distinct spend_date, 'both' from spending
         ),

     cte2 as
         (
             select
                 user_id,
                 spend_date,
                 if(count(distinct platform)=2,'both',platform) as platform,
                 sum(amount) as amount
             from spending
             group by 1,2
         )


select
    t1.spend_date,
    t1.platform,
    ifnull(sum(t2.amount),0) as total_amount,
    ifnull(count(t2.user_id),0) as total_users
from cte1 t1
         left join cte2 t2
                   using(spend_date,platform)
group by 1,2
# Write your MySQL query statement below

with cte1 as
    (
    select distinct spend_date, 'desktop'  as platform from spending
    union
    select distinct spend_date, 'mobile' from spending
    union
    select distinct spend_date, 'both' from spending
    ),

    cte2 as
    (
    select
    user_id,
    spend_date,
    if(count(distinct platform)=2,'both',platform) as platform,
    sum(amount) as amount
    from spending
    group by 1,2
    )


select
    t1.spend_date,
    t1.platform,
    ifnull(sum(t2.amount),0) as total_amount,
    ifnull(count(t2.user_id),0) as total_users
from cte1 t1
         left join cte2 t2
                   using(spend_date,platform)
group by 1,2

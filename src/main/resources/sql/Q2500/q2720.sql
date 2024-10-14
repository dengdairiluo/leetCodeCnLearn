# Write your MySQL query statement below
select user1,round(a/b*100,2) as percentage_popularity
from(
        select user1,count(user2) as a
        from(
                select user1,user2
                from Friends

                union

                select user2 as user1,user1 as user2
                from Friends
            ) t
        group by user1
    ) t1
        cross join(
    select count(distinct user1) as b
    from(
            select user1
            from Friends
            union
            select user2
            from Friends
        ) t
) t2
order by user1

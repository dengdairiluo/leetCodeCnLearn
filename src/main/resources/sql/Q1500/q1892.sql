# Write your MySQL query statement below


select f.user1_id user_id,l.page_id,count(*) friends_likes
from(
        select user1_id,user2_id
        from Friendship
        union all
        select user2_id,user1_id
        from Friendship
    ) f
        left join Likes l
                  on user2_id=user_id
where not exists (
    select *
    from Likes
    where user_id=user1_id
      and page_id=l.page_id
)
group by user1_id,page_id


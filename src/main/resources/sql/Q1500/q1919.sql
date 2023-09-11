# Write your MySQL query statement below
select distinct user1_id,user2_id
from(
        select l1.user_id as user1_id,l2.user_id as user2_id,l1.day,l1.song_id
        from Listens l1,Listens l2
        where l1.day =l2.day and l1.user_id<l2.user_id and l1.song_id=l2.song_id
        group by l1.user_id,l2.user_id,l1.day
        having count(distinct l1.song_id)>=3
    )t
where (user1_id,user2_id) in(
    select user1_id,user2_id from Friendship
)
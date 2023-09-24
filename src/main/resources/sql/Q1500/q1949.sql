# Write your MySQL query statement below
with t as (
    (select user1_id user_id,user2_id friend_id
     from Friendship
     union all
     select user2_id,user1_id
     from Friendship)
        order by 1,2
)
select t1.user_id user1_id
     ,t2.user_id user2_id
     ,count(distinct t1.friend_id) common_friend
from t t1,t t2
where (t1.user_id,t2.user_id) in (select * from t)
  and t1.friend_id = t2.friend_id
  and t1.user_id < t2.user_id
group by 1,2
having count(distinct t1.friend_id) >=3

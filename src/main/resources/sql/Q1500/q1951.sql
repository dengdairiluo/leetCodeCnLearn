# Write your MySQL query statement below
with temp as
         (
             select user1_id, user2_id, count(*) as cnt from
                 (
                     select a.user_id as user1_id, b.user_id as user2_id, a.follower_id from Relations a
                                                                                                 join Relations b on a.follower_id = b.follower_id and a.user_id<b.user_id
                 ) as temp
             group by user1_id, user2_id
         )

select user1_id, user2_id from temp
where cnt = (select max(cnt) from temp)

select distinct user1 as user_id, user2 as recommended_id
from (select l1.day, l1.user_id as user1, l2.user_id as user2, l1.song_id
      from Listens l1
               join Listens l2
                    on l1.user_id != l2.user_id and l1.day = l2.day and l1.song_id = l2.song_id
      group by l1.user_id, l2.user_id, l1.day, l1.song_id) a
where 1 / 2 * (user1 + user2) * (user1 + user2 + 1) + power(user1 * user2, 2) not in
      (select 1 / 2 * (user1_id + user2_id) * (user1_id + user2_id + 1) + power(user1_id * user2_id, 2) from Friendship)
group by day, user1, user2
having count(distinct song_id) >= 3
order by 1, 2

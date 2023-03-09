# Write your MySQL query statement below
SELECT a.follower, COUNT(DISTINCT b.follower) num
FROM follow a JOIN follow b
                   ON a.follower=b.followee
GROUP BY a.follower;
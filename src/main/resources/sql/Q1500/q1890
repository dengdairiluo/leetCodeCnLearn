# Write your MySQL query statement below
SELECT user_id, MAX(time_stamp) as last_stamp
FROM Logins
WHERE TIMEDIFF(time_stamp,'2020-01-01 00:00:00')>0
    and TIMEDIFF(time_stamp,'2020-12-31 23:59:59') <0
GROUP BY user_id

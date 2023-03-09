# Write your MySQL query statement below
SELECT
    login_date,
    count(user_id) user_count
FROM (
         SELECT
             min(activity_date) login_date,
             user_id
         FROM Traffic
         WHERE activity= 'login'
         GROUP BY user_id
     ) t
WHERE DATEDIFF('2019-6-30', login_date) <= 90
GROUP BY login_date;
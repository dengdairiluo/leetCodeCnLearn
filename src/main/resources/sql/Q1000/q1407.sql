# Write your MySQL query statement below
SELECT name,IFNULL(sum(distance),0) travelled_distance
FROM Users u LEFT JOIN Rides r
                       ON r.user_id = u.id
GROUP BY u.id
ORDER BY travelled_distance DESC, name

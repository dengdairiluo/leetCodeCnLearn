# Write your MySQL query statement below
SELECT DISTINCT page_id AS recommended_page
FROM Likes
WHERE user_id IN (
    SELECT (
               CASE
                   WHEN user1_id = 1 then user2_id
                   WHEN user2_id = 1 then user1_id
                   END
               ) AS user_id
    FROM Friendship
    WHERE user1_id = 1 OR user2_id = 1
)  AND page_id NOT IN (
    SELECT page_id FROM Likes WHERE user_id = 1
)

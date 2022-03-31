# Write your MySQL query statement below

SELECT (SELECT NUM
        FROM MyNumbers
        GROUP BY 1
        HAVING COUNT(*) = 1
        ORDER BY 1 DESC
        LIMIT 1) AS NUM;
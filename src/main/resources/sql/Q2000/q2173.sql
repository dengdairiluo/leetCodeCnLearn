# Write your MySQL query statement below
SELECT player_id,
       MAX(cnt) AS longest_streak
FROM (
         SELECT player_id,
                id,
                sum(if(result='Win',1,0)) AS cnt
         FROM (
                  SELECT player_id,
                         match_day,
                         result,
                         ROW_NUMBER() OVER(PARTITION BY player_id ORDER BY match_day ASC) -
                         ROW_NUMBER() OVER(PARTITION BY player_id, result ORDER BY match_day ASC) AS id
                  FROM Matches
              ) t
         GROUP BY player_id, id
     ) t
GROUP BY player_id
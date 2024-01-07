# Write your MySQL query statement below

WITH t1 AS
         (SELECT first_col,
                 ROW_NUMBER() OVER (ORDER BY first_col) AS rk
          FROM Data)
        ,
     t2 AS
         (SELECT second_col,
                 ROW_NUMBER() OVER (ORDER BY second_col DESC) AS rk
          FROM Data)

SELECT t1.first_col,
       t2.second_col
FROM t1
         JOIN
     t2
     USING (rk);



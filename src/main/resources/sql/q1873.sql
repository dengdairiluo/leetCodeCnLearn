SELECT employee_id
     , CASE
           WHEN employee_id % 2 != 1
               OR substr(name, 1, 1) = 'M' THEN 0
           ELSE salary
    END AS bonus
FROM employees
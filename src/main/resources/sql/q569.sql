# Write your MySQL query statement below
SELECT
    Id AS id,
    Company AS company,
    Salary AS salary
FROM
    (SELECT
         Id,
         Company,
         Salary,
         COUNT(*) OVER(PARTITION BY Company) AS cnt,
         ROW_NUMBER() OVER(PARTITION BY Company ORDER BY Salary, Id) AS ranking1,
         ROW_NUMBER() OVER(PARTITION BY Company ORDER BY Salary DESC, Id DESC) AS ranking2
     FROM
         Employee) t1
WHERE
        ROUND(cnt / 2, 0) <= ranking1
  AND
        ROUND(cnt / 2, 0) <= ranking2
ORDER BY
    Company,
    Salary,
    Id;
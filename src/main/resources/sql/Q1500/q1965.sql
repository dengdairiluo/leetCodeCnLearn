# Write your MySQL query statement below
select employee_id
FROM (SELECT employee_id
      FROM Employees
      UNION ALL
      SELECT employee_id
      FROM Salaries) AS t
GROUP BY employee_id
HAVING COUNT(*) = 1
ORDER BY employee_id ASC;


# Write your MySQL query statement below
select employee_id
from (select *, 70000 - sum(salary) over (order by experience_rk,salary) as sum_salary2
      from (select *,
                   70000 - sum(salary) over (partition by experience order by salary) as sum_salary,
                   if(experience = 'Senior', 1, 2)                                    as experience_rk
            from candidates) t
      where t.sum_salary >= 0) t2
where t2.sum_salary2 >= 0


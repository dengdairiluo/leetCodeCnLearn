# Write your MySQL query statement below

select experience,
       sum(flag = 1) as accepted_candidates
from (select *,
             if(@s + salary <= 70000, 1, 0) as flag,
             @s := if(@s + salary <= 70000, @s + salary, @s)

      from Candidates
               join (select @s := 0) t1
      order by experience, salary) t2
group by experience

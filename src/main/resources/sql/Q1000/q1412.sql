# Write your MySQL query statement below
select t1.student_id, s.student_name
from (select *,
             if(dense_rank() over (partition by exam_id order by score desc) = 1, 1, 0) d_rank,
             if(dense_rank() over (partition by exam_id order by score ) = 1, 1, 0)     a_rank
      from Exam) t1
         left join Student s on t1.student_id = s.student_id
group by t1.student_id
having sum(d_rank) = 0
   and sum(a_rank) = 0
order by student_id

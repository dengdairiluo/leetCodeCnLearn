select student_id, course_id, grade
from (select student_id,
             course_id,
             grade,
             row_number() over (partition by student_id order by grade desc, course_id) as rk
      from Enrollments) a
where rk = 1


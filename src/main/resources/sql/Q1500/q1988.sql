# Write your MySQL query statement below
select school_id,
       ifnull(min(score), -1) as score
#取最低分数，如果为null，则输出-1
from Schools s
         left join Exam e
                   on capacity >= student_count
#容量需大于分数段学生数量
group by school_id

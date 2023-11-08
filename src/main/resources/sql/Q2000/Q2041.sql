
# Write your MySQL query statement below
with t1 as (
    select candidate_id
    from Candidates
    where years_of_exp >= 2
    )
,t2 as (
    select t4.candidate_id
    from Rounds t3
    left join Candidates t4
    on t3.interview_id = t4.interview_id
    group by 1
    having sum(score) > 15
    )
select t1.candidate_id
from t1,t2
where t1.candidate_id = t2.candidate_id

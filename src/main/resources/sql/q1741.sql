select event_day day, emp_id, sum(out_time-in_time) total_time from employees
group by 1, 2;

select distinct event_day as day, emp_id,
sum(out_time-in_time) over (partition by event_day, emp_id)as total_time 
from employees;

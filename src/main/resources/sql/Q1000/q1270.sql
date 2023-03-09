select e.employee_id from Employees e 
inner join Employees m1 on e.manager_id = m1.employee_id
inner join Employees m2 on m1.manager_id = m2.employee_id
where e.employee_id != 1 and m2.manager_id = 1

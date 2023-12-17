# Write your MySQL query statement below
select concat(group_concat(term order by power desc SEPARATOR ''), '=0') as equation
from (select power,
             concat(if(factor > 0, '+', ''), factor,
                    case power when 1 then 'X' when 0 then '' else concat('X^', power) end) as term
      from Terms) a

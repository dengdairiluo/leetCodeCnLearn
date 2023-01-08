# Write your MySQL query statement below
select round(sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)), 2) shortest
from point2D a
         inner join point2D b on (a.x != b.x or a.y != b.y)
order by shortest
limit 1
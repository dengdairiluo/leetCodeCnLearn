select avg(num) median
from
    (select num,
            sum(frequency) over(order by num) asc_accumu,
            sum(frequency) over(order by num desc) desc_accumu
     from numbers) t1,
    (select sum(frequency) total from numbers) t2
where asc_accumu >= total/2 and desc_accumu >=total/2

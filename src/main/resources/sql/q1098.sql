select b.book_id, name
from books b
         left join orders o
                   on b.book_id = o.book_id and dispatch_date >= '2018-06-23'
where available_from < '2019-05-23'
group by b.book_id
having ifnull(sum(quantity), 0) < 10
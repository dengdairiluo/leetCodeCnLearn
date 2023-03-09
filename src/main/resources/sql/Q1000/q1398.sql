SELECT customer_id,customer_name
FROM Customers
WHERE
        customer_id IN(SELECT customer_id FROM Orders WHERE product_name='A')
  AND
        customer_id IN(SELECT customer_id FROM Orders WHERE product_name='B')
  AND
        customer_id NOT IN(SELECT customer_id FROM Orders WHERE product_name='C');
select o.customer_id, customer_name
from orders o, customers c
where o.customer_id = c.customer_id
group by o.customer_id
having  sum(product_name='A') > 0 and sum(product_name='B') > 0 and sum(product_name='C') = 0;
select
    o1.customer_id as customer_id,
    c1.customer_name as customer_name
from `Customers` as c1
         inner join (
    select
        customer_id
    from `Orders`
    where product_name = 'A' or product_name = 'B'
    group by customer_id
    having count(distinct product_name) = 2
) as o1
                    on c1.customer_id = o1.customer_id
         left join (
    select
        distinct customer_id
    from `Orders`
    where product_name = 'C'
) as o2
                   on o1.customer_id = o2.customer_id
where o2.customer_id is null;
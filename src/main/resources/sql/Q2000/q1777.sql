select product_id,
       sum(if(store = 'store1', price, null)) store1,
       sum(if(store = 'store2', price, null)) store2,
       sum(if(store = 'store3', price, null)) store3
from Products
group by 1
;

select p.product_id,
       a.price store1,
       b.price store2,
       c.price store3
from Products p
         left join
         (select * from Products where store = 'store1') a on p.product_id = a.product_id
         left join
         (select * from Products where store = 'store2') b on p.product_id = b.product_id
         left join
         (select * from Products where store = 'store3') c on p.product_id = c.product_id
group by 1
;

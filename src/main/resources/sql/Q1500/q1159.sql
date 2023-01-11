# Write your MySQL query statement below
select u.seller_id,
       if(item_brand is null, 'no',
          case
              when favorite_brand = item_brand then 'yes'
              else 'no' end) as 2nd_item_fav_brand
from (select user_id as seller_id
      from Users) u
         left join
     (select *
      from (select o.order_date,
                   o.seller_id,
                   i.item_brand,
                   u.favorite_brand,
                   rank() over (partition by o.seller_id order by o.order_date) rnk
            from Orders o
                     left join Users u
                               on o.seller_id = u.user_id
                     left join Items i
                               on o.item_id = i.item_id) t1
      where rnk = 2) t2
     on u.seller_id = t2.seller_id

# Write your MySQL query statement below
select
    id,
    @temp:=if(drink is null, @temp, drink) as drink
from
    CoffeeShop


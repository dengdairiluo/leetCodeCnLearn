# 1.使用带条件的自连接，按每一天进行关联，再按每一天聚合，分组过滤出当天最大的金额。

select
    a.transaction_id
from
    Transactions a left join Transactions b
on
    day(a.day) = day(b.day) 
group by
    a.day
having
    sum(b.amount>a.amount) = 0
order by
    1
# 2.使用窗口函数，直接按每天的交易金额进行排序，外层表求出排名第一的金额即可。

select
    transaction_id
from
    (
        select *,rank() over(partition by day(a.day) order by amount desc) rk
        from Transactions a
    ) t
where
    rk = 1
order by 
    1

with
    recursive temp
                  as
                  (select 1 as n
                   union all
                   select n + 1
                   from temp
                   where n < 12)


select temp.n   as 'month',

#当月没有可用的司机
-- sum(if(temp44.driverAmount is null , 0 , temp44.driverAmount )) over( order by temp.n asc ) as validDriver
       round(
               CASE
#表示没有旅途
                   when temp11.slaves is NULL
                       then 0
                   when sum(ifnull(temp44.driverAmount, 0)) over ( order by temp.n asc) = 0
                       then 0
                   else
                               100 *
                               temp11.slaves
                           /
                               sum(ifnull(temp44.driverAmount, 0)) over ( order by temp.n asc)
                   end
           , 2) as 'working_percentage'
from temp

         left join
     #旅途的日期,旅途的司机
         (select Month(Rides.requested_at) as var1, count(distinct AcceptedRides.driver_id) as slaves
          from Rides
                   right join AcceptedRides
                              on Rides.ride_id = AcceptedRides.ride_id and YEAR(Rides.requested_at) = 2020
          group by Month(Rides.requested_at)) as temp11
#关联到2020年当月的旅途（旅途信息可能为null）
     on temp.n = temp11.var1


# 当月没有加入可能为null
         left join
     (
         #统计2020年每个月加入的司机数量
         select memory,
                count(*) as driverAmount
         FROM (select case
                          when datediff('2020-1-1', join_date) > 0
                              then 1
                          else
                              Month(join_date)
                          end as memory
               from Drivers
               where datediff('2021-1-1', join_date) > 0)
                  as temp33
         group by memory) as temp44
     on temp44.memory = temp.n

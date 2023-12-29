# Write your MySQL query statement below
SELECT bus_id, SUM(IF(ISNULL(bus_time), 0, 1)) AS passengers_cnt
FROM (SELECT passenger_id, MIN(B.arrival_time) AS bus_time
      FROM Buses AS B,
           Passengers AS P
      WHERE B.arrival_time >= P.arrival_time
      GROUP BY passenger_id) AS temp
         RIGHT JOIN Buses
                    ON temp.bus_time = Buses.arrival_time
GROUP BY bus_id
ORDER BY bus_id ASC

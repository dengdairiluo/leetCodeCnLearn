SELECT first_date                                                          install_dt,
       count(distinct a.player_id)                                         installs,
       round(count(distinct b.player_id) / count(distinct a.player_id), 2) Day1_retention
FROM (SELECT player_id,
             min(event_date) first_date
      FROM activity
      GROUP BY player_id) a
         LEFT JOIN activity b ON a.player_id = b.player_id and DATEDIFF(b.event_date, a.first_date) = 1
GROUP BY first_date
ORDER BY first_date;


# Write your MySQL query statement below

select team_id,
       team_name,
       ifnull(sum(case
                      when host_goals > guest_goals then 3
                      when host_goals = guest_goals then 1
                      else 0 end), 0) as num_points
from (select host_team, host_goals, guest_goals
      from matches
      union all
      select guest_team as host_team, guest_goals as host_goals, host_goals as guest_goals
      from matches) t
         right join teams on t.host_team = teams.team_id
group by 1, 2
order by num_points desc, team_id

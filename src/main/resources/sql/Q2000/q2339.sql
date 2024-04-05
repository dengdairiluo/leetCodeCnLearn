# Write your MySQL query statement below
select t1.team_name as home_team, t2.team_name as away_team
from teams t1,
     teams t2
where t2.team_name != t1.team_name;

# Write your MySQL query statement below
select name,
       mail
from (select user_id
      from (select user_id,
                   contest_id -
                   row_number() over (partition by user_id order by contest_id) diff
            from (select contest_id, gold_medal user_id
                  from contests
                  union all
                  select contest_id, silver_medal user_id
                  from contests
                  union all
                  select contest_id, bronze_medal user_id
                  from contests) temp1) temp2
      group by user_id, diff
      having count(diff) >= 3
      union
      select gold_medal user_id
      from contests
      group by gold_medal
      having count(gold_medal) >= 3) temp3
         join users using (user_id);

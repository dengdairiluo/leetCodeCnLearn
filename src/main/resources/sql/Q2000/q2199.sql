# Write your MySQL query statement below
select post_id, ifnull(group_concat(distinct topic_id order by topic_id), 'Ambiguous!')  as topic
from
    (select post_id, topic_id as topic_id
     from Posts p
              left join Keywords k
                        on lower(content) like concat('% ',word,' %') or content like concat(word,' %') or content like concat('% ',word)) a
group by post_id

select platform,
       experiment_name,
       count(experiment_id) as num_experiments
from (select 'Android' platform union select 'IOS' union select 'Web') t1
         join (select 'Reading' experiment_name union select 'Sports' union select 'Programming') t2
         left join Experiments
                   using (platform, experiment_name)
group by 1, 2
order by 1, 2

# Write your MySQL query statement below

select  Activity.machine_id  ,

-- ,Activity.process_id  ,  a.activity_type, Activity.activity_type,
        round (avg(Activity.timestamp-a.timestamp) ,3) as processing_time


from Activity
         join
     Activity  as  a

     on
                 a.machine_id=Activity.machine_id
             and
                 a.process_id=Activity.process_id
             and
                 a.activity_type='start'

where Activity.activity_type='end'

group by Activity.machine_id


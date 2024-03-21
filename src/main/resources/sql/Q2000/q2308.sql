
# Write your MySQL query statement below


# MySQL中自定义排序


with t1 as(
    select *,
           row_number() over(partition by gender order by user_id asc) as rn
    from Genders
)

select user_id,gender from t1
order by rn asc,
         field(gender,"female","other","male") asc


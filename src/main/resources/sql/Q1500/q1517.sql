# Write your MySQL query statement below
select * from users 
where mail regexp'^[:alpha:]+[[:alnum:]_\\./\\-]*@leetcode\\.com$'

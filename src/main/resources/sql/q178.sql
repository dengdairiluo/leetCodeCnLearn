# Write your MySQL query statement below

select Score, dense_rank() over(order by Score desc) 'Rank'
from Scores

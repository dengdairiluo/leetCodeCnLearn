# Write your MySQL query statement below
select artist,count(artist) as occurrences
from spotify
group by artist
order by count(artist) desc,artist asc


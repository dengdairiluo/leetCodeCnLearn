select distinct b.title
from TVProgram a, Content b
where a.content_id = b.content_id
  AND b.content_type = 'Movies'
  AND a.program_date >= DATE '2020-06-01'
  AND a.program_date < DATE '2020-07-01'
  AND b.kids_content='Y'


# Write your MySQL query statement below
(select name as results
from MovieRating join Users 
using(user_id)
group by name
order by COUNT(*) DESC, name
LIMIT 1)

UNION ALL

(select title AS results
from MovieRating join Movies 
using(movie_id)
where created_at between '2020-02-01' AND '2020-02-29'
group by title
order by AVG(rating) DESC, title
LIMIT 1)
# Write your MySQL query statement below
SELECT count(1) accounts_count
FROM (SELECT account_id
      FROM subscriptions s
      WHERE (s.start_date BETWEEN '2021-01-01' AND '2022-01-01')
         OR (s.end_date BETWEEN '2021-01-01' AND '2022-01-01')) sub
         LEFT JOIN (select account_id from streams where stream_date BETWEEN '2021-01-01' AND '2022-01-01') str
                   ON sub.account_id = str.account_id
WHERE str.account_id is null

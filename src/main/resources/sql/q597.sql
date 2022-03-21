SELECT CASE
           WHEN t.frc = 0 THEN 0.00
           ELSE round((
                          SELECT COUNT(DISTINCT requester_id, accepter_id)
                          FROM RequestAccepted
                      ) / t.frc, 2)
           END AS accept_rate
FROM (
         SELECT COUNT(DISTINCT sender_id, send_to_id) AS frc
         FROM FriendRequest fr
     ) t
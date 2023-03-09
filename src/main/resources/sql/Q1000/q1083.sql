SELECT buyer_id AS 'buyer_id'
FROM Product AS p1
         INNER JOIN Sales AS s1
                    ON p1.product_id = s1.product_id
GROUP BY buyer_id
HAVING COUNT(IF(p1.product_name = 'S8', 1, NULL)) > 0
   AND COUNT(IF(p1.product_name = 'iPhone', 1, NULL)) = 0
;

# Write your MySQL query statement below\
SELECT SELLER_ID
FROM SALES
GROUP BY SELLER_ID
HAVING SUM(PRICE) >= ALL (SELECT SUM(PRICE)
                          FROM SALES
                          GROUP BY SELLER_ID);


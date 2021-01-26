select u.name, sum(amount) balance from transactions t  left join Users u on t.account = u.account group by t.account having balance > 10000;

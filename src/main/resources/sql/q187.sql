CREATE FUNCTION getNthHighestSalary ( N INT ) RETURNS INT BEGIN

    DECLARE m INT;

    SET m = N - 1;

    RETURN ( # Write your MySQL query statement below.

        SELECT ifnull( ( SELECT DISTINCT salary FROM Employee ORDER BY salary DESC LIMIT m, 1 ), NULL ) );

END

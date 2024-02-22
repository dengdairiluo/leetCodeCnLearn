CREATE PROCEDURE UnpivotProducts() #dynamic:动态 unpivoting:取消旋转
BEGIN
    # Write your MySQL query statement below.
    SET group_concat_max_len = 10240;

    SELECT GROUP_CONCAT('SELECT product_id, \'',
                        column_name, '\' AS store, ',
                        column_name,
                        ' AS price FROM Products WHERE ',
                        column_name,
                        ' IS NOT NULL'
                        SEPARATOR ' UNION '
           )
    INTO @sql
    FROM (SELECT column_name
          FROM information_schema.columns
          WHERE table_schema = DATABASE()
            AND table_name = 'Products'
            AND column_name <> 'product_id') t;

    PREPARE statement FROM @sql;
    EXECUTE statement;
END

select warehouse_name, sum(volume) as volume from
    (select w.name as warehouse_name, w.product_id, w.units * Width * Length * Height as volume from Warehouse w left join Products p on w.product_id = p.product_id) t
group by warehouse_name
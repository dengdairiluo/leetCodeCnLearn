select i.invoice_id, c1.customer_name, i.price,
       count(ct.contact_name) contacts_cnt ,
       count(c2.customer_name) trusted_contacts_cnt
from invoices i join customers c1 on i.user_id=c1.customer_id
                left join contacts ct on i.user_id=ct.user_id
                left join customers c2 on ct.contact_email=c2.email
group by i.invoice_id
order by i.invoice_id


select max(purchase_amount),customer_id from orders group by customer_id;


SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;


select max(purchase_amount),order_date,customer_id from orders group by customer_id,order_date having max(purchase_amount) in (2030, 3450, 5760, 6000);
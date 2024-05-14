UPDATE customers
SET customers.user_id = users.id
FROM customers
INNER JOIN users ON customers.email = users.email;

ALTER TABLE customers DROP COLUMN first_name;
ALTER TABLE customers DROP COLUMN last_name;
ALTER TABLE customers DROP COLUMN email;

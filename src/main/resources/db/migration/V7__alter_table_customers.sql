INSERT INTO users (email, password, first_name, last_name, created_at, updated_at)
SELECT email, '', first_name, last_name, GETDATE(), GETDATE()
FROM customers;

ALTER TABLE customers ADD user_id UniqueIdentifier;

ALTER TABLE customers
    ADD CONSTRAINT fk_user_id
    FOREIGN KEY (user_id) REFERENCES users(id);

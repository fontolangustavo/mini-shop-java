CREATE TABLE clients (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    cpf VARCHAR(11),
    email VARCHAR(255),
    phone VARCHAR(15) NULL
);
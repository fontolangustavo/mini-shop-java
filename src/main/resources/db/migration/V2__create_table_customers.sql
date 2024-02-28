CREATE TABLE customers (
    id UniqueIdentifier  PRIMARY KEY default newid(),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    cpf VARCHAR(11),
    email VARCHAR(255),
    phone VARCHAR(15) NULL
);
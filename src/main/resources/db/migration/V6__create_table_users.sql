CREATE TABLE users (
    id UniqueIdentifier PRIMARY KEY default newid(),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    birth_date DATE,
    created_at DATETIME,
    updated_at DATETIME
);

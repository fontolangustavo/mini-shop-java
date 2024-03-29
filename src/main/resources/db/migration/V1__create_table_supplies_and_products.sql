CREATE TABLE suppliers (
    id UniqueIdentifier  PRIMARY KEY default newid(),
    name VARCHAR(100),
    cnpj VARCHAR(14),
    city VARCHAR(100),
    uf VARCHAR(2),
    phone VARCHAR(15),
    email VARCHAR(255),
    contact VARCHAR(255) NULL
);

CREATE TABLE products (
    id UniqueIdentifier  PRIMARY KEY default newid(),
    supplier_id UniqueIdentifier,
    name VARCHAR(100),
    price DECIMAL(6, 2),
    is_discontinued BIT,

  FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);
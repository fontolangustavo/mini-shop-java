CREATE TABLE orders (
    id UniqueIdentifier PRIMARY KEY default newid(),
    customer_id UniqueIdentifier,
    amount DECIMAL(6, 2),
    created_at DATETIME,

    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE order_items (
    id UniqueIdentifier PRIMARY KEY default newid(),
    order_id UniqueIdentifier,
    product_id UniqueIdentifier,
    quantity INT,
    price DECIMAL(6, 2),

    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

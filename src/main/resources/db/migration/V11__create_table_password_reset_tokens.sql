CREATE TABLE password_reset_tokens (
    id UniqueIdentifier PRIMARY KEY default newid(),
    token VARCHAR(100),
    user_id UniqueIdentifier,
    expiry_at datetimeoffset(3) NOT NULL,
    created_at datetimeoffset(3) NOT NULL,
    updated_at datetimeoffset(3) NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255) UNIQUE,
    phone_number varchar(255) UNIQUE,
    password varchar(255) UNIQUE
    );